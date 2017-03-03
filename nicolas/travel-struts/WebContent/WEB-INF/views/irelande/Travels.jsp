<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<title>irelande voyage</title>
</head>
<body>
	<h1>Irelande travels</h1>

	<p>
		actuellemrent en irelande nous avons ${travels.size()} voyage <br />
		<!-- br retour a la ligne  -->

		par exemple il y a : ${travels[0].location}
		<!-- lire des donnée   -->

	</p>
	<img
		src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSS7BKvLaWfCn23Xp6GnvXfctnDAFq8LcilUVNh-XFMYK-w3jOA-A">

	<p>
		<a href="index">retour a l'irelande</a>
	</p>

	<p>
		<a href="../">retour a l'accueil</a>
	</p>

	<s:debug />
	
	<!-- affiche des donnée pour npous aider a faire le code source si on veu consulté les jstl on marque s: et on fait controle +space  -->
	
	
	
	<table border="1">
	
	

	<!-- en el -->
	
	<s:property value="travels[1].location"/>  
   
    <!-- en struts -->
	<s:property value="#action.travels[2].days"/>
	
	<tr><th>location</th>><th>day</th><th>accomodation</th></tr>
	
		<!-- pour l'iterator il y a en statut  count, even first , modulus(2), index , odd et last il sont appeler par un diez -->
	<s:iterator value="travels" status="st">     
	
	<tr>
	<!--  <td><s:property value="#st.index"/></td>
	<td><s:property value="#st.modulus(3)"/></td>
	<td><s:property value="#st.odd"/></td>-->
	
	
	<td><s:property value="location"/></td>
	<td><s:property value="days"/></td>
	<td><s:property value="accomodation"/><s:if test='accomodation=="hotel"'>
	&#9733;&#9733;&#9733;
	</s:if><s:elseif test='accomodation=="camping"'>&#9733;&#9733;</s:elseif><s:else>&#9733;</s:else></td></tr>	
	
	</s:iterator>
	</table>


</body>
</html>