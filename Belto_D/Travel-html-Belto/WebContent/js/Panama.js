/**
 * 
 */
console.log("Panama.js loaded")
document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos voyages";
/* Selectionner le dernier h2 pour le changer en ajoutant "!" */
document.querySelector("section:last-of-type h2").innerHTML += "!"
/* Selectionner tous les h2 */
var l = document.querySelectorAll("h2")
for (var i = 0; i < l.length; i++)
	l[i].addEventListener("click", h2clicked) /*
												 * afficher une alerte quand on
												 * click sur h2, on aurait pu
												 * faire onclick (ancien) aussi
												 */
/* faire une apparaitre les paragraphes quand on click */
function h2clicked() {
		var p=this.parentNode.querySelector("p");
	/* Si on click cela apparait ou disparait, on (old p)*/
	if (p.style.display=="none"){
	     p.style.display="block"}
	     else
    p.style.display="none";
	if(!localStorage.deja){
		localStorage.deja=true
		alert("cliquez pour refermer")
	}
	}
var blue=0;
function showTps(){
var tps=[17,19,20,23,27,31,32,35,33,30,21,15]
var ctx=document.querySelector("canvas").getContext("2d")
for(var i in tps){
	ctx.fillStyle="rgb(255,"+(250-tps[i]*7)+","+(blue%200)+")"//ajoute du bleu
	ctx.fillRect(i*80+20,1000-tps[i]*30,75,tps[i]*30)
}
blue+=5
}
//animation avec le bleu, toute les 20minisecondes//
setInterval(showTps,200)