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

import com.lostsys.lists.NoSuchTaskItemException;
import com.lostsys.lists.model.TaskItem;
import com.lostsys.lists.model.impl.TaskItemImpl;
import com.lostsys.lists.model.impl.TaskItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the task item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemPersistence
 * @see TaskItemUtil
 * @generated
 */
public class TaskItemPersistenceImpl extends BasePersistenceImpl<TaskItem>
	implements TaskItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskItemUtil} to access the task item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, TaskItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, TaskItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaskItemPersistenceImpl() {
		setModelClass(TaskItem.class);
	}

	/**
	 * Caches the task item in the entity cache if it is enabled.
	 *
	 * @param taskItem the task item
	 */
	@Override
	public void cacheResult(TaskItem taskItem) {
		EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey(), taskItem);

		taskItem.resetOriginalValues();
	}

	/**
	 * Caches the task items in the entity cache if it is enabled.
	 *
	 * @param taskItems the task items
	 */
	@Override
	public void cacheResult(List<TaskItem> taskItems) {
		for (TaskItem taskItem : taskItems) {
			if (EntityCacheUtil.getResult(
						TaskItemModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemImpl.class, taskItem.getPrimaryKey()) == null) {
				cacheResult(taskItem);
			}
			else {
				taskItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskItem taskItem) {
		EntityCacheUtil.removeResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskItem> taskItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskItem taskItem : taskItems) {
			EntityCacheUtil.removeResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemImpl.class, taskItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task item with the primary key. Does not add the task item to the database.
	 *
	 * @param id the primary key for the new task item
	 * @return the new task item
	 */
	@Override
	public TaskItem create(long id) {
		TaskItem taskItem = new TaskItemImpl();

		taskItem.setNew(true);
		taskItem.setPrimaryKey(id);

		return taskItem;
	}

	/**
	 * Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the task item
	 * @return the task item that was removed
	 * @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem remove(long id)
		throws NoSuchTaskItemException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item that was removed
	 * @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem remove(Serializable primaryKey)
		throws NoSuchTaskItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskItem taskItem = (TaskItem)session.get(TaskItemImpl.class,
					primaryKey);

			if (taskItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskItem);
		}
		catch (NoSuchTaskItemException nsee) {
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
	protected TaskItem removeImpl(TaskItem taskItem) throws SystemException {
		taskItem = toUnwrappedModel(taskItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskItem)) {
				taskItem = (TaskItem)session.get(TaskItemImpl.class,
						taskItem.getPrimaryKeyObj());
			}

			if (taskItem != null) {
				session.delete(taskItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskItem != null) {
			clearCache(taskItem);
		}

		return taskItem;
	}

	@Override
	public TaskItem updateImpl(com.lostsys.lists.model.TaskItem taskItem)
		throws SystemException {
		taskItem = toUnwrappedModel(taskItem);

		boolean isNew = taskItem.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taskItem.isNew()) {
				session.save(taskItem);

				taskItem.setNew(false);
			}
			else {
				session.merge(taskItem);
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

		EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey(), taskItem);

		return taskItem;
	}

	protected TaskItem toUnwrappedModel(TaskItem taskItem) {
		if (taskItem instanceof TaskItemImpl) {
			return taskItem;
		}

		TaskItemImpl taskItemImpl = new TaskItemImpl();

		taskItemImpl.setNew(taskItem.isNew());
		taskItemImpl.setPrimaryKey(taskItem.getPrimaryKey());

		taskItemImpl.setId(taskItem.getId());
		taskItemImpl.setList(taskItem.getList());
		taskItemImpl.setLabel(taskItem.getLabel());
		taskItemImpl.setWeight(taskItem.getWeight());
		taskItemImpl.setStatus(taskItem.getStatus());
		taskItemImpl.setDescription(taskItem.getDescription());

		return taskItemImpl;
	}

	/**
	 * Returns the task item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item
	 * @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskItemException, SystemException {
		TaskItem taskItem = fetchByPrimaryKey(primaryKey);

		if (taskItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskItem;
	}

	/**
	 * Returns the task item with the primary key or throws a {@link com.lostsys.lists.NoSuchTaskItemException} if it could not be found.
	 *
	 * @param id the primary key of the task item
	 * @return the task item
	 * @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem findByPrimaryKey(long id)
		throws NoSuchTaskItemException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item, or <code>null</code> if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaskItem taskItem = (TaskItem)EntityCacheUtil.getResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemImpl.class, primaryKey);

		if (taskItem == _nullTaskItem) {
			return null;
		}

		if (taskItem == null) {
			Session session = null;

			try {
				session = openSession();

				taskItem = (TaskItem)session.get(TaskItemImpl.class, primaryKey);

				if (taskItem != null) {
					cacheResult(taskItem);
				}
				else {
					EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemImpl.class, primaryKey, _nullTaskItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
					TaskItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskItem;
	}

	/**
	 * Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the task item
	 * @return the task item, or <code>null</code> if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the task items.
	 *
	 * @return the task items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task items
	 * @param end the upper bound of the range of task items (not inclusive)
	 * @return the range of task items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task items
	 * @param end the upper bound of the range of task items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItem> findAll(int start, int end,
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

		List<TaskItem> list = (List<TaskItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKITEM;

				if (pagination) {
					sql = sql.concat(TaskItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaskItem>(list);
				}
				else {
					list = (List<TaskItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the task items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaskItem taskItem : findAll()) {
			remove(taskItem);
		}
	}

	/**
	 * Returns the number of task items.
	 *
	 * @return the number of task items
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

				Query q = session.createQuery(_SQL_COUNT_TASKITEM);

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
	 * Initializes the task item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lostsys.lists.model.TaskItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskItem>> listenersList = new ArrayList<ModelListener<TaskItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaskItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TASKITEM = "SELECT taskItem FROM TaskItem taskItem";
	private static final String _SQL_COUNT_TASKITEM = "SELECT COUNT(taskItem) FROM TaskItem taskItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskItem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskItemPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static TaskItem _nullTaskItem = new TaskItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskItem> toCacheModel() {
				return _nullTaskItemCacheModel;
			}
		};

	private static CacheModel<TaskItem> _nullTaskItemCacheModel = new CacheModel<TaskItem>() {
			@Override
			public TaskItem toEntityModel() {
				return _nullTaskItem;
			}
		};
}