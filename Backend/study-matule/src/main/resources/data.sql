
INSERT INTO users (id, email, password_hash, created_at, updated_at) VALUES
    ('user_1', 'test@example.com', '$2a$10$fV81xV.E5kL/s9W1lW24x.P4J0A7X.8kO8q9.3N.k4M5V9m', NOW(), NOW());

INSERT INTO products (id, title, description, price, type_closes, type, created_at, updated_at) VALUES
    ('prod_1', 'Красное платье', 'Идеальное вечернее платье.', 15000, 'платье', 'женский', NOW(), NOW()),
    ('prod_2', 'Кожаная куртка', 'Классическая черная куртка.', 25000, 'куртка', 'унисекс', NOW(), NOW()),
    ('prod_3', 'Кроссовки белые', 'Удобные для спорта и прогулок.', 8000, 'обувь', 'мужской', NOW(), NOW());

INSERT INTO news (id, news_image, created_at, updated_at) VALUES
    ('news_1', 'url/image/sale.jpg', NOW(), NOW()),
    ('news_2', 'url/image/new_collection.jpg', NOW(), NOW());

INSERT INTO projects (id, user_id, title, date_start, date_end, category, created_at, updated_at) VALUES
    ('proj_1', 'user_1', 'Летний гардероб', '2025-06-01', '2025-08-31', 'мода', NOW(), NOW());