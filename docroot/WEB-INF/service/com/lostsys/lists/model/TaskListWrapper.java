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

package com.lostsys.lists.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaskList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskList
 * @generated
 */
public class TaskListWrapper implements TaskList, ModelWrapper<TaskList> {
	public TaskListWrapper(TaskList taskList) {
		_taskList = taskList;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskList.class;
	}

	@Override
	public String getModelClassName() {
		return TaskList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("portlet", getPortlet());
		attributes.put("description", getDescription());
		attributes.put("weight", getWeight());
		attributes.put("ratings", getRatings());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String portlet = (String)attributes.get("portlet");

		if (portlet != null) {
			setPortlet(portlet);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Integer ratings = (Integer)attributes.get("ratings");

		if (ratings != null) {
			setRatings(ratings);
		}

		Integer comments = (Integer)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this task list.
	*
	* @return the primary key of this task list
	*/
	@Override
	public long getPrimaryKey() {
		return _taskList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task list.
	*
	* @param primaryKey the primary key of this task list
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this task list.
	*
	* @return the ID of this task list
	*/
	@Override
	public long getId() {
		return _taskList.getId();
	}

	/**
	* Sets the ID of this task list.
	*
	* @param id the ID of this task list
	*/
	@Override
	public void setId(long id) {
		_taskList.setId(id);
	}

	/**
	* Returns the portlet of this task list.
	*
	* @return the portlet of this task list
	*/
	@Override
	public java.lang.String getPortlet() {
		return _taskList.getPortlet();
	}

	/**
	* Sets the portlet of this task list.
	*
	* @param portlet the portlet of this task list
	*/
	@Override
	public void setPortlet(java.lang.String portlet) {
		_taskList.setPortlet(portlet);
	}

	/**
	* Returns the description of this task list.
	*
	* @return the description of this task list
	*/
	@Override
	public java.lang.String getDescription() {
		return _taskList.getDescription();
	}

	/**
	* Sets the description of this task list.
	*
	* @param description the description of this task list
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_taskList.setDescription(description);
	}

	/**
	* Returns the weight of this task list.
	*
	* @return the weight of this task list
	*/
	@Override
	public int getWeight() {
		return _taskList.getWeight();
	}

	/**
	* Sets the weight of this task list.
	*
	* @param weight the weight of this task list
	*/
	@Override
	public void setWeight(int weight) {
		_taskList.setWeight(weight);
	}

	/**
	* Returns the ratings of this task list.
	*
	* @return the ratings of this task list
	*/
	@Override
	public int getRatings() {
		return _taskList.getRatings();
	}

	/**
	* Sets the ratings of this task list.
	*
	* @param ratings the ratings of this task list
	*/
	@Override
	public void setRatings(int ratings) {
		_taskList.setRatings(ratings);
	}

	/**
	* Returns the comments of this task list.
	*
	* @return the comments of this task list
	*/
	@Override
	public int getComments() {
		return _taskList.getComments();
	}

	/**
	* Sets the comments of this task list.
	*
	* @param comments the comments of this task list
	*/
	@Override
	public void setComments(int comments) {
		_taskList.setComments(comments);
	}

	@Override
	public boolean isNew() {
		return _taskList.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taskList.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taskList.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskList.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taskList.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taskList.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taskList.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taskList.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taskList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taskList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taskList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskListWrapper((TaskList)_taskList.clone());
	}

	@Override
	public int compareTo(com.lostsys.lists.model.TaskList taskList) {
		return _taskList.compareTo(taskList);
	}

	@Override
	public int hashCode() {
		return _taskList.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lostsys.lists.model.TaskList> toCacheModel() {
		return _taskList.toCacheModel();
	}

	@Override
	public com.lostsys.lists.model.TaskList toEscapedModel() {
		return new TaskListWrapper(_taskList.toEscapedModel());
	}

	@Override
	public com.lostsys.lists.model.TaskList toUnescapedModel() {
		return new TaskListWrapper(_taskList.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taskList.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taskList.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taskList.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskListWrapper)) {
			return false;
		}

		TaskListWrapper taskListWrapper = (TaskListWrapper)obj;

		if (Validator.equals(_taskList, taskListWrapper._taskList)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaskList getWrappedTaskList() {
		return _taskList;
	}

	@Override
	public TaskList getWrappedModel() {
		return _taskList;
	}

	@Override
	public void resetOriginalValues() {
		_taskList.resetOriginalValues();
	}

	private TaskList _taskList;
}