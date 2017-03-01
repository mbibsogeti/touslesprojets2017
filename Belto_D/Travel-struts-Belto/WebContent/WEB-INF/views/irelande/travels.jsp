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
	
<title>Irelande-travels</title>
<link rel="stylesheet" href="/travel-struts-Belto/CSS/bootstrap.min.css">
</head>
<body>
<nav >
<ul class="nav nav-pills nav-tabs nav-justified">
<li class="active"><a href="../index"><spam class="glyphicon glyphicon-heart"></spam>Acceuil générale sur l'europe</a></li>
<li class= "active" ><a href="infos">Lien vers la page informations</a></li>
<li class= "active" ><a href="index">Retour accueil géneral sur l'Irlande</a></li>
<li class="active" color="red"><a href="#"><spam class="glyphicon glyphicon-asterisk"></spam>Irlande</a></li>
</ul>
</nav>
<div class="container">
<h1> Tous les voyages vers l'Irelande</h1>
<h2>Avion, Jet-privé, Paquebots, Yatch, Bateau</h2>
<p> Actuellement pour l'irelande, Il y a ${travels.size()} <%-- afficher le nombre de destination --%>
destinations différentes!
<br>
Par exemple, ${travels[1].Location} <%-- <!-- Pas de besoin de mettre get
on, a deja déclarer la fonction getTravels, il le cherche tout seul --%>
</p>
 <%-- ou on fait comme ça <s:property value= "travel[1].Location/> marche que si la donnée est dans la class d'action  ou
 		ou  <s:property value="#action.travels[0].Location/>" plus generale on le fait plus souvent   ou --%>
<table><%--Afficher les donnnés dans une table --%>
<tr><%--première ligne en dure, les en-tête de table --%>
<th>Number</th>
<th>Location</th>
<th>Days</th>
<th>Accomodations</th>
</tr>
<s:iterator value="travels" status="st"><%--dire qu'on va lire dans la boucle --%>
<tr><%--on les affiche ligne par ligne --%>
<td><s:property value="#st.index+1"/></td>
<td><s:property value="Location"/></td>
<td><s:property value="Days"/></td>
<td><s:property value="Accomodation"/>
<s:if test='Accomodation=="hotel"'><%--afficher 3 étoiles si c'est un hotel --%>
&#9733;&#9733;&#9733;
</s:if>
<s:else>
&#9733;&#9733;
</s:else>
</td>
</tr>
</s:iterator>
</table>

<s:debug />
</div>
</body>
</html>