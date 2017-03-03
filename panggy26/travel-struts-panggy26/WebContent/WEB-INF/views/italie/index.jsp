<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Italie index</title>
</head>
<body>
	<h1>Bienvenue en Italie !</h1>
	<p>
		<%-- Lien index Europe --%>
		<%-- namespace et action prennent les valeurs du fichier struts.xml --%>
		<s:url namespace="/" action="index" var="url1" />
		<a href="${url1}">Retour à l'index Europe</a>
	</p>
	<h2>Tableau n°1</h2>
	<table>
		<tr>
			<th>Nom</th>
			<th>Lieu</th>
			<th>Nombre de visiteur(s)</th>
		</tr>
		<s:iterator value="listMonuments">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="visitor" /></td>
			</tr>
		</s:iterator>
	</table>
	<h2>Tableau n°2</h2>
	<table>
		<tr>
			<th>Monument</th>
			<th>Commentaires</th>
		</tr>
		<s:iterator value="listMonuments" var="m">
			<td><s:property value="name" /></td>
			<td>
				<s:iterator value="%{getComments(#m)}">
					<s:property value="text" />
					<br>
				</s:iterator>
			</td>
		</s:iterator>
		
	</table>
</body>
</html>