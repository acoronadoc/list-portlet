<%@ include file="init.jsp" %>

<portlet:actionURL var='actionAddList' windowState="NORMAL">
	<portlet:param name='action' value='addList'/>
	<portlet:param name='order' value='${order}'/>
</portlet:actionURL>
	
<portlet:renderURL var='urlCancel' windowState="NORMAL">
	<portlet:param name='action' value='view'/>
	<portlet:param name='order' value='${order}'/>
	<portlet:param name='list' value='${list}'/>
</portlet:renderURL>

<portlet:actionURL var='actionDeleteList' windowState="NORMAL">
	<portlet:param name='action' value='addList'/>
	<portlet:param name='delete' value='1'/>
	<portlet:param name='id' value='${item.id}'/>
	<portlet:param name='order' value='${order}'/>
</portlet:actionURL>

<portlet:renderURL var='urlBack' windowState="EXCLUSIVE">
	<portlet:param name='action' value='view'/>
	<portlet:param name='order' value='${order}'/>
	<portlet:param name='list' value='${list}'/>
</portlet:renderURL>

<a href="#" onclick="javascript: ${portletDisplay.namespace}ajaxRequest('${urlBack}');">&laquo; <liferay-ui:message key="back" /></a>

<liferay-ui:header title="list-title" />

<form id='listform' method="post" action="<%= actionAddList %>" onSubmit = "<%= "javascript: return "+renderResponse.getNamespace()+"validate(this);" %>" >
	
	<div class="list_form_field">
		<aui:input type='text' name='description' label="list-name" value='${item.description}' />
	</div>

	<div class="list_form_field">
		<aui:select label="weight" name="weight">
			<c:set value="${item.weight}" var="sval"/>
			<c:if test="${item.id==null}">
				<c:set value="0" var="sval"/>
			</c:if>		
	
			<c:forEach var="i" begin="0" end="50">
				<aui:option value="${i-25}" selected="${sval==i-25}">${i-25}</aui:option>
			</c:forEach>
		</aui:select>
	</div>

	<div class="list_form_field">
		<aui:select label="enable.ratings" name="ratings">
			<c:set value="${item.ratings}" var="sval"/>
			<c:if test="${item.ratings==null}">
				<c:set value="0" var="sval"/>
			</c:if>		
	
			<aui:option value="0" selected="${sval==0}"> <liferay-ui:message key="list.no" /> </aui:option>
			<aui:option value="1" selected="${sval==1}"> <liferay-ui:message key="list.yes" /> </aui:option>
		</aui:select>
	</div>

	<div class="list_form_field">
		<aui:select label="enable.comments" name="comments">
			<c:set value="${item.comments}" var="sval"/>
			<c:if test="${item.comments==null}">
				<c:set value="0" var="sval"/>
			</c:if>		
	
			<aui:option value="0" selected="${sval==0}"> <liferay-ui:message key="list.no" /> </aui:option>
			<aui:option value="1" selected="${sval==1}"> <liferay-ui:message key="list.yes" /> </aui:option>
		</aui:select>
	</div>

	<div style="clear: both; overflow: hidden; height: 1px;" >
		&nbsp;
	</div>

	<p>
		&nbsp;
	</p>

	<p>
		<c:if test="${item.id!=null}">		
			<aui:input type='hidden' name='id' value='${item.id}' />
			<input type='submit' value='<liferay-ui:message key="save" />'/>
			<input type='button' onclick='<%=renderResponse.getNamespace()+"toDelete();" %>' value='<liferay-ui:message key="action.DELETE" />'/>
		</c:if>		
		<c:if test="${item.id==null}">		
			<aui:input type='hidden' name='id' value='-1' />
			<input type='submit' value='<liferay-ui:message key="add" />'/>
		</c:if>	
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='button' onclick="javascript: window.location.href='${urlCancel}';" value='<liferay-ui:message key="cancel" />'/>
	</p>

</form>


<aui:script use="aui-node">
	<portlet:namespace />validate=function() {
		if ( AUI().one("#<portlet:namespace />description").val().trim()=="" ) {
			alert( '<liferay-ui:message key="this-field-is-mandatory" />' );
			AUI().one("#<portlet:namespace />description").focus();

			return false;
			}

		return true;
		}

	<portlet:namespace />toDelete=function() {
		if ( confirm("<liferay-ui:message key="attention-delete" />") )
			window.location.href='${actionDeleteList}';
		}
</aui:script>
