<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spain</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center">${monument.name}</h1>
		</div>
		<div class="row">
			<p>
				<h3>Se trouvant en ${monument.location}, <strong>${monument.name}</strong>
				acceuille chaque année plus de ${monument.visitor} visiteurs !!</h3>
		</div>
	</div>
	<aside>
		<a href="?request_locale=fr" class="btn btn-primary"> fr </a> <a
			href="?request_locale=en" class="btn btn-primary"> en </a> <a
			href="?request_locale=es" class="btn btn-primary"> es </a>
	</aside>
</body>
</html>