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

package net.sareweb.onddo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.sareweb.onddo.model.Picking;

import java.util.List;

/**
 * The persistence utility for the picking service. This utility wraps {@link PickingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author A.Galdos
 * @see PickingPersistence
 * @see PickingPersistenceImpl
 * @generated
 */
public class PickingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Picking picking) {
		getPersistence().clearCache(picking);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Picking> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Picking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Picking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Picking update(Picking picking, boolean merge)
		throws SystemException {
		return getPersistence().update(picking, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Picking update(Picking picking, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(picking, merge, serviceContext);
	}

	/**
	* Caches the picking in the entity cache if it is enabled.
	*
	* @param picking the picking
	*/
	public static void cacheResult(net.sareweb.onddo.model.Picking picking) {
		getPersistence().cacheResult(picking);
	}

	/**
	* Caches the pickings in the entity cache if it is enabled.
	*
	* @param pickings the pickings
	*/
	public static void cacheResult(
		java.util.List<net.sareweb.onddo.model.Picking> pickings) {
		getPersistence().cacheResult(pickings);
	}

	/**
	* Creates a new picking with the primary key. Does not add the picking to the database.
	*
	* @param pickingId the primary key for the new picking
	* @return the new picking
	*/
	public static net.sareweb.onddo.model.Picking create(long pickingId) {
		return getPersistence().create(pickingId);
	}

	/**
	* Removes the picking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pickingId the primary key of the picking
	* @return the picking that was removed
	* @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking remove(long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException {
		return getPersistence().remove(pickingId);
	}

	public static net.sareweb.onddo.model.Picking updateImpl(
		net.sareweb.onddo.model.Picking picking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(picking, merge);
	}

	/**
	* Returns the picking with the primary key or throws a {@link net.sareweb.onddo.NoSuchPickingException} if it could not be found.
	*
	* @param pickingId the primary key of the picking
	* @return the picking
	* @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking findByPrimaryKey(
		long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException {
		return getPersistence().findByPrimaryKey(pickingId);
	}

	/**
	* Returns the picking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pickingId the primary key of the picking
	* @return the picking, or <code>null</code> if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking fetchByPrimaryKey(
		long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(pickingId);
	}

	/**
	* Returns the picking where userId = &#63; or throws a {@link net.sareweb.onddo.NoSuchPickingException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching picking
	* @throws net.sareweb.onddo.NoSuchPickingException if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the picking where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching picking, or <code>null</code> if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the picking where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching picking, or <code>null</code> if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static net.sareweb.onddo.model.Picking fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Returns all the pickings.
	*
	* @return the pickings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.onddo.model.Picking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pickings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pickings
	* @param end the upper bound of the range of pickings (not inclusive)
	* @return the range of pickings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.onddo.model.Picking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pickings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pickings
	* @param end the upper bound of the range of pickings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pickings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<net.sareweb.onddo.model.Picking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the picking where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the pickings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pickings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching pickings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of pickings.
	*
	* @return the number of pickings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PickingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PickingPersistence)PortletBeanLocatorUtil.locate(net.sareweb.onddo.service.ClpSerializer.getServletContextName(),
					PickingPersistence.class.getName());

			ReferenceRegistry.registerReference(PickingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(PickingPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(PickingUtil.class, "_persistence");
	}

	private static PickingPersistence _persistence;
}