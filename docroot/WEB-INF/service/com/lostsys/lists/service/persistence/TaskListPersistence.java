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

import com.liferay.portal.service.persistence.BasePersistence;

import com.lostsys.lists.model.TaskList;

/**
 * The persistence interface for the task list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskListPersistenceImpl
 * @see TaskListUtil
 * @generated
 */
public interface TaskListPersistence extends BasePersistence<TaskList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskListUtil} to access the task list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the task list in the entity cache if it is enabled.
	*
	* @param taskList the task list
	*/
	public void cacheResult(com.lostsys.lists.model.TaskList taskList);

	/**
	* Caches the task lists in the entity cache if it is enabled.
	*
	* @param taskLists the task lists
	*/
	public void cacheResult(
		java.util.List<com.lostsys.lists.model.TaskList> taskLists);

	/**
	* Creates a new task list with the primary key. Does not add the task list to the database.
	*
	* @param id the primary key for the new task list
	* @return the new task list
	*/
	public com.lostsys.lists.model.TaskList create(long id);

	/**
	* Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task list
	* @return the task list that was removed
	* @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskList remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lostsys.lists.NoSuchTaskListException;

	public com.lostsys.lists.model.TaskList updateImpl(
		com.lostsys.lists.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task list with the primary key or throws a {@link com.lostsys.lists.NoSuchTaskListException} if it could not be found.
	*
	* @param id the primary key of the task list
	* @return the task list
	* @throws com.lostsys.lists.NoSuchTaskListException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskList findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lostsys.lists.NoSuchTaskListException;

	/**
	* Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the task list
	* @return the task list, or <code>null</code> if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskList fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the task lists.
	*
	* @return the task lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lostsys.lists.model.TaskList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lostsys.lists.model.TaskList> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lostsys.lists.model.TaskList> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the task lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of task lists.
	*
	* @return the number of task lists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}