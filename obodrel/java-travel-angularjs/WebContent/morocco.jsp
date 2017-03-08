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
<script src="./js/morocco.js"></script>
<title>Morocco</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="MoroccoController as controller" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="morocco"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to our Morocco's page, ask for an account here!</h3>
			<div class="row">
				<form class="col-xs-4 form-horizontal">
					<section class="form-group">
						<div class="row">
							<label class="col-xs-3" for="nameAsking">Your Name : </label>
							<div class="col-xs-4">	
								<input id="nameAsking" type="text" class="form-control" name="name" data-ng-model="controller.name">
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3" for="emailAsking">Your Email : </label>
							<div class="col-xs-4">	
								<input id="emailAsking" type="email" class="form-control" name="email" data-ng-model="controller.email">
							</div>
						</div>							
					</section>
					<p data-ng-show="controller.isNothingSet()">Please set your name and email!</p>
					<p data-ng-hide="!controller.areNameAndEmailSet()">Send a request for <span data-ng-bind="controller.name"></span> / {{controller.email}} :</p>
					<p data-ng-if="!controller.isNameSet() && !controller.isNothingSet()">Please set you name!</p>
					<p data-ng-if="!controller.isEmailSet() && !controller.isNothingSet()">Please set your email!</p>
					<input id="sendAsking" class="col-xs-4 btn btn-primary" type="button" value="Send">
				</form>
				<div class="col-xs-2">
					<img alt="morroco Head" data-ng-src="{{controller.morrocoHeadImage}}" width="90%" data-ng-if="controller.morrocoHeadImage!=''">
				</div>
			</div>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>