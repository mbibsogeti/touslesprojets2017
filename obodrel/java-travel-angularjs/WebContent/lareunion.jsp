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
<script src="./js/angular-route.min.js"></script>
<script src="./js/angular-animate.min.js"></script>
<script src="./js/lareunion.module.js" defer></script>
<script src="./js/lareunion.controller.js" defer></script>
<script src="./js/lareunion.route-config.js" defer></script>
<title>La Reunion</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-cloak data-ng-controller="LaReunionController as vm">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="lareunion"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to La Reunion!</h3>
			<div class="row">
				<form name="vm.myForm" class="col-xs-4 form-horizontal">
					<section class="form-group">
						<div class="row">
							<label class="col-xs-3" for="name">Your Name : </label>
							<div class="col-xs-4">	
								<input required id="name" type="text" class="form-control" name="name" data-ng-model="vm.name" data-ng-change="vm.isInformationsDisplayed()">
							</div>
						</div>
						<br>
						<div class="row">
							<label class="col-xs-3" for="email">Your Email : </label>
							<div class="col-xs-4">	
								<input required id="email" type="email" class="form-control" name="email" data-ng-model="vm.email" data-ng-change="vm.isInformationsDisplayed()">
							</div>
						</div>			
					</section>
					<br>
					<div class="row">
						<input id="register" class="col-xs-4 btn btn-primary" type="button" value="Send" data-ng-disabled="vm.isNotValid()" data-ng-click="vm.showInformations()">
					</div>
				</form>
			</div>
			<br>
			<p data-ng-show="vm.displayInformations"> {{vm.informationsMessage}}</p>
			<p class="danger" data-ng-show="vm.displayError"> {{vm.errorMessage}}</p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>