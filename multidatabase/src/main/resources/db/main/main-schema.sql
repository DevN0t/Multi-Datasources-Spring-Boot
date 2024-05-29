DROP TABLE maincontent;

CREATE TABLE maincontent(
    id serial PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL
);

INSERT INTO maincontent (name, description) VALUES ('Main Content 1', 'This is the first main content');
INSERT INTO maincontent (name, description) VALUES ('Main Content 2', 'This is the second main content');