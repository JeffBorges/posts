CREATE TABLE post_comentario (
  id            serial,
  autor        varchar(100) NOT NULL,
  id_post       INTEGER NOT NULL,
  texto         varchar(1000),
  data_inclusao timestamp,
  PRIMARY KEY (id)
);
