package com.coffee.generator.expressionsParser;

import com.coffee.generator.commons.IMiniZincConstants;
import com.coffee.hlvl.And;
import com.coffee.hlvl.Equality;
import com.coffee.hlvl.Iff;
import com.coffee.hlvl.Implies;
import com.coffee.hlvl.Negation;
import com.coffee.hlvl.Or;
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
public class BooleanExpressionsRules implements IBooleanExpressionsRules, IMiniZincConstants {
  private IExpressionsParser parser;
  
  public BooleanExpressionsRules(final IExpressionsParser parser) {
    this.parser = parser;
  }
  
  @Override
  public CharSequence getAnd(final And exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append(" ");
    _builder.append(IMiniZincConstants.AND);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getIff(final Iff exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append("  ");
    _builder.append(IMiniZincConstants.IFF);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getImplies(final Implies exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append("  ");
    _builder.append(IMiniZincConstants.IMPLIES_LR);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getNegation(final Negation exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(IMiniZincConstants.NOT);
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getExpression());
    _builder.append(_parse);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getOr(final Or exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _parse = this.parser.parse(exp.getLeft());
    _builder.append(_parse);
    _builder.append(" ");
    _builder.append(IMiniZincConstants.OR);
    _builder.append(" ");
    CharSequence _parse_1 = this.parser.parse(exp.getRight());
    _builder.append(_parse_1);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  public CharSequence getVariable(final VariableRef exp) {
    return exp.getVariable().getName();
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
