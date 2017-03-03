<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimal-scale=0.5">
<title>England-Enregistrement</title>
<h1><s:text name="england.registration"/></h1>
<link rel="stylesheet" href="/travel-struts-Belto/CSS/bootstrap.min.css">
</head>
<body>
<div class="container">

<s:form action="send"><%--action =send sera appeler par SendAction qui renvoie à sent.jsp --%>
<s:textfield name="name" label="Nom"/>
<s:textfield name="email" label="email"/>
<s:checkbox name="luxury" label="Luxe"/>
<s:submit value="send"/>
</s:form>

<s:debug />
</div>
</body>
</html>