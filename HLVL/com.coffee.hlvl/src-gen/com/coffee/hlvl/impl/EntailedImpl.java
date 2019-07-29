/**
 * generated by Xtext 2.18.0
 */
package com.coffee.hlvl.impl;

import com.coffee.hlvl.ElmDeclaration;
import com.coffee.hlvl.Entailed;
import com.coffee.hlvl.HlvlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entailed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.coffee.hlvl.impl.EntailedImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntailedImpl extends RelationalImpl implements Entailed
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected ElmDeclaration element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntailedImpl()
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
    return HlvlPackage.Literals.ENTAILED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElmDeclaration getElement()
  {
    if (element != null && element.eIsProxy())
    {
      InternalEObject oldElement = (InternalEObject)element;
      element = (ElmDeclaration)eResolveProxy(oldElement);
      if (element != oldElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HlvlPackage.ENTAILED__ELEMENT, oldElement, element));
      }
    }
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElmDeclaration basicGetElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(ElmDeclaration newElement)
  {
    ElmDeclaration oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HlvlPackage.ENTAILED__ELEMENT, oldElement, element));
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
      case HlvlPackage.ENTAILED__ELEMENT:
        if (resolve) return getElement();
        return basicGetElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HlvlPackage.ENTAILED__ELEMENT:
        setElement((ElmDeclaration)newValue);
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
      case HlvlPackage.ENTAILED__ELEMENT:
        setElement((ElmDeclaration)null);
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
      case HlvlPackage.ENTAILED__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

} //EntailedImpl