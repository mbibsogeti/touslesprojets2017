<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Buenos Aires</title>
</head>
<body>

	<%!private static final String[] mois = new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet",
			"Aout", "Septembre", "Octobre", "Novembre", "Décembre" };%>

	<div class="container">
		<h1 style="text-align: center">Buenos Aires</h1>

		<h2>Inscription</h2>

		<form class="form-inline">
			<section class="form-group"> <label>Depart : </label> <input
				type="number" name="jour" min="1" max="31" value="1"
				class="form-control" style="width: 5em" /> <select name="mois"
				class="form-control">
				<%
					for (int i = 0; i < 12; i++) {
						request.setAttribute("i",i);
				%>
				<option value="<%=i%>" ${param.mois==i? "selected='selected'":''}><%=mois[i]%></option>
				<%
					}
				%>
			</select> <input type="number" name="annee" min="2017" max="2020" value="2017"
				class="form-control" style="width: 8em" /> </section>

			</p>
			<label>Nom : </label><input type="text" name="nom"
				class="form-control" value="${param.nom}"/>
			</p>

			<p>
				<label>Email : </label><input type="email" name="email"
					class="form-control" value="${param.email}"/>
			</p>

			<p>
				<input type="submit" name="btn" value="Demander"
					class="form-control btn-primary" />
			</p>

		</form>

		<%
			String email = request.getParameter("email");
		%>

		<%
			if (email != null) {
		%>
		<%
			String j = request.getParameter("jour");
				int m = Integer.parseInt(request.getParameter("mois"));
				String a = request.getParameter("annee");
		%>
		<p>
			Demande pour le
			<%=j%>
			<%=mois[m]%>
			<%=a%>
			enregistrée pour
			<%=email%></p>
		<%
			}
		%>

		<p>${"bonjour"}</p>

	</div>






</body>
</html>