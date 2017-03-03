<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="'<c:url value='WEB-INF/css/bootstrap.min.css'/>' rel='stylesheet'"/>
</head>
<body style="background: #F8F4F8">
	<div class="container">
		<div class="row">
			<div class="row col-sm-12">


				<h1>Nos voyages en Irlande</h1>
				<p>Actuellement nous vous proposons ${travels.size()}
					destinations.</p>
				<p>Par exemple: ${travels[3].location}</p>
</div>
<div class="row">
				<section class="col-sm-12 table-responsive ">
					<table class="table table-striped">
						<tr>
					     	<th>Position</th>
							<th>Location</th>
							<th>Days</th>
							<th>Accomodation</th>
						</tr>
						
						<s:iterator value="travels" status="st">						
							<tr>
							
							    <td><s:property value="#st.index"/></td>
								<td><s:property value="location"/></td>
								<td><s:property value="days" /></td>
								<td><s:property value="accomodation"/>
								<s:if test='accomodation=="hotel"'>
						          &#9733; &#9733; &#9733;
						          </s:if>
						         <s:else > 
						         &#9733; &#9733;
						         </s:else>
						        
								</td>							
						      
							</tr>
						</s:iterator>
					</table>
				</section>
			</div>
		</div>	
		</div>
	<s:debug />
</body>
</html>