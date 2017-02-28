var url = "jersey/excursions/list";
var xhr = new XMLHttpRequest();

window.onload = onLoadInit;
function onLoadInit() {
	// Appel à la fonction received()
	xhr.onreadystatechange = received;
	// Ouverture de la connexion
	xhr.open("GET", url, true);
	// On lance la requête. Pas de donnée dans le corps (ne serait pas nul si envoi d'un formulaire).
	xhr.send(null);
}
function received() {
	/**
	 * Affiche Received dans la console du navigateur.
	 */
	//console.log("Received");
	// readyState vaut 4 : All the data has been received
	if(xhr.readyState == 4) {
		console.log("Received");
		// On convertit le corps de la réponse (xhr.responseText) en objet JavaScript
		var excurs = JSON.parse(xhr.responseText);
		for(var i in excurs) {
			document.getElementById("exTable").innerHTML += "<tr><td>" + excurs[i].lieu + "</td></tr>";
		} // end for
	} // end if
} // end received function