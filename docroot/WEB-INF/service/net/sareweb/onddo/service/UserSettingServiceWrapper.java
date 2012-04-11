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
 * This class is a wrapper for {@link UserSettingService}.
 * </p>
 *
 * @author    A.Galdos
 * @see       UserSettingService
 * @generated
 */
public class UserSettingServiceWrapper implements UserSettingService,
	ServiceWrapper<UserSettingService> {
	public UserSettingServiceWrapper(UserSettingService userSettingService) {
		_userSettingService = userSettingService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserSettingService getWrappedUserSettingService() {
		return _userSettingService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserSettingService(
		UserSettingService userSettingService) {
		_userSettingService = userSettingService;
	}

	public UserSettingService getWrappedService() {
		return _userSettingService;
	}

	public void setWrappedService(UserSettingService userSettingService) {
		_userSettingService = userSettingService;
	}

	private UserSettingService _userSettingService;
}