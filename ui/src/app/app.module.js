import flightMap from './map/map.module'
import apiUrl from './api.url'
import appComponent from './app.component.js'
import routes from './app.routes'
import homeAp from './home/home.module'
import registerApp from './register/register.module'
import bcrypt from 'bcryptjs'

export default
  angular
    .module('flight', [
      'ngAria',
      'ngAnimate',
      'ngMaterial',
      'ngMessages',
      'ui.router',
      homeAp,
      registerApp,
      flightMap
    ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .config(routes)
    .name
