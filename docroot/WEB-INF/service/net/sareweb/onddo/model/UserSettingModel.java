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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserSetting service. Represents a row in the &quot;Onddo_UserSetting&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.sareweb.onddo.model.impl.UserSettingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.sareweb.onddo.model.impl.UserSettingImpl}.
 * </p>
 *
 * @author A.Galdos
 * @see UserSetting
 * @see net.sareweb.onddo.model.impl.UserSettingImpl
 * @see net.sareweb.onddo.model.impl.UserSettingModelImpl
 * @generated
 */
public interface UserSettingModel extends BaseModel<UserSetting> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user setting model instance should use the {@link UserSetting} interface instead.
	 */

	/**
	 * Returns the primary key of this user setting.
	 *
	 * @return the primary key of this user setting
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user setting.
	 *
	 * @param primaryKey the primary key of this user setting
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user setting ID of this user setting.
	 *
	 * @return the user setting ID of this user setting
	 */
	public long getUserSettingId();

	/**
	 * Sets the user setting ID of this user setting.
	 *
	 * @param userSettingId the user setting ID of this user setting
	 */
	public void setUserSettingId(long userSettingId);

	/**
	 * Returns the company ID of this user setting.
	 *
	 * @return the company ID of this user setting
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this user setting.
	 *
	 * @param companyId the company ID of this user setting
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this user setting.
	 *
	 * @return the user ID of this user setting
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user setting.
	 *
	 * @param userId the user ID of this user setting
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user setting.
	 *
	 * @return the user uuid of this user setting
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user setting.
	 *
	 * @param userUuid the user uuid of this user setting
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this user setting.
	 *
	 * @return the create date of this user setting
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user setting.
	 *
	 * @param createDate the create date of this user setting
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this user setting.
	 *
	 * @return the modified date of this user setting
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this user setting.
	 *
	 * @param modifiedDate the modified date of this user setting
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the visibility to friends of this user setting.
	 *
	 * @return the visibility to friends of this user setting
	 */
	@AutoEscape
	public String getVisibilityToFriends();

	/**
	 * Sets the visibility to friends of this user setting.
	 *
	 * @param visibilityToFriends the visibility to friends of this user setting
	 */
	public void setVisibilityToFriends(String visibilityToFriends);

	/**
	 * Returns the visibility to others of this user setting.
	 *
	 * @return the visibility to others of this user setting
	 */
	@AutoEscape
	public String getVisibilityToOthers();

	/**
	 * Sets the visibility to others of this user setting.
	 *
	 * @param visibilityToOthers the visibility to others of this user setting
	 */
	public void setVisibilityToOthers(String visibilityToOthers);

	/**
	 * Returns the tweet picking of this user setting.
	 *
	 * @return the tweet picking of this user setting
	 */
	public boolean getTweetPicking();

	/**
	 * Returns <code>true</code> if this user setting is tweet picking.
	 *
	 * @return <code>true</code> if this user setting is tweet picking; <code>false</code> otherwise
	 */
	public boolean isTweetPicking();

	/**
	 * Sets whether this user setting is tweet picking.
	 *
	 * @param tweetPicking the tweet picking of this user setting
	 */
	public void setTweetPicking(boolean tweetPicking);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(UserSetting userSetting);

	public int hashCode();

	public CacheModel<UserSetting> toCacheModel();

	public UserSetting toEscapedModel();

	public String toString();

	public String toXmlString();
}