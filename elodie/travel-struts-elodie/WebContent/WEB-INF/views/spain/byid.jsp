<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width =device-width, initial-scale = 1, minimum-scale = 0.5">
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<style>.wwFormTable .label{color:black}</style>
<title>SPAIN</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/byidSpain.jpg" alt="Photo_spain" class="col-sm-12" />
		</header>
		<section class="row col-sm-12">
			<h1>${mo.name}</h1>
			<p>Où ? ${mo.location}</p>
		</section>
		<section class="row col-sm-12">
			<a href="proposal">Back to Spain</a>
		</section>
	</div>
</body>
</html>