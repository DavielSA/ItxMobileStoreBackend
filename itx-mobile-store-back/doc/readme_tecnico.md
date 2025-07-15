# 📘 README_TECNICO.md — VirtualShop

---

## 🛠️ Tecnologías Principales

- **Backend:** Java (Spring Boot)
- **Frontend:** Vue.js 2 / 3 *(según stack final acordado)*
- **Base de Datos:** PostgreSQL / MySQL
- **ORM:** JPA / Hibernate
- **Seguridad:** Spring Security + JWT
- **Testing:** JUnit, Mockito, Postman (para API testing)
- **Deploy:** Docker, Jenkins (CI/CD), Nginx (proxy)
- **API REST:** Arquitectura basada en controladores RESTful

---

## 📁 Estructura del Proyecto

/virtualshop │ ├── backend/ │ ├── src/main/java/com/virtualshop │ │ ├── config/ # Configuración global (CORS, seguridad, etc.) │ │ ├── controller/ # Controladores REST │ │ ├── model/ # Entidades JPA │ │ ├── repository/ # Interfaces de persistencia │ │ ├── service/ # Lógica de negocio │ │ ├── dto/ # Objetos de transferencia de datos │ │ └── VirtualShopApp.java # Main App │ └── resources/ │ ├── application.yml # Configuración de entorno │ └── static/ # Recursos estáticos (si aplica) │ ├── frontend/ │ ├── public/ │ ├── src/ │ │ ├── assets/ │ │ ├── components/ │ │ ├── views/ │ │ ├── router/ │ │ └── store/ │ └── vue.config.js │ ├── docker/ │ ├── Dockerfile-backend │ ├── Dockerfile-frontend │ └── docker-compose.yml │ └── README_TECNICO.md

yaml
Copiar
Editar

---

## 🔐 Seguridad

- Autenticación con JWT (JSON Web Tokens)
- Spring Security configurado con roles y filtros
- Validación de entrada con DTOs y `@Valid`
- Protección contra ataques CSRF / CORS

---

## 🧪 Testing

- **Backend:** JUnit5 + Mockito para tests de servicios/repositorios
- **Frontend:** Jest o Vue Test Utils (según la versión de Vue)
- **Postman Collection:** Para probar endpoints

---

## ⚙️ Configuración Inicial

1. Crear BBDD (si es local):

```sql
CREATE DATABASE virtualshop_db;
Variables en application.yml:

yaml
Copiar
Editar
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/virtualshop_db
    username: users
    password: pass
  jpa:
    hibernate:
      ddl-auto: update
Ejecutar backend:

bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
Ejecutar frontend:

bash
Copiar
Editar
npm install
npm run serve
🧰 Scripts Útiles
bash
Copiar
Editar
mvn clean install     # Compilar y testear el backend
npm run lint          # Linting del frontend
docker-compose up     # Levantar todo en contenedores
📦 Docker
yaml
Copiar
Editar
version: '3.8'
services:
  backend:
    build: ./backend
    ports:
      - "8080:8080"
  frontend:
    build: ./frontend
    ports:
      - "3000:80"
  db:
    image: postgres
    environment:
      POSTGRES_DB: virtualshop_db
