angular.module('main').service('listagemService', ['$http', '$rootScope', 'messageService', function($http, $rootScope, messageService) {

<<<<<<< HEAD
    this.listagem = function(id) {
        if (id == null) id = '';
        $http.get(`http://localhost:8080/api/contatos/${id}`, {
=======
    this.listagem = function() {
        $http.get('http://localhost:8080/api/contatos', {
>>>>>>> 282e14b... criação de diretiva para verificação de exclusão e estilo novo
            method: 'GET'
        }).success(resp => {
            $rootScope.resp = resp;
            $rootScope.contatos = $rootScope.resp.conteudoResposta;
<<<<<<< HEAD
            if ($rootScope.contatos == null) {
                messageService.insereMensagem('Não foi possivél efetuar a busca');
                return;
            }
            if (resp.conteudoResposta.length == 0)
                messageService.insereMensagem('Não encontramos nenhum contato');
            $rootScope.$broadcast("success", resp);
=======
            if (!$rootScope.contatos.length)
                messageService.insereMensagem('Não existe nenhum contato');
>>>>>>> 282e14b... criação de diretiva para verificação de exclusão e estilo novo
        }).error(resp => {
            messageService.insereMensagem('Ocorreu um erro na busca');
        })

    }
}])