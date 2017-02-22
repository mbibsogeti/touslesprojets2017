<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%--Pour trouver l'uri, aller dans x.tld / fmt.tld... --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="t" uri="http://travel.com"%>
<fmt:setLocale scope="page" value="en"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Montevideo</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
	<jsp:include page="WEB-INF/jsp/header.jsp">
		<jsp:param name="year" value="2017" />
	</jsp:include>
	
	<div class="container">
		<section>
			<h1>Welcome on the ${fn:toUpperCase ("Montevideo")} webpage</h1>
			<%--Formattage en utilisant la tag library fmt--%>
			<p>Do not miss our special offer: only <fmt:formatNumber value="${promo}" pattern="0.0"/> the trip!</p>
		</section>

		<section>
			<%--Appel de l'objet "now" pour donner la date --%>
			<p>This promotion is valid until
				${now.getDayOfMonth()}/${now.getMonthValue()}/${now.year+1} and if
				you fulfil all the conditions required*.</p>
		</section>

		<section>
			<%--Création d'un tableau avec une boucle en utilisant la TagLib core --%>
			<table class="table table-striped">
				<c:forEach items="${days}" var="day" varStatus="o">
					<tr>
						<td>jour ${o.count}</td>
						<td>${day}<c:if test="${o.count%2==0}">!</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</section>
		
		<section>
			<t:discount/>
		</section>
	</div>
	<jsp:include page="WEB-INF/jsp/footer.jsp"/>
</body>
</html>