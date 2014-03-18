package com.lostsys.lists.controller;

import com.lostsys.lists.util.ModelAndView;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.io.IOException;
import javax.portlet.PortletException;

import java.util.Map;
import java.util.HashMap;

import com.lostsys.lists.service.TaskListLocalServiceUtil;
import com.lostsys.lists.model.TaskList;
import com.lostsys.lists.service.persistence.TaskListPK;

import com.liferay.counter.service.CounterLocalServiceUtil;

public class AddListController {

	public void handleActionRequest(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		try {
		int id=-1;
		if ( request.getParameter("id")!=null ) {
			id=Integer.parseInt( request.getParameter("id") );
			}

		response.setRenderParameter("action","view");
		if ( request.getParameter("order")!=null ) 
			response.setRenderParameter("order", request.getParameter("order") );

		if ( request.getParameter("delete")!=null ) {
			TaskListLocalServiceUtil.deleteTaskList( (long) id );

			return;
			}

		TaskList l;
		if ( id==-1 )
			l=TaskListLocalServiceUtil.createTaskList( CounterLocalServiceUtil.increment(TaskList.class.getName()) );
			else
			l=TaskListLocalServiceUtil.getTaskList( id );

		l.setPortlet( ConfigurationActionImpl.getScope( request, response ) );
		l.setDescription( request.getParameter("description") );
		l.setWeight( Integer.parseInt( request.getParameter("weight") ) );

		l.setRatings( Integer.parseInt( request.getParameter("ratings") ) );
		l.setComments( Integer.parseInt( request.getParameter("comments") ) );

		if ( id==-1 )
			TaskListLocalServiceUtil.addTaskList( l );
			else
			TaskListLocalServiceUtil.updateTaskList( l );

		response.setRenderParameter("list", ""+l.getId() );
		} catch (Exception ex) { ex.printStackTrace(); }
		}

	public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		Map<String, Object> model = new HashMap<String, Object>();

		try {
		String list=request.getParameter("id");

		if ( list!=null ) {
				TaskList l=TaskListLocalServiceUtil.getTaskList( Integer.parseInt( list ) );

				model.put( "item", l );
				}

		model.put( "list", request.getParameter("list") );
		if ( request.getParameter("order")!=null ) 
			model.put("order", request.getParameter("order") );
		} catch (Exception ex) { ex.printStackTrace(); }

		return new ModelAndView("addlist", model);
		}

}
