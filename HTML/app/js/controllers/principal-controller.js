angular.module('main').controller('principalController', ['$rootScope', '$scope', 'listagemService', 'deletaService', function($rootScope, $scope, listagemService, deletaService) {
    $rootScope.titulo = "Lista de Contatos";
    $rootScope.Pesquisa = true;

    listagemService.listagem();

    $scope.excluir = function(id) {
        deletaService.deleta(id);
    }

}])