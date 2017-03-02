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
<title>Spain: proposal</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
	<style>
.label {
	color:black;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<h1>Proposal</h1>
		<section class="form-group">
			<s:form>
				<s:textfield class="form-control" name="monument.name"
					label="name of the monument" />
				<s:textfield class="form-control" name="monument.location"
					label="location of the monument" />
					<!-- pour un nombre, on peut écrire type="number" -->
				<s:textfield type="number" class="form-control" name="monument.visitor"
					label="number of tourists" />
				<s:submit class="btn" value="send"/>
			</s:form>
		</section>
	</div>
</body>
</html>