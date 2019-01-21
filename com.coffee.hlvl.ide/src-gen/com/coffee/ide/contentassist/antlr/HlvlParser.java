/*
 * generated by Xtext 2.12.0
 */
package com.coffee.ide.contentassist.antlr;

import com.coffee.ide.contentassist.antlr.internal.InternalHlvlParser;
import com.coffee.services.HlvlGrammarAccess;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class HlvlParser extends AbstractContentAssistParser {

	@Inject
	private HlvlGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalHlvlParser createParser() {
		InternalHlvlParser result = new InternalHlvlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDeclarationAccess().getAlternatives(), "rule__Declaration__Alternatives");
					put(grammarAccess.getOptionsDeclarationAccess().getAlternatives(), "rule__OptionsDeclaration__Alternatives");
					put(grammarAccess.getRelationAccess().getAlternatives(), "rule__Relation__Alternatives");
					put(grammarAccess.getPairAccess().getOperatorAlternatives_0_0(), "rule__Pair__OperatorAlternatives_0_0");
					put(grammarAccess.getVarListAccess().getOperatorAlternatives_0_0(), "rule__VarList__OperatorAlternatives_0_0");
					put(grammarAccess.getHierarchyAccess().getAlternatives(), "rule__Hierarchy__Alternatives");
					put(grammarAccess.getOrderAccess().getAlternatives(), "rule__Order__Alternatives");
					put(grammarAccess.getConsExpressionAccess().getAlternatives(), "rule__ConsExpression__Alternatives");
					put(grammarAccess.getEqualityAccess().getOpAlternatives_1_1_0(), "rule__Equality__OpAlternatives_1_1_0");
					put(grammarAccess.getComparisonAccess().getOpAlternatives_1_1_0(), "rule__Comparison__OpAlternatives_1_1_0");
					put(grammarAccess.getPlusOrMinusAccess().getAlternatives_1_0(), "rule__PlusOrMinus__Alternatives_1_0");
					put(grammarAccess.getMulOrDivAccess().getOpAlternatives_1_1_0(), "rule__MulOrDiv__OpAlternatives_1_1_0");
					put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
					put(grammarAccess.getAtomicAccess().getAlternatives(), "rule__Atomic__Alternatives");
					put(grammarAccess.getAtomicAccess().getValueAlternatives_0_1_0(), "rule__Atomic__ValueAlternatives_0_1_0");
					put(grammarAccess.getBoolValAccess().getValueAlternatives_0(), "rule__BoolVal__ValueAlternatives_0");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getNonEnumerableValueAccess().getAlternatives(), "rule__NonEnumerableValue__Alternatives");
					put(grammarAccess.getDataTypeAccess().getAlternatives(), "rule__DataType__Alternatives");
					put(grammarAccess.getGlobalOpAccess().getAlternatives(), "rule__GlobalOp__Alternatives");
					put(grammarAccess.getFunctionOpAccess().getAlternatives(), "rule__FunctionOp__Alternatives");
					put(grammarAccess.getUnaryOpAccess().getAlternatives(), "rule__UnaryOp__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getModelAccess().getGroup_6(), "rule__Model__Group_6__0");
					put(grammarAccess.getElmDeclarationAccess().getGroup(), "rule__ElmDeclaration__Group__0");
					put(grammarAccess.getConstantDeclAccess().getGroup(), "rule__ConstantDecl__Group__0");
					put(grammarAccess.getConstantDeclAccess().getGroup_1(), "rule__ConstantDecl__Group_1__0");
					put(grammarAccess.getVariableDeclAccess().getGroup(), "rule__VariableDecl__Group__0");
					put(grammarAccess.getVariableDeclAccess().getGroup_1(), "rule__VariableDecl__Group_1__0");
					put(grammarAccess.getIntervalAccess().getGroup(), "rule__Interval__Group__0");
					put(grammarAccess.getEnumerationAccess().getGroup(), "rule__Enumeration__Group__0");
					put(grammarAccess.getRelDeclarationAccess().getGroup(), "rule__RelDeclaration__Group__0");
					put(grammarAccess.getCoreAccess().getGroup(), "rule__Core__Group__0");
					put(grammarAccess.getMultInstantiationAccess().getGroup(), "rule__MultInstantiation__Group__0");
					put(grammarAccess.getPairAccess().getGroup(), "rule__Pair__Group__0");
					put(grammarAccess.getComplexImpliesAccess().getGroup(), "rule__ComplexImplies__Group__0");
					put(grammarAccess.getQImpliesAccess().getGroup(), "rule__QImplies__Group__0");
					put(grammarAccess.getVarListAccess().getGroup(), "rule__VarList__Group__0");
					put(grammarAccess.getDecompositionAccess().getGroup(), "rule__Decomposition__Group__0");
					put(grammarAccess.getGroupAccess().getGroup(), "rule__Group__Group__0");
					put(grammarAccess.getRangeAccess().getGroup(), "rule__Range__Group__0");
					put(grammarAccess.getVisibilityAccess().getGroup(), "rule__Visibility__Group__0");
					put(grammarAccess.getOrderAccess().getGroup_1(), "rule__Order__Group_1__0");
					put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
					put(grammarAccess.getIffAccess().getGroup(), "rule__Iff__Group__0");
					put(grammarAccess.getIffAccess().getGroup_1(), "rule__Iff__Group_1__0");
					put(grammarAccess.getImpliesAccess().getGroup(), "rule__Implies__Group__0");
					put(grammarAccess.getImpliesAccess().getGroup_1(), "rule__Implies__Group_1__0");
					put(grammarAccess.getOrAccess().getGroup(), "rule__Or__Group__0");
					put(grammarAccess.getOrAccess().getGroup_1(), "rule__Or__Group_1__0");
					put(grammarAccess.getAndAccess().getGroup(), "rule__And__Group__0");
					put(grammarAccess.getAndAccess().getGroup_1(), "rule__And__Group_1__0");
					put(grammarAccess.getEqualityAccess().getGroup(), "rule__Equality__Group__0");
					put(grammarAccess.getEqualityAccess().getGroup_1(), "rule__Equality__Group_1__0");
					put(grammarAccess.getComparisonAccess().getGroup(), "rule__Comparison__Group__0");
					put(grammarAccess.getComparisonAccess().getGroup_1(), "rule__Comparison__Group_1__0");
					put(grammarAccess.getPlusOrMinusAccess().getGroup(), "rule__PlusOrMinus__Group__0");
					put(grammarAccess.getPlusOrMinusAccess().getGroup_1(), "rule__PlusOrMinus__Group_1__0");
					put(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_0(), "rule__PlusOrMinus__Group_1_0_0__0");
					put(grammarAccess.getPlusOrMinusAccess().getGroup_1_0_1(), "rule__PlusOrMinus__Group_1_0_1__0");
					put(grammarAccess.getMulOrDivAccess().getGroup(), "rule__MulOrDiv__Group__0");
					put(grammarAccess.getMulOrDivAccess().getGroup_1(), "rule__MulOrDiv__Group_1__0");
					put(grammarAccess.getPrimaryAccess().getGroup_0(), "rule__Primary__Group_0__0");
					put(grammarAccess.getPrimaryAccess().getGroup_1(), "rule__Primary__Group_1__0");
					put(grammarAccess.getPrimaryAccess().getGroup_2(), "rule__Primary__Group_2__0");
					put(grammarAccess.getPrimaryAccess().getGroup_3(), "rule__Primary__Group_3__0");
					put(grammarAccess.getAtomicAccess().getGroup_0(), "rule__Atomic__Group_0__0");
					put(grammarAccess.getAtomicAccess().getGroup_1(), "rule__Atomic__Group_1__0");
					put(grammarAccess.getAtomicAccess().getGroup_2(), "rule__Atomic__Group_2__0");
					put(grammarAccess.getAtomicAccess().getGroup_3(), "rule__Atomic__Group_3__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getGlobalAccess().getGroup(), "rule__Global__Group__0");
					put(grammarAccess.getGlobalAccess().getGroup_4(), "rule__Global__Group_4__0");
					put(grammarAccess.getListOfValuesAccess().getGroup(), "rule__ListOfValues__Group__0");
					put(grammarAccess.getListOfValuesAccess().getGroup_1(), "rule__ListOfValues__Group_1__0");
					put(grammarAccess.getListOfIDsAccess().getGroup(), "rule__ListOfIDs__Group__0");
					put(grammarAccess.getListOfIDsAccess().getGroup_1(), "rule__ListOfIDs__Group_1__0");
					put(grammarAccess.getListOfRelRefsAccess().getGroup(), "rule__ListOfRelRefs__Group__0");
					put(grammarAccess.getListOfRelRefsAccess().getGroup_1(), "rule__ListOfRelRefs__Group_1__0");
					put(grammarAccess.getNamesAccess().getGroup(), "rule__Names__Group__0");
					put(grammarAccess.getNamesAccess().getGroup_1(), "rule__Names__Group_1__0");
					put(grammarAccess.getValuationAccess().getGroup(), "rule__Valuation__Group__0");
					put(grammarAccess.getListOfValuationAccess().getGroup(), "rule__ListOfValuation__Group__0");
					put(grammarAccess.getListOfValuationAccess().getGroup_1(), "rule__ListOfValuation__Group_1__0");
					put(grammarAccess.getListOfListValuesAccess().getGroup(), "rule__ListOfListValues__Group__0");
					put(grammarAccess.getListOfListValuesAccess().getGroup_3(), "rule__ListOfListValues__Group_3__0");
					put(grammarAccess.getModelAccess().getNameAssignment_1(), "rule__Model__NameAssignment_1");
					put(grammarAccess.getModelAccess().getElementsAssignment_3(), "rule__Model__ElementsAssignment_3");
					put(grammarAccess.getModelAccess().getRelationsAssignment_5(), "rule__Model__RelationsAssignment_5");
					put(grammarAccess.getModelAccess().getPairsAssignment_6_1(), "rule__Model__PairsAssignment_6_1");
					put(grammarAccess.getElmDeclarationAccess().getAttAssignment_0(), "rule__ElmDeclaration__AttAssignment_0");
					put(grammarAccess.getElmDeclarationAccess().getDataTypeAssignment_1(), "rule__ElmDeclaration__DataTypeAssignment_1");
					put(grammarAccess.getElmDeclarationAccess().getNameAssignment_2(), "rule__ElmDeclaration__NameAssignment_2");
					put(grammarAccess.getElmDeclarationAccess().getDeclarationAssignment_3(), "rule__ElmDeclaration__DeclarationAssignment_3");
					put(grammarAccess.getConstantDeclAccess().getValueAssignment_1_1(), "rule__ConstantDecl__ValueAssignment_1_1");
					put(grammarAccess.getVariableDeclAccess().getVariantsAssignment_1_1(), "rule__VariableDecl__VariantsAssignment_1_1");
					put(grammarAccess.getIntervalAccess().getStartAssignment_0(), "rule__Interval__StartAssignment_0");
					put(grammarAccess.getIntervalAccess().getEndAssignment_2(), "rule__Interval__EndAssignment_2");
					put(grammarAccess.getEnumerationAccess().getListAssignment_1(), "rule__Enumeration__ListAssignment_1");
					put(grammarAccess.getRelDeclarationAccess().getNameAssignment_0(), "rule__RelDeclaration__NameAssignment_0");
					put(grammarAccess.getRelDeclarationAccess().getExpAssignment_2(), "rule__RelDeclaration__ExpAssignment_2");
					put(grammarAccess.getCoreAccess().getElementsAssignment_3(), "rule__Core__ElementsAssignment_3");
					put(grammarAccess.getMultInstantiationAccess().getNameAssignment_1(), "rule__MultInstantiation__NameAssignment_1");
					put(grammarAccess.getMultInstantiationAccess().getMinAssignment_3(), "rule__MultInstantiation__MinAssignment_3");
					put(grammarAccess.getMultInstantiationAccess().getMaxAssignment_5(), "rule__MultInstantiation__MaxAssignment_5");
					put(grammarAccess.getPairAccess().getOperatorAssignment_0(), "rule__Pair__OperatorAssignment_0");
					put(grammarAccess.getPairAccess().getVar1Assignment_2(), "rule__Pair__Var1Assignment_2");
					put(grammarAccess.getPairAccess().getVar2Assignment_4(), "rule__Pair__Var2Assignment_4");
					put(grammarAccess.getComplexImpliesAccess().getVar1Assignment_2(), "rule__ComplexImplies__Var1Assignment_2");
					put(grammarAccess.getComplexImpliesAccess().getExpAssignment_4(), "rule__ComplexImplies__ExpAssignment_4");
					put(grammarAccess.getQImpliesAccess().getMinaAssignment_1(), "rule__QImplies__MinaAssignment_1");
					put(grammarAccess.getQImpliesAccess().getMaxaAssignment_3(), "rule__QImplies__MaxaAssignment_3");
					put(grammarAccess.getQImpliesAccess().getVar1Assignment_5(), "rule__QImplies__Var1Assignment_5");
					put(grammarAccess.getQImpliesAccess().getMinbAssignment_8(), "rule__QImplies__MinbAssignment_8");
					put(grammarAccess.getQImpliesAccess().getMaxbAssignment_10(), "rule__QImplies__MaxbAssignment_10");
					put(grammarAccess.getVarListAccess().getOperatorAssignment_0(), "rule__VarList__OperatorAssignment_0");
					put(grammarAccess.getVarListAccess().getVar1Assignment_2(), "rule__VarList__Var1Assignment_2");
					put(grammarAccess.getVarListAccess().getListAssignment_5(), "rule__VarList__ListAssignment_5");
					put(grammarAccess.getDecompositionAccess().getParentAssignment_3(), "rule__Decomposition__ParentAssignment_3");
					put(grammarAccess.getDecompositionAccess().getChildrenAssignment_6(), "rule__Decomposition__ChildrenAssignment_6");
					put(grammarAccess.getDecompositionAccess().getCardinalityAssignment_10(), "rule__Decomposition__CardinalityAssignment_10");
					put(grammarAccess.getGroupAccess().getParentAssignment_3(), "rule__Group__ParentAssignment_3");
					put(grammarAccess.getGroupAccess().getChildrenAssignment_6(), "rule__Group__ChildrenAssignment_6");
					put(grammarAccess.getGroupAccess().getMinAssignment_10(), "rule__Group__MinAssignment_10");
					put(grammarAccess.getGroupAccess().getMaxAssignment_12(), "rule__Group__MaxAssignment_12");
					put(grammarAccess.getRangeAccess().getValueAssignment_1(), "rule__Range__ValueAssignment_1");
					put(grammarAccess.getVisibilityAccess().getConditionAssignment_2(), "rule__Visibility__ConditionAssignment_2");
					put(grammarAccess.getVisibilityAccess().getChildrenAssignment_5(), "rule__Visibility__ChildrenAssignment_5");
					put(grammarAccess.getOrderAccess().getOperatorAssignment_0(), "rule__Order__OperatorAssignment_0");
					put(grammarAccess.getOrderAccess().getLeftAssignment_1_1(), "rule__Order__LeftAssignment_1_1");
					put(grammarAccess.getOrderAccess().getRightAssignment_1_4(), "rule__Order__RightAssignment_1_4");
					put(grammarAccess.getExpressionAccess().getExpAssignment_2(), "rule__Expression__ExpAssignment_2");
					put(grammarAccess.getIffAccess().getRightAssignment_1_2(), "rule__Iff__RightAssignment_1_2");
					put(grammarAccess.getImpliesAccess().getRightAssignment_1_2(), "rule__Implies__RightAssignment_1_2");
					put(grammarAccess.getOrAccess().getRightAssignment_1_2(), "rule__Or__RightAssignment_1_2");
					put(grammarAccess.getAndAccess().getRightAssignment_1_2(), "rule__And__RightAssignment_1_2");
					put(grammarAccess.getEqualityAccess().getOpAssignment_1_1(), "rule__Equality__OpAssignment_1_1");
					put(grammarAccess.getEqualityAccess().getRightAssignment_1_2(), "rule__Equality__RightAssignment_1_2");
					put(grammarAccess.getComparisonAccess().getOpAssignment_1_1(), "rule__Comparison__OpAssignment_1_1");
					put(grammarAccess.getComparisonAccess().getRightAssignment_1_2(), "rule__Comparison__RightAssignment_1_2");
					put(grammarAccess.getPlusOrMinusAccess().getRightAssignment_1_1(), "rule__PlusOrMinus__RightAssignment_1_1");
					put(grammarAccess.getMulOrDivAccess().getOpAssignment_1_1(), "rule__MulOrDiv__OpAssignment_1_1");
					put(grammarAccess.getMulOrDivAccess().getRightAssignment_1_2(), "rule__MulOrDiv__RightAssignment_1_2");
					put(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2(), "rule__Primary__ExpressionAssignment_1_2");
					put(grammarAccess.getPrimaryAccess().getOpAssignment_2_1(), "rule__Primary__OpAssignment_2_1");
					put(grammarAccess.getPrimaryAccess().getExpressionAssignment_2_3(), "rule__Primary__ExpressionAssignment_2_3");
					put(grammarAccess.getPrimaryAccess().getOpAssignment_3_1(), "rule__Primary__OpAssignment_3_1");
					put(grammarAccess.getPrimaryAccess().getLeftAssignment_3_3(), "rule__Primary__LeftAssignment_3_3");
					put(grammarAccess.getPrimaryAccess().getRightAssignment_3_5(), "rule__Primary__RightAssignment_3_5");
					put(grammarAccess.getAtomicAccess().getValueAssignment_0_1(), "rule__Atomic__ValueAssignment_0_1");
					put(grammarAccess.getAtomicAccess().getVariableAssignment_1_1(), "rule__Atomic__VariableAssignment_1_1");
					put(grammarAccess.getAtomicAccess().getAttributeAssignment_2_1(), "rule__Atomic__AttributeAssignment_2_1");
					put(grammarAccess.getAtomicAccess().getValueAssignment_3_1(), "rule__Atomic__ValueAssignment_3_1");
					put(grammarAccess.getGlobalAccess().getOpAssignment_0(), "rule__Global__OpAssignment_0");
					put(grammarAccess.getGlobalAccess().getVarsAssignment_2(), "rule__Global__VarsAssignment_2");
					put(grammarAccess.getGlobalAccess().getValuesAssignment_4_1(), "rule__Global__ValuesAssignment_4_1");
					put(grammarAccess.getBoolValAccess().getValueAssignment(), "rule__BoolVal__ValueAssignment");
					put(grammarAccess.getNumberAccess().getValueAssignment(), "rule__Number__ValueAssignment");
					put(grammarAccess.getSymbolAccess().getValueAssignment(), "rule__Symbol__ValueAssignment");
					put(grammarAccess.getListOfValuesAccess().getValuesAssignment_0(), "rule__ListOfValues__ValuesAssignment_0");
					put(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1(), "rule__ListOfValues__ValuesAssignment_1_1");
					put(grammarAccess.getListOfIDsAccess().getValuesAssignment_0(), "rule__ListOfIDs__ValuesAssignment_0");
					put(grammarAccess.getListOfIDsAccess().getValuesAssignment_1_1(), "rule__ListOfIDs__ValuesAssignment_1_1");
					put(grammarAccess.getListOfRelRefsAccess().getIdsAssignment_0(), "rule__ListOfRelRefs__IdsAssignment_0");
					put(grammarAccess.getListOfRelRefsAccess().getIdsAssignment_1_1(), "rule__ListOfRelRefs__IdsAssignment_1_1");
					put(grammarAccess.getNamesAccess().getIdsAssignment_0(), "rule__Names__IdsAssignment_0");
					put(grammarAccess.getNamesAccess().getIdsAssignment_1_1(), "rule__Names__IdsAssignment_1_1");
					put(grammarAccess.getValuationAccess().getElementAssignment_1(), "rule__Valuation__ElementAssignment_1");
					put(grammarAccess.getValuationAccess().getValueAssignment_3(), "rule__Valuation__ValueAssignment_3");
					put(grammarAccess.getListOfValuationAccess().getValuationsAssignment_0(), "rule__ListOfValuation__ValuationsAssignment_0");
					put(grammarAccess.getListOfValuationAccess().getValuationsAssignment_1_1(), "rule__ListOfValuation__ValuationsAssignment_1_1");
					put(grammarAccess.getListOfListValuesAccess().getListAssignment_1(), "rule__ListOfListValues__ListAssignment_1");
					put(grammarAccess.getListOfListValuesAccess().getListAssignment_3_2(), "rule__ListOfListValues__ListAssignment_3_2");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public HlvlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(HlvlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
