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
	<h1>Liste de monuments Italie</h1>

	<table>
		<tr>
			<th>Monuments</th>
			<th>Location</th>
			<th>NbVisitors</th>
			<th>Comments</th>
		</tr>	
			<s:iterator value="monuments" var="m">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="nbVisitors" /></td>
				<td><s:iterator value="%{getComments(#m)}">
						<s:property value="text" />
					</s:iterator></td>
					</tr>
			</s:iterator>
		

	</table>
</body>
</html>

