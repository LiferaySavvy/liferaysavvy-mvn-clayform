
<%@ include file="/init.jsp" %>
<h2>Welcome to Clay Taglib Examples</h2><br/>
<portlet:renderURL var="renderEditEmployee">
	<portlet:param name="mvcRenderCommandName" value="/clayform/edit_employee" />
</portlet:renderURL>
<aui:button href="<%= renderEditEmployee %>" value="Edit Employee" />
