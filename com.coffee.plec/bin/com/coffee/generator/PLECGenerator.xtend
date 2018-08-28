/*
 * generated by Xtext 2.12.0
 */
package com.coffee.generator

// autogenerated imports
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext




//Language imports
import com.coffee.pLEC.Model
import com.coffee.generator.THLCL.THLCLGenerator
import com.coffee.generator.XCSP3.XCSP3Generator
import com.coffee.pLEC.VarDeclaration
import com.coffee.pLEC.Structural

/**
 * Class autogenerated by xtext and edited to define the code generator
 * for the Product Line Engineering Constraints Language
 * @author Angela Villota
 * @version PLEC V3
 * August 2018
 */
/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class PLECGenerator extends AbstractGenerator {



	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// obtaining the name of the model from the source code
		val modelName= modelName(resource.contents.head as Model)
		// obtaining the model
		val model= resource.contents.head as Model
		
		//obtaining the type of problem
		val typeOfProblem= setTypeOfProblem(model)
		
		//generating an intermediate file with the textual HLCL representation
		fsa.generateFile(modelName+".hlcl", toTHLCL(model, modelName, typeOfProblem))
		
//		//generating an intermediate file with the textual XCSP3 representation
		fsa.generateFile(modelName+".xml", toXCSP3(model, modelName, typeOfProblem))
	}
	
	/**
	 * Method to obtain the name of the model
	 * @param modes is of type Model 
	 * @retuns String name with the name of the model
	 */
	def modelName(Model model) {
		var name = model.name.toFirstUpper
		return name
	}
	
	/**
	 * Method that determines the type of the problem regarding the types of the variables and 
	 * type of the constraints
	 * @param model is an abstract representation of the model
	 */
	def TypeOfProblem setTypeOfProblem(Model model){
		/*
		 * if all variables and constraints can be translated into a sat problem
		 * the the problem is a SAT
		 * otherwise is a CSP
		 */ 
		 
		if (typeOfVariables(model)== TypeOfProblem.SAT 
			&& 
			typeOfConstraints(model)== TypeOfProblem.SAT){
			return TypeOfProblem.SAT
		}else{
			return TypeOfProblem.CSP
		}
	}
	
	/**
	 * Method to obtain a Textual HLCL representation of the model
	 * @param the model
	 * @return a sequence of characters to create a .hlcl file
	 */
	def toTHLCL(Model model, String modelName, TypeOfProblem typeOfProblem) {
		//en este metodo se debe  instanciar el generador de THLCL 
		//se les manda como parámetro el tipo de problema. 
		var THLCLGenerator thlcl= new THLCLGenerator (modelName,  typeOfProblem)
		thlcl.parseModel(model)
		
	}
	/**
	 * Method to obtain a XCSP3 representation of the model
	 * @param the model
	 * @return a sequence of characters to create a .xcsp3 file
	 */
	def toXCSP3(Model model, String modelName,TypeOfProblem typeOfProblem) {
		//en este metodo se debe  instanciar el generador de XCSP3 
		//se les manda como parámetro el tipo de problema. 
		var XCSP3Generator xcsp3= new XCSP3Generator (modelName,  typeOfProblem)
		xcsp3.parseModel(model)
		
	}
	
	/**
	 * Method to determine the type of the constraints 
	 * If there are one constraint that cannot be mapped into a boolean
	 * constraint, then the method returns CSP. 
	 * @param model
	 * @return TypeOfProblem (CSP, SAT)
	 */
	def typeOfConstraints(Model model){
		for (cons: model.constraints ){
			// Integer constraints may appear in structural relations
			if (cons.exp instanceof Structural){
				val min = (cons.exp as Structural).min
				val max=  (cons.exp as Structural).max
				// the constraint has a cardinality
				if (min !==null && max !==null){
					if  (!(min.value==0 && max.value >=1) && !(min.value ==1 && max.value==1)) {
						return TypeOfProblem.CSP		
					}
				}
			}
		}
		// if the loop is finished, then the problem does not have constraint 
		// with non boolean cardinalities
		return  TypeOfProblem.SAT;
	}
	
	/**
	 * Method to determine the type of the variables 
	 * If there are one variable that cannot be mapped into a boolean
	 * variable, then the method returns CSP. 
	 * @param model
	 * @return TypeOfProblem (CSP, SAT)
	 */
	def typeOfVariables(Model model){
		var isInstanciable= false
		var isInteger= false
		for (variable: model.vars ){
			// a variable is instantiable if it contains a cardinality declaration
			if (variable.min!==null && variable.max!==null){
				isInstanciable=true
			}
			// a variable is integer if its type is integer
			if (variable.type=="integer"){
				isInteger=true
			}
			//if the problem contains either one instantiable or one integer variable
			// is a CSP
			if (isInstanciable || isInteger){
				return TypeOfProblem.CSP
			}
		}
		// if the loop is finished, then the problem does not have instantiable or 
		// integer variables, therefore it may be translated into a SAT
		return  TypeOfProblem.SAT;
	}
	
	
}
