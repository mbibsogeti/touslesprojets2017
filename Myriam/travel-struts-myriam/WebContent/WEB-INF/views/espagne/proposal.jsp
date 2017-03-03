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
		<h1>Les Monuments Espagnols :</h1>

		<div class="row col-xs-6">
			<h2>Ajouter un monument</h2>

			<s:form>
				<s:textfield name="monument.name" label="Nom du Monument" />
				<s:textfield name="monument.location"
					label="Ville où se situe le monument" />
				<s:textfield name="monument.pays" label="Pays du monument" />
				<s:textfield type="number" min="0" max="50" name="monument.visitor"
					label="Nombre de visiteur" />
				<s:submit value="Envoi" />
			</s:form>
		</div>

		<div class="row col-xs-6">
			<h2>Supprimer un monument</h2>

			<div class="clearfix"></div>
			<s:form action="byid">
				<s:textfield type="number" min="0" max="50" name="id"
					label="Numéro du Monument à supprimer" />
				<s:submit value="Envoi" />
			</s:form>
		</div>

		<div class="clearfix"></div>

		<p style='text-align: right'>
			<a href="list">Liste des monuments</a>
			<br />
			<a href="../">Retour
				Acceuil</a>
		</p>

	</div>

</body>
</html>