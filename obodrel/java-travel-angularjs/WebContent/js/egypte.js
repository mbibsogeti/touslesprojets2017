var app = angular.module("application", []);

app.controller('EgypteController', function() {
    this.days = 3;
    this.visits = false;
    this.display = false;
    this.show = function() {
    	this.display = !this.display;
    }
    this.trick = function() {
    	this.visits = true;
    }
    this.footer = "./footer.html";
 });