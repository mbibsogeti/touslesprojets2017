document.body.childNodes[1].childNodes[5].childNodes[1].innerHTML="Vos voyages"

document.querySelector("section:last-of-type>h2").innerHTML+="!"
document.querySelector("section:nth-of-type(3)>h2").innerHTML+="!"

//var liste=document.querySelectorAll("h2");
var oldP=null;
//for(var i in liste){
//	console.log(i)
//	if(parseInt(i)){
//		liste[i].addEventListener("click", beClicked);
//	}
//}

if (!localStorage.deja){
	localStorage.deja=true;
	alert("cliquez pour refermer svp");
}

function beClicked(){
	
//	var listeSection=this.parentNode.parentNode.querySelectorAll("section");
//	var p=this.parentNode.querySelector("p");
//	for (var l in listeSection){
//		if(this == listeSection[l].querySelector("h2")){
//			if(p.style.display=="none"){
//				p.style.display="block";
//			}else{
//				p.style.display="none";
//			}
//		}else{
//			p = listeSection[l].querySelector("p");
//			p.style.display="none";
//		}
//	}
	// Teacher answer !!
	p.style.display="block";
	if(oldP!=null)
		oldP.style.display="none";
	oldP=p
}

var blue=0;

function showTps(){
	var tps=[17,19,20,23,27,31,32,33,31,25,19,15]
	var ctx=document.querySelector("canvas").getContext("2d");
	for(var i in tps){
		ctx.fillStyle= "rgb(100,"+(250-tps[i]*7)+","+(blue%200)+")";
		ctx.fillRect(i*80+20,1000-tps[i]*30,75,1000)		
	}
	blue+=5;
}

setInterval(showTps,50);