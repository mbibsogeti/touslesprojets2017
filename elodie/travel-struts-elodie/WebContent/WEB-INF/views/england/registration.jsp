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
<style>.wwFormTable .label{color:black}</style>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/englandFormulaire.jpg" alt="Photo_england"
				class="col-sm-12" />
		</header>
		<section class="row col-sm-12">
			<h1>Inscription</h1>
		</section>
		<section class="row col-sm-12">
			<s:form action="send">
				<s:textfield name="name" label="nom" />
				<s:textfield name="email" label="email" />
				<s:checkbox name="luxury" label="luxe" />
				<s:submit value="envoi" />
			</s:form>
		</section>
		<section class="row col-sm-12">
			<s:url namespace="/england" action="index" var="u2" />
			<a href="${u2}">Back to England</a>
		</section>
	</div>
</body>
</html>