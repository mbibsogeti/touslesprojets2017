<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="tvl" uri="http://travel.com" %>
<fmt:setLocale scope="page" value="en"/>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<title>Montevideo</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="montevideo"/>
		</jsp:include>
		<div class="col-xs-6">
			<h3>Welcome to ${fn:toUpperCase("Montevideo")} </h3>
			<p>A travel to Montevideo will only cost you : <fmt:formatNumber value="${planePrice}" pattern="0.00"/>€
			 since there is <fmt:formatNumber value="${promotionPercent}" pattern="0"/>% <tvl:discount/></p>
			 <p>(Offer available until ${currDate.dayOfMonth}/<fmt:formatNumber value="${currDate.monthValue}" pattern="00"/>/${currDate.year+1})</p>
		</div>
		<div class="col-xs-6">
			<h3>Montevideo Schedule Activities</h3>
			<table class="table table-stripped"> 
				<thead>
					<tr>
						<th>Days</th>
						<th>Activities</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${scheduleOptions}" varStatus="iterator">
					<tr>
						<th>${iterator.count}</th>
						<td>${iterator.current}<c:if test="${iterator.count%2==0}">!</c:if></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>