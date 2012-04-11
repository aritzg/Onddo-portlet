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
 * This class is used by SOAP remote services, specifically {@link net.sareweb.onddo.service.http.PickingServiceSoap}.
 *
 * @author    A.Galdos
 * @see       net.sareweb.onddo.service.http.PickingServiceSoap
 * @generated
 */
public class PickingSoap implements Serializable {
	public static PickingSoap toSoapModel(Picking model) {
		PickingSoap soapModel = new PickingSoap();

		soapModel.setPickingId(model.getPickingId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setLat(model.getLat());
		soapModel.setLng(model.getLng());
		soapModel.setMoonPhase(model.getMoonPhase());
		soapModel.setWeather(model.getWeather());
		soapModel.setTemperature(model.getTemperature());
		soapModel.setHumidity(model.getHumidity());
		soapModel.setImgId(model.getImgId());
		soapModel.setImgName(model.getImgName());

		return soapModel;
	}

	public static PickingSoap[] toSoapModels(Picking[] models) {
		PickingSoap[] soapModels = new PickingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PickingSoap[][] toSoapModels(Picking[][] models) {
		PickingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PickingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PickingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PickingSoap[] toSoapModels(List<Picking> models) {
		List<PickingSoap> soapModels = new ArrayList<PickingSoap>(models.size());

		for (Picking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PickingSoap[soapModels.size()]);
	}

	public PickingSoap() {
	}

	public long getPrimaryKey() {
		return _pickingId;
	}

	public void setPrimaryKey(long pk) {
		setPickingId(pk);
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

	private long _pickingId;
	private long _companyId;
	private long _userId;
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