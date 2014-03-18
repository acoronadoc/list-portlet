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

import com.lostsys.lists.model.TaskItem;

/**
 * The persistence interface for the task item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemPersistenceImpl
 * @see TaskItemUtil
 * @generated
 */
public interface TaskItemPersistence extends BasePersistence<TaskItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskItemUtil} to access the task item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the task item in the entity cache if it is enabled.
	*
	* @param taskItem the task item
	*/
	public void cacheResult(com.lostsys.lists.model.TaskItem taskItem);

	/**
	* Caches the task items in the entity cache if it is enabled.
	*
	* @param taskItems the task items
	*/
	public void cacheResult(
		java.util.List<com.lostsys.lists.model.TaskItem> taskItems);

	/**
	* Creates a new task item with the primary key. Does not add the task item to the database.
	*
	* @param id the primary key for the new task item
	* @return the new task item
	*/
	public com.lostsys.lists.model.TaskItem create(long id);

	/**
	* Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task item
	* @return the task item that was removed
	* @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskItem remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lostsys.lists.NoSuchTaskItemException;

	public com.lostsys.lists.model.TaskItem updateImpl(
		com.lostsys.lists.model.TaskItem taskItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task item with the primary key or throws a {@link com.lostsys.lists.NoSuchTaskItemException} if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item
	* @throws com.lostsys.lists.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskItem findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.lostsys.lists.NoSuchTaskItemException;

	/**
	* Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item, or <code>null</code> if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.lostsys.lists.model.TaskItem fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the task items.
	*
	* @return the task items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.lostsys.lists.model.TaskItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lostsys.lists.model.TaskItem> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.lostsys.lists.model.TaskItem> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the task items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of task items.
	*
	* @return the number of task items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}