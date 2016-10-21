import mapAp from './mapstuff.component.js'
import mapService from '../service/mapstuff.service.js'

export default
  angular
    .module('mapAppper', ['ngMap'])
    .component('mapAp', mapAp)
    .service('mapService', mapService)
    .config(['$stateProvider', function ($stateProvider) {
      $stateProvider
        .state('map', {
          url: '/map/:routeid',
          component: 'mapAp'
        })
    }])
    .name
