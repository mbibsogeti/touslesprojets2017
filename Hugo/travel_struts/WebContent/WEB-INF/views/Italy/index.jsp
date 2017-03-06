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
<title>Viaje a Italia</title>
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
			<li><a href="../Spain/proposal"><span
					class='glyphicon glyphicon-certificate'></span> Spain</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-glass'></span> Italy</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>Italia</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>Monumentos</h2>
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

			<section class='col-sm-6'>
				<h2>Comentarios</h2>
				<table
					class='table table-hover table-condensed table-striped table-bordered'>
					<tr>
						<th>Monumento
						<th>Comentarios
					</tr>
					<s:iterator value="monuments" var="m">
						<tr>
							<td><s:property value="name" />
							<td><ul>
									<s:iterator value="%{getComments(#m)}">
										<li><s:property value="text" /> - Autor: <s:property
												value="author" />
									</s:iterator>
								</ul></td>
						</tr>
					</s:iterator>
				</table>
			</section>
		</div>
	</div>

</body>
</html>