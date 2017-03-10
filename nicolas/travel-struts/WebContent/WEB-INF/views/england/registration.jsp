<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
<h1><s:text name="england.reg"/> </h1>

<s:form action="send" >
<p><s:textfield name="name" key="england.name"/></p>
<p><s:textfield name="email" label="email"/></p>
<p><s:checkbox name="luxury" label="luxe"/></p>
<p><s:submit key="england.btlg" /></p>
</s:form>


<s:url namespace="/england" action="index" var="u2"/>
	<s:url namespace="/england" action="registration" var="u_en"> <%--génere un url via struts --%>
	<s:param name="request_locale" value="'en'"/>
	</s:url>
	<s:url namespace="/england" action="registration" var="u_fr"> <%--génere un url via struts --%>
	<s:param name="request_locale" value="'fr'"/>
	</s:url>
	<a href="${u_en}">en</a>
	<a href="${u_fr}">fr</a>
	<a href="${u2}">retour a l'accueil</a>

</body>
</html>