<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Irelande-travels</title>
</head>
<body>
<h1> Tous les voyages vers l'Irelande</h1>
<h2>Avion, Jet-privé, Paquebots, Yatch, Bateau</h2>
<br>
<a href= "../index" >Retour à l'accueil générale sur l'europe </a>
<br>
<a href= "index" >Retour à l'acceuil sur l'Irelande </a>
<br>
<a href= "infos" >Lien vers la page Infos</a>
<p> Actuellement pour l'irelande, Il y a ${travels.size()} <%-- afficher le nombre de destination --%>
destinations différentes!
<br>
Par exemple, ${travels[1].Location} <%-- <!-- Pas de besoin de mettre get
on, a deja déclarer la fonction getTravels, il le cherche tout seul --%>
</p>
 <%-- ou on fait comme ça <s:property value= "travel[1].Location/> marche que si la donnée est dans la class d'action  ou
 		ou  <s:property value="#action.travels[0].Location/>" plus generale on le fait plus souvent   ou --%>
<s:iterator value="travels">
<s:property value="Location"/>
</s:iterator>
<s:debug />
</body>
</html>