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
<script src="./js/route-config.js"></script>
<script src="./js/ghana.controller.js" defer></script>
<title>Ghana</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="GhanaController as vm" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="ghana"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Ghana!</h3>
				<div class="row">
				<form class="col-xs-4 form-horizontal">
					<section class="form-group">
						<div class="row">
							<label class="col-xs-3" for="nameGhana">Your Name : </label>
							<div class="col-xs-4">	
								<input id="nameGhana" type="text" class="form-control" name="name" data-ng-model="vm.name" data-ng-change="vm.isRegisterDisplayed()">
							</div>
						</div>	
						<br>
						<div class="row">
							<label class="col-xs-3" for="telGhana">Your Email : </label>
							<div class="col-xs-4">	
								<input id="telGhana" type="text" class="form-control" name="tel" data-ng-model="vm.tel" data-ng-change="vm.isRegisterDisplayed()">
							</div>
						</div>	
						<br>
						<div class="row">
							<label class="col-xs-3" for="messageGhana">Your Email : </label>
							<div class="col-xs-4">	
								<textarea rows="4" cols="2" id="messageGhana" class="form-control" name="message" data-ng-model="vm.message" data-ng-change="vm.isRegisterDisplayed()"></textarea>
							</div>
						</div>							
					</section>
					<br>
					<div class="row">
						<input id="requestInformationGhana" class="col-xs-4 btn btn-primary" type="button" value="Informations Request" data-ng-disabled="vm.isOneEmpty()" data-ng-click="vm.showInformations()">
					</div>
					<br>
					<div class="row">
						<input id="preRegisterGhana" class="col-xs-4 btn btn-primary" type="button" value="Pre Register" data-ng-disabled="vm.isOneEmpty()" data-ng-click="vm.showRegister()">
					</div>
				</form>
			</div>
			<br>
			<p data-ng-show="vm.displayInformations"> Your informations are : name = {{vm.name}} and tel = {{vm.tel}} </p>
			<p data-ng-show="vm.displayRegister"> {{vm.registerMessage}}</p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>