<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Angleterre</title>
</head>
<body>
	<h1>Welcome to England ! To see this message will cost you 10 £</h1>
	<h2>
		<s:text name="england.title" />
	</h2>
	<p>
		<%-- Lien index Europe --%>
		<%-- namespace et action prennent les valeurs du fichier struts.xml --%>
		<s:url namespace="/" action="index" var="url1"/>
		<a href="${url1}">Retour à l'index Europe</a>
	</p>
	<p>
		Départ prévu le :
		<%-- Formatage à la main en récupérant chaque morceau de la date. ${depart} renvoie un truc tout moche. --%>
		<s:date name="depart" format="dd" />
		/
		<s:date name="depart" format="M" />
		/
		<s:date name="depart" format="yyyy" />
		Cela vous laisse
		<s:date name="depart" nice="true" />
		pour faire vos bagages. Le voyage vous coûtera ${prix} €.
	</p>
	<p>
		<s:text name="england.price">
			<s:param>${prix}</s:param>
			<%-- Si prix contient plusieurs valeurs, il faut refaire ${prix} pour afficher les suivantes 
			<s:param>${prix + 250}</s:param> --%>
		</s:text>
	</p>
	<p>
		Inscrivez-vous 	<s:url namespace="/angleterre" action="registration" var="url"/>
		<a href="${url}">ici</a>
	<p>
		<%-- Synthaxe Struts --%>
		<%-- En français --%>
		<s:url namespace="/angleterre" action="index" var="u_fr">
		<s:param name="request_locale" value="'fr'"/>
		</s:url>
		<a href="${u_fr}">Français</a>
		<%-- En anglais --%>
		<s:url namespace="/angleterre" action="index" var="u_en">
			<s:param name="request_locale" value="'en'"/>
		</s:url>
		<a href="${u_en}">English</a>
		<%-- Synthaxe HTML --%>
		<%-- Autre Rester sur la même page, juste en modifiant le paramètre après "?" --%>
		<a href="?request_locale=es">Español</a> 
		<a href="?request_locale=vi">Tiếng Việt</a>	
	</p>
</body>
</html>