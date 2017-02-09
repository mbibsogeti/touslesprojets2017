/**
 * 
 */
console.log("File costarica.js loaded");

function sent() {
	var m = document.getElementById("message");
	var nb = document.getElementById("nb");
	// Conversion entier -> numérique
	var n = parseInt(nb.value);
	m.value = "Demande envoyée, ";

	// CONDITION //
	if (n <= 1 | n >= 50) {
		// On écrase la chaîne précédente
		m.value = "Erreur"
	} else if (n >= 6) {
		// On poursuit la chaîne précédente
		m.value += "mais il ne s'agit pas d'un voyage familial, contactez-nous par mail"
	} else {
		m.value += n * 1080 + "€";

		// BOUCLE //
		m.value += " (";
		while (n > 0) {
			if (n % 2 == 0) {
				m.value += "une chambre double";
				n -= 2;
				// Si ce n'est pas le dernier, on met une virgule
				if (n > 0) {
					m.value += ", ";
				}
			} else {
				m.value += "une chambre simple, ";
				n -= 1;
			}
		}
		m.value += ")";
		// Le n a été modifié, on reprend ici la valeur saisie
		var n = parseInt(nb.value);

		/*
		 * Version du prof (voir la boucle) m.value = " ("; for (var i = 1; i <
		 * n; i += 2) m.value += "Une chambre double, " if (n % 2 == 1) m.value +=
		 * "Une chambre simple"
		 */
	}

	// TABLEAU //
	/*
	 * [Navette, vol jusqu'à LA, vol jusqu'à San Jose, bus] et 40 minutes entre
	 * chaque étape
	 */
	var ds = [ 45, 7 * 60 + 40, 3 * 60 + 10, 60 + 20 ];
	var etape = 40;
	var tot = 0;
	for ( var i in ds) {
		tot += ds[i] + etape;
	}
	var heure = parseInt(tot / 60);
	var minute = tot % 60;
	m.value += " Temps total de voyage : " + heure + " heure(s) et " + minute
			+ " minute(s)";

	// DICTIONNAIRE //
	var cadeaux = {
		"Chambres mitoyennes" : 3,
		"Croisière" : 5,
		"Spectacle" : 3,
		"Souvenirs" : 4
	}
	// Les boucles dans les dictionnaires parcourent les clefs
	for ( var i in cadeaux) {
		if (n >= cadeaux[i]) {
			m.value += " Bravo ! Vous avez gagné : " + i;
		}
	}

}

document.getElementById("send").addEventListener("click", sent);