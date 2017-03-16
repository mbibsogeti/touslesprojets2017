/**
 * jQuery
 */
(function() {
	define([ "jquery" ], function($) {
		console.log("japan.js loaded!")
		// $("section>a").animate({"margin-left" : "100px"}, 1000)
		$("section>a").on("click", function() {
			$(this).animate({
				"margin-left" : "100px"
			}, 1000)
		})
	})
})()