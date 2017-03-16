/**
 * 
 */
//Crée une fonction qui s'appelle elle-mm
(function(){
	//Définition du module AMD correspondant au fichier JS
	define(["jquery"],function($){
		console.log("Japan is alive !!");
		//Animation de l'élément sélectionné dès le lancement
		//$("section .btn").animate({"margin-left":"400px"},1000);
		
		//Animation de l'élément suivant un évènement
		$("div>a").on("click",function(){
			console.log("in the move !")
			$(this).animate({"margin-left":"400px","background-color":"black"},1000)
		})
	})
})()