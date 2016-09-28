class FlightNode {

     originCityName

    parentNode

    childNodes = {}

    destinationFlightMap = {}

    getOriginCityName() {
        return originCityName;
    }

  setOriginCityName(originCityName) {
        this.originCityName = originCityName;
    }

    getParentNode() {
        return parentNode;
    }

    setParentNode(parentNode) {
        this.parentNode = parentNode;
    }

    getChildNodes() {
        return childNodes;
    }

    setChildNodes(childNodes) {
        this.childNodes = childNodes;
    }

    getDestinationFlightMap() {
        return destinationFlightMap;
    }

    setDestinationFlightMap(destinationFlightMap) {
        this.destinationFlightMap = destinationFlightMap;
    }
}
