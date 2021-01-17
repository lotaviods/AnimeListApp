angular.module('main').service('listagemService', ['$http', '$rootScope', 'messageService', function($http, $rootScope, messageService) {
    this.listagem = function(id) {
        if (id == null) id = '';
        $http.get(`http://localhost:8080/api/contatos/${id}`, {
            method: 'GET'
        }).success(resp => {
            $rootScope.resp = resp;
            $rootScope.contatos = $rootScope.resp.conteudoResposta;

            if ($rootScope.contatos == null) {
                messageService.insereMensagem('Não foi possivél efetuar a busca');
                return;
            }
            if (resp.conteudoResposta.length == 0)
                messageService.insereMensagem('Não encontramos nenhum contato');
            $rootScope.$broadcast("success", resp);
        }).error(resp => {
            messageService.insereMensagem('Ocorreu um erro na busca');
        })

    }
}])