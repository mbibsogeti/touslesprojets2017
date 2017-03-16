<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> SpAiN, HeRe We Go !!</h1>
<fieldset>
<legend>Propososals Action</legend>
<s:form>
<p><s:textfield name="monument.name" label="Monument"/></p>
<p><s:textfield name="monument.location" label="Location"/></p>
<p><s:textfield type="number" name="monument.nbVisitors" label="Affluence"/></p>
<p><s:submit value="Envoyer" class="btn btn-default"/>
</s:form>
</fieldset>
</body>
</html>

