<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/extend.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/function.js"></script>
<script src="./js/spain.js" defer></script>
<title>Spain List</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeSpain"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Spain list monuments</h3>
			<s:if test="monuments!=null">
				<p>Here is all monuments</p>
				<table id="tableMonuments" class="table table-stripped">
					<thead>
						<tr>
							<th>Monument Id</th>
							<th>Monument Name</th>
							<th>Monument Location</th>
							<th>Monument Max Visitors</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="monuments" status="st">
							<tr>
								<td id="monumentID<s:property value="ID"/>" ><div class="btn monumentLink" ><s:property value="ID"/></div></td>
								<td id="monumentName<s:property value="ID"/>"><div class="btn monumentLink" ><s:property value="name"/></div></td>
								<td id="monumentLocation<s:property value="ID"/>"><div class="btn monumentLink" ><s:property value="location"/></div></td>
								<td id="monumentMxVisitorse<s:property value="ID"/>"><div class="btn monumentLink" ><s:property value="maxVisitors"/></div></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:else>
				<p>Error</p>
			</s:else>
		</div>
		<jsp:include page="../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>