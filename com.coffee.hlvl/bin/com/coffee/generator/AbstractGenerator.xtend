package com.coffee.generator


import java.util.HashMap
import java.util.Map
import com.coffee.hlvl.ElmDeclaration
import com.coffee.hlvl.Decomposition
import com.coffee.hlvl.Model
import com.coffee.hlvl.Relation
import com.coffee.hlvl.Core
import com.coffee.hlvl.Group
import com.coffee.hlvl.Pair
import com.coffee.hlvl.VarList
import com.coffee.hlvl.Expression
import com.coffee.hlvl.Visibility
import com.coffee.hlvl.VariableDecl
import com.coffee.hlvl.ConstantDecl

/**
 * Abstract Generator, this is the class that process the model and traverses the 
 * syntax tree regardless the type of notation and problem
 * @author Angela Villota
 * @version HLVL 1
 * August 2018
 * adpated to the HLVl grammar on January 2019
 */
 abstract class AbstractGenerator implements IGenerator{
	/**
	 * Name of the PL model 
	 */
	private String modelName
	

	private Dialect dialect
	/**
	 * object to obtain the program sentences regarding the type of the problem
	 */
	private CodeFactory factory;
	
	/**
	 * Map with the parent of each variable, for decomposition relations
	 */
	private Map <String, ElmDeclaration> parents;
	
		/**
	 * Map with the parent of each variable, for decomposition relations
	 */
	private Map <String, Relation> relations;
	
	private Map <String, ElmDeclaration> attributes;
	/**
	 * Constructor method 
	 * @param the name of the model
	 * @param type of the problem
	 */
	new(String name, Dialect dialect) {
		modelName= name
		this.dialect= dialect
		//initializing the data sctucture with the map of parents
		parents= new HashMap<String,ElmDeclaration>();
		attributes= new HashMap<String,ElmDeclaration>();
		relations= new HashMap<String, Relation>();
	}

	
	/*===================================================================
	 *===================================================================
	  Methods that should be implemented in an instance of the generator (BooleanGenerator, IntegerGenerator)
	  */
	
	/**
	 * Method to obtain a sequence of characters containing the constraint
	 * representation of the model regarding the type of the problem and the
	 * notation.
	 * @param model is an ECORE syntax tree with the program
	 * this syntax tree should be traversed. 
	 */
	 override parseModel(Model model){
	 	'''
	 	% Autogenerated code form the Coffee framework
	 	% Author: avillota
	 	% Variables from elements definitions 
	 	«parseElements(model)»
	 	% Variables and constraints from the variability relations definition
	 	«parseRelations(model)»
	 	% The solving parameters from the parameters files
	 	'''
	 } 
	
	

	
	/**
	 * Returns the generated code for a particular constraint
	 * @param id is a String containing the identifier of the constraint
	 * @param exp is a ConsExpression (to be parsed)
	 */
	
	
	/**
	 * Returns the generated code for the constraints autogenerated giving clonning
	 * and cardinality relations 
	 */
	//abstract override putAutogeneratedCons() ;

	
	/*===================================================================
	 *===================================================================
	 * Implemented Methods 
	 */
		
	/**
	 * This method traverses the list of variables to parse each declaration
	 * The declaration is made by the factory 
	 * @param model
	 */
	override parseElements(Model model) {
		var String out=""
		
		for(element : model.elements){
			if (element.att !==null && element.att=="att"){
				attributes.put(element.name, element)
			}
			else if (element.declaration instanceof ConstantDecl){
				
				val value= (element.declaration as ConstantDecl).value
				if (element.dataType=="boolean" && value==0){
					out+=factory.getElement(element)
				}else{
				out+= factory.getConstant(element)
				
				} 
			}
			else if(element.declaration instanceof VariableDecl ){
				out+=factory.getElement(element)
			}
		}
		out
	}
	/**
	 * Method to parse the constraints in a model.
	 * The constraints are contained in a collection 
	 * of constraints
	 * @param model 
	 */	
	override parseRelations(Model model) {
		var String out=""
		println("call to parseRelations")
		for(e: model.relations){
			relations.put(e.name, e.exp)
			println('''parsing relation «e.name»''')
			out+=parseRelation(e.exp)
		}
		println("parseRelation out "+ out)
		out
	}
	

	
	/**
	 * This method is used to determine he type of an expression and
	 * call the method in charge to produce the code.
	 * @param exp is a constraint expression
	 */
	override parseRelation(Relation rel) {
		
		if (rel instanceof Core ){
			factory.getCore(rel)
		}
		else if (rel instanceof Decomposition){
			factory.getDecomposition(rel, parents)
		}
		else if(rel instanceof Group){
			factory.getGroup(rel, parents)
		}
		else if (rel instanceof Pair){
			val pair= rel as Pair
			if (pair.operator=="implies"){
				factory.getImpliesPair(rel.var1, rel.var2)
			}
			else{
				factory.getMutexPair(rel.var1, rel.var2)
			}
		}
		else if (rel instanceof VarList){
						val pair= rel as Pair
			if (pair.operator=="implies"){
				factory.getImpliesList(rel)
			}
			else{
				factory.getMutexList(rel)
			}
		}
		else if (rel instanceof Expression){
			factory.getExpression(rel)
		}
		else if (rel instanceof Visibility){
			factory.getVisibility(rel)
		}
	}
	
	
	
	/*===================================================================
	 *===================================================================
	 *  Getters and setters
	 */	
	override getModelName() {
		return modelName
	}
	
	override getDialect() {
		return dialect
	}
	
	override addParents(Decomposition exp) {
		for (element : exp.children.values) {
			parents.put(element.name, exp.parent)
		}
	}
	
	override getParents(){
		return parents
		
	}
	override void setFactory( CodeFactory factory){
		this.factory= factory
	}
	
	
}