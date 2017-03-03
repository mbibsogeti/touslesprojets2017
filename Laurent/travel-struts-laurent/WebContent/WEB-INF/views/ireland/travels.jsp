<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Infos</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/headerIrland.jsp"%>
<div class="container">
		<div class="row">
			<h1 class="text-center">Voyages</h1>	
		</div>
		<div class="row">
			<h3>Nous disposons de ${travels.size()} destinations pour l'Irlande</h3>
			<h4> ${travels[1].location} ou encore ${travels[4].location} !!</h4>
		</div>
		<div class="row">
			<table class="table table-hover table-condensed col-md-1">
				<thead>
					<tr style="background-color:#856D4D; color:white">
						<th> 
						<th class="text-center"> Ville
						<th class="text-center"> Hébergement
						<th class="text-center"> Séjour
				</thead>
				<tbody>
					<s:iterator value="travels" status="st">
						<tr>
							<td class="text-center"> <s:property value="#st.count"/>
							<td class="text-center" style="background-color:#FDF1B8; color:white"> <s:property value="location"/>
							<td class="text-center"> 
								<s:property value="accomodation"/> 
								<s:if test="accomodation == 'Hotel'">
									<span class="glyphicon glyphicon-star-empty"> </span>
									<span class="glyphicon glyphicon-star-empty"> </span>
									<span class="glyphicon glyphicon-star-empty"> </span>
								</s:if>
								<s:else>
									<span class="glyphicon glyphicon-star-empty"> </span>
									<span class="glyphicon glyphicon-star-empty"> </span>
								</s:else>
							<td class="text-center"> <s:property value="days"/>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>