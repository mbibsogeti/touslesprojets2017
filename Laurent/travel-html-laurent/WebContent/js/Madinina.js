var button = document.getElementById("searchButton");
var panel1 = document.getElementById("waitPanel");
var panel2 = document.getElementById("resultPanel");
var defPanel = document.getElementById("searchPanel");

button.addEventListener("click", buttonClicked);

function buttonClicked(){
	//var i=30;
	defPanel.style.display="block";
	panel1.style.display="block"
	panel2.style.display="none";
	setTimeout(function(){panel1.style.display="none"
		panel2.style.display="block";},1000);
	
	
}