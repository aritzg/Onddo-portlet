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

import net.sareweb.onddo.service.PickingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author A.Galdos
 */
public class PickingClp extends BaseModelImpl<Picking> implements Picking {
	public PickingClp() {
	}

	public Class<?> getModelClass() {
		return Picking.class;
	}

	public String getModelClassName() {
		return Picking.class.getName();
	}

	public long getPrimaryKey() {
		return _pickingId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPickingId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pickingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getPickingId() {
		return _pickingId;
	}

	public void setPickingId(long pickingId) {
		_pickingId = pickingId;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public double getLat() {
		return _lat;
	}

	public void setLat(double lat) {
		_lat = lat;
	}

	public double getLng() {
		return _lng;
	}

	public void setLng(double lng) {
		_lng = lng;
	}

	public String getMoonPhase() {
		return _moonPhase;
	}

	public void setMoonPhase(String moonPhase) {
		_moonPhase = moonPhase;
	}

	public String getWeather() {
		return _weather;
	}

	public void setWeather(String weather) {
		_weather = weather;
	}

	public double getTemperature() {
		return _temperature;
	}

	public void setTemperature(double temperature) {
		_temperature = temperature;
	}

	public double getHumidity() {
		return _humidity;
	}

	public void setHumidity(double humidity) {
		_humidity = humidity;
	}

	public long getImgId() {
		return _imgId;
	}

	public void setImgId(long imgId) {
		_imgId = imgId;
	}

	public String getImgName() {
		return _imgName;
	}

	public void setImgName(String imgName) {
		_imgName = imgName;
	}

	public void persist() throws SystemException {
		PickingLocalServiceUtil.updatePicking(this);
	}

	@Override
	public Picking toEscapedModel() {
		return (Picking)Proxy.newProxyInstance(Picking.class.getClassLoader(),
			new Class[] { Picking.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PickingClp clone = new PickingClp();

		clone.setPickingId(getPickingId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setType(getType());
		clone.setLat(getLat());
		clone.setLng(getLng());
		clone.setMoonPhase(getMoonPhase());
		clone.setWeather(getWeather());
		clone.setTemperature(getTemperature());
		clone.setHumidity(getHumidity());
		clone.setImgId(getImgId());
		clone.setImgName(getImgName());

		return clone;
	}

	public int compareTo(Picking picking) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), picking.getCreateDate());

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

		PickingClp picking = null;

		try {
			picking = (PickingClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = picking.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{pickingId=");
		sb.append(getPickingId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", lat=");
		sb.append(getLat());
		sb.append(", lng=");
		sb.append(getLng());
		sb.append(", moonPhase=");
		sb.append(getMoonPhase());
		sb.append(", weather=");
		sb.append(getWeather());
		sb.append(", temperature=");
		sb.append(getTemperature());
		sb.append(", humidity=");
		sb.append(getHumidity());
		sb.append(", imgId=");
		sb.append(getImgId());
		sb.append(", imgName=");
		sb.append(getImgName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("net.sareweb.onddo.model.Picking");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pickingId</column-name><column-value><![CDATA[");
		sb.append(getPickingId());
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
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lat</column-name><column-value><![CDATA[");
		sb.append(getLat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lng</column-name><column-value><![CDATA[");
		sb.append(getLng());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moonPhase</column-name><column-value><![CDATA[");
		sb.append(getMoonPhase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weather</column-name><column-value><![CDATA[");
		sb.append(getWeather());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>temperature</column-name><column-value><![CDATA[");
		sb.append(getTemperature());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>humidity</column-name><column-value><![CDATA[");
		sb.append(getHumidity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imgId</column-name><column-value><![CDATA[");
		sb.append(getImgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imgName</column-name><column-value><![CDATA[");
		sb.append(getImgName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pickingId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private double _lat;
	private double _lng;
	private String _moonPhase;
	private String _weather;
	private double _temperature;
	private double _humidity;
	private long _imgId;
	private String _imgName;
}