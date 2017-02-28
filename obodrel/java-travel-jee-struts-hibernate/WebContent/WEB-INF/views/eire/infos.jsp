<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="">
<head>
<base href="${initParam.BASE_URL}">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Eire Informations</title>
</head>
<body id="body">
	<div class="container-fluid">
		<jsp:include page="../../jsp/header.jsp">
			<jsp:param name="pageName" value="homeEire"/>
		</jsp:include>
		<div class="col-xs-12">
			<h3>Eire Informations</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sollicitudin tempor euismod. 
			Nullam vulputate massa et mauris sollicitudin, ac gravida neque efficitur. Aenean pretium odio 
			in velit cursus, ac cursus nulla laoreet. Cras est mi, accumsan a laoreet nec, vehicula id risus. 
			Cras ut porta metus, at placerat purus. Aenean tincidunt, mi sit amet fringilla feugiat, sapien 
			est tincidunt risus, et posuere orci justo id magna. Donec erat sapien, imperdiet non faucibus 
			a, tristique at erat. Sed consectetur maximus nisi eget rhoncus. Quisque efficitur dolor et nisi 
			fringilla imperdiet. In ac nunc maximus magna molestie porta in vel mi. Aenean mollis, nisi nec 
			auctor lacinia, felis urna porttitor augue, nec interdum enim odio vitae nisl. Praesent a augue 
			pulvinar, tempus ligula nec, luctus sapien. Vestibulum eu lorem facilisis, mollis lectus 
			pellentesque, dapibus tellus.<br><br>Donec placerat at lacus ut volutpat. Pellentesque ultrices, 
			lectus sit amet consectetur convallis, leo ex ultrices ipsum, in facilisis ante massa in risus. 
			Donec ut congue risus, vitae facilisis nisi. Suspendisse eu sodales lectus. Donec elementum elit 
			sit amet lectus semper, eu finibus urna commodo. Nulla varius tellus ac commodo imperdiet. Integer 
			laoreet sem et est dignissim, vel sollicitudin nisi tristique. Duis in purus egestas, commodo urna 
			non, interdum risus. Curabitur mattis eros in rutrum fermentum. Donec sit amet tortor turpis. 
			Maecenas vel ornare ante. Aliquam erat volutpat. Phasellus pharetra neque ut eros dapibus, id 
			bibendum turpis feugiat.</p>
		</div>
		<jsp:include page="../../jsp/footer.jsp">
			<jsp:param name="year" value="2017"/>
		</jsp:include>
	</div>
</body>
</html>