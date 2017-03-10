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
<script src="./js/madagascar.module.js" defer></script>
<script src="./js/madagascar.controller.js" defer></script>
<script src="./js/madagascar.route-config.js" defer></script>
<script src="./js/madagascar.directive.year.js" defer></script>
<title>Madagascar</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-cloak data-ng-controller="MadagascarController as vm">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="madagascar"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Madagascar!</h3>
			<p>It year : <span data-year></span>™</p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>