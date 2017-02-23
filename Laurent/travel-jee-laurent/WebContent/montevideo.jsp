<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="travel" uri="http://travel.com" %>

<fmt:setLocale scope="page" value="fr"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monte-Video</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<aside class="" style="position:absolute; right:10px; top:110px;">
		<travel:discount/>
	</aside>
	<div class="container">
		<div class="row">
			<div class="panel panel-default col-xs-12">
				<header class="panel-header">
					<h1 class="text-center">${fn:toUpperCase("Montevideo")}</h1>
				</header>
			</div>
		</div>
		<div class="row">
			<section class="col-xs-6">
				<h3 class="text-center">Grosse promotion sur ce voyage !!!</h3>
				
				<blockquote class="text-justify">
					Montevidéo étant une destination far, dans notre catalogue, on a
					pensé qu'une promotion à la hauteur de ses paysages s'imposait,
					ainsi nous appliquons -15% sur tout le voyage. Prenons l'exemple
					d'un voyage à <fmt:formatNumber value="${1399}" pattern="0,000.00"/>€, cela vous reviendrait à <fmt:formatNumber value="${1399-promo}" pattern="0,000.00"/>€
					seulement !!!!<br> Profitez vite de cette offre !!
				</blockquote>
				<h5>(Valide jusqu'à
					${now.dayOfMonth}/${now.monthValue}/${now.plusYears(1).year})</h5>
			</section>
			<section class="col-xs-6">
				<h3 class="text-center">Programme de la semaine de séjour :</h3>
				<section class='table-responsive'>
				<table class='table table-striped table-bordered table-condensed'>
					<tbody>
						<tr>
							<th>Jours</th>
							<th>Activités</th>
						</tr>
						<c:forEach items="${days}" varStatus="s">
							<tr>
								<th> ${s.count} </th>
								<td>
									${s.current}
									<c:if test="${(s.count==1)||(s.count==8)}">!!</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</section>
			</section>
		</div>
	</div>
	<div class="panel panel-default">
		<footer class="panel-footer">
			<jsp:include page="/WEB-INF/jsp/footer.jsp">
				<jsp:param value="1999" name="year"/>
			</jsp:include>
		</footer>
	</div>
</body>
</html>