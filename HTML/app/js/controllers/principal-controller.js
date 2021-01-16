angular.module('main').controller('principalController', ['$rootScope', '$scope', 'listagemService', 'deletaService', function($rootScope, $scope, listagemService, deletaService) {
    $rootScope.titulo = "Lista de Contatos";
    listagemService.listagem();
    $rootScope.Pesquisa = true;
    $scope.excluir = function(id) {
        deletaService.deleta(id);
    }

}])