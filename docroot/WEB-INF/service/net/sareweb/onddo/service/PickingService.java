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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the picking remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author A.Galdos
 * @see PickingServiceUtil
 * @see net.sareweb.onddo.service.base.PickingServiceBaseImpl
 * @see net.sareweb.onddo.service.impl.PickingServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PickingService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PickingServiceUtil} to access the picking remote service. Add custom service methods to {@link net.sareweb.onddo.service.impl.PickingServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public net.sareweb.onddo.model.Picking getPickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public net.sareweb.onddo.model.Picking addPicking(long companyId,
		long userId, long createDate, long modifiedDate, java.lang.String type,
		double lat, double lng, java.lang.String moonPhase,
		java.lang.String weather, double temperature, double humidity,
		long imgId, java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public net.sareweb.onddo.model.Picking updatePicking(long pickingId,
		long companyId, long userId, long createDate, long modifiedDate,
		java.lang.String type, double lat, double lng,
		java.lang.String moonPhase, java.lang.String weather,
		double temperature, double humidity, long imgId,
		java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deletePickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<net.sareweb.onddo.model.Picking> findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}