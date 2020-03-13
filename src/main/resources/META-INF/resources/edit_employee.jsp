

<%@ include file="/init.jsp" %>
<portlet:actionURL name="/clayfrom/edit_employee" var="editEmployeeURL" />
<%
	List<SelectOption> selectOptions = new ArrayList<>();
	selectOptions.add(new SelectOption("India", String.valueOf("India")));
	selectOptions.add(new SelectOption("US", String.valueOf("US")));
	selectOptions.add(new SelectOption("UK", String.valueOf("UK")));
%>

<aui:form action="<%= editEmployeeURL %>" cssClass="edit-entry" enctype="multipart/form-data" method="post" name="fm">
<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<div class="clearfix">
			<label class="control-label">Gender</label>
			<clay:radio checked="<%= true %>" label="Male" name="<%=curPortletNameSpace+"gender"%>" showLabel="<%= true %>" value="male"/>
			<clay:radio checked="<%= true %>" label="Female" name="<%=curPortletNameSpace+"gender"%>" showLabel="<%= true %>" value="female"/>
		</div>
	</aui:fieldset>
	<aui:fieldset>
		<div class="clearfix">
			<label class="control-label">Hobbies</label>
			<clay:checkbox checked="<%= true %>" label="Music" name="<%=curPortletNameSpace+"hobbies"%>" showLabel="<%= true %>" value="Music"/>
			<clay:checkbox label="Travel" name="<%=curPortletNameSpace+"hobbies"%>" showLabel="<%= true %>" value="Travel"/>
			<clay:checkbox label="Movies" name="<%=curPortletNameSpace+"hobbies"%>" showLabel="<%= true %>" value="Movies"/>
		</div>
	</aui:fieldset>
	<aui:fieldset>
		<div class="clearfix">
			<clay:select label="Country" name="<%=curPortletNameSpace+"country"%>" options="<%= selectOptions %>"/>
		</div>
	</aui:fieldset>
	<aui:fieldset>
		<div class="clearfix">
			<aui:button name="saveButton" type="submit" value="Save" />
		</div>
	</aui:fieldset>
	
</aui:fieldset-group>

</aui:form>
