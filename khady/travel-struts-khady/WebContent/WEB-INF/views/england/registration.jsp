<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Veuillez vous inscrire ici !</title>
<link rel="stylesheet" href="WEB-INF/css/bootstrap.min.css">
</head>
<body background-color: lightblue;>
<h1>Page d'inscription </h1>
<s:form action = "send" class="form-inline">
<div class="form-group">
<fieldset>
<p><legend>Inscription</legend>
<p><s:textfield name="name" label="Nom"/></p>
<p><s:textfield name="email" label="Email"/></p>
</div>
<div class="checkbox">
<p><s:checkbox name="luxury" label="Luxe"/></p>
</div>
<p><s:submit value="Envoi" class="btn btn-default"/>
</fieldset>
</s:form>

</body>
</html>
