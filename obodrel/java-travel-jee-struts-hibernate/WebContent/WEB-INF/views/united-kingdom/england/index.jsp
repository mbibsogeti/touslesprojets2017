<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/function.js"></script>
<script src="./js/england.js" defer></script>
<title><s:text name="england.title"/></title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeEngland"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to <s:text name="england.title"/></h3>
			<p>Departure : <s:date name="travelDate" format="dd/MM/yyyy"/>, <s:date name="travelDate" nice="true"/> </p>
			<p>	
				<s:text name="england.price">
					<s:param>${travelPrice}</s:param>
				</s:text>€
			</p>
		</div>
		<div class="col-xs-12">
<%-- 			<s:url var="localeEN" namespace="united-kingdom/england" action="locale" > --%>
<%-- 			   <s:param name="request_locale" >en</s:param> --%>
<%-- 			</s:url> --%>
<%-- 			<s:url var="localeFR" namespace="united-kingdom/england" action="locale" > --%>
<%-- 			   <s:param name="request_locale" >fr</s:param> --%>
<%-- 			</s:url> --%>
<%-- 			<s:a href="%{localeEN}" >English</s:a> --%>
<%-- 			<s:a href="%{localeFR}" >France</s:a> --%>
			<div class="btn btn-primary" id="toEN">English</div>
			<div class="btn btn-primary" id="toFR">French</div>
		</div>
		<jsp:include page="../../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>