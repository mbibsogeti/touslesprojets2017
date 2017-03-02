<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="spain.name" /></title>
</head>
<body>
	<header>
		<a href="?request_locale=es">ES</a> <a href="?request_locale=fr">FR</a>
	</header>
	<h1>
		<s:text name="spain.name" />
	</h1>
	<p>
		<s:text name="spain.text" />
	</p>
	<s:form>
		<s:textfield name="monument.name" label="Nom/Appellido"/>
		<s:textfield name="monument.location" label="Location/arrendamiento" />
		<s:textfield type="number" name="monument.visitor" label="Visiteur/Visitante"/>
		<s:submit value="Envoi/Despacho" />
	</s:form>
	<p>
		<a href="../index">Retour à l'Acceuil</a>
	</p>
</body>
</html>