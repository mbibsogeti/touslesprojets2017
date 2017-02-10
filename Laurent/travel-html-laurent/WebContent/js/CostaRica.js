/**
 * This file handle backend of the Costa Rica web page
 */

console.log("CostaRica.js loaded")
var button=document.getElementById("button1")
var mess=document.getElementById("message")
var messP=document.getElementById("messP")
var nbT=document.getElementById("nbTravellers")
var t=[45,(7*60+40),(3*60+10),(1*60+20)]
var dic={"Ch. Mitoyenne":3,"Croisière":5,"Spectacle":3,"Souvenir":4}
button.addEventListener("click",buttonClicked)

function buttonClicked(){
	
	var n=parseInt(nbT.value)
	var prix=1080*n
	if((n>50)||(n<1)){
		mess.value="Erreur !!"
	}
	else{
		mess.value=""
		mess.value="Demande envoyée, il"+((n>1)?" y aura "+n+" voyageur(s) pour votre demande. ":" n'y aura que vous pour ce voyage. ")
		mess.value+="Le prix sera donc de "+prix+"€."
		if(n>5){
			mess.value +=" Veuillez faire votre demande par email svp";
		}
		mess.value+=" ("
		for (var i=n; i>2; i-=3){
			mess.value+=" chambre triple"
			if(i>4) mess.value+=", ";
			n%=3
		}
		for (var i=n; i>1; i-=2){
			mess.value+=" chambre double"
			if(i>3) mess.value+=", ";
			n%=2
		}
		
		if(nbT.value==1){ mess.value+=" chambre simple "}
		else{if(n==1) mess.value+=", chambre simple ";}
		mess.value+=" )"
	}

	var tempsTotal=0;
	var tpsH=0
	var tpsM=0
	for(var x in t){
		tempsTotal+=40+t[x]
	}
	mess.value+=". Temps de trajet total : "+parseInt(tempsTotal/60)+" heures et "+tempsTotal%60+" mins";
	
	console.log(nbT.value)
	if(parseInt(nbT.value)>=3) mess.value+=". Options disponibles :";
	
	for(var k in dic){
		if(dic[k]<=parseInt(nbT.value)){
			mess.value+=k+" "
			mess.value+=", "
		}
	}
	
}