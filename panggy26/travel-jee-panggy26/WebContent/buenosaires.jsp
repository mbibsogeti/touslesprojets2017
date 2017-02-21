<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Argentine</title>
</head>
<body>
	<div>
		<h1>Argentina</h1>
		<%! private final static String[] months = new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
			"Septiembre", "Octubre", "Noviembre", "Diciembre" }; 
		%>
		<section>
			<p>Inscription</p>
		</section>
		<section>
			<form action="./buenosaires.jsp">
				<p>
					<label>Départ : </label>
					<select name="month" value="${param.month}">
						<% 
						for (int i = 1; i <= 12; i++) { 
							//Pour que le i de la balise option soit lisible
							request.setAttribute("i", i);
						%>
						<!-- ${param.month == i ? "selected" : ""} : Si le i de la boucle correspond à ce qui a été entré, on le remet (selected) --> 			
						<option value="<%= i %>" ${param.month == i ? "selected" : ""}>
							<%= months[i - 1] %>
						</option>
						<% } %>
					</select>
				</p>
				<p>
					<label>Nom : </label>
					<!-- value="${param.nom}" permet de remettre ce qui a été saisi précédemment dans le champ Nom -->
					<input type="text" name="nom" value="${param.nom}">
				</p>
				<p>
					<label>Email : </label>
					<input type="email" name="mail" value="${param.mail}">
				</p>
				<p>
					<input type="submit" value="Demander">
				</p>
			</form>
		</section>
		<section>
			<p>
				<!-- Si le paramètre "month" (numéro du mois) existe -->
				<% if (request.getParameter("month") != null) { %>
				<!-- Conversion du String "month" en integer -->
				Demande pour <%= months[Integer.parseInt(request.getParameter("month")) - 1] %> enregistrée au mail <%= request.getParameter("mail") %>
				<% } %>
			</p>
		</section>
	</div>
</body>
</html>