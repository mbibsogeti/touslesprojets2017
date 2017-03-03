<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<title>ITALY</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/Italie.jpg" alt="Photo_ireland" class="col-sm-12" />
		</header>
		<section class="row col-sm-12">
			<h1>Welcome to ITALY</h1>
		</section>	
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th>Monument</th>
				<th>Location</th>
				<th>Visitors</th>
				<th>Comment</th>
			</tr>
			<s:iterator value="monuments" var="m">
				<tr>
					<td><s:property value="name"/></td>
					<td><s:property value="location" /></td>
					<td><s:property value="visitor" /></td>
					<td>
					<s:iterator value="%{getComments(#m)}">
					- <s:property value="text" /></br>
					</s:iterator>
					</td>
				</tr>
			</s:iterator>
		</table>
		<section class="row col-sm-12">
			<a href="../index">Home</a>
		</section>	
	</div>
</body>
</html>