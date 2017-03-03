<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>England: index</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="container">
		<h1>
			<s:text name="england.title" />
		</h1>
		<p>
			<!-- balise spéciale de la TL s pour le formatage des dates -->
			Departure:
			<s:date name="departure" format="dd/MM/yyyy" />
			<s:date name="departure" nice="true" />
		</p>
		<p>
			<!-- NB : on aurait aussi pu utiliser une balise EL. -->
			<s:text name="england.price">
				<s:param>${price}</s:param>
				<s:param>${price+250}</s:param>
			</s:text>
		</p>
		<a href="../index">Back to the Welcome page</a><br> <a
			href="registration">Registration</a><br>
		<p>Language:</p>
		<!-- lien classique pour choisir la langue -->
		<a href="?request_locale=en">English</a><br> <a
			href="?request_locale=fr">Français</a><br> <a
			href="?request_locale=de">Deutsch</a><br> <a
			href="?request_locale=es">Espanol</a><br>
		<!-- choisir l'adresse associée au lien -->
		<s:url namespace="/" action="index" var="u1" />
		<a href="u1">welcome page</a><br>
		<!-- fabrique des url qui contiennent des variables (ici on pourrait en mettre une à la place de "en") -->
		<s:url namespace="/england" action="index" var="u_en">
			<s:param name="request_locale" value="'en'" />
		</s:url>
		<a href="u_en">welcome page again</a>


	</div>
</body>
</html>