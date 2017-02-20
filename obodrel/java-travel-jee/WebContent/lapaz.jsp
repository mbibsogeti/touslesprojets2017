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
				<li class="active"><a href=".">Lapaz Travel</a></li>
			</ul>
		</nav>
		<div class="col-xs-12">
			<h3>Lapaz Welcomes you!</h3>
			<% int planePrice = 1062; %>
			<% int nightPrice = 42; %>
			<p>10 days trip all in one for <%=9*nightPrice+planePrice%>€<p>
		</div>
	</div>
</body>
</html>