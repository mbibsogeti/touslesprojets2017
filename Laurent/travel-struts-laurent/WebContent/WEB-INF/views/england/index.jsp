<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>England</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center">
				<!-- Affiche du text statique défini dans global(_fr).properties -->
				<s:text name="england.title"/>
			</h1>
		</div>
		<div class="row">
			<p class="col-md-6 col-md-offset-3">
				<img alt="" src="/travel-struts-laurent/img/england1.jpg" class="img-thumbnail">
		</div>
		<div class="row">
			<h3>Départ : <s:date name="dateP[0]" format="dd/MM/yyyy"/></h3>
			<h3>
				<s:text name="england.price">
					<s:param>${dateP[1]}</s:param>
				</s:text>
			</h3>
		</div>
	</div>
	<aside>
		<a href="?request_locale=fr" class="btn btn-primary"> fr </a>
		<a href="?request_locale=en" class="btn btn-primary"> en </a>
		<a href="?request_locale=es" class="btn btn-primary"> es </a>
	</aside>
</body>
</html>