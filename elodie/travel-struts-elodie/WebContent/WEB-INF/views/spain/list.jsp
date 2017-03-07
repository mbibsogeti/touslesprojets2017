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
<style>
.wwFormTable .label {
	color: black
}
</style>
<title>SPAIN</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/espagne3.jpg" alt="Photo_spain" class="col-sm-12" />
		</header>
		<section class="row col-sm-12">
			<h1>Liste de monuments</h1>
		</section>
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th>Monument</th>
				<th>Location</th>
				<th>Visitors</th>
			</tr>
			<s:iterator value="monuments">
				<%-- Je veux lire dans le getMonuments donc value="monuments" --%>
				<tr>
					<td>
					<s:url action="byid" var="u">
						<s:param name="id" value="id" />
					</s:url>
						<a href="${u}"><s:property value="name"/></a>
					</td>
					<td><s:property value="location" /></td>  <%-- Attribut de la classe Monument --%>
					<td><s:property value="visitor" /></td>
				</tr>
			</s:iterator>
		</table>
		<section class="row col-sm-12">
			<a href="proposal">Les propositions ... </a>
		</section>
		<section class="row col-sm-12">
			<a href="../index">Home</a>
		</section>
	</div>
</body>
</html>