<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asuncion</title>
</head>
<body>
	<div>
		<h1>Bienvenido a Asunción</h1>
		<!-- Inclut le contenu du fichier headerAsuncion.jsp -->
		<%@ include file="./WEB-INF/jsp/headerAsuncion.jsp" %>
		<!-- Autre syntaxe -->
		<!-- On récupère le paramètre year du fichier footerAsuncion -->
		<jsp:include page="./WEB-INF/jsp/footerAsuncion.jsp">
			<jsp:param value="1923" name="year"/>
		</jsp:include>
	</div>
</body>
</html>