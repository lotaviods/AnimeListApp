angular.module('main').service('editaService', ['$http', 'messageService', '$rootScope', 'listagemService', function($http, messageService, $rootScope, listagemService) {

    this.edita = function(id, data) {
        $http.put(`http://localhost:8080/api/contatos/${id}`, data).success(res => {
            messageService.insereMensagem('Edição feita com sucesso');
        }).error(res => {
            messageService.insereMensagem(`Edição falhou: ${res.conteudoResposta.mensagem}`);
        })
    }


}])