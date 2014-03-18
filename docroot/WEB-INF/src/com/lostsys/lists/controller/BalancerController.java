package com.lostsys.lists.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;

import com.lostsys.lists.util.ModelAndView;

public class BalancerController extends MVCPortlet {

	public void processAction(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		String action="";
		if ( request.getParameter("action")!=null ) action=request.getParameter("action");

		if ( action.equals("addList") ) new AddListController().handleActionRequest(request,response);
		else if ( action.equals("addItem") ) new AddItemController().handleActionRequest(request,response);
		else if ( action.equals("addComment") ) new AddCommentController().handleActionRequest(request,response);
		else new DefaultController().handleActionRequest(request,response);
		}


	public void render(RenderRequest request,RenderResponse response) throws IOException, PortletException {
		String action="";
		if ( request.getParameter("action")!=null ) action=request.getParameter("action");

		ModelAndView mav=null;

		if ( action.equals("addList") ) mav=new AddListController().handleRenderRequest(request,response);
		else if ( action.equals("addItem") ) mav=new AddItemController().handleRenderRequest(request,response);
		else if ( action.equals("addComment") ) mav=new AddCommentController().handleRenderRequest(request,response);
		else mav=new DefaultController().handleRenderRequest(request,response);

		//response.setRenderParameter( "jspPage", "/jsp/lists/"+mav.getPage()+".jsp" );

		Map v=mav.getMap();
		for( int i=0;i<v.keySet().toArray().length;i++ ) {
			String k=""+v.keySet().toArray()[i];

			request.setAttribute( k, v.get( k ) );		
			}

		/* super.render( request, response ); */
		include("/jsp/lists/"+mav.getPage()+".jsp", request, response);
		}

	}


