<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel='stylesheet' href='css/bonito.css'>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content='IE=edge'>
<meta name='viewport'
	content='width=device-width, initial-scale=1 minimum-scale=0.5'>
<title>El viaje de tus sueños: La Paz</title>
</head>
<body>

	<nav>
		<ul class='nav nav-pills nav-justified'>
			<li><a href='index.html'><span
					class='glyphicon glyphicon-home'></span> Inicio</a>
			<li><a href='ecuador/quito'><span
					class='glyphicon glyphicon-headphones'></span> Quito</a>
			<li><a href='colombia/cartagena'><span
					class='glyphicon glyphicon-king'></span> Cartagena</a>
			<li><a href='venezuela/maracaibo'><span
					class='glyphicon glyphicon-apple'></span> Maracaibo</a>
			<li><a href='peru/lima'><span
					class='glyphicon glyphicon-camera'></span> Lima</a>
			<li><a href='chile/santiago'><span
					class='glyphicon glyphicon-scissors'></span> Santiago</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-cloud'></span> La Paz</a>
			<li><a href='buenosaires.jsp'><span
					class='glyphicon glyphicon-education'></span> Buenos Aires</a>
			<li><a href='asuncion.jsp'><span
					class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>
			<li><a href='uruguay/montevideo'><span
					class='glyphicon glyphicon-flash'></span> Montevideo</a>
			<li><a href='guyana/georgetown'><span
					class='glyphicon glyphicon-send'></span> Georgetown</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>La Paz - Bolivia</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>La Paz</h2>
				<%@ page contentType="text/html; charset=utf-8"%>
				<% int prixAvion = 1062;
				   int prixNuitee = 42; %>
				<%! private static final
 					int DIAS = 9; %>
				<% int prixTot = prixAvion+(prixNuitee*DIAS); %>
				<p>
					Viaje
					<%=DIAS%>
					dias por tan solo
					<%= prixTot%>
					€.
				</p>
			</section>

			<section class='col-sm-6'>
				<h2>Organisation</h2>
				<table
					class='table table-striped table-hover table-responsive table-bordered table-condensed'>
					<tr>
						<th class='danger'>Dia</th>
						<th class='danger'>Programa</th>

						<% for (int i=1; i<=DIAS; i++) { %>
					
					<tr>
						<td><%= i %> <%	if (i==1 || i==DIAS){ %>
						<td>Avion <% } else { %>
						<td>Visita <% } } %>
				</table>
			</section>

		</div>
	</div>
</body>
</html>