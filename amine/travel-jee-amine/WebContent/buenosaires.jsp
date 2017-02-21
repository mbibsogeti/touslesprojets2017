<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buenos Aires</title>
</head>
<body>
	<h1>Buenos Aires</h1>
	<h4>Inscription</h4>
	<form>
		<%!private final static String[] monthes = new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre" };%>
		<p>
			Départ: <select name="month">
				<%
					for (int i = 1; i <= 12; i++) {
				%>
				<option value="<%=i%>"><%=monthes[i - 1]%>
				</option>
				<%
					}
				%>
			</select>
		</p>
		<p>
			<label>Nom: <input type="text" name="nom"></label>
		</p>
		<p>
			<label>Email: <input type="email" name="email"></label>
		</p>
		<p>
			<label><input type="submit" name="demander"></label>
	</form>
</body>
</html>