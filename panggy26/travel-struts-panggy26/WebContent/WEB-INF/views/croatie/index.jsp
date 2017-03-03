<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Croatie index</title>
</head>
<body>
	<h1>Bienvenue en Croatie !</h1>
	<p>
		<%-- Lien index Europe --%>
		<%-- namespace et action prennent les valeurs du fichier struts.xml --%>
		<s:url namespace="/" action="index" var="url1" />
		<a href="${url1}">Retour à l'index Europe</a>
	</p>
	<p>${croatieMessenger.offers}</p>
</body>
</html>
<s:debug/>