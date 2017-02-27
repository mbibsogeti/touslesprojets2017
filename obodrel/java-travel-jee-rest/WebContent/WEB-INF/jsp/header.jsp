<%@page contentType="text/html;charset=UTF-8" %>
		<h1 class="col-xs-8 col-xs-offset-4">Obodrel's Travel, REST!</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li class="${param.pageName=="home"?"active":""}"><a href="${param.pageName=="error"?"/jee-rest-travel-obodrel/":"./"}">Home</a></li>
				<li class="${param.pageName=="cruise"?"active":""}"><a href="${param.pageName=="error"?"/jee-rest-travel-obodrel/cruise":"./cruise"}">Cruise</a></li>
			</ul>
		</nav>