<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>  
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>

<portlet:defineObjects />  
<liferay-theme:defineObjects />

<aui:script use="aui-node">
	<portlet:namespace />ajaxRequest=function(url) {
	    AUI().io.request( url, {
		        on: {
		          success: function() {
		            var data = this.get('responseData');
		            
		            AUI().one("#portlet<%=portletDisplay.getNamespace().substring(0, portletDisplay.getNamespace().length()-1) %> .portlet-content").html( data );
		          }
		        }
		      } );
		    
		 return false;
	    }
</aui:script>

<%
         long groupId = themeDisplay.getPortletGroupId();
         String name = themeDisplay.getPortletDisplay().getRootPortletId();
         String primKey = themeDisplay.getPortletDisplay().getResourcePK();
%>


