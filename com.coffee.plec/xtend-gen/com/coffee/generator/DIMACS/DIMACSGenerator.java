package com.coffee.generator.DIMACS;

import com.coffee.generator.AbstractGenerator;
import com.coffee.generator.DIMACS.DIMACSFactory;
import com.coffee.generator.TypeOfProblem;
import com.coffee.pLEC.Attributes;
import com.coffee.pLEC.ConsExpression;
import com.coffee.pLEC.Model;
import com.coffee.pLEC.Rule;
import com.coffee.pLEC.VarDeclaration;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Code generator for parsing from the PLEC language to the DIMACS format
 * This class implements the Generator interface
 * @author Angela Villota
 * @version PLEC V3
 * September 2018
 */
@SuppressWarnings("all")
public class DIMACSGenerator extends AbstractGenerator {
  /**
   * object to obtain the constraints regarding the type of the problem
   */
  private DIMACSFactory factory;
  
  /**
   * number of clauses in the problem
   */
  protected int numClauses;
  
  /**
   * Constructor method
   * @param the name of the model
   */
  public DIMACSGenerator(final String name, final TypeOfProblem type) {
    super(name, type);
    DIMACSFactory _dIMACSFactory = new DIMACSFactory();
    this.factory = _dIMACSFactory;
    this.setFactory(this.factory);
  }
  
  @Override
  public CharSequence parseModel(final Model model) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("c");
      _builder.newLine();
      _builder.append("c DIMACS code generated using the Coffee framework");
      _builder.newLine();
      _builder.append("c");
      _builder.newLine();
      String program = _builder.toString();
      this.parseVariables(model);
      CharSequence clauses = this.parseConstraints(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("p cnf ");
      int _numClauses = this.factory.getNumClauses();
      _builder_1.append(_numClauses);
      _builder_1.append(" ");
      int _numVars = this.factory.getNumVars();
      _builder_1.append(_numVars);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append(clauses);
      _builder_1.append(" ");
      _builder_1.newLineIfNotEmpty();
      program = _builder_1.toString();
      _xblockexpression = program;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence parseRule(final Rule rule) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CharSequence parseAttributes(final Attributes exp) {
    throw new UnsupportedOperationException("Error: no attributes should be included");
  }
  
  @Override
  public CharSequence putAutogeneratedCons() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  /**
   * This method traverses the list of variables to parse each declaration
   * The declaration is made by the factory
   * @param model
   */
  @Override
  public CharSequence parseVariables(final Model model) {
    CharSequence _xblockexpression = null;
    {
      EList<VarDeclaration> _vars = model.getVars();
      for (final VarDeclaration variable : _vars) {
        this.factory.getVariable(variable);
      }
      StringConcatenation _builder = new StringConcatenation();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Override
  public CharSequence parseConstraint(final String id, final ConsExpression exp) {
    return this.parseExpression(exp);
  }
}