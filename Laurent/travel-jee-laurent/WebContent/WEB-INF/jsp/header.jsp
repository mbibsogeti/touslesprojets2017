<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<nav>
		<ul class="nav nav-tabs nav-justified">
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/index.html")?"class='active'":""%>><a href="./index.jsp">Accueil</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/quito.html")?"class='active'":""%>><a href="./quito.html">Quito</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/cartagena.html")?"class='active'":""%>><a href="./cartagena.html">Cartagena</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/maracaibo.html")?"class='active'":""%>><a href="./maracaibo.html">Maracaibo</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/lima.html")?"class='active'":""%>><a href='./lima.html'>Lima</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/santiago.html")?"class='active'":""%>><a href='/travel-jee-laurent/santiago.html'>Santiago</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/lapaz.jsp")?"class='active'":""%>><a href='/travel-jee-laurent/lapaz.jsp'>Lapaz</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/buenosaires.jsp")?"class='active'":""%>><a href='/travel-jee-laurent/buenosaires.jsp'>Buenos Aires</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/asuncion.jsp")?"class='active'":""%>><a href='/travel-jee-laurent/asuncion.jsp'>Asùncion</a>
			<li <%=request.getRequestURL().toString().endsWith("/travel-jee-laurent/montevideo.html")?"class='active'":""%>><a href='/travel-jee-laurent/montevideo.html'>Montevideo</a>
		</ul>
	</nav>