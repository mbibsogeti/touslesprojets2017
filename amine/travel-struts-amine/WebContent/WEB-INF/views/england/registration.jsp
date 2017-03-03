<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="england.registration" /></title>
</head>
<body>
	<h1>
		<s:text name="england.registration" />
	</h1>
	<%-- <form>
		<label><s:text name="england.name" />: <input type="text"
			name="name"></label><br/> <label>Email: <input type="email"
			name="email"></label><br/> <label><s:text name="england.departure" />:
			<input type="date" name="date"></label><br/>
			<label><input type="submit" name="submit"></label>
	</form>--%>
	<s:form action="send">
		<%-- <s:textfield name="name" label="nom" />--%>
		<s:textfield name="name" key="england.name" />
		<s:textfield name="email" label="Email" />
		<s:checkbox name="luxury" label="luxe" />
		<s:submit value="Envoi" />
	</s:form>
	<p>
		<s:url namespace="/england" action="index" var="u" />
		<a href="${u}">Acceuil</a>
	</p>

</body>
</html>