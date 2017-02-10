document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos voyages"

document.body.childNodes[1].childNodes[7].querySelector("h2").innerHTML = "Quand y aller ?!"

var l = document.querySelectorAll("h2")
var oldl = null
	for (var i = 0; i < l.length; i++){
		l[i].addEventListener("click", function() {
			var p = this.parentNode.querySelector("p, table")
			p.style.display = "block"
			if (oldl != null)
				oldl.style.display = "none"
			oldl = p
			if(!localStorage.deja){
				localStorage.deja=true
				alert("Cliquez pour refermer")
			}
		})
	}

var blue =0;

function showTps(){
	var tps = [17,19,20,23,27,31,31,35,15,14,10,9]
	var ctx = document.querySelector("canvas").getContext("2d")
	for (var i in tps){
		ctx.fillStyle = "rgb(255,"+(250-tps[i]*7)+","+(blue%200)+")"
		ctx.fillRect(i*80+20,1000-tps[i]*30,75,tps[i]*30)
	}
	blue+=5
}
setInterval(showTps,100)