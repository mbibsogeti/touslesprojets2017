var app = angular.module("application", []);

app.constant("plane",945).value("hotel",38.29);

app.filter("toCurrency", function(numberFilter) {
	return function(priceInEuro, currencyString, convertRate) {
		return numberFilter((priceInEuro/convertRate),2) + " " +currencyString;
	}
});

app.controller('SenegalController', function(plane, hotel) {
	this.days = 9;
	this.plane = plane;
	this.hotel = hotel;
	this.computePrice = function() {
		return this.days * hotel + plane;
    }
});