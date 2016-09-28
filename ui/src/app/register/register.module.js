import userService from '../service/user.service.js'
import userComponent from './register.component.js'
import registerRoutes from './register.routes'
import loginComponent from './login.component.js'
import userHome from './user.component.js'
import userFlightComponent from './user.flight.component.js'

export default
  angular
    .module('appRegister', ['ui.router'])
    .service('userSrvce', userService)
    .component('userComp', userComponent)
    .component('loginComp', loginComponent)
    .component('userPage', userHome)
    .component('userFlight', userFlightComponent)
    .config(registerRoutes)
    .name
