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
 * This class is a wrapper for {@link TaskItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItem
 * @generated
 */
public class TaskItemWrapper implements TaskItem, ModelWrapper<TaskItem> {
	public TaskItemWrapper(TaskItem taskItem) {
		_taskItem = taskItem;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskItem.class;
	}

	@Override
	public String getModelClassName() {
		return TaskItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("list", getList());
		attributes.put("label", getLabel());
		attributes.put("weight", getWeight());
		attributes.put("status", getStatus());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long list = (Long)attributes.get("list");

		if (list != null) {
			setList(list);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this task item.
	*
	* @return the primary key of this task item
	*/
	@Override
	public long getPrimaryKey() {
		return _taskItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task item.
	*
	* @param primaryKey the primary key of this task item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this task item.
	*
	* @return the ID of this task item
	*/
	@Override
	public long getId() {
		return _taskItem.getId();
	}

	/**
	* Sets the ID of this task item.
	*
	* @param id the ID of this task item
	*/
	@Override
	public void setId(long id) {
		_taskItem.setId(id);
	}

	/**
	* Returns the list of this task item.
	*
	* @return the list of this task item
	*/
	@Override
	public long getList() {
		return _taskItem.getList();
	}

	/**
	* Sets the list of this task item.
	*
	* @param list the list of this task item
	*/
	@Override
	public void setList(long list) {
		_taskItem.setList(list);
	}

	/**
	* Returns the label of this task item.
	*
	* @return the label of this task item
	*/
	@Override
	public java.lang.String getLabel() {
		return _taskItem.getLabel();
	}

	/**
	* Sets the label of this task item.
	*
	* @param label the label of this task item
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_taskItem.setLabel(label);
	}

	/**
	* Returns the weight of this task item.
	*
	* @return the weight of this task item
	*/
	@Override
	public int getWeight() {
		return _taskItem.getWeight();
	}

	/**
	* Sets the weight of this task item.
	*
	* @param weight the weight of this task item
	*/
	@Override
	public void setWeight(int weight) {
		_taskItem.setWeight(weight);
	}

	/**
	* Returns the status of this task item.
	*
	* @return the status of this task item
	*/
	@Override
	public int getStatus() {
		return _taskItem.getStatus();
	}

	/**
	* Sets the status of this task item.
	*
	* @param status the status of this task item
	*/
	@Override
	public void setStatus(int status) {
		_taskItem.setStatus(status);
	}

	/**
	* Returns the description of this task item.
	*
	* @return the description of this task item
	*/
	@Override
	public java.lang.String getDescription() {
		return _taskItem.getDescription();
	}

	/**
	* Sets the description of this task item.
	*
	* @param description the description of this task item
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_taskItem.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _taskItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taskItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taskItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taskItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taskItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taskItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taskItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taskItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taskItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taskItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskItemWrapper((TaskItem)_taskItem.clone());
	}

	@Override
	public int compareTo(com.lostsys.lists.model.TaskItem taskItem) {
		return _taskItem.compareTo(taskItem);
	}

	@Override
	public int hashCode() {
		return _taskItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lostsys.lists.model.TaskItem> toCacheModel() {
		return _taskItem.toCacheModel();
	}

	@Override
	public com.lostsys.lists.model.TaskItem toEscapedModel() {
		return new TaskItemWrapper(_taskItem.toEscapedModel());
	}

	@Override
	public com.lostsys.lists.model.TaskItem toUnescapedModel() {
		return new TaskItemWrapper(_taskItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taskItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taskItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taskItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskItemWrapper)) {
			return false;
		}

		TaskItemWrapper taskItemWrapper = (TaskItemWrapper)obj;

		if (Validator.equals(_taskItem, taskItemWrapper._taskItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaskItem getWrappedTaskItem() {
		return _taskItem;
	}

	@Override
	public TaskItem getWrappedModel() {
		return _taskItem;
	}

	@Override
	public void resetOriginalValues() {
		_taskItem.resetOriginalValues();
	}

	private TaskItem _taskItem;
}