package com.coffee.generator.boolParser;

import com.coffee.generator.TransformationRules;
import com.coffee.hlvl.Decomposition;
import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Group;
import com.coffee.hlvl.Relational;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * class implementing the boolean transformation rules for obtaining a DIMACS (cnf) representation
 * This class implements TransformationRules
 * @author Angela Villota
 * @version HLVL V1.4
 * July 2019
 */
@SuppressWarnings("all")
public class DIMACSRules extends TransformationRules {
  /**
   * Strings in the Textual DIMACS format
   */
  private static final String HEADER = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("c");
      _builder.newLine();
      _builder.append("c DIMACS code generated using the Coffee framework");
      _builder.newLine();
      _builder.append("c");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  /**
   * number of clauses in the problem
   */
  protected int numClauses;
  
  /**
   * Map of variables to obtain the numeric Id using the name of
   * the variable as key
   */
  protected Map<String, Integer> variables;
  
  /**
   * Constructor
   */
  public DIMACSRules() {
    this.numClauses = 0;
    HashMap<String, Integer> _hashMap = new HashMap<String, Integer>();
    this.variables = _hashMap;
  }
  
  /**
   * @returns returns the code generated for the
   * header of a CNF file in the DIMACS format
   */
  public String getHeader() {
    return DIMACSRules.HEADER;
  }
  
  @Override
  public CharSequence getCoreSingle(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      this.addNumClauses(1);
      StringConcatenation _builder = new StringConcatenation();
      Integer _get = this.variables.get(element.getName());
      _builder.append(_get);
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
      for (final ElmDeclaration child : _values) {
        {
          parents.put(child.getName(), rel.getParent());
          if (((rel.getMin() == 1) && (rel.getMax() == 1))) {
            this.addNumClauses(2);
            String _out = out;
            StringConcatenation _builder = new StringConcatenation();
            Integer _get = this.variables.get(rel.getParent().getName());
            _builder.append(_get);
            _builder.append(" -");
            Integer _get_1 = this.variables.get(child.getName());
            _builder.append(_get_1);
            _builder.newLineIfNotEmpty();
            _builder.append("-");
            Integer _get_2 = this.variables.get(rel.getParent().getName());
            _builder.append(_get_2);
            _builder.append(" ");
            Integer _get_3 = this.variables.get(child.getName());
            _builder.append(_get_3);
            _builder.newLineIfNotEmpty();
            out = (_out + _builder);
          } else {
            this.addNumClauses(1);
            String _out_1 = out;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("-");
            Integer _get_4 = this.variables.get(child.getName());
            _builder_1.append(_get_4);
            _builder_1.append(" ");
            Integer _get_5 = this.variables.get(rel.getParent().getName());
            _builder_1.append(_get_5);
            _builder_1.newLineIfNotEmpty();
            out = (_out_1 + _builder_1);
          }
        }
      }
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  /**
   * Method to obtain a CNF representation of a mandatory relation
   */
  public CharSequence getMandatory(final String parent, final String child) {
    CharSequence _xblockexpression = null;
    {
      this.addNumClauses(2);
      StringConcatenation _builder = new StringConcatenation();
      Integer _get = this.variables.get(parent);
      _builder.append(_get);
      _builder.append(" -");
      Integer _get_1 = this.variables.get(child);
      _builder.append(_get_1);
      _builder.newLineIfNotEmpty();
      _builder.append("-");
      Integer _get_2 = this.variables.get(parent);
      _builder.append(_get_2);
      _builder.append(" ");
      Integer _get_3 = this.variables.get(child);
      _builder.append(_get_3);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Method to obtain a CNF representation of an optional relation
   */
  public CharSequence getOptional(final String parent, final String child) {
    CharSequence _xblockexpression = null;
    {
      this.addNumClauses(1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-");
      Integer _get = this.variables.get(child);
      _builder.append(_get);
      _builder.append(" ");
      Integer _get_1 = this.variables.get(parent);
      _builder.append(_get_1);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * This method includes the variable name in a variables map to obtain an
   * integer for the DIMACS transformation
   * @param element is a ElmDeclaration
   * @return the empty String, variables are not translated in the DIMCAS code
   */
  @Override
  public CharSequence getElement(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      int _size = this.variables.keySet().size();
      final int id = (_size + 1);
      this.variables.put(element.getName(), Integer.valueOf(id));
      StringConcatenation _builder = new StringConcatenation();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getConstant(final ElmDeclaration element) {
    CharSequence _xblockexpression = null;
    {
      int _size = this.variables.keySet().size();
      final int id = (_size + 1);
      this.variables.put(element.getName(), Integer.valueOf(id));
      StringConcatenation _builder = new StringConcatenation();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getExpression(final Relational rel) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CharSequence getGroup(final Group rel, final Map<String, ElmDeclaration> parents) {
    String _xifexpression = null;
    if (((rel.getMin() == 1) && Objects.equal(rel.getMax().getValue(), "1"))) {
      _xifexpression = this.getXor(rel);
    } else {
      _xifexpression = this.getOR(rel);
    }
    return _xifexpression;
  }
  
  public String getXor(final Group rel) {
    String _xblockexpression = null;
    {
      String out = "";
      EList<ElmDeclaration> _values = rel.getChildren().getValues();
      for (final ElmDeclaration child : _values) {
        {
          int _size = rel.getChildren().getValues().size();
          int _plus = (_size + 1);
          this.addNumClauses(_plus);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("-");
          Integer _get = this.variables.get(rel.getParent().getName());
          _builder.append(_get);
          _builder.append(" ");
          Integer _get_1 = this.variables.get(child.getName());
          _builder.append(_get_1);
          String singleClause = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("-");
          Integer _get_2 = this.variables.get(child.getName());
          _builder_1.append(_get_2);
          _builder_1.append(" ");
          Integer _get_3 = this.variables.get(rel.getParent().getName());
          _builder_1.append(_get_3);
          _builder_1.newLineIfNotEmpty();
          String clauses = _builder_1.toString();
          EList<ElmDeclaration> _values_1 = rel.getChildren().getValues();
          for (final ElmDeclaration inChild : _values_1) {
            String _name = child.getName();
            String _name_1 = inChild.getName();
            boolean _equals = Objects.equal(_name, _name_1);
            boolean _not = (!_equals);
            if (_not) {
              String _singleClause = singleClause;
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append(" ");
              Integer _get_4 = this.variables.get(inChild.getName());
              _builder_2.append(_get_4, " ");
              singleClause = (_singleClause + _builder_2);
              String _clauses = clauses;
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("-");
              Integer _get_5 = this.variables.get(child.getName());
              _builder_3.append(_get_5);
              _builder_3.append(" -");
              Integer _get_6 = this.variables.get(inChild.getName());
              _builder_3.append(_get_6);
              _builder_3.newLineIfNotEmpty();
              clauses = (_clauses + _builder_3);
            }
          }
          String _out = out;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(singleClause);
          _builder_4.newLineIfNotEmpty();
          _builder_4.append(clauses);
          _builder_4.newLineIfNotEmpty();
          out = (_out + _builder_4);
        }
      }
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
  
  public String getOR(final Group rel) {
    String output = "";
    int _size = rel.getChildren().getValues().size();
    int _plus = (_size + 1);
    this.addNumClauses(_plus);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-");
    Integer _get = this.variables.get(rel.getParent().getName());
    _builder.append(_get);
    String singleClause = _builder.toString();
    String clauses = "";
    EList<ElmDeclaration> _values = rel.getChildren().getValues();
    for (final ElmDeclaration child : _values) {
      {
        String _singleClause = singleClause;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(" ");
        Integer _get_1 = this.variables.get(child.getName());
        _builder_1.append(_get_1, " ");
        singleClause = (_singleClause + _builder_1);
        String _clauses = clauses;
        StringConcatenation _builder_2 = new StringConcatenation();
        Integer _get_2 = this.variables.get(rel.getParent().getName());
        _builder_2.append(_get_2);
        _builder_2.append(" -");
        Integer _get_3 = this.variables.get(child.getName());
        _builder_2.append(_get_3);
        _builder_2.newLineIfNotEmpty();
        clauses = (_clauses + _builder_2);
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(singleClause);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append(clauses);
    _builder_1.newLineIfNotEmpty();
    output = _builder_1.toString();
    return output;
  }
  
  @Override
  public CharSequence getImpliesPair(final ElmDeclaration left, final ElmDeclaration right) {
    CharSequence _xblockexpression = null;
    {
      this.addNumClauses(1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-");
      Integer _get = this.variables.get(left.getName());
      _builder.append(_get);
      _builder.append(" ");
      Integer _get_1 = this.variables.get(right.getName());
      _builder.append(_get_1);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence getMutexPair(final ElmDeclaration left, final ElmDeclaration right) {
    CharSequence _xblockexpression = null;
    {
      this.addNumClauses(1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("-");
      Integer _get = this.variables.get(left.getName());
      _builder.append(_get);
      _builder.append(" -");
      Integer _get_1 = this.variables.get(right.getName());
      _builder.append(_get_1);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Increased the count of clauses by the number in amount
   * @param number of clauses to add
   */
  public void addNumClauses(final int amount) {
    int _numClauses = this.numClauses;
    this.numClauses = (_numClauses + amount);
  }
  
  /**
   * @return returns the number of variables in the problem
   */
  public int getNumVars() {
    return this.variables.keySet().size();
  }
  
  /**
   * @return returns the number of generated clauses
   */
  public int getNumClauses() {
    return this.numClauses;
  }
}
