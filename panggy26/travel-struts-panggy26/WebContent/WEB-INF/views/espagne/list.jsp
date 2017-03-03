<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste</title>
</head>
<body>
	<h1>Lista del monumentos</h1>
	<p>
		<%-- Lien vers le formulaire pour rentrer les monuments --%>
		<s:url namespace="/espagne" action="proposal" var="url" />
		<a href="${url}">Retour vers proposal</a>
	</p>
	<p>Los monumentos del patrimonio histórico de España son una serie de realizaciones arquitectónicas, de ingeniería o esculturales
		españolas que por su interés y valor gozan de una protección jurídica específica recogida en la Ley 16/1985, del 25 de junio de 1985, del
		Patrimonio Histórico Español para su preservación, enriquecimiento y exhibición. Los monumentos son una categoría dentro de la declaración
		más amplia de bienes de interés cultural.</p>
	<table>
		<tr>
			<th>Nom</th>
			<th>Lieu</th>
			<th>Nombre de visiteur(s)</th>
		</tr>
		<s:iterator value="listMonuments">
			<tr>
				<%-- Ma version. Bien comprendre ce que désigne identifiant et id (voir correspondances avec après) --%>
				<%-- <td><s:url namespace="/espagne" action="byId" var="url2" /> <a href="${url2}?identifiant=${id}"><s:property value="name" /></a></td> --%>
				<td>
					<s:url namespace="/espagne" action="byId" var="url2">
						<s:param name="identifiant" value="id" />
					</s:url> 
					<a href="${url2}"> 
						<s:property value="name" />
					</a>
				</td>
				<td><s:property value="location" /></td>
				<td><s:property value="visitor" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>