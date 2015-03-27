(function () {

    angular
        .module('trades')
        .controller('TradeCtrl', TradeCtrl);

    TradeCtrl.$inject = ['$scope', '$http'];

    function TradeCtrl($scope, $http) {

        $http.get('/api/trades').
            success(function(trades) {
                $scope.trades = trades;
            });

    }

})();