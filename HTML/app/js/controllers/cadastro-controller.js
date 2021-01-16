angular.module('main').controller('cadastroController', ['$scope', '$rootScope', '$http', '$timeout', '$location', 'cadastroService', function($scope, $rootScope, $http, $timeout, $location, cadastroService) {
    $rootScope.titulo = "Adição de contatos";
    $scope.nome = '';
    $scope.email = '';
    $scope.num = '';

    $scope.cadastrar = function() {
        $scope.data = {
            'nome': $scope.nome,
            'email': $scope.email,
            'numero': $scope.num
        };
        cadastroService.cadastro($scope.data);

    }
    $scope.inicio = function() {
        $location.path("/");
    }

}])