/*document.body.childNodes[1].innerHTML="H4CK3D"*//* est une opération du DOM qui va permettre de remplacer le contenu de notre page HTML par "H4CK3D" et avec childNodes[1] on récupère l'enfant qui a l'indice 1 et ici c le div qui est à cette position */
document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos voyages"
/* document.getElementById().innerHTML=document.getElementByTagName()=document.getElementByClassName() */
document.querySelector("section:last-of-type h2").innerHTML += "!"/*
																	 * permet
																	 * d'ajouter
																	 * "!" à la
																	 * fin du
																	 * titre de
																	 * la
																	 * dernière
																	 * section
																	 */
var l = document.querySelectorAll("h2")
var oldp = null
for (var i = 0; i < l.length; i++){ 
	l[i].addEventListener("click", function() {/*
												 * la function alert permet
												 * d'afficher une alerte quand
												 * on clique sur les titres de
												 * type h2
												 */
		/* alert("click on <..h2..>"); */
		var p = this.parentNode.querySelector("p")
		/* alert(p.innerHTML); */
		p.style.display = "block"
		if (oldp != null)
			oldp.style.display = "none";
		oldp = p

		if (!localStorage.deja) {
			localStorage.deja = true
			alert("cliquez pour refermer")
		}

	})
}

var blue = 0
function showTemp(){
	var temp=[17, 19, 20, 23, 27, 31, 15, 17, 15, 14, 12, 20]
	var ctx=document.querySelector("canvas").getContext("2d")
	for(var i in temp){
		ctx.fillStyle="rgb(255,"+(250-temp[i]*7)+","+(blue%200)+")"
		ctx.fillRect(i*80+20,1000-temp[i]*30,75,temp[i]*30)
	}
	blue+=5
}

setInterval(showTemp, 20)






