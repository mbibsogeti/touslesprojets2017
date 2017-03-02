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
<title>IRELAND</title>
</head>
<body>
	<div class="container">
		<header class="row">
			<img src="../img/irelandTravel.jpg" alt="Photo_ireland"
				class="col-sm-12" />
		</header>
		<section class="row col-sm-6">
			<h1>Our travels</h1>
			<table class="table table-striped table-bordered table-condensed">
				<tr>
					<th>Status</th>
					<th>Location</th>
					<th>Days</th>
					<th>Accomodation</th>
				</tr>
				<s:iterator value="travels" status="st">
					<tr>
						<td><s:property value="#st.index" />
						<td><s:property value="location" /></td>
						<td><s:property value="days" /></td>
						<s:if test='accomodation =="hotel"'>
							<td><s:property value="accomodation" />***</td>
						</s:if>
						<s:elseif test='accomodation =="Campsite" || accomodation =="B&B"'>
							<td><s:property value="accomodation" />**</td>
						</s:elseif>
						<s:else>
							<td><s:property value="accomodation" /></td>
						</s:else>
					</tr>
				</s:iterator>
			</table>
		</section>
		<section class="row col-sm-12">
			<a href="index">Back to Ireland</a>
		</section>
	</div>
	<s:debug />
</body>
</html>