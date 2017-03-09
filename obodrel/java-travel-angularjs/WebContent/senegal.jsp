<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/angular.min.js"></script>
<script src="./js/senegal.js" defer></script>
<title>Senegal</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="SenegalController as controller" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="senegal"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Senegal!</h3>
			<p>Our trip will cost {{controller.computePrice() | toCurrency : "€" : 1 }} ( {{controller.computePrice() | toCurrency : "cfa" : 0.0015}} )</p>
			{{controller.log()}}
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>