@GetMapping("/admin/export/trips")
public void exportTrips(HttpServletResponse response) throws IOException {
    List<Trip> trips = tripRepository.findAll();
    
    // Set headers for file download
    response.setContentType("application/json");
    response.setHeader("Content-Disposition", "attachment; filename=trips_report.json");
    
    // Serialize and write to response stream
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(response.getOutputStream(), trips);
}
