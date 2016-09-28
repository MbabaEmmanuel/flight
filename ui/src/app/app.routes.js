/* @ngInject */
export default function routes ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/');
  $stateProvider
    .state('app', {
      url:'/',
      template: '<flight-app></flight-app>'
    })
  }
