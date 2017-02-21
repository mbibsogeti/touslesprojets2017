<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>La Muy Noble y Leal Ciudad de Nuestra Señora Santa María
	de la Asunción</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<nav>
		<ul class="nav nav-pills nav-justified">
			<li><a href="equateur/quito">Quito</a></li>
			<li><a href="colombie/cartagena">Cartagena</a></li>
			<li><a href="venezuela/maracaibo">Maracaibo</a></li>
			<li><a href="chile/santiago">Santiago</a></li>
			<li><a href="lapaz.jsp">La Paz</a></li>
			<li><a href="buenosaires.jsp">Buenos Aires</a></li>
			<li><a href="asuncion.jsp">Asuncion</a></li>
			<li><a href="sanlorenzo.jsp">San Lorenzo</a></li>
			<li><a href="uruguay/montevideo.jsp">Montevideo</a></li>
		</ul>
	</nav>

	<jsp:include page="WEB-INF/jsp/header.jsp">
		<jsp:param name="year" value="2017" />
	</jsp:include>

	<div class="container">

		<section class="row">
			<section class="col-xs-12" style="text-align: center">
				<h1>La Muy Noble y Leal Ciudad de Nuestra Señora Santa María de
					la Asunción</h1>
			</section>
		</section>

		<section class="row">
			<section class="col-xs-12"></section>
		</section>

	</div>

	<jsp:include page="WEB-INF/jsp/footer.jsp">
		<jsp:param value="Dude" name="name" />
	</jsp:include>
</body>
</html>