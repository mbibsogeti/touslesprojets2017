<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Angleterre</title>
<%@taglib prefix="s" uri="/struts-tags"%>
</head>

<body>
	<div class="container">
		<h1>
			<s:text name="england.title">
				<s:param>${prix}</s:param>
				<s:param>${prix+250}</s:param>
			</s:text>
		</h1>

		<p>
			<s:date name="date" format="dd/MM/yyyy" />
			<s:date name="date" nice="true" />
		</p>
		<p>
			prix :
			<s:property value="prix" />
			€
		</p>

		<div class="clearfix"></div>
		<p>
			<a href="?request_locale=en">English</a>


			<s:url namespace="/" action="england" var="ufr">
				<s:param name="request_locale" value="fr" />
			</s:url>
			<a href=${ufr}>Français</a>

			<s:url namespace="/" action="england" var="ues">
				<s:param name="request_locale" value="es" />
			</s:url>
			<a href=${ues}>Español</a>
		</p>
		<div class="clearfix"></div>
		<p>
			<s:url namespace="/" action="index" var="u1" />
			<a href=${u1}>retour</a>
		<div class="clearfix"></div>
		<p>
			<a href="registration">Inscription</a>
		</p>
		
	
	</div>

</body>
</html>