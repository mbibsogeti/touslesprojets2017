/**
 * 
 */

// document.body.innerHTML="H4CK3D"
// document.body.childNodes[1].innerHTML="H4CK3D";
document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Tus viajes";
document.querySelector("section:nth-of-type(3) h2").innerHTML += "H4CK3D"

var oldp = null;

var h = document.querySelectorAll("body h2");
for (var i = 0; i < h.length; i++) {
	// h[i].onclick = functison() {
	// alert('Alerte!!')
	h[i].addEventListener('click', function() {
		var p = this.parentNode.querySelector("p");

		// alert(p.innerHTML)
		p.style.display = "block";

		if (oldp != null) {
			oldp.style.display = "none"
		}
		oldp = p;

		if (!sessionStorage.deja) {
			sessionStorage.deja = true;
			alert("cliquez pour refermer");
		}
	})
}
var blue = 0;
function showTps() {
	var tmp = [ 0, 5, 12, 19, 25, 31, 35, 30, 26, 22, 15, 10 ];
	var ctx = document.querySelector("canvas").getContext("2d");
	for ( var i in tmp) {
		ctx.fillStyle = "rgb(255," + (250 - tmp[i] * 7) + ","+(blue%200)+")"
		ctx.fillRect(i * 80 + 20, 1000 - tmp[i] * 30, 75, tmp[i] * 30);
	}
	blue+=5;
}
setInterval(showTps,20);