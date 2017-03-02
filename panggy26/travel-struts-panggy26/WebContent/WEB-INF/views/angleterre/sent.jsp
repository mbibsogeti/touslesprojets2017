<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire envoyé</title>
</head>
<body>
	<h1>Formulaire envoyé !</h1>
	Félicitations ${name} ! Votre demande de réservation
	<%-- luxury est ici transformé en isLuxury --%>
	<s:if test="luxury==true">
		 $ luxueuse $
	</s:if>
		a bien été prise pour l'adresse mail ${mail} :) !
	<p>
		<a href="./registration">Retour au formulaire</a>
	</p>
</body>
</html>