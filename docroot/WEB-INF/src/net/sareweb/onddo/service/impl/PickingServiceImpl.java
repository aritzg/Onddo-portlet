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

package net.sareweb.onddo.service.impl;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import net.sareweb.onddo.model.Picking;
import net.sareweb.onddo.service.PickingLocalServiceUtil;
import net.sareweb.onddo.service.base.PickingServiceBaseImpl;

/**
 * The implementation of the picking remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.sareweb.onddo.service.PickingService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author A.Galdos
 * @see net.sareweb.onddo.service.base.PickingServiceBaseImpl
 * @see net.sareweb.onddo.service.PickingServiceUtil
 */
public class PickingServiceImpl extends PickingServiceBaseImpl {
	
	public Picking getPickingById(long pickingId) throws PortalException, SystemException{
		return PickingLocalServiceUtil.getPicking(pickingId);
	}
	
	public Picking addPicking(long companyId, long userId, long createDate, long modifiedDate, String type, double lat, double lng, String moonPhase, String weather, double temperature, double humidity, long imgId, String imgName) throws SystemException{
		Picking p = PickingLocalServiceUtil.createPicking(CounterLocalServiceUtil.increment());
		p.setCompanyId(companyId);
		p.setUserId(userId);
		p.setCreateDate(new Date(createDate));
		p.setModifiedDate(new Date(modifiedDate));
		p.setType(type);
		p.setLat(lat);
		p.setLng(lng);
		p.setMoonPhase(moonPhase);
		p.setWeather(weather);
		p.setTemperature(temperature);
		p.setHumidity(humidity);
		p.setImgId(imgId);
		p.setImgName(imgName);
		return PickingLocalServiceUtil.addPicking(p);
	}
	
	public Picking updatePicking(long pickingId, long companyId, long userId, long createDate, long modifiedDate, String type, double lat, double lng, String moonPhase, String weather, double temperature, double humidity, long imgId, String imgName) throws PortalException, SystemException {
		Picking p = PickingLocalServiceUtil.getPicking(pickingId);
		p.setCompanyId(companyId);
		p.setUserId(userId);
		p.setCreateDate(new Date(createDate));
		p.setModifiedDate(new Date(modifiedDate));
		p.setType(type);
		p.setLat(lat);
		p.setLng(lng);
		p.setMoonPhase(moonPhase);
		p.setWeather(weather);
		p.setTemperature(temperature);
		p.setHumidity(humidity);
		p.setImgId(imgId);
		p.setImgName(imgName);
		return PickingLocalServiceUtil.updatePicking(p);
	}
	
}