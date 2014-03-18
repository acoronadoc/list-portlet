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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.lostsys.lists.service.ClpSerializer;
import com.lostsys.lists.service.TaskItemCommentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskItemCommentClp extends BaseModelImpl<TaskItemComment>
	implements TaskItemComment {
	public TaskItemCommentClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_taskItemCommentRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemCommentRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_taskItemCommentRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItem() {
		return _item;
	}

	@Override
	public void setItem(long item) {
		_item = item;

		if (_taskItemCommentRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemCommentRemoteModel.getClass();

				Method method = clazz.getMethod("setItem", long.class);

				method.invoke(_taskItemCommentRemoteModel, item);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserid() {
		return _userid;
	}

	@Override
	public void setUserid(long userid) {
		_userid = userid;

		if (_taskItemCommentRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemCommentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserid", long.class);

				method.invoke(_taskItemCommentRemoteModel, userid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_taskItemCommentRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemCommentRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_taskItemCommentRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTaskItemCommentRemoteModel() {
		return _taskItemCommentRemoteModel;
	}

	public void setTaskItemCommentRemoteModel(
		BaseModel<?> taskItemCommentRemoteModel) {
		_taskItemCommentRemoteModel = taskItemCommentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _taskItemCommentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_taskItemCommentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskItemCommentLocalServiceUtil.addTaskItemComment(this);
		}
		else {
			TaskItemCommentLocalServiceUtil.updateTaskItemComment(this);
		}
	}

	@Override
	public TaskItemComment toEscapedModel() {
		return (TaskItemComment)ProxyUtil.newProxyInstance(TaskItemComment.class.getClassLoader(),
			new Class[] { TaskItemComment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskItemCommentClp clone = new TaskItemCommentClp();

		clone.setId(getId());
		clone.setItem(getItem());
		clone.setUserid(getUserid());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(TaskItemComment taskItemComment) {
		long primaryKey = taskItemComment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskItemCommentClp)) {
			return false;
		}

		TaskItemCommentClp taskItemComment = (TaskItemCommentClp)obj;

		long primaryKey = taskItemComment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", item=");
		sb.append(getItem());
		sb.append(", userid=");
		sb.append(getUserid());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.lostsys.lists.model.TaskItemComment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>item</column-name><column-value><![CDATA[");
		sb.append(getItem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userid</column-name><column-value><![CDATA[");
		sb.append(getUserid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _item;
	private long _userid;
	private String _description;
	private BaseModel<?> _taskItemCommentRemoteModel;
}