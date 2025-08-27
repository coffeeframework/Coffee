package com.coffee.generator.boolParser;

import com.coffee.generator.AbstractHLVLParser;
import com.coffee.generator.Dialect;
import com.coffee.generator.TransformationRules;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class BasicBoolParser extends AbstractHLVLParser {
  public BasicBoolParser(final String name, final Dialect dialect) {
    super(name, dialect);
    BasicBooleanRules _basicBooleanRules = new BasicBooleanRules(dialect);
    this.setTransformationRules(_basicBooleanRules);
  }
  
  public String getCNF() {
    String _xblockexpression = null;
    {
      TransformationRules _transformationRules = this.getTransformationRules();
      BasicBooleanRules rules = ((BasicBooleanRules) _transformationRules);
      String program = rules.getHeader();
      String _program = program;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("p cnf ");
      int _numClauses = rules.getNumClauses();
      _builder.append(_numClauses);
      _builder.append(" ");
      int _numVars = rules.getNumVars();
      _builder.append(_numVars);
      _builder.newLineIfNotEmpty();
      String _cNF = rules.getCNF();
      _builder.append(_cNF);
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      program = (_program + _builder);
      _xblockexpression = program;
    }
    return _xblockexpression;
  }
}
