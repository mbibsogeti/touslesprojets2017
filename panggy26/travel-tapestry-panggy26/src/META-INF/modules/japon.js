/**
 * Définition de module AMD
 */
(function() {
	define(["jquery"], function($) {
		console.log("Chargement du fichier japan.js");
		// $("section>a") : Sélectionne les balises a filles des balises section
//		$("section>a").css({"margin-left" : "400px"});
		// Applique la fonction spécifiée lorsque l'événement click a lieu 
		$("section>a").on("click", function() {
			// $(this) : désigne l'objet JQuery sur lequel l'événement a lieu
			// animate() : fais ce qu'il y a entre parenthèses (dictionnaire JavaScript), mais pas immédiatement
			$(this).animate({"margin-left" : "400px"});
			
		})
	})
})()
// Je définis une fonction entre les grandes parenthèses et je l'appelle tout de suite avec les petites parenthèses