<%@page import="java.util.*"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bolivie: La Paz</title>
</head>
<body>

	<h1>La Paz</h1>
	<p>Voyage 10 jours</p>
	<%!private static final int nuit = 10;%>
	<%
		int ttc = 1062 + (nuit - 1) * 42;
	%>
	<p>
		tout compris
		<%=ttc%>
		€
	</p>
	<h2>Programme du voyage</h2>
	<table border="1">
		<tr>
			<th>Jour</th>
			<th>Programme</th>
		</tr>
		<%
			for (int j = 1; j <= nuit; j++) {
		%>
		<tr>
			<td><%=j%></td>
			<%
				if (j != 10 && j != 1) {
			%><td><%="Visites"%></td>
			<%
				} else {
			%><td><%="Avion"%></td>
			<%
				}
				}
			%>
		</tr>







	</table>
	<a href="http://localhost:8080/travel-jee-amine/index.html">Retour</a>
</body>
</html>
