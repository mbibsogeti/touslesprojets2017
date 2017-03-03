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
<title>Italy Index</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeItaly"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Italy Index</h3>
			<s:if test="monuments!=null">
				<p>Here is all monuments</p>
				<table id="tableMonuments" class="table table-stripped">
					<thead>
						<tr>
							<th>Monument Name</th>
							<th>Monument Location</th>
							<th>Monument Max Visitors</th>
							<th>Show Comments</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="monuments" var="currMonument">
							<tr>
								<td><s:property value="#currMonument.name"/></td>
								<td><s:property value="#currMonument.location"/></td>
								<td><s:property value="#currMonument.maxVisitors"/></td>
								<td class="dropdown">
									<div data-toggle="dropdown" class="btn btn-primary dropdown-toggle">Show  <span class="caret"></span></div>
										<ul class="dropdown-menu">
											<s:iterator value="%{getComments(#currMonument)}" var="currComment" status="st">
												<s:if test="#st.count>1">
											    	<li class="divider"></li>
												</s:if>
												<li>Author : <s:property value="#currComment.author"/></li>
												<li>Text : <s:property value="#currComment.text"/></li>
											</s:iterator>
										</ul>
								</td>
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