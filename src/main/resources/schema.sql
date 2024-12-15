CREATE TABLE IF NOT EXISTS item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    img_url VARCHAR(500) NOT NULL,
    quantity INT NOT NULL,
    bought_on TIMESTAMP,
    listed_on TIMESTAMP,
    created_on TIMESTAMP NOT NULL DEFAULT current_timestamp,
    version INT
);
