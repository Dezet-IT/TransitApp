angular.module('app', [])
    .controller('TransitController', function($http) {
        var vm = this;
        function refreshData() {
            $http.get('transit/daily')
                .then(function success(response) {
                    vm.transit = response.data;
                }, function error(response) {
                    console.log('API error ' + response.status);
                });
        }

        vm.addTransit = function(transit) {
            $http.post('transit', transit)
                .then(function success(response) {
                    refreshData();
                    vm.transit = {};
                }, function error(response) {
                    console.log('Data not saved ' + transit);
                });
        }
        vm.appName = 'Transit Manager';
        refreshData();
    });