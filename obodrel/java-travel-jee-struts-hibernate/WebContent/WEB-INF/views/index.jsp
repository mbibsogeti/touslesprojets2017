<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Obodrel's Travel Europe Division</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../jsp/header.jsp">
			<jsp:param name="pageName" value="home"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Obodrel's Travel</h3>
		</div>
		<jsp:include page="../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>