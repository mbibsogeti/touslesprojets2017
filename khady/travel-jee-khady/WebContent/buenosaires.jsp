<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BUENOS AIRES</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body  style="background: #CEF6F5">

<div class="container">
<h2>ARGENTINA</h2>
<h3>Bienvenidos a Buenos Aires !!!</h3>
<p>
	<center>
		<img src="img/buenosaires_opt.jpg" alt="Amérique du Sud">
	</center>
	</p>
	<h3>Inscription</h3>
	<%!private final static String[] monthes = new String[] { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre" };%>

	<p>
	<form>
		<p>
			<label>Départ <select name="month">
					<%
						for (int i = 1; i <= 12; i++) {
							request.setAttribute("i",i);
					%>							 
					<option value="<%=i%>" ${param.month==i?"selected":"" }><%=monthes[i - 1]%></option>
					<%
						}
					%>
			</select></label>
		</p>
		<p class="form-group">
			<label>Nom <input id="name" type="text" name=name value="${param.name}"   class="form-control"></label>
		</p>
		<p class="form-group">
			<label>Email <input id="email" type="text" name=email value="${param.email}"class="form-control"></label>
		</p>
		<p class="form-group">
			<label><input type="submit" class="btn btn-info"
				value="Demander" class="form-control"></label>
		</p>
	</form>

	<%if (request.getParameter("month")!=null){%>
	Votre demande pour le mois de
	<%=monthes[Integer.parseInt(request.getParameter("month"))-1]%>
	est enregistrée pour
	<%=request.getParameter("email")%>.
	<% }%>



</body>
</html>

