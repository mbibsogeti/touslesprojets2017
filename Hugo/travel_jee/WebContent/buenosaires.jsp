<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel='stylesheet' href='css/bonito.css'>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content='IE=edge'>
<meta name='viewport'
	content='width=device-width, initial-scale=1 minimum-scale=0.5'>
<title>El viaje de tus sueños: Buenos Aires</title>
</head>
<body>

	<nav>
		<ul class='nav nav-pills nav-justified'>
			<li><a href='index.html'><span
					class='glyphicon glyphicon-home'></span> Inicio</a>
			<li><a href='ecuador/quito'><span
					class='glyphicon glyphicon-headphones'></span> Quito</a>
			<li><a href='colombia/cartagena'><span
					class='glyphicon glyphicon-king'></span> Cartagena</a>
			<li><a href='venezuela/maracaibo'><span
					class='glyphicon glyphicon-apple'></span> Maracaibo</a>
			<li><a href='peru/lima'><span
					class='glyphicon glyphicon-camera'></span> Lima</a>
			<li><a href='chile/santiago'><span
					class='glyphicon glyphicon-scissors'></span> Santiago</a>
			<li><a href='lapaz.jsp'><span
					class='glyphicon glyphicon-cloud'></span> La Paz</a>
			<li class='active'><a href='#'><span
					class='glyphicon glyphicon-education'></span> Buenos Aires</a>
			<li><a href='asuncion.jsp'><span
					class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>
			<li><a href='uruguay/montevideo'><span
					class='glyphicon glyphicon-flash'></span> Montevideo</a>
		</ul>
	</nav>

	<div class='container'>
		<div>
			<h1>Buenos Aires - Argentina</h1>
		</div>

		<div class='row'>
			<section class='col-sm-6'>
				<h2>Buenos Aires</h2>
				<p></p>
			</section>

			<section class='col-sm-6'>
				<h2>Inscripcion</h2>
				<form action='buenosaires.jsp'>

					<section class='form-group'>
						<%! private final static String[]mes=new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}; %>
						<label for='mes'> Salida: </label> <select name='mes' id='salida'
							class='form-control'>
							<option selected></option>
							<% for(int i=1; i<=12; i++){
							request.setAttribute("i",i); %>
							<option value="<%= i %>" ${param.mes==i?"selected":""}><%= mes[i-1] %></option>
							<% } %>
						</select>
					</section>

					<section class='form-group'>
						<label for='nombre'> Nombre: </label> <input value='${param.nombre}' type='text'
							name='nombre' id='nombre' class='form-control'>
					</section>

					<section class='form-group'>
						<label for='email'> E-mail: </label> <input value='${param.email}' type='text'
							name='email' id='email' class='form-control'>
					</section>

					<section class='form-group'>
						<input type='submit' value='Enviar' class='btn btn-warning'>
					</section>

				</form>

				<% if(request.getParameter("mes")!=null){ %>
				<p><%= request.getParameter("nombre") %>, tu pedido para viajar
					en el mes de <%=  mes[Integer.parseInt(request.getParameter("mes"))-1] %> ha sido enviado.</p>
					<% } %>

			</section>

		</div>
	</div>

</body>
</html>