<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>La Paz</title>
</head>
<body style="text-align: center">

	<div class="container">
		<div class="row">
			<%@page contentType="text/html; charset=UTF-8"%>

			<h1>Bienvenue à la Paz</h1>

			<%
				float prix = 1062 + (10 * (float) (NUIT));
			%>
			<p>
				Voyage 10 jours :
				<%=prix%>
				€ tout compris
			</p>

		</div>

		<div class="row">
			<section class="col-xs-6">
				<table class='table table-striped table-bordered table-condensed'>
					<tr>
						<th>Jour</th>
						<th>Programme</th>
					</tr>
					<%
						for (int i = 1; i < 11; i++) {
					%>
					<tr>
						<td><%=i%></td>
						<%
							if (i == 1 || i == 10) {
						%>
						<td>Avion</td>
						<%
							} else {
						%>
						<td>Visite</td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</section>
		</div>

		<%!private static final int NUIT = 42;%>

	</div>
</body>
</html>