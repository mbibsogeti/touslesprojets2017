window.onload = onLoadInit;
var body;
var CURRENT_CONTENT_NEEDED = "barbade";
var indexRule = null;
var currentSection = null;
var isMenuDisplayed = false;

function onLoadInit() {
	body = document.getElementById("body");
	var path = document.documentURI;
	console.log(path)
	var pageName = path.split("/").pop();
	console.log(pageName)
	pageName = pageName.split("#").shift();
	pageName = pageName.split("?").shift();

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
		 initRoot();
		 break;
	case "":
		 initRoot();
		 break;
	}
}

function initRoot() {
		currentSection = document.querySelector("#homeContent");
		currentSection.style.display = "block";
		for(element of document.getElementsByClassName("countryBtn")) {
			element.addEventListener("click",displayCurrentContent);
		}
		for(element of document.getElementsByClassName("goUpBtn")) {
			element.addEventListener("click",setScrollToTop);
		}
		document.getElementById("countryLiRoller").addEventListener("click",
				displayMenu);
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
		document.getElementById("submitMartinique").addEventListener("click",displaySearchAside);
	
}

function displaySearchAside(evt) {
	if(document.getElementById("searchPanel").style.display == "none" 
		|| document.getElementById("searchPanel").style.display == "") {
		document.getElementById("searchPanel").style.display = "block";
	}
}

function setScrollToTop(evt) {
	window.scrollTo(0,0);
	document.getElementById("lastOfPage").style.display = "none";
}

function makeMenuTopFixed(evt) {
	if(evt.type  == "scroll" && document.body.scrollTop > 125) {
		document.getElementById("menuTravel").className = "fixedMenu";
	} else {
		document.getElementById("menuTravel").className = "absoluteMenu";
	}
	document.getElementById("lastOfPage").style.top = window.innerHeight/100*85+"px";
	if(evt.type  == "scroll" && document.body.scrollTop > 0) {
		document.getElementById("lastOfPage").style.display = "block";
	}
	else { 
		document.getElementById("lastOfPage").style.display = "none";
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
		currentH3.style.backgroundColor = "#E07400";
		currentH3.className = "minus";
	} else {
		currentP.style.margin = "0";
		currentP.style.maxHeight = "0";
		currentH3.style.backgroundColor = "#000000";
		currentH3.className = "plus";
	}
} 

function displayMenu(evt) {
	var menuUL = document.querySelector("div#menuTravel ul");
	var rollerUL = document.querySelector("div#menuTravel div#countryLiRoller");
	if(!isMenuDisplayed) {
		menuUL.style.maxHeight = menuUL.scrollHeight+"px";
		rollerUL.textContent = "▼";
	} else {
		rollerUL.textContent = "►";
		menuUL.style.maxHeight = "0px";
	}
	isMenuDisplayed = !isMenuDisplayed;
}

if(!localStorage.hasAlreadyVisited) {
	localStorage.hasAlreadyVisited = true;
	alert("Congratulations, you made your first visit here!");
}