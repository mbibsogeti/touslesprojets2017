/**
 * 
 */

console.log("costarica.js loaded")

function buttonClicked() {
	var m = document.getElementById("message")
	var nb = document.getElementById("nb_v")
	var n = parseInt(nb.value)
	if (n < 1 | n > 50) {
		m.value = "Erreur le nombre de voyageur est trop important ou nul"
	} else if (n > 5) {
		m.value = "Pour plus de 5 voyageurs merci d'envoyer la demande de devis par e-mail afin de profiter de notre réduction du moment"
	} else {
		m.value = "Pour " + n + " voyageurs, le voyage coûtera " + n * 1080
				+ " €"
		for (i = 0; i < n / 2; i++)
			if (n % 2 == 1 & n - (i * 2) == 1) {
				m.value = m.value + ", une chambre simple"
			} else
				m.value = m.value + ", une chambre double"
	}
	var tps = document.getElementById("trajet")
	var tps_trajet = 0
	var t = [ 45, 460, 190, 80 ]
	for ( var i in t) {
		tps_trajet += 40 + t[i]
	}
	tps.value = "temps de trajet :" + parseInt(tps_trajet / 60) + "h"
			+ tps_trajet % 60 + "min"

	var c = document.getElementById("cadeau")
	c.value = "Vous aurez droit en cadeau à : "
	var o = {
		'ch.mitoyennes' : 3,
		'croisieres' : 5,
		'spectacles' : 3,
		'souvenirs' : 4,
		'afficher' : function afficher(n) {
			var t = ""
			for ( var k in this) {
				if (n >= this[k])
					t += ", des " + k
			}
			return t
		}
	}
	c.value += o.afficher(n)
}
document.getElementById("bt_devis").addEventListener("click", buttonClicked)
