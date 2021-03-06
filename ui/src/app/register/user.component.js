import userURL from './user.component.html'

/* @ngInject */
class UserController {
  constructor ($scope, userSrvce, $state) {
    var ctrl = this
    let users = ctrl.allUsers
    console.dir($state.params.id)
    let use = users.map(e => e.id).indexOf($state.params.id)
    console.dir(use)
    ctrl.user
    ctrl.flight
    ctrl.hi
    ctrl.obj

    ctrl.getItinerary = function () {

      userSrvce.getPastItinerary($state.params.id).then(function(promise){
        $scope.itineraries = promise.data
        console.dir($scope.itineraries)
      })
    }

    ctrl.newItinerary = function (flight) {
      var flights = []
      flights.push(flight)
      userSrvce.postItinerary($state.params.id, flights)
    }

    ctrl.mapItinerary = function (object){

      console.dir(object.id)
      $state.go('mapflight', {routeid: object.id})

    }






    ctrl.searchFlight = function () {

        userSrvce.newItinerary(ctrl.flight).then(function(promise) {
          $scope.flights=promise.data
            console.dir($scope.flights)
            $scope.flightList = [];
            for(var i=0; i < promise.data.length; i++) {
              $scope.mapdata = promise.data[i];
              $scope.flightList.push($scope.mapdata);
            }
            console.log($scope.flightList);

        })


    }


  }

}


  export default {
    templateUrl: userURL,
    controller: UserController,
    controllerAs: 'userCtrl',
    bindings: {
      allFlights: '<',
      allUsers: '<',
      pastItinerary: '<'
    }
  }
