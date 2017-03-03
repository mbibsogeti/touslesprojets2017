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
<title>Spain: byId</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
<style>
.label {
	color: black;
}
</style>
</head>
<body>
	<div class="container">
		<h1>${monument.name}</h1>
		<p>Where you are heading: ${monument.location}. We will prepare accomodation for ${monument.visitor}.</p>
	</div>
</body>
</html>