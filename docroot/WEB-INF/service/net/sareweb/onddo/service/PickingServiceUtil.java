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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the picking remote service. This utility wraps {@link net.sareweb.onddo.service.impl.PickingServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author A.Galdos
 * @see PickingService
 * @see net.sareweb.onddo.service.base.PickingServiceBaseImpl
 * @see net.sareweb.onddo.service.impl.PickingServiceImpl
 * @generated
 */
public class PickingServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.sareweb.onddo.service.impl.PickingServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static net.sareweb.onddo.model.Picking getPickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPickingById(pickingId);
	}

	public static net.sareweb.onddo.model.Picking addPicking(long companyId,
		long userId, long createDate, long modifiedDate, java.lang.String type,
		double lat, double lng, java.lang.String moonPhase,
		java.lang.String weather, double temperature, double humidity,
		long imgId, java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPicking(companyId, userId, createDate, modifiedDate,
			type, lat, lng, moonPhase, weather, temperature, humidity, imgId,
			imgName);
	}

	public static net.sareweb.onddo.model.Picking updatePicking(
		long pickingId, long companyId, long userId, long createDate,
		long modifiedDate, java.lang.String type, double lat, double lng,
		java.lang.String moonPhase, java.lang.String weather,
		double temperature, double humidity, long imgId,
		java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePicking(pickingId, companyId, userId, createDate,
			modifiedDate, type, lat, lng, moonPhase, weather, temperature,
			humidity, imgId, imgName);
	}

	public static void clearService() {
		_service = null;
	}

	public static PickingService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PickingService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					PickingService.class.getName(), portletClassLoader);

			_service = new PickingServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(PickingServiceUtil.class,
				"_service");
			MethodCache.remove(PickingService.class);
		}

		return _service;
	}

	public void setService(PickingService service) {
		MethodCache.remove(PickingService.class);

		_service = service;

		ReferenceRegistry.registerReference(PickingServiceUtil.class, "_service");
		MethodCache.remove(PickingService.class);
	}

	private static PickingService _service;
}