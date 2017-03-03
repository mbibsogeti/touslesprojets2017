<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url namespace="/" action="index" var="uHome" />
<s:url namespace="/ireland" action="index" var="uIre" />
<s:url namespace="/england" action="index" var="uEng" />
<s:url namespace="/spain" action="proposal" var="uSpn" />
<s:url namespace="/italia" action="index" var="uItl" />
<s:url namespace="/croatia" action="index" var="uCro" />

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
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/spain/list")?"class='active'":""%>><a
			href="/travel-struts-laurent/spain/list"><s:text name="spain.list.title"/></a>
	</ul>
</nav>
<%}
if(menu.equals("italia")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="${uHome}">Paradise
			on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/italia/index")?"class='active'":""%>><a
			href="${uItl}"><s:text name="italia.title"/></a>
	</ul>
</nav>
<%}
if(menu.equals("croatia")){%>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="${uCro}">Paradise
			on ice</a>
	</div>
	<ul class="nav navbar-nav">
		<li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/croatia/index")?"class='active'":""%>><a
			href="${uItl}"><s:text name="croatia.title"/></a>
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
			href="${uSpn}">SPAIN</a><li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/italia")?"class='active'":""%>><a
			href="${uItl}">ITALIA</a><li
			<%=request.getRequestURL().toString().endsWith("/travel-struts-laurent/croatia")?"class='active'":""%>><a
			href="${uCro}">CROATIA</a>
			
			
	</ul>
</nav>
<%}%>