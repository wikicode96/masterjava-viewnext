# Productos Service

Este proyecto es una aplicación de servicio de gestión de productos desarrollada en Java con Spring Boot. Proporciona una API REST para realizar operaciones relacionadas con productos, como la obtención de todos los productos, la actualización del stock de un producto y la obtención del precio de un producto por su ID.

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Maven

## Configuración

Asegúrese de tener Java y Maven instalados en su sistema antes de ejecutar la aplicación. Puede configurar la conexión a la base de datos en `application.properties` o `application.yml` según sus necesidades.

## Ejecución

Para ejecutar la aplicación, puede utilizar el siguiente comando:

```shell
mvn spring-boot:run
```
La aplicación se ejecutará en http://localhost:8080.

## Endpoints de la API
- GET /productos: Obtiene todos los productos en formato JSON.
- PUT /producto: Actualiza el stock de un producto utilizando un objeto JSON en el cuerpo de la solicitud.
- GET /producto/price/{id}: Obtiene el precio de un producto por su ID.