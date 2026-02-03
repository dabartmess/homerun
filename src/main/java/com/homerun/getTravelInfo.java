public String getTravelInfo(Point driverPt, Point riderPt) {
    // Format coordinates for Google API: "lat,lng"
    String origin = driverPt.getY() + "," + driverPt.getX();
    String destination = riderPt.getY() + "," + riderPt.getX();

    DistanceMatrixApiRequest req = DistanceMatrixApi.getDistanceMatrix(context, 
        new String[]{origin}, 
        new String[]{destination});

    try {
        DistanceMatrix result = req.await();
        return result.rows[0].elements[0].duration.humanReadable; // e.g., "12 mins"
    } catch (Exception e) {
        return "N/A";
    }
}
