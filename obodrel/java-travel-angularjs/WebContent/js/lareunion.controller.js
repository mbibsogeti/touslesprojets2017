angular.module("application")
	.controller("LaReunionController", ["$http", LaReunionController]);

function LaReunionController($http) {
	var vm = this;
    vm.informationsMessage = "";
    vm.errorMessage = "";
    vm.displayInformations = false;
    vm.displayError = false;
	
    vm.init = init;
    
    vm.showInformations = showInformations;
    vm.isNotValid = isNotValid;
    vm.checkIfOneIsSet = checkIfOneIsSet;
    vm.isInformationsDisplayed = isInformationsDisplayed;

	function init() {
        vm.name = "";
        vm.email = "";
        vm.isInit = true;
	}

	function showInformations() {
		if(vm.myForm.$valid) {
	    	vm.displayInformations = true;
	    	vm.informationsMessage = "Wait for the server to manage your request";

	        $http.post("./lareunionres/",
	        		"name="+vm.name+"&email="+vm.email,
	        		{headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then(showPostRes);
	    	vm.init();
		}
    }
	
	function showPostRes() {
		vm.informationsMessage = "Registration Ok ™";
	}
	
    function isNotValid() {
    	var errorArray = [];
    	for(formChild in vm.myForm) {
    		if(vm.myForm[formChild] != undefined && vm.myForm[formChild].$valid != undefined && vm.myForm[formChild].$invalid) {
    			errorArray.push(vm.myForm[formChild].$name);
    		}
    	}
    	if(errorArray.length > 0 ) {
    		vm.displayError = true && !vm.displayInformations;
        	if(errorArray.length > 1 ) {
        		vm.errorMessage = "There are errors on the following fields :";
        		for(error of errorArray) {
        			vm.errorMessage += " ["+error+"] ";
        		}
        	} else {
        		vm.errorMessage = "There is an error on the following field : [" + errorArray[0]+"]";
        	}
    	} else {
    		vm.displayError = false && !vm.displayInformation;
    	}
    	if(vm.myForm.name.$invalid || vm.email=="" || vm.myForm.$invalid) {
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
    function isInformationsDisplayed() {
    	vm.checkIfOneIsSet();
    	vm.displayInformations = vm.displayInformations && vm.isInit;
    }
    
	vm.init();
}
