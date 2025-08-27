package com.coffee.generator.integerParser;

import com.coffee.generator.ComplexTransformationRules;
import com.coffee.generator.Dialect;
import com.coffee.generator.commons.IMiniZincConstants;
import com.coffee.hlvl.ComplexImplies;
import com.coffee.hlvl.ComplexMutex;
import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Visibility;
import java.util.List;
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
public class ComplexIntegerRules extends BasicIntegerRules implements IMiniZincConstants, ComplexTransformationRules {
  /**
   * integer variable to produce the identifiers for the variables and constraints
   * in visibility relations
   */
  private int visibilityIdCounter;
  
  public ComplexIntegerRules(final Dialect dialect) {
    super(dialect);
    this.visibilityIdCounter = 0;
  }
  
  @Override
  public CharSequence getVisibility(final Visibility rel, final List<CharSequence> relations) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var bool: B");
      _builder.append(this.visibilityIdCounter);
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      _builder.append("constraint ");
      CharSequence _parse = this.expressionsParser.parse(rel.getCondition());
      _builder.append(_parse);
      _builder.append(" -> B");
      _builder.append(this.visibilityIdCounter);
      _builder.append(IMiniZincConstants.SEMICOLON);
      _builder.newLineIfNotEmpty();
      String out = _builder.toString();
      for (final CharSequence r : relations) {
        String _out = out;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("constraint B");
        _builder_1.append(this.visibilityIdCounter);
        _builder_1.append("  <-> ");
        CharSequence _subSequence = r.subSequence(10, r.length());
        _builder_1.append(_subSequence);
        _builder_1.newLineIfNotEmpty();
        out = (_out + _builder_1);
      }
      this.visibilityIdCounter++;
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getComplexImplies(final ComplexImplies rel) {
    String _xblockexpression = null;
    {
      StringBuilder out = new StringBuilder();
      EList<ElmDeclaration> _values = rel.getElements().getValues();
      for (final ElmDeclaration element : _values) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(IMiniZincConstants.CONS_DEF);
        _builder.append(" ");
        CharSequence _parse = this.expressionsParser.parse(rel.getExp());
        _builder.append(_parse);
        _builder.append(" ");
        _builder.append(IMiniZincConstants.IMPLIES_LR);
        _builder.append(" ");
        String _name = element.getName();
        _builder.append(_name);
        _builder.append(IMiniZincConstants.SEMICOLON);
        _builder.newLineIfNotEmpty();
        out.append(_builder);
      }
      _xblockexpression = out.toString();
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getComplexMutex(final ComplexMutex rel) {
    String _xblockexpression = null;
    {
      StringBuilder out = new StringBuilder();
      EList<ElmDeclaration> _values = rel.getElements().getValues();
      for (final ElmDeclaration element : _values) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(IMiniZincConstants.CONS_DEF);
        _builder.append(" ");
        _builder.append(IMiniZincConstants.NOT);
        _builder.append("(");
        CharSequence _parse = this.expressionsParser.parse(rel.getExp());
        _builder.append(_parse);
        _builder.append(" ");
        _builder.append(IMiniZincConstants.AND);
        _builder.append(" ");
        String _name = element.getName();
        _builder.append(_name);
        _builder.append(")");
        _builder.append(IMiniZincConstants.SEMICOLON);
        _builder.newLineIfNotEmpty();
        out.append(_builder);
      }
      _xblockexpression = out.toString();
    }
    return _xblockexpression;
  }
}
