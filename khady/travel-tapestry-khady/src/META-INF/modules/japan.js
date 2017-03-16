(function(){/*cette ligne définit que ce qui est dans cette f° est isolé c.a.d que c'est propre à ce fichier japan.js */
define(["jquery"],function($){/*cette ligne définit le code module. Le symbole '$' veut dire jquery */
console.log("japan.js loaded !")	
/*$("section>a").animate({"margin-left":"400px"})cette ligne utilise la f° animate de jquery on peut utiliser css à la place de animate */
$("section>a").on("click", function(){
	$(this).animate({"margin-left":"400px"})/*ici c seulement qd on clique sur un élémt que celui-ci est décalé vers la droite*/
})
	
	
	
	
	
})		
})()/* les parenthèses () veulent dire dès que la fonction est construite, on l'appelle de suite*/




