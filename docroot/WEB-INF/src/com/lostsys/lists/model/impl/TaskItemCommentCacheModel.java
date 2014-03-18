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

import com.lostsys.lists.model.TaskItemComment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TaskItemComment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TaskItemComment
 * @generated
 */
public class TaskItemCommentCacheModel implements CacheModel<TaskItemComment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", item=");
		sb.append(item);
		sb.append(", userid=");
		sb.append(userid);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskItemComment toEntityModel() {
		TaskItemCommentImpl taskItemCommentImpl = new TaskItemCommentImpl();

		taskItemCommentImpl.setId(id);
		taskItemCommentImpl.setItem(item);
		taskItemCommentImpl.setUserid(userid);

		if (description == null) {
			taskItemCommentImpl.setDescription(StringPool.BLANK);
		}
		else {
			taskItemCommentImpl.setDescription(description);
		}

		taskItemCommentImpl.resetOriginalValues();

		return taskItemCommentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		item = objectInput.readLong();
		userid = objectInput.readLong();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(item);
		objectOutput.writeLong(userid);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long id;
	public long item;
	public long userid;
	public String description;
}