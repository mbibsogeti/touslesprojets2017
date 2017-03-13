<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/extends.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/angular.min.js"></script>
<script src="./js/angular-route.min.js"></script>
<script src="./js/angular-animate.min.js"></script>
<script src="./js/southafrica.module.js" defer></script>
<script src="./js/southafrica.controller.js" defer></script>
<script src="./js/southafrica.route-config.js" defer></script>
<title>South Africa</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="southafrica"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to South Africa!</h3>
		</div>
		<div data-ng-controller="SouthAfricaController as vm" data-ng-view class="viewSA col-xs-10 col-xs-offset-1">
		
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>