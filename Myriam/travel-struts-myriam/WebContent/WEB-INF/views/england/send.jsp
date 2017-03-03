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
<title>Send</title>
<%@taglib prefix="s" uri="/struts-tags"%>
</head>

<body>
	<div class="container">
		<h1>Inscription</h1>

		<p>L'inscription à bien été enregistrée :</p>

		<div class="col-xs-4">
			<table class="table">
				<tr>
					<th>nom</th>
					<td>${name }</td>
				</tr>
				<tr>
					<th>email</th>
					<td>${email }</td>
				</tr>
				<tr>
					<th>luxe</th>
					<td>${luxury }</td>
				</tr>
			</table>

		</div>

		<div class="clearfix"></div>
		<p>
			<a href=inscription>retour</a>
	</div>

</body>
</html>