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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.lostsys.lists.model.TaskList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TaskList in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TaskList
 * @generated
 */
public class TaskListCacheModel implements CacheModel<TaskList>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", portlet=");
		sb.append(portlet);
		sb.append(", description=");
		sb.append(description);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", ratings=");
		sb.append(ratings);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskList toEntityModel() {
		TaskListImpl taskListImpl = new TaskListImpl();

		taskListImpl.setId(id);

		if (portlet == null) {
			taskListImpl.setPortlet(StringPool.BLANK);
		}
		else {
			taskListImpl.setPortlet(portlet);
		}

		if (description == null) {
			taskListImpl.setDescription(StringPool.BLANK);
		}
		else {
			taskListImpl.setDescription(description);
		}

		taskListImpl.setWeight(weight);
		taskListImpl.setRatings(ratings);
		taskListImpl.setComments(comments);

		taskListImpl.resetOriginalValues();

		return taskListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		portlet = objectInput.readUTF();
		description = objectInput.readUTF();
		weight = objectInput.readInt();
		ratings = objectInput.readInt();
		comments = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (portlet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portlet);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(weight);
		objectOutput.writeInt(ratings);
		objectOutput.writeInt(comments);
	}

	public long id;
	public String portlet;
	public String description;
	public int weight;
	public int ratings;
	public int comments;
}