import { cons, nil } from 'list'


var FlightTree = function(flight) {

  var newFlightTree = {};

  newFlightTree.flight = flight;
  newFlightTree.children = [];

  return newFlightTree;
};

FlightTree.addChild = function(flight) {

  this.children.push(FlightTree(flight));
};

FlightTree.contains = function(targetFlight) {

    var found = false;
    var flightList = []

  var originCheck = function(node) {

    if(node.flight.origin === targetFlight.origin){
      flightList.push(node)
    } else  {
      flightList.push(Nil)
      this.addChild[flightList]
    }

    for (var i = 0; i < node.children.length; i++) {
      var child = node.children[i];
      originCheck(child);
    }
  };
  originCheck(this);

  return found;
};
