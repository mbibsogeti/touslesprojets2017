<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<title>Asuncion</title>
</head>
<body id="body">
	<div class="container-fluid"><jsp:include page="./WEB-INF/jsp/header.jsp">
		<jsp:param name="pageName" value="asuncion"/>
	</jsp:include>
		<div class="col-xs-12">
			<h3>Welcome to Asuncion</h3>
		</div><jsp:include page="./WEB-INF/jsp/footer.jsp">
		<jsp:param name="year" value="1923"/>
	</jsp:include>
	</div>
</body>
</html>