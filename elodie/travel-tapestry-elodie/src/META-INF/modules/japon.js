(function(){
	define(["jquery"],function($){
		console.log("japon.js loaded!")
		$("section>p>a").on("click",function(){
			$(this).animate({"margin-left":"400px"})
		})
		
	})
})()