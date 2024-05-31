DROP TABLE IF EXISTS Reviews;
DROP TABLE IF EXISTS Compras;
DROP TABLE IF EXISTS Imagenes;
DROP TABLE IF EXISTS Anuncios;
DROP TABLE IF EXISTS Categorias;
DROP TABLE IF EXISTS Usuarios;


CREATE TABLE Usuarios
(
    ID            varchar(36) PRIMARY KEY default (uuid()),
    Nombre        varchar(255) NOT NULL,
    NombreUsuario varchar(255) NOT NULL,
    PassHash      varchar(255) NOT NULL
);

CREATE TABLE Categorias
(
    ID     varchar(36) PRIMARY KEY default (uuid()),
    Nombre varchar(255) NOT NULL
);

CREATE TABLE Anuncios
(
    ID          varchar(36) PRIMARY KEY default (uuid()),
    Nombre      varchar(255) NOT NULL,
    Descripcion varchar(255) NOT NULL,
    Precio      decimal      NOT NULL,
    Categoria   varchar(36)  NOT NULL REFERENCES Categorias (ID),
    Vendedor    varchar(36)  NOT NULL REFERENCES Usuarios (ID)
);

CREATE TABLE Imagenes
(
    ID      varchar(36) PRIMARY KEY default (uuid()),
    Anuncio varchar(36) NOT NULL REFERENCES Anuncios (ID),
    Data    Blob(10485760)
);

CREATE TABLE Compras
(
    ID                      varchar(36) PRIMARY KEY default (uuid()),
    Anuncio                 varchar(36) NOT NULL REFERENCES Anuncios (ID),
    Cantidad                INTEGER     NOT NULL,
    Comprador               varchar(36) NOT NULL REFERENCES Usuarios (ID),
    PrecioPagadoPorArticulo DECIMAL     NOT NULL,
    Fecha DATETIME
);

CREATE TABLE Reviews
(
    ID           varchar(36) PRIMARY KEY default (uuid()),
    Compra       varchar(36) NOT NULL REFERENCES Compras (ID),
    Calificacion INTEGER     NOT NULL,
    Mensaje      varchar(255)
);