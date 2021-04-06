CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name VARCHAR(2000),
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now()
);

create table comment (
    id SERIAL PRIMARY KEY,
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    post_id INT NOT NULL REFERENCES post(id)
);