<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buenosaires bitches !!</title>
<link rel="stylesheet" href="/travel-jee-laurent/css/bootstrap.min.css">
</head>
<%! private final static String[] monthes=new String[]{"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"}; %>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center col-xs-12">Buenos Aires</h1>
		</div>
		<div class="row">
			<h2 class="text-left col-xs-12">Inscription :</h2>
			<section class="col-xs-5">
				<form>
					<section class="form-group"> 
						<label for="Depart">Départ : </label>
						<select name="month" id="Depart" class="form-control">
							<%for(int i=1;i<13;i++){ 
								request.setAttribute("i", i);
							%>
								<option value="<%=i%>" ${(param.month==i)?"selected":""}><%=monthes[i-1]%></option>
							<%} %>
						</select>
					</section>
					<section class="form-group"> 
						<label for="Nom">Nom : </label> <input type="text" name="Nom" id="Nom" value="${param.Nom}" class="form-control">
					</section>
					<section class="form-group">
						<label for="Email">Email : </label> <input type="email" name="Email" id="Email" value="${param.Email}" class="form-control">
					</section>
					<input type="submit" value="Demander" class="btn btn-default">
				</form>
			</section>
			<div class="col-xs-7">
				<%if(request.getParameter("month")!=null){ %>
					<h3>Demande pour <%=monthes[Integer.parseInt(request.getParameter("month"))-1] %> enregistrée pour ${param.Email}</h3>
				<%}%>
			</div>
		</div>
	</div>
</body>
</html>