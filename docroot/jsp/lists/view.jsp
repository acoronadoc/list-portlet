<%@ include file="init.jsp" %>

<portlet:renderURL var='urlAddList' windowState="EXCLUSIVE"><portlet:param name='action' value='addList'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>
<portlet:renderURL var='urlEditList' windowState="EXCLUSIVE"><portlet:param name='action' value='addList'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/><portlet:param name='id' value='${list}'/></portlet:renderURL>
<portlet:renderURL var='urlAddItem' windowState="EXCLUSIVE"><portlet:param name='action' value='addItem'/><portlet:param name='order' value='${order}'/><portlet:param name='list' value='${list}'/></portlet:renderURL>


<p>
<% if (permissionChecker.hasPermission(groupId, name, primKey, "EDIT")) { %>
	<aui:button name='addList' value='add-list' onclick="javascript: ${portletDisplay.namespace}ajaxRequest('${urlAddList}');" />
	<c:if test="${list!=null}">
		<aui:button name='addItem' value='add-item' onclick="javascript: ${portletDisplay.namespace}ajaxRequest('${urlAddItem}');" />
	</c:if>
<% } %>
</p>

<ul class="nav nav-tabs"> 
	<c:forEach var="item" items="${tabList}">
		<c:set var="isActive" value="" />
		<c:if test="${formTab==item.description}">
			<c:set var="isActive" value="active" />
		</c:if>
	
		<portlet:renderURL var='def' windowState="EXCLUSIVE">
			<portlet:param name='action' value='view'/>
			<portlet:param name='tabs1' value='${item.description}'/>
			<portlet:param name='list' value='${item.id}'/>
		</portlet:renderURL>
	
		<li class="tab ${isActive}"> 
			<a onclick="javascript: <portlet:namespace />ajaxRequest('${def}');" href="#">
				${item.description}
			</a>
		</li> 
	</c:forEach>
</ul>

<p style='text-align: right;'>
	<% if (permissionChecker.hasPermission(groupId, name, primKey, "EDIT")) { %>
		<c:if test="${list!=null}">
			<a onclick="javascript: <portlet:namespace />ajaxRequest('${urlEditList}');" href="#">
				<liferay-ui:icon
					cssClass="top-link"
					image="edit"
					label="<%= false %>"
					/>
				<liferay-ui:message key='lists.editlist' />
			</a>
		</c:if>
	<% } %>
</p>

<table class='table table-bordered table-hover table-striped' style='width: 100%;'>
	<thead class="table-columns">
		<tr>
			<th class="table-first-header">
				<b>
					<portlet:renderURL var='defLabel' windowState="EXCLUSIVE">
							<portlet:param name='action' value='view'/>
							<portlet:param name='list' value='${list}'/>
							<portlet:param name='order' value='label'/>
							</portlet:renderURL>							
					<a style='text-decoration: none;' onclick="javascript: <portlet:namespace />ajaxRequest('${defLabel}');" href="#">
						<liferay-ui:message key="label" />
	
						<c:if test="${order=='label'}">
							&or;
						</c:if>
					</a>
				</b>
			</th>
			<th>
				<b>
					<portlet:renderURL var='defWeight' windowState="EXCLUSIVE">
							<portlet:param name='action' value='view'/>
							<portlet:param name='list' value='${list}'/>
							<portlet:param name='order' value='weight'/>
							</portlet:renderURL>							
					<a style='text-decoration: none;' onclick="javascript: <portlet:namespace />ajaxRequest('${defWeight}');" href="#">
						<liferay-ui:message key="weight" />
	
						<c:if test="${order=='weight'}">
							&or;
						</c:if>
					</a>
				</b>
			</th>
			<th class="table-last-header">
				<b>
					<portlet:renderURL var='defStatus' windowState="EXCLUSIVE">
							<portlet:param name='action' value='view'/>
							<portlet:param name='list' value='${list}'/>
							<portlet:param name='order' value='status'/>
							</portlet:renderURL>							
					<a style='text-decoration: none;' onclick="javascript: <portlet:namespace />ajaxRequest('${defStatus}');" href="#">
						<liferay-ui:message key="status" />
	
						<c:if test="${order=='status'}">
							&or;
						</c:if>
					</a>
				</b>
			</th>
		</tr>
	</thead>
	
	<tbody class="table-data">

		<c:forEach var="item" items="${itemList}">
			<portlet:renderURL var='urlViewItem' windowState="EXCLUSIVE">
				<portlet:param name='list' value='${list}'/>
				<portlet:param name='itemid' value='${item.id}'/>
				<portlet:param name='order' value='${order}'/>
			</portlet:renderURL>
	
			<tr>
				<td class="table-cell first">	
					<a style='text-decoration: none;' onclick="javascript: <portlet:namespace />ajaxRequest('${urlViewItem}');" href="#">	
						${item.label}
					</a>
				</td>
				<td class="table-cell table-sortable-column">
					<c:choose>
						<c:when test="${item.weight>=16}">
							<span class='weight_highest'>
						</c:when>
						<c:when test="${item.weight>=4}">
							<span class='weight_high'>
						</c:when>
						<c:when test="${item.weight>=-4}">
							<span class='weight_normal'>
						</c:when>
						<c:when test="${item.weight>=-14}">
							<span class='weight_low'>
						</c:when>
						<c:otherwise>
							<span class='weight_lowest'>
						</c:otherwise>
					</c:choose>
					${item.weight}</span>
				</td>
				<td class="table-cell table-sortable-column last">
						<c:choose>
							<c:when test="${item.status==0}">
								<span class='status_normal'><liferay-ui:message key="normal" /></span>
							</c:when>
							<c:when test="${item.status==1}">
								<span class='status_waiting'><liferay-ui:message key="waiting" /></span>
							</c:when>
							<c:when test="${item.status==2}">
								<span class='status_cancelled'><liferay-ui:message key="cancelled" /></span>
							</c:when>
							<c:when test="${item.status==3}">
								<span class='status_finished'><liferay-ui:message key="finished" /></span>
							</c:when>
							<c:otherwise>
								${item.status}
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

