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
<title>Spain Proposal</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeSpain"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Spain proposal</h3>
			<s:form action="register" >
				<section class="form-group">
					<s:textfield class="form-control" name="monument.name" label="Name" />
					<s:textfield class="form-control" name="monument.location" label="Location" />
					<s:textfield class="form-control" name="monument.maxVisitors" label="Max Visitors" type="number" />
				</section>
				<s:submit class="btn btn-default" value="Submit"/>
			</s:form>
		</div>
		<jsp:include page="../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>