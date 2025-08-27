package com.coffee.generator.integerParser;

import com.coffee.generator.Dialect;
import com.coffee.generator.TransformationRules;
import com.coffee.hlvl.ConstantDecl;
import com.coffee.hlvl.Declaration;
import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Model;
import com.coffee.hlvl.Relational;
import com.coffee.hlvl.VariableDecl;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;

@SuppressWarnings("all")
public class AttributesParser extends ComplexIntegerParser {
  private Map<String, ElmDeclaration> attributes;
  
  public AttributesParser(final String name, final Dialect dialect) {
    super(name, dialect);
    ComplexIntegerRules _complexIntegerRules = new ComplexIntegerRules(dialect);
    this.setTransformationRules(_complexIntegerRules);
    HashMap<String, ElmDeclaration> _hashMap = new HashMap<String, ElmDeclaration>();
    this.attributes = _hashMap;
  }
  
  /**
   * This method traverses the collection of elements to produce a block of code containing the
   * declaration of the elements represented as variables in the minizinc language
   *  The code for translating an element declaration and relation is produced by an object called rule containing the
   * transformation rules.
   * @param model
   */
  @Override
  public CharSequence parseElements(final Model model) {
    String _xblockexpression = null;
    {
      StringBuilder builder = new StringBuilder();
      TransformationRules rules = this.getTransformationRules();
      EList<ElmDeclaration> _elements = model.getElements();
      for (final ElmDeclaration element : _elements) {
        if (((element.getAtt() != null) && Objects.equal(element.getAtt(), "att"))) {
          this.attributes.put(element.getName(), element);
        } else {
          Declaration _declaration = element.getDeclaration();
          if ((_declaration instanceof ConstantDecl)) {
            Declaration _declaration_1 = element.getDeclaration();
            final Relational value = ((ConstantDecl) _declaration_1).getValue();
            if ((Objects.equal(element.getDataType(), "boolean") && (value == null))) {
              builder.append(rules.getElement(element));
            } else {
              builder.append(rules.getConstant(element));
            }
          } else {
            Declaration _declaration_2 = element.getDeclaration();
            if ((_declaration_2 instanceof VariableDecl)) {
              builder.append(rules.getElement(element));
            }
          }
        }
      }
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}
