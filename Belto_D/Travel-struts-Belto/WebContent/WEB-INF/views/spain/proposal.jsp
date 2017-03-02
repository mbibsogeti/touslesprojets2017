<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimal-scale=0.5">
<title>Spain-proposal</title>
<link rel="stylesheet" href="/travel-struts-Belto/CSS/bootstrap.min.css">
</head>
<body>
<nav >
<ul class="nav nav-pills nav-tabs nav-justified">
<li class="active"><a href="../index"><spam class="glyphicon glyphicon-heart"></spam>Acceuil générale sur l'europe</a></li>
</ul>
</nav>
<div class="container">
<h1> Tous les voyages vers l'espagne</h1>
<s:form>
<s:textfield name="monument.name" label="Nom du monument"/>
<s:textfield name="monument.location" label="Ville"/>
<s:textfield name="monument.visitor" label="Nombre de visiteur" type="number"/>
<s:submit>Envoi</s:submit>
</s:form>
<s:debug />
</div>
</body>
</html>