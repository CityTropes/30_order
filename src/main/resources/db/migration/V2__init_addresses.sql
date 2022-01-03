CREATE TABLE IF NOT EXISTS addresses
(
    id UUID PRIMARY KEY,
    street_name VARCHAR(50) NOT NULL,
    house_number VARCHAR(8),
    postal_code VARCHAR(8) NOT NULL,
    city_name VARCHAR NOT NULL
);