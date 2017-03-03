<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Angleterre</title>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
.wwFormTable .label{color:black;}
</style>
</head>

<body>
	<div class="container">
		<h1>
			Inscription
		</h1>
		<s:form action="send">
		<s:textfield name="name" key="england.name" />
		<s:textfield name="email" label="email"/>
		<s:checkbox name="luxury" label="luxe"/>
		<s:submit value="Envoi"/>
		</s:form>
	</div>

</body>
</html>