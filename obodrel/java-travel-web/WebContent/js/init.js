window.onload = onLoadInit;
var body;
var CURRENT_CONTENT_NEEDED = "haiti";
var indexRule = null;
var currentSection = null;

function onLoadInit() {
	body = document.getElementById("body");
	var path = document.documentURI;
	var pageName = path.split("/").pop();

	switch (pageName) {
	case "nicaragua.html":
		document.getElementById("formNica")["formNb"].addEventListener("click",
				nbTravellers);
		document.getElementById("formNica").addEventListener("submit",
				displayNicaFormRes);
		break;
	case "costarica.html":
		document.getElementById("estimateBtn").addEventListener("click",
				displayCostaRicaEstimation);
		break;
	case "index.html":
		currentSection = document.querySelector("#homeContent");
		currentSection.style.display = "block";
		for(element of document.getElementsByClassName("countryBtn")) {
			element.addEventListener("click",displayCurrentContent);
		}
		document.getElementById("formNica")["formNb"].addEventListener("click",
				nbTravellers);
		document.getElementById("formNica").addEventListener("submit",
				displayNicaFormRes);
		document.getElementById("estimateBtn").addEventListener("click",
				displayCostaRicaEstimation);
		document.getElementById("estimateNb").addEventListener("keydown",
				displayCostaRicaEstimation);
		document.getElementById("panamaCountry").addEventListener("click",
				displayPanamaAccordionContent);
		document.getElementById("panamaTrips").addEventListener("click",
				displayPanamaAccordionContent);
		document.getElementById("panamaProg").addEventListener("click",
				displayPanamaAccordionContent);
		displaySectionByName(CURRENT_CONTENT_NEEDED);
		document.addEventListener("scroll",makeMenuTopFixed);
	}
}

function makeMenuTopFixed(evt) {
	if(evt.type  == "scroll" && document.body.scrollTop > 125) {
		document.getElementById("menuTravel").className = "fixedMenu";
	} else {
		document.getElementById("menuTravel").className = "absoluteMenu";
	}
}

function displayCurrentContent(evt) {
	console.log(evt.target)
	var btnClicked = evt.target.getAttribute("id");
	btnClicked = btnClicked.substring(3); 
	displaySectionByName(btnClicked);
}

function displaySectionByName(sectionName) {
	var isCurrentSection = false;
	console.log(sectionName)
	currentSection.style.display = "none";
	currentSection = document.querySelector("#"+sectionName.toLowerCase()+"Content");
	currentSection.style.display = "block";
}

function displayPanamaAccordionContent(evt) {
	var btnClicked = evt.target.getAttribute("id"); 
	var currentH3 = document.querySelector("div#panamaContent h3#"+btnClicked);
	var currentP = currentH3.parentNode.parentNode.getElementsByTagName("p")[0];
	var currentStyle = currentP.style.maxHeight;
	var currentH3After = document.querySelector("div#panamaContent h3#"+btnClicked, ":after");
	if(currentStyle == "0px" || currentStyle == "") {
		currentP.style.maxHeight = currentP.scrollHeight+"px";
		currentP.style.marginTop = "25px";
		currentP.style.marginBottom = "25px";
		currentH3.style.backgroundColor = "#bbeebb";
		currentH3.className = "minus";
	} else {
		currentP.style.margin = "0";
		currentP.style.maxHeight = "0";
		currentH3.style.backgroundColor = "#bbee99";
		currentH3.className = "plus";
	}
} 

if(!localStorage.hasAlreadyVisited) {
	localStorage.hasAlreadyVisited = true;
	alert("Congratulations, you made your first visit here!");
}