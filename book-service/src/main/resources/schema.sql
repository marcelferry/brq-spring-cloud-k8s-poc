-- set mode MySQL;
DROP TABLE book;

CREATE TABLE IF NOT EXISTS book (
  id              INT     NOT NULL PRIMARY KEY,
  author       	  VARCHAR(200) NOT NULL,
  title           VARCHAR(200) NOT NULL
);