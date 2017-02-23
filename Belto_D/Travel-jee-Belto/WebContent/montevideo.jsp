<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale scope="page" value="en"/>
<%@taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="travel"
uri="http://travel.com"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Montévidéo</title>
</head>
<body>
<h1>${fn:toUpperCase("Montévideo")}</h1>
<h2> Bienvenu à montévidéo</h2>
<travel:discount/>
<p>
Montevideo ou Montévidéo2, de son nom complet San Felipe y Santiago de Montevideo,
est la capitale, le principal port et la plus grande ville d'Uruguay et est aussi 
celle du département de Montevideo. Montevideo possède une des plus importantes 
rades des Amériques (appelée Rambla[réf. souhaitée]). Elle se trouve dans la partie 
sud du pays et est bordée par le Rio de la Plata. La ville comptait 1 325 968 habitants
en 2004 et son aire métropolitaine 1 668 335, soit presque la moitié de la population
du pays. La ville possède également de superbes plages, telles que Pocitos, Buceo,
Malvín, Playa de los Ingleses, Playa Verde, Punta Gorda et Carrasco.
Montevideo accueille le siège du Mercosur et celui de l'ALADI. Montevideo est considérée
comme la ville d'Amérique latine où la qualité de vie est la plus élevée et fait partie
des 30 villes les plus sûres du monde.
</p>
le prix totale est: 
${promo}€;<!-- afficher le calcul déjà fait dans la servlet -->
<br>
ou avec un autre format:
<fmt:formatNumber value="${promo}"
pattern="0.0"/>€
<br>
<!-- dire que cette promo est valable pendant 1 an -->
Cette promo est valable jusqu'au
${now.dayOfMonth-1}/
${now.monthValue}/
${now.getYear()+1};
<br>
Une réduction de 15% est déjà déduite dans le prix affiché.
<br>
Le programme:
<table>
<c:forEach items="${days}" var="day" varStatus="s">
<tr><th>Jour ${s.count} </th><td>${day}<c:if test="${s.count%2==0}">!</c:if></td></tr>
</c:forEach>
</table>
<!-- cela ne marche pas pour afficher le tableau, on aurait pu mettre du java mais on va faire du JSTL -->
</body>
</html>