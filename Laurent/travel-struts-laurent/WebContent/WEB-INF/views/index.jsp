<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center">EUROPE</h1>
		</div>
		<div class="row">
			<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
				    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
			  <div class="carousel-inner" role="listbox">
				    <div class="item active">
				      <img class="d-block img-fluid" src="/travel-struts-laurent/img/europe1.jpg" alt="First slide">
				    </div>
				    <div class="item">
				      <img class="d-block img-fluid" src="/travel-struts-laurent/img/ireland1.jpg" alt="Second slide">
				    </div>
				    <div class="item">
				      <img class="d-block img-fluid" src="/travel-struts-laurent/img/england1.jpg" alt="Third slide">
				    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
	</div>
</body>
</html>