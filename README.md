# Challenge ONE Back End - ForoHub

## Descripción
ForoHub es una API RESTful que implementa un CRUD para la gestión de tópicos en un foro, con persistencia de datos en MySQL. Además, utiliza JWT para la autenticación y autorización de usuarios, garantizando un acceso seguro a los recursos.

## Funcionalidades
- **CRUD de Tópicos**: Crear, actualizar, eliminar, listar y filtrar tópicos.
- **Autenticación y Autorización**: Implementación de JWT para proteger el acceso a los endpoints.
- **Persistencia de Datos**: Almacenamiento de la información en MySQL mediante JPA e Hibernate.
- **Documentación Automática**: Integración con Springdoc OpenAPI para generar documentación interactiva con Swagger.
- **Migraciones de Base de Datos**: Uso de Flyway para la gestión de cambios en el esquema de la base de datos.

## Documentación y Endpoints de la API
La API de ForoHub cuenta con documentación interactiva generada con Swagger. Para visualizarla, accede a:

🔗 [Swagger UI](http://localhost:8080/swagger-ui/index.html)

## Tecnologías Utilizadas
- **Entorno de Desarrollo**: IntelliJ IDEA Community Edition
- **Lenguaje**: Java 17
- **Framework**: Spring Boot 3.4.0
- **Gestor de Dependencias**: Maven
- **Dependencias Principales**:
   - Spring Web
   - Spring Data JPA
   - Spring Boot DevTools
   - Lombok
   - Flyway Migration
   - MySQL Driver
   - Spring Security
   - Java JWT
   - Springdoc OpenAPI
   - Validation
- **Base de Datos**: MySQL

## Instrucciones para Ejecutar el Proyecto Localmente
Sigue estos pasos para ejecutar el proyecto en tu entorno local:

1. **Clonar el Repositorio**:
   ```bash
    git clone https://github.com/joche-dev/challenge-forohub.git
    ```
2. **Configurar el archivo application.properties**:
   - Abre el proyecto en IntelliJ IDEA.
   - Edita src/main/resources/application.properties para establecer los parámetros de conexión a MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
3. **Compilar y Ejecutar la Aplicación**: 
   - Abre el archivo ApiApplication.java y ejecútalo.
   - Alternativamente, desde la terminal ejecuta:
   ```bash
    mvn spring-boot:run
    ```
4. **Acceder a la API**:
   - La API se ejecutará en http://localhost:8080/
   - Consulta los endpoints disponibles en [Swagger UI](http://localhost:8080/swagger-ui/index.html)
