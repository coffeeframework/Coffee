package org.xtext.generator;





/**
 * This class contains the Strings included in the generation of 
 * a Java File from the PC-HLCL specification
 * @author Angela Villota
 *
 */
public interface JavaCodeStrings {
	public static final String JAVA_IMPORTS= "import java.util.HashMap;\n"
			+ "import java.util.List;";
	public static final String HLCL_IMPORTS= 
			"import com.variamos.hlcl.core.HlclProgram; "
			+ "\nimport com.variamos.hlcl.model.expressions.HlclFactory; "
			+ "\nimport com.variamos.hlcl.model.domains.BinaryDomain;"
			+ "\nimport com.variamos.hlcl.model.domains.IntervalDomain;"
			+ "\nimport com.variamos.hlcl.model.domains.RangeDomain;"
			+ "\nimport com.variamos.hlcl.model.domains.StringDomain;"
			+ "\nimport com.variamos.hlcl.model.expressions.Identifier;"
			+ "\nimport com.variamos.hlcl.model.expressions.IntBooleanExpression;"
			+ "\nimport com.variamos.hlcl.model.expressions.NumericIdentifier;"
			+ "\nimport com.variamos.hlcl.model.expressions.SymbolicExpression;\n"
			+ "import com.variamos.hlcl.model.expressions.IntNumericExpression;";
	
	public static final String SOLVER_IMPORTS= 
			"import com.variamos.solver.core.SWIPrologSolver;\n"
			+ "import com.variamos.solver.core.compiler.Hlcl2SWIProlog;\n"
			+ "import com.variamos.solver.model.SolverSolution;\n";
	
	public static final String CLASS_JAVADOC=
			"/**\n" + 
			"* This class is automatically generated from a product line model described in \n" + 
			"* constraint programming HLCL\n" + 
			"* @author Angela Villota \n" + 
			"* @version CP-HLCL Version1\n" + 
			"*\n" + 
			"*/";
	public static final String CLASS_DECLARATION="public class";
	public static final String CLASS_ATTRIBUTES=
			"\n" + 
			"private String modelName;\n" + 
			"private HlclFactory factory;\n" + 
			"private HlclProgram hlclProgram;\n" + 
			"private SWIPrologSolver swiSolver;\n" + 
			"private String prologProgram;\n" + 
			"private HashMap<String,IntBooleanExpression> constraints;\n" + 
			"private HashMap<String,Identifier> variables;\n" + 
			"private HashMap<String,NumericIdentifier> numbers;";
	
	public static final String CONSTRUCTOR_JAVADOC= 
			"/**\n" + 
			"* This is an autogenerated method"+
			"* Constructor method\n" + 
			"* @param modelName is the name of the model in the  CP-HLCL specification\n" + 
			"*/"; 
	public static final String CONSTRUCTOR_CODE= 
			"\n" + 
			"this.modelName= modelName;\n" + 
			"hlclProgram= new HlclProgram();\n" + 
			"factory = new HlclFactory();\n" + 
			"variables= new HashMap<String,Identifier>();\n" + 
			"constraints= new HashMap<String,IntBooleanExpression>();\n" + 
			"numbers= new HashMap<String,NumericIdentifier>();\n" + 
			"NumericIdentifier one = factory.number(1);\n" + 
			"NumericIdentifier zero= factory.number(0);\n" + 
			"numbers.put(\"1\", one);\n" + 
			"numbers.put(\"0\", zero);";
	
	public static final String RUN_METHOD=
			"public void run(){\n" + 
			"	// first obtain a HlclProgram from the specification\n" + 
			"	transformVars();\n" + 
			"	transformConstraints(); \n" + 
			"	// use the solver to solve the constraint program\n" + 
			"	evaluateSatisfiability();\n" + 
			"	//show the output\n" + 
			"	System.out.println(prologProgram);\n" + 
			"}"; 

	public static final String EVALUATE_SATISFIABILITY= 
			"public boolean evaluateSatisfiability(){\n" + 
			"	// the output\n" + 
			"	boolean evaluation= false;\n" + 
			"	// //to transform the hllcl program into a prolog  file, \n" + 
			"	// //these lines are commented because they are useful for debugging \n" + 
			"	Hlcl2SWIProlog swiPrologTransformer = new Hlcl2SWIProlog(); \n" + 
			"	prologProgram = swiPrologTransformer.transform(hlclProgram);\n" + 
			"			\n" + 
			"	// an instance of the solver for Swiprolog \n" + 
			"	swiSolver= new SWIPrologSolver();\n" + 
			"	swiSolver.setHLCLProgram(hlclProgram); //passing the hlcl program to the solver\n" + 
			"	swiSolver.solve(); // This methhod prepares the solver \n" + 
			"	List<SolverSolution> solutions = swiSolver.getAllSolutions(); // Consulting if the solver has one solution\n" + 
			"		evaluation= solutions.size()>0;\n" + 
			"		for (SolverSolution solverSolution : solutions) {\n" + 
			"			System.out.println(solverSolution.toString());\n" + 
			"		}"+
			"	return evaluation;\n" + 
			"}";
	
	

	
	public static final String GETTERS_SETTERS= 
			"	public String getModelName() {\n" + 
			"		return modelName;\n" + 
			"	}\n" +  
			"	public void setModelName(String modelName) {\n" + 
			"		this.modelName = modelName;\n" + 
			"	}\n" + 
			"	public HlclFactory getFactory() {\n" + 
			"		return factory;\n" + 
			"	}\n" + 
			"	public void setFactory(HlclFactory factory) {\n" + 
			"		this.factory = factory;\n" + 
			"	}\n" + 
			"	public HlclProgram getHlclProgram() {\n" + 
			"		return hlclProgram;\n" + 
			"	}\n" +  
			"	public void setHlclProgram(HlclProgram hlclProgram) {\n" + 
			"		this.hlclProgram = hlclProgram;\n" + 
			"	}";
	public static final String GET_VALUE_JAVADOC=
			"/** \n"
			+ "* To obtain the NumericIdentifier representation of a value \n"
			+ "* @param id the string with the value \n"
			+ "* @return the NumericIdentifier \n"
			+ "*/";
	public static final String GET_VALUE_CODE=
			"public NumericIdentifier getValue(String id) {"+
			"	NumericIdentifier value= numbers.get(id); \n "+
			"	if (value==null) { \n "+
			"		if (id.equals(\"selected\")) { \n "+
			"			value= numbers.get(\"1\"); \n "+
			"		} \n "+
			"		else if(id.equals(\"unselected\")) {\n"+
			"			value= numbers.get(\"0\"); \n"+
			"		} \n"+
			"		else { \n"+
			"			value= factory.number(Integer.parseInt(id)); \n"+
			"			numbers.put(id, value);\n"+
			"		}\n "+
			"	} \n "+
			"	return value; \n "+
			"} " ;
				


}
