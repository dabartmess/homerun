CREATE TABLE trips (
    trip_id SERIAL PRIMARY KEY,
    rider_name VARCHAR(100), -- For the public form
    pickup_address TEXT NOT NULL,
    destination_address TEXT NOT NULL,
    -- Spatial points
    pickup_location GEOGRAPHY(POINT, 4326),
    destination_location GEOGRAPHY(POINT, 4326),
    status VARCHAR(20) DEFAULT 'PENDING', -- PENDING, ACTIVE, COMPLETED
    assigned_driver_id INTEGER REFERENCES drivers(driver_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
