<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spain</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
<style>
	.wwFormTable .label{
		color:black;
	}
</style> 
</head>
<body>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div class="container">
		<div class="row">
			<h1 class="text-center"><s:text name="spain.proposal"/></h1>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<s:form>
					<s:textfield name="monument.name" label="Name" class="form-control" />
					<s:textfield name="monument.location" label="Location" class="form-control"/>
					<s:textfield type="number" name="monument.visitor" label="Visitor" class="form-control"/>
					<s:submit value="Send" class="btn btn-default"/>
				</s:form>
			</div>
		</div>
</div>
<aside>
		<a href="?request_locale=fr" class="btn btn-primary"> fr </a>
		<a href="?request_locale=en" class="btn btn-primary"> en </a>
		<a href="?request_locale=es" class="btn btn-primary"> es </a>
</aside>
</body>
</html>