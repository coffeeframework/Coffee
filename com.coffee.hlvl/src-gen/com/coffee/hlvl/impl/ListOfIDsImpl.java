/**
 * generated by Xtext 2.12.0
 */
package com.coffee.hlvl.impl;

import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.HlvlPackage;
import com.coffee.hlvl.ListOfIDs;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of IDs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.coffee.hlvl.impl.ListOfIDsImpl#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfIDsImpl extends MinimalEObjectImpl.Container implements ListOfIDs
{
  /**
   * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValues()
   * @generated
   * @ordered
   */
  protected EList<ElmDeclaration> values;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListOfIDsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return HlvlPackage.Literals.LIST_OF_IDS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ElmDeclaration> getValues()
  {
    if (values == null)
    {
      values = new EObjectResolvingEList<ElmDeclaration>(ElmDeclaration.class, this, HlvlPackage.LIST_OF_IDS__VALUES);
    }
    return values;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HlvlPackage.LIST_OF_IDS__VALUES:
        return getValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HlvlPackage.LIST_OF_IDS__VALUES:
        getValues().clear();
        getValues().addAll((Collection<? extends ElmDeclaration>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HlvlPackage.LIST_OF_IDS__VALUES:
        getValues().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HlvlPackage.LIST_OF_IDS__VALUES:
        return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ListOfIDsImpl