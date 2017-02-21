<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buenos Aires</title>
</head>
<body>
	<h1>Buenos Aires</h1>
	<h4>Inscription</h4>
	<form>
		<%!private final static String[] monthes = new String[] { "", "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre" };%>
		<p>
			Départ: <select name="month">
				<%
					for (int i = 0; i <= 12; i++) {
						request.setAttribute("i", i);
				%>
				<option value="<%=i%>" ${param.month==i?"selected":""}><%=monthes[i]%>
				</option>
				<%
					}
				%>
			</select>
		</p>
		<p>
			<label>Nom: <input type="text" name="nom"
				value="${param.nom}"></label>
		</p>
		<p>
			<label>Email: <input type="email" name="email"
				value="${param.email}"></label>
		</p>
		<p>
			<label><input type="submit" name="demande"></label>
		</p>

	</form>
	<%
		if (request.getParameter("demande") != null) {
	%>
	<p>
		Demande pour
		<%=monthes[Integer.parseInt(request.getParameter("month"))]%>
		enregistrée pour
		<%=request.getParameter("email")%>.
	</p>
	<%
		}
	%>

</body>
</html>