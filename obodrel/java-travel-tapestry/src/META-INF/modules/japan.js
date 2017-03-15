(function(){
	define(["jquery"],function($){
		console.log("japan.js loaded");
		$("section>div").css({
			"text-transform":"uppercase"
		});
		$("section>div").on("click",function(){
			console.log($(this).css("width"));
			if($(this).css("width") == "182px"){
				$(this).animate({
						"width":"100%"
				},2000);
			} else {
				$(this).animate({
						"width":"120%"
				},2000);
			}
		});
	});
})();