angular.module('main').service('cadastroService', ['$http', 'messageService', function($http, messageService) {

    this.cadastro = function(data) {
        $http.post('http://localhost:8080/api/contatos/', data).success(res => {
            messageService.insereMensagem('Cadastro feito com sucesso');
        }).error(res => {
            messageService.insereMensagem(`Cadastro falhou: ${res.conteudoResposta.mensagem}`);
        })
    }
}])