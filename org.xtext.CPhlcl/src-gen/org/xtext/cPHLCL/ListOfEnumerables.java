/**
 * generated by Xtext 2.12.0
 */
package org.xtext.cPHLCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Of Enumerables</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.cPHLCL.ListOfEnumerables#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.xtext.cPHLCL.CPHLCLPackage#getListOfEnumerables()
 * @model
 * @generated
 */
public interface ListOfEnumerables extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.xtext.cPHLCL.CPHLCLPackage#getListOfEnumerables_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

} // ListOfEnumerables
