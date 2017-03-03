<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Par identifiant</title>
</head>
<body>
	<h1>${monument.name}</h1>
	<p>Où ? ${monument.location}</p>
	<p>Nombre de visiteur(s) quotidien : ${monument.visitor}</p>
</body>
</html>