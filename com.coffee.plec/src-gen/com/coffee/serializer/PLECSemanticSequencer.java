/*
 * generated by Xtext 2.12.0
 */
package com.coffee.serializer;

import com.coffee.pLEC.Assignment;
import com.coffee.pLEC.Attributes;
import com.coffee.pLEC.BoolVal;
import com.coffee.pLEC.Constraint;
import com.coffee.pLEC.FodaBin;
import com.coffee.pLEC.FodaUN;
import com.coffee.pLEC.IDCons;
import com.coffee.pLEC.ListOfIDs;
import com.coffee.pLEC.ListOfValues;
import com.coffee.pLEC.Model;
import com.coffee.pLEC.PLECPackage;
import com.coffee.pLEC.Rule;
import com.coffee.pLEC.SetRefinement;
import com.coffee.pLEC.Structural;
import com.coffee.pLEC.Symbol;
import com.coffee.pLEC.VarDeclaration;
import com.coffee.pLEC.VarRefinement;
import com.coffee.pLEC.VariantsEnumeration;
import com.coffee.pLEC.VariantsInterval;
import com.coffee.services.PLECGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class PLECSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PLECGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PLECPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PLECPackage.ASSIGNMENT:
				sequence_Assignment(context, (Assignment) semanticObject); 
				return; 
			case PLECPackage.ATTRIBUTES:
				sequence_Attributes(context, (Attributes) semanticObject); 
				return; 
			case PLECPackage.BOOL_VAL:
				sequence_BoolVal(context, (BoolVal) semanticObject); 
				return; 
			case PLECPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case PLECPackage.FODA_BIN:
				sequence_FodaBin(context, (FodaBin) semanticObject); 
				return; 
			case PLECPackage.FODA_UN:
				sequence_FodaUN(context, (FodaUN) semanticObject); 
				return; 
			case PLECPackage.ID_CONS:
				sequence_IDCons(context, (IDCons) semanticObject); 
				return; 
			case PLECPackage.LIST_OF_IDS:
				sequence_ListOfIDs(context, (ListOfIDs) semanticObject); 
				return; 
			case PLECPackage.LIST_OF_VALUES:
				sequence_ListOfValues(context, (ListOfValues) semanticObject); 
				return; 
			case PLECPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case PLECPackage.NUMBER:
				sequence_Number(context, (com.coffee.pLEC.Number) semanticObject); 
				return; 
			case PLECPackage.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			case PLECPackage.SET_REFINEMENT:
				sequence_SetRefinement(context, (SetRefinement) semanticObject); 
				return; 
			case PLECPackage.STRUCTURAL:
				sequence_Structural(context, (Structural) semanticObject); 
				return; 
			case PLECPackage.SYMBOL:
				sequence_Symbol(context, (Symbol) semanticObject); 
				return; 
			case PLECPackage.VAR_DECLARATION:
				sequence_VarDeclaration(context, (VarDeclaration) semanticObject); 
				return; 
			case PLECPackage.VAR_REFINEMENT:
				sequence_VarRefinement(context, (VarRefinement) semanticObject); 
				return; 
			case PLECPackage.VARIANTS_ENUMERATION:
				sequence_VariantsEnumeration(context, (VariantsEnumeration) semanticObject); 
				return; 
			case PLECPackage.VARIANTS_INTERVAL:
				sequence_VariantsInterval(context, (VariantsInterval) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ConsExpression returns Assignment
	 *     TerminalExp returns Assignment
	 *     Refinement returns Assignment
	 *     Assignment returns Assignment
	 *
	 * Constraint:
	 *     (var=ID value=Value)
	 */
	protected void sequence_Assignment(ISerializationContext context, Assignment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.ASSIGNMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.ASSIGNMENT__VAR));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.ASSIGNMENT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssignmentAccess().getVarIDTerminalRuleCall_0_0(), semanticObject.getVar());
		feeder.accept(grammarAccess.getAssignmentAccess().getValueValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns Attributes
	 *     TerminalExp returns Attributes
	 *     Attributes returns Attributes
	 *
	 * Constraint:
	 *     (att=ListOfIDs var1=[VarDeclaration|ID])
	 */
	protected void sequence_Attributes(ISerializationContext context, Attributes semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.ATTRIBUTES__ATT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.ATTRIBUTES__ATT));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.ATTRIBUTES__VAR1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.ATTRIBUTES__VAR1));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributesAccess().getAttListOfIDsParserRuleCall_2_0(), semanticObject.getAtt());
		feeder.accept(grammarAccess.getAttributesAccess().getVar1VarDeclarationIDTerminalRuleCall_5_0_1(), semanticObject.eGet(PLECPackage.Literals.ATTRIBUTES__VAR1, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BoolVal returns BoolVal
	 *     Value returns BoolVal
	 *     NonEnumerableValue returns BoolVal
	 *
	 * Constraint:
	 *     (value='true' | value='false')
	 */
	protected void sequence_BoolVal(ISerializationContext context, BoolVal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Constraint returns Constraint
	 *
	 * Constraint:
	 *     (name=ID exp=ConsExpression)
	 */
	protected void sequence_Constraint(ISerializationContext context, Constraint semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.CONSTRAINT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.CONSTRAINT__NAME));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.CONSTRAINT__EXP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.CONSTRAINT__EXP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConstraintAccess().getExpConsExpressionParserRuleCall_2_0(), semanticObject.getExp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns FodaBin
	 *     TerminalExp returns FodaBin
	 *     FodaBin returns FodaBin
	 *
	 * Constraint:
	 *     (var1=[VarDeclaration|ID] op=BinOp var2=[VarDeclaration|ID])
	 */
	protected void sequence_FodaBin(ISerializationContext context, FodaBin semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.FODA_BIN__VAR1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.FODA_BIN__VAR1));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.FODA_BIN__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.FODA_BIN__OP));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.FODA_BIN__VAR2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.FODA_BIN__VAR2));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFodaBinAccess().getVar1VarDeclarationIDTerminalRuleCall_0_0_1(), semanticObject.eGet(PLECPackage.Literals.FODA_BIN__VAR1, false));
		feeder.accept(grammarAccess.getFodaBinAccess().getOpBinOpParserRuleCall_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getFodaBinAccess().getVar2VarDeclarationIDTerminalRuleCall_2_0_1(), semanticObject.eGet(PLECPackage.Literals.FODA_BIN__VAR2, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns FodaUN
	 *     TerminalExp returns FodaUN
	 *     FodaUN returns FodaUN
	 *
	 * Constraint:
	 *     (var1=[VarDeclaration|ID] op=UnaryOp)
	 */
	protected void sequence_FodaUN(ISerializationContext context, FodaUN semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.FODA_UN__VAR1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.FODA_UN__VAR1));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.FODA_UN__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.FODA_UN__OP));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFodaUNAccess().getVar1VarDeclarationIDTerminalRuleCall_0_0_1(), semanticObject.eGet(PLECPackage.Literals.FODA_UN__VAR1, false));
		feeder.accept(grammarAccess.getFodaUNAccess().getOpUnaryOpParserRuleCall_2_0(), semanticObject.getOp());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns IDCons
	 *     TerminalExp returns IDCons
	 *     IDCons returns IDCons
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_IDCons(ISerializationContext context, IDCons semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.ID_CONS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.ID_CONS__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIDConsAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ListOfIDs returns ListOfIDs
	 *
	 * Constraint:
	 *     (ids+=[VarDeclaration|ID] ids+=[VarDeclaration|ID]*)
	 */
	protected void sequence_ListOfIDs(ISerializationContext context, ListOfIDs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ListOfValues returns ListOfValues
	 *
	 * Constraint:
	 *     (values+=Value values+=Value*)
	 */
	protected void sequence_ListOfValues(ISerializationContext context, ListOfValues semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (name=ID vars+=VarDeclaration* constraints+=Constraint*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Number returns Number
	 *     Value returns Number
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Number(ISerializationContext context, com.coffee.pLEC.Number semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.NUMBER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.NUMBER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNumberAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns Rule
	 *     TerminalExp returns Rule
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (condition=TerminalExp consequence=TerminalExp)
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.RULE__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.RULE__CONDITION));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.RULE__CONSEQUENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.RULE__CONSEQUENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRuleAccess().getConditionTerminalExpParserRuleCall_0_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getRuleAccess().getConsequenceTerminalExpParserRuleCall_2_0(), semanticObject.getConsequence());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns SetRefinement
	 *     TerminalExp returns SetRefinement
	 *     Refinement returns SetRefinement
	 *     SetRefinement returns SetRefinement
	 *
	 * Constraint:
	 *     (vars=ListOfIDs head=ListOfValues tail+=ListOfValues+)
	 */
	protected void sequence_SetRefinement(ISerializationContext context, SetRefinement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns Structural
	 *     TerminalExp returns Structural
	 *     Structural returns Structural
	 *
	 * Constraint:
	 *     (parent=[VarDeclaration|Parent] group=ListOfIDs (min=Number max=Number)?)
	 */
	protected void sequence_Structural(ISerializationContext context, Structural semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Symbol returns Symbol
	 *     Value returns Symbol
	 *     NonEnumerableValue returns Symbol
	 *
	 * Constraint:
	 *     value=ID
	 */
	protected void sequence_Symbol(ISerializationContext context, Symbol semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.NON_ENUMERABLE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.NON_ENUMERABLE_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSymbolAccess().getValueIDTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     VarDeclaration returns VarDeclaration
	 *
	 * Constraint:
	 *     ((instantiable='instantiable' min=Number max=Number)? type=VarType name=ID variants=VariantDeclaration?)
	 */
	protected void sequence_VarDeclaration(ISerializationContext context, VarDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConsExpression returns VarRefinement
	 *     TerminalExp returns VarRefinement
	 *     Refinement returns VarRefinement
	 *     VarRefinement returns VarRefinement
	 *
	 * Constraint:
	 *     (var=ID values=VariantDeclaration)
	 */
	protected void sequence_VarRefinement(ISerializationContext context, VarRefinement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.VAR_REFINEMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.VAR_REFINEMENT__VAR));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.VAR_REFINEMENT__VALUES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.VAR_REFINEMENT__VALUES));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVarRefinementAccess().getVarIDTerminalRuleCall_0_0(), semanticObject.getVar());
		feeder.accept(grammarAccess.getVarRefinementAccess().getValuesVariantDeclarationParserRuleCall_2_0(), semanticObject.getValues());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     VariantDeclaration returns VariantsEnumeration
	 *     VariantsEnumeration returns VariantsEnumeration
	 *
	 * Constraint:
	 *     list=ListOfValues
	 */
	protected void sequence_VariantsEnumeration(ISerializationContext context, VariantsEnumeration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.VARIANTS_ENUMERATION__LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.VARIANTS_ENUMERATION__LIST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariantsEnumerationAccess().getListListOfValuesParserRuleCall_1_0(), semanticObject.getList());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     VariantDeclaration returns VariantsInterval
	 *     VariantsInterval returns VariantsInterval
	 *
	 * Constraint:
	 *     (start=Number end=Number)
	 */
	protected void sequence_VariantsInterval(ISerializationContext context, VariantsInterval semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.VARIANTS_INTERVAL__START) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.VARIANTS_INTERVAL__START));
			if (transientValues.isValueTransient(semanticObject, PLECPackage.Literals.VARIANTS_INTERVAL__END) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PLECPackage.Literals.VARIANTS_INTERVAL__END));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariantsIntervalAccess().getStartNumberParserRuleCall_0_0(), semanticObject.getStart());
		feeder.accept(grammarAccess.getVariantsIntervalAccess().getEndNumberParserRuleCall_2_0(), semanticObject.getEnd());
		feeder.finish();
	}
	
	
}