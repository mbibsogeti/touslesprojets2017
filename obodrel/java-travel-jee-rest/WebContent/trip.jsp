<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script type="text/javascript" src="./js/trip.js" defer></script>
<title>Trips</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="./WEB-INF/jsp/header.jsp">
			<jsp:param name="pageName" value="trip"/>
		</jsp:include>
		<div class="col-xs-12">
			<h2>Show</h2>
		</div>
		<div class="col-xs-12">
			<div class="col-xs-4">
				<p>Show Best Trip!</p>
				<p><span class="btn btn-primary" id="bestTrip">Show best trip</span></p>
			</div>
			<div class="col-xs-4">
				<p>Show All Trips!</p>
				<p><span class="btn btn-primary" id="allTrips">Show all trips</span></p>
			</div>
			<div class="col-xs-4">
				<p>Show a specific trip!</p>
				<input type="number" id="nbTrip" min="0" max="9" value="0">
				<p><span class="btn btn-primary" id="specTrip">Show Specific trips</span></p>
			</div>
		</div>
		<div class="col-xs-12">
			<h2>Trips</h2>
		</div>
		<div class="col-xs-12">
			<p>This table is filled with a js client which call upon the implicit servlet declared in 
			TripHolder.java, the one we use with previous buttons, but without changing pages</p>
			<table id="exTable" class="table table stripped">
			</table>
		</div>
		<jsp:include page="./WEB-INF/jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>