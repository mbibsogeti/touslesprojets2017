angular.module("application")
	.controller("SouthAfricaController", ["$routeParams","destinationsArray", SouthAfricaController]);

function SouthAfricaController($routeParams, destinationsArray) {
	var vm = this;
	
	vm.destinationsArray = destinationsArray;

    vm.init = init;
	vm.setDestinationById = setDestinationById;
	vm.id = $routeParams.id;

	function init() {
		vm.setDestinationById(0);
    }
	function setDestinationById() {
		for(dest of vm.destinationsArray) {
			if(dest.id == vm.id) {
				vm.currDestination = dest;
				return true;
			}
		}
		return false;
    }
    
	vm.init();
}
