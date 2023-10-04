# Proyecto Spring de Gestión de Cursos

Este proyecto de Spring se encarga de la gestión de cursos, proporcionando una API REST para acceder y manipular información sobre cursos. Incluye un controlador, un servicio y una entidad para manejar los datos de los cursos en una base de datos.

## Funcionalidades

El proyecto ofrece las siguientes funcionalidades:

- Obtener un curso por su identificador.
- Obtener una lista de todos los cursos disponibles.
- Guardar un nuevo curso.
- Actualizar un curso existente.
- Eliminar un curso.
- Editar las horas de un curso existente.
- Obtener una lista de cursos en un rango de precios específico.

## Estructura del Proyecto

El proyecto está organizado en tres paquetes principales:

- `com.viewnext.masterjava.app.controller`: Contiene el controlador de Spring que maneja las solicitudes HTTP relacionadas con cursos.
- `com.viewnext.masterjava.app.service`: Contiene la implementación del servicio que gestiona las operaciones relacionadas con cursos.
- `com.viewnext.masterjava.app.model`: Contiene la entidad `Curso` que representa los datos de un curso en la base de datos.

## Tecnologías Utilizadas

El proyecto utiliza las siguientes tecnologías y herramientas:

- Spring Boot: Framework de desarrollo de aplicaciones Java.
- Spring Data JPA: Biblioteca para simplificar el acceso a bases de datos.
- Maven: Herramienta de gestión de dependencias y construcción.

## Uso

Puedes clonar este repositorio y ejecutar la aplicación Spring Boot para comenzar a utilizarla. Asegúrate de tener Maven instalado y ejecuta el siguiente comando en el directorio raíz del proyecto:

```shell
mvn spring-boot:run
```

La aplicación estará disponible en http://localhost:8080.

## Endpoints
El controlador ofrece los siguientes endpoints:

- GET /curso/{id}: Obtiene un curso por su identificador.
- GET /cursos: Obtiene una lista de todos los cursos disponibles.
- POST /curso: Guarda un nuevo curso.
- PUT /curso: Actualiza un curso existente.
- DELETE /curso: Elimina un curso.
- PUT /curso/{id}/horas/{horas}: Edita las horas de un curso existente.
- GET /cursos/precio/{min}/{max}: Obtiene una lista de cursos en un rango de precios específico.
Los datos se envían y se reciben en formato JSON.