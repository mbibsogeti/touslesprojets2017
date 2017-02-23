<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=0.5, maximum-scale=2">
<title>Buenos Aires</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="WEB-INF/jsp/header.jsp">
		<jsp:param name="year" value="2017" />
	</jsp:include>

	<div class="container">

		<section class="row">
			<section class="col-xs-12" style="text-align: center">
				<h1>Buenos Aires: you sure wanna go there, ain't ya?</h1>
			</section>
		</section>
		<%!private final static String[] months = new String[] { "january", "february", "march", "april", "may", "june",
			"july", "august", "september", "october", "november", "december" };%>

		<section class="row">
			<section class="col-xs-8">
				<form>
					<p class="form-group">
						<select name="month" class="form-control">
							<%
								for (int i = 1; i <= 12; i++) {
									request.setAttribute("i", i);
							%>
							<option value="<%=i%>" ${param.month==i?"selected":""}><%=months[i - 1]%></option>
							<%
								}
							%>
						</select>
					</p>
					<p class="form-group">
						<label>Name: <input type="text" name="name"
							placeholder="John Doe" class="form-control" value="${param.name}"></label>
					</p>
					<p class="form-group">
						<label>email: <input type="email" name="email"
							placeholder="John@Doe.com" class="form-control"
							value="${param.email}"></label>
					</p>
					<p class="form-group">
						<input type="submit" value="send" class="btn btn-danger">
					</p>

					<%--Nom du mois --%>
					<%
						String m = request.getParameter("month");
					%>
					<%
						if (m != null) {
					%>
					<%
						int n = Integer.parseInt(m);
					%>

					<p>
						Request for
						<%=months[n - 1]%>
						sent at
						<%=request.getParameter("email")%></p>
					<%
						}
					%>

				</form>
				<%
					int x = 2;
				%>
				${x} ${3+2}

			</section>
		</section>

	</div>
	<jsp:include page="WEB-INF/jsp/footer.jsp" />
</body>
</html>
