package com.coffee.generator.expressionsParser;

import com.coffee.generator.Dialect;
import com.coffee.generator.commons.IMiniZincConstants;
import com.coffee.hlvl.BinaryFunction;
import com.coffee.hlvl.Comparison;
import com.coffee.hlvl.Equality;
import com.coffee.hlvl.Minus;
import com.coffee.hlvl.MulOrDiv;
import com.coffee.hlvl.Plus;
import com.coffee.hlvl.UnaryFunction;
import com.coffee.hlvl.VariableRef;
import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Implementation of boolean rules
 * @author Angela Villota
 * @version HLVL V1.4
 *  May 2019
 */
@SuppressWarnings("all")
public class IntegerExpressionsRules extends BooleanExpressionsRules implements IIntegerExpressionsRules, IMiniZincConstants {
  private IExpressionsParser parser;
  
  private Dialect dialect;
  
  public IntegerExpressionsRules(final IExpressionsParser parser, final Dialect dialect) {
    super(parser);
    this.parser = parser;
    this.dialect = dialect;
  }
  
  @Override
  public CharSequence getVariable(final VariableRef exp) {
    if ((Objects.equal(exp.getVariable().getDataType(), "boolean") && ((Objects.equal(this.dialect, Dialect.BASIC_INT) || 
      Objects.equal(this.dialect, Dialect.ATTRIBUTE)) || 
      Objects.equal(this.dialect, Dialect.MULTIPLICITY)))) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = exp.getVariable().getName();
      _builder.append(_name);
      _builder.append(" > 0");
      return _builder;
    } else {
      return exp.getVariable().getName();
    }
  }
  
  @Override
  public CharSequence getComparison(final Comparison exp) {
    CharSequence _xifexpression = null;
    String _op = exp.getOp();
    boolean _equals = Objects.equal(_op, ">=");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      CharSequence _parse = this.parser.parse(exp.getLeft());
      _builder.append(_parse);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.GEQ);
      _builder.append(" ");
      CharSequence _parse_1 = this.parser.parse(exp.getRight());
      _builder.append(_parse_1);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      String _op_1 = exp.getOp();
      boolean _equals_1 = Objects.equal(_op_1, "<=");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        CharSequence _parse_2 = this.parser.parse(exp.getLeft());
        _builder_1.append(_parse_2);
        _builder_1.append(" ");
        _builder_1.append(IMiniZincConstants.LEQ);
        _builder_1.append(" ");
        CharSequence _parse_3 = this.parser.parse(exp.getRight());
        _builder_1.append(_parse_3);
        _builder_1.append(")");
        _xifexpression_1 = _builder_1;
      } else {
        CharSequence _xifexpression_2 = null;
        String _op_2 = exp.getOp();
        boolean _equals_2 = Objects.equal(_op_2, ">");
        if (_equals_2) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("(");
          CharSequence _parse_4 = this.parser.parse(exp.getLeft());
          _builder_2.append(_parse_4);
          _builder_2.append(" ");
          _builder_2.append(IMiniZincConstants.GT);
          _builder_2.append(" ");
          CharSequence _parse_5 = this.parser.parse(exp.getRight());
          _builder_2.append(_parse_5);
          _builder_2.append(")");
          _xifexpression_2 = _builder_2;
        } else {
          CharSequence _xifexpression_3 = null;
          String _op_3 = exp.getOp();
          boolean _equals_3 = Objects.equal(_op_3, "<");
          if (_equals_3) {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("(");
            CharSequence _parse_6 = this.parser.parse(exp.getLeft());
            _builder_3.append(_parse_6);
            _builder_3.append(" ");
            _builder_3.append(IMiniZincConstants.LT);
            _builder_3.append(" ");
            CharSequence _parse_7 = this.parser.parse(exp.getRight());
            _builder_3.append(_parse_7);
            _builder_3.append(")");
            _xifexpression_3 = _builder_3;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public CharSequence getMinus(final Minus exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append(" ");
    _builder.append(IMiniZincConstants.MINUS);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getMulOrDiv(final MulOrDiv exp) {
    CharSequence _xifexpression = null;
    String _op = exp.getOp();
    boolean _equals = Objects.equal(_op, "*");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("( ");
      CharSequence _parse = this.parser.parse(exp.getLeft());
      _builder.append(_parse);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.TIMES);
      _builder.append(" ");
      CharSequence _parse_1 = this.parser.parse(exp.getRight());
      _builder.append(_parse_1);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      String _op_1 = exp.getOp();
      boolean _equals_1 = Objects.equal(_op_1, "/");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("( ");
        CharSequence _parse_2 = this.parser.parse(exp.getLeft());
        _builder_1.append(_parse_2);
        _builder_1.append(" ");
        _builder_1.append(IMiniZincConstants.DIV);
        _builder_1.append(" ");
        CharSequence _parse_3 = this.parser.parse(exp.getRight());
        _builder_1.append(_parse_3);
        _builder_1.append(")");
        _xifexpression_1 = _builder_1;
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("( ");
        CharSequence _parse_4 = this.parser.parse(exp.getLeft());
        _builder_2.append(_parse_4);
        _builder_2.append(" ");
        _builder_2.append(IMiniZincConstants.MOD);
        _builder_2.append(" ");
        CharSequence _parse_5 = this.parser.parse(exp.getRight());
        _builder_2.append(_parse_5);
        _builder_2.append(")");
        _xifexpression_1 = _builder_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public CharSequence getPlus(final Plus exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append(" ");
    _builder.append(IMiniZincConstants.PLUS);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getUnaryFunction(final UnaryFunction exp) {
    CharSequence _xifexpression = null;
    String _op = exp.getOp();
    boolean _equals = Objects.equal(_op, "abs");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.ABSOLUTE_VALUE);
      _builder.append("(");
      CharSequence _parse = this.parser.parse(exp.getExpression());
      _builder.append(_parse);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      String _op_1 = exp.getOp();
      boolean _equals_1 = Objects.equal(_op_1, "sqrt");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(IMiniZincConstants.SQUARE_ROOT);
        _builder_1.append("(");
        CharSequence _parse_1 = this.parser.parse(exp.getExpression());
        _builder_1.append(_parse_1);
        _builder_1.append(")");
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public CharSequence getBinaryFunction(final BinaryFunction exp) {
    CharSequence _xifexpression = null;
    String _op = exp.getOp();
    boolean _equals = Objects.equal(_op, "pow");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(IMiniZincConstants.MIN);
      _builder.append("(");
      CharSequence _parse = this.parser.parse(exp.getLeft());
      _builder.append(_parse);
      _builder.append(" ");
      _builder.append(IMiniZincConstants.COMMA);
      _builder.append(" ");
      CharSequence _parse_1 = this.parser.parse(exp.getRight());
      _builder.append(_parse_1);
      _builder.append(")");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      String _op_1 = exp.getOp();
      boolean _equals_1 = Objects.equal(_op_1, "min");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(IMiniZincConstants.MAX);
        _builder_1.append("(");
        CharSequence _parse_2 = this.parser.parse(exp.getLeft());
        _builder_1.append(_parse_2);
        _builder_1.append(" ");
        _builder_1.append(IMiniZincConstants.COMMA);
        _builder_1.append(" ");
        CharSequence _parse_3 = this.parser.parse(exp.getRight());
        _builder_1.append(_parse_3);
        _builder_1.append(")");
        _xifexpression_1 = _builder_1;
      } else {
        CharSequence _xifexpression_2 = null;
        String _op_2 = exp.getOp();
        boolean _equals_2 = Objects.equal(_op_2, "max");
        if (_equals_2) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(IMiniZincConstants.POWER);
          _builder_2.append("(");
          CharSequence _parse_4 = this.parser.parse(exp.getLeft());
          _builder_2.append(_parse_4);
          _builder_2.append(" ");
          _builder_2.append(IMiniZincConstants.COMMA);
          _builder_2.append(" ");
          CharSequence _parse_5 = this.parser.parse(exp.getRight());
          _builder_2.append(_parse_5);
          _builder_2.append(")");
          _xifexpression_2 = _builder_2;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public CharSequence getEquality(final Equality exp) {
    String _xblockexpression = null;
    {
      String out = "";
      String _op = exp.getOp();
      boolean _equals = Objects.equal(_op, "!=");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        CharSequence _parse = this.parser.parse(exp.getLeft());
        _builder.append(_parse);
        _builder.append(" ");
        _builder.append(IMiniZincConstants.NEQUIV);
        _builder.append(" ");
        CharSequence _parse_1 = this.parser.parse(exp.getRight());
        _builder.append(_parse_1);
        _builder.append(")");
        out = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        CharSequence _parse_2 = this.parser.parse(exp.getLeft());
        _builder_1.append(_parse_2);
        _builder_1.append(" ");
        _builder_1.append(IMiniZincConstants.EQUIV);
        _builder_1.append(" ");
        CharSequence _parse_3 = this.parser.parse(exp.getRight());
        _builder_1.append(_parse_3);
        _builder_1.append(")");
        out = _builder_1.toString();
      }
      _xblockexpression = out;
    }
    return _xblockexpression;
  }
}
