<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GeorgeTown de Guyana</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="panel panel-default col-xs-12">
				<header class="panel-header">
					<h1 class="text-center">GeorgeTown</h1>
				</header>
			</div>
		</div>
		<div class="row">
			<h3>${erreur} </h3>
		</div>
	</div>
	<div class="panel panel-default">
		<footer class="panel-footer">
			<jsp:include page="/WEB-INF/jsp/footer.jsp">
				<jsp:param value="1999" name="year"/>
			</jsp:include>
		</footer>
	</div>
</body>
</html>