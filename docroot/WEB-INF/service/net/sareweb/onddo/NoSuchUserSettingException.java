/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package net.sareweb.onddo;

import com.liferay.portal.NoSuchModelException;

/**
 * @author A.Galdos
 */
public class NoSuchUserSettingException extends NoSuchModelException {

	public NoSuchUserSettingException() {
		super();
	}

	public NoSuchUserSettingException(String msg) {
		super(msg);
	}

	public NoSuchUserSettingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserSettingException(Throwable cause) {
		super(cause);
	}

}