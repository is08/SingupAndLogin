CREATE TABLE IF NOT EXISTS users(
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(100) PRIMARY KEY NOT NULL,
    password VARCHAR(100) NOT NULL,
    logged_in BOOLEAN
);

INSERT INTO users VALUES("Isha", "Singh", "isha080400@gmail.com", "IshaS123", false);