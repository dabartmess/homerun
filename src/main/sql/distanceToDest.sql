SELECT ST_Distance(pickup_location, destination_location) / 1000 AS distance_km
FROM trips WHERE trip_id = 1;
