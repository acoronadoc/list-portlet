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

package com.lostsys.lists.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.lostsys.lists.model.TaskItem;
import com.lostsys.lists.model.TaskItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TaskItem service. Represents a row in the &quot;Lostsys_TaskItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.lostsys.lists.model.TaskItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemImpl
 * @see com.lostsys.lists.model.TaskItem
 * @see com.lostsys.lists.model.TaskItemModel
 * @generated
 */
public class TaskItemModelImpl extends BaseModelImpl<TaskItem>
	implements TaskItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task item model instance should use the {@link com.lostsys.lists.model.TaskItem} interface instead.
	 */
	public static final String TABLE_NAME = "Lostsys_TaskItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "list", Types.BIGINT },
			{ "label", Types.VARCHAR },
			{ "weight", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Lostsys_TaskItem (id_ LONG not null primary key,list LONG,label VARCHAR(75) null,weight INTEGER,status INTEGER,description STRING null)";
	public static final String TABLE_SQL_DROP = "drop table Lostsys_TaskItem";
	public static final String ORDER_BY_JPQL = " ORDER BY taskItem.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Lostsys_TaskItem.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.lostsys.lists.model.TaskItem"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.lostsys.lists.model.TaskItem"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.lostsys.lists.model.TaskItem"));

	public TaskItemModelImpl() {
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getList() {
		return _list;
	}

	@Override
	public void setList(long list) {
		_list = list;
	}

	@Override
	public String getLabel() {
		if (_label == null) {
			return StringPool.BLANK;
		}
		else {
			return _label;
		}
	}

	@Override
	public void setLabel(String label) {
		_label = label;
	}

	@Override
	public int getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(int weight) {
		_weight = weight;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TaskItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaskItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TaskItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskItemImpl taskItemImpl = new TaskItemImpl();

		taskItemImpl.setId(getId());
		taskItemImpl.setList(getList());
		taskItemImpl.setLabel(getLabel());
		taskItemImpl.setWeight(getWeight());
		taskItemImpl.setStatus(getStatus());
		taskItemImpl.setDescription(getDescription());

		taskItemImpl.resetOriginalValues();

		return taskItemImpl;
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

		if (!(obj instanceof TaskItem)) {
			return false;
		}

		TaskItem taskItem = (TaskItem)obj;

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<TaskItem> toCacheModel() {
		TaskItemCacheModel taskItemCacheModel = new TaskItemCacheModel();

		taskItemCacheModel.id = getId();

		taskItemCacheModel.list = getList();

		taskItemCacheModel.label = getLabel();

		String label = taskItemCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			taskItemCacheModel.label = null;
		}

		taskItemCacheModel.weight = getWeight();

		taskItemCacheModel.status = getStatus();

		taskItemCacheModel.description = getDescription();

		String description = taskItemCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			taskItemCacheModel.description = null;
		}

		return taskItemCacheModel;
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

	private static ClassLoader _classLoader = TaskItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TaskItem.class
		};
	private long _id;
	private long _list;
	private String _label;
	private int _weight;
	private int _status;
	private String _description;
	private TaskItem _escapedModel;
}