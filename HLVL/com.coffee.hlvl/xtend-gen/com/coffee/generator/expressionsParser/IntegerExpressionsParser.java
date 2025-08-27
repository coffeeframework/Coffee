package com.coffee.generator.expressionsParser;

import com.coffee.generator.Dialect;
import com.coffee.hlvl.And;
import com.coffee.hlvl.BinaryFunction;
import com.coffee.hlvl.BoolConstant;
import com.coffee.hlvl.Comparison;
import com.coffee.hlvl.Equality;
import com.coffee.hlvl.Iff;
import com.coffee.hlvl.Implies;
import com.coffee.hlvl.IntConstant;
import com.coffee.hlvl.Minus;
import com.coffee.hlvl.MulOrDiv;
import com.coffee.hlvl.Negation;
import com.coffee.hlvl.Or;
import com.coffee.hlvl.Plus;
import com.coffee.hlvl.Relational;
import com.coffee.hlvl.SymbolConstant;
import com.coffee.hlvl.UnaryFunction;
import com.coffee.hlvl.VariableRef;
import java.util.Map;

/**
 * Parser for boolean expressions
 * @author Angela Villota
 * @version HLVL V1.4
 *  July 2019
 */
@SuppressWarnings("all")
public class IntegerExpressionsParser extends BooleanExpressionsParser implements IExpressionsParser {
  /**
   * Tranformation rules
   */
  private IntegerExpressionsRules rules;
  
  private Dialect dialect;
  
  private Map<String, Integer> symbolsMap;
  
  public IntegerExpressionsParser(final Map<String, Integer> map, final Dialect dialect) {
    this.symbolsMap = map;
    this.dialect = dialect;
    IntegerExpressionsRules _integerExpressionsRules = new IntegerExpressionsRules(this, dialect);
    this.rules = _integerExpressionsRules;
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
      if (exp instanceof IntConstant) {
        _matched=true;
        _switchResult = Integer.valueOf(((IntConstant)exp).getValue()).toString();
      }
    }
    if (!_matched) {
      if (exp instanceof SymbolConstant) {
        _matched=true;
        _switchResult = this.symbolsMap.get(((SymbolConstant)exp).getValue()).toString();
      }
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
    if (!_matched) {
      if (exp instanceof Comparison) {
        _matched=true;
        _switchResult = this.rules.getComparison(((Comparison)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Plus) {
        _matched=true;
        _switchResult = this.rules.getPlus(((Plus)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof Minus) {
        _matched=true;
        _switchResult = this.rules.getMinus(((Minus)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof MulOrDiv) {
        _matched=true;
        _switchResult = this.rules.getMulOrDiv(((MulOrDiv)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof UnaryFunction) {
        _matched=true;
        _switchResult = this.rules.getUnaryFunction(((UnaryFunction)exp));
      }
    }
    if (!_matched) {
      if (exp instanceof BinaryFunction) {
        _matched=true;
        _switchResult = this.rules.getBinaryFunction(((BinaryFunction)exp));
      }
    }
    return _switchResult;
  }
}
