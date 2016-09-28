import loginURL from './login.component.html'
/* @ngInject */
class LoginController {
  constructor (userSrvce) {
    var ctrl = this
    ctrl.user

    ctrl.getUser = function () {
  console.log("test")
  userSrvce
  .getUser(this.allUsers, ctrl.user)
  }

}
}


export default {
  templateUrl: loginURL,
  controller: LoginController,
  controllerAs: 'loginCtrl',
  bindings: {
    allUsers: '<'
  }

}
