<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue en Angleterre !</title>
</head>
<body>
<h1><s:text name="england.title"/> <!--EnGlAnD HeRe We ArE !!  --></h1>
<!--<p>Départ ${departure} <!--est équivalent à l'écriture suivante --> 
<p>Départ: <s:date name="departure" format="dd/MM/yyyy"/></p></p>
<!--<p>Prix: ${price} €</p>est équivalent à l'écriture suivante</p> --> 
<p><s:text name="england.price">
<s:param>${price}</s:param>
</s:text></p>
<p><a href="?request_locale=de">Allemand</a></p>
<p><a href="?request_locale=es">Espagnol</a></p>
<p><a href="?request_locale=it">Italien</a></p>
<p><s:url namespace="/" action="index" var="v1"/>
<p><a href="${v1}">Page d'accueil</a></p>


<p><s:url namespace="/england/registration" action="index" var="v2"/>
<p><a href="${v2}">Page d'inscription</a></p>

</body>
</html>
