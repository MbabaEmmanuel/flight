export default
class UserService {
 /* @ngInject */
 constructor ($http, $state) {
   this.$http = $http

   this.getAllFlights = function() {
        return this.$http.get('http://localhost:8000/flights').then((allFlights) => allFlights.data)
      }
    }
  }
