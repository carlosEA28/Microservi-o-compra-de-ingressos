
CREATE EXTENSION IF NOT EXISTS "pgcrypto";


CREATE TABLE venue (
    venue_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    total_capacity BIGINT NOT NULL
);


CREATE TABLE event (
    event_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    venue_id UUID NOT NULL,
    total_capacity BIGINT NOT NULL,
    left_capacity BIGINT NOT NULL,
    CONSTRAINT fk_event_venue FOREIGN KEY (venue_id) REFERENCES venue(venue_id) ON DELETE CASCADE
);
