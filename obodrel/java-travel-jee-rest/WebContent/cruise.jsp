<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script type="text/javascript" src="./js/cruise.js" defer></script>
<title>Cruise</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="cruise"/>
		</jsp:include>
		<div class="col-xs-12">
			<h2>Donwload</h2>
		</div>
		<div class="col-xs-12">
			<p>Download a file which represent all cruise available!</p>
			<p><span class="btn btn-primary" id="dlNow">Download Now</span></p>
			<p>Download a specific cruise!</p>
			<input type="number" id="nbCruise" min="1" max="4" value="1">
			<p><span class="btn btn-primary" id="dlSpec">Download Specific</span></p>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>