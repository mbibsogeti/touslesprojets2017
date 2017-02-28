<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Index</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<h1>Europe</h1>
		
		<section class="row"> <section class="col-xs-8">
		<form>
			<p class="form-group">
				<label>Name: <input type="text" name="name"
					placeholder="John Doe" class="form-control" value="${param.name}"></label>
			</p>
			<p class="form-group">
				<label>email: <input type="email" name="email"
					placeholder="John@Doe.com" class="form-control"
					value="${param.email}"></label>
			</p>
			<p class="form-group">
				<input type="submit" value="send" class="btn btn-danger">
		</form>
		</section> </section>
	</div>
</body>
</html>