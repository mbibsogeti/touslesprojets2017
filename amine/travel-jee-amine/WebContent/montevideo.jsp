<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="travel" uri="http://travel.com"%>
<fmt:setLocale scope="page" value="en" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Montevideo</title>
</head>
<body>
	<h1>Montevideo<travel:discount/></h1>
	<h1>${fn:toUpperCase("Montevideo")}</h1>
	<p>Notre promo du moment avec 15% de réduction est à: ${promo}€</p>
	<p>
		Notre promo du moment avec 15% de réduction est à:
		<fmt:formatNumber value="${promo}" pattern="0.0" />
		€
		<!-- arrondi et fait une adaptation de la virgule , -->
	</p>
	<!-- promo1 -->
	<p>Valide jusqu'au: 31/12/${now.getYear()}</p>
	<!-- promo2 -->
	<p>Valide jusqu'au:
		${now.dayOfMonth}/${now.monthValue}/${1+now.year}</p>
	<table border="1">
		<tr>
			<th>Jour</th>
			<th>Programme</th>
		</tr>
		<c:forEach items="${days}" var="day" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${day}<c:if test="${s.count%2==0}">!</c:if></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>