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
<title>Insert title here</title>
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
			<li><a href='../Spain/proposal'><span
					class='glyphicon glyphicon-certificate'></span> Spain</a>
			<li><a href="../Italy/index"><span
					class='glyphicon glyphicon-glass'></span> Italy</a>
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
			<p>${name}tu demanda de inscripcion ha sido enviada a tu correo
				electronico ${email}</p>
		</div>
	</div>
</body>
</html>