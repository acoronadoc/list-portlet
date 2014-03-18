/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.lostsys.lists.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.lostsys.lists.NoSuchTaskListException;
import com.lostsys.lists.model.TaskList;
import com.lostsys.lists.model.impl.TaskListImpl;
import com.lostsys.lists.model.impl.TaskListModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the task list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskListPersistence
 * @see TaskListUtil
 * @generated
 */
public class TaskListPersistenceImpl extends BasePersistenceImpl<TaskList>
	implements TaskListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskListUtil} to access the task list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, TaskListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, TaskListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaskListPersistenceImpl() {
		setModelClass(TaskList.class);
	}

	/**
	 * Caches the task list in the entity cache if it is enabled.
	 *
	 * @param taskList the task list
	 */
	@Override
	public void cacheResult(TaskList taskList) {
		EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey(), taskList);

		taskList.resetOriginalValues();
	}

	/**
	 * Caches the task lists in the entity cache if it is enabled.
	 *
	 * @param taskLists the task lists
	 */
	@Override
	public void cacheResult(List<TaskList> taskLists) {
		for (TaskList taskList : taskLists) {
			if (EntityCacheUtil.getResult(
						TaskListModelImpl.ENTITY_CACHE_ENABLED,
						TaskListImpl.class, taskList.getPrimaryKey()) == null) {
				cacheResult(taskList);
			}
			else {
				taskList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskList taskList) {
		EntityCacheUtil.removeResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskList> taskLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskList taskList : taskLists) {
			EntityCacheUtil.removeResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
				TaskListImpl.class, taskList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task list with the primary key. Does not add the task list to the database.
	 *
	 * @param id the primary key for the new task list
	 * @return the new task list
	 */
	@Override
	public TaskList create(long id) {
		TaskList taskList = new TaskListImpl();

		taskList.setNew(true);
		taskList.setPrimaryKey(id);

		return taskList;
	}

	/**
	 * Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the task list
	 * @return the task list that was removed
	 * @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList remove(long id)
		throws NoSuchTaskListException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list that was removed
	 * @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList remove(Serializable primaryKey)
		throws NoSuchTaskListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskList taskList = (TaskList)session.get(TaskListImpl.class,
					primaryKey);

			if (taskList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskList);
		}
		catch (NoSuchTaskListException nsee) {
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
	protected TaskList removeImpl(TaskList taskList) throws SystemException {
		taskList = toUnwrappedModel(taskList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskList)) {
				taskList = (TaskList)session.get(TaskListImpl.class,
						taskList.getPrimaryKeyObj());
			}

			if (taskList != null) {
				session.delete(taskList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskList != null) {
			clearCache(taskList);
		}

		return taskList;
	}

	@Override
	public TaskList updateImpl(com.lostsys.lists.model.TaskList taskList)
		throws SystemException {
		taskList = toUnwrappedModel(taskList);

		boolean isNew = taskList.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taskList.isNew()) {
				session.save(taskList);

				taskList.setNew(false);
			}
			else {
				session.merge(taskList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey(), taskList);

		return taskList;
	}

	protected TaskList toUnwrappedModel(TaskList taskList) {
		if (taskList instanceof TaskListImpl) {
			return taskList;
		}

		TaskListImpl taskListImpl = new TaskListImpl();

		taskListImpl.setNew(taskList.isNew());
		taskListImpl.setPrimaryKey(taskList.getPrimaryKey());

		taskListImpl.setId(taskList.getId());
		taskListImpl.setPortlet(taskList.getPortlet());
		taskListImpl.setDescription(taskList.getDescription());
		taskListImpl.setWeight(taskList.getWeight());
		taskListImpl.setRatings(taskList.getRatings());
		taskListImpl.setComments(taskList.getComments());

		return taskListImpl;
	}

	/**
	 * Returns the task list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list
	 * @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskListException, SystemException {
		TaskList taskList = fetchByPrimaryKey(primaryKey);

		if (taskList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskList;
	}

	/**
	 * Returns the task list with the primary key or throws a {@link com.lostsys.lists.NoSuchTaskListException} if it could not be found.
	 *
	 * @param id the primary key of the task list
	 * @return the task list
	 * @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList findByPrimaryKey(long id)
		throws NoSuchTaskListException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list, or <code>null</code> if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaskList taskList = (TaskList)EntityCacheUtil.getResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
				TaskListImpl.class, primaryKey);

		if (taskList == _nullTaskList) {
			return null;
		}

		if (taskList == null) {
			Session session = null;

			try {
				session = openSession();

				taskList = (TaskList)session.get(TaskListImpl.class, primaryKey);

				if (taskList != null) {
					cacheResult(taskList);
				}
				else {
					EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
						TaskListImpl.class, primaryKey, _nullTaskList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
					TaskListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskList;
	}

	/**
	 * Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the task list
	 * @return the task list, or <code>null</code> if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the task lists.
	 *
	 * @return the task lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task lists
	 * @param end the upper bound of the range of task lists (not inclusive)
	 * @return the range of task lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskList> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task lists
	 * @param end the upper bound of the range of task lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskList> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TaskList> list = (List<TaskList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKLIST;

				if (pagination) {
					sql = sql.concat(TaskListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaskList>(list);
				}
				else {
					list = (List<TaskList>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the task lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaskList taskList : findAll()) {
			remove(taskList);
		}
	}

	/**
	 * Returns the number of task lists.
	 *
	 * @return the number of task lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKLIST);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the task list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lostsys.lists.model.TaskList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskList>> listenersList = new ArrayList<ModelListener<TaskList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskList>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TaskListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TASKLIST = "SELECT taskList FROM TaskList taskList";
	private static final String _SQL_COUNT_TASKLIST = "SELECT COUNT(taskList) FROM TaskList taskList";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskList exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskListPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static TaskList _nullTaskList = new TaskListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskList> toCacheModel() {
				return _nullTaskListCacheModel;
			}
		};

	private static CacheModel<TaskList> _nullTaskListCacheModel = new CacheModel<TaskList>() {
			@Override
			public TaskList toEntityModel() {
				return _nullTaskList;
			}
		};
}