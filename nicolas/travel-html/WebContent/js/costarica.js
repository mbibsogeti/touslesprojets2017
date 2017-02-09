/**
 * 
 */

console.log("costarica.js loaded")

function send() { // le e est créé par la ligen 53
	console.log('registered')
	var m = document.getElementById("message");
	var nb = document.getElementById("nbTravellers");
	var n = parseInt(nb.value) // converti caractère en string
	// m.value= "inscription envoyé "+nb.value // concate avec la value lit
	// précédement $
	m.value = "inscription envoyé ";
	//m.value += (n * 1080)

	if (n < 1 | n > 50)
		m.value = "ERREUR ";
	if (n > "5")

		m.value = "envoyer un mail ";

	m.value += " ("

	for (var i = 1; i < n; i += 2)
		m.value += "une chambre double,";
	if (n % 2 == 1)
		m.value += "une chambre simple"
	m.value += ")";
	var t=[45,460,190,80]
	var dure=0;
	for(var i in t)
		dure+=40+ t[i]
	m.value+="Trajet:"+dure+"min"

}



document.getElementById("send").addEventListener("click", send)