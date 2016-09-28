import mapComponent from './mapstuff.component.js'
import mapService from './mapstuff.service'

export default
  angular
    .module('flight.map', ['ngMap'])
    .component('flightMap', mapComponent)
    .service('$map', mapService)
    .config( $stateProvider
        .state('mapping', {
          url: '/mapper/:flight',
          component: 'userComp'
        }
      )
    )
    .name
