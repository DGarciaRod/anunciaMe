INSERT INTO Usuarios(Id, Nombre, NombreUsuario, PassHash)
VALUES ("f30400fa-db90-4353-b356-b72b55270c23", "Juan - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.",
        "juan",
        "$2a$08$Ls39TudG35mB0etX.dkTvOhI7Jh84q4JWEL82w024JmS3GbxHFGIO");

INSERT INTO Usuarios(Id, Nombre, NombreUsuario, PassHash)
VALUES ("f30400fa-db90-4353-b356-b72b22270c23", "Pedro", "Márquez",
        "$2a$08$Ls39TudG35mB0etX.dkTvOhI7Jh84q4JWEL82w024JmS3GbxHFGIO$2a$08$Ls39TudG35mB0etX.dkTvOhI7Jh84q4JWEL82w024JmS3GbxHFGIO");

INSERT INTO Usuarios(Id, Nombre, NombreUsuario, PassHash)
VALUES ("0badcb07-4367-4a46-8ff2-614023e55e89",
        "Juan - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Iglesias",
        "$2a$08$Ls39TudG35mB0etX.dkTvOhI7Jh84q4JWEL82w024JmS3GbxHFGIO");

INSERT INTO Categorias(Id, Nombre)
VALUES ("755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "Ordenadores - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Categorias(Id, Nombre)
VALUES ("d7d63719-1cf2-4880-ac58-cff66a5f0177", "Bicicletas - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83b46935-166f-4343-a027-d450be30d5af", "Ordenador 1 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Ordenador barato 1", 1.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83a46935-166f-4343-a027-d450be30d5af", "Ordenador 2 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Ordenador barato 2", 150.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83a46935-166f-4343-a027-d450321125af", "Ordenador 3 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", 150.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83a46935-166f-4343-a027-d450444125af", "Ordenador 4 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", 150.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83a46935-166f-4343-a027-d450455525af", "Ordenador 5 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", 150.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Anuncios(Id, Nombre, Descripcion, Precio, Categoria, Vendedor)
VALUES ("83a46935-166f-4343-a027-d450455615af", "Ordenador 6 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.", 150.0,
        "755ca95f-a4f2-4e7b-a4f2-4df0c1a4255f", "0badcb07-4367-4a46-8ff2-614023e55e89");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("18e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:00");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("28e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:01");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("38e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:02");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("48e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:03");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("58e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:04");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("68e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:05");

INSERT INTO Compras(ID, Anuncio, Cantidad, Comprador, PrecioPagadoPorArticulo, Fecha)
VALUES ("78e4580e-593e-43e3-bf68-f962f69e477f", "83b46935-166f-4343-a027-d450be30d5af", 2,
        "f30400fa-db90-4353-b356-b72b55270c23", 40, "2024-01-01 00:00:06");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("1b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("2b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("3b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("4b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("5b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("6b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("7b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");

INSERT INTO Reviews(ID, Compra, Calificacion, Mensaje)
VALUES ("8b94e918-5eb1-41ce-b6d9-2c4a729ebf62", "78e4580e-593e-43e3-bf68-f962f69e477f", 3, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled.");