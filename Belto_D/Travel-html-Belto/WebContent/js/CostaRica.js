/**
 * 
 */
console.log("Costarica.js loaded")
function buttonClicked() {
	var m = document.getElementById("message")
	var nb = document.getElementById("number")
	var n = parseInt(nb.value)
	var total = 1080 * n
	// Test, moins de 1 et + de 50 = erreur, plus de 5 voyageurs demande à faire
	// par mail//
	if (n < 1 | n > 50) {
		m.value = "error"
	} else if (n > 0 & n < 6) {
		m.value = "Devis envoyé, le total est: ";
		m.value += total + "€"; // utilisation de +=//
		// afficher chambre double, chambre simple en fonction du nombre de
		// personne entre 1 et 5//
		for (var i = 1; i < n; i += 2)
			m.value += " une chambre double,"
		if (n % 2 == 1)
			m.value += " une chambre simple"
	} else {
		m.value = "Demande à faire par mail: ";
	}
	// utilisation d'un table//
	var t = [ 45, 7 * 60 + 40, 3 * 60 + 10, 80 ];
	var s = t.length;
	var total = 0;
	for (var i = 0; i < s; i++)
		total += t[i] + 40;
	m.value += " Un trajet de " + total + " min"
	//utilisation d'un objet, d'une Bibliotèque//
	var o={ChMitoyennes: 3, Croisiere:5, Spectacle:3, Souvenirs:4}
	m.value+=" .Les options disponibles pour vous "
	for (var k in o)
		if(o[k]<=n)
			m.value+=k+" "
		
}
document.getElementById("button").addEventListener("click", buttonClicked)