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

import com.liferay.portal.service.persistence.BasePersistence;

import net.sareweb.onddo.model.Picking;

/**
 * The persistence interface for the picking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author A.Galdos
 * @see PickingPersistenceImpl
 * @see PickingUtil
 * @generated
 */
public interface PickingPersistence extends BasePersistence<Picking> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PickingUtil} to access the picking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the picking in the entity cache if it is enabled.
	*
	* @param picking the picking
	*/
	public void cacheResult(net.sareweb.onddo.model.Picking picking);

	/**
	* Caches the pickings in the entity cache if it is enabled.
	*
	* @param pickings the pickings
	*/
	public void cacheResult(
		java.util.List<net.sareweb.onddo.model.Picking> pickings);

	/**
	* Creates a new picking with the primary key. Does not add the picking to the database.
	*
	* @param pickingId the primary key for the new picking
	* @return the new picking
	*/
	public net.sareweb.onddo.model.Picking create(long pickingId);

	/**
	* Removes the picking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pickingId the primary key of the picking
	* @return the picking that was removed
	* @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking remove(long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException;

	public net.sareweb.onddo.model.Picking updateImpl(
		net.sareweb.onddo.model.Picking picking, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the picking with the primary key or throws a {@link net.sareweb.onddo.NoSuchPickingException} if it could not be found.
	*
	* @param pickingId the primary key of the picking
	* @return the picking
	* @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking findByPrimaryKey(long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException;

	/**
	* Returns the picking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pickingId the primary key of the picking
	* @return the picking, or <code>null</code> if a picking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking fetchByPrimaryKey(long pickingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the picking where userId = &#63; or throws a {@link net.sareweb.onddo.NoSuchPickingException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching picking
	* @throws net.sareweb.onddo.NoSuchPickingException if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException;

	/**
	* Returns the picking where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching picking, or <code>null</code> if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the picking where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching picking, or <code>null</code> if a matching picking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public net.sareweb.onddo.model.Picking fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pickings.
	*
	* @return the pickings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<net.sareweb.onddo.model.Picking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.onddo.model.Picking> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<net.sareweb.onddo.model.Picking> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the picking where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			net.sareweb.onddo.NoSuchPickingException;

	/**
	* Removes all the pickings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pickings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching pickings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pickings.
	*
	* @return the number of pickings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}