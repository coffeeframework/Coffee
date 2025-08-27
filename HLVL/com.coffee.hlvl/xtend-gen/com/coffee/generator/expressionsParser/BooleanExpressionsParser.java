package com.coffee.generator.expressionsParser;

import com.coffee.generator.Dialect;
import com.coffee.hlvl.And;
import com.coffee.hlvl.BoolConstant;
import com.coffee.hlvl.Equality;
import com.coffee.hlvl.Iff;
import com.coffee.hlvl.Implies;
import com.coffee.hlvl.Negation;
import com.coffee.hlvl.Or;
import com.coffee.hlvl.Relational;
import com.coffee.hlvl.VariableRef;

/**
 * Parser for boolean expressions
 * @author Angela Villota
 * @version HLVL V1.4
 *  May 2019
 */
@SuppressWarnings("all")
public class BooleanExpressionsParser implements IExpressionsParser {
  /**
   * Tranformation rules
   */
  private IBooleanExpressionsRules rules;
  
  private Dialect dialect;
  
  public BooleanExpressionsParser() {
    BooleanExpressionsRules _booleanExpressionsRules = new BooleanExpressionsRules(this);
    this.rules = _booleanExpressionsRules;
  }
  
  @Override
  public void setDialect(final Dialect dialect) {
    this.dialect = dialect;
  }
  
  @Override
  public CharSequence parse(final Relational exp) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (exp instanceof BoolConstant) {
      _matched=true;
      _switchResult = ((BoolConstant)exp).getValue();
    }
    if (!_matched) {
      if (exp instanceof VariableRef) {
        _matched=true;
        _switchResult = this.rules.getVariable(((VariableRef)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Negation) {
        _matched=true;
        _switchResult = this.rules.getNegation(((Negation)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Iff) {
        _matched=true;
        _switchResult = this.rules.getIff(((Iff)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Implies) {
        _matched=true;
        _switchResult = this.rules.getImplies(((Implies)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Or) {
        _matched=true;
        _switchResult = this.rules.getOr(((Or)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof And) {
        _matched=true;
        _switchResult = this.rules.getAnd(((And)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Equality) {
        _matched=true;
        _switchResult = this.rules.getEquality(((Equality)exp));
      }
    }
    return _switchResult;
  }
}
