<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<title>ENGLAND</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/england.jpg" alt="Photo_england" class="col-sm-12" />
		</header>
		<section class="row col-sm-12">
			<h1>
				<s:text name="England.title" />
			</h1>
		</section>
		<section class="row col-sm-12">
			<p>
				Départ:
				<s:date name="date" nice="true" />
			</p>
			<p>
				<s:text name="England.prix">
					<s:param>${prix}</s:param>
				</s:text>
			</p>
		</section>
		<section class="row col-sm-12">
			<p>
				<s:url namespace="/england" action="registration" var="u3" />
				<a href="${u3}">Registration</a>
			<p>
			<p>
				<s:url namespace="/" action="index" var="u1" />
				<a href="${u1}">Home</a>
			<p>
			<p style="text-align: right">
				<a href="?request_locale=fr">Fr /</a> <a href="?request_locale=en">
					En /</a> <a href="?request_locale=es">Es</a>
			</p>
		</section>
	</div>
</body>
</html>