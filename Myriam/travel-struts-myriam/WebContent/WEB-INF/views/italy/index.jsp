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
<title>Italie</title>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
.wwFormTable .label {
	color: black;
}
</style>
</head>

<body>
	<div class="container">
		<h1 style='text-align: center'>Bienvenue en Italie ... Et voici
			une liste de monuments déjà visité par nos adhérents : </h1>
		<br />

		<div class="row col-xs-8">
			<table class="table">
				<tr>
					<th>Nom du monument</th>
					<th>Ville</th>
					<th>Commentaires</th>

					<s:iterator value="monuments" var="m" status="st">
						<tr>
							<td><s:url action="showbyid" var="u">
									<s:param name="id" value="id" />
								</s:url><a href="${u}"><s:property value="name" /></a></td>
							<td><s:property value="location" /></td>
							<td>
									<ul><s:iterator value="%{getComments(#m)}">
										<li><s:property value="text" />(<s:property value="author" />)</li>
									</s:iterator>
									</ul>
								</td>

						</tr>
					</s:iterator>
			</table>
		</div>


		<div class="clearfix"></div>
		<p></p>
		<p style='text-align: right'>
			<a href="../">Accueil</a>
		</p>

	</div>

</body>
</html>