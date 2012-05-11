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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import net.sareweb.onddo.service.UserSettingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author A.Galdos
 */
public class UserSettingClp extends BaseModelImpl<UserSetting>
	implements UserSetting {
	public UserSettingClp() {
	}

	public Class<?> getModelClass() {
		return UserSetting.class;
	}

	public String getModelClassName() {
		return UserSetting.class.getName();
	}

	public long getPrimaryKey() {
		return _userSettingId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserSettingId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userSettingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getUserSettingId() {
		return _userSettingId;
	}

	public void setUserSettingId(long userSettingId) {
		_userSettingId = userSettingId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getVisibilityToFriends() {
		return _visibilityToFriends;
	}

	public void setVisibilityToFriends(String visibilityToFriends) {
		_visibilityToFriends = visibilityToFriends;
	}

	public String getVisibilityToOthers() {
		return _visibilityToOthers;
	}

	public void setVisibilityToOthers(String visibilityToOthers) {
		_visibilityToOthers = visibilityToOthers;
	}

	public boolean getTweetPicking() {
		return _tweetPicking;
	}

	public boolean isTweetPicking() {
		return _tweetPicking;
	}

	public void setTweetPicking(boolean tweetPicking) {
		_tweetPicking = tweetPicking;
	}

	public void persist() throws SystemException {
		UserSettingLocalServiceUtil.updateUserSetting(this);
	}

	@Override
	public UserSetting toEscapedModel() {
		return (UserSetting)Proxy.newProxyInstance(UserSetting.class.getClassLoader(),
			new Class[] { UserSetting.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserSettingClp clone = new UserSettingClp();

		clone.setUserSettingId(getUserSettingId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVisibilityToFriends(getVisibilityToFriends());
		clone.setVisibilityToOthers(getVisibilityToOthers());
		clone.setTweetPicking(getTweetPicking());

		return clone;
	}

	public int compareTo(UserSetting userSetting) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), userSetting.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserSettingClp userSetting = null;

		try {
			userSetting = (UserSettingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userSetting.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userSettingId=");
		sb.append(getUserSettingId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", visibilityToFriends=");
		sb.append(getVisibilityToFriends());
		sb.append(", visibilityToOthers=");
		sb.append(getVisibilityToOthers());
		sb.append(", tweetPicking=");
		sb.append(getTweetPicking());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.onddo.model.UserSetting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userSettingId</column-name><column-value><![CDATA[");
		sb.append(getUserSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visibilityToFriends</column-name><column-value><![CDATA[");
		sb.append(getVisibilityToFriends());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visibilityToOthers</column-name><column-value><![CDATA[");
		sb.append(getVisibilityToOthers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetPicking</column-name><column-value><![CDATA[");
		sb.append(getTweetPicking());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userSettingId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _visibilityToFriends;
	private String _visibilityToOthers;
	private boolean _tweetPicking;
}