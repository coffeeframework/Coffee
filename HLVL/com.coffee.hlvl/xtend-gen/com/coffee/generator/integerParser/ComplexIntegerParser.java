package com.coffee.generator.integerParser;

import com.coffee.generator.AbstractHLVLParser;
import com.coffee.generator.Dialect;
import com.coffee.generator.TransformationRules;
import com.coffee.hlvl.Common;
import com.coffee.hlvl.ComplexImplies;
import com.coffee.hlvl.ComplexMutex;
import com.coffee.hlvl.Constraint;
import com.coffee.hlvl.Decomposition;
import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Group;
import com.coffee.hlvl.NamedItem;
import com.coffee.hlvl.Pair;
import com.coffee.hlvl.RelDeclaration;
import com.coffee.hlvl.Relation;
import com.coffee.hlvl.VarList;
import com.coffee.hlvl.Visibility;
import com.google.common.base.Objects;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ComplexIntegerParser extends AbstractHLVLParser {
  public ComplexIntegerParser(final String name, final Dialect dialect) {
    super(name, dialect);
    ComplexIntegerRules _complexIntegerRules = new ComplexIntegerRules(dialect);
    this.setTransformationRules(_complexIntegerRules);
  }
  
  /**
   * This method parses a variability relation individually.
   * First, the type of variability relation is determined, then a call to the transfromationRules object
   * is performed to transform each variability relation into a set of constraints considering the type of problem.
   * @param rel is a variability relation
   */
  @Override
  public CharSequence parseRelation(final Relation rel) {
    CharSequence _xblockexpression = null;
    {
      TransformationRules _transformationRules = this.getTransformationRules();
      ComplexIntegerRules rules = ((ComplexIntegerRules) _transformationRules);
      CharSequence _switchResult = null;
      boolean _matched = false;
      if (rel instanceof Common) {
        _matched=true;
        _switchResult = rules.getCore(((Common)rel));
      }
      if (!_matched) {
        if (rel instanceof Decomposition) {
          _matched=true;
          _switchResult = rules.getDecomposition(((Decomposition)rel), this.getParents());
        }
      }
      if (!_matched) {
        if (rel instanceof Group) {
          _matched=true;
          _switchResult = rules.getGroup(((Group)rel), this.getParents());
        }
      }
      if (!_matched) {
        if (rel instanceof Pair) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            final Pair pair = ((Pair) rel);
            CharSequence _xifexpression = null;
            String _operator = pair.getOperator();
            boolean _equals = Objects.equal(_operator, "implies");
            if (_equals) {
              _xifexpression = rules.getImpliesPair(((Pair)rel).getVar1(), ((Pair)rel).getVar2());
            } else {
              _xifexpression = rules.getMutexPair(((Pair)rel).getVar1(), ((Pair)rel).getVar2());
            }
            _xblockexpression_1 = _xifexpression;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (rel instanceof VarList) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            final VarList pair = ((VarList) rel);
            CharSequence _xifexpression = null;
            String _operator = pair.getOperator();
            boolean _equals = Objects.equal(_operator, "implies");
            if (_equals) {
              _xifexpression = rules.getImpliesList(((VarList)rel));
            } else {
              _xifexpression = rules.getMutexList(((VarList)rel));
            }
            _xblockexpression_1 = _xifexpression;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (rel instanceof Constraint) {
          _matched=true;
          _switchResult = rules.getExpression(((Constraint)rel).getExp());
        }
      }
      if (!_matched) {
        if (rel instanceof Visibility) {
          _matched=true;
          CharSequence _xblockexpression_1 = null;
          {
            ArrayList<CharSequence> relations = new ArrayList<CharSequence>();
            EList<NamedItem> _ids = ((Visibility)rel).getList().getIds();
            for (final NamedItem r : _ids) {
              boolean _matched_1 = false;
              if (r instanceof ElmDeclaration) {
                _matched_1=true;
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("% a visibility rule n.y.i.");
                relations.add(_builder);
              }
              if (!_matched_1) {
                if (r instanceof RelDeclaration) {
                  _matched_1=true;
                  relations.add(this.parseRelation(((RelDeclaration)r).getExp()));
                }
              }
            }
            _xblockexpression_1 = rules.getVisibility(((Visibility)rel), relations);
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (rel instanceof ComplexImplies) {
          _matched=true;
          _switchResult = rules.getComplexImplies(((ComplexImplies)rel));
        }
      }
      if (!_matched) {
        if (rel instanceof ComplexMutex) {
          _matched=true;
          _switchResult = rules.getComplexMutex(((ComplexMutex)rel));
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
