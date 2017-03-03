<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spain: List</title>
</head>
<body>
	<ul>
		<li>L'Alhambra</li>
		<li>Basilique de la Sagrada Familia</li>
		<li>Mosquée de Cordoue</li>
		<li>Cathédrale de Saint-Jacques-de-Compostelle</li>
		<li>Cathédrale de Burgos</li>
		<li>Alcazar de Ségovie</li>
		<li>Cathédrale de Majorque</li>
		<li>Basilique Nuestra Señora del Pilar</li>
		<li>Théâtre romain de Mérida</li>
		<li>La Giralda</li>
	</ul>
	<h1>Extraire les Monuments de la base de données</h1>
	<table border="1">
		<tr>

			<th>Name</th>
			<th>Location</th>
			<th>Visitor</th>
		</tr>
		<s:iterator value="monuments">
			<tr>
				<td><s:url action="byid" var="u">
						<s:param name="id" value="id" />
					</s:url><a href="${u}"> <s:property value="name" /></a></td>
				<td><s:property value="location" /></td>
				<td><s:property value="visitor" /></td>
			</tr>
		</s:iterator>
	</table>
	<p>
		<a href="proposal">Précédent</a>
	</p>
</body>
</html>