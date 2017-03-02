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
<title>Viaje a Inglaterra</title>
</head>
<body>

	<nav class="subnav1">
	<ul class='nav nav-pills nav-justified'>
		<s:url namespace='/' action='index' var='u1' />
		<li><a href='${u1}'><span class='glyphicon glyphicon-home'></span>
				Inicio</a>
		<li><a href='../Ireland/index'><span
				class='glyphicon glyphicon-king'></span> Ireland</a>
		<li class='active'><a href='#'><span
				class='glyphicon glyphicon-plane'></span> England</a>
	</ul>
	</nav>

	<nav class="subnav2">
	<ul class='nav nav-pills nav-justified'>
		<s:url namespace='/England' action='registration' var='eng_reg' />
		<li><a href="${eng_reg}"><span
				class='glyphicon glyphicon-tree-deciduous'></span> Inscripcion</a>
	</ul>
	</nav>

	<nav>
	<ul class='nav nav-pills nav-justified'>
		<s:url namespace='/England' action='index' var='u_en'>
			<s:param name='request_locale'>en</s:param>
		</s:url>
		<li><a href="${u_en}">English</a></a> <s:url namespace='/England'
				action='index' var='u_es'>
				<s:param name='request_locale'>es</s:param>
			</s:url>
		<li><a href="${u_es}">Español</a> <s:url namespace='/England'
				action='index' var='u_fr'>
				<s:param name='request_locale'>fr</s:param>
			</s:url>
		<li><a href="${u_fr}">Français</a></a>
	</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>
				<s:text name="england.title" />
			</h1>

		</div>

		<div class='row'>
			<section class='col-sm-6'>
			<h2>
				<s:text name="england.subtitle" />
			</h2>
			<p>
				Salidas a Inglaterra desde el
				<s:date name="salida" format="dd" />
				/
				<s:date name="salida" format="MM" />
				/
				<s:date name="salida" format="yyyy" />
				por tan solo ${precio} €.
			</p>
			<p>
				<s:text name="england.price">
					<s:param>${Precio}</s:param>
				</s:text>
				€
			</p>
			<%-- 			<s:date name="salida" nice="true"/> --%> </section>

			<section class='col-sm-5'> </section>

			<section class='col-sm-1'> </section>
		</div>
	</div>


</body>
</html>