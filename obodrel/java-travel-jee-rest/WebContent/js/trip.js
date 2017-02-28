window.onload = onLoadInit;

function onLoadInit() {
	document.getElementById("bestTrip").addEventListener("click",showBest);
	document.getElementById("allTrips").addEventListener("click",showAll);
	document.getElementById("specTrip").addEventListener("click",showSpec);

	httpGetAsync("./jersey/trips/list", fillInTestTable)
}

function showBest(evt) {
	var win = window.open("./jersey/trips/bestvalue", '_blank');
	win.focus();
}
function showAll(evt) {
	var win = window.open("./jersey/trips/list", '_blank');
	win.focus();
}
function showSpec(evt) {
	var win = window.open("./jersey/trips/list/"+document.getElementById("nbTrip").value, '_blank');
	win.focus();
}

function httpGetAsync(theUrl, callback)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}

function fillInTestTable(responseText) {
	/*
	var str = "";
	*/
	var table = document.getElementById("exTable");
	var tHead = document.createElement("thead");
	var trHead = document.createElement("tr");
	var th1Head = document.createElement("th");
	var th2Head = document.createElement("th");

	var jsonResponse = JSON.parse(responseText);

	var tBody = document.createElement("tbody");

	th1Head.appendChild(document.createTextNode("Destination"));
	th2Head.appendChild(document.createTextNode("Dangerosity"));
	trHead.appendChild(th1Head);
	trHead.appendChild(th2Head);

	tHead.appendChild(trHead);

	/*
	str += "<thead><tr><th>Destination</th><th>Dangerosity</th></tr></thead><tbody>";"
	*/

	for(var i=0;i<jsonResponse.length;i++) {
		var currTr = document.createElement("tr");
		var currTd1 = document.createElement("td");
		var currTd2 = document.createElement("td");
		currTd1.appendChild(document.createTextNode(jsonResponse[i].location));
		currTd2.appendChild(document.createTextNode(jsonResponse[i].dangerosity));
		currTr.appendChild(currTd1);
		currTr.appendChild(currTd2);
		tBody.appendChild(currTr);
		/*
		str += "<tr><td>jsonResponse[i].location</td><td>jsonResponse[i].dangerosity</td></tr>;"
		*/
	}

	/*
	str += "</tbody>":
	table.innerHTML = str
	*/

	table.appendChild(tHead);
	table.appendChild(tBody);
}