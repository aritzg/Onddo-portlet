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

package net.sareweb.onddo.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserSetting}.
 * </p>
 *
 * @author    A.Galdos
 * @see       UserSetting
 * @generated
 */
public class UserSettingWrapper implements UserSetting,
	ModelWrapper<UserSetting> {
	public UserSettingWrapper(UserSetting userSetting) {
		_userSetting = userSetting;
	}

	public Class<?> getModelClass() {
		return UserSetting.class;
	}

	public String getModelClassName() {
		return UserSetting.class.getName();
	}

	/**
	* Returns the primary key of this user setting.
	*
	* @return the primary key of this user setting
	*/
	public long getPrimaryKey() {
		return _userSetting.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user setting.
	*
	* @param primaryKey the primary key of this user setting
	*/
	public void setPrimaryKey(long primaryKey) {
		_userSetting.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user setting ID of this user setting.
	*
	* @return the user setting ID of this user setting
	*/
	public long getUserSettingId() {
		return _userSetting.getUserSettingId();
	}

	/**
	* Sets the user setting ID of this user setting.
	*
	* @param userSettingId the user setting ID of this user setting
	*/
	public void setUserSettingId(long userSettingId) {
		_userSetting.setUserSettingId(userSettingId);
	}

	/**
	* Returns the company ID of this user setting.
	*
	* @return the company ID of this user setting
	*/
	public long getCompanyId() {
		return _userSetting.getCompanyId();
	}

	/**
	* Sets the company ID of this user setting.
	*
	* @param companyId the company ID of this user setting
	*/
	public void setCompanyId(long companyId) {
		_userSetting.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this user setting.
	*
	* @return the user ID of this user setting
	*/
	public long getUserId() {
		return _userSetting.getUserId();
	}

	/**
	* Sets the user ID of this user setting.
	*
	* @param userId the user ID of this user setting
	*/
	public void setUserId(long userId) {
		_userSetting.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user setting.
	*
	* @return the user uuid of this user setting
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSetting.getUserUuid();
	}

	/**
	* Sets the user uuid of this user setting.
	*
	* @param userUuid the user uuid of this user setting
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userSetting.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this user setting.
	*
	* @return the create date of this user setting
	*/
	public java.util.Date getCreateDate() {
		return _userSetting.getCreateDate();
	}

	/**
	* Sets the create date of this user setting.
	*
	* @param createDate the create date of this user setting
	*/
	public void setCreateDate(java.util.Date createDate) {
		_userSetting.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user setting.
	*
	* @return the modified date of this user setting
	*/
	public java.util.Date getModifiedDate() {
		return _userSetting.getModifiedDate();
	}

	/**
	* Sets the modified date of this user setting.
	*
	* @param modifiedDate the modified date of this user setting
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userSetting.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the visibility to friends of this user setting.
	*
	* @return the visibility to friends of this user setting
	*/
	public java.lang.String getVisibilityToFriends() {
		return _userSetting.getVisibilityToFriends();
	}

	/**
	* Sets the visibility to friends of this user setting.
	*
	* @param visibilityToFriends the visibility to friends of this user setting
	*/
	public void setVisibilityToFriends(java.lang.String visibilityToFriends) {
		_userSetting.setVisibilityToFriends(visibilityToFriends);
	}

	/**
	* Returns the visibility to others of this user setting.
	*
	* @return the visibility to others of this user setting
	*/
	public java.lang.String getVisibilityToOthers() {
		return _userSetting.getVisibilityToOthers();
	}

	/**
	* Sets the visibility to others of this user setting.
	*
	* @param visibilityToOthers the visibility to others of this user setting
	*/
	public void setVisibilityToOthers(java.lang.String visibilityToOthers) {
		_userSetting.setVisibilityToOthers(visibilityToOthers);
	}

	/**
	* Returns the tweet picking of this user setting.
	*
	* @return the tweet picking of this user setting
	*/
	public boolean getTweetPicking() {
		return _userSetting.getTweetPicking();
	}

	/**
	* Returns <code>true</code> if this user setting is tweet picking.
	*
	* @return <code>true</code> if this user setting is tweet picking; <code>false</code> otherwise
	*/
	public boolean isTweetPicking() {
		return _userSetting.isTweetPicking();
	}

	/**
	* Sets whether this user setting is tweet picking.
	*
	* @param tweetPicking the tweet picking of this user setting
	*/
	public void setTweetPicking(boolean tweetPicking) {
		_userSetting.setTweetPicking(tweetPicking);
	}

	public boolean isNew() {
		return _userSetting.isNew();
	}

	public void setNew(boolean n) {
		_userSetting.setNew(n);
	}

	public boolean isCachedModel() {
		return _userSetting.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userSetting.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userSetting.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userSetting.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userSetting.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userSetting.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userSetting.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserSettingWrapper((UserSetting)_userSetting.clone());
	}

	public int compareTo(net.sareweb.onddo.model.UserSetting userSetting) {
		return _userSetting.compareTo(userSetting);
	}

	@Override
	public int hashCode() {
		return _userSetting.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.onddo.model.UserSetting> toCacheModel() {
		return _userSetting.toCacheModel();
	}

	public net.sareweb.onddo.model.UserSetting toEscapedModel() {
		return new UserSettingWrapper(_userSetting.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSetting.toString();
	}

	public java.lang.String toXmlString() {
		return _userSetting.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSetting.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserSetting getWrappedUserSetting() {
		return _userSetting;
	}

	public UserSetting getWrappedModel() {
		return _userSetting;
	}

	public void resetOriginalValues() {
		_userSetting.resetOriginalValues();
	}

	private UserSetting _userSetting;
}