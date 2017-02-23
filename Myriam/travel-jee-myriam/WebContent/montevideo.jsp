<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="travel" uri="http://travel.com"%>
<fmt:setLocale scope="page" value="en" />
<%@include file="jsp/header.jsp"%>

<title>Montevideo</title>
</head>
<body>
	<div class="container">
		<h1>${fn:toUpperCase("Bienvenue à Montevideo")}</h1>
	

		<p>
		<travel:discount/>
			Pour un voyage à 1399€ nous offrons une promo de 15%, le prix revient
			donc à
			<fmt:formatNumber value="${promo}" pattern="0.00" />
			€
		</p>
		<p>Offre valable jusqu'au
			${now.getDayOfMonth()}/${now.getMonthValue()}/${now.getYear()+1}</p>

		<table class='table table-striped table-bordered table-condensed'
			style="width: 30%">
			<tr>
				<th>Jour</th>
				<th>Programme</th>
			</tr>
			<c:forEach items="${day}" var="day" varStatus="s">
				<tr>
					<th>${s.count}</
					<th>
					<td>${day}<c:if test="${s.count%2==0}">!</c:if></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>