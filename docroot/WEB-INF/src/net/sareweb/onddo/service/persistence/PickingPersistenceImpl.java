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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.sareweb.onddo.NoSuchPickingException;
import net.sareweb.onddo.model.Picking;
import net.sareweb.onddo.model.impl.PickingImpl;
import net.sareweb.onddo.model.impl.PickingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the picking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author A.Galdos
 * @see PickingPersistence
 * @see PickingUtil
 * @generated
 */
public class PickingPersistenceImpl extends BasePersistenceImpl<Picking>
	implements PickingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PickingUtil} to access the picking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PickingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, PickingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, PickingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			PickingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, PickingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, PickingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the picking in the entity cache if it is enabled.
	 *
	 * @param picking the picking
	 */
	public void cacheResult(Picking picking) {
		EntityCacheUtil.putResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingImpl.class, picking.getPrimaryKey(), picking);

		picking.resetOriginalValues();
	}

	/**
	 * Caches the pickings in the entity cache if it is enabled.
	 *
	 * @param pickings the pickings
	 */
	public void cacheResult(List<Picking> pickings) {
		for (Picking picking : pickings) {
			if (EntityCacheUtil.getResult(
						PickingModelImpl.ENTITY_CACHE_ENABLED,
						PickingImpl.class, picking.getPrimaryKey()) == null) {
				cacheResult(picking);
			}
			else {
				picking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pickings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PickingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PickingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the picking.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Picking picking) {
		EntityCacheUtil.removeResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingImpl.class, picking.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Picking> pickings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Picking picking : pickings) {
			EntityCacheUtil.removeResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
				PickingImpl.class, picking.getPrimaryKey());
		}
	}

	/**
	 * Creates a new picking with the primary key. Does not add the picking to the database.
	 *
	 * @param pickingId the primary key for the new picking
	 * @return the new picking
	 */
	public Picking create(long pickingId) {
		Picking picking = new PickingImpl();

		picking.setNew(true);
		picking.setPrimaryKey(pickingId);

		return picking;
	}

	/**
	 * Removes the picking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pickingId the primary key of the picking
	 * @return the picking that was removed
	 * @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking remove(long pickingId)
		throws NoSuchPickingException, SystemException {
		return remove(Long.valueOf(pickingId));
	}

	/**
	 * Removes the picking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the picking
	 * @return the picking that was removed
	 * @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picking remove(Serializable primaryKey)
		throws NoSuchPickingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Picking picking = (Picking)session.get(PickingImpl.class, primaryKey);

			if (picking == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPickingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(picking);
		}
		catch (NoSuchPickingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Picking removeImpl(Picking picking) throws SystemException {
		picking = toUnwrappedModel(picking);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, picking);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(picking);

		return picking;
	}

	@Override
	public Picking updateImpl(net.sareweb.onddo.model.Picking picking,
		boolean merge) throws SystemException {
		picking = toUnwrappedModel(picking);

		boolean isNew = picking.isNew();

		PickingModelImpl pickingModelImpl = (PickingModelImpl)picking;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, picking, merge);

			picking.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PickingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pickingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pickingModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(pickingModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
			PickingImpl.class, picking.getPrimaryKey(), picking);

		return picking;
	}

	protected Picking toUnwrappedModel(Picking picking) {
		if (picking instanceof PickingImpl) {
			return picking;
		}

		PickingImpl pickingImpl = new PickingImpl();

		pickingImpl.setNew(picking.isNew());
		pickingImpl.setPrimaryKey(picking.getPrimaryKey());

		pickingImpl.setPickingId(picking.getPickingId());
		pickingImpl.setCompanyId(picking.getCompanyId());
		pickingImpl.setUserId(picking.getUserId());
		pickingImpl.setCreateDate(picking.getCreateDate());
		pickingImpl.setModifiedDate(picking.getModifiedDate());
		pickingImpl.setType(picking.getType());
		pickingImpl.setLat(picking.getLat());
		pickingImpl.setLng(picking.getLng());
		pickingImpl.setMoonPhase(picking.getMoonPhase());
		pickingImpl.setWeather(picking.getWeather());
		pickingImpl.setTemperature(picking.getTemperature());
		pickingImpl.setHumidity(picking.getHumidity());
		pickingImpl.setImgId(picking.getImgId());
		pickingImpl.setImgName(picking.getImgName());

		return pickingImpl;
	}

	/**
	 * Returns the picking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the picking
	 * @return the picking
	 * @throws com.liferay.portal.NoSuchModelException if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the picking with the primary key or throws a {@link net.sareweb.onddo.NoSuchPickingException} if it could not be found.
	 *
	 * @param pickingId the primary key of the picking
	 * @return the picking
	 * @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking findByPrimaryKey(long pickingId)
		throws NoSuchPickingException, SystemException {
		Picking picking = fetchByPrimaryKey(pickingId);

		if (picking == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pickingId);
			}

			throw new NoSuchPickingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pickingId);
		}

		return picking;
	}

	/**
	 * Returns the picking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the picking
	 * @return the picking, or <code>null</code> if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picking fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the picking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pickingId the primary key of the picking
	 * @return the picking, or <code>null</code> if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking fetchByPrimaryKey(long pickingId) throws SystemException {
		Picking picking = (Picking)EntityCacheUtil.getResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
				PickingImpl.class, pickingId);

		if (picking == _nullPicking) {
			return null;
		}

		if (picking == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				picking = (Picking)session.get(PickingImpl.class,
						Long.valueOf(pickingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (picking != null) {
					cacheResult(picking);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PickingModelImpl.ENTITY_CACHE_ENABLED,
						PickingImpl.class, pickingId, _nullPicking);
				}

				closeSession(session);
			}
		}

		return picking;
	}

	/**
	 * Returns all the pickings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching pickings
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picking> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pickings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of pickings
	 * @param end the upper bound of the range of pickings (not inclusive)
	 * @return the range of matching pickings
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picking> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pickings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of pickings
	 * @param end the upper bound of the range of pickings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pickings
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picking> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Picking> list = (List<Picking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PICKING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PickingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Picking>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first picking in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching picking
	 * @throws net.sareweb.onddo.NoSuchPickingException if a matching picking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPickingException, SystemException {
		List<Picking> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPickingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last picking in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching picking
	 * @throws net.sareweb.onddo.NoSuchPickingException if a matching picking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPickingException, SystemException {
		int count = countByUserId(userId);

		List<Picking> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPickingException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the pickings before and after the current picking in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pickingId the primary key of the current picking
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next picking
	 * @throws net.sareweb.onddo.NoSuchPickingException if a picking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picking[] findByUserId_PrevAndNext(long pickingId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchPickingException, SystemException {
		Picking picking = findByPrimaryKey(pickingId);

		Session session = null;

		try {
			session = openSession();

			Picking[] array = new PickingImpl[3];

			array[0] = getByUserId_PrevAndNext(session, picking, userId,
					orderByComparator, true);

			array[1] = picking;

			array[2] = getByUserId_PrevAndNext(session, picking, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Picking getByUserId_PrevAndNext(Session session, Picking picking,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PICKING_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PickingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(picking);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Picking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pickings.
	 *
	 * @return the pickings
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picking> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Picking> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Picking> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Picking> list = (List<Picking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PICKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PICKING.concat(PickingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Picking>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Picking>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pickings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (Picking picking : findByUserId(userId)) {
			remove(picking);
		}
	}

	/**
	 * Removes all the pickings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Picking picking : findAll()) {
			remove(picking);
		}
	}

	/**
	 * Returns the number of pickings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching pickings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PICKING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pickings.
	 *
	 * @return the number of pickings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PICKING);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the picking persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.onddo.model.Picking")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Picking>> listenersList = new ArrayList<ModelListener<Picking>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Picking>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PickingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PickingPersistence.class)
	protected PickingPersistence pickingPersistence;
	@BeanReference(type = UserSettingPersistence.class)
	protected UserSettingPersistence userSettingPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PICKING = "SELECT picking FROM Picking picking";
	private static final String _SQL_SELECT_PICKING_WHERE = "SELECT picking FROM Picking picking WHERE ";
	private static final String _SQL_COUNT_PICKING = "SELECT COUNT(picking) FROM Picking picking";
	private static final String _SQL_COUNT_PICKING_WHERE = "SELECT COUNT(picking) FROM Picking picking WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "picking.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "picking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Picking exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Picking exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PickingPersistenceImpl.class);
	private static Picking _nullPicking = new PickingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Picking> toCacheModel() {
				return _nullPickingCacheModel;
			}
		};

	private static CacheModel<Picking> _nullPickingCacheModel = new CacheModel<Picking>() {
			public Picking toEntityModel() {
				return _nullPicking;
			}
		};
}