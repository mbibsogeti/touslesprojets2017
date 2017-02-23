<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // Permet d'utiliser les symboles UTF-8 dans le texte HTML%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lapaz en Bolivie</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
	<%@page import="java.util.TreeMap" %>
	<%!private static final int jrs=10;
		private static final double prixAv=1062;
		private static final double prixUnit=42;
		private TreeMap<String,String> Menu= new TreeMap<>();

		public String setMenu(String ongletActif){
			String txt="";
			txt+="<nav >";
			txt+="<ul class='nav nav-tabs nav-justified'>";
			for(String k:Menu.keySet()){
				txt+="<li"+((k==ongletActif)?"class='active'>":">")+"<a href='"+Menu.get(k)+">"+k+"</a>";
			}
			txt+="</ul></nav>";
			return txt;
		}
		
		public void addMenu(String titre, String lien){
			Menu.put(titre, lien);
		}
	%>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="text-center col-xs-12">Lapaz</h1>
		</div>
		<div class="row">
			
			<% 
				double prixTTC=prixAv+prixUnit*(jrs-1);
			%>
			<h3 class="col-xs-8">Voyage de <%= jrs %> jours, tout compris, pour : <%= prixTTC %> €</h3>
			
		</div>
		<div class="clearfix visible-xs visible-sm visible-lg"> </div>
		<div class="row">
			<section class="col-sm-6 table-responsive">
				<h2>Planning</h2>
				<table class="table table-striped table-bordered table-condensed">
					<thead>
						<tr> 
							<th> Jour
							<th> Programme
					<tbody>
						<%for(int i=1;i<(jrs+1);i++){ %>
							<tr>
								<th> <%=i %>
								<%if((i==1)||(i==10)){ %>
									<td class="text-justify"> <%="Avion"%>
								<%}else{%>
									<td class="text-justify"> <%="Visites"%>
								<%} %>
						<%} %>
					</tbody>
				</table>
			</section>
		</div>
	
	</div>
</body>
</html>