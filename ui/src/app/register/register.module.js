import userService from '../service/user.service.js'
import userComponent from './register.component.js'
import registerRoutes from './register.routes'
import loginComponent from './login.component.js'
import userHome from './user.component.js'
import userFlightComponent from './user.flight.component.js'
import mapComponent from '../mapstuff/mapstuff.component.js'

export default
  angular
    .module('appRegister', ['ui.router'])
    .service('userSrvce', userService)
    .component('userComp', userComponent)
    .component('loginComp', loginComponent)
    .component('userPage', userHome)
    .component('userFlight', userFlightComponent)
    .component('mapApp', mapComponent)
    .config(registerRoutes)
    .name
