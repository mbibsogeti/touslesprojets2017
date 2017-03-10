<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spain</title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<s:url namespace="/spain" action="byid" var="uById" />
	<div class="container">
		<div class="row">
			<h1 class="text-center"><s:text name="spain.list.title"/></h1>
		</div>
		<div class="row">
			<table class="col-md-10 col-md-offset-1">
				<thead>
					<tr style="background-color:#856D4D; color:white">
						<th></th>
						<th class="text-center"><s:text name="spain.list.name"/></th>
						<th class="text-center"><s:text name="spain.list.location"/></th>
						<th class="text-center"><s:text name="spain.list.visitor"/></th>
					</tr>
				<tbody>
					<tbody>
						<s:iterator value="monuments" status="st">
							<tr>
								<td class="text-center"> <s:property value="#st.count"/>
								<td class="text-center"><a href="${uById}?id=<s:property value='id'/>"> <s:property value="name"/></a>
								<td class="text-center"> <s:property value="location"/> 
								<td class="text-center"> <s:property value="visitor"/>
						</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<aside>
		<a href="?request_locale=fr" class="btn btn-primary"> fr </a> 
		<a href="?request_locale=en" class="btn btn-primary"> en </a>
		<a href="?request_locale=es" class="btn btn-primary"> es </a>
	</aside>
</body>
</html>