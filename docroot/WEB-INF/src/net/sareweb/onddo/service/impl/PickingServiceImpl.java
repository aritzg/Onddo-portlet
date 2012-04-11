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
	
}