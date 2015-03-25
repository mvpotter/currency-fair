function Trade($scope, $http) {
    $http.get('/api/trade/count').
        success(function(data) {
            $scope.count = data.count;
        });
}