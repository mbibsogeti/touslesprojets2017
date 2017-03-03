<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url namespace="/" action="index" var="uHome" />
<s:url namespace="/ireland" action="index" var="uIre" />
<s:url namespace="/england" action="index" var="uEng" />
<s:url namespace="/spain" action="proposal" var="uSpn" />

<%String menu=request.getRequestURL().toString().split("/")[6];
if(menu.equals("ireland")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="${uHome}">Paradise on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/ireland/index")?"class='active'":""%>><a
			href="${uIre}">Accueil</a>
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/ireland/infos")?"class='active'":""%>><a
			href="/travel-struts-laurent/ireland/infos"><span
				class="glyphicon glyphicon-hand-right"> </span> Informations</a>
		<li <%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/ireland/travels")?"class='active'":""%>><a
			href="/travel-struts-laurent/ireland/travels"><span
				class="glyphicon glyphicon-plane"> </span> Voyages</a>
	</ul>
</nav>
<% }
if(menu.equals("england")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="/travel-struts-laurent/index">Paradise
			on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/england/index")?"class='active'":""%>><a
			href="/travel-struts-laurent/england/index">Accueil</a>
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/england/registration")?"class='active'":""%>><a
			href="/travel-struts-laurent/england/registration">Inscription</a>
	</ul>
</nav>
<%}
if(menu.equals("spain")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="/travel-struts-laurent/index">Paradise
			on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/spain/proposal")?"class='active'":""%>><a
			href="/travel-struts-laurent/spain/proposal"><s:text name="spain.proposal"/></a>
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/spain/byid")?"class='active'":""%>><a
			href="/travel-struts-laurent/spain/byid">${monument.name}</a>
	</ul>
</nav>
<%}
if(menu.contains("index")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="${uHome}">Paradise on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/index")?"class='active'":""%>><a
			href="${uHome}">INDEX</a> <li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/ireland/index")?"class='active'":""%>><a
			href="${uIre}">IRELAND</a><li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/england/index")?"class='active'":""%>><a
			href="${uEng}">ENGLAND</a><li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/spain")?"class='active'":""%>><a
			href="${uSpn}">SPAIN</a>
			
	</ul>
</nav>
<%}%>