<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="england.title" /></title>
</head>
<body>
	<h1>
		<s:text name="england.title" />
	</h1>
	<ul>
		<li>Départ: <s:date name="departure" format="dd/MM/yyyy" /> <%-- <s:date name="departure" nice="true" /></li>--%>
		<li>
			<!--Prix: <s:property value="price" /> €--> <s:text
				name="england.price">
				<s:param>${price}</s:param>
			</s:text>
		</li>

	</ul>
	<a href="?request_locale=en">EN</a>
	<a href="?request_locale=fr">FR</a>
	<p>
		<%--<s:url namespace="/england" action="index" var=u_en>
		<s:param name="request_locale" value="en"/></s:url>
		<a href="${u_en}">EN Acceuil</a>--%>
		
		<%-- <a href="../">Retour à l'acceuil</a>--%>
		<s:url namespace="/" action="index" var="u1"/>
		<a href="${u1}">Acceuil</a>
	</p>
</body>
</html>