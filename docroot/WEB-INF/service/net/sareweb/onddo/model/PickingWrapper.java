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
 * This class is a wrapper for {@link Picking}.
 * </p>
 *
 * @author    A.Galdos
 * @see       Picking
 * @generated
 */
public class PickingWrapper implements Picking, ModelWrapper<Picking> {
	public PickingWrapper(Picking picking) {
		_picking = picking;
	}

	public Class<?> getModelClass() {
		return Picking.class;
	}

	public String getModelClassName() {
		return Picking.class.getName();
	}

	/**
	* Returns the primary key of this picking.
	*
	* @return the primary key of this picking
	*/
	public long getPrimaryKey() {
		return _picking.getPrimaryKey();
	}

	/**
	* Sets the primary key of this picking.
	*
	* @param primaryKey the primary key of this picking
	*/
	public void setPrimaryKey(long primaryKey) {
		_picking.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the picking ID of this picking.
	*
	* @return the picking ID of this picking
	*/
	public long getPickingId() {
		return _picking.getPickingId();
	}

	/**
	* Sets the picking ID of this picking.
	*
	* @param pickingId the picking ID of this picking
	*/
	public void setPickingId(long pickingId) {
		_picking.setPickingId(pickingId);
	}

	/**
	* Returns the company ID of this picking.
	*
	* @return the company ID of this picking
	*/
	public long getCompanyId() {
		return _picking.getCompanyId();
	}

	/**
	* Sets the company ID of this picking.
	*
	* @param companyId the company ID of this picking
	*/
	public void setCompanyId(long companyId) {
		_picking.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this picking.
	*
	* @return the user ID of this picking
	*/
	public long getUserId() {
		return _picking.getUserId();
	}

	/**
	* Sets the user ID of this picking.
	*
	* @param userId the user ID of this picking
	*/
	public void setUserId(long userId) {
		_picking.setUserId(userId);
	}

	/**
	* Returns the user uuid of this picking.
	*
	* @return the user uuid of this picking
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _picking.getUserUuid();
	}

	/**
	* Sets the user uuid of this picking.
	*
	* @param userUuid the user uuid of this picking
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_picking.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this picking.
	*
	* @return the create date of this picking
	*/
	public java.util.Date getCreateDate() {
		return _picking.getCreateDate();
	}

	/**
	* Sets the create date of this picking.
	*
	* @param createDate the create date of this picking
	*/
	public void setCreateDate(java.util.Date createDate) {
		_picking.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this picking.
	*
	* @return the modified date of this picking
	*/
	public java.util.Date getModifiedDate() {
		return _picking.getModifiedDate();
	}

	/**
	* Sets the modified date of this picking.
	*
	* @param modifiedDate the modified date of this picking
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_picking.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this picking.
	*
	* @return the type of this picking
	*/
	public java.lang.String getType() {
		return _picking.getType();
	}

	/**
	* Sets the type of this picking.
	*
	* @param type the type of this picking
	*/
	public void setType(java.lang.String type) {
		_picking.setType(type);
	}

	/**
	* Returns the lat of this picking.
	*
	* @return the lat of this picking
	*/
	public double getLat() {
		return _picking.getLat();
	}

	/**
	* Sets the lat of this picking.
	*
	* @param lat the lat of this picking
	*/
	public void setLat(double lat) {
		_picking.setLat(lat);
	}

	/**
	* Returns the lng of this picking.
	*
	* @return the lng of this picking
	*/
	public double getLng() {
		return _picking.getLng();
	}

	/**
	* Sets the lng of this picking.
	*
	* @param lng the lng of this picking
	*/
	public void setLng(double lng) {
		_picking.setLng(lng);
	}

	/**
	* Returns the moon phase of this picking.
	*
	* @return the moon phase of this picking
	*/
	public java.lang.String getMoonPhase() {
		return _picking.getMoonPhase();
	}

	/**
	* Sets the moon phase of this picking.
	*
	* @param moonPhase the moon phase of this picking
	*/
	public void setMoonPhase(java.lang.String moonPhase) {
		_picking.setMoonPhase(moonPhase);
	}

	/**
	* Returns the weather of this picking.
	*
	* @return the weather of this picking
	*/
	public java.lang.String getWeather() {
		return _picking.getWeather();
	}

	/**
	* Sets the weather of this picking.
	*
	* @param weather the weather of this picking
	*/
	public void setWeather(java.lang.String weather) {
		_picking.setWeather(weather);
	}

	/**
	* Returns the temperature of this picking.
	*
	* @return the temperature of this picking
	*/
	public double getTemperature() {
		return _picking.getTemperature();
	}

	/**
	* Sets the temperature of this picking.
	*
	* @param temperature the temperature of this picking
	*/
	public void setTemperature(double temperature) {
		_picking.setTemperature(temperature);
	}

	/**
	* Returns the humidity of this picking.
	*
	* @return the humidity of this picking
	*/
	public double getHumidity() {
		return _picking.getHumidity();
	}

	/**
	* Sets the humidity of this picking.
	*
	* @param humidity the humidity of this picking
	*/
	public void setHumidity(double humidity) {
		_picking.setHumidity(humidity);
	}

	/**
	* Returns the img ID of this picking.
	*
	* @return the img ID of this picking
	*/
	public long getImgId() {
		return _picking.getImgId();
	}

	/**
	* Sets the img ID of this picking.
	*
	* @param imgId the img ID of this picking
	*/
	public void setImgId(long imgId) {
		_picking.setImgId(imgId);
	}

	/**
	* Returns the img name of this picking.
	*
	* @return the img name of this picking
	*/
	public java.lang.String getImgName() {
		return _picking.getImgName();
	}

	/**
	* Sets the img name of this picking.
	*
	* @param imgName the img name of this picking
	*/
	public void setImgName(java.lang.String imgName) {
		_picking.setImgName(imgName);
	}

	public boolean isNew() {
		return _picking.isNew();
	}

	public void setNew(boolean n) {
		_picking.setNew(n);
	}

	public boolean isCachedModel() {
		return _picking.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_picking.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _picking.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _picking.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_picking.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _picking.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_picking.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PickingWrapper((Picking)_picking.clone());
	}

	public int compareTo(net.sareweb.onddo.model.Picking picking) {
		return _picking.compareTo(picking);
	}

	@Override
	public int hashCode() {
		return _picking.hashCode();
	}

	public com.liferay.portal.model.CacheModel<net.sareweb.onddo.model.Picking> toCacheModel() {
		return _picking.toCacheModel();
	}

	public net.sareweb.onddo.model.Picking toEscapedModel() {
		return new PickingWrapper(_picking.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _picking.toString();
	}

	public java.lang.String toXmlString() {
		return _picking.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_picking.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Picking getWrappedPicking() {
		return _picking;
	}

	public Picking getWrappedModel() {
		return _picking;
	}

	public void resetOriginalValues() {
		_picking.resetOriginalValues();
	}

	private Picking _picking;
}