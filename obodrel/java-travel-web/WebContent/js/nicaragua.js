function httpGetAsync(theUrl, callback) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}

function displayFormRes(evt) {
	var formNica = document.getElementById("formNica");
	var name = formNica["formName"].value;
	var email = formNica["formEmail"].value;
	var number = formNica["formNb"].value;
	var outputRes = "";

	if(name == "") {
		outputRes += "No name entered.\n";
	} else {
		outputRes += "Name : "+name+"\n";
	}
	if(email == "") {
		outputRes += "No email entered.\n";
	} else {
		outputRes += "Email : "+email+"\n";
	}
	if(number == "") {
		outputRes += "No number entered.\n";
	} else {
		outputRes += "Number : "+number+"\n";
	}
	console.log(outputRes);

	alert(outputRes);
	evt.preventDefault();
	//httpGetAsync("./nicaragua.html?formName="+name+"&formEmail="+email+"&formNb="+number+"");
}

function nbTravellers() {
	console.log("nbtravellersClicked");
}

window.onload=OnLoad;

function OnLoad() {
	console.log("loaded");
	document.getElementById("formNica")["formEmail"].addEventListener("click", nbTravellers);
	document.getElementById("formNica").addEventListener("submit", displayFormRes);
}