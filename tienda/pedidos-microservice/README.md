# Proyecto de Gestión de Pedidos

Este es un proyecto de muestra que demuestra cómo gestionar pedidos utilizando Spring Boot y una base de datos de pedidos. El proyecto se divide en dos partes principales: el controlador de pedidos y el servicio de pedidos.

## Tabla de contenidos

- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Requisitos

Asegúrate de tener instalado lo siguiente en tu entorno de desarrollo:

- Java 8 o superior.
- [Spring Boot](https://spring.io/projects/spring-boot).
- [Maven](https://maven.apache.org/).

## Clona este repositorio:

   ```bash
   git clone https://github.com/tuusuario/proyecto-pedidos.git
   ```

## Uso

La aplicación debería ejecutarse en http://localhost:9000. Puedes acceder a la API a través de este endpoint.

La aplicación ofrece las siguientes funcionalidades:

Obtener todos los pedidos: Puedes obtener una lista de todos los pedidos haciendo una solicitud GET a /pedidos.

Agregar un nuevo pedido: Puedes agregar un nuevo pedido haciendo una solicitud POST a /pedido y proporcionando los detalles del pedido en formato JSON.

Asegúrate de tener un servicio REST de productos en ejecución en http://localhost:8080 para que la aplicación pueda interactuar con él.