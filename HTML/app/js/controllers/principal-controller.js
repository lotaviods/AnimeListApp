angular.module('main').controller('principalController', ['$rootScope', 'listagemService', function($rootScope, listagemService) {
    $rootScope.titulo = "Lista de Contatos";
    listagemService.listagem();

}])