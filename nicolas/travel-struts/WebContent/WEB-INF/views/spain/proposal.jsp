<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
  <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<title>spain</title>
</head>
<body>
<h1>spain proposal</h1>
<s:form>
<s:textfield name="monument.name" label="monument"/>
<s:textfield name="monument.location" label="location"/>
<s:textfield type="number" name="monument.visitor" label="nb de visiteur"/>
<s:submit/>

</s:form>
<a href="../">accueil</a>
</body>
</html>