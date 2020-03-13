
<%@ include file="/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<h2>Display Employee Details</h2><br/>
<%
Map<String,String> employeeMap=(Map<String,String>)request.getAttribute("employeeObject");
%>
<b>Gender: </b><%=employeeMap.get("gender")%>    <br/>
<b>Country: </b><%=employeeMap.get("country")%>    <br/>
<b>Hobbies: </b><br/>
<%
List<String> hobbiesList=(List<String>)request.getAttribute("hobbiesList");
if(hobbiesList!=null){
for(String hobby:hobbiesList){
%>
<%=hobby%><br/>
<%}}%>

<portlet:renderURL var="homeURL">
</portlet:renderURL>
<br/>
<br/>
<aui:button href="<%= homeURL %>" value="Home" />
