<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<title>Lapaz</title>
</head>
<body id="body">
	<div class="container-fluid">
		<h1 class="col-xs-12 col-xs-offset-3">Obodrel's Travel, South America division!</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li><a href="./">Home</a></li>
				<li><a href="./equator/quito">Quito Travel</a></li>
				<li><a href="./colombia/cartagena">Cartagena Travel</a></li>
				<li><a href="./venezuela/maracaibo">Maracaibo Travel</a></li>
				<li><a href="./peru/lima">Lima Travel</a></li>
				<li><a href="./chile/santiago">Santiago Travel</a></li>
				<li class="active"><a href="./lapaz.jsp">Lapaz Travel</a></li>
				<li><a href="./buenosaires.jsp">Buenos Aires Travel</a></li>
				<li><a href="./asuncion.jsp">Asuncion Travel</a></li>
				<li><a href="./montevideo">Montevideo Travel</a></li>
				<li><a href="./georgetown">George Town Travel</a></li>
			</ul>
		</nav>
		<div class="col-xs-12">
			<h3>Lapaz Welcomes you!</h3>
			<p><%=daysOfStaying%> days trip all in one for <%=daysOfStaying*nightPrice+planePrice %>€<p>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>Days</th>
						<th>Schedule</th>
					</tr>
				</thead>
				<tbody><% for(int i=0;i<daysOfStaying;i++) {  %>
					<tr>
						<td><%=i+1 %></td><% if(i==0 || i==daysOfStaying-1 ) { %>
						<td>Plane<td><% } else { %>
						<td>Visits<td>
					</tr><% }} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<%! int planePrice = 1062; %>
<%! int nightPrice = 42; %>
<%! private static final int daysOfStaying = 9; %>