angular.module("application", [])
	.controller('GhanaController', GhanaController);

function GhanaController() {
	var vm = this;
	vm.registerMessage = "";
	vm.displayInformations = false;
	vm.displayRegister = false;

    vm.init = init;

    vm.showInformations = showInformations;
    vm.showRegister = showRegister;
    vm.isOneEmpty = isOneEmpty;
    vm.checkIfOneIsSet = checkIfOneIsSet;
    vm.isRegisterDisplayed = isRegisterDisplayed;

	function init() {
    	vm.name = "";
    	vm.tel = "";
    	vm.message = "";
    	vm.isInit = true;
    }
    function showInformations() {
    	vm.displayInformations = !vm.displayInformations;
    	vm.displayRegister = false;
    }
	function showRegister() {
    	vm.displayRegister = true;
    	vm.displayInformations = false;
    	vm.registerMessage= "You have registered as : name = "+vm.name+" and tel = "+vm.tel;
    	vm.init();
    }
    function isOneEmpty() {
    	if(vm.name=="" || vm.tel=="" || vm.message=="") {
    		return true;
    	}
    	return false;
    }
    function checkIfOneIsSet() {
    	if(vm.name!="" || vm.tel!="" || vm.message!="") {
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
