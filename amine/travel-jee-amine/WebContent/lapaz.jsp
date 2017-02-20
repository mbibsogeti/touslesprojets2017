<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bolivie: La Paz</title>
</head>
<body>
	<h1>La Paz</h1>
	<p>Voyage 10 jours</p>
	<%
		int ttc = 1062 + (10 - 1) * 42;
	%>
	<p>
		tout compris
		<%=ttc%>
		$
	</p>
	<a href="http://localhost:8080/travel-jee-amine/index.html">Retour</a>
</body>
</html>