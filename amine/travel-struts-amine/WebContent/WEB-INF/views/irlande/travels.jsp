<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Voyages</title>
</head>
<body>

	<h1>Nos Voyages</h1>

	<p>
		Actuellement il y a ${travels.size()} diponible pour l'Irlande! <br />
		Par exemple: ${travels[0].location} ou
		<s:property value="travels[1].location" />
		ou
		<s:property value="#action.travels[2].location" />
		<br /></p>
	<table border="1">
	<tr><th>Locations</th><th>Jours</th><th>Hébergement</th></tr>
		<s:iterator value="travels">
			<tr>
				<td><s:property value="location" /></td>
				<td><s:property value="days" /></td>
				<td><s:property value="accomodation" /></td>
			</tr>
		</s:iterator>
	</table>
	
	<s:debug />

	<p>
		<a href="index">Index Irlande</a>
	</p>
	<p>
		<a href="../">Retour à l'acceuil</a>
	</p>
</body>
</html>