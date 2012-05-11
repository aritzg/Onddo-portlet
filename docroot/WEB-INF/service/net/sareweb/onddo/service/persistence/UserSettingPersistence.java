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

package net.sareweb.onddo.service.persistence;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import net.sareweb.onddo.model.UserSetting;

/**
 * The persistence interface for the user setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author A.Galdos
 * @see UserSettingPersistenceImpl
 * @see UserSettingUtil
 * @generated
 */
public interface UserSettingPersistence extends BasePersistence<UserSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSettingUtil} to access the user setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user setting in the entity cache if it is enabled.
	*
	* @param userSetting the user setting
	*/
	public void cacheResult(net.sareweb.onddo.model.UserSetting userSetting);

	/**
	* Caches the user settings in the entity cache if it is enabled.
	*
	* @param userSettings the user settings
	*/
	public void cacheResult(
		java.util.List<net.sareweb.onddo.model.UserSetting> userSettings);

	/**
	* Creates a new user setting with the primary key. Does not add the user setting to the database.
	*
	* @param userSettingId the primary key for the new user setting
	* @return the new user setting
	*/
	public net.sareweb.onddo.model.UserSetting create(long userSettingId);

	/**
	* Removes the user setting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSettingId the primary key of the user setting
	* @return the user setting that was removed
	* @throws net.sareweb.onddo.NoSuchUserSettingException if a user setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting remove(long userSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchUserSettingException;

	public net.sareweb.onddo.model.UserSetting updateImpl(
		net.sareweb.onddo.model.UserSetting userSetting, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user setting with the primary key or throws a {@link net.sareweb.onddo.NoSuchUserSettingException} if it could not be found.
	*
	* @param userSettingId the primary key of the user setting
	* @return the user setting
	* @throws net.sareweb.onddo.NoSuchUserSettingException if a user setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting findByPrimaryKey(
		long userSettingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchUserSettingException;

	/**
	* Returns the user setting with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSettingId the primary key of the user setting
	* @return the user setting, or <code>null</code> if a user setting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting fetchByPrimaryKey(
		long userSettingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user setting where userId = &#63; or throws a {@link net.sareweb.onddo.NoSuchUserSettingException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user setting
	* @throws net.sareweb.onddo.NoSuchUserSettingException if a matching user setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchUserSettingException;

	/**
	* Returns the user setting where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user setting, or <code>null</code> if a matching user setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user setting where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user setting, or <code>null</code> if a matching user setting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.UserSetting fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user settings.
	*
	* @return the user settings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.onddo.model.UserSetting> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.onddo.model.UserSetting> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user settings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user settings
	* @param end the upper bound of the range of user settings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user settings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.onddo.model.UserSetting> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user setting where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchUserSettingException;

	/**
	* Removes all the user settings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user settings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user settings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user settings.
	*
	* @return the number of user settings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public UserSetting remove(UserSetting userSetting)
		throws SystemException;
}