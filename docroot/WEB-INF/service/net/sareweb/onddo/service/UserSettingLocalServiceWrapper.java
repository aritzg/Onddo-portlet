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
 * This class is a wrapper for {@link UserSettingLocalService}.
 * </p>
 *
 * @author    A.Galdos
 * @see       UserSettingLocalService
 * @generated
 */
public class UserSettingLocalServiceWrapper implements UserSettingLocalService,
	ServiceWrapper<UserSettingLocalService> {
	public UserSettingLocalServiceWrapper(
		UserSettingLocalService userSettingLocalService) {
		_userSettingLocalService = userSettingLocalService;
	}

	/**
	* Adds the user setting to the database. Also notifies the appropriate model listeners.
	*
	* @param userSetting the user setting
	* @return the user setting that was added
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting addUserSetting(
		net.sareweb.onddo.model.UserSetting userSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.addUserSetting(userSetting);
	}

	/**
	* Creates a new user setting with the primary key. Does not add the user setting to the database.
	*
	* @param userSettingId the primary key for the new user setting
	* @return the new user setting
	*/
	public net.sareweb.onddo.model.UserSetting createUserSetting(
		long userSettingId) {
		return _userSettingLocalService.createUserSetting(userSettingId);
	}

	/**
	* Deletes the user setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSettingId the primary key of the user setting
	* @throws PortalException if a user setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserSetting(long userSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userSettingLocalService.deleteUserSetting(userSettingId);
	}

	/**
	* Deletes the user setting from the database. Also notifies the appropriate model listeners.
	*
	* @param userSetting the user setting
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserSetting(
		net.sareweb.onddo.model.UserSetting userSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSettingLocalService.deleteUserSetting(userSetting);
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
		return _userSettingLocalService.dynamicQuery(dynamicQuery);
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
		return _userSettingLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userSettingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _userSettingLocalService.dynamicQueryCount(dynamicQuery);
	}

	public net.sareweb.onddo.model.UserSetting fetchUserSetting(
		long userSettingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.fetchUserSetting(userSettingId);
	}

	/**
	* Returns the user setting with the primary key.
	*
	* @param userSettingId the primary key of the user setting
	* @return the user setting
	* @throws PortalException if a user setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting getUserSetting(
		long userSettingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.getUserSetting(userSettingId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user settings
	* @param end the upper bound of the range of user settings (not inclusive)
	* @return the range of user settings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.onddo.model.UserSetting> getUserSettings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.getUserSettings(start, end);
	}

	/**
	* Returns the number of user settings.
	*
	* @return the number of user settings
	* @throws SystemException if a system exception occurred
	*/
	public int getUserSettingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.getUserSettingsCount();
	}

	/**
	* Updates the user setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSetting the user setting
	* @return the user setting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting updateUserSetting(
		net.sareweb.onddo.model.UserSetting userSetting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.updateUserSetting(userSetting);
	}

	/**
	* Updates the user setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSetting the user setting
	* @param merge whether to merge the user setting with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user setting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting updateUserSetting(
		net.sareweb.onddo.model.UserSetting userSetting, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSettingLocalService.updateUserSetting(userSetting, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userSettingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSettingLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserSettingLocalService getWrappedUserSettingLocalService() {
		return _userSettingLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserSettingLocalService(
		UserSettingLocalService userSettingLocalService) {
		_userSettingLocalService = userSettingLocalService;
	}

	public UserSettingLocalService getWrappedService() {
		return _userSettingLocalService;
	}

	public void setWrappedService(
		UserSettingLocalService userSettingLocalService) {
		_userSettingLocalService = userSettingLocalService;
	}

	private UserSettingLocalService _userSettingLocalService;
}