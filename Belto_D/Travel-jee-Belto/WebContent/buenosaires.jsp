<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buenos aires</title>
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
	<h1>On est bien à Buenos-aires</h1>
	<%!private final static String[] monthes = new String[] { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre" };%>
	<form action="">
		<h2>Inscription</h2>
		<label> Départ:<select name=month></label>
		<!-- une autre façon de faire select dans un formulaire(TRES IMPORTANT) -->
		<!-- une boucle pour aller chercher les variables du tableaux -->
		<%
			for (int i = 1; i <= 12; i++) {	
				request.setAttribute("i",i);<%-- recuperer le select et le stocker ds i--%>
		<option value="<%=i%>" ${param.month==i?"selected":""}><%=monthes[i - 1]%></option>
		<!-- prendre la chaine de charactères qui se trouve entre (0-11) les 12 mois. Et afficher ce que l'utilisateur à rentré -->
		<%
			}
		%>
		
		</select>
		<p>
			<label> Nom:<input value="${param.name}" name=name></label><!-- value=${param.name}" pour que la valeur entrée reste afficher, revenir dans le formulaire -->
		<p>
			<label> Email:<input value="${param.email }" name=email></label>
		</p>
		<p>
			<label><input type="submit" value="Demander"></label>
		</p>
		<%=request.getParameter("month")%><!-- recuperer le paramètre mois -->
		<%
			if (request.getParameter("month") != null) {
		%><!-- s'il n'est pas null alors... -->
		Demande pour
		<%=monthes[Integer.parseInt(request.getParameter("month")) - 1]%>
		Enregisté pour
		<%=request.getParameter("email")%>
		<%
			}
		%>
		<% int x=2; %>
		${x }
	</form>
</body>
</html>