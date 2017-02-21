<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p class="col-sm-12">
	Tout droit est réservé à la prod@taitaie- Page créée en
	<% if(request.getParameter("year")!=null) {%>
		${param.year}
		<%} else {%>
		2016
		<%}%>
</p>