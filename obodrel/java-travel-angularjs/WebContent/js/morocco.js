var app = angular.module("application", []);
//
//app.controller("controller", function($scope) {
//    $scope.name = "Obodrel";
//    $scope.email = "reynald.pereira@gmail.com";
//    $scope.morrocoHeadImage = "http://dsphotographic.com/blog/wp-content/uploads/morocco-01.jpg";
//});

app.controller('MoroccoController', function() {
    this.name = "?";
    this.email = "?";
    this.morrocoHeadImage = "http://dsphotographic.com/blog/wp-content/uploads/morocco-01.jpg";
    this.isNameSet = function(){
    	if (this.name.trim() == "?" || this.name.trim() == "") {
    		return false;
    	}
    	return true;
    }
    this.isEmailSet = function(){
    	if (this.email.trim() == "?" || this.email.trim() == "") {
    		return false;
    	}
    	return true;
    }
    this.areNameAndEmailSet = function(){
    	if (this.isEmailSet() && this.isNameSet()) {
    		return true;
    	}
    	return false;
    }
    this.isNothingSet = function(){
    	if (!this.isEmailSet() && !this.isNameSet()) {
    		return true;
    	}
    	return false;
    }
});