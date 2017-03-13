angular.module("application", [])
	.controller('NigeriaController', NigeriaController);

function NigeriaController() {
	var vm = this;
	vm.registerMessage = "";
	vm.displayInformations = false;
	vm.displayRegister = false;
    vm.offers = [
    {monthNumber : 1 , monthName : "January", seasonDesc : "Dry Season"},
    {monthNumber : 2 , monthName : "February", seasonDesc : "Dry Season"},
    {monthNumber : 3 , monthName : "March", seasonDesc : "Dry Season"},
    {monthNumber : 4 , monthName : "April", seasonDesc : "Rain Season"},
    {monthNumber : 5 , monthName : "May", seasonDesc : "Rain Season"},
    {monthNumber : 6 , monthName : "June", seasonDesc : "Rain Season"},
    {monthNumber : 7 , monthName : "July", seasonDesc : "Rain Season"},
    {monthNumber : 8 , monthName : "August", seasonDesc : "Dry Season"},
    {monthNumber : 9 , monthName : "September", seasonDesc : "Rain Season"},
    {monthNumber : 10 , monthName : "October", seasonDesc : "Rain Season"},
    {monthNumber : 11 , monthName : "November", seasonDesc : "Dry Season"},
    {monthNumber : 12 , monthName : "December", seasonDesc : "Dry Season"}
    ];

    vm.init = init;

    vm.showRegister = showRegister;
    vm.isNotValid = isNotValid;
    vm.checkIfOneIsSet = checkIfOneIsSet;
    vm.isRegisterDisplayed = isRegisterDisplayed;

	function init() {
    	vm.name = "";
    	vm.email = "";
    	vm.isInit = true;
    	vm.offer = undefined;
    }
	function showRegister() {
		if(vm.registerForm.$valid) {
	    	vm.displayRegister = true;
	    	vm.registerMessage= "You have registered as : name = "+vm.name+" and email = "+vm.email + ". You will go between the 1/"+vm.offer.monthNumber+" and the 7/"+vm.offer.monthNumber+".";
	    	vm.init();
		}
    }
    function isNotValid() {
    	var errorArray = [];
//    	console.log(vm.registerForm);
    	for(formChild in vm.registerForm) {
    		if(vm.registerForm[formChild] != undefined && vm.registerForm[formChild].$valid != undefined && vm.registerForm[formChild].$invalid) {
    			errorArray.push(vm.registerForm[formChild].$name);
//    			console.log(vm.registerForm[formChild].$name)
    		}
    	}
//    	console.log(errorArray)
    	if(errorArray.length > 0 ) {
    		vm.displayError = true && !vm.displayRegister;
        	if(errorArray.length > 1 ) {
        		vm.errorMessage = "There are errors on the following fields :";
        		for(error of errorArray) {
        			vm.errorMessage += " ["+error+"] ";
        		}
        	} else {
        		vm.errorMessage = "There is an error on the following field : [" + errorArray[0]+"]";
        	}
    	} else {
    		vm.displayError = false && !vm.displayRegister;
    	}
    	if(vm.registerForm.name.$invalid || vm.email=="" || vm.registerForm.$invalid) {
    		return true;
    	}
    	return false;
    }
    function checkIfOneIsSet() {
    	if(vm.name!="" || vm.email!="") {
    		vm.isInit = false;
    	} else {
    		vm.isInit = true;
    	}
    }
    function isRegisterDisplayed() {
    	vm.checkIfOneIsSet();
    	vm.displayRegister = vm.displayRegister && vm.isInit;
    }

    
	vm.init();
}
