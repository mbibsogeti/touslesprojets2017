<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ASUNCION</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body style="background: #F8E0EC">
	<div class="container">

		<%@ include file="WEB-INF/JSP/header.jsp"%>
		<h1>Bienvenidos a Asuncion</h1>
		<p>
		<center>
			<img src="img/asuncion_opt.jpg" alt="Amérique du Sud">
		</center>
		</p>
		<p class="text-justify">
			Asuncion ou Assomption, en espagnol AsunciónN 1, connue également
			sous son nom complet Muy Noble y Leal Ciudad de Nuestra <br>Señora
			Santa María de la AsunciónN 2, est la capitale et la ville la plus
			peuplée du Paraguay. Elle se situe sur la rive <br>gauche du Río
			Paraguay, sur une portion du cours d'eau qui fait frontière avec
			l'Argentine. Centre administratif et financier,<br> important
			pôle industriel avec des usines de chaussures, de textiles et de
			tabac, la ville comporte également un important port<br>
			fluvial.
		</p>
	 <jsp:include page="WEB-INF/JSP/footer.jsp"> 
	 <jsp:param name="year" value="1950"/>
	 </jsp:include>
		
		
		
	</div>
</body>
</html>