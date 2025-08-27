package com.coffee.generator.boolParser;

import com.coffee.generator.Dialect;
import com.coffee.generator.TransformationRules;
import com.coffee.generator.commons.IMiniZincConstants;
import com.coffee.generator.expressionsParser.BooleanExpressionsParser;
import com.coffee.hlvl.BoolConstant;
import com.coffee.hlvl.ConstantDecl;
import com.coffee.hlvl.Declaration;
import com.coffee.hlvl.Decomposition;
import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Group;
import com.coffee.hlvl.Relational;
import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * class implementing the boolean transformation rules for in Benavides2010
 * for obtaining the HLCL representation in the MiniZinc language.
 * This class implements TransformationRules
 * @author Angela Villota
 * @version HLVL V1.4
 * August 2018
 * updated on May 2019
 * modified on July 2019 to comply with the modifications in the syntax method: getDecomposition
 * fixed a bug in the group with cardinality [1,1]
 */
@SuppressWarnings("all")
public class BasicBooleanRules extends TransformationRules implements IMiniZincConstants {
  /**
   * integer variable to produce the identifiers for the variables and constraints
   * in visibility relations
   */
  private int visibilityIdCounter;
  
  private DIMACSRules dimacs;
  
  private BooleanExpressionsParser expressionsParser;
  
  private StringBuilder cnfBuilder;
  
  public BasicBooleanRules(final Dialect dialect) {
    BooleanExpressionsParser _booleanExpressionsParser = new BooleanExpressionsParser();
    this.expressionsParser = _booleanExpressionsParser;
    this.expressionsParser.setDialect(dialect);
    this.visibilityIdCounter = 0;
    StringBuilder _stringBuilder = new StringBuilder();
    this.cnfBuilder = _stringBuilder;
    DIMACSRules _dIMACSRules = new DIMACSRules();
    this.dimacs = _dIMACSRules;
  }
  
  public String getCNF() {
    return this.cnfBuilder.toString();
  }
  
  @Override
  public CharSequence getConstant(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      Declaration _declaration = element.getDeclaration();
      final Relational value = ((ConstantDecl) _declaration).getValue();
      this.cnfBuilder.append(this.dimacs.getElement(element));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.BOOL_DOMAIN);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.COLON);
      _builder.append(" ");
      String _name = element.getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.ASSIGN);
      _builder.append(" ");
      String _value = ((BoolConstant) value).getValue();
      _builder.append(_value);
      _builder.append("  ");
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getElement(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      this.cnfBuilder.append(this.dimacs.getElement(element));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.VAR_DEF);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.BOOL_DOMAIN);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.COLON);
      _builder.append(" ");
      String _name = element.getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getCoreSingle(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      this.cnfBuilder.append(this.dimacs.getCoreSingle(element));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.CONS_DEF);
      _builder.append(" ");
      String _name = element.getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.EQUIV);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.TRUE_ATOM);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getDecomposition(final Decomposition rel, final Map<String, ElmDeclaration> parents) {
    String _xblockexpression = null;
    {
      String out = "";
      EList<ElmDeclaration> _values = rel.getChildren().getValues();
      for (final ElmDeclaration element : _values) {
        {
          parents.put(element.getName(), rel.getParent());
          if (((rel.getMin() == 1) && (rel.getMax() == 1))) {
            String _out = out;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(IMiniZincConstants.CONS_DEF);
            _builder.append(" ");
            String _name = rel.getParent().getName();
            _builder.append(_name);
            _builder.append(" ");
            _builder.append(IMiniZincConstants.IFF);
            _builder.append(" ");
            String _name_1 = element.getName();
            _builder.append(_name_1);
            _builder.append(" ");
            _builder.append(IMiniZincConstants.SEMICOLON);
            _builder.newLineIfNotEmpty();
            out = (_out + _builder);
            this.cnfBuilder.append(this.dimacs.getMandatory(rel.getParent().getName(), element.getName()));
          } else {
            String _out_1 = out;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(IMiniZincConstants.CONS_DEF);
            _builder_1.append(" ");
            String _name_2 = element.getName();
            _builder_1.append(_name_2);
            _builder_1.append(" ");
            _builder_1.append(IMiniZincConstants.IMPLIES_LR);
            _builder_1.append(" ");
            String _name_3 = rel.getParent().getName();
            _builder_1.append(_name_3);
            _builder_1.append(" ");
            _builder_1.append(IMiniZincConstants.SEMICOLON);
            _builder_1.newLineIfNotEmpty();
            out = (_out_1 + _builder_1);
            this.cnfBuilder.append(this.dimacs.getOptional(rel.getParent().getName(), element.getName()));
          }
        }
      }
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getGroup(final Group rel, final Map<String, ElmDeclaration> parents) {
    String _xifexpression = null;
    if (((rel.getMin() == 1) && Objects.equal(rel.getMax().getValue(), "1"))) {
      String _xblockexpression = null;
      {
        this.cnfBuilder.append(this.dimacs.getXor(rel));
        _xblockexpression = this.getXor(rel, parents);
      }
      _xifexpression = _xblockexpression;
    } else {
      String _xblockexpression_1 = null;
      {
        this.cnfBuilder.append(this.dimacs.getOR(rel));
        _xblockexpression_1 = this.getOR(rel, parents);
      }
      _xifexpression = _xblockexpression_1;
    }
    return _xifexpression;
  }
  
  public String getXor(final Group rel, final Map<String, ElmDeclaration> parents) {
    String _xblockexpression = null;
    {
      String out = "";
      EList<ElmDeclaration> _values = rel.getChildren().getValues();
      for (final ElmDeclaration element : _values) {
        {
          parents.put(element.getName(), rel.getParent());
          String _out = out;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(IMiniZincConstants.CONS_DEF);
          _builder.append(" ");
          String _name = element.getName();
          _builder.append(_name);
          _builder.append(" ");
          _builder.append(IMiniZincConstants.IFF);
          _builder.append(" ");
          _builder.append(IMiniZincConstants.OPEN_CALL);
          out = (_out + _builder);
          EList<ElmDeclaration> _values_1 = rel.getChildren().getValues();
          for (final ElmDeclaration inElement : _values_1) {
            String _name_1 = element.getName();
            String _name_2 = inElement.getName();
            boolean _notEquals = (!Objects.equal(_name_1, _name_2));
            if (_notEquals) {
              String _out_1 = out;
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(IMiniZincConstants.NOT);
              _builder_1.append(IMiniZincConstants.OPEN_CALL);
              String _name_3 = inElement.getName();
              _builder_1.append(_name_3);
              _builder_1.append(IMiniZincConstants.CLOSE_CALL);
              _builder_1.append(" ");
              _builder_1.append(IMiniZincConstants.AND);
              _builder_1.append(" ");
              out = (_out_1 + _builder_1);
            }
          }
          String _out_2 = out;
          StringConcatenation _builder_2 = new StringConcatenation();
          String _name_4 = rel.getParent().getName();
          _builder_2.append(_name_4);
          _builder_2.append(IMiniZincConstants.CLOSE_CALL);
          _builder_2.append(" ");
          _builder_2.append(IMiniZincConstants.SEMICOLON);
          _builder_2.newLineIfNotEmpty();
          out = (_out_2 + _builder_2);
        }
      }
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  public String getOR(final Group rel, final Map<String, ElmDeclaration> parents) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.CONS_DEF);
      _builder.append(" ");
      String _name = rel.getParent().getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.IFF);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.OPEN_CALL);
      String out = _builder.toString();
      EList<ElmDeclaration> _values = rel.getChildren().getValues();
      for (final ElmDeclaration element : _values) {
        {
          parents.put(element.getName(), rel.getParent());
          String _out = out;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          String _name_1 = element.getName();
          _builder_1.append(_name_1, " ");
          _builder_1.append(" ");
          _builder_1.append(IMiniZincConstants.OR, " ");
          out = (_out + _builder_1);
        }
      }
      int _length = out.length();
      int _minus = (_length - 2);
      CharSequence _subSequence = out.subSequence(0, _minus);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(IMiniZincConstants.CLOSE_CALL);
      _builder_1.append(" ");
      _builder_1.append(IMiniZincConstants.SEMICOLON);
      _builder_1.newLineIfNotEmpty();
      String _plus = (_subSequence + _builder_1.toString());
      out = _plus;
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getImpliesPair(final ElmDeclaration left, final ElmDeclaration right) {
    CharSequence _xblockexpression = null;
    {
      this.cnfBuilder.append(this.dimacs.getImpliesPair(left, right));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.CONS_DEF);
      _builder.append(" ");
      String _name = left.getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.IMPLIES_LR);
      _builder.append(" ");
      String _name_1 = right.getName();
      _builder.append(_name_1);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getMutexPair(final ElmDeclaration left, final ElmDeclaration right) {
    CharSequence _xblockexpression = null;
    {
      this.cnfBuilder.append(this.dimacs.getMutexPair(left, right));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.CONS_DEF);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.NOT);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.OPEN_CALL);
      String _name = left.getName();
      _builder.append(_name);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.AND);
      _builder.append(" ");
      String _name_1 = right.getName();
      _builder.append(_name_1);
      _builder.append(IMiniZincConstants.CLOSE_CALL);
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getExpression(final Relational exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(IMiniZincConstants.CONS_DEF);
    _builder.append(" ");
    CharSequence _parse = this.expressionsParser.parse(exp);
    _builder.append(_parse);
    _builder.append(IMiniZincConstants.SEMICOLON);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * ===================================================================
   * ===================================================================
   * Methods for DIMACS notation
   */
  public String getHeader() {
    return this.dimacs.getHeader();
  }
  
  public int getNumClauses() {
    return this.dimacs.getNumClauses();
  }
  
  public int getNumVars() {
    return this.dimacs.getNumVars();
  }
}
