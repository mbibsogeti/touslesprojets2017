<%@page contentType="text/html;charset=UTF-8" %>
		<nav class="col-xs-6 col-xs-offset-6">
			<ul class="nav nav-pills nav-justified">
				<li class="${param.pageName=="homeEire"?"active":""}"><a href="./eire/">Home Eire</a></li>
				<li class="${param.pageName=="infoEire"?"active":""}"><a href="./eire/infos">Infos Eire</a></li>
				<li class="${param.pageName=="travelEire"?"active":""}"><a href="./eire/travels">Travels Eire</a></li>
			</ul>
		</nav>