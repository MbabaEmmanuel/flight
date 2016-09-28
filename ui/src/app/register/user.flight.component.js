import flightURL from './user.flight.component.html'

/* @ngInject */
class UserFlightController {
constructor (userSrvce) {

}
}
export default{
  templateUrl: flightURL,
  controller: UserFlightController,
  controllerAs: 'userFlightCtrl'
}
