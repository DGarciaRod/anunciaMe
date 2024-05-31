# anuncia.me - App web de anuncios
## Iniciar en modo desarrollo
### Backend
#### Requisitos
- Java 17
- Mysql 8
- Maven 3.9

#### Configurar conexión con la BD
Es necesario configurar la conexión con la base de datos.\
Esto se puede hacer en el archivo:
```
src/main/resources/application-dev.properties
```
Solo nos interesan las 3 primeras líneas:
```properties
# Db Connection
spring.datasource.url=jdbc:mysql://localhost:3306/nombreBD
spring.datasource.username=root
spring.datasource.password=pass
```
En la primera línea debemos introducir la dirección de conexión. Cambiaremos el puerto, si hemos instalado mysql en el puerto por defecto (3306) y el nombre del esquema de la bd.\
En la segunda y tercera línea debemos introucir el nombre y el usuario de la base de datos.

#### Iniciar el backend
Lanzar en una terminal, desde la carpeta raíz:
```
mvn spring-boot:run 
```

### Frontend
#### Requisitos
- Node 17
#### Configurar conexión con el backend
Este paso no es necesario si no hemos cambiado en la configuración del backend el puerto en el que se sirve.
Accederemos al archivo:
```
frontend/src/environments/environment.development
```
```ts
export const environment = {
  dbUrl:"http://localhost:8080"
};
```
Y modificaremos la url como sea pertinente.

#### Instalar dependencias
Desde la carpeta:
```
frontend/
```
Lanzamos el siguiente comando:
```
npm install
```

#### Iniciar el frontend
Desde la carpeta:
```
frontend/
```
Lanzamos el siguiente comando:
```
npm start
```

## Generar version de produccion
### Requisitos
- Java 17
- Maven 3.9

### Generar JAR
Utilizaremos el plugin de maven maven-frontend-plugin para compilar el frontend e incluirlo en el servidor tomcat embebido de springboot.
De esta forma obtendremos un JAR que contendrá el backend y el frontend en el mismo archivo.

Ya esta todo configurado en el pom y se han creado environments de desarrollo y producción para el backend y el frontend.

Solo es necesario ejecutar el siguiente comando desde la carpeta raíz del proyecto:
```
mvn package -P prod
```
Y se nos generará el JAR de la aplicación en la carpeta target dentro de la carpeta raíz.

### Ejecutar JAR
Podemos ejecutar el archivo JAR lanzando el siguiente comando desde la carpeta target:
```
java -jar anunciaMe-1.0.jar
```
