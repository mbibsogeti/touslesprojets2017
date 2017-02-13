console.log("costarica.js loaded");

function sent() {
	var m = document.getElementById("message");
	var nb = document.getElementById("nb");
	var n = parseInt(nb.value);
	var coutSejour = n * 1080;

	if (n < 1 || n > 50) {
		m.value = "erreur";
	} else if (n > 5) {
		m.value = "Demandez devis par mail";
	} else {
		m.value = "Votre demande est envoyée ! Cela vous coutera ";
		m.value += coutSejour + " €.";
	}


		var option1 = "chambre simple";
		var option2 = "chambre(s) double(s)";

		if (n == 1) {
			m.value += " Vous bénéficierez de " + option1 + " .";

		} else if (n % 2 == 0) {
			m.value += " Vous bénéficierez de " + (n / 2) + " " + option2
					+ " .";

		} else if (n % 2 != 0) {
			m.value += " Vous bénéficierez de " + (parseInt(n / 2)) + " "
					+ option2 + " et " + ((n % 2) + " " + option1 + " .");
		

	}
	/* Calcul temps de trajet avec temps attente de 40mn entre chaque étape */
	var tab = [ 45, 460, 190, 80 ];
	var tps = 0;

	for ( var i in tab)
		tps += 40 + tab[i];
	m.value += " " + " Votre trajet durera " + tps + " minutes";

	/*
	 * cham.mitoyennes si 3 croisiere si 5 spectacle si 3 souvenir si 4
	 */

	var tab = {
		"chamb.mitoyennes" : 3,
		"croisieres" : 5,
		"spectacles" : 3,
		"souvenirs" : 4,

		"message" : function(n) {
			var txt = "";
			for ( var opt in this)
				if (this[opt] <= n)
					txt += opt + ","
			return txt
		}
	}

	m.value += " et vous aurez droit aux " + opt + " !" + " ".message(n);
}

document.getElementById("send").addEventListener("click", sent);
