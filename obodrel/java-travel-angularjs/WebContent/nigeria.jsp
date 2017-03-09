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
<script src="./js/nigeria.controller.js" defer></script>
<title>Nigeria</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="NigeriaController as vm" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="nigeria"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Nigeria!</h3>
				<div class="row">
				<form name="vm.registerForm" class="col-xs-4 form-horizontal">
					<section class="form-group">
						<div class="row">
							<label class="col-xs-3" for="nameNigeria">Your Name : </label>
							<div class="col-xs-4">	
								<input required pattern="[A-Z][a-z]+" id="nameNigeria" type="text" class="form-control" name="name" data-ng-model="vm.name" data-ng-change="vm.isRegisterDisplayed()">
							</div>
						</div>
						<br>
						<div class="row">
							<label class="col-xs-3" for="emailNigeria">Your Email : </label>
							<div class="col-xs-4">	
								<input required id="emailNigeria" type="email" class="form-control" name="email" data-ng-model="vm.email" data-ng-change="vm.isRegisterDisplayed()">
							</div>
						</div>
						<br>
						<div class="row">
							<label class="col-xs-3" for="offerNigeria">Choose an offer : </label>
							<div class="col-xs-4">	
								<select required id="offerNigeria" class="form-control" name="offers" data-ng-model="vm.offer" data-ng-options="offer.monthName group by offer.seasonDesc for offer in vm.offers" data-ng-change="vm.isRegisterDisplayed()">
									<option value="">Choose One</option>
								</select>
							</div>
						</div>							
					</section>
					<br>
					<div class="row">
						<input id="registerNigeria" class="col-xs-4 btn btn-primary" type="button" value="Register" data-ng-disabled="vm.isNotValid()" data-ng-click="vm.showRegister()">
					</div>
				</form>
			</div>
			<br>
			<p data-ng-show="vm.displayRegister"> {{vm.registerMessage}}</p>
			<p class="danger" data-ng-show="vm.displayError"> {{vm.errorMessage}}</p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>