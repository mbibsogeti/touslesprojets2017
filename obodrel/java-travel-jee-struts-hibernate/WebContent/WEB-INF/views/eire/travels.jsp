<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Eire Travels</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeEire"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Eire Travels : ${travels.size()}/<s:property value="#action.travels.size()"/> availables </h3>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>Location</th>
						<th>Days</th>
						<th>Accomodation</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="travels" status="st">
					<tr>
						<td><s:property value="location"/></td>
						<td><s:property value="days"/></td>
						<td><s:property value="accomodation"/></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
		<jsp:include page="../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>