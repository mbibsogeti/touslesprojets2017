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
<h1> Liste de monuments</h1>

<table>
<tr>
<th>Monuments</th>
<th>Location</th>
<th>nbVisitors</th>
</tr>

<s:iterator value="monuments">
<tr>
<td><s:url action="byid" var="u">
<s:param name="id" value="id"/>
</s:url><a href="${u}"><s:property value="name"/></a></td>

<td><s:property value="location"/></td>
<td><s:property value="nbVisitors"/></td>
</tr>
</s:iterator>
</table>







</body>
</html>

