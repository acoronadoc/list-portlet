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
 * This class is a wrapper for {@link TaskItemService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TaskItemService
 * @generated
 */
public class TaskItemServiceWrapper implements TaskItemService,
	ServiceWrapper<TaskItemService> {
	public TaskItemServiceWrapper(TaskItemService taskItemService) {
		_taskItemService = taskItemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _taskItemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taskItemService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taskItemService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TaskItemService getWrappedTaskItemService() {
		return _taskItemService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTaskItemService(TaskItemService taskItemService) {
		_taskItemService = taskItemService;
	}

	public TaskItemService getWrappedService() {
		return _taskItemService;
	}

	public void setWrappedService(TaskItemService taskItemService) {
		_taskItemService = taskItemService;
	}

	private TaskItemService _taskItemService;
}