package com.lostsys.lists.controller;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction( PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest,portletResource);

		int scope=ParamUtil.getInteger(actionRequest, "scope", 0);
		prefs.setValue( "scope", ""+scope );
		prefs.store();
		}

	public String render( PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest,portletResource);

		renderRequest.setAttribute( "scope_"+prefs.getValue("scope","0"), "selected" );

		return "/jsp/lists/config.jsp";
		}

	static public String getScope(javax.portlet.PortletRequest portletRequest, javax.portlet.PortletResponse portletResponse) throws Exception {
		ThemeDisplay themeDisplay =(ThemeDisplay) portletRequest.getAttribute("THEME_DISPLAY");

		String portletResource = portletResponse.getNamespace();
		if ( portletResource.startsWith("_") ) portletResource=portletResource.substring( 1, portletResource.length() );
		if ( portletResource.endsWith("_") ) portletResource=portletResource.substring( 0, portletResource.length()-1 );

		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(portletRequest,portletResource);

		String scope=prefs.getValue("scope","0");

		if ( scope.equals("0") ) {
			return portletResponse.getNamespace();
		} else if ( scope.equals("1") ) {
			return "LAYOUT_"+themeDisplay.getLayout().getLayoutId();
		} else if ( scope.equals("2") ) {
			return "SCOPE_GROUP_"+themeDisplay.getScopeGroupId();
			}

		return null;
		}

	}
