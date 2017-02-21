<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buenos Aires</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<img src="img/buenosaires.gif" alt="photo" class="col-sm-12" />
		</div>
		<div class="row">
			<h1 class="col-sm-12">BUENOS AIRES</h1>
		</div>
		<div class="row">
			<h2 class="col-sm-12" style="text-decoration:underline">Inscription</h2>
		</div>
		<section class="col-sm-12 form-group">
		<form action="buenosaires.jsp">
			<p>
				<label>Départ <select name="month"  class="form-control">
						<%!private final static String[] monthes = new String[] { "-","Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };%>
						<%
							int value = 1;
						%>
						<%
							for (String i : monthes) {
								request.setAttribute("value", value);
						%>
						<option ${param.month==value?"selected":""} value="<%=value%>"><%=i%></option>
						<%
							value += 1;

							}
						%>
				</select>
				</label>
			</p>
			<p>
				<label>Nom <input type="text" name="nom" value="${param.nom}" class="form-control"></label>
			</p>
			<p>
				<label>Email <input type="email" name="email" value="${param.email}" class="form-control"></label>
			</p>
			<p>
				<input type="submit" name="envoi" value="Demander" class="btn">
			</p>
			<p>
				<% if(request.getParameter("month")!=null){%>
				Demande pour
				<%= monthes[Integer.parseInt(request.getParameter("month"))-1] %>
				enregistrée pour
				<%= request.getParameter("email")%>
				<%}%>
			</p>
		</form>
		</section>

	</div>
</body>
</html>