
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="travel" uri="http://travel.com"%>
<fmt:setLocale scope="page" value="en"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>montevideo</title>
</head>
<body>
	<h1>${fn:toUpperCase("montevideo")}</h1>
	<travel:discount/>
	<p>le prix du voyage est de <fmt:formatNumber value="${promo}" pattern ="0,000.00"/></p>
	<p>valide jusqu'a <fmt:formatDate value="${now2}" pattern ="yy-MM-dd"/> </p>
	<p>le programme est ${days[0]}</p>


<table border="1">
<c:forEach items="${days}" var="day" varStatus="s"> 

<tr><th>${s.count}</th><td>${day} <c:if test="${s.count%2==0}">!</c:if></td><td><c:out value="${day}"/></tr>

</c:forEach>

	</table>
	

</body>


</html>