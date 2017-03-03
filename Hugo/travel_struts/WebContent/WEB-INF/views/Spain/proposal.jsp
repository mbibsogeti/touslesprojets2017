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
<title>Viaje a España</title>
</head>
<body>

	<nav class="subnav1">
		<ul class='nav nav-pills nav-justified'>
			<s:url namespace='/' action='index' var='u1' />
			<li><a href='${u1}'><span class='glyphicon glyphicon-home'></span>
					Inicio</a>
			<li><a href='../Ireland/index'><span
					class='glyphicon glyphicon-king'></span> Ireland</a>
			<li><a href='../England/index'><span
					class='glyphicon glyphicon-plane'></span> England</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-certificate'></span> Spain</a>
			<li><a href="../Italy/index"><span
					class='glyphicon glyphicon-glass'></span> Italy</a>
		</ul>
	</nav>

	<nav class="subnav2">
		<ul class='nav nav-pills nav-justified'>
			<li><a href='list'><span
					class='glyphicon glyphicon-tree-conifer'></span> Monuments</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>España</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>Formulario de inscripcion</h2>
				<s:form>
					<style>.wwFormTable .label {color: black}</style>
					<s:textfield name="monument.name" label="Nombre"></s:textfield>
					<s:textfield name="monument.location" label="Sitio"></s:textfield>
					<s:textfield name="monument.visitor" label="Visitantes"
						type="number"></s:textfield>
					<s:submit value="Enviar" />
				</s:form>
			</section>

			<section class='col-sm-6'>
				<!-- 			<h2></h2> -->
			</section>
		</div>
	</div>

</body>
</html>