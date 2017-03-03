<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>¡Bienvenido a España!</h1>
	<p>
		<%-- Lien index Europe --%>
		<%-- namespace et action prennent les valeurs du fichier struts.xml --%>
		<s:url namespace="/" action="index" var="url1" />
		<a href="${url1}">Retour à l'index Europe</a>
	</p>
	<p>
		<%-- Lien vers la liste des monuments --%>
		<%-- namespace et action prennent les valeurs du fichier struts.xml --%>
		<s:url namespace="/espagne" action="list" var="url2" />
		<a href="${url2}">Consultez la liste des monuments</a>
	</p>
	<s:form>
		<%-- name="monument.name" désigne les mêmes noms que les setters des classes EspagneProposal et Monument --%>
		<s:textfield name="monument.name" label="Nom du monument "/>
		<s:textfield name="monument.location" label="Site "/>
		<s:textfield type="number" name="monument.visitor" label="Nombre de visiteur(s) "/>
		<s:submit value="Envoyer"/>
	</s:form>
</body>
</html>