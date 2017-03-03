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
<title>Spain By Id</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeSpain"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Spain look by id</h3>
			<div class="col-xs-6">
				<p>Show a specific trip!</p>
				<s:if test="#parameters.id!=null">
					<input type="number" id="monumentId" min="1" max="12" value="<s:property value="#parameters.id"/>">
				</s:if>
				<s:else>
					<input type="number" id="monumentId" min="5" max="12" value="5">
				</s:else>
				<p><span class="btn btn-primary" id="specMonument">Show Specific Monument</span></p>
			</div>
			<s:if test="#parameters.id!=null && monument!=null">
				<div class="col-xs-6">
					<p>Result!</p>
					<p>Our displayed monument of id <s:property value="#parameters.id"/> is : ${monument.name} located in 
					${monument.location} with a capacity of ${monument.maxVisitors} visitors! </p>
				</div>
			</s:if>
		</div>
		<jsp:include page="../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>