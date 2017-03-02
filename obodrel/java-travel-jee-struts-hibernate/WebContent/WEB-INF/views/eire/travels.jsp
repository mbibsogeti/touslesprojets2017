<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
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
						<th>Travel Number</th>
						<th>Location</th>
						<th>Days</th>
						<th>Accomodation</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="travels" status="st">
					<tr>
						<td><s:property value="#st.count"/></td>
						<td><s:property value="location"/></td>
						<td><s:property value="days"/></td>
						<s:if test="location==\"Cork\"">
							<td><s:property value="accomodation"/>***</td>
						</s:if>
						<s:elseif test="location==\"Dublin\"">
							<td><s:property value="accomodation"/>**</td>
						</s:elseif>
						<s:else>
							<td><s:property value="accomodation"/></td>
						</s:else>
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