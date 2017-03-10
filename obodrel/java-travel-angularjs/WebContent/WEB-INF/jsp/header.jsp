<%@page contentType="text/html;charset=UTF-8" %>
		<h1 class="col-xs-8 col-xs-offset-4">Obodrel's Travel, Europe Division</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li class='${param.pageName=="home"?"active":""}'><a href="./">Home</a></li>
				<li class='${param.pageName=="morocco"?"active":""}'><a href="./morocco/">Morocco</a></li>
				<li class='${param.pageName=="tunisia"?"active":""}'><a href="./tunisia/">Tunisia</a></li>
				<li class='${param.pageName=="egypte"?"active":""}'><a href="./egypte/">Egypte</a></li>
				<li class='${param.pageName=="senegal"?"active":""}'><a href="./senegal/">Senegal</a></li>
				<li class='${param.pageName=="ghana"?"active":""}'><a href="./ghana/">Ghana</a></li>
				<li class='${param.pageName=="nigeria"?"active":""}'><a href="./nigeria/">Nigeria</a></li>
			</ul>
		</nav>