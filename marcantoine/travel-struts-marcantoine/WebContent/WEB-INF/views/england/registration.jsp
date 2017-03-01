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
<title>England: registration</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">

<style>
div.row {
	background: lightblue;
}
.label {
	color:black;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="container">
		<h1>Registration:</h1>
		<p>Language:</p>
		<!-- lien classique pour choisir la langue -->
		<a href="?request_locale=en">English</a><br> <a
			href="?request_locale=fr">Français</a><br> <a
			href="?request_locale=de">Deutsch</a><br> <a
			href="?request_locale=es">Espanol</a><br>
		<div class="row">
			<div class="col-xs-12">
				<s:form class="form-group" action="send">
					<s:textfield class="form-control" name="name" key="england.name" />
					<s:textfield class="form-control" name="email" key="england.email" />
					<s:checkbox name="luxury" key="england.luxury" />
					<!-- submit lance l'action "send" que l'on définit -->
					<s:submit class="btn" value="send" />
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>