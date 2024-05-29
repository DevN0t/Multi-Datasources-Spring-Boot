DROP TABLE users;

CREATE TABLE users(
    id serial PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('user1', 'password1', true);
INSERT INTO users (username, password, enabled) VALUES ('user2', 'password2', true);