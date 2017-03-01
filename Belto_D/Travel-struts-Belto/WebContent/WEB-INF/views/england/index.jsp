<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>England-travels</title>
</head>
<body>
<h1> Tous les voyages vers l'Angleterre</h1>
<p>
Depart:${departure} <%--une première façon d'afficher --%>
<br>
Départ:<s:date name="departure" format= "dd/MM/yyyy"/><%--une seconde façon --%>
<br>
Départ: <s:date name="departure" nice="true"/><%--encore une autre façon --%>
<br>
<s:date name="departure" format="yyyy"/>
<br>
Prix:${price}€
</p>
<h1><s:text name="england.title"/></h1>
<s:text name="england.price">
<s:param>${price}</s:param>
</s:text>
<br>
<a href="?request_locale=es">es</a><%--lien pour appeler les different fichier de lang --%>
<a href="?request_locale=en">en</a>
<br>
<s:url namespace="/england" action="index" var="v1"/><%--une façon de plus de faire --%>
<a href="${v1}">Accueil</a>
<br>
<s:url namespace="/england" action="index" var="u_en"><%--une façon de plus de faire --%>
<s:param name="request_locale" value="en"/><%--On appel lien paramétré --%>
</s:url>
<a href="${u_en}">en</a>
<s:debug />
</body>
</html>