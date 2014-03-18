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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskItemCommentSoap implements Serializable {
	public static TaskItemCommentSoap toSoapModel(TaskItemComment model) {
		TaskItemCommentSoap soapModel = new TaskItemCommentSoap();

		soapModel.setId(model.getId());
		soapModel.setItem(model.getItem());
		soapModel.setUserid(model.getUserid());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TaskItemCommentSoap[] toSoapModels(TaskItemComment[] models) {
		TaskItemCommentSoap[] soapModels = new TaskItemCommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskItemCommentSoap[][] toSoapModels(
		TaskItemComment[][] models) {
		TaskItemCommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskItemCommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskItemCommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskItemCommentSoap[] toSoapModels(
		List<TaskItemComment> models) {
		List<TaskItemCommentSoap> soapModels = new ArrayList<TaskItemCommentSoap>(models.size());

		for (TaskItemComment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskItemCommentSoap[soapModels.size()]);
	}

	public TaskItemCommentSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getItem() {
		return _item;
	}

	public void setItem(long item) {
		_item = item;
	}

	public long getUserid() {
		return _userid;
	}

	public void setUserid(long userid) {
		_userid = userid;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private long _item;
	private long _userid;
	private String _description;
}