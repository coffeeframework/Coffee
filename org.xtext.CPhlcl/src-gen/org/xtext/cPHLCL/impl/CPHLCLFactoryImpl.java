/**
 * generated by Xtext 2.12.0
 */
package org.xtext.cPHLCL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.cPHLCL.Arithmetic;
import org.xtext.cPHLCL.Bool;
import org.xtext.cPHLCL.BoolExpression;
import org.xtext.cPHLCL.BoolVar;
import org.xtext.cPHLCL.CPHLCLFactory;
import org.xtext.cPHLCL.CPHLCLPackage;
import org.xtext.cPHLCL.ComplexTerm;
import org.xtext.cPHLCL.Constraint;
import org.xtext.cPHLCL.Control;
import org.xtext.cPHLCL.DomainDeclaration;
import org.xtext.cPHLCL.Enumeration;
import org.xtext.cPHLCL.Expression;
import org.xtext.cPHLCL.Global;
import org.xtext.cPHLCL.IntVar;
import org.xtext.cPHLCL.Interval;
import org.xtext.cPHLCL.ListOfEnumerables;
import org.xtext.cPHLCL.ListOfIDs;
import org.xtext.cPHLCL.ListOfValues;
import org.xtext.cPHLCL.Logic;
import org.xtext.cPHLCL.LogicUn;
import org.xtext.cPHLCL.Model;
import org.xtext.cPHLCL.NumExpression;
import org.xtext.cPHLCL.Relational;
import org.xtext.cPHLCL.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CPHLCLFactoryImpl extends EFactoryImpl implements CPHLCLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CPHLCLFactory init()
  {
    try
    {
      CPHLCLFactory theCPHLCLFactory = (CPHLCLFactory)EPackage.Registry.INSTANCE.getEFactory(CPHLCLPackage.eNS_URI);
      if (theCPHLCLFactory != null)
      {
        return theCPHLCLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CPHLCLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPHLCLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case CPHLCLPackage.MODEL: return createModel();
      case CPHLCLPackage.VAR_DECLARATION: return createVarDeclaration();
      case CPHLCLPackage.DOMAIN_DECLARATION: return createDomainDeclaration();
      case CPHLCLPackage.INTERVAL: return createInterval();
      case CPHLCLPackage.ENUMERATION: return createEnumeration();
      case CPHLCLPackage.CONSTRAINT: return createConstraint();
      case CPHLCLPackage.EXPRESSION: return createExpression();
      case CPHLCLPackage.BOOL_EXPRESSION: return createBoolExpression();
      case CPHLCLPackage.COMPLEX_TERM: return createComplexTerm();
      case CPHLCLPackage.LOGIC: return createLogic();
      case CPHLCLPackage.LOGIC_UN: return createLogicUn();
      case CPHLCLPackage.RELATIONAL: return createRelational();
      case CPHLCLPackage.NUM_EXPRESSION: return createNumExpression();
      case CPHLCLPackage.ARITHMETIC: return createArithmetic();
      case CPHLCLPackage.GLOBAL: return createGlobal();
      case CPHLCLPackage.CONTROL: return createControl();
      case CPHLCLPackage.BOOL: return createBool();
      case CPHLCLPackage.BOOL_VAR: return createBoolVar();
      case CPHLCLPackage.NUMBER: return createNumber();
      case CPHLCLPackage.INT_VAR: return createIntVar();
      case CPHLCLPackage.LIST_OF_VALUES: return createListOfValues();
      case CPHLCLPackage.LIST_OF_ENUMERABLES: return createListOfEnumerables();
      case CPHLCLPackage.LIST_OF_IDS: return createListOfIDs();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDeclaration createVarDeclaration()
  {
    VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
    return varDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainDeclaration createDomainDeclaration()
  {
    DomainDeclarationImpl domainDeclaration = new DomainDeclarationImpl();
    return domainDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Interval createInterval()
  {
    IntervalImpl interval = new IntervalImpl();
    return interval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumeration createEnumeration()
  {
    EnumerationImpl enumeration = new EnumerationImpl();
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpression createBoolExpression()
  {
    BoolExpressionImpl boolExpression = new BoolExpressionImpl();
    return boolExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexTerm createComplexTerm()
  {
    ComplexTermImpl complexTerm = new ComplexTermImpl();
    return complexTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Logic createLogic()
  {
    LogicImpl logic = new LogicImpl();
    return logic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicUn createLogicUn()
  {
    LogicUnImpl logicUn = new LogicUnImpl();
    return logicUn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relational createRelational()
  {
    RelationalImpl relational = new RelationalImpl();
    return relational;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumExpression createNumExpression()
  {
    NumExpressionImpl numExpression = new NumExpressionImpl();
    return numExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arithmetic createArithmetic()
  {
    ArithmeticImpl arithmetic = new ArithmeticImpl();
    return arithmetic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Global createGlobal()
  {
    GlobalImpl global = new GlobalImpl();
    return global;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Control createControl()
  {
    ControlImpl control = new ControlImpl();
    return control;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bool createBool()
  {
    BoolImpl bool = new BoolImpl();
    return bool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolVar createBoolVar()
  {
    BoolVarImpl boolVar = new BoolVarImpl();
    return boolVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.xtext.cPHLCL.Number createNumber()
  {
    NumberImpl number = new NumberImpl();
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntVar createIntVar()
  {
    IntVarImpl intVar = new IntVarImpl();
    return intVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfValues createListOfValues()
  {
    ListOfValuesImpl listOfValues = new ListOfValuesImpl();
    return listOfValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfEnumerables createListOfEnumerables()
  {
    ListOfEnumerablesImpl listOfEnumerables = new ListOfEnumerablesImpl();
    return listOfEnumerables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListOfIDs createListOfIDs()
  {
    ListOfIDsImpl listOfIDs = new ListOfIDsImpl();
    return listOfIDs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CPHLCLPackage getCPHLCLPackage()
  {
    return (CPHLCLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CPHLCLPackage getPackage()
  {
    return CPHLCLPackage.eINSTANCE;
  }

} //CPHLCLFactoryImpl
