package com.coffee.generator.integerParser;

import com.coffee.generator.AbstractHLVLParser;
import com.coffee.generator.Dialect;

@SuppressWarnings("all")
public class BasicIntegerParser extends AbstractHLVLParser {
  public BasicIntegerParser(final String name, final Dialect dialect) {
    super(name, dialect);
    BasicIntegerRules _basicIntegerRules = new BasicIntegerRules(dialect);
    this.setTransformationRules(_basicIntegerRules);
  }
}
