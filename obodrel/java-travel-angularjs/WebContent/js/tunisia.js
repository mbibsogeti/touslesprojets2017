var app = angular.module("application", []);

app.controller('TunisiaController', function() {
    this.valueArray = [1,2,3,4];
    this.daysByLocation = [{location:"Tunis",days:2},{location:"Constantine",days:3},{location:"Jerba",days:6},{location:"Zouwarah",days:2}];
});