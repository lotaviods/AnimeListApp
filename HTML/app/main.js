angular.module("main", ['ngAnimate', 'ngRoute'])
    .config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
        $locationProvider.html5Mode(true);
        $routeProvider.when('/', {
            templateUrl: 'partials/principal.html',
            controller: 'principalController'
        });
        $routeProvider.when('/cadastro', {
            templateUrl: 'partials/cadastroForm.html',
            controller: 'cadastroController'
        });
        $routeProvider.when('/edita/:id', {
            templateUrl: 'partials/editaForm.html',
            controller: 'editaController'
        });
        $routeProvider.otherwise({
            redirectTo: '/'
        });


    }]);