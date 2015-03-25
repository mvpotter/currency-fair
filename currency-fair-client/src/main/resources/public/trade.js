function Trade($scope, $http) {
    $http.get('/api/trades/count').
        success(function(data) {
            $scope.count = data.count;
        });
    $http.get('/api/trades').
        success(function(trades) {
            $scope.trades = trades;
        });
}