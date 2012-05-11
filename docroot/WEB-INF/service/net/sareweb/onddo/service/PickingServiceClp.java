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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author A.Galdos
 */
public class PickingServiceClp implements PickingService {
	public PickingServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getPickingByIdMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPickingById", long.class);

		_addPickingMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"addPicking", long.class, long.class, long.class, long.class,
				java.lang.String.class, double.class, double.class,
				java.lang.String.class, java.lang.String.class, double.class,
				double.class, long.class, java.lang.String.class);

		_updatePickingMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"updatePicking", long.class, long.class, long.class,
				long.class, long.class, java.lang.String.class, double.class,
				double.class, java.lang.String.class, java.lang.String.class,
				double.class, double.class, long.class, java.lang.String.class);

		_deletePickingByIdMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deletePickingById", long.class);

		_findByUserIdMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByUserId", long.class);
	}

	public net.sareweb.onddo.model.Picking getPickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPickingByIdMethodKey0,
				pickingId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (net.sareweb.onddo.model.Picking)ClpSerializer.translateOutput(returnObj);
	}

	public net.sareweb.onddo.model.Picking addPicking(long companyId,
		long userId, long createDate, long modifiedDate, java.lang.String type,
		double lat, double lng, java.lang.String moonPhase,
		java.lang.String weather, double temperature, double humidity,
		long imgId, java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addPickingMethodKey1,
				companyId, userId, createDate, modifiedDate,
				ClpSerializer.translateInput(type), lat, lng,
				ClpSerializer.translateInput(moonPhase),
				ClpSerializer.translateInput(weather), temperature, humidity,
				imgId, ClpSerializer.translateInput(imgName));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (net.sareweb.onddo.model.Picking)ClpSerializer.translateOutput(returnObj);
	}

	public net.sareweb.onddo.model.Picking updatePicking(long pickingId,
		long companyId, long userId, long createDate, long modifiedDate,
		java.lang.String type, double lat, double lng,
		java.lang.String moonPhase, java.lang.String weather,
		double temperature, double humidity, long imgId,
		java.lang.String imgName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updatePickingMethodKey2,
				pickingId, companyId, userId, createDate, modifiedDate,
				ClpSerializer.translateInput(type), lat, lng,
				ClpSerializer.translateInput(moonPhase),
				ClpSerializer.translateInput(weather), temperature, humidity,
				imgId, ClpSerializer.translateInput(imgName));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (net.sareweb.onddo.model.Picking)ClpSerializer.translateOutput(returnObj);
	}

	public void deletePickingById(long pickingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deletePickingByIdMethodKey3,
				pickingId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<net.sareweb.onddo.model.Picking> findByUserId(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByUserIdMethodKey4,
				userId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<net.sareweb.onddo.model.Picking>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getPickingByIdMethodKey0;
	private MethodKey _addPickingMethodKey1;
	private MethodKey _updatePickingMethodKey2;
	private MethodKey _deletePickingByIdMethodKey3;
	private MethodKey _findByUserIdMethodKey4;
}