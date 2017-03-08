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
<script src="./js/tunisia.js"></script>
<title>Tunisia</title>
</head>
<body id="body">
	<div class="container-fluid" data-ng-app="application" data-ng-controller="TunisiaController as controller" data-ng-cloak>
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="tunisia"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Tunisia!</h3>
			<p data-ng-repeat="value in controller.valueArray">{{value}} traveller<span data-ng-hide="value==1">s</span></p>
			<table class="table">
				<thead>
					<tr>
						<th>Index</th>
						<th>Location</th>
						<th>Days</th>
					</tr>
				</thead>
				<tbody>
					<tr data-ng-repeat="value in controller.daysByLocation" data-ng-class-even="'bg-danger'" data-ng-class-odd="'bg-warning'">
						<td>{{$index+1}}</td>
						<td>{{value.location | uppercase}}</td>
						<td>{{value.days | number : 2}}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>