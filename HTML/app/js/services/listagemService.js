angular.module('main').service('listagemService', ['$http', '$rootScope', 'messageService', function($http, $rootScope, messageService) {

    this.listagem = function() {
        $http.get('http://localhost:8080/api/contatos', {
            method: 'GET'
        }).success(resp => {
            $rootScope.resp = resp;
            $rootScope.contatos = $rootScope.resp.conteudoResposta;
            if ($rootScope.contatos)
                messageService.insereMensagem('Não existe nenhum contato');
        }).error(resp => {
            messageService.insereMensagem('Ocorreu um erro na busca');
        })

    }
}])