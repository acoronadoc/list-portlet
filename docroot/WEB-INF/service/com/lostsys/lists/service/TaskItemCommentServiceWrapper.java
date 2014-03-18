/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.lostsys.lists.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TaskItemCommentService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TaskItemCommentService
 * @generated
 */
public class TaskItemCommentServiceWrapper implements TaskItemCommentService,
	ServiceWrapper<TaskItemCommentService> {
	public TaskItemCommentServiceWrapper(
		TaskItemCommentService taskItemCommentService) {
		_taskItemCommentService = taskItemCommentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _taskItemCommentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taskItemCommentService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taskItemCommentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TaskItemCommentService getWrappedTaskItemCommentService() {
		return _taskItemCommentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTaskItemCommentService(
		TaskItemCommentService taskItemCommentService) {
		_taskItemCommentService = taskItemCommentService;
	}

	public TaskItemCommentService getWrappedService() {
		return _taskItemCommentService;
	}

	public void setWrappedService(TaskItemCommentService taskItemCommentService) {
		_taskItemCommentService = taskItemCommentService;
	}

	private TaskItemCommentService _taskItemCommentService;
}