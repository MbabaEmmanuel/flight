var bcrypt = require('bcryptjs')

export default
class UserService {
 /* @ngInject */
 constructor ($http, $state) {
   this.$http = $http

   this.getAllUsers = function() {
     return this.$http.get('http://localhost:8000/user').then((allUsers) => allUsers.data)
   }

   this.getAllFlights = function() {
        return this.$http.get('http://localhost:8000/flights').then((allFlights) => allFlights.data)
      }

 this.newUser = function (allUsers, user) {
  let found = allUsers.map(e => e.userName).indexOf(user.userName)
   if(found === -1)
   {
    user.password = bcrypt.hashSync(user.password, 8)
    this.$http.post('http://localhost:8000/user', user)
  }
  }

  this.getUser = function (allUsers, userCheck) {
    console.dir(allUsers)
    let checkAll = allUsers
    .map(e => e.userName).indexOf(userCheck.userName)
    console.dir(checkAll)
    let userfind = allUsers[checkAll]
    console.dir(userfind)
     if(checkAll !== -1)
      {
        if(bcrypt.compareSync(userCheck.password, userfind.password)){
          this.$http.get('http://localhost:8000/user/' + userfind.id)
            .then(function() { $state.go('userHomepage/:id', {id: userfind.id})
          }
        )

        }
      }

 }

 this.newItinerary = function(flight){

   var promise =  this.$http.post('http://localhost:8000/flights/allavailable', flight).success(function (data) {
      return data.data;
    })
    .error(function (data) {
      return {"status": false};
    });

  return promise;
}

this.getPastItinerary = function (id){
  var promise = this.$http.get('http://localhost:8000/user/itinerary/' + id).success( function (data)
  {return data.data}

).error(function(data){
  return {"status": false}
})
return promise;
}

this.postItinerary = function(id, flight) {
  return this.$http.post('http://localhost:8000/user/itinerary/' + id, flight)
}



 }
 }
