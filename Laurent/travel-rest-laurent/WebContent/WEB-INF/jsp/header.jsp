<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
      		<a class="navbar-brand" href="#">Paradise on ice</a>
    	</div>
		<ul class="nav navbar-nav">
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/index.html")?"class='active'":""%>><a href="./excursions.jsp">Excursions</a>
		</ul>
	</nav>