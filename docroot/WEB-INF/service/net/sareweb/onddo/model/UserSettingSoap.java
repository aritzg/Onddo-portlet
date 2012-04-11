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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link net.sareweb.onddo.service.http.UserSettingServiceSoap}.
 *
 * @author    A.Galdos
 * @see       net.sareweb.onddo.service.http.UserSettingServiceSoap
 * @generated
 */
public class UserSettingSoap implements Serializable {
	public static UserSettingSoap toSoapModel(UserSetting model) {
		UserSettingSoap soapModel = new UserSettingSoap();

		soapModel.setUserSettingId(model.getUserSettingId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVisibilityToFriends(model.getVisibilityToFriends());
		soapModel.setVisibilityToOthers(model.getVisibilityToOthers());
		soapModel.setTweetPicking(model.getTweetPicking());

		return soapModel;
	}

	public static UserSettingSoap[] toSoapModels(UserSetting[] models) {
		UserSettingSoap[] soapModels = new UserSettingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSettingSoap[][] toSoapModels(UserSetting[][] models) {
		UserSettingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSettingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSettingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSettingSoap[] toSoapModels(List<UserSetting> models) {
		List<UserSettingSoap> soapModels = new ArrayList<UserSettingSoap>(models.size());

		for (UserSetting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSettingSoap[soapModels.size()]);
	}

	public UserSettingSoap() {
	}

	public long getPrimaryKey() {
		return _userSettingId;
	}

	public void setPrimaryKey(long pk) {
		setUserSettingId(pk);
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

	private long _userSettingId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _visibilityToFriends;
	private String _visibilityToOthers;
	private boolean _tweetPicking;
}