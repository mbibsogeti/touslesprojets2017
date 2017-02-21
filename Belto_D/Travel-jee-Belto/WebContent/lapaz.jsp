<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La Paz</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<nav>
			<ul class="nav nav-pills nav-tabs nav-justified">
				<!-- Nav=pour espacer, nav-pills pour faire des cases et nav-tabs -->
				<li><a href="index.html">Acceuil</a></li>
			</ul>
		</nav>

	</div>
	<h1>On est bien à La Paz</h1>
	<!-- lalala -->
	<%
		float a = 1062;
	%>
	<%
		float n = 42;
	%>
	<%
		float b;
	%>
	<%
		b = a + (nuit * n);
	%>
	Votre voyage de 10jours, tout compris est :
	<%--Mon commentaire--%>
	<%=b%>
	€
	<%!private static final int nuit = 10;%>
	<!-- declaration d'une constante -->
	<table>
		<tr>
			<th>Jour</th>
			<th>Programme</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Avion</td>
		</tr>
		<%
			for (int j = 2; j < nuit; j++) {
		%>
		<tr>
			<td><%=j%></td>
			<td>Visite</td>
		</tr>
		<%
			}
		%>
<tr>
			<td><%=nuit%></td>
			<td>Avion</td>
		</tr>

	</table>


</body>
</html>