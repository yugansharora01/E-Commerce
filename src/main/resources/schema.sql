CREATE TABLE IF NOT EXISTS item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    price DECIMAL(12,2) NOT NULL,
    imgUrl VARCHAR(500) NOT NULL,
    quantity INT NOT NULL,
    boughtOn TIMESTAMP,
    listedOn TIMESTAMP,
    createdOn TIMESTAMP
);
