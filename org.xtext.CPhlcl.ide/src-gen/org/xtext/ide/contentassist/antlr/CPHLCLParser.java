/*
 * generated by Xtext 2.12.0
 */
package org.xtext.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.xtext.ide.contentassist.antlr.internal.InternalCPHLCLParser;
import org.xtext.services.CPHLCLGrammarAccess;

public class CPHLCLParser extends AbstractContentAssistParser {

	@Inject
	private CPHLCLGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalCPHLCLParser createParser() {
		InternalCPHLCLParser result = new InternalCPHLCLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDomainDeclarationAccess().getAlternatives(), "rule__DomainDeclaration__Alternatives");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getBoolTermAccess().getAlternatives(), "rule__BoolTerm__Alternatives");
					put(grammarAccess.getComplexTermAccess().getAlternatives(), "rule__ComplexTerm__Alternatives");
					put(grammarAccess.getNumericTermAccess().getAlternatives(), "rule__NumericTerm__Alternatives");
					put(grammarAccess.getStrategyAccess().getAlternatives(), "rule__Strategy__Alternatives");
					put(grammarAccess.getBoolValAccess().getAlternatives(), "rule__BoolVal__Alternatives");
					put(grammarAccess.getLogicOpBinAccess().getAlternatives(), "rule__LogicOpBin__Alternatives");
					put(grammarAccess.getRelationalOpAccess().getAlternatives(), "rule__RelationalOp__Alternatives");
					put(grammarAccess.getGlobalOpAccess().getAlternatives(), "rule__GlobalOp__Alternatives");
					put(grammarAccess.getArithmeticOpAccess().getAlternatives(), "rule__ArithmeticOp__Alternatives");
					put(grammarAccess.getIntegerOpAccess().getAlternatives(), "rule__IntegerOp__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getNonEnumerableValueAccess().getAlternatives(), "rule__NonEnumerableValue__Alternatives");
					put(grammarAccess.getVarTypeAccess().getAlternatives(), "rule__VarType__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getVarDeclarationAccess().getGroup(), "rule__VarDeclaration__Group__0");
					put(grammarAccess.getIntervalAccess().getGroup(), "rule__Interval__Group__0");
					put(grammarAccess.getEnumerationAccess().getGroup(), "rule__Enumeration__Group__0");
					put(grammarAccess.getConstraintAccess().getGroup(), "rule__Constraint__Group__0");
					put(grammarAccess.getBoolTermAccess().getGroup_0(), "rule__BoolTerm__Group_0__0");
					put(grammarAccess.getLogicAccess().getGroup(), "rule__Logic__Group__0");
					put(grammarAccess.getLogicUnAccess().getGroup(), "rule__LogicUn__Group__0");
					put(grammarAccess.getRelationalAccess().getGroup(), "rule__Relational__Group__0");
					put(grammarAccess.getNumericTermAccess().getGroup_0(), "rule__NumericTerm__Group_0__0");
					put(grammarAccess.getArithmeticAccess().getGroup(), "rule__Arithmetic__Group__0");
					put(grammarAccess.getGlobalAccess().getGroup(), "rule__Global__Group__0");
					put(grammarAccess.getControlAccess().getGroup(), "rule__Control__Group__0");
					put(grammarAccess.getListOfValuesAccess().getGroup(), "rule__ListOfValues__Group__0");
					put(grammarAccess.getListOfValuesAccess().getGroup_1(), "rule__ListOfValues__Group_1__0");
					put(grammarAccess.getListOfEnumerablesAccess().getGroup(), "rule__ListOfEnumerables__Group__0");
					put(grammarAccess.getListOfEnumerablesAccess().getGroup_1(), "rule__ListOfEnumerables__Group_1__0");
					put(grammarAccess.getModelAccess().getNameAssignment_1(), "rule__Model__NameAssignment_1");
					put(grammarAccess.getModelAccess().getVarsAssignment_3(), "rule__Model__VarsAssignment_3");
					put(grammarAccess.getModelAccess().getConstraintsAssignment_5(), "rule__Model__ConstraintsAssignment_5");
					put(grammarAccess.getModelAccess().getStrategyAssignment_7(), "rule__Model__StrategyAssignment_7");
					put(grammarAccess.getVarDeclarationAccess().getTypeAssignment_0(), "rule__VarDeclaration__TypeAssignment_0");
					put(grammarAccess.getVarDeclarationAccess().getNameAssignment_1(), "rule__VarDeclaration__NameAssignment_1");
					put(grammarAccess.getVarDeclarationAccess().getDomainAssignment_3(), "rule__VarDeclaration__DomainAssignment_3");
					put(grammarAccess.getIntervalAccess().getStartAssignment_0(), "rule__Interval__StartAssignment_0");
					put(grammarAccess.getIntervalAccess().getEndAssignment_2(), "rule__Interval__EndAssignment_2");
					put(grammarAccess.getEnumerationAccess().getListAssignment_1(), "rule__Enumeration__ListAssignment_1");
					put(grammarAccess.getConstraintAccess().getNameAssignment_0(), "rule__Constraint__NameAssignment_0");
					put(grammarAccess.getConstraintAccess().getExpAssignment_2(), "rule__Constraint__ExpAssignment_2");
					put(grammarAccess.getLogicAccess().getLogicLeftAssignment_0(), "rule__Logic__LogicLeftAssignment_0");
					put(grammarAccess.getLogicAccess().getLogicOpAssignment_1(), "rule__Logic__LogicOpAssignment_1");
					put(grammarAccess.getLogicAccess().getLogicRightAssignment_2(), "rule__Logic__LogicRightAssignment_2");
					put(grammarAccess.getLogicUnAccess().getLogicOpAssignment_0(), "rule__LogicUn__LogicOpAssignment_0");
					put(grammarAccess.getLogicUnAccess().getExpAssignment_2(), "rule__LogicUn__ExpAssignment_2");
					put(grammarAccess.getRelationalAccess().getRelationalLeftAssignment_0(), "rule__Relational__RelationalLeftAssignment_0");
					put(grammarAccess.getRelationalAccess().getRelationalOpAssignment_1(), "rule__Relational__RelationalOpAssignment_1");
					put(grammarAccess.getRelationalAccess().getRelationalRightAssignment_2(), "rule__Relational__RelationalRightAssignment_2");
					put(grammarAccess.getArithmeticAccess().getLeftAssignment_0(), "rule__Arithmetic__LeftAssignment_0");
					put(grammarAccess.getArithmeticAccess().getArithOperatorAssignment_1(), "rule__Arithmetic__ArithOperatorAssignment_1");
					put(grammarAccess.getArithmeticAccess().getRightAssignment_2(), "rule__Arithmetic__RightAssignment_2");
					put(grammarAccess.getGlobalAccess().getOpAssignment_0(), "rule__Global__OpAssignment_0");
					put(grammarAccess.getGlobalAccess().getVarsAssignment_2(), "rule__Global__VarsAssignment_2");
					put(grammarAccess.getControlAccess().getCondAssignment_2(), "rule__Control__CondAssignment_2");
					put(grammarAccess.getControlAccess().getTrueStatementAssignment_5(), "rule__Control__TrueStatementAssignment_5");
					put(grammarAccess.getControlAccess().getElseStatementAssignment_7(), "rule__Control__ElseStatementAssignment_7");
					put(grammarAccess.getBoolAccess().getValAssignment(), "rule__Bool__ValAssignment");
					put(grammarAccess.getBoolVarAccess().getIdAssignment(), "rule__BoolVar__IdAssignment");
					put(grammarAccess.getNumberAccess().getNumAssignment(), "rule__Number__NumAssignment");
					put(grammarAccess.getIntVarAccess().getIdAssignment(), "rule__IntVar__IdAssignment");
					put(grammarAccess.getListOfValuesAccess().getValuesAssignment_0(), "rule__ListOfValues__ValuesAssignment_0");
					put(grammarAccess.getListOfValuesAccess().getValuesAssignment_1_1(), "rule__ListOfValues__ValuesAssignment_1_1");
					put(grammarAccess.getListOfEnumerablesAccess().getValuesAssignment_0(), "rule__ListOfEnumerables__ValuesAssignment_0");
					put(grammarAccess.getListOfEnumerablesAccess().getValuesAssignment_1_1(), "rule__ListOfEnumerables__ValuesAssignment_1_1");
					put(grammarAccess.getListOfIDsAccess().getIdsAssignment(), "rule__ListOfIDs__IdsAssignment");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public CPHLCLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CPHLCLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
