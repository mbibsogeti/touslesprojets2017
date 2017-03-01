<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Ireland: travel</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="container">
		<h1>Travel with us!!</h1>
		<a href="../index">Back to the Welcome page</a><br> <a
			href="index">Back to Welcome in Ireland</a><br> <a href="info">More
			information</a>
		<!--  En appelant "travels", le compilateur va chercher automatiquement dans la classe action.
			Il y cherchera une méthode appelée methodeTravels (ce mécanisme est conventionnel). il considère donc que "travels." équivaut à "getTravels."-->
		<p>We currently have ${travels.size()} destinations available. For
			example: ${travels[4].location}!</p>
		<table class="table table-hindered table-striped">
			<tr style="background:lightblue;color:white">
				<th>Location</th>
				<th>Days</th>
				<th>Accomodation</th>
			</tr>
			<s:iterator value="travels">
				<tr>
					<th><s:property value="location" /></th>
					<th><s:property value="days" /></th>
					<th><s:property value="accomodation" /></th>
				</tr>
				<br>
			</s:iterator>
		</table>
		<!-- Informations de debug affichées sur page web -->
		<s:debug />
	</div>
</body>
</html>
