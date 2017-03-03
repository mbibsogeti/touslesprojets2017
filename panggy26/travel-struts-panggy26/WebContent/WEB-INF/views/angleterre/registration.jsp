<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h1>Inscription</h1>
	<p>
		<a href="./index">Index anglais</a>
	</p>
	<s:form action="send">
			<s:textfield name="name" label="Nom "/>
			<s:textfield name="mail" label="Email "/>
			<s:checkbox name="luxury" label="Formule luxe "/>
			<s:submit value="Envoi "/>
	</s:form>
</body>
</html>