
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>buenso aires</title>
</head>
<body>
	<h1>Buenos aires</h1>
	<h2>Inscription</h2>
	<%!private final static String[] monthes = new String[] { "janvier", "février", "mars", "avril", "mai", "jui",
			"juillet", "Aout", "septembre", "octrobre", "novembre", "décemebre" };%>
	<form>
		<p>
			<label>Départ:</label> <select name="month">
				<%
					for (int i = 1; i <= 12; i++) {request.setAttribute("i",i);%>
				<option value="<%=i%>" ${param.month==i?"selected":""} >
					<%=monthes[i - 1]%>  </option>		
						<%
					}
				%>
			</select>
		</p>

		<p>
			<label>nom:<input id="nom" type="text" name="nom" value="${param.nom}" ></label>
		</p>
		<p>
			<label>email<input id="email" type="text" name="email"
			value="${param.email}"></label>
		</p>
		<p>
			<input type="submit" value="Demander" name="bouton">
		</p>
		<%=request.getParameter("month")%>

	</form>
	<p><%
		if (request.getParameter("bouton") != null) {
	%>

	
		demande pour
		<%=monthes[Integer.parseInt(request.getParameter("month"))-1] %>
		enregistré pour
		<%=request.getParameter("nom")%>   
	<%}%>
	
	${3+5+8} </p>

<% int x=2;%>
<p>
${x}</P>  /* affiche rien*/


</body>
</html>