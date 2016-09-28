import mapUrl from './mapstuff.component.html'

/* @ngInject */
class MapStuffController {
  zoom = 7
  center = [35.5175, -86.5804]
  markers = []
  paths = []

  constructor ($map, $stateParams) {
    $map.getMarkerByCityName($stateParams.flight.origin)
      .then(chattanooga => {
          $map.getMarkerByCityName($stateParams.flight.destination).then( function(path) {
      this.addPath(chattanooga, path, '#ff0000')
      })
    })


  }

  addMarker ({ latitude, longitude }) {
    this.markers.push({
      position: `[${latitude}, ${longitude}]`
    })
  }

  addPath (a, b, color) {
    this.paths.push({
      path: `[[${a.latitude}, ${a.longitude}], [${b.latitude}, ${b.longitude}]]`,
      strokeColor: color,
      strokeOpacity: 1.0,
      strokeWeight: 3,
      geodesic: true
    })
  }

}

export default {
  templateUrl:mapUrl,
  controller: MapStuffController,
  controllerAs: '$mapCtrl'
}
