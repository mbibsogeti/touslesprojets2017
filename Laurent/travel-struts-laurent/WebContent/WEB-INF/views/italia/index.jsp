<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="italia.title"/></title>
<link rel="stylesheet" href="/travel-struts-laurent/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center">
				<!-- Affiche du text statique défini dans global(_fr).properties -->
				<s:text name="italia.title"/>
			</h1>
		</div>
		<div class="row">
			<p class="col-md-6 col-md-offset-3">
				<img alt="" src="/travel-struts-laurent/img/italia1.jpg" class="img-thumbnail">
		</div>
		<div class="row">
			<table class="table table-stipped table-condensed col-md-12">
				<thead>
					<tr style="background-color:#856D4D; color:white">
						<th></th>
						<th class="text-center col-md-3"><s:text name="spain.list.name"/></th>
						<th class="text-center col-md-2"><s:text name="spain.list.location"/></th>
						<th class="text-center col-md-2"><s:text name="spain.list.visitor"/></th>
						<th class="text-center col-md-4"><s:text name="italia.list.comment"/></th>
					</tr>
				<tbody>
					<tbody>
						<s:iterator value="monuments" status="st" var="m">
							<tr>
								<td class="text-center col-md-1"> <s:property value="#st.count"/>
								<td class="text-center col-md-3"> <s:property value="name"/>
								<td class="text-center col-md-2"> <s:property value="location"/> 
								<td class="text-center col-md-2"> <s:property value="visitor"/>
								<td class="text-center text-justify col-md-4">
									<table class="table table-stipped table-condensed">
										<s:iterator value="%{getComments(#m)}">
											<tr>
												<th> <s:property value="text"/>
												<td> <s:property value="valid"/>
										</s:iterator>
									</table>
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