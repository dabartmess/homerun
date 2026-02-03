SELECT driver_id, vehicle_info
FROM drivers
WHERE ST_DWithin(current_location, ST_GeogFromText('POINT(-122.084 37.422)'), 5000);
