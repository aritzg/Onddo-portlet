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

package net.sareweb.onddo.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.sareweb.onddo.model.Picking;
import net.sareweb.onddo.service.PickingLocalService;
import net.sareweb.onddo.service.PickingService;
import net.sareweb.onddo.service.UserSettingLocalService;
import net.sareweb.onddo.service.UserSettingService;
import net.sareweb.onddo.service.persistence.PickingPersistence;
import net.sareweb.onddo.service.persistence.UserSettingPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the picking remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.sareweb.onddo.service.impl.PickingServiceImpl}.
 * </p>
 *
 * @author A.Galdos
 * @see net.sareweb.onddo.service.impl.PickingServiceImpl
 * @see net.sareweb.onddo.service.PickingServiceUtil
 * @generated
 */
public abstract class PickingServiceBaseImpl extends PrincipalBean
	implements PickingService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link net.sareweb.onddo.service.PickingServiceUtil} to access the picking remote service.
	 */

	/**
	 * Returns the picking local service.
	 *
	 * @return the picking local service
	 */
	public PickingLocalService getPickingLocalService() {
		return pickingLocalService;
	}

	/**
	 * Sets the picking local service.
	 *
	 * @param pickingLocalService the picking local service
	 */
	public void setPickingLocalService(PickingLocalService pickingLocalService) {
		this.pickingLocalService = pickingLocalService;
	}

	/**
	 * Returns the picking remote service.
	 *
	 * @return the picking remote service
	 */
	public PickingService getPickingService() {
		return pickingService;
	}

	/**
	 * Sets the picking remote service.
	 *
	 * @param pickingService the picking remote service
	 */
	public void setPickingService(PickingService pickingService) {
		this.pickingService = pickingService;
	}

	/**
	 * Returns the picking persistence.
	 *
	 * @return the picking persistence
	 */
	public PickingPersistence getPickingPersistence() {
		return pickingPersistence;
	}

	/**
	 * Sets the picking persistence.
	 *
	 * @param pickingPersistence the picking persistence
	 */
	public void setPickingPersistence(PickingPersistence pickingPersistence) {
		this.pickingPersistence = pickingPersistence;
	}

	/**
	 * Returns the user setting local service.
	 *
	 * @return the user setting local service
	 */
	public UserSettingLocalService getUserSettingLocalService() {
		return userSettingLocalService;
	}

	/**
	 * Sets the user setting local service.
	 *
	 * @param userSettingLocalService the user setting local service
	 */
	public void setUserSettingLocalService(
		UserSettingLocalService userSettingLocalService) {
		this.userSettingLocalService = userSettingLocalService;
	}

	/**
	 * Returns the user setting remote service.
	 *
	 * @return the user setting remote service
	 */
	public UserSettingService getUserSettingService() {
		return userSettingService;
	}

	/**
	 * Sets the user setting remote service.
	 *
	 * @param userSettingService the user setting remote service
	 */
	public void setUserSettingService(UserSettingService userSettingService) {
		this.userSettingService = userSettingService;
	}

	/**
	 * Returns the user setting persistence.
	 *
	 * @return the user setting persistence
	 */
	public UserSettingPersistence getUserSettingPersistence() {
		return userSettingPersistence;
	}

	/**
	 * Sets the user setting persistence.
	 *
	 * @param userSettingPersistence the user setting persistence
	 */
	public void setUserSettingPersistence(
		UserSettingPersistence userSettingPersistence) {
		this.userSettingPersistence = userSettingPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return Picking.class;
	}

	protected String getModelClassName() {
		return Picking.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = pickingPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PickingLocalService.class)
	protected PickingLocalService pickingLocalService;
	@BeanReference(type = PickingService.class)
	protected PickingService pickingService;
	@BeanReference(type = PickingPersistence.class)
	protected PickingPersistence pickingPersistence;
	@BeanReference(type = UserSettingLocalService.class)
	protected UserSettingLocalService userSettingLocalService;
	@BeanReference(type = UserSettingService.class)
	protected UserSettingService userSettingService;
	@BeanReference(type = UserSettingPersistence.class)
	protected UserSettingPersistence userSettingPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
}