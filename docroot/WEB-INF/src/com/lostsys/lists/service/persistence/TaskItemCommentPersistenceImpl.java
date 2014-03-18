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

import com.lostsys.lists.NoSuchTaskItemCommentException;
import com.lostsys.lists.model.TaskItemComment;
import com.lostsys.lists.model.impl.TaskItemCommentImpl;
import com.lostsys.lists.model.impl.TaskItemCommentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the task item comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemCommentPersistence
 * @see TaskItemCommentUtil
 * @generated
 */
public class TaskItemCommentPersistenceImpl extends BasePersistenceImpl<TaskItemComment>
	implements TaskItemCommentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskItemCommentUtil} to access the task item comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskItemCommentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentModelImpl.FINDER_CACHE_ENABLED,
			TaskItemCommentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentModelImpl.FINDER_CACHE_ENABLED,
			TaskItemCommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TaskItemCommentPersistenceImpl() {
		setModelClass(TaskItemComment.class);
	}

	/**
	 * Caches the task item comment in the entity cache if it is enabled.
	 *
	 * @param taskItemComment the task item comment
	 */
	@Override
	public void cacheResult(TaskItemComment taskItemComment) {
		EntityCacheUtil.putResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentImpl.class, taskItemComment.getPrimaryKey(),
			taskItemComment);

		taskItemComment.resetOriginalValues();
	}

	/**
	 * Caches the task item comments in the entity cache if it is enabled.
	 *
	 * @param taskItemComments the task item comments
	 */
	@Override
	public void cacheResult(List<TaskItemComment> taskItemComments) {
		for (TaskItemComment taskItemComment : taskItemComments) {
			if (EntityCacheUtil.getResult(
						TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemCommentImpl.class,
						taskItemComment.getPrimaryKey()) == null) {
				cacheResult(taskItemComment);
			}
			else {
				taskItemComment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task item comments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskItemCommentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskItemCommentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task item comment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskItemComment taskItemComment) {
		EntityCacheUtil.removeResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentImpl.class, taskItemComment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskItemComment> taskItemComments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskItemComment taskItemComment : taskItemComments) {
			EntityCacheUtil.removeResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemCommentImpl.class, taskItemComment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task item comment with the primary key. Does not add the task item comment to the database.
	 *
	 * @param id the primary key for the new task item comment
	 * @return the new task item comment
	 */
	@Override
	public TaskItemComment create(long id) {
		TaskItemComment taskItemComment = new TaskItemCommentImpl();

		taskItemComment.setNew(true);
		taskItemComment.setPrimaryKey(id);

		return taskItemComment;
	}

	/**
	 * Removes the task item comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the task item comment
	 * @return the task item comment that was removed
	 * @throws com.lostsys.lists.NoSuchTaskItemCommentException if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment remove(long id)
		throws NoSuchTaskItemCommentException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the task item comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task item comment
	 * @return the task item comment that was removed
	 * @throws com.lostsys.lists.NoSuchTaskItemCommentException if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment remove(Serializable primaryKey)
		throws NoSuchTaskItemCommentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskItemComment taskItemComment = (TaskItemComment)session.get(TaskItemCommentImpl.class,
					primaryKey);

			if (taskItemComment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskItemCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskItemComment);
		}
		catch (NoSuchTaskItemCommentException nsee) {
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
	protected TaskItemComment removeImpl(TaskItemComment taskItemComment)
		throws SystemException {
		taskItemComment = toUnwrappedModel(taskItemComment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskItemComment)) {
				taskItemComment = (TaskItemComment)session.get(TaskItemCommentImpl.class,
						taskItemComment.getPrimaryKeyObj());
			}

			if (taskItemComment != null) {
				session.delete(taskItemComment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskItemComment != null) {
			clearCache(taskItemComment);
		}

		return taskItemComment;
	}

	@Override
	public TaskItemComment updateImpl(
		com.lostsys.lists.model.TaskItemComment taskItemComment)
		throws SystemException {
		taskItemComment = toUnwrappedModel(taskItemComment);

		boolean isNew = taskItemComment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taskItemComment.isNew()) {
				session.save(taskItemComment);

				taskItemComment.setNew(false);
			}
			else {
				session.merge(taskItemComment);
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

		EntityCacheUtil.putResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemCommentImpl.class, taskItemComment.getPrimaryKey(),
			taskItemComment);

		return taskItemComment;
	}

	protected TaskItemComment toUnwrappedModel(TaskItemComment taskItemComment) {
		if (taskItemComment instanceof TaskItemCommentImpl) {
			return taskItemComment;
		}

		TaskItemCommentImpl taskItemCommentImpl = new TaskItemCommentImpl();

		taskItemCommentImpl.setNew(taskItemComment.isNew());
		taskItemCommentImpl.setPrimaryKey(taskItemComment.getPrimaryKey());

		taskItemCommentImpl.setId(taskItemComment.getId());
		taskItemCommentImpl.setItem(taskItemComment.getItem());
		taskItemCommentImpl.setUserid(taskItemComment.getUserid());
		taskItemCommentImpl.setDescription(taskItemComment.getDescription());

		return taskItemCommentImpl;
	}

	/**
	 * Returns the task item comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item comment
	 * @return the task item comment
	 * @throws com.lostsys.lists.NoSuchTaskItemCommentException if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskItemCommentException, SystemException {
		TaskItemComment taskItemComment = fetchByPrimaryKey(primaryKey);

		if (taskItemComment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskItemCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskItemComment;
	}

	/**
	 * Returns the task item comment with the primary key or throws a {@link com.lostsys.lists.NoSuchTaskItemCommentException} if it could not be found.
	 *
	 * @param id the primary key of the task item comment
	 * @return the task item comment
	 * @throws com.lostsys.lists.NoSuchTaskItemCommentException if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment findByPrimaryKey(long id)
		throws NoSuchTaskItemCommentException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the task item comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item comment
	 * @return the task item comment, or <code>null</code> if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaskItemComment taskItemComment = (TaskItemComment)EntityCacheUtil.getResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemCommentImpl.class, primaryKey);

		if (taskItemComment == _nullTaskItemComment) {
			return null;
		}

		if (taskItemComment == null) {
			Session session = null;

			try {
				session = openSession();

				taskItemComment = (TaskItemComment)session.get(TaskItemCommentImpl.class,
						primaryKey);

				if (taskItemComment != null) {
					cacheResult(taskItemComment);
				}
				else {
					EntityCacheUtil.putResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemCommentImpl.class, primaryKey,
						_nullTaskItemComment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaskItemCommentModelImpl.ENTITY_CACHE_ENABLED,
					TaskItemCommentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskItemComment;
	}

	/**
	 * Returns the task item comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the task item comment
	 * @return the task item comment, or <code>null</code> if a task item comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItemComment fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the task item comments.
	 *
	 * @return the task item comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItemComment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task item comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskItemCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task item comments
	 * @param end the upper bound of the range of task item comments (not inclusive)
	 * @return the range of task item comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItemComment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task item comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.lostsys.lists.model.impl.TaskItemCommentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of task item comments
	 * @param end the upper bound of the range of task item comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task item comments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskItemComment> findAll(int start, int end,
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

		List<TaskItemComment> list = (List<TaskItemComment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKITEMCOMMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKITEMCOMMENT;

				if (pagination) {
					sql = sql.concat(TaskItemCommentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskItemComment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaskItemComment>(list);
				}
				else {
					list = (List<TaskItemComment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the task item comments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaskItemComment taskItemComment : findAll()) {
			remove(taskItemComment);
		}
	}

	/**
	 * Returns the number of task item comments.
	 *
	 * @return the number of task item comments
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

				Query q = session.createQuery(_SQL_COUNT_TASKITEMCOMMENT);

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
	 * Initializes the task item comment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.lostsys.lists.model.TaskItemComment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskItemComment>> listenersList = new ArrayList<ModelListener<TaskItemComment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskItemComment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaskItemCommentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TASKITEMCOMMENT = "SELECT taskItemComment FROM TaskItemComment taskItemComment";
	private static final String _SQL_COUNT_TASKITEMCOMMENT = "SELECT COUNT(taskItemComment) FROM TaskItemComment taskItemComment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskItemComment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskItemComment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskItemCommentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static TaskItemComment _nullTaskItemComment = new TaskItemCommentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskItemComment> toCacheModel() {
				return _nullTaskItemCommentCacheModel;
			}
		};

	private static CacheModel<TaskItemComment> _nullTaskItemCommentCacheModel = new CacheModel<TaskItemComment>() {
			@Override
			public TaskItemComment toEntityModel() {
				return _nullTaskItemComment;
			}
		};
}