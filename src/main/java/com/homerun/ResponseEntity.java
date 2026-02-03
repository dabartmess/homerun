@PostMapping("/request")
public ResponseEntity<String> requestRide(@RequestBody TripDTO tripDto) throws Exception {
    Trip trip = new Trip();
    trip.setRiderName(tripDto.getRiderName());
    trip.setPickupAddress(tripDto.getPickupAddress());
    
    // Convert string address to PostGIS Point
    Point pickupPt = geocodingService.convertAddressToPoint(tripDto.getPickupAddress());
    trip.setPickupLocation(pickupPt);
    
    tripRepository.save(trip);
    return ResponseEntity.ok("Trip saved with spatial coordinates!");
}
