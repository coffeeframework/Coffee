/*
 * generated by Xtext 2.12.0
 */
package org.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.pLhlcl.Model
import org.xtext.pLhlcl.VarDeclaration
import org.xtext.pLhlcl.ConsExpression
import org.xtext.pLhlcl.VariantDeclaration
import org.xtext.pLhlcl.VariantsInterval
import org.xtext.pLhlcl.VariantsEnumeration
import org.eclipse.emf.common.util.EList
import org.xtext.pLhlcl.Refinement
import org.xtext.pLhlcl.FodaBin
import org.xtext.pLhlcl.Rule
import org.xtext.pLhlcl.FodaUN
import org.xtext.pLhlcl.IDCons
import org.xtext.pLhlcl.Structural
import java.util.Map
import java.util.HashMap
import java.util.ArrayList


/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class PLhlclGenerator extends AbstractGenerator implements CPCode {
	/**
	 * Name of the PL model 
	 */
	private String modelName
	private Map <String, String> parents;
	private ArrayList <String> clonConstraints;

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		modelName= modelName(resource.contents.head as Model)
		parents= new HashMap<String,String>();
		clonConstraints= new ArrayList<String>;
		fsa.generateFile(modelName+".cp", toCPHLCL(resource.contents.head as Model))

	}
	def modelName(Model model) {
		var name = model.name.toFirstUpper
		return name
	}
	
	def toCPHLCL(Model model) '''
		«HEADER» «modelName»
		«VARIABLES»
		boolean «modelName»
		«FOR v : model.vars»
			«v.declareVariable»
		«ENDFOR»
		«CONSTRAINTS»
		C_«modelName» : «modelName» = 1
		«declareClonConstraints()»
		«FOR c : model.constraints»
			«IF c.exp instanceof Structural »
				«var exp= c.exp as Structural»
				«IF exp.min===null && exp.max===null »
					«declareParents(exp)»
				«ELSE»
					«c.name»: «getExpression(c.exp)»
				«ENDIF»
			«ELSE»
				«c.name»: «getExpression(c.exp)»
			«ENDIF»	
		«ENDFOR»
«««		«STRATEGY»
	'''
	def declareVariable(VarDeclaration variable)'''
		«declareSingleVar(variable)»
		«IF  (!(variable.min===null && variable.max===null)) »
			«declareInstances(variable)»	
		«ENDIF»
	'''
	/**
	 * Method to declare a variable without clones
	 */
	def declareSingleVar(VarDeclaration variable) '''
		«variable.type» «variable.name» «declareVariants(variable, variable.variants)»
	'''
		/**
	 * Method to declare a variable's with clones
	 */
	def  declareInstances(VarDeclaration variable) {
		var String declaration=""
		var String left= "(" + variable.min.value + "<="
		var String right= "(" + variable.max.value + ">="
		var String sum= ""
		for ( var i=1; i<= variable.max.value; i= i+1) {
			declaration+="boolean " +variable.name+i +"\n"
			sum+= variable.name+i + " +"
		}
		left += sum.substring(0, sum.length() - 1) + ") "
		right += sum.substring(0, sum.length() - 1) + ") "
		var String constraint= variable.name+" => (" + left + "AND" + right +")"
		clonConstraints.add(constraint)
		declaration
	}
	/**
	 * Declare clon constraints 
	 */
	 def  declareClonConstraints()'''
	 	«var int id = 1»
	 	«FOR constraint : clonConstraints»
	 		clon«id»: «constraint.toString»
	 		«{id++ + "+"; ""}»
	 	«ENDFOR»
	 '''


	/**
	 * Method for declare variants
	 */
	def declareVariants(VarDeclaration variable, VariantDeclaration variant) '''
		«IF variable.type=="boolean"»
		«ELSE»	
			«IF variant instanceof VariantsInterval»
				domain: «variant.start»..«variant.end»
			«ELSE»
				«IF variant instanceof VariantsEnumeration»
					domain: [«getList(variant.list.values)»]
				«ENDIF»	
			«ENDIF»
		«ENDIF»
	'''
	def  getList(EList l){
		var out= l.get(0) ;
		for(var i=1; i<l.size(); i= i+1 ){
			out= out +", " + l.get(i) ;
		}
		return out;
	}
	
	def getExpression(ConsExpression exp)'''
«««		«IF exp instanceof Refinement»
«««			«declareRefinement(exp, name)»
«««		«ELSE»
		«IF exp instanceof IDCons»
			«exp.name»
		«ELSE»
			«IF exp instanceof FodaBin»
				«declareFodaBin(exp)»
			«ELSE»
				«IF exp instanceof Rule»
					«declareRule(exp)»
				«ELSE»
					«IF exp instanceof Structural»
						«declareStructural(exp)»
					«ELSE»
						«IF exp instanceof FodaUN»
							«declareFodaUnary(exp)»
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDIF»
		«ENDIF»
	'''
	def declareRule(Rule rule)'''
		«val left= getExpression(rule.condition as ConsExpression)»
		«val right= getExpression (rule.consequence as ConsExpression)»
		(«left») => («right»)
	'''
	def declareFodaBin(FodaBin exp) '''
		«val left= exp.var1.name»
		«val right= exp.var2.name»
		«IF exp.op=="requires"»
			«IF exp.var1.min===null && exp.var1.max===null»
				«left»  => «right» 
			«ELSE»
				«var String declaration="("+left+"1"+" => " + right + ")"»
				«for ( var i=2; i<= exp.var1.max.value; i= i+1)  {
					declaration+=" AND ("+ left+i +" => " + right + ")"
				}»
				«declaration»
			«ENDIF»
		«ELSE»
			«IF exp.op=="excludes"»
				«IF exp.var1.min===null && exp.var1.max===null»
					«left» + «right»<= 1 
				«ELSE»
					«var String declaration="("+left+"1"+" + " + right + "<= 1)"»
					«for ( var i=2; i<= exp.var1.max.value; i= i+1)  {
						declaration+=" AND ("+ left+i +" + " + right + "<= 1)"
					}»
					«declaration»
				«ENDIF»
			«ELSE»
				«IF exp.op=="mandatory"»
					«left» = «right»
				«ELSE»
					«left» >= «right»
				«ENDIF»
			«ENDIF»
		«ENDIF»
	'''
	def declareStructural(Structural exp)'''
		«IF exp.min ==0 && exp.max == 0»
			«{declareParents(exp); ""}»
		«ELSE»
			«var String idsSum=""»
			«FOR child : exp.group.ids»
				(«child.name» => «exp.parent») AND
				«{idsSum+= child.name +"+"; ""}»
				«{parents.put(child.name, exp.parent)+"+"; ""}»
			«ENDFOR»
			(«exp.parent»>= 1) => («idsSum.substring(0, idsSum.length() - 1)» >= «exp.min.value») AND
			(«exp.parent»>= 1) => («idsSum.substring(0, idsSum.length() - 1)» <= «exp.max.value») 
		«ENDIF»
	'''
	def declareParents(Structural exp){
		for (element : exp.group.ids) {
			parents.put(element.name, exp.parent)
		}
	}
	def declareFodaUnary(FodaUN exp) '''
		«IF exp.op=="optional"»
			«parents.get(exp.var1.name)» >= «exp.var1.name»
		«ELSE»
			«IF exp.op=="mandatory"»
				«parents.get(exp.var1.name)» = «exp.var1.name»
			«ELSE»
			«ENDIF»
		«ENDIF»
	'''
}