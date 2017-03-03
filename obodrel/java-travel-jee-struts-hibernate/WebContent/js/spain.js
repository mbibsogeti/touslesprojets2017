window.onload = onLoadInit;

function onLoadInit() {
	if(document.getElementById("specMonument") != null) {
		document.getElementById("specMonument").addEventListener("click",showMonument);
	} else if (document.getElementById("tableMonuments") != null) {
		for(element of document.getElementsByClassName("monumentLink")) {
			element.addEventListener("click",displayMonumentById);
		}
	}
}

function showMonument(evt) {
    postRequest("./spain/byId",{"id":document.getElementById("monumentId").value});
}

function displayMonumentById(evt) {
	var id = -1;
	var currentTDs = evt.target.parentNode.parentNode.getElementsByTagName("td");
	console.log(currentTDs);
	for(oneTD of currentTDs) {
		var indexID = oneTD.getAttribute("id").toLowerCase().indexOf("monumentid");
		if(indexID!== -1) {
			id = oneTD.getAttribute("id").substring(indexID+"monumentid".length);
		}
	}
	postRequest("./spain/byId",{"id":id});
}