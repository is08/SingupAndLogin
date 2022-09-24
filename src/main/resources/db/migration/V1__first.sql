CREATE TABLE IF NOT EXISTS users(
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    logged_in BOOLEAN
);

INSERT INTO users VALUES("Isha", "Singh", "isha080400@gmail.com", "IshaS123", false);