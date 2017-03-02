<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/bonito.css'>
<meta http-equiv="X-UA-Compatible" content='IE=edge'>
<meta name='viewport'
	content='width=device-width, initial-scale=1 minimum-scale=0.5'>
<meta charset="UTF-8">
<title>Inscripciones para Inglaterra</title>
</head>
<body>

	<nav class="subnav1">
	<ul class='nav nav-pills nav-justified'>
		<s:url namespace='/' action='index' var='u1' />
		<li><a href='${u1}'><span class='glyphicon glyphicon-home'></span>
				Inicio</a>
		<li><a href='../Ireland/index'><span
				class='glyphicon glyphicon-king'></span> Ireland</a>
		<li><a href='index'><span class='glyphicon glyphicon-plane'></span>
				England</a>
	</ul>
	</nav>

	<nav class="subnav2">
	<ul class='nav nav-pills nav-justified'>
		<s:url namespace='/England' action='registration' var='eng_reg' />
		<li class='active'><a href="${eng_reg}"><span
				class='glyphicon glyphicon-tree-deciduous'></span> Inscripcion</a>
	</ul>
	</nav>


	<div class='container'>
		<div>
			<h1>Inscripciones</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
			<h2>Formulario</h2>
			<s:form action="send">
			<style>.wwFormTable .label{color:black}</style>
				<s:textfield name="name" label="Nombre" />
				<s:textfield name="email" label="E-mail" />
				<s:checkbox name="luxury" label="Lujo?" />
				<s:submit value="Enviar" />
			</s:form> </section>

			<section class='col-sm-5'> </section>

			<section class='col-sm-1'> </section>
		</div>
	</div>

</body>
</html>