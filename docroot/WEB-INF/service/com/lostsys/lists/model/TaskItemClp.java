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
import com.lostsys.lists.service.TaskItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskItemClp extends BaseModelImpl<TaskItem> implements TaskItem {
	public TaskItemClp() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_taskItemRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getList() {
		return _list;
	}

	@Override
	public void setList(long list) {
		_list = list;

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setList", long.class);

				method.invoke(_taskItemRemoteModel, list);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_taskItemRemoteModel, label);
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

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setWeight", int.class);

				method.invoke(_taskItemRemoteModel, weight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_taskItemRemoteModel, status);
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

		if (_taskItemRemoteModel != null) {
			try {
				Class<?> clazz = _taskItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_taskItemRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTaskItemRemoteModel() {
		return _taskItemRemoteModel;
	}

	public void setTaskItemRemoteModel(BaseModel<?> taskItemRemoteModel) {
		_taskItemRemoteModel = taskItemRemoteModel;
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

		Class<?> remoteModelClass = _taskItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_taskItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskItemLocalServiceUtil.addTaskItem(this);
		}
		else {
			TaskItemLocalServiceUtil.updateTaskItem(this);
		}
	}

	@Override
	public TaskItem toEscapedModel() {
		return (TaskItem)ProxyUtil.newProxyInstance(TaskItem.class.getClassLoader(),
			new Class[] { TaskItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskItemClp clone = new TaskItemClp();

		clone.setId(getId());
		clone.setList(getList());
		clone.setLabel(getLabel());
		clone.setWeight(getWeight());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(TaskItem taskItem) {
		long primaryKey = taskItem.getPrimaryKey();

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

		if (!(obj instanceof TaskItemClp)) {
			return false;
		}

		TaskItemClp taskItem = (TaskItemClp)obj;

		long primaryKey = taskItem.getPrimaryKey();

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
		sb.append(", list=");
		sb.append(getList());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.lostsys.lists.model.TaskItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>list</column-name><column-value><![CDATA[");
		sb.append(getList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _list;
	private String _label;
	private int _weight;
	private int _status;
	private String _description;
	private BaseModel<?> _taskItemRemoteModel;
}