import registerURL from './register.component.html'

/* @ngInject */
class RegisterController {
  constructor (userSrvce) {
    var ctrl = this
    ctrl.user

    ctrl.newUser = function () {
      userSrvce
      .newUser(this.allUsers, ctrl.user)
    }

}
}

export default {
  templateUrl: registerURL,
  controller: RegisterController,
  controllerAs: 'registerCtrl',
  bindings: {
    allUsers: '<',
  }

}
