CREATE TABLE IF NOT EXISTS movies (
    id int(5) NOT NULL AUTO_INCREMENT,
    imdb_id varchar(50) DEFAULT NULL,
    title varchar(50) DEFAULT NULL,
    director varchar(50) DEFAULT NULL,
    year varchar(50) DEFAULT NULL,
    imdb_url varchar(50) DEFAULT NULL,
    PRIMARY KEY(id)
    );