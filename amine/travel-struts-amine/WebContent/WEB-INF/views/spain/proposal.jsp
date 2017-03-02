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
	<h1>
		<s:text name="spain.name" />
	</h1>
	<p><s:text name="spain.text" /></p>
	<p>
		<a href="?request_locale=es">ES</a> <a href="?request_locale=fr">FR</a>
	</p>
	<p>
		<a href="../index">Retour à l'Acceuil</a>
</body>
</html>