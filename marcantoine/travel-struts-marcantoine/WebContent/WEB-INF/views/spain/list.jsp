<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Spain: list</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
<style>
.label {
	color: black;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container">
		<h1>Our trips:</h1>
		<table class="table table-hindered table-striped"
			style="text-align: center">
			<tr></tr>
			<s:iterator value="monuments" status="st">
				<tr>
					<!-- on utilise un lien paramétré faisant référence au fichier struts.xml -->
					<td><s:url action="byId" var="u">
							<s:param name="id" value="id" />
						</s:url> <a href="${u}"><s:property value="id" /></a></td>
					<td><s:url action="byId" var="u">
							<s:param name="id" value="id" />
						</s:url><a href="${u}"><s:property value="name" /></a></td>
					<td><s:url action="byId" var="u">
							<s:param name="id" value="id" />
						</s:url><a href="${u}"><s:property value="location" /></a></td>
					<td><s:url action="byId" var="u">
							<s:param name="id" value="id" />
						</s:url><a href="${u}"><s:property value="visitor" /></a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>