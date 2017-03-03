<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/extend.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js" defer></script>
<script src="./js/bootstrap.min.js" defer></script>
<title>Register</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeEngland"/>
		</jsp:include>
		<div class="col-xs-12">
			<s:if test="name==null || email==null">
				<h3>Register</h3>
				<s:form action="register" >
					<section class="form-group">
						<s:textfield class="form-control" name="name" label="Name" />
						<s:textfield class="form-control" name="email" label="Email" />
						<s:checkbox name="luxary" label="Luxary" />
					</section>
					<s:submit class="btn btn-default" value="Submit"/>
				</s:form>
			</s:if>
			<s:else>
				<h3>Registered</h3>
				<p>${name} is registered to travel with ${email} as email, you will <s:if test="!luxary">not</s:if> use the luxary room!</p>
			</s:else>
		</div>
		<jsp:include page="../../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>
<s:debug/>