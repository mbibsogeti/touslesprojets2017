/**
 * 
 */
console.log("Costarica.js loaded")
function buttonClicked(){
	var m=document.getElementById("message")
	var nb=document.getElementById("number")
	var n=parseInt(nb.value)
	var total=1080*n
	m.value="Le total est: "+ total+ "€"
}
document.getElementById("button").
addEventListener("click", buttonClicked)