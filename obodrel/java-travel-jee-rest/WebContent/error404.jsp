<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/jee-rest-travel-obodrel/css/bootstrap.min.css">
<title>404 not found</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="error"/>
		</jsp:include>
		<div class="col-xs-12">
			<h2>Error 404</h2>
		</div>
		<div class="col-xs-12">
			<p>The page you requested doesn't exist (yet), or is not available for now!</p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>