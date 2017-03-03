<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Voyages</title>

<!-- On récupère les fonctions offertes par Struts :  -->
<%@taglib prefix="s" uri="/struts-tags"%>

</head>

<body>

	<div class="container">
		<h1>Nos voyages</h1>

		<div class="row">
		<p>Nombre de voyages disponibles : ${travels.size()}</p>
		<ul>
			<li>${travels.get(0).get("location")}</li>
			<li>${travels[1].location}</li>
			<!-- modèles struts pour récupérer les infos :  -->
			<li><s:property value="travels[2].location" /></li>
			<li><s:property value="#action.travels[3].location" /></li>
		</ul>
	</div>
	
	<div class="row col-xs-6">
		<table class="table" style="text-align:center">
			<tr>
				<th></th>
				<th style="text-align:center">Ville</th>
				<th style="text-align:center">Nombre de jours</th>
				<th style="text-align:center">Hebergement</th>
				<th style="text-align:center">Confort</th>
			</tr>
			<s:iterator value="travels" status="st">
				<tr>
					<th><s:property value="#st.index+1" /></th>
					<td><s:property value="location" /></td>
					<td><s:property value="days" /></td>
					<td><s:property value="accomodation" /></td>
					<td><s:if test="accomodation=='hotel'">&#9733;&#9733;&#9733;</s:if><s:else>&#9733;&#9733;</s:else></td>
				</tr>

			</s:iterator>
		</table>
	</div>

<div class="clearfix"></div>
	<p>
		<a href="index">retour</a>
	</p>


	</div>

	<!-- option de débug de Struts -->
	<s:debug />

</body>
</html>