<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LA PAZ</title>
</head>
<body style="background: #F8E0F7">
	<h1>Bolivie</h1>
	<h2>La Paz... Hola !! Bienvenidos</h2>

	<p>
	<center>
		<img src="img/lapaz_opt.jpg" alt="Amérique du Sud">
	</center>
	</p>
	<!-- commentaire -->
	<%-- commentaire --%>

	<%@ page contentType="text/html; charset=utf-8"%>
	
	<%!private static final int nuite = 42;%>
	<%
		int avion = 1062;
		int nbJours = 10;
		int prixTTC = avion + (nuite * nbJours);

		out.write("Votre voyage de " + nbJours + " jours tout compris est de " + prixTTC + " €.");
%>

<table>
<tr>
<th>Jours</th>
<th>Programme</th>
</tr>

<%
for(int i=1; i<=nbJours; i++){
	if(i==1 || i==nbJours){%>	
	<tr><td><%=i %></td>
		<td> Avion</td></tr>
		
	<% }else{%>	
	<tr><td><%=i %></td>
	<td>visites</td></tr>
	<% }
}%>
	
</table>




















</body>
</html>