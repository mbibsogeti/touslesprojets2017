<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ASUNCION</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<%@ include file="WEB-INF/jsp/header.jsp" %>
		</header>
		<div class="row">
			<img src="img/asuncion.jpg" alt="photo" class="col-sm-12" />
		</div>
		<div class="row">
			<h1 class="col-sm-12">Asuncion</h1>
		</div>
		<div class="row">
			<section class="col-sm-12" style="text-align:justify">
				<p>Asuncion ou Assomption, en espagnol Asunción, connue
					également sous son nom complet Muy Noble y Leal Ciudad de Nuestra
					Señora Santa María de la AsunciónN 2, est la capitale et la ville
					la plus peuplée du Paraguay. Elle se situe sur la rive gauche du
					Río Paraguay, sur une portion du cours d'eau qui fait frontière
					avec l'Argentine. Centre administratif et financier, important pôle
					industriel avec des usines de chaussures, de textiles et de tabac,
					la ville comporte également un important port fluvial.</p>
			</section>
		</div>
		<footer class="row">
			<jsp:include page="WEB-INF/jsp/footer.jsp">
				<jsp:param name="year" value="2017"/>
			</jsp:include>
		</footer>
	</div>

</body>
</html>