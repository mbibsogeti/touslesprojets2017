<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage</title>
</head>
<body>
	<h1>${monument.name}</h1>
	<p>Où? ${monument.location}</p>
	<p>
		<a href="../index">Retour à l'Acceuil</a>
	</p>
</body>
</html>