/**
 * 
 */
console.log("costarica.js loaded")

function sent() {
	var en = document.getElementById("message")
	var nbVoyageurs = document.getElementById("nb")
	var n = parseInt(nb.value)

	// Exo de condition

	if (n < 1 || n > 50) {
		en.value = "ERREUR"
	} else if (n > 5) {
		en.value = "Faites une demande par mail"
	} else {
		en.value = "Demande envoyée - Estimation du prix: "
		en.value += (n * 1080) + " euros."
	}

	// Exo de boucle

	en.value += " ("
	for (var i = 1; i < n; i += 2) {
		en.value += "Chambre double,"
	}
	if (n % 2 == 1) {
		en.value += "Chambre simple"
	}
	en.value += ")";

	// Exo Tableau

	var tab = [ 45, 460, 190, 80 ]
	var l = 0
	for ( var i in tab) {
		l = l + tab[i] + 40
		en.value += "Temps trajet N°" + i + " est de: " + l + " "
	}

	function Option (nbV){
		this.lireOption = function (){
			var tab = {
					"chambre Mitoyenne" : 3,
					"croisiere" : 5,
					"spectacle" : 3,
					"souvenir" : 4
				}
			for ( var opt in tab)
				if (tab[opt] <= nbV) {
					en.value += opt + ", "
				}
			return en.value
		}	
	}
	var opt1 = new Option(n)
	opt1.lireOption();
}

document.getElementById("bouton").addEventListener("click", sent)