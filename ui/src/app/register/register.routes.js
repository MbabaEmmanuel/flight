/* @ngInject */
export default function routes ($stateProvider) {
  $stateProvider
    .state('register', {
      url: '/register',
      component: 'userComp',
      resolve:{
        allUsers: function(userSrvce){
          return userSrvce.getAllUsers()
        }
      }
  })

  .state('LogIn', {
    url: '/login',
    component: 'loginComp',
    resolve:{
      allUsers: function(userSrvce){
        return userSrvce.getAllUsers()
      }
    }
})
.state('userHomepage/:id', {
  url: '/user/:id',
  component: 'userPage',
  resolve:{
    allFlights: function(userSrvce){
      return userSrvce.getAllFlights()
    },
    allUsers: function(userSrvce){
      return userSrvce.getAllUsers()
    }

  }

})
.state('userFlights/:id', {
  url: '/userflight/:id',
  component: 'userFlight'


})
.state('mapflight', {
  url: '/map/:routeid',
  component: 'mapApp'
})


}
