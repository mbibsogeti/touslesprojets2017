<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- c pour core, uri à copiercoller depuis le fichier c.tld --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fmt pour format --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- fn pour functions --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- Utilisation de la taglib prototype XB-2214 créée de toutes pièces --%>
<%@ taglib prefix="travel" uri="http://travel.com"%>
<%-- Précise la langue utilisée dans cette page. Impacte aussi le format des nombres --%>
<fmt:setLocale scope="page" value="en"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uruguay</title>
</head>
<body>
	<%-- ${fn:toUpperCase()} pour afficher en majuscules --%>
	<h1> ${fn:toUpperCase("Bienvenido a Uruguay")} </h1>
	<section>
		<%-- Autre syntaxe pour accéder aux attributs de l'objet LocalDateTime "now" : ${now.getYear()}, ${now.getDayOfMonth()}, ${now.getMonthValue()} --%>
		<p>Bénéficiez d'une offre exceptionnelle ! Une <travel:discount/> de 15% sur le prix d'un aller-retour Bordeaux-Montevideo ! Le coût de votre voyage de
		 rêves s'élèvera ainsi à <fmt:formatNumber value="${promo}" pattern="0.00"/> € au lieu de 1399 € ! Promotion valide jusqu'à la fin de l'année 
		 en cours : 31/12/${now.year}. 
		 Pour les nains de jardin, cette incroyable promotion perdurera jusqu'au ${now.dayOfMonth}/${now.monthValue}/${now.year + 1}.</p>
	</section>
	<section>
		Voici le programme éclectique de votre séjour uruguayen :
		<table>
			<%-- On fouille dans planning et chacun des objets contenus dedans sont stockés dans la variable programme --%>
			<c:forEach items="${planning}" var="programme" varStatus="s">
				<tr>
					<%-- ${s.count} permet d'avoir les entiers en partant de 1. Pour partir de 0 : ${s.index} --%>
					<td> 
						Jour ${s.count} :
					</td>
					<td>
						${programme}
						<%-- Rajouter un ! sur les activités des jours pairs --%>
						<c:if test="${s.count % 2 == 0}">
							!
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>