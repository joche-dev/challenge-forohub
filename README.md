# Challenge ONE Back End - ForoHub

## Descripción
Este proyeEste proyecto es una API RESTful que implementa un CRUD para la gestión de tópicos, con persistencia de datos en MySQL. Además, utiliza JWT para la autenticación y autorización de usuarios, garantizando un acceso seguro a los recursos.

## Funcionalidades
- CRUD de Tópicos: Crear, Actualizar, Eliminar, Listar y filtrar tópicos.
- Autenticación y Autorización: Acceso protegido a las funcionalidades de los tópicos.
- Persistencia de datos: Almacenamiento de los datos en MySQL.
- Documentación automatica: Se implementa springdoc-openapi, para que genere automaticamente la documentación con Swagger.

## Documentación y Endpoints de la API
La API de ForoHub viene con documentación Swagger. Visite la siguiente URL: [Swagger](http://localhost:8080/swagger-ui/index.html)

## Tecnologias Utilizadas
- **Entorno de Desarrollo**: IntelliJ IDEA Community Edition
- **Lenguaje**: Java 17
- **Framework**: Spring Boot 3.4.0
- **Gestor de dependencias**: Maven
- **Dependencias**: Spring Web, Spring Data JPA, Spring Boot DevTools, Lombok, Flyway Migration, MySQL Driver, Spring Security, Validation, Java-jwt, Springdoc-openapi.
- **Base Datos**: MySQL

## Instrucciones para Ejecutar el Proyecto Localmente
Sigue estos pasos para ejecutar el proyecto en tu entorno local:

1. **Clonar el Repositorio**:
   ```bash
    git clone https://github.com/joche-dev/challenge-forohub.git
    ```
2. **Abrir el Proyecto en IntelliJ y Configurar el archivo application.properties**: Navega al archivo application.properties, debes revisar la configuración de conexión con la base de datos MySQL.
3. **Compilar y Ejecutar el Archivo LiteraluraApplication**: Navega al archivo ApiApplication.java, compílalo y ejecútalo para comenzar a utilizar la aplicación.
