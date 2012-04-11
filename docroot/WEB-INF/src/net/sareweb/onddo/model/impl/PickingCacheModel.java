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

import net.sareweb.onddo.model.Picking;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Picking in entity cache.
 *
 * @author A.Galdos
 * @see Picking
 * @generated
 */
public class PickingCacheModel implements CacheModel<Picking>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{pickingId=");
		sb.append(pickingId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", type=");
		sb.append(type);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", lng=");
		sb.append(lng);
		sb.append(", moonPhase=");
		sb.append(moonPhase);
		sb.append(", weather=");
		sb.append(weather);
		sb.append(", temperature=");
		sb.append(temperature);
		sb.append(", humidity=");
		sb.append(humidity);
		sb.append(", imgId=");
		sb.append(imgId);
		sb.append(", imgName=");
		sb.append(imgName);
		sb.append("}");

		return sb.toString();
	}

	public Picking toEntityModel() {
		PickingImpl pickingImpl = new PickingImpl();

		pickingImpl.setPickingId(pickingId);
		pickingImpl.setCompanyId(companyId);
		pickingImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			pickingImpl.setCreateDate(null);
		}
		else {
			pickingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pickingImpl.setModifiedDate(null);
		}
		else {
			pickingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			pickingImpl.setType(StringPool.BLANK);
		}
		else {
			pickingImpl.setType(type);
		}

		pickingImpl.setLat(lat);
		pickingImpl.setLng(lng);

		if (moonPhase == null) {
			pickingImpl.setMoonPhase(StringPool.BLANK);
		}
		else {
			pickingImpl.setMoonPhase(moonPhase);
		}

		if (weather == null) {
			pickingImpl.setWeather(StringPool.BLANK);
		}
		else {
			pickingImpl.setWeather(weather);
		}

		pickingImpl.setTemperature(temperature);
		pickingImpl.setHumidity(humidity);
		pickingImpl.setImgId(imgId);

		if (imgName == null) {
			pickingImpl.setImgName(StringPool.BLANK);
		}
		else {
			pickingImpl.setImgName(imgName);
		}

		pickingImpl.resetOriginalValues();

		return pickingImpl;
	}

	public long pickingId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String type;
	public double lat;
	public double lng;
	public String moonPhase;
	public String weather;
	public double temperature;
	public double humidity;
	public long imgId;
	public String imgName;
}