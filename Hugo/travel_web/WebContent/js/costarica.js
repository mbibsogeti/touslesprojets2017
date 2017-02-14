/**
 * 
 */
console.log("costarica.js loaded");

function prixTot(a) {
	var prix = 1080;
	return a * prix;
}

function sentQuote() {
	var mess = document.getElementById('message');
	var nbT = document.getElementById('nbTravellers');
	nbT = parseInt(nbT.value);
	if (nbT < 1 | nbT > 10) {
		mess.value = 'Erreur';
	}

	else {
		if (nbT > 5) {
			mess.value = 'Demandez un devis par e-mail.';
		} else {
			mess.value = 'Devis envoyé.';
			mess.value += ' Le prix total est ' + prixTot(nbT) + ' €';
			if (nbT % 2 == 0 & nbT !== 1) {
				mess.value += ' Vous serez logés en ' + nbT / 2
						+ ' chambres doubles';
			} else {
				if (nbT == 1) {
					mess.value += ' Vous serez logés en ' + nbT
							+ ' chambre simple';
				} else {
					mess.value += ' Vous serez logés en ' + (nbT - 1) / 2
							+ ' chambres doubles et 1 chambre simple';
				}
			}
		}
	}

	tEtape = [ 45, 460, 190, 80, 40 ];
	var tTot = 0;
	for (var i = 0; i < 3; i++) {
		tTot += tEtape[i] + tEtape[4];
	}

	mess.value += '. Le temps total du voyage sera de ' + tTot + ' minutes ou '
			+ parseInt(tTot / 60) + ' heures et ' + tTot % 60 + ' minutes. ';

	mess.value += "Options: "
	var o = {
		"Chambre mitoyenne" : 3,
		"Croisière" : 5,
		"Spectable" : 3,
		"Souvenirs" : 4,
		"afficher" : function() {
			affiche = "";
			for ( var opt in o) {
				if (o[opt] <= nbT) {
					affiche += opt + ", "
				}
			}
			return affiche
		}
	}

	mess.value += o.afficher();

	// function afficher(){
	// for ( var opt in o) {
	// if (o[opt] <= nbT) {
	// return mess.value+=opt+","
	// }

	// mess.value += 'Options: '
	// for ( var opt in o) {
	// if (o[opt] <= nbT) {
	// mess.value += opt + ", "
	// }
	// }

}

var bouton = document.getElementById('boutonDevis');
bouton.addEventListener('click', sentQuote);
