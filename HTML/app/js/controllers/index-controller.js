angular.module('main').controller('indexController', ['$scope', '$rootScope', '$http', '$timeout', function($scope, $rootScope, $http, $timeout, listagemService) {
    $rootScope.transition = false;
    $rootScope.titulo = "Lista de Contatos";
    $rootScope.messageBox = "";

}])