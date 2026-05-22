CREATE TABLE request (
                         id BIGSERIAL PRIMARY KEY,
                         text VARCHAR(1000) NOT NULL,
                         category VARCHAR(50),
                         priority VARCHAR(50),
                         status VARCHAR(50),
                         created_at TIMESTAMP
);