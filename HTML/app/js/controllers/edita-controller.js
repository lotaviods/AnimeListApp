angular.module('main').controller('editaController', ['$scope', '$rootScope', '$location', 'editaService', 'listagemService', '$routeParams', function($scope, $rootScope, $location, editaService, listagemService, $routeParams) {
    $rootScope.titulo = "Edição de contatos";
    $scope.id = $routeParams.id;
    $scope.nome = '';
    $scope.email = '';
    $scope.num = '';
    listagemService.listagem($scope.id);

    $rootScope.$on("success", function(event, data) {
        //console.log(data);
        $scope.nome = $rootScope.contatos.nome;
        $scope.email = $rootScope.contatos.email;
        $scope.num = $rootScope.contatos.numero;
    })

    $rootScope.Pesquisa = false;

    $scope.cadastrar = function() {
        $scope.data = {
            'nome': $scope.nome,
            'email': $scope.email,
            'numero': $scope.num
        };
        editaService.edita($scope.id, $scope.data);

    }
    $scope.inicio = function() {
        $location.path("/");
    }
}])