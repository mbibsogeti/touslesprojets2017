<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Angleterre</title>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
.wwFormTable .label {
	color: black;
}
</style>
</head>

<body>
	<div class="container">
		<h1>Liste des Monuments</h1>

		<div class="row col-xs-8">
			<table class="table">
				<tr>
					<th>Nom du monument</th>
					<th>Ville</th>
					<s:iterator value="monuments" status="st">
						<tr>
							<td><s:url action="showbyid" var="u"><s:param name="id" value="id"/></s:url><a href="${u}"><s:property value="name"/></a></td>
							<td><s:property value="location"/></td>
						</tr>
					</s:iterator>
			</table>
		</div>

		<div class="clearfix"></div>
		<p></p>
		<p style='text-align:right'>
			<a href="proposal">Retour</a><br/>
			<a href="../">Retour Accueil</a>
		</p>

	</div>

</body>
</html>