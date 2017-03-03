<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Italie</title>
</head>
<body><h1>Italie</h1>
<table border="2" >
		<tr>
			<th>Nom des monument</th>
			<th>location</th>
			<th>nb de visiteur</th>
		</tr>
		<s:iterator value="monuments">
		<tr>
			<%-- mettre un url dans le tableau associé a name--%>
			<%-- <td><s:url action="byid" var="u"><s:param name="id" value="id"/></s:url><a href="${u}"><s:property value="name"/></a><--%>/td>
			<td><s:property value="name"/></td>
			<td><s:property value="location"/></td>
			<td><s:property value="visitor"/></td>
		</tr>
</s:iterator>
	</table>
<a href="../">retour a l'accueil</a>
</body>
</html>