<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Desintations irlandaises</title>
</head>
<body>
	<h1>Destinations irlandaises</h1>
	<p>
		<a href="./index">Index irlandais</a>
	</p>
	<p>
		<%-- ${travels.size()} : EL fouille dans la classe TravelsAction grâce à la ligne <action name="travels" class="jk.travel.irlande.TravelsAction">
		 de struts.xml. Ensuite, il cherche un fonction en utilisant la convention de nommage suivante : mettre la 1ère lettre en majuscule et rajouter get devant
		<s:property value="travels[1].location"/> ne peut afficher que les objets de la classe d'action
		<s:property value="#action.travels[2].location"/> pour afficher n'importe quel élément montré dans <s:debug /> --%>
		Actuellement, notre agence dispose de ${travels.size()} destinations en Irlande. Nous possédons en ce moment une offre promotionnelle
		exceptionnelle pour ${travels[0].location} ou pour
		<s:property value="travels[1].location" />
		, ou encore
		<s:property value="#action.travels[2].location" />
	</p>
	<p>Voici la liste exhaustive de nos destinations :</p>
	<table>
		<tr>
			<th>Index</th>
			<th>Location</th>
			<th>Days</th>
			<th>Accomodation</th>
		</tr>
		<%-- status="st" : idem à JSPL, contient les index, count, first, last, odd, even,  modulus... --%>
		<s:iterator value="travels" status="st">
			<tr>
				<%-- # : pour accéder aux éléments de la pile. Ici on a l'index de l'itérateur --%>
				<td><s:property value="#st.index" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="days" /></td>
				<td><s:property value="accomodation" />
					<%-- Si le logement est un hôtel, on ajoute 3 étoiles (syntaxe des entités en HTML) --%>
					<s:if test='accomodation=="hotel"'>
						&#9733;&#9733;&#9733;
					</s:if>
					<%-- Sinon, seulement 2 étoiles --%>
					<s:else>
						&#9733;&#9733;
					</s:else></td>
			</tr>
		</s:iterator>
	</table>
	<p>
		<%-- Balise issue de struts pour aider au debug. Voir le résultat dans le navigateur. On peut y voir notamment la liste des données accessibles --%>
		<s:debug />
	</p>
</body>
</html>