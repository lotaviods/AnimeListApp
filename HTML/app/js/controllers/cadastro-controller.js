angular.module('main').controller('cadastroController', ['$scope', '$rootScope', '$location', 'cadastroService', function($scope, $rootScope, $location, cadastroService) {
    $rootScope.titulo = "Adição de contatos";
    $scope.nome = '';
    $scope.email = '';
    $scope.num = '';
    $rootScope.Pesquisa = false;
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