CREATE TABLE quizes (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    category VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);
