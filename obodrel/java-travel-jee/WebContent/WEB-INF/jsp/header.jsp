<%@page contentType="text/html;charset=UTF-8" %>
		<h1 class="col-xs-12 col-xs-offset-3">Obodrel's Travel, South America division!</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li class="${param.pageName=="home"?"active":""}"><a href="./">Home</a></li>
				<li class="${param.pageName=="quito"?"active":""}"><a href="./equator/quito">Quito Travel</a></li>
				<li class="${param.pageName=="cartagena"?"active":""}"><a href="./colombia/cartagena">Cartagena Travel</a></li>
				<li class="${param.pageName=="maracaibo"?"active":""}"><a href="./venezuela/maracaibo">Maracaibo Travel</a></li>
				<li class="${param.pageName=="lima"?"active":""}"><a href="./peru/lima">Lima Travel</a></li>
				<li class="${param.pageName=="santiago"?"active":""}"><a href="./chile/santiago">Santiago Travel</a></li>
				<li class="${param.pageName=="lapaz"?"active":""}"><a href="./lapaz.jsp">Lapaz Travel</a></li>
				<li class="${param.pageName=="buenosaires"?"active":""}"><a href="./buenosaires.jsp">Buenos Aires Travel</a></li>
				<li class="${param.pageName=="asuncion"?"active":""}"><a href="./asuncion.jsp">Asuncion Travel</a></li>
				<li class="${param.pageName=="montevideo"?"active":""}"><a href="./montevideo">Montevideo Travel</a></li>
				<li class="${param.pageName=="georgetown"?"active":""}"><a href="./georgetown">George Town Travel</a></li>
			</ul>
		</nav>