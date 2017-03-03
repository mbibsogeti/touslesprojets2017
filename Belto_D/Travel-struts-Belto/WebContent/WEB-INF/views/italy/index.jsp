<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimal-scale=0.5">
	
<title>Italy-index</title>
<link rel="stylesheet" href="/travel-struts-Belto/CSS/bootstrap.min.css">
</head>
<body>
<nav >
<ul class="nav nav-pills nav-tabs nav-justified">
<li class="active"><a href="../index"><spam class="glyphicon glyphicon-heart"></spam>Acceuil générale sur l'europe</a></li>
<li class="active" color="red"><a href="#"><spam class="glyphicon glyphicon-asterisk"></spam>Irlande</a></li>
</ul>
</nav>
<div class="container">
<h1>La liste des monuments Italie</h1>
<p>Laaaaaaaaaaaaaaaa</p>
<!--  <table>
<tr>
<th>Position</th>
<th>Nom de monument</th>
<th>La ville</th>
<th>Nombre de visiteurs</th>
</tr>
<s:iterator value="monuments" status="st">
<tr>
<td><s:property value="#st.index+1"/></td>
<td><s:property value="name"/></td>
<td><s:property value="location"/></td>
<td><s:property value="visitor"/>
</td>
</tr>
</s:iterator>
</table>--><!-- une première façon d'afficher sans lien -->
<table>
<tr>
<th>Identifiant</th><!-- affichage en dure -->
<th>Nom du monument</th><!-- affichage en dure -->
<th>La ville</th><!-- affichage en dure -->
<th>Nombre de visiteurs</th><!-- affichage en dure -->
</tr>
<s:iterator value="monuments"><!-- affichage Nom des monuments -->
<tr>
<td>
<s:property value="id"/><!-- affichage des identifiants -->
</td>
<!-- affichage des nom comme des lien, pour permettre d'avoir directement les infos -->
<td><s:url action="byid" var="u"><s:param name="id" value="id"/></s:url><a href="${u}"><s:property value="name"/></a></td>
<td><s:property value="location"/></td>
<td><s:property value="visitor"/>
</td>
</tr>
</s:iterator>
</table>
<br>
<table>
<tr>
<th>Identifiant</th>
<th>Nom de la ville</th>
<th>Monuments</th>
<th>Commentaires</th>
</tr>
<s:iterator value="monuments" var="m">
<tr>
<td>
<s:property value="id"/>
</td>
<td>
<s:property value="location"/>
</td>
<td>
<s:property value="name"/><!-- par ce qu'il a un seul monument, pas de boucle -->
</td>
<td>
<s:iterator value="%{getComments(#m)}"><!--un boucle pour lire tous les commentaires, car plusieurs par monument -->
<s:property value="text"/>
</s:iterator>
</td>
</tr>
</s:iterator>
</table>


<s:debug />
</div>
</body>
</html>