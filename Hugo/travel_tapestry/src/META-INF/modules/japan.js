/**
 * 
 */

(function() {
	/** ["jquery"]: appel au module jquery * */
	/** function($): prefixe pour appeler le module jquery dans js * */
	define([ "jquery" ], function($) {
		console.log("japan.js cargado")
		// $("section>a").animate({"margin-left":"400px"})
		$("section a").on("click", function() {
			$(this).animate({
				"margin-left" : "200px"
			})
		})
	})

})()