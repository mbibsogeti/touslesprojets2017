<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class='container'>
		<div>
			<!--Voici un commentaire HTML (affiché dans le navigateur)-->
			<h1>¡Bienvenido a La Paz!</h1>
			<!--Balise de déclaration-->
			<%!private static final int NUITEE = 9;%>
			<!--Balise de scriptlet-->
			<%
				// Voici un commentaire Java (ignoré dans le navigateur)
				int avion = 1026;
				int hotel = 42;
				double prix = avion + NUITEE * hotel;
			%>
			<p>
				Voyage de 10 jours tout compris :
				<%=prix%>
				€
			</p>
			<!--Tableau détail du séjour : 10 jours avec avion aux deux extrêmités et visites partout ailleurs-->
			<table>
				<tr>
					<th>Jour</th>
					<th>Programme</th>
				</tr>
				<%
					for (int i = 1; i <= NUITEE + 1 ; i++) {
				%>
				<tr>
					<td><%=i%></td>
					<td>
						<%
							if (i == 1 || i == 10)
						%> Avion <%
							else
						%> Visites
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>