<!-- Structure d'un module -->
<!-- 1er fonction definit le module -->
<!-- la seconde est celui qui sera executer -->
(function (){
define(["jquery"], function($){
console.log("japan.js loaded!")
$("section>a").on("click",function(){
$(this).animate({"margin-left":"700px"})
})
})
})()