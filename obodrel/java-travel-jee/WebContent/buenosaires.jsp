<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%!private static final ArrayList<String> months = new ArrayList<String>();%>
<% boolean isMonthSet = false; %>
<% boolean isNameSet = false; %>
<% boolean isEmailSet = false; %>
<% boolean isError = false; %>
<% boolean isFirstTime = false; %>
<% String monthValue = ""; %>
<% String nameValue = ""; %>
<% String emailValue = ""; %>
<% String errorOutName = ""; %>
<% String errorOutEmail = ""; %>
<% String errorOutMonth = ""; %>
<%
	if(months.size() == 0 ) {
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");
	}
%>
<% 
	Pattern patternMonth = Pattern.compile("[0-9]{1,2}$", Pattern.CASE_INSENSITIVE);
	Pattern patternName = Pattern.compile("^[A-Z ]*$", Pattern.CASE_INSENSITIVE);
	Pattern patternEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	if(request.getParameter("monthsBA") != null && !request.getParameter("monthsBA").equals("")) {
		isMonthSet = true;
		monthValue = request.getParameter("monthsBA");
	}
	if(request.getParameter("nameBA") != null && !request.getParameter("nameBA").equals("")) {
		isNameSet = true;
		nameValue = request.getParameter("nameBA");
	}
	if(request.getParameter("emailBA") != null && !request.getParameter("emailBA").equals("")) {
		isEmailSet = true;
		emailValue = request.getParameter("emailBA");
	}
	Matcher matcherMonth = patternMonth.matcher(monthValue);
	if(request.getParameter("monthsBA") != null && !matcherMonth.find() && !(Integer.valueOf(monthValue) >=1 && Integer.valueOf(monthValue)<=12)) {
		isMonthSet = false;
		monthValue = "";
		errorOutMonth += "Months can only be from 1 to 12!";
	}
	Matcher matcherName = patternName.matcher(nameValue);
	if(request.getParameter("nameBA") != null && !matcherName.find()) {
		isNameSet = false;
		nameValue = "";
		errorOutName += "Numbers are not authorized in names!";
	}
	Matcher matcherEmail = patternEmail.matcher(emailValue);
	if(request.getParameter("emailBA") != null && !matcherEmail.find()) {
		isEmailSet = false;
		emailValue = "";
		errorOutEmail += " You didn't put an acceptable email, please enter an email like [foobar@foobar.com] (this is an example)!";
	}
	if(request.getParameter("monthsBA") == null && 
			request.getParameter("nameBA") == null && 
			request.getParameter("emailBA") == null ) {
		isFirstTime = true;
	}
	isError = !(isNameSet && isEmailSet && isMonthSet);
	request.setAttribute("monthValue", monthValue);
	request.setAttribute("nameValue", nameValue);
	request.setAttribute("emailValue", emailValue);
%>
<!DOCTYPE html>
<html xmlns="">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
<title>Buenos Aires</title>
</head>
<body id="body">
	<div class="container-fluid">
		<h1 class="col-xs-12 col-xs-offset-3">Obodrel's Travel, South
			America division!</h1>
		<nav class="col-xs-12">
			<ul class="nav nav-pills nav-justified">
				<li><a href="./">Home</a></li>
				<li><a href="./equator/quito">Quito Travel</a></li>
				<li><a href="./colombia/cartagena">Cartagena Travel</a></li>
				<li><a href="./venezuela/maracaibo">Maracaibo Travel</a></li>
				<li><a href="./peru/lima">Lima Travel</a></li>
				<li><a href="./chile/santiago">Santiago Travel</a></li>
				<li><a href="./lapaz.jsp">Lapaz Travel</a></li>
				<li class="active"><a href="./buenosaires.jsp">Buenos Aires Travel</a></li>
				<li><a href="./asuncion.jsp">Asuncion Travel</a></li>
				<li><a href="./montevideo">Montevideo Travel</a></li>
			</ul>
		</nav><%if(!isFirstTime) { %>
		<div class="col-xs-6"><% } else { %>
		<div class="col-xs-12"><% } %>
			<h3>Buenos Aires Welcomes you for inscription!</h3>
			<p>Please fill in the correct informations!
			<p>
			<form action="./buenosaires.jsp" method="get">
				<section class="form-group">
					<label for="monsthsIDBA">Departure :</label>
					<select class="form-control" name="monthsBA" id="monsthsIDBA"> <% for (int i = 0; i < months.size(); i++) { request.setAttribute("i", i);%>
							<option ${monthValue==i+1?"selected":""} value="<%=i + 1%>"><%=months.get(i)%></option><% } %>
					</select>
					<label for="nameIDBA">Name :</label><input required value="${nameValue}" class="form-control" type="text" name="nameBA" id="nameIDBA">
					<label for="emailIDBA">Email :</label><input required value="${emailValue}" class="form-control" type="email" name="emailBA" id="emailIDBA">
					<input class="btn btn-primary" type="submit" value="Submit">
				</section>
			</form>
		</div><%if(!isError) { %>
		<div class="col-xs-6">
			<h3>Your travel</h3>
			<p>Request to go on <%=months.get(Integer.valueOf(monthValue)-1) %> registered for <%= request.getParameter("emailBA") %>!</p>
		</div><% } else if(isError && !isFirstTime) { %>
		<div class="col-xs-6">
			<h3>You made an error</h3>
			<p>You forgot to fill in some values, please retry!</p><%if(!errorOutMonth.equals("")) {%>
			<p><%=errorOutMonth %></p><%} %><%if(!errorOutName.equals("")) {%>
			<p><%=errorOutName %></p><%} %><%if(!errorOutEmail.equals("")) {%>
			<p><%=errorOutEmail %></p><%} %>
		</div><% } %>
	</div>
</body>
</html>
