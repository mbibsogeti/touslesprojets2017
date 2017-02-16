///////////////////////////////////////////////////////////
// On remplace tout le body du fichier HTML par "H4CK3D" //
///////////////////////////////////////////////////////////
// document.body.innerHTML = "H4CK3D";
//
///////////////////////////////////////
// Accéder au premier enfant de body //
///////////////////////////////////////
// document.body.firstChild;
// Le premier enfant est la zone vide en dessous de <body>, actuellement il
// s'agit d'un retour à la ligne
//
////////////////////////////////
// Accéder aux autres enfants //
////////////////////////////////
// les indices commencent à 0
// Changer "Nos voyages" en "Vos voyages" :
document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos voyages";

// /////////////////////////////////////////
// querySelector() et querySelectorAll() //
// /////////////////////////////////////////
// La fonction querySelector() permet de sélectionner UN
// noeud,querySelectorAll() les sélectionne tous

// Rajouter un "!" au titre de la dernière section

// Ici, on sélectionne tous les h2 dans la dernière section (il n'y en a qu'un)
document.querySelector("section:last-of-type h2").innerHTML += "!";

// On sélectionne tous les h2 du document (peu importe leur place)
var l = document.querySelectorAll("h2");
// Effacement de tous les éléments de l
for (var i = 0; i < l.length; i++)
	l[i].innerHTML = "Il y avait un titre ici";

// Quand on clique sur un h2, une alerte est déclenchée (ma version)
// var l = document.querySelectorAll("h2");
// for (var i = 0; i < l.length; i++) {
// l[i].onclick = function() {
// alert("!!!");
// }
// }

// Quand on clique sur un h2, une alerte est déclenchée (version prof)
// for (var i = 0; i < l.length; i++) {
// // Fonction anonyme
// l[i].addEventListener("click", function() {
// alert("!!!");
// })
// }

// ////////////////////////////////////////////////////////////////////////
// Afficher les paragraphes lorsqu'on clique dessus et cacher les autres //
// ///////////////////////////////////////////////////////////////////////
// Pour se souvenir du p sur lequel on a cliqué précédemment
var oldP = null;
for (var i = 0; i < l.length; i++) {
	l[i].addEventListener("click", function() {
		// Paragraphe qui a le même parent que l'objet en cours
		// querySelector("p") cherche dans les enfants, donc on doit utiliser
		// parentNode pour remonter au même niveau que this (h2)
		var p = this.parentNode.querySelector("p");

		// A reprendre (Reynald)
		if (p == oldP) {
			if (p.style.display == "block") {
				p.style.display = "none";
			} else {
				p.style.display = "block";
			}
		} else {
			if (oldP != null) {
				oldP.style.display = "none";
			}
			p.style.display = "block";
		}
		// Le nouveau p devient l'ancien
		oldP = p;
	})
}

// //////////////////////////
// DESSINS DANS UN CANVAS //
// //////////////////////////
var blue = 0;
var tps = [ 7, 10, 19, 23, 28, 31, 42, 33, 28, 18, 15, 8 ];
function showTps() {
	var ctx = document.querySelector("canvas").getContext("2d");
	for ( var i in tps) {
		// Couleur des barres en RGB avec calcul pour le vert et le bleu
		ctx.fillStyle = "rgb(255, " + (250 - tps[i] * 7) + "," + (blue%200) + ")";
		// AxeX, AxeY, longueur, largeur, hauteur (avec calcul)
		ctx.fillRect(i * 80 + 20, 1000 - tps[i] * 30, 75, tps[i] * 30)
	}
	// blue augmente de 5 en 5 mais le modulo instaure un cycle
	blue += 5;
}

// On appelle la fonction showTps toutes les 100 ms
setInterval(showTps, 100);


///////////////////
// LOCAL STORAGE //
///////////////////
// Si le localStorage n'existe pas déjà, on le créé
// La prochaine fois qu'on vient sur la page, il ne s'affichera pas (car
// la valeur est à true et cela est conservé de façon permanente dans le
// localStorage). Le nom de l'attribut deja est arbitraire.
if (!localStorage.deja) {
	localStorage.deja = true
	alert("Cliquez ici pour refermer cette fenêtre")
}