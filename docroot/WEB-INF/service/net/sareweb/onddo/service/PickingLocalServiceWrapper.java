/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.sareweb.onddo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PickingLocalService}.
 * </p>
 *
 * @author    A.Galdos
 * @see       PickingLocalService
 * @generated
 */
public class PickingLocalServiceWrapper implements PickingLocalService,
	ServiceWrapper<PickingLocalService> {
	public PickingLocalServiceWrapper(PickingLocalService pickingLocalService) {
		_pickingLocalService = pickingLocalService;
	}

	/**
	* Adds the picking to the database. Also notifies the appropriate model listeners.
	*
	* @param picking the picking
	* @return the picking that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking addPicking(
		net.sareweb.onddo.model.Picking picking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.addPicking(picking);
	}

	/**
	* Creates a new picking with the primary key. Does not add the picking to the database.
	*
	* @param pickingId the primary key for the new picking
	* @return the new picking
	*/
	public net.sareweb.onddo.model.Picking createPicking(long pickingId) {
		return _pickingLocalService.createPicking(pickingId);
	}

	/**
	* Deletes the picking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pickingId the primary key of the picking
	* @throws PortalException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePicking(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pickingLocalService.deletePicking(pickingId);
	}

	/**
	* Deletes the picking from the database. Also notifies the appropriate model listeners.
	*
	* @param picking the picking
	* @throws SystemException if a system exception occurred
	*/
	public void deletePicking(net.sareweb.onddo.model.Picking picking)
		throws com.liferay.portal.kernel.exception.SystemException {
		_pickingLocalService.deletePicking(picking);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.sareweb.onddo.model.Picking fetchPicking(long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.fetchPicking(pickingId);
	}

	/**
	* Returns the picking with the primary key.
	*
	* @param pickingId the primary key of the picking
	* @return the picking
	* @throws PortalException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking getPicking(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.getPicking(pickingId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the pickings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pickings
	* @param end the upper bound of the range of pickings (not inclusive)
	* @return the range of pickings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.onddo.model.Picking> getPickings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.getPickings(start, end);
	}

	/**
	* Returns the number of pickings.
	*
	* @return the number of pickings
	* @throws SystemException if a system exception occurred
	*/
	public int getPickingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.getPickingsCount();
	}

	/**
	* Updates the picking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param picking the picking
	* @return the picking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking updatePicking(
		net.sareweb.onddo.model.Picking picking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.updatePicking(picking);
	}

	/**
	* Updates the picking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param picking the picking
	* @param merge whether to merge the picking with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the picking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking updatePicking(
		net.sareweb.onddo.model.Picking picking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingLocalService.updatePicking(picking, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _pickingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pickingLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PickingLocalService getWrappedPickingLocalService() {
		return _pickingLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPickingLocalService(
		PickingLocalService pickingLocalService) {
		_pickingLocalService = pickingLocalService;
	}

	public PickingLocalService getWrappedService() {
		return _pickingLocalService;
	}

	public void setWrappedService(PickingLocalService pickingLocalService) {
		_pickingLocalService = pickingLocalService;
	}

	private PickingLocalService _pickingLocalService;
}