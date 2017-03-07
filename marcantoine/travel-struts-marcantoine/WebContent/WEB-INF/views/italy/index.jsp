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
<title>Italy: index</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<h1>Italy: welcome on this webpage</h1>
		<table class="table table-hindered table-striped"
			style="text-align: justify">
			<tr></tr>
			<s:iterator value="monuments" status="st">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="location" /></td>
					<td><s:property value="visitor" /></td>
				</tr>
			</s:iterator>
		</table>
		<h2>Comments about these monuments:</h2>
		<table class="table table-hindered table-striped"
			style="text-align: justify">
			<!-- var="m" équivaut en java à for (m:list){} -->
			<!-- tableau des comms tous seuls -->
			<s:iterator value="monuments" status="st" var="m">
				<tr>
					<td><s:iterator value= "%{getComments(#m)}"><s:property value="id" /></s:iterator></td>
					<td><s:iterator value= "%{getComments(#m)}"><s:property value="author" /></s:iterator></td>
					<td><s:iterator value= "%{getComments(#m)}"><s:property value="text" /></s:iterator></td>
				</tr>
			</s:iterator>
		</table>
		
		<!-- tableau monuments + commentaires -->
		<h2>All the information in a blink:</h2>
		<table class="table table-hindered table-striped"
			style="text-align: justify">
			<tr></tr>
			<s:iterator value="monuments" status="st" var="m">
				<s:iterator value= "%{getComments(#m)}" var="c">
					<tr>
						<td><s:property value="#m.id" /></td>
						<td><s:property value="#m.name" /></td>
						<td><s:property value="#m.location" /></td>
						<td><s:property value="#m.visitor" /></td>
						<td><s:property value="#c.text" /></td>
					</tr>
				</s:iterator>
			</s:iterator>
		</table>
	</div>
</body>
</html>