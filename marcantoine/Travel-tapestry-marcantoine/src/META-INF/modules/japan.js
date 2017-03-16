/**
 * 
 */

// Premier bout de code servant à définir le code.
// On écrit la fonction (function...)() pour :
// 1) aider l'interpréteur js à s'y retrouver,
// 2) définir un morceau de code défini qui est executé immédiatement
// (parenthèses de fin)).
(function() {
	define([ "jquery" ], function($) {
		console.log("japan.js is loaded!");
		// Animation dés chargement page
//		$("section>a").animate({
//			"margin-left" : "400px"
//		});
		$("section>a").on("click", function() {
			$(this).animate({"margin-left" : "400px"});
		})
	})
})()