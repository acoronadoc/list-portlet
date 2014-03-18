<%@ include file="init.jsp" %>

<portlet:actionURL var='actionAddItem' windowState="NORMAL">
	<portlet:param name='order' value='${order}'/>
	<portlet:param name='list' value='${list}'/>
	<portlet:param name='action' value='addItem'/>
</portlet:actionURL>

<portlet:actionURL var='actionDeleteItem' windowState="NORMAL">
	<portlet:param name='action' value='addItem'/>
	<portlet:param name='delete' value='1'/>
	<portlet:param name='id' value='${item.id}'/>
	<portlet:param name='list' value='${list}'/>
	<portlet:param name='order' value='${order}'/>
</portlet:actionURL>

<portlet:renderURL var='urlCancel' windowState="NORMAL">
	<portlet:param name='order' value='${order}'/>
	<portlet:param name='action' value='view'/>
	<portlet:param name='list' value='${list}'/>
</portlet:renderURL>

<portlet:renderURL var='urlBack' windowState="EXCLUSIVE">
	<portlet:param name='order' value='${order}'/>
	<portlet:param name='action' value='view'/>
	<portlet:param name='list' value='${list}'/>
</portlet:renderURL>

<a href="#" onclick="javascript: ${portletDisplay.namespace}ajaxRequest('${urlBack}');">&laquo; <liferay-ui:message key="back" /></a>

<liferay-ui:header title="item-title" />

<form id='listform' method="post" action="<%= actionAddItem %>" onSubmit = "<%= "javascript: return "+renderResponse.getNamespace()+"validate(this);" %>" >
	
	<aui:input type='hidden' name='list' value='${list}' />

	<div class="list_form_field">
		<aui:input type='text' name='label' label="label" value='${item.label}' />
	</div>

	<div class="list_form_field">
		<aui:select label="weight" name="weight" style="float: left;">
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
		<aui:select label="status" name="status" style="float: left;">
			<aui:option value="0" label="normal" selected="${item.status==0}" />
			<aui:option value="1" label="waiting" selected="${item.status==1}" />
			<aui:option value="2" label="cancelled" selected="${item.status==2}" />
			<aui:option value="3" label="finished" selected="${item.status==3}" />
		</aui:select>
	</div>

	<div style="clear: both; overflow: hidden; height: 1px;" >
		&nbsp;
	</div>

	<aui:input type='textarea' name='description' label="item-description" value='${item.description}' style="width: 95%;" />

	<p>
		&nbsp;
	</p>

	<p>
		<c:if test="${item.id!=null}">		
			<aui:input type='hidden' name='id' value='${item.id}' />
			<input type='submit' value="<liferay-ui:message key='save' />"/>
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

<aui:script>
	<portlet:namespace />validate=function() {
		if ( AUI().one("#<portlet:namespace />label").val().trim()=="" ) {
			alert( '<liferay-ui:message key="this-field-is-mandatory" />' );
			AUI().one("#<portlet:namespace />label").focus();

			return false;
			}

		return true;
		}

	<portlet:namespace />toDelete=function() {
		if ( confirm("<liferay-ui:message key="attention-delete" />") )
			window.location.href='<%=actionDeleteItem %>';
		}
</aui:script>
