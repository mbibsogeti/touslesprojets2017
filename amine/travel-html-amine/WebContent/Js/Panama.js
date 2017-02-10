/**
 * 
 */
console.log("Panama.js loaded")
// document.body.childNodes[1].innerHTML="H4CK3D"
document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML = "Vos Voyages"
document.querySelector("section:last-of-type h2").innerHTML += "!"

/*
 * var l = document.querySelectorAll("h2") for (var i = 0; i < l.length; i++) {
 * l[i].innerHTML = "" }
 */
var l = document.querySelectorAll("h2")
var oldP = null
for (var i = 0; i < l.length; i++) {
	l[i].addEventListener("click", function() {
		var p = this.parentNode.querySelector("p")
		// alert("!")
		// alert(p.innerHTML)
		// p.style.display="block"
		
		p.style.display = 'block';
		if (oldP !== null) {
			oldP.style.display = "none"
		}
		oldP = p
	})
}
