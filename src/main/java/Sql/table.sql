CREATE TABLE IF NOT EXISTS Users(
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255) UNIQUE ,
    email VARCHAR(255) UNIQUE ,
    password VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Categories(
  category_id SERIAL PRIMARY KEY,
  name VARCHAR(255) UNIQUE ,
  description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Brand(
     brand_id SERIAL PRIMARY KEY,
     name VARCHAR(255) UNIQUE ,
     website VARCHAR(255),
     description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Product(
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    create_date VARCHAR(255),
    category_id INTEGER,
    brand_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id),
    FOREIGN KEY (brand_id) REFERENCES Brand(brand_id)
);

CREATE TABLE IF NOT EXISTS Shareholder(
    shareholder_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    phone_number INTEGER,
    national_code INTEGER UNIQUE
);
CREATE TABLE IF NOT EXISTS Shareholder_Brand(
  ShB_id SERIAL PRIMARY KEY,
  shareholder_id INTEGER,
  brand_id INTEGER,
    FOREIGN KEY (shareholder_id) REFERENCES Shareholder(shareholder_id),
    FOREIGN KEY (brand_id) REFERENCES Brand(brand_id)
);

