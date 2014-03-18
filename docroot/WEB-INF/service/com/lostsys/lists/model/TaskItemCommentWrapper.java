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
 * This class is a wrapper for {@link TaskItemComment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemComment
 * @generated
 */
public class TaskItemCommentWrapper implements TaskItemComment,
	ModelWrapper<TaskItemComment> {
	public TaskItemCommentWrapper(TaskItemComment taskItemComment) {
		_taskItemComment = taskItemComment;
	}

	@Override
	public Class<?> getModelClass() {
		return TaskItemComment.class;
	}

	@Override
	public String getModelClassName() {
		return TaskItemComment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("item", getItem());
		attributes.put("userid", getUserid());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long item = (Long)attributes.get("item");

		if (item != null) {
			setItem(item);
		}

		Long userid = (Long)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this task item comment.
	*
	* @return the primary key of this task item comment
	*/
	@Override
	public long getPrimaryKey() {
		return _taskItemComment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task item comment.
	*
	* @param primaryKey the primary key of this task item comment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taskItemComment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this task item comment.
	*
	* @return the ID of this task item comment
	*/
	@Override
	public long getId() {
		return _taskItemComment.getId();
	}

	/**
	* Sets the ID of this task item comment.
	*
	* @param id the ID of this task item comment
	*/
	@Override
	public void setId(long id) {
		_taskItemComment.setId(id);
	}

	/**
	* Returns the item of this task item comment.
	*
	* @return the item of this task item comment
	*/
	@Override
	public long getItem() {
		return _taskItemComment.getItem();
	}

	/**
	* Sets the item of this task item comment.
	*
	* @param item the item of this task item comment
	*/
	@Override
	public void setItem(long item) {
		_taskItemComment.setItem(item);
	}

	/**
	* Returns the userid of this task item comment.
	*
	* @return the userid of this task item comment
	*/
	@Override
	public long getUserid() {
		return _taskItemComment.getUserid();
	}

	/**
	* Sets the userid of this task item comment.
	*
	* @param userid the userid of this task item comment
	*/
	@Override
	public void setUserid(long userid) {
		_taskItemComment.setUserid(userid);
	}

	/**
	* Returns the description of this task item comment.
	*
	* @return the description of this task item comment
	*/
	@Override
	public java.lang.String getDescription() {
		return _taskItemComment.getDescription();
	}

	/**
	* Sets the description of this task item comment.
	*
	* @param description the description of this task item comment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_taskItemComment.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _taskItemComment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taskItemComment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taskItemComment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taskItemComment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taskItemComment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taskItemComment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taskItemComment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taskItemComment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taskItemComment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taskItemComment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taskItemComment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskItemCommentWrapper((TaskItemComment)_taskItemComment.clone());
	}

	@Override
	public int compareTo(
		com.lostsys.lists.model.TaskItemComment taskItemComment) {
		return _taskItemComment.compareTo(taskItemComment);
	}

	@Override
	public int hashCode() {
		return _taskItemComment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.lostsys.lists.model.TaskItemComment> toCacheModel() {
		return _taskItemComment.toCacheModel();
	}

	@Override
	public com.lostsys.lists.model.TaskItemComment toEscapedModel() {
		return new TaskItemCommentWrapper(_taskItemComment.toEscapedModel());
	}

	@Override
	public com.lostsys.lists.model.TaskItemComment toUnescapedModel() {
		return new TaskItemCommentWrapper(_taskItemComment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taskItemComment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taskItemComment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taskItemComment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskItemCommentWrapper)) {
			return false;
		}

		TaskItemCommentWrapper taskItemCommentWrapper = (TaskItemCommentWrapper)obj;

		if (Validator.equals(_taskItemComment,
					taskItemCommentWrapper._taskItemComment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaskItemComment getWrappedTaskItemComment() {
		return _taskItemComment;
	}

	@Override
	public TaskItemComment getWrappedModel() {
		return _taskItemComment;
	}

	@Override
	public void resetOriginalValues() {
		_taskItemComment.resetOriginalValues();
	}

	private TaskItemComment _taskItemComment;
}