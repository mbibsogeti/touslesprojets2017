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
<script src="./js/egypte.js"></script>
<title>Egypte</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="EgypteController as controller" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="egypte"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Egypte! Your Trip :</h3>
			<form class="col-xs-4 form-horizontal">
				<section class="form-group">
					<div class="row">
						<label class="col-xs-3" for="daysTrip">Days </label>
						<div class="col-xs-4">	
							<input id="daysTrip" type="number" min="3" max="25" class="form-control" name="days" data-ng-model="controller.days">
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3" for="visitTrip">Visits </label>
						<div class="col-xs-4">	
							<input id="visitTrip" type="checkbox" class="form-control" name="visit" data-ng-model="controller.visits"  data-ng-mouseover="controller.trick()">
						</div>
					</div>							
				</section>
				<input id="sendTrip" class="col-xs-4 btn btn-primary" type="button" value="Send" data-ng-click="controller.show()">
			</form>
			<p data-ng-show="controller.display"> OK </p>
		</div>
		<div data-ng-include="controller.footer"></div>
	</div>
</body>
</html>