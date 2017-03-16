<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 %>
 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"
 %>
   
 <%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt"
 %> 
  
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions"
 %>   
 
 <%@ taglib prefix="travel" 
           uri="http://travel.com"
 %>
 
 <fmt:setLocale scope="page" value="en"/>

<p> <travel:discount/></p>
<h1>${fn:toUpperCase("Montevideo")}</h1> 
<p>Montevideo est située au sud de l'Uruguay, en bordure du Rio de la Plata et se développe autour d'une baie qui forme un <br>port naturel, l'un des plus importants du cône Sud. Son relief est peu accentué et culmine à 136 mètres au Cerro. C'est la capitale la plus méridionale du continent américain.</p>
<p> Votre prix tout compris après promotion est de  <fmt:formatNumber value="${promo}" pattern="0.00"/> € </p>
<p> Et cette promotion est valide jusqu'au ${now.dayOfMonth}/${now.monthValue}/${1+now.getYear()}.</p>
<table>
 <tr>
 <th>Jour</th>
 <th>Programme</th></tr><tr>
<c:forEach items="${days}" var="progDay" varStatus="s">
 <tr><td>j${s.count}</td>
 <td>${progDay}<c:if test="${s.count%2==0}">!
</c:if></td></tr>
</c:forEach>
</table>







 

