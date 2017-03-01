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
	<h1><s:text name="england.title"> <s:param>${price}</s:param><s:param>${price+250}</s:param></s:text></h1>
	<ul>
		<%-- autre syntaxe possible pour la suite :<s:date name="departure" affiche la date (que pour les date) et en tagligstruts ${departure} ou ${price} --%>
		<li>Depart: <s:date name="departure" format="yyyy/MM/dd"/></li>
		<%--  la value departure appel la fonction getDeparture ,automatiquemen il met une majuscule et le get--%>
	    <li>Départ dans: <s:date name="departure" nice="true"/></li>
		<%-- nice renvoi un compte a rebour --%>
		<li>Prix:<s:property value="price" /></li>
	</ul>
	<a href="../index">retour a l'accueil</a>

</body>
</html>