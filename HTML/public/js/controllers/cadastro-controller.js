angular.module('main').controller('cadastroController', function($scope, $http, $timeout, $location) {

    $scope.titulo = "Adição de contatos";
    $scope.message = "";

    $scope.nome = 'luiz';
    $scope.email = 'l.otavio9099@gmail.com';
    $scope.num = 147788775454;

    $scope.data = {
        'nome': $scope.nome,
        'email': $scope.email,
        'numero': $scope.num
    };
    $scope.cadastrar = function() {
        $http.post('http://localhost:8080/api/contatos/', $scope.data).success(res => {
            console.log(res);
        }).error(res => {
            console.log(res);
        })
    }
    $scope.inicio = function() {
        $location.path("/");
    }
});