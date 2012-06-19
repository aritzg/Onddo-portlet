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

import net.sareweb.onddo.NoSuchUserSettingException;
import net.sareweb.onddo.model.UserSetting;
import net.sareweb.onddo.model.impl.UserSettingImpl;
import net.sareweb.onddo.model.impl.UserSettingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author A.Galdos
 * @see UserSettingPersistence
 * @see UserSettingUtil
 * @generated
 */
public class UserSettingPersistenceImpl extends BasePersistenceImpl<UserSetting>
	implements UserSettingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSettingUtil} to access the user setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSettingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingModelImpl.FINDER_CACHE_ENABLED, UserSettingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			UserSettingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingModelImpl.FINDER_CACHE_ENABLED, UserSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingModelImpl.FINDER_CACHE_ENABLED, UserSettingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user setting in the entity cache if it is enabled.
	 *
	 * @param userSetting the user setting
	 */
	public void cacheResult(UserSetting userSetting) {
		EntityCacheUtil.putResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingImpl.class, userSetting.getPrimaryKey(), userSetting);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(userSetting.getUserId()) }, userSetting);

		userSetting.resetOriginalValues();
	}

	/**
	 * Caches the user settings in the entity cache if it is enabled.
	 *
	 * @param userSettings the user settings
	 */
	public void cacheResult(List<UserSetting> userSettings) {
		for (UserSetting userSetting : userSettings) {
			if (EntityCacheUtil.getResult(
						UserSettingModelImpl.ENTITY_CACHE_ENABLED,
						UserSettingImpl.class, userSetting.getPrimaryKey()) == null) {
				cacheResult(userSetting);
			}
			else {
				userSetting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user settings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserSettingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserSettingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user setting.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSetting userSetting) {
		EntityCacheUtil.removeResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingImpl.class, userSetting.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userSetting);
	}

	@Override
	public void clearCache(List<UserSetting> userSettings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSetting userSetting : userSettings) {
			EntityCacheUtil.removeResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
				UserSettingImpl.class, userSetting.getPrimaryKey());

			clearUniqueFindersCache(userSetting);
		}
	}

	protected void clearUniqueFindersCache(UserSetting userSetting) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(userSetting.getUserId()) });
	}

	/**
	 * Creates a new user setting with the primary key. Does not add the user setting to the database.
	 *
	 * @param userSettingId the primary key for the new user setting
	 * @return the new user setting
	 */
	public UserSetting create(long userSettingId) {
		UserSetting userSetting = new UserSettingImpl();

		userSetting.setNew(true);
		userSetting.setPrimaryKey(userSettingId);

		return userSetting;
	}

	/**
	 * Removes the user setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userSettingId the primary key of the user setting
	 * @return the user setting that was removed
	 * @throws net.sareweb.onddo.NoSuchUserSettingException if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting remove(long userSettingId)
		throws NoSuchUserSettingException, SystemException {
		return remove(Long.valueOf(userSettingId));
	}

	/**
	 * Removes the user setting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user setting
	 * @return the user setting that was removed
	 * @throws net.sareweb.onddo.NoSuchUserSettingException if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSetting remove(Serializable primaryKey)
		throws NoSuchUserSettingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserSetting userSetting = (UserSetting)session.get(UserSettingImpl.class,
					primaryKey);

			if (userSetting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSetting);
		}
		catch (NoSuchUserSettingException nsee) {
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
	protected UserSetting removeImpl(UserSetting userSetting)
		throws SystemException {
		userSetting = toUnwrappedModel(userSetting);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userSetting);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userSetting);

		return userSetting;
	}

	@Override
	public UserSetting updateImpl(
		net.sareweb.onddo.model.UserSetting userSetting, boolean merge)
		throws SystemException {
		userSetting = toUnwrappedModel(userSetting);

		boolean isNew = userSetting.isNew();

		UserSettingModelImpl userSettingModelImpl = (UserSettingModelImpl)userSetting;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userSetting, merge);

			userSetting.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSettingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
			UserSettingImpl.class, userSetting.getPrimaryKey(), userSetting);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(userSetting.getUserId()) },
				userSetting);
		}
		else {
			if ((userSettingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userSettingModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(userSetting.getUserId()) },
					userSetting);
			}
		}

		return userSetting;
	}

	protected UserSetting toUnwrappedModel(UserSetting userSetting) {
		if (userSetting instanceof UserSettingImpl) {
			return userSetting;
		}

		UserSettingImpl userSettingImpl = new UserSettingImpl();

		userSettingImpl.setNew(userSetting.isNew());
		userSettingImpl.setPrimaryKey(userSetting.getPrimaryKey());

		userSettingImpl.setUserSettingId(userSetting.getUserSettingId());
		userSettingImpl.setCompanyId(userSetting.getCompanyId());
		userSettingImpl.setUserId(userSetting.getUserId());
		userSettingImpl.setCreateDate(userSetting.getCreateDate());
		userSettingImpl.setModifiedDate(userSetting.getModifiedDate());
		userSettingImpl.setVisibilityToFriends(userSetting.getVisibilityToFriends());
		userSettingImpl.setVisibilityToOthers(userSetting.getVisibilityToOthers());
		userSettingImpl.setTweetPicking(userSetting.isTweetPicking());

		return userSettingImpl;
	}

	/**
	 * Returns the user setting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user setting
	 * @return the user setting
	 * @throws com.liferay.portal.NoSuchModelException if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSetting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user setting with the primary key or throws a {@link net.sareweb.onddo.NoSuchUserSettingException} if it could not be found.
	 *
	 * @param userSettingId the primary key of the user setting
	 * @return the user setting
	 * @throws net.sareweb.onddo.NoSuchUserSettingException if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting findByPrimaryKey(long userSettingId)
		throws NoSuchUserSettingException, SystemException {
		UserSetting userSetting = fetchByPrimaryKey(userSettingId);

		if (userSetting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userSettingId);
			}

			throw new NoSuchUserSettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userSettingId);
		}

		return userSetting;
	}

	/**
	 * Returns the user setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user setting
	 * @return the user setting, or <code>null</code> if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSetting fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user setting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userSettingId the primary key of the user setting
	 * @return the user setting, or <code>null</code> if a user setting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting fetchByPrimaryKey(long userSettingId)
		throws SystemException {
		UserSetting userSetting = (UserSetting)EntityCacheUtil.getResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
				UserSettingImpl.class, userSettingId);

		if (userSetting == _nullUserSetting) {
			return null;
		}

		if (userSetting == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userSetting = (UserSetting)session.get(UserSettingImpl.class,
						Long.valueOf(userSettingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userSetting != null) {
					cacheResult(userSetting);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserSettingModelImpl.ENTITY_CACHE_ENABLED,
						UserSettingImpl.class, userSettingId, _nullUserSetting);
				}

				closeSession(session);
			}
		}

		return userSetting;
	}

	/**
	 * Returns the user setting where userId = &#63; or throws a {@link net.sareweb.onddo.NoSuchUserSettingException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user setting
	 * @throws net.sareweb.onddo.NoSuchUserSettingException if a matching user setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting findByUserId(long userId)
		throws NoSuchUserSettingException, SystemException {
		UserSetting userSetting = fetchByUserId(userId);

		if (userSetting == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSettingException(msg.toString());
		}

		return userSetting;
	}

	/**
	 * Returns the user setting where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user setting, or <code>null</code> if a matching user setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the user setting where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user setting, or <code>null</code> if a matching user setting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSetting fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERSETTING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(UserSettingModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserSetting> list = q.list();

				result = list;

				UserSetting userSetting = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					userSetting = list.get(0);

					cacheResult(userSetting);

					if ((userSetting.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userSetting);
					}
				}

				return userSetting;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (UserSetting)result;
			}
		}
	}

	/**
	 * Returns all the user settings.
	 *
	 * @return the user settings
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSetting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user settings
	 * @param end the upper bound of the range of user settings (not inclusive)
	 * @return the range of user settings
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSetting> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user settings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user settings
	 * @param end the upper bound of the range of user settings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user settings
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSetting> findAll(int start, int end,
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

		List<UserSetting> list = (List<UserSetting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSETTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSETTING.concat(UserSettingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserSetting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserSetting>)QueryUtil.list(q, getDialect(),
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
	 * Removes the user setting where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId)
		throws NoSuchUserSettingException, SystemException {
		UserSetting userSetting = findByUserId(userId);

		remove(userSetting);
	}

	/**
	 * Removes all the user settings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserSetting userSetting : findAll()) {
			remove(userSetting);
		}
	}

	/**
	 * Returns the number of user settings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user settings
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSETTING_WHERE);

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
	 * Returns the number of user settings.
	 *
	 * @return the number of user settings
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSETTING);

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
	 * Initializes the user setting persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.net.sareweb.onddo.model.UserSetting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserSetting>> listenersList = new ArrayList<ModelListener<UserSetting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserSetting>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserSettingImpl.class.getName());
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
	private static final String _SQL_SELECT_USERSETTING = "SELECT userSetting FROM UserSetting userSetting";
	private static final String _SQL_SELECT_USERSETTING_WHERE = "SELECT userSetting FROM UserSetting userSetting WHERE ";
	private static final String _SQL_COUNT_USERSETTING = "SELECT COUNT(userSetting) FROM UserSetting userSetting";
	private static final String _SQL_COUNT_USERSETTING_WHERE = "SELECT COUNT(userSetting) FROM UserSetting userSetting WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userSetting.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSetting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSetting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSetting exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserSettingPersistenceImpl.class);
	private static UserSetting _nullUserSetting = new UserSettingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSetting> toCacheModel() {
				return _nullUserSettingCacheModel;
			}
		};

	private static CacheModel<UserSetting> _nullUserSettingCacheModel = new CacheModel<UserSetting>() {
			public UserSetting toEntityModel() {
				return _nullUserSetting;
			}
		};
}