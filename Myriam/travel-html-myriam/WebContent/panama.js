/**
 * 
 */

document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos voyages"
document.querySelector("section:last-of-type h2").innerHTML += "!"

var pp = document.querySelector("p")

function onclick() {
	var p = this.parentNode.querySelector("p")
	p.style.display = "block"
	pp.style.display = "none"
	pp = p
	/* alert(p.innerHTML) */
}

var l = document.querySelectorAll("h2")

for (var i = 0; i < l.length; i++) {
	l[i].addEventListener("click", onclick)
}

if (!localStorage.deja) {
	localStorage.deja = true
	alert("cliquer pour refermer")
}
var blue = 0

function showTps() {

	var tps = [ 17, 19, 20, 23, 27, 31, 28, 25, 22, 19, 19, 18 ]
	var ctx = document.querySelector("canvas").getContext("2d")

	for ( var i in tps) {
		ctx.fillStyle = "rgb(255," + (250 - tps[i] * 7) + "," + (blue % 200)
				+ ")"
		ctx.fillRect(i * 80 + 20, 1000 - tps[i] * 30, 75, tps[i] * 30)
	}
	blue += 5
}
setInterval(showTps,20)
