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

package net.sareweb.onddo.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.sareweb.onddo.model.UserSetting;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserSetting in entity cache.
 *
 * @author A.Galdos
 * @see UserSetting
 * @generated
 */
public class UserSettingCacheModel implements CacheModel<UserSetting>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userSettingId=");
		sb.append(userSettingId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", visibilityToFriends=");
		sb.append(visibilityToFriends);
		sb.append(", visibilityToOthers=");
		sb.append(visibilityToOthers);
		sb.append(", tweetPicking=");
		sb.append(tweetPicking);
		sb.append("}");

		return sb.toString();
	}

	public UserSetting toEntityModel() {
		UserSettingImpl userSettingImpl = new UserSettingImpl();

		userSettingImpl.setUserSettingId(userSettingId);
		userSettingImpl.setCompanyId(companyId);
		userSettingImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			userSettingImpl.setCreateDate(null);
		}
		else {
			userSettingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userSettingImpl.setModifiedDate(null);
		}
		else {
			userSettingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (visibilityToFriends == null) {
			userSettingImpl.setVisibilityToFriends(StringPool.BLANK);
		}
		else {
			userSettingImpl.setVisibilityToFriends(visibilityToFriends);
		}

		if (visibilityToOthers == null) {
			userSettingImpl.setVisibilityToOthers(StringPool.BLANK);
		}
		else {
			userSettingImpl.setVisibilityToOthers(visibilityToOthers);
		}

		userSettingImpl.setTweetPicking(tweetPicking);

		userSettingImpl.resetOriginalValues();

		return userSettingImpl;
	}

	public long userSettingId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String visibilityToFriends;
	public String visibilityToOthers;
	public boolean tweetPicking;
}