<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="england.title" /></title>
</head>
<body>
	<h1><s:text name="england.title"/> </h1>
	<%--<s:param>${price}</s:param><s:param>${price+250}</s:param> --%>
	
	<ul>
		<%-- autre syntaxe possible pour la suite :<s:date name="departure" affiche la date (que pour les date) et en tagligstruts ${departure} ou ${price} --%>
		<li>Depart: <s:date name="departure" format="yyyy/MM/dd"/></li>
		<%--  la value departure appel la fonction getDeparture ,automatiquemen il met une majuscule et le get--%>
	    <li>Départ dans: <s:date name="departure" nice="true"/></li>
		<%-- nice renvoi un compte a rebour --%>
		<li>Prix:<s:property value="price" /></li>
	</ul>
	<s:url namespace="/" action="index" var="u1"/>
	<s:url namespace="/england" action="index" var="u_en"> <%--génere un url via struts --%>
	<s:param name="request_locale" value="'en'"/>
	</s:url>
	<s:url namespace="/england" action="index" var="u_fr"> <%--génere un url via struts --%>
	<s:param name="request_locale" value="'fr'"/>
	</s:url>
	<a href="${u_en}">en</a>
	<a href="${u_fr}">fr</a>
	<%--<a href="?request_locale=fr">fr</a> --%>
	
	<a href="${u1}">retour a l'accueil</a>
	<a href="registration">registration</a>
	<a href="list">list</a>
</body>
</html>