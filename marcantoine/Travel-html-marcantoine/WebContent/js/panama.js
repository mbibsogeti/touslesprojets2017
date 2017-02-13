/**
 * 
 */
// Utilisation ,fonction innerHTML
document.querySelector("section:last-of-type h2").innerHTML += "!";
function titleClicked() {
	alert('Clic !!')
}

// Réalisation d'un accordéon
var oldp = null;
var l = document.querySelectorAll("h2");
// boucle regardant les noeuds contenus dans l :
for (var i = 0; i < l.length; i++) {
	// fonction ouvrant et fermant les block
	l[i].addEventListener("click", function() {
		//		
		var p = this.parentNode.querySelector("p");
		// afficher le block p
		p.style.display = "block";
		// si le block p précédent est affiché, le cacher et appeler le block
		// actuel
		// bloc précédent
		if (oldp != null)
			oldp.style.display = "none";
		oldp = p;
	})
}

if (!localStorage.deja) {
	localStorage.deja = true;
	alert("cliquez pour refermer")
}

// Changement de la couleur toutes les x secondes
var blue = 0;
function showTps() {

	// Remplissage du canvas créé dans l'html
	var tps = [ 3, 8, 15, 18, 27, 31, 35, 36, 30, 27, 18, 13 ];
	var ctx = document.querySelector("canvas").getContext("2d");
	for ( var i in tps) {
//		On ajoute blue dans le RGB
		ctx.fillStyle = "rgb("+(blue%150)+"," + (250 - tps[i] * 7) + ","+(blue%200)+")";
		ctx.fillRect(i * 80 + 20, 1000 - tps[i] * 30, 75, tps[i] * 30);
	}
//	on incrémente la valeur de bleu à chaque tour de setInterval(...,...)
	blue += 5
}
setInterval(showTps, 20);