/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.lostsys.lists.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class TaskListPK implements Comparable<TaskListPK>, Serializable {
	public String portlet;
	public long id;

	public TaskListPK() {
	}

	public TaskListPK(String portlet, long id) {
		this.portlet = portlet;
		this.id = id;
	}

	public String getPortlet() {
		return portlet;
	}

	public void setPortlet(String portlet) {
		this.portlet = portlet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int compareTo(TaskListPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = portlet.compareTo(pk.portlet);

		if (value != 0) {
			return value;
		}

		if (id < pk.id) {
			value = -1;
		}
		else if (id > pk.id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TaskListPK pk = null;

		try {
			pk = (TaskListPK)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		if ((portlet.equals(pk.portlet)) && (id == pk.id)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (String.valueOf(portlet) + String.valueOf(id)).hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("portlet");
		sb.append(StringPool.EQUAL);
		sb.append(portlet);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("id");
		sb.append(StringPool.EQUAL);
		sb.append(id);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}