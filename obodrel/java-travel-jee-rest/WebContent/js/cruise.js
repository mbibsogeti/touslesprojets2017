window.onload = onLoadInit;

function onLoadInit() {
	document.getElementById("dlNow").addEventListener("click",dlCruiseCSV);
	document.getElementById("dlSpec").addEventListener("click",dlCruiseCSVSpec);
}

function dlCruiseCSV(evt) {
	document.location = "./cruiseCSV";
}
function dlCruiseCSVSpec(evt) {
	document.location = "./cruiseCSV/"+document.getElementById("nbCruise").value;
}