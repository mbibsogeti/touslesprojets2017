<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Désolé pour ça !!</title>
<link rel="stylesheet" href="/travel-jee-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="clearfix visible-xs"> </div>
		<div class="clearfix visible-xs"> </div>
		<div class="row">
			<img alt="" src="/travel-jee-laurent/img/memesSorry.jpg" class="col-xs-5">
			<h1 class="col-xs-7 text-center-xs"> Nous sommes désolé de ce désagrément ...</h1>
		</div>
		<div class="row">
			<h2 class="text-justify-sm text-center-sm"> Une erreur (code error 404) est survenue lors de votre navigation sur notre site, et nous tenons à nous excuser pour ce déplaisant évènement, je vous propose de revenir vers l'accueil avec les liens ci-dessous</h2>
		</div>
		<div class="row">
			<h3><a href="/travel-jee-laurent/index.jsp">Retour à l'accueil</a></h3>
		</div>
	</div>
</body>
</html>