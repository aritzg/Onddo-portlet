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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.sareweb.onddo.model.Picking;
import net.sareweb.onddo.model.PickingModel;
import net.sareweb.onddo.model.PickingSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the Picking service. Represents a row in the &quot;Onddo_Picking&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.sareweb.onddo.model.PickingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PickingImpl}.
 * </p>
 *
 * @author A.Galdos
 * @see PickingImpl
 * @see net.sareweb.onddo.model.Picking
 * @see net.sareweb.onddo.model.PickingModel
 * @generated
 */
@JSON(strict = true)
public class PickingModelImpl extends BaseModelImpl<Picking>
	implements PickingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a picking model instance should use the {@link net.sareweb.onddo.model.Picking} interface instead.
	 */
	public static final String TABLE_NAME = "Onddo_Picking";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pickingId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "type_", Types.VARCHAR },
			{ "lat", Types.DOUBLE },
			{ "lng", Types.DOUBLE },
			{ "moonPhase", Types.VARCHAR },
			{ "weather", Types.VARCHAR },
			{ "temperature", Types.DOUBLE },
			{ "humidity", Types.DOUBLE },
			{ "imgId", Types.BIGINT },
			{ "imgName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Onddo_Picking (pickingId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,type_ VARCHAR(75) null,lat DOUBLE,lng DOUBLE,moonPhase VARCHAR(75) null,weather VARCHAR(75) null,temperature DOUBLE,humidity DOUBLE,imgId LONG,imgName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Onddo_Picking";
	public static final String ORDER_BY_JPQL = " ORDER BY picking.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Onddo_Picking.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.sareweb.onddo.model.Picking"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.sareweb.onddo.model.Picking"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.net.sareweb.onddo.model.Picking"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Picking toModel(PickingSoap soapModel) {
		Picking model = new PickingImpl();

		model.setPickingId(soapModel.getPickingId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setType(soapModel.getType());
		model.setLat(soapModel.getLat());
		model.setLng(soapModel.getLng());
		model.setMoonPhase(soapModel.getMoonPhase());
		model.setWeather(soapModel.getWeather());
		model.setTemperature(soapModel.getTemperature());
		model.setHumidity(soapModel.getHumidity());
		model.setImgId(soapModel.getImgId());
		model.setImgName(soapModel.getImgName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Picking> toModels(PickingSoap[] soapModels) {
		List<Picking> models = new ArrayList<Picking>(soapModels.length);

		for (PickingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.sareweb.onddo.model.Picking"));

	public PickingModelImpl() {
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

	public Class<?> getModelClass() {
		return Picking.class;
	}

	public String getModelClassName() {
		return Picking.class.getName();
	}

	@JSON
	public long getPickingId() {
		return _pickingId;
	}

	public void setPickingId(long pickingId) {
		_pickingId = pickingId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_type = type;
	}

	@JSON
	public double getLat() {
		return _lat;
	}

	public void setLat(double lat) {
		_lat = lat;
	}

	@JSON
	public double getLng() {
		return _lng;
	}

	public void setLng(double lng) {
		_lng = lng;
	}

	@JSON
	public String getMoonPhase() {
		if (_moonPhase == null) {
			return StringPool.BLANK;
		}
		else {
			return _moonPhase;
		}
	}

	public void setMoonPhase(String moonPhase) {
		_moonPhase = moonPhase;
	}

	@JSON
	public String getWeather() {
		if (_weather == null) {
			return StringPool.BLANK;
		}
		else {
			return _weather;
		}
	}

	public void setWeather(String weather) {
		_weather = weather;
	}

	@JSON
	public double getTemperature() {
		return _temperature;
	}

	public void setTemperature(double temperature) {
		_temperature = temperature;
	}

	@JSON
	public double getHumidity() {
		return _humidity;
	}

	public void setHumidity(double humidity) {
		_humidity = humidity;
	}

	@JSON
	public long getImgId() {
		return _imgId;
	}

	public void setImgId(long imgId) {
		_imgId = imgId;
	}

	@JSON
	public String getImgName() {
		if (_imgName == null) {
			return StringPool.BLANK;
		}
		else {
			return _imgName;
		}
	}

	public void setImgName(String imgName) {
		_imgName = imgName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Picking toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Picking)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Picking.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		PickingImpl pickingImpl = new PickingImpl();

		pickingImpl.setPickingId(getPickingId());
		pickingImpl.setCompanyId(getCompanyId());
		pickingImpl.setUserId(getUserId());
		pickingImpl.setCreateDate(getCreateDate());
		pickingImpl.setModifiedDate(getModifiedDate());
		pickingImpl.setType(getType());
		pickingImpl.setLat(getLat());
		pickingImpl.setLng(getLng());
		pickingImpl.setMoonPhase(getMoonPhase());
		pickingImpl.setWeather(getWeather());
		pickingImpl.setTemperature(getTemperature());
		pickingImpl.setHumidity(getHumidity());
		pickingImpl.setImgId(getImgId());
		pickingImpl.setImgName(getImgName());

		pickingImpl.resetOriginalValues();

		return pickingImpl;
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

		Picking picking = null;

		try {
			picking = (Picking)obj;
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
	public void resetOriginalValues() {
		PickingModelImpl pickingModelImpl = this;

		pickingModelImpl._originalUserId = pickingModelImpl._userId;

		pickingModelImpl._setOriginalUserId = false;

		pickingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Picking> toCacheModel() {
		PickingCacheModel pickingCacheModel = new PickingCacheModel();

		pickingCacheModel.pickingId = getPickingId();

		pickingCacheModel.companyId = getCompanyId();

		pickingCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			pickingCacheModel.createDate = createDate.getTime();
		}
		else {
			pickingCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			pickingCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			pickingCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		pickingCacheModel.type = getType();

		String type = pickingCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			pickingCacheModel.type = null;
		}

		pickingCacheModel.lat = getLat();

		pickingCacheModel.lng = getLng();

		pickingCacheModel.moonPhase = getMoonPhase();

		String moonPhase = pickingCacheModel.moonPhase;

		if ((moonPhase != null) && (moonPhase.length() == 0)) {
			pickingCacheModel.moonPhase = null;
		}

		pickingCacheModel.weather = getWeather();

		String weather = pickingCacheModel.weather;

		if ((weather != null) && (weather.length() == 0)) {
			pickingCacheModel.weather = null;
		}

		pickingCacheModel.temperature = getTemperature();

		pickingCacheModel.humidity = getHumidity();

		pickingCacheModel.imgId = getImgId();

		pickingCacheModel.imgName = getImgName();

		String imgName = pickingCacheModel.imgName;

		if ((imgName != null) && (imgName.length() == 0)) {
			pickingCacheModel.imgName = null;
		}

		return pickingCacheModel;
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

	private static ClassLoader _classLoader = Picking.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Picking.class
		};
	private long _pickingId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
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
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Picking _escapedModelProxy;
}