angular.module('main').service('messageService', ['$rootScope', '$timeout', function($rootScope, $timeout) {

    this.insereMensagem = function(message) {
        $rootScope.transition = true;
        $rootScope.messageBox = `${message}`;
        $timeout(f => {
            $rootScope.transition = false;
            $rootScope.messageBox = '';
        }, 5000)
    }

}]);