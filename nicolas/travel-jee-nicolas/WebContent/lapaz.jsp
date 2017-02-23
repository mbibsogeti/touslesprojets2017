
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lapaz</title>
</head>
<body>
	<h1>A la paz</h1>


	<h2>L ile</h2>
	<p class="text-justify text-capitalize")>lapaz est capital de sa
		capitale fois une rÃ©gion monodÃ©partementale</p>
	<p>Cout d'un voyage de 10 jours</p>

	<p>
		voyage de 10jour tou comrpis
		<%!private static double a = 0;%>
		<%
			a = 1062 + 42 * 9;
		%>
		<%--toto --%>
		<%=a%>
		<!-- apola -->

		<%!private static int nbjr = 10;%>       
	<table border="1" >
		<tr>
			<th>Jour</th>
			<th>programme</th>
		</tr>
		<%	for (int j = 1; j <= nbjr; j++) {%>
		<% if(j==1 || j==10 ){%>
		<tr>
			<td><%=j%></td>
			<td>Avion</td>
		</tr>
		<%  }else{%>
		<tr>
			<td><%=j%></td>
			<td>visite</td>
		</tr>
		<% } %>
		<% }%>
	</table>
	</p>
</body>
</html>