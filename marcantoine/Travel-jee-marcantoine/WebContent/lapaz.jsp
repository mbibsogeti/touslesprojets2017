<%@page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>La Paz</title>
<link rel='stylesheet' href='css/bootstrap.min.css'>
</head>
<body>

	<jsp:include page="WEB-INF/jsp/header.jsp">
		<jsp:param name="year" value="2017" />
	</jsp:include>
	
	<div class='container'>
		<header>
			<h1>La Paz</h1>
		</header>
		<section>
			<h2>Tourism and locals</h2>
			<p>La Paz is an important cultural center of Bolivia. The city
				hosts several cathedrals belonging to the colonial times, such as
				the San Francisco Cathedral and the Metropolitan Cathedral, this
				last one located on Murillo Square, which is also home of the
				political and administrative power of the country. Hundreds of
				different museums can be found across the city, the most notable
				ones on Jaén Street, which street design has been preserved from the
				Spanish days and is home of 10 different museums. The home of the
				Bolivian government is located on Murillo Square and is known as
				"Palacio Quemado" (Burnt Palace) as it has been on fire several
				times. The palace has been restored many times since, but the name
				has remained untouched.</p>
			<p>
				<%!private static final int nights = 2;%>
				<%=nights + 1%>
				days trip, global price:
				<!-- Balblabla-->

				<%
					int price = 1062 + 42 * nights;
				%>
				<%=price%>
				<%="\u20ac"%>. Very cheap, ain't it?
			</p>

			<!--  Création d'une table utilisant une boucle Java-->
			<table class="table">
				<tr>
					<th>Day</th>
					<th>Schedule</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Avion</td>
				</tr>
				<!--  Boucle utilisée-->
				<%
					for (int i = 2; i < nights; i++) {
				%>
				<tr>
					<td><%=i%></td>
					<td>Visits</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td><%=nights + 1%></td>
					<td>Avion</td>
				</tr>

			</table>
		</section>
	</div>
</body>
</html>
