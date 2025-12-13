
-- Пользователи
CREATE TABLE app_user (
    user_id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255) NOT NULL,
    date_birthday VARCHAR(50) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    verified BOOLEAN NOT NULL DEFAULT FALSE,
    phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE refresh_token(
    token_id VARCHAR(255) PRIMARY KEY,
    user_id BIGINT NOT NULL,
    token_hash VARCHAR(512) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_refresh_token_user FOREIGN KEY (user_id) REFERENCES app_user(user_id)
        ON DELETE CASCADE
);