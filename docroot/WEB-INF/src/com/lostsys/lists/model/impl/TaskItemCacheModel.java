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

import com.lostsys.lists.model.TaskItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TaskItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TaskItem
 * @generated
 */
public class TaskItemCacheModel implements CacheModel<TaskItem>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", list=");
		sb.append(list);
		sb.append(", label=");
		sb.append(label);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskItem toEntityModel() {
		TaskItemImpl taskItemImpl = new TaskItemImpl();

		taskItemImpl.setId(id);
		taskItemImpl.setList(list);

		if (label == null) {
			taskItemImpl.setLabel(StringPool.BLANK);
		}
		else {
			taskItemImpl.setLabel(label);
		}

		taskItemImpl.setWeight(weight);
		taskItemImpl.setStatus(status);

		if (description == null) {
			taskItemImpl.setDescription(StringPool.BLANK);
		}
		else {
			taskItemImpl.setDescription(description);
		}

		taskItemImpl.resetOriginalValues();

		return taskItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		list = objectInput.readLong();
		label = objectInput.readUTF();
		weight = objectInput.readInt();
		status = objectInput.readInt();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(list);

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeInt(weight);
		objectOutput.writeInt(status);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long id;
	public long list;
	public String label;
	public int weight;
	public int status;
	public String description;
}