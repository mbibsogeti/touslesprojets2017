<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<nav>
	<ul class="nav nav-pills nav-justified">
		<li><a href="equateur/quito">Quito</a></li>
		<li><a href="colombie/cartagena">Cartagena</a></li>
		<li><a href="venezuela/maracaibo">Maracaibo</a></li>
		<li><a href="chile/santiago">Santiago</a></li>
		<li><a href="lapaz.jsp">La Paz</a></li>
		<li><a href="buenosaires.jsp">Buenos Aires</a></li>
		<li><a href="asuncion.jsp">Asuncion</a></li>
		<li><a href="sanlorenzo.jsp">San Lorenzo</a></li>
		<li><a href="montevideo.jsp">Montevideo</a></li>
		<li><a href="guyana/georgetown">Georgetown</a></li>
	</ul>
</nav>
<div class="panel panel-heading panel-warning"
	style="background: lightblue">
	<section class="row">
		<section class="col-xs-12">
			<h3 style="text-align: center">Trips in South America in
				${param.year!=null?param.year:2017}</h3>
		</section>
	</section>
</div>