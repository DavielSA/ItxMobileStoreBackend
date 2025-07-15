# 📦 ITX Mobile Store Backend

Este proyecto es un **backend RESTful** desarrollado en **Java con Spring Boot**, que expone un servicio para obtener productos relacionados mediante un cliente externo.

## 🚀 Requisitos

- Java 17 o superior
- Maven 3.6+
- Git
- (Opcional) Docker

## ⚙️ Cómo ejecutar

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/itx-mobile-store.git
   cd itx-mobile-store
   ```
## Compila y ejecuta la aplicación:

```bash
mvn spring-boot:run
```
La aplicación se levantará en:
http://localhost:5000

## 🧪 Ejecutar Tests
Puedes ejecutar los tests con:

```bash
mvn test
```
## 📘 Swagger - Documentación de la API
La documentación Swagger está disponible en la siguiente URL:

http://localhost:5000/swagger-ui/index.html#/product-related-controller/getProductRelated

## 📂 Estructura destacada
* ProductRelatedService: Servicio principal que orquesta la obtención de productos relacionados.
* ProductClient: Cliente Feign que interactúa con otros servicios.
* VSExceptionHandler: Manejador global de excepciones.
* ServiceExceptionDto: DTO de error estándar para respuestas de error uniformes.

## 🛠️ Tecnologías usadas
* Java 17
* Spring Boot
* Spring Web
* Spring Security (opcional o desactivado)
* Feign Client
* Swagger / OpenAPI
* Lombok
* JUnit 5 / Mockito

## 🧑 ‍💻 Autor
Este backend fue desarrollado como parte del examen de acceso al equipo de ITX Mobile Store.
Para más detalles o soporte técnico, contacta al equipo de desarrollo.
