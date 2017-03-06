<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>England</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1>Inscription enregistrée</h1>
		</div>
		<div class="row">
			<h3>Mr/Mme ${name}, votre demande a été enregistré. Un résumé a été envoyé à l'adresse mail ${email} </h3>
		</div>
	</div>
</body>
</html>