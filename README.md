# Proyecto E-Commerce 

Este es un proyecto de e-commerce que consta de un backend desarrollado con Spring Boot y un frontend desarrollado con Angular.

## Requisitos Previos

- Docker
- Docker Compose

## Estructura del Proyecto
    │ecommerce_project_keola/
    │
    ├── ecommerce_backend/
    │ ├── src/
    │ ├── target/
    │ ├── Dockerfile
    │ ├── pom.xml
    │ └── application.properties
    │
    ├── docker-compose.yml
    └── README.md

## Configuración del Proyecto

### Backend

El backend está desarrollado con Spring Boot y se configura mediante variables de entorno en Docker. Asegúrate de configurar las siguientes variables en el archivo `docker-compose.yml`:

    ```yaml
    version: '3.8'

    services:
      backend:
        build:
          context: ./ecommerce_backend
          dockerfile: Dockerfile
        ports:
          - "8080:8080"
        depends_on:
          - postgres
          - mongo
        environment:
          - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/  ecommerce_keola
          - SPRING_DATASOURCE_USERNAME=ecommerce_user
          - SPRING_DATASOURCE_PASSWORD=123456
          - SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/  ecommerce_keola

      postgres:
        image: postgres:14
        environment:
          POSTGRES_DB: ecommerce_keola
          POSTGRES_USER: ecommerce_user
          POSTGRES_PASSWORD: 123456
        ports:
          - "5432:5432"

      mongo:
        image: mongo:latest
        ports:
          - "27017:27017"

## Construcción y Ejecución

### Con Docker
#### Clona el repositorio
    git clone https://github.com/tuusuario/ecommerce_project_keola.git
    cd ecommerce_project_keola

#### Construye la imagen de Docker y levanta los contenedores:
    docker-compose up --build

Esto levantará los contenedores del backend, PostgreSQL y MongoDB. La aplicación estará disponible en http://localhost:8080.

