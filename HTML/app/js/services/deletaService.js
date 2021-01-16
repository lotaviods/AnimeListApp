angular.module('main').service('deletaService', ['$http', 'messageService', function($http, messageService) {

    this.deleta = function(id) {
        $http.delete(`http://localhost:8080/api/contatos/${id}`)
            .success(res => {
                messageService.insereMensagem('Deletado com sucesso');
            })
            .error(res => {
                messageService.insereMensagem('Ocorreu um erro ao deletar');
            })
    }
}])