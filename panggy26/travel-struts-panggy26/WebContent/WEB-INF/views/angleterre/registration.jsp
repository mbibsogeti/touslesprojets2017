<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<s:submit label="Envoi "/>
	</s:form>
</body>
</html>