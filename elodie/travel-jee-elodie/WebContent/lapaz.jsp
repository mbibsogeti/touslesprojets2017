<%@page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>LA PAZ</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="img/lapaz.jpg" alt="photo_Lapaz" class="col-sm-12">
		</header>
		<section class="col-sm-12">
			<h1>La paz</h1>
			<p>
				Voyage de 10 jours tout compris :
				<%!private static final int NUIT = 42;%>
				<%
					int avion = 1062;
					double tot = 0;
					tot = avion + (10 * NUIT);
				%>
				<%=tot%>€
			</p>
		</section>
		<section class="col-sm-2">
			<table class="table table-striped table-bordered table-condensed">
				<tr >
					<th>JOURS</th>
					<th>PROGRAMME</th>
				</tr>
				<%
					for (int i = 1; i <= 10; i++) 
					{
						if (i == 1 || i == 10) 
						{
				%>
				<tr>
					<th><%= i %></th>
					<td>Avion</td>
				</tr>

				<%
						} else {
				%>
				<tr>
					<th><%= i %></th>
					<td>Visites</td>
				</tr>
				<%	
						}
					}
				%>

			</table>
		</section>
	</div>

</body>
</html>