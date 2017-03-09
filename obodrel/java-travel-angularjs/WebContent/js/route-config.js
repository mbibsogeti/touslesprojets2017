angular
    .module('app')
    .config(config);

function config($routeProvider) {
    $routeProvider
        .when('/ghana/', {
            templateUrl: 'ghana.jsp',
            controller: 'GhanaController',
            controllerAs: 'vm'
        });
}