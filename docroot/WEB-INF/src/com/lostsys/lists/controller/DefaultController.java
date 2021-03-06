package com.lostsys.lists.controller;

import com.lostsys.lists.util.ModelAndView;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import javax.portlet.PortletException;

import com.lostsys.lists.service.TaskListLocalServiceUtil;
import com.lostsys.lists.model.TaskList;
import com.lostsys.lists.service.TaskItemLocalServiceUtil;
import com.lostsys.lists.model.TaskItem;
import com.lostsys.lists.service.TaskItemCommentLocalServiceUtil;
import com.lostsys.lists.model.TaskItemComment;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;

public class DefaultController {

	public void handleActionRequest(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		}

	public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		Map<String, Object> model = new HashMap<String, Object>();

		try {

		if ( request.getParameter("order")!=null ) 
			model.put("order", request.getParameter("order") );

		/* viewItem */
		String itemid=request.getParameter("itemid");

		if ( itemid!=null ) {
			TaskItem l=TaskItemLocalServiceUtil.getTaskItem( Integer.parseInt( itemid ) );
			TaskList lObj=TaskListLocalServiceUtil.getTaskList( l.getList() );

			DynamicQuery dq=DynamicQueryFactoryUtil.forClass( TaskItemComment.class );
			dq.add( PropertyFactoryUtil.forName( "item" ).eq( l.getId() ) );
			dq.addOrder( PropertyFactoryUtil.forName( "id" ).asc() );

			List<TaskItemComment> cs=TaskItemCommentLocalServiceUtil.dynamicQuery( dq );
			
			model.put( "listObj", lObj);
			model.put( "comments", cs );
			model.put( "item", l );
			model.put( "list", ""+l.getList() );
			model.put( "statuses", new String[] { "Normal","Waiting for","Cancelled","Finished" } );

			return new ModelAndView("viewitem", model);
			}
		
		/* Read params */
		String tab=request.getParameter("tabs1");
		String listid=request.getParameter("list");
		String order=request.getParameter("order");

		if ( tab==null ) tab="";
		if ( order==null ) order="weight";
		if ( order.equals("") ) order="weight";

		model.put("formTab", tab );

		/* Load Lists */
		DynamicQuery dq=DynamicQueryFactoryUtil.forClass( TaskList.class );
		dq.add( PropertyFactoryUtil.forName( "portlet" ).eq( ConfigurationActionImpl.getScope( request, response ) ) );
		dq.addOrder( PropertyFactoryUtil.forName( "weight" ).asc() );
		List<TaskList> ls=TaskListLocalServiceUtil.dynamicQuery( dq );
		
		for ( int i=0; i<ls.size(); i++ ) {
			TaskList l=ls.get( i );
			if ( i==0 && listid==null ) listid=""+l.getId();

			if ( (""+l.getId()).equals( listid ) || (l.getDescription().equals( tab ) && !tab.equals("") ) ) {
				model.put("formTab", l.getDescription() );
				model.put("list", l.getId() );
				}				
			}
		
		model.put("tabList", ls);
		
		/* Load Items */
		DynamicQuery dqi=DynamicQueryFactoryUtil.forClass( TaskItem.class );
		dqi.add( PropertyFactoryUtil.forName( "list" ).eq( model.get("list") ) );
		dqi.addOrder( PropertyFactoryUtil.forName( order ).asc() );

		List<TaskItem> is=TaskItemLocalServiceUtil.dynamicQuery( dqi );
		model.put("itemList", is);

		} catch (Exception ex) { ex.printStackTrace(); }

		return new ModelAndView("view", model);
		}

}
