package com.coffee.generator.integerParser;

import com.coffee.generator.Dialect;
import com.coffee.hlvl.ElmDeclaration;

@SuppressWarnings("all")
public class AttributesTranformationRules extends BasicIntegerRules implements IAttributesRules {
  public AttributesTranformationRules(final Dialect dialect) {
    super(dialect);
  }
  
  @Override
  public CharSequence getDecompositionAtt(final ElmDeclaration parent, final ElmDeclaration attribute) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
