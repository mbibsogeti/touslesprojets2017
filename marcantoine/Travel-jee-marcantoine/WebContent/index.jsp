<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel='stylesheet' href='css/bootstrap.min.css'>
</head>
<body>
	
	<jsp:include page="WEB-INF/jsp/header.jsp">
		<jsp:param name="year" value="2017" />
	</jsp:include>
	
	<div class='container'>
		<h1>Welcome!</h1>
		<h2>Here is our offer</h2>

		<a href="equateur/quito">Quito</a><br> 
		<a href="colombie/cartagena">Cartagena</a><br> 
		<a href="venezuela/maracaibo">Maracaibo</a><br> 
		<a href="peru/lima">Lima</a><br>
		<a href="chile/santiago">Santiago</a><br>
		<a href="buenosaires.jsp">Buenos Aires</a><br>
		<a href="asuncion.jsp">Asuncion</a><br>
		<a href="sanlorenzo.jsp">San Lorenzo</a><br>
		<a href="uruguay/montevideo.jsp">Montevideo</a>
		<a href="guyana/georgetown">Georgetown</a>
	</div>
</body>
</html>