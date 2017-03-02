<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Ireland: travel</title>
<link rel="stylesheet"
	href="/travel-struts-marcantoine/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="container">
		<h1>Travel with us!!</h1>
		<a href="../index">Back to the Welcome page</a><br> <a
			href="index">Back to Welcome in Ireland</a><br> <a href="info">More
			information</a>
		<!--  En appelant "travels", le compilateur va chercher automatiquement dans la classe action.
			Il y cherchera une méthode appelée methodeTravels (ce mécanisme est conventionnel). il considère donc que "travels." équivaut à "getTravels."-->
		<p>We currently have ${travels.size()} destinations available. For
			example: ${travels[4].location}!</p>
		<table class="table table-hindered table-striped"
			style="text-align: center">
			<tr style="background: lightblue; color: white">
				<th style="text-align: center">Location</th>
				<th style="text-align: center">Days</th>
				<th style="text-align: center">Accomodation</th>
				<th style="text-align: center">status from the iterator</th>
			</tr>
			<!-- attribut additionnel : status. Il produit une variable dans le stack que l'on pourra lire ensuite.
			on y trouve plein de choses : index, count, even, odd, first, last, modulus -->
			<s:iterator value="travels" status="st">
				<tr>
					<td><s:property value="location" /></td>
					<td><s:property value="days" /><s:if test="days>=10">
							<span class="glyphicon glyphicon-asterisk"></span>
						</s:if></td>
					<td><s:property value="accomodation" /> <!-- Attention, il faut utiliser des apostrophes ou des guillements pour la chaîne de caractères. On peut aussi faire des étoiles avec &#9733 -->
						<s:if test="accomodation=='hotel'">
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
						</s:if> <s:elseif test="accomodation=='boat'"> &#9733; &#9733;
						</s:elseif> <s:elseif test="accomodation=='B&B'"> &#9733;
						</s:elseif></td>
					<td><s:property value="#st.index" /></td>
				</tr>
				<br>
			</s:iterator>
		</table>
		<p><span class="glyphicon glyphicon-asterisk"> Repatriation in fatal cases offered for these trips!!</span></p>
		<!-- Informations de debug affichées sur page web. donne des infos sur tout ce qui a un # (ex : #st.index) -->
		<s:debug />
	</div>
</body>
</html>
