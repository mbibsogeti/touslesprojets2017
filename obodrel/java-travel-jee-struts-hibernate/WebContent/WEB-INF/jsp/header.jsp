<%@page contentType="text/html;charset=UTF-8" %>
		<h1 class="col-xs-8 col-xs-offset-4">Obodrel's Travel, Europe Division</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li class="${param.pageName=="home"?"active":""}"><a href="./">Home</a></li>
				<li class="dropdown ${param.pageName=="homeEire"?"active":""}">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Eire<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="./eire/">Home</a></li>
						<li><a href="./eire/infos">Infos</a></li>
						<li><a href="./eire/travels">Travels</a></li>
					</ul>
				</li>
			</ul>
		</nav>