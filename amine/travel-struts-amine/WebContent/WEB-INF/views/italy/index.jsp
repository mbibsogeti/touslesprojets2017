<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Italy</title>
<style>
table, th, td {
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Italie</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Location</th>
			<th>Visitor</th>
			<th>Comment</th>
		</tr>
		<s:iterator value="monuments" var="m">
			<tr>

				<td><s:property value="name" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="visitor" /></td>
				<td><s:iterator value="%{getComments(#m)}">
						<s:property value="text" /><br>
					</s:iterator>
				</td>
			</tr>
		</s:iterator>


	</table>
</body>
</html>