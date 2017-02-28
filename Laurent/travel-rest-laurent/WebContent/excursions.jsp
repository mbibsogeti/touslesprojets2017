<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brazil !!</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="container">
		<div class="row">
			<h1 class="col-xs-6">Excursions</h1>
			<section class="col-xs-6">
				<table id="exTable">
				
				</table>
				<script type="text/javascript">
					//Définition de la fonction de réception de la donnée demandée
					function received(){
						console.log("Received")
						//Vérification de la réception de la réponse 
						if(xhr.readyState==4){
							//Récupération de la donnée demandée
							var excs=JSON.parse(xhr.responseText);
							//Modification du code HTML en fonction de la donnée reçu
							for(var i in excs){
								document.getElementById("exTable").innerHTML+="<tr><td>"+excs[i].location+"</td></tr>"
							}
						}
					}
					//Définition de l'URL
					var url="jersey/excursions/list";
					//Définition de l'outil de gestion de la requete
					var xhr= new XMLHttpRequest();
					//Définition de la fonction à appeler lorsque la donnée souhaitée est prete
					xhr.onreadystatechange = received;
					//Ouverture de la connection avec le serveur
					xhr.open("GET",url,true);
					//Lancement de la requête sans donnée( d'où le "null")
					xhr.send(null)
				</script>
			</section>
		</div>
		<div class="row">
			<h3>${response}</h3>
		</div>
	</div>
</body>
</html>