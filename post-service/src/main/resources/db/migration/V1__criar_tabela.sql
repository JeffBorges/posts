CREATE TABLE post (
  id            serial,
  titulo        varchar(250) NOT NULL,
  sub_titulo    varchar(500),
  texto         varchar(10000),
  data_inclusao timestamp,
  PRIMARY KEY (id)
);
