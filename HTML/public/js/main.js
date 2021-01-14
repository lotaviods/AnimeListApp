angular.module("main", ['ngAnimate', 'ngRoute'])
    .config(function($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $routeProvider.when('/', {
            templateUrl: 'partials/principal.html',
            controller: 'principalController'
        });
        $routeProvider.when('/cadastro', {
            templateUrl: 'partials/cadastro.html',
            controller: 'cadastroController'
        })
        $routeProvider.otherwise({
            redirectTo: '/'
        });
    });