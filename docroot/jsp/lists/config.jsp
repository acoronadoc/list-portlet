<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<form method='post' action='<liferay-portlet:actionURL portletConfiguration="true" />'>

	<p>
		<liferay-ui:message key='scope' /> : 

		<select name='scope'>
			<option value='0' <%=request.getAttribute("scope_0") %> > <liferay-ui:message key='portlet-id' /> (<liferay-ui:message key='default' />)</option>
			<option value='1' <%=request.getAttribute("scope_1") %> > <liferay-ui:message key='page' /> </option>
			<option value='2' <%=request.getAttribute("scope_2") %> > <liferay-ui:message key='community' /> </option>
		</select>
	</p>
	<p>
		<input type='submit' value="<liferay-ui:message key='send' />" />
	</p>
</form>
