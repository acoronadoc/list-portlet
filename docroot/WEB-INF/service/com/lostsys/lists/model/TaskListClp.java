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
import com.lostsys.lists.service.TaskListLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskListClp extends BaseModelImpl<TaskList> implements TaskList {
	public TaskListClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_taskListRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortlet() {
		return _portlet;
	}

	@Override
	public void setPortlet(String portlet) {
		_portlet = portlet;

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setPortlet", String.class);

				method.invoke(_taskListRemoteModel, portlet);
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

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_taskListRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(int weight) {
		_weight = weight;

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setWeight", int.class);

				method.invoke(_taskListRemoteModel, weight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRatings() {
		return _ratings;
	}

	@Override
	public void setRatings(int ratings) {
		_ratings = ratings;

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setRatings", int.class);

				method.invoke(_taskListRemoteModel, ratings);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getComments() {
		return _comments;
	}

	@Override
	public void setComments(int comments) {
		_comments = comments;

		if (_taskListRemoteModel != null) {
			try {
				Class<?> clazz = _taskListRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", int.class);

				method.invoke(_taskListRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTaskListRemoteModel() {
		return _taskListRemoteModel;
	}

	public void setTaskListRemoteModel(BaseModel<?> taskListRemoteModel) {
		_taskListRemoteModel = taskListRemoteModel;
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

		Class<?> remoteModelClass = _taskListRemoteModel.getClass();

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

		Object returnValue = method.invoke(_taskListRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskListLocalServiceUtil.addTaskList(this);
		}
		else {
			TaskListLocalServiceUtil.updateTaskList(this);
		}
	}

	@Override
	public TaskList toEscapedModel() {
		return (TaskList)ProxyUtil.newProxyInstance(TaskList.class.getClassLoader(),
			new Class[] { TaskList.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskListClp clone = new TaskListClp();

		clone.setId(getId());
		clone.setPortlet(getPortlet());
		clone.setDescription(getDescription());
		clone.setWeight(getWeight());
		clone.setRatings(getRatings());
		clone.setComments(getComments());

		return clone;
	}

	@Override
	public int compareTo(TaskList taskList) {
		long primaryKey = taskList.getPrimaryKey();

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

		if (!(obj instanceof TaskListClp)) {
			return false;
		}

		TaskListClp taskList = (TaskListClp)obj;

		long primaryKey = taskList.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", portlet=");
		sb.append(getPortlet());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", ratings=");
		sb.append(getRatings());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.lostsys.lists.model.TaskList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portlet</column-name><column-value><![CDATA[");
		sb.append(getPortlet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratings</column-name><column-value><![CDATA[");
		sb.append(getRatings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _portlet;
	private String _description;
	private int _weight;
	private int _ratings;
	private int _comments;
	private BaseModel<?> _taskListRemoteModel;
}