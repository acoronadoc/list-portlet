<%@ include file="init.jsp" %>

<portlet:renderURL var='urlCancel'  windowState="EXCLUSIVE"><portlet:param name='action' value='view'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>

	<a href="#" onclick="javascript: ${portletDisplay.namespace}ajaxRequest('${urlCancel}');">&laquo; <liferay-ui:message key="back" /></a>

	<liferay-ui:header title="${listObj.description} - ${item.label}" />


	<% if (permissionChecker.hasPermission(groupId, name, primKey, "EDIT")) { %>
		<div style="margin-right: 4px;" >
				<portlet:renderURL var='urlEditItem' windowState="NORMAL">
					<portlet:param name='action' value='addItem'/>
					<portlet:param name='list' value='${list}'/>
					<portlet:param name='itemid' value='${item.id}'/>
					<portlet:param name='order' value='${order}'/>
				</portlet:renderURL>

				<liferay-ui:icon
					cssClass="top-link"
					image="edit"
					label="<%= true %>"
					message="edit" 
					url='${urlEditItem}'
					/>
		</div>
	<% } %>

	<aui:field-wrapper label="description">
		<% pageContext.setAttribute("newLineChar", "\n"); %>
		${fn:replace(item.description,newLineChar,"<br/>")}
	</aui:field-wrapper>

	<div style="float: left; margin-right: 4px;" >
		<aui:field-wrapper label="label">
			<c:out value='${item.label}' />
		</aui:field-wrapper>
	</div>

	<div style="float: left; margin-right: 4px;" >
		<aui:field-wrapper label="status">
	<c:if test="${statuses[ item.status ]=='Normal'}">
			<span class='status_normal'><liferay-ui:message key="normal" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Waiting for'}">
			<span class='status_waiting'><liferay-ui:message key="waiting" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Cancelled'}">
			<span class='status_cancelled'><liferay-ui:message key="cancelled" /></span>
	</c:if>
	<c:if test="${statuses[ item.status ]=='Finished'}">
			<span class='status_finished'><liferay-ui:message key="finished" /></span>
	</c:if>
		</aui:field-wrapper>
	</div>

	<c:if test="${listObj.ratings==1}">
		<div style="clear: both; overflow: hidden; height: 1px;" >&nbsp;</div>
		
		<div style="float: right; margin-right: 4px;" >
			<liferay-ui:ratings
				className="<%= com.lostsys.lists.model.TaskItem.class.getName() %>"
				classPK="${item.id}"
				/>
		</div>
	</c:if>

	<div style="clear: both; overflow: hidden; height: 1px;" >&nbsp;</div>

	<c:if test="${listObj.comments==1}">
		<h3>
			<liferay-ui:message key="list.comments" /><br/>
		</h3>

		<c:forEach var="comment" items="${comments}">
			<c:set var='userid' value='${comment.userid}'/>
			<%
			com.liferay.portal.model.User u=com.liferay.portal.service.UserLocalServiceUtil.getUser( 
				 java.lang.Long.decode( ""+pageContext.getAttribute( "userid" ) )
				 );
			%>

			<p>

				<div class='lists_comment'>
					<div class='lists_comment_img'>
						<img src="<%= u.getPortraitURL(themeDisplay) %>" /> 
					</div>
					<div class='lists_comment_txt'>
						<div class='lists_comment_header'>
							<%=u.getFullName() %>
						</div>
						<div class='lists_comment_content'>
							${fn:replace(comment.description,newLineChar,"<br/>")}
						</div>
					</div>
				</div>
				<div style='clear: both; overflow: hidden; height: 1px;'>&nbsp;</div>
			</p>
		</c:forEach>

		<p>
			<portlet:actionURL var='actionAddComment'  windowState="NORMAL"><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/><portlet:param name='itemid' value='${item.id}'/><portlet:param name='action' value='addComment'/></portlet:actionURL>

			<form id='listform' method="post" action="<%= actionAddComment %>" >
				<h3>
					<liferay-ui:message key="leave.comment" /><br/>
				</h3>

				<aui:input type='textarea' name='description' label="description" value='' style="width: 95%;" /><br/>
				<input type='submit' value="<liferay-ui:message key='send' />"/>
			</form>
		</p>
	</c:if>

