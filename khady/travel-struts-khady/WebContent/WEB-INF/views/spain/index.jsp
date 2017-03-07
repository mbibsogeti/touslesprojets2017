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

<s:form>
<fieldset>
<legend>Propososals Action</legend>
<p><s:textfield name="monument.name" label="Monument"/></p>
<p><s:textfield name="monument.location" label="Location"/></p>
<p><s:textfield type="number" name="monument.nbVisitors" label="Affluence"/></p>
<p><s:submit value="Envoyer" class="btn btn-default"/>
</fieldset>
</s:form>
</body>
</html>

