
-- Пользователи
CREATE TABLE users (
                       id VARCHAR(255) PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       email_visibility BOOLEAN NOT NULL DEFAULT TRUE,
                       firstname VARCHAR(255),
                       lastname VARCHAR(255),
                       secondname VARCHAR(255),
                       date_birthday VARCHAR(255),
                       gender VARCHAR(50),
                       verified BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP NOT NULL,
                       updated_at TIMESTAMP NOT NULL
);

-- Продукты (Shop)
CREATE TABLE products (
                          id VARCHAR(255) PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description VARCHAR(1000),
                          price INT NOT NULL,
                          type_closes VARCHAR(255),
                          type VARCHAR(255),
                          approximate_cost VARCHAR(255),
                          created_at TIMESTAMP NOT NULL,
                          updated_at TIMESTAMP NOT NULL
);

-- Новости
CREATE TABLE news (
                      id VARCHAR(255) PRIMARY KEY,
                      news_image VARCHAR(255),
                      created_at TIMESTAMP NOT NULL,
                      updated_at TIMESTAMP NOT NULL
);

-- Проекты
CREATE TABLE projects (
                          id VARCHAR(255) PRIMARY KEY,
                          user_id VARCHAR(255) NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          date_start VARCHAR(255),
                          date_end VARCHAR(255),
                          gender VARCHAR(50),
                          description_source VARCHAR(1000),
                          category VARCHAR(255),
                          image VARCHAR(255),
                          created_at TIMESTAMP NOT NULL,
                          updated_at TIMESTAMP NOT NULL
);

-- Элементы корзины (Cart Items)
CREATE TABLE cart_items (
                            id VARCHAR(255) PRIMARY KEY,
                            user_id VARCHAR(255) NOT NULL,
                            product_id VARCHAR(255) NOT NULL,
                            count INT NOT NULL,
                            created_at TIMESTAMP NOT NULL,
                            updated_at TIMESTAMP NOT NULL
);

-- Заказы (Orders)
CREATE TABLE orders (
                        id VARCHAR(255) PRIMARY KEY,
                        user_id VARCHAR(255) NOT NULL,
                        product_id VARCHAR(255) NOT NULL,
                        count INT NOT NULL,
                        created_at TIMESTAMP NOT NULL,
                        updated_at TIMESTAMP NOT NULL
);