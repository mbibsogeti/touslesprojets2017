function displayNicaFormRes(evt) {
	var formNica = document.getElementById("formNica");
	var name = formNica["formName"].value;
	var email = formNica["formEmail"].value;
	var number = formNica["formNb"].value;
	var outputRes = "";

	evt.preventDefault();

	outputRes = "Request granted for " + name
			+ "! You have registered using this email " + email
			+ ", and you will be " + number
			+ " to travel! Thanks for trying us!";
	if (name == "" || email == "" || number == 0) {
		outputRes = "You forgot to give us an information, your registrations has failed. Please retry!";
	}

	var formRes = document.getElementById("formRes");
	var content = document.createElement("p");
	content.appendChild(document.createTextNode(outputRes));
	if (formRes.hasChildNodes()) {
		formRes.removeChild(formRes.firstChild);
	}
	formRes.appendChild(content);
	content.setAttribute("id", "outputRes");
	formNica["formNb"].value = 0;
}

function nbTravellers(evt) {
	console.log("nbtravellersClicked");
}

function displayCostaRicaEstimation(evt) {
	if (evt.type == "click" || (evt.type == "keydown" && evt.key == "Enter")) {
		var outputStr = "";
		var nbTravellers = parseInt(document.getElementById("estimateNb").value);
		var pricePerTravellers = 1080;
		var totalPrice = 0;
		var costaRicaEstimateOutput = document.getElementById("outputCoRi");
		var content = document.createElement("p");
		var chooseCori = document.getElementById("chooseCoRi");
		var isError;
		var travelDurationStr;
		var bonusAvailableStr;

		if (nbTravellers <= 0 || nbTravellers > 50 || isNaN(nbTravellers)) {
			isError = true;
			outputStr = "*Please enter a number between 1 and 50!";
		} else if (nbTravellers > 5) {
			isError = false
			outputStr = "You want to travel more than 5 days, please contact us!";
		} else {
			isError = false;
			totalPrice = pricePerTravellers * nbTravellers;
			outputStr = "Request Sent, it will cost you " + totalPrice
					+ "€ to travel to Costa Rica!";

			var divide = parseInt(nbTravellers / 2);
			var left = nbTravellers % 2;

			var tmpStr = "(";
			for (i = 0; i < divide; i++) {
				if (i != 0) {
					tmpStr += ", ";
				}
				tmpStr += "one double room";
			}
			if (left != 0) {
				if (divide != 0) {
					tmpStr += ", ";
				}
				tmpStr += "one simple room"
			}
			tmpStr += ").\n";

			outputStr += " " + tmpStr;
		}

		travelDurationStr = computeTravelDuration(costaRicaTravelStepArray);
		bonusAvailableStr = costaRicaBonusOptions.computeBonusAvailable(nbTravellers);

		if (isError) {
			content.appendChild(document.createTextNode(outputStr));
			if (costaRicaEstimateOutput.hasChildNodes()) {
				while (costaRicaEstimateOutput.firstChild) {
					costaRicaEstimateOutput
							.removeChild(costaRicaEstimateOutput.firstChild);
				}
			}
			if (chooseCori.hasChildNodes()) {
				chooseCori.removeChild(chooseCori.firstChild);
			}
			chooseCori.appendChild(content);
		} else {
			content.appendChild(document.createTextNode(outputStr));
			if (costaRicaEstimateOutput.hasChildNodes()) {
				while (costaRicaEstimateOutput.firstChild) {
					costaRicaEstimateOutput
							.removeChild(costaRicaEstimateOutput.firstChild);
				}
			}
			if (chooseCori.hasChildNodes()) {
				chooseCori.removeChild(chooseCori.firstChild);
			}
			costaRicaEstimateOutput.appendChild(content);
			if (travelDurationStr != "") {
				content.appendChild(document.createElement("br"));
				content.appendChild(document.createTextNode(travelDurationStr));
			}
			if (bonusAvailableStr != "") {
				content.appendChild(document.createElement("br"));
				content.appendChild(document.createTextNode(bonusAvailableStr));
			}
		}
	}
}

var costaRicaTravelStepArray = [ [ "Bus", 0, 45 ], [ "Los Angeles", 7, 40 ],
		[ "San Jose", 3, 10 ], [ "Bus", 1, 20 ] ];

function computeTravelDuration(stepArray) {
	var retStr = "Your travel will follow these steps : ";
	var retTime = 0;
	for (i = 0; i < stepArray.length; i++) {
		if (i != 0) {
			retStr += ", ";
		}
		retStr += stepArray[i][0] + " for ";
		if (stepArray[i][1] != 0) {
			retStr += stepArray[i][1] + " hours and ";
		}
		if (stepArray[i][2] != 0) {
			retStr += stepArray[i][2] + " minutes";
		}
		retTime += stepArray[i][1] * 60 + stepArray[i][2];
		retTime += 40;
	}

	retStr += " with 40minutes stop for each steps, lasting "
			+ parseInt(retTime / 60) + " hours and " + retTime % 60
			+ " minutes in total.";

	return retStr;
}

var costaRicaBonusOptions = { _bonnusArray : [ {
	bonus : "Nextdoor Rooms",
	condition : 3
}, {
	bonus : "Cruise",
	condition : 5
}, {
	bonus : "Show",
	condition : 3
}, {
	bonus : "Souvenirs",
	condition : 4
} ]
};

function computeBonusAvailable(nbTravellers, bonusOptionsArray) {
	var retStr = "Due to your high number of travellers you will participate in these activities : ";
	var hasAddedOneAlready = false;
	if(bonusOptionsArray == undefined) {
		if(this == undefined) {
			return "Error";
		}
		bonusOptionsArray = this._bonnusArray;
	}
	for(var option of bonusOptionsArray) {
		if(nbTravellers >= option.condition) {
			if(hasAddedOneAlready) {
				retStr += ", "
			}
			retStr += option.bonus;
			hasAddedOneAlready = true;
		}
	}
	if(!hasAddedOneAlready) {
		return "";
	}
	retStr += ".";
	return retStr;
}

costaRicaBonusOptions.computeBonusAvailable = computeBonusAvailable;


var temperatureArrayCostaRica = [17,19,20,23,27,31,30,35,29,22,18,13];

var blueForCanvarCostaRica = 0;

function fillTemperatureInCanvas() {
	fillTemperatureInCanvasCR(temperatureArrayCostaRica);
}

function fillTemperatureInCanvasCR(temperatureArray) {
	var canvasLinkContext = document.querySelector("canvas").getContext("2d");

	for(var temperature in temperatureArray) {
		canvasLinkContext.fillStyle = "rgb(255,"+(250-temperatureArray[temperature]*7)+","+blueForCanvarCostaRica%200+")";
		canvasLinkContext.fillRect(temperature*40+10,500-temperatureArray[temperature]*15,38,temperatureArray[temperature]*150);
	}
	blueForCanvarCostaRica +=5;

}

setInterval(fillTemperatureInCanvas,200);