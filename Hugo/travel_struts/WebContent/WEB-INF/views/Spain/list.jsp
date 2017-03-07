<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Lista de monumentos</title>
</head>
<body>

	<nav class="subnav1">
		<ul class='nav nav-pills nav-justified'>
			<li><a href='../index'><span
					class='glyphicon glyphicon-home'></span> Inicio</a>
			<li><a href='../Ireland/index'><span
					class='glyphicon glyphicon-king'></span> Ireland</a>
			<li><a href='../England/index'><span
					class='glyphicon glyphicon-plane'></span> England</a>
			<li><a href='proposal'><span
					class='glyphicon glyphicon-certificate'></span> Spain</a>
			<li><a href="../Italy/index"><span
					class='glyphicon glyphicon-glass'></span> Italy</a>
		</ul>
	</nav>

	<nav class="subnav2">
		<ul class='nav nav-pills nav-justified'>
			<li class='active'><a href='list'><span
					class='glyphicon glyphicon-tree-conifer'></span> Monuments</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>Lista de monumentos</h1>
		</div>

		<div class='row'>
			<section class='col-sm-4'></section>
			<section class='col-sm-4'>
				<table
					class='table table-hover table-condensed table-striped table-bordered'>
					<tr>
						<th>Monumento
						<th>Lugar
						<th>Visitantes
					</tr>
					<s:iterator value="monuments">
						<tr>
							<td><s:url action="byid" var="u">
									<s:param name="id" value="id" />
								</s:url><a href="${u}"><s:property value="name" /></a></td>
							<td><s:property value="location" /></td>
							<td><s:property value="visitor" /></td>
						</tr>
					</s:iterator>
				</table>
			</section>
			<section class='col-sm-4'></section>
		</div>
	</div>

</body>
</html>