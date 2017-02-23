<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="viaje" uri="http://seek-and-destroy.space"%>

<fmt:setLocale scope="page" value="en" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='../css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/bonito.css'>
<title>El Viaje de tus Sueños: Montevideo</title>
</head>
<body>

	<nav>
		<ul class='nav nav-pills nav-justified'>
			<li><a href='../index.html'><span
					class='glyphicon glyphicon-home'></span> Inicio</a>
			<li><a href='../ecuador/quito'><span
					class='glyphicon glyphicon-headphones'></span> Quito</a>
			<li><a href='../colombia/cartagena'><span
					class='glyphicon glyphicon-king'></span> Cartagena</a>
			<li><a href='../venezuela/maracaibo'><span
					class='glyphicon glyphicon-apple'></span> Maracaibo</a>
			<li><a href='../peru/lima'><span
					class='glyphicon glyphicon-camera'></span> Lima</a>
			<li><a href='../chile/santiago'><span
					class='glyphicon glyphicon-scissors'></span> Santiago</a>
			<li><a href='../lapaz.jsp'><span
					class='glyphicon glyphicon-cloud'></span> La Paz</a>
			<li><a href='../buenosaires.jsp'><span
					class='glyphicon glyphicon-education'></span> Buenos Aires</a>
			<li><a href='../asuncion.jsp'><span
					class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-flash'></span> Montevideo</a>
			<li><a href='../guyana/georgetown'><span
					class='glyphicon glyphicon-send'></span> Georgetown</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>${fn:toUpperCase("Montevideo - Uruguay")}</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>Viajes a Montevideo</h2>
				<p>
					<viaje:discount />
				</p>
				<p>
					Con una reduccion de 15% sobre un precio inicial de 1399 €, el
					precio del vuelo a Montevideo se lo dejamos por
					<fmt:formatNumber value="${precioFinal}" pattern="0.00" />
					€ (Promocion valida hasta el
					${finPromo.getDayOfMonth()}/${finPromo.getMonthValue()}/${finPromo.plusYears(1).getYear()}
				</p>
			</section>

			<section class='col-sm-6'>
				<h2>Programa de la estadia</h2>
				<p>El programa Montevideo reune actividades variadas durante
					toda la estadia, tales como:</p>
				<div class=" col-lg-6 col-push-right-4 tablas">
					<table
						class='table table-hover table-condensed table-striped table-bordered'>
						<tr>
							<th>Dia
							<th>Actividad <c:forEach items="${programaDias}" var="dia"
									varStatus="s">
									<tr>
										<td>${s.count}
										<td>${dia}<c:if test="${s.count%2==0}">!</c:if>
								</c:forEach>
					</table>
				</div>

			</section>
		</div>
	</div>
</body>
</html>