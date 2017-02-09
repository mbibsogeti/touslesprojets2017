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

	// CONDITION
	if (n <= 1 | n >= 50) {
		// On écrase la chaîne précédente
		m.value = "Erreur"
	} else if (n >= 6) {
		// On poursuit la chaîne précédente
		m.value += "mais il ne s'agit pas d'un voyage familial, contactez-nous par mail"
	} else {
		m.value += n * 1080 + "€";

		// BOUCLE
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

		/* Version du prof (voir la boucle)
		m.value = " (";
		for (var i = 1; i < n; i += 2)
			m.value += "Une chambre double, "
		if (n % 2 == 1)
			m.value += "Une chambre simple" */

	}
}

document.getElementById("send").addEventListener("click", sent);