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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import net.sareweb.onddo.model.PickingClp;
import net.sareweb.onddo.model.UserSettingClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Onddo-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Onddo-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Onddo-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PickingClp.class.getName())) {
			return translateInputPicking(oldModel);
		}

		if (oldModelClassName.equals(UserSettingClp.class.getName())) {
			return translateInputUserSetting(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputPicking(BaseModel<?> oldModel) {
		PickingClp oldCplModel = (PickingClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.onddo.model.impl.PickingImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setPickingId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getPickingId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCompanyId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setType",
						new Class[] { String.class });

				String value5 = oldCplModel.getType();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLat",
						new Class[] { Double.TYPE });

				Double value6 = new Double(oldCplModel.getLat());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setLng",
						new Class[] { Double.TYPE });

				Double value7 = new Double(oldCplModel.getLng());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setMoonPhase",
						new Class[] { String.class });

				String value8 = oldCplModel.getMoonPhase();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setWeather",
						new Class[] { String.class });

				String value9 = oldCplModel.getWeather();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setTemperature",
						new Class[] { Double.TYPE });

				Double value10 = new Double(oldCplModel.getTemperature());

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setHumidity",
						new Class[] { Double.TYPE });

				Double value11 = new Double(oldCplModel.getHumidity());

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setImgId",
						new Class[] { Long.TYPE });

				Long value12 = new Long(oldCplModel.getImgId());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setImgName",
						new Class[] { String.class });

				String value13 = oldCplModel.getImgName();

				method13.invoke(newModel, value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputUserSetting(BaseModel<?> oldModel) {
		UserSettingClp oldCplModel = (UserSettingClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("net.sareweb.onddo.model.impl.UserSettingImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUserSettingId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getUserSettingId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCompanyId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setVisibilityToFriends",
						new Class[] { String.class });

				String value5 = oldCplModel.getVisibilityToFriends();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setVisibilityToOthers",
						new Class[] { String.class });

				String value6 = oldCplModel.getVisibilityToOthers();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setTweetPicking",
						new Class[] { Boolean.TYPE });

				Boolean value7 = new Boolean(oldCplModel.getTweetPicking());

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("net.sareweb.onddo.model.impl.PickingImpl")) {
			return translateOutputPicking(oldModel);
		}

		if (oldModelClassName.equals(
					"net.sareweb.onddo.model.impl.UserSettingImpl")) {
			return translateOutputUserSetting(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputPicking(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				PickingClp newModel = new PickingClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getPickingId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setPickingId(value0);

				Method method1 = oldModelClass.getMethod("getCompanyId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getCreateDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

				Method method5 = oldModelClass.getMethod("getType");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setType(value5);

				Method method6 = oldModelClass.getMethod("getLat");

				Double value6 = (Double)method6.invoke(oldModel, (Object[])null);

				newModel.setLat(value6);

				Method method7 = oldModelClass.getMethod("getLng");

				Double value7 = (Double)method7.invoke(oldModel, (Object[])null);

				newModel.setLng(value7);

				Method method8 = oldModelClass.getMethod("getMoonPhase");

				String value8 = (String)method8.invoke(oldModel, (Object[])null);

				newModel.setMoonPhase(value8);

				Method method9 = oldModelClass.getMethod("getWeather");

				String value9 = (String)method9.invoke(oldModel, (Object[])null);

				newModel.setWeather(value9);

				Method method10 = oldModelClass.getMethod("getTemperature");

				Double value10 = (Double)method10.invoke(oldModel,
						(Object[])null);

				newModel.setTemperature(value10);

				Method method11 = oldModelClass.getMethod("getHumidity");

				Double value11 = (Double)method11.invoke(oldModel,
						(Object[])null);

				newModel.setHumidity(value11);

				Method method12 = oldModelClass.getMethod("getImgId");

				Long value12 = (Long)method12.invoke(oldModel, (Object[])null);

				newModel.setImgId(value12);

				Method method13 = oldModelClass.getMethod("getImgName");

				String value13 = (String)method13.invoke(oldModel,
						(Object[])null);

				newModel.setImgName(value13);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputUserSetting(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				UserSettingClp newModel = new UserSettingClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUserSettingId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setUserSettingId(value0);

				Method method1 = oldModelClass.getMethod("getCompanyId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getCreateDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

				Method method5 = oldModelClass.getMethod(
						"getVisibilityToFriends");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setVisibilityToFriends(value5);

				Method method6 = oldModelClass.getMethod(
						"getVisibilityToOthers");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setVisibilityToOthers(value6);

				Method method7 = oldModelClass.getMethod("getTweetPicking");

				Boolean value7 = (Boolean)method7.invoke(oldModel,
						(Object[])null);

				newModel.setTweetPicking(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}