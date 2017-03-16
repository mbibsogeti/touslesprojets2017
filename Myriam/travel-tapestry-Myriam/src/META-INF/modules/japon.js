/**
 * 
 */


function japan(){ 
	define(
			["jquery"],function($){
		console.log("japon.js loaded !");
		$("section>a").on("click",function(){
			console.log("j'y passe");
			$(this).animate({"margin-left":"100px"})});
	})


}
	
(japan)();