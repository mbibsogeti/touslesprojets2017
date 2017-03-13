angular.module("application")
	.config(SouthAfricaRouteProvider)


function SouthAfricaRouteProvider($routeProvider) {
	$routeProvider
	.when('/index', {
			controller: 'SouthAfricaController',
			controllerAs: 'vm',
			template: function() {
				return "<p>We propose SSSd</p>";
			}
		})
		.when('/destinations', {
			controller: 'SouthAfricaController',
			controllerAs: 'vm',
			templateUrl : './southafrica/destinations.jsp'
		})
		.when('/destinations/:id', {
			controller: 'SouthAfricaController',
			controllerAs: 'vm',
			templateUrl : './southafrica/information.jsp'
		})
		.otherwise({redirectTo : "/index"});
}

