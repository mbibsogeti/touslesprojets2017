/**
 * 
 */
console.log("costaRica.js loaded")

function sendForm() {
	var m = document.getElementById("message")
	var nb = document.getElementById("nb")
	var n = parseInt(nb.value)
	if (n < 0 | n > 50) {
		m.value = "Entrez une valeur entre 1 et 50";
	} else {
		if (n <= 12) {
			m.value = "Form sent for " + nb.value + " travellers. ";
			m.value += "Total price: " + n * 1080 + " € (";
			for (i = 0; i < n - 1; i += 2) {
				m.value += "une chambre double, ";
			}

			if (n % 2 != 0) {
				m.value += "une chambre simple).";
			} else {
				m.value += ")."
			}
		} else {
			m.value = "Call us, you're too many.";
		}
	}
	
	var t = [ 45, 7 * 60 + 40, 3 * 60 + 10, 1 * 60 + 20 ];
	var time = 0;
	for ( var i in t) {
		time += t[i] + 40;
	}
	m.value += " Length of the trip: " + parseInt(time / 60) + " hours and "
			+ time % 60 + " minutes.";
	
	var o = {"Ch. mitoyennes":3, "Croisière":5, "Spectacle":3, "Souvenirs":4};
	m.value += " Options: "
	for (var k in o) {
		if (o[k] <= n) {
			m.value += k+", ";
		}
	}
	m.value += " c'est super.";
}

var b = document.getElementById("send")
b.addEventListener("click", sendForm)
