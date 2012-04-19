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

package net.sareweb.onddo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PickingService}.
 * </p>
 *
 * @author    A.Galdos
 * @see       PickingService
 * @generated
 */
public class PickingServiceWrapper implements PickingService,
	ServiceWrapper<PickingService> {
	public PickingServiceWrapper(PickingService pickingService) {
		_pickingService = pickingService;
	}

	public net.sareweb.onddo.model.Picking getPickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pickingService.getPickingById(pickingId);
	}

	public net.sareweb.onddo.model.Picking addPicking(long companyId,
		long userId, long createDate, long modifiedDate, java.lang.String type,
		double lat, double lng, java.lang.String moonPhase,
		java.lang.String weather, double temperature, double humidity,
		long imgId, java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pickingService.addPicking(companyId, userId, createDate,
			modifiedDate, type, lat, lng, moonPhase, weather, temperature,
			humidity, imgId, imgName);
	}

	public net.sareweb.onddo.model.Picking updatePicking(long pickingId,
		long companyId, long userId, long createDate, long modifiedDate,
		java.lang.String type, double lat, double lng,
		java.lang.String moonPhase, java.lang.String weather,
		double temperature, double humidity, long imgId,
		java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pickingService.updatePicking(pickingId, companyId, userId,
			createDate, modifiedDate, type, lat, lng, moonPhase, weather,
			temperature, humidity, imgId, imgName);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PickingService getWrappedPickingService() {
		return _pickingService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPickingService(PickingService pickingService) {
		_pickingService = pickingService;
	}

	public PickingService getWrappedService() {
		return _pickingService;
	}

	public void setWrappedService(PickingService pickingService) {
		_pickingService = pickingService;
	}

	private PickingService _pickingService;
}