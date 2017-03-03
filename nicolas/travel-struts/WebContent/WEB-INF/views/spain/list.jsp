<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
  <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<title>ListeSpain</title>
</head>
<body>
<h1>Listspain</h1>
<ul>

<li>alambra</li>
<li>Cordoba</li>
<li>seville</li>
<li>granada</li>
<li>toledo</li>
<li>paplune</li>
<li>truc</li>
<li>barcelona</li>
<li>madrid</li>
<li>irun</li>
<li>bidule</li>
<li>machine</li>

</ul>

<table border="2" >
		<tr>
			<th>Nom des monument</th>
			<th>location</th>
			<th>nb de visiteur</th>
		</tr>
		<s:iterator value="monuments">
		<tr>
			<td><s:url action="byid" var="u"><s:param name="id" value="id"/></s:url><a href="${u}"><s:property value="name"/></a></td>
			<td><s:property value="location"/></td>
			<td><s:property value="visitor"/></td>
		</tr>
</s:iterator>
	</table>


<a href="../">accueil</a>
</body>
</html>