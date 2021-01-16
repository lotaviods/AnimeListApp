angular.module('main').controller('indexController', ['$rootScope', function($rootScope) {
    $rootScope.transition = false;
    $rootScope.titulo = "Lista de Contatos";
    $rootScope.messageBox = "";
    $rootScope.Pesquisa = true;
}])