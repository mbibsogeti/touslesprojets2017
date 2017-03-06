<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='../css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/bonito.css'>
<meta http-equiv="X-UA-Compatible" content='IE=edge'>
<meta name='viewport'
	content='width=device-width, initial-scale=1 minimum-scale=0.5'>
<meta charset="UTF-8">
<title>Viajes a Irlanda</title>
</head>
<body>

	<nav class="subnav1">
		<ul class='nav nav-pills nav-justified'>
			<li><a href='../index'><span
					class='glyphicon glyphicon-home'></span> Inicio</a>
			<li><a href='index'><span class='glyphicon glyphicon-king'></span>
					Ireland</a>
			<li><a href='../England/index'><span
					class='glyphicon glyphicon-plane'></span> England</a>
			<li><a href='../Spain/proposal'><span
					class='glyphicon glyphicon-certificate'></span> Spain</a>
			<li><a href="../Italy/index"><span
					class='glyphicon glyphicon-glass'></span> Italy</a>
		</ul>
	</nav>

	<nav class="subnav2">
		<ul class='nav nav-pills nav-justified'>
			<li><a href='info'><span
					class='glyphicon glyphicon-tree-deciduous'></span> Informacion
					practica</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-send'></span> Viajes</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>Viajes a Irlanda</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>Una semana en el Temple Bar</h2>
				<p>Te proponemos ${viajes.size()} destinos para que Irlanda no
					tenga mas secretos para ti: ${viajes[0].lugar}, ${viajes[1].lugar}
					y ${viajes[2].lugar}</p>
			</section>

			<section class='col-sm-6'>
				<h2>Excursiones para cazar ovejas</h2>
				<table
					class='table table-hover table-condensed table-striped table-bordered'>

					<!-- 				<tr> -->
					<%-- 					<th>Destino<s:iterator value="viajes"><td><s:property value="lugar"/></s:iterator> --%>
					<!-- 				<tr> -->
					<%-- 					<th>Duracion<s:iterator value="viajes"><td><s:property value="dias"/></s:iterator> --%>
					<!-- 				<tr> -->
					<%-- 					<th>Estadia<s:iterator value="viajes"><td><s:property value="hospedaje"/></s:iterator> --%>
					<tr>
						<th>Index
						<th>Destino
						<th>Duracion
						<th>Estadia
					</tr>
					<s:iterator value="viajes" status="st">
						<tr>
							<td><s:property value="#st.index" /></td>
							<td><s:property value="lugar" /></td>
							<td><s:property value="dias" /></td>
							<td><s:property value="hospedaje" /> <s:if
									test='hospedaje=="hotel"'>
								&#9733; &#9733; &#9733;
							</s:if> <s:else>&#9733; &#9733;</s:else></td>
						</tr>
					</s:iterator>
				</table>
			</section>
		</div>
	</div>

	<%-- 	<s:debug /> --%>
	<!-- diferentes formas de hacer lo mismo  -->
	<%-- 	${viajes[0].lugar} --%>
	<%-- 	<s:property value="viajes[1].lugar"/> --%>
	<%-- 	<s:property value="#action.viajes[2].lugar"/> --%>
	<%-- 	<s:iterator value="viajes"> --%>
	<%-- 		<s:property value="lugar" /> --%>
	<%-- 	</s:iterator> --%>

</body>
</html>