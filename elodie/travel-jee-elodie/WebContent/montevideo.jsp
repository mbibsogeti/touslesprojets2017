<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sti" uri="http://travel.com"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MONTEVIDEO</title>
</head>
<body>
	<p>
		<sti:discount />
	</p>
	<h1>${fn:toUpperCase("Montevideo")}</h1>
	<p>Montevideo ou Montévidéo2, de son nom complet San Felipe y
		Santiago de Montevideo, est la capitale, le principal port et la plus
		grande ville d'Uruguay et est aussi celle du département de
		Montevideo. Montevideo possède une des plus importantes rades des
		Amériques (appelée Rambla[réf. souhaitée]). Elle se trouve dans la
		partie sud du pays et est bordée par le Rio de la Plata. La ville
		comptait 1 325 968 habitants en 2004 et son aire métropolitaine 1 668
		335, soit presque la moitié de la population du pays. La ville possède
		également de superbes plages, telles que Pocitos, Buceo, Malvín, Playa
		de los Ingleses, Playa Verde, Punta Gorda et Carrasco.</p>

	<p>
		Pour un voyage à 1399 €, bénéficiez d'une remise de 15% soit un voyage
		à
		<fmt:formatNumber value="${promo}" pattern="0,000.00" />
		€
	</p>

	<table>
		<tr>
			<th>Jours</th>
			<th>Programme</th>
		</tr>

		<c:forEach items="${days}" var="eachDay" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td>${eachDay}<c:if test="${i.count%2==0}">!</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<p>Valide jusqu'au ${now.getDayOfMonth()}/
		${now.getMonthValue()}/${now.getYear()+1}</p>


</body>
</html>