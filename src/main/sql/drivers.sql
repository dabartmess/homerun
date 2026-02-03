CREATE TABLE drivers (
    driver_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
    license_number VARCHAR(50) UNIQUE,
    vehicle_info TEXT,
    -- Geography(Point, 4326) uses WGS 84 (lat/long)
    current_location GEOGRAPHY(POINT, 4326), 
    is_available BOOLEAN DEFAULT TRUE,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Index for fast spatial queries (e.g., "find nearest driver")
CREATE INDEX idx_driver_location ON drivers USING GIST(current_location);
