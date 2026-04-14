# LearningPlatform

API REST para la gestión de cursos de una plataforma de aprendizaje en línea, desarrollada con **Spring Boot**.

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Java | 25 |
| Spring Boot | 4.0.5 |
| Spring Data JPA | — |
| H2 Database (en memoria) | — |
| Lombok | — |
| Spring Boot Actuator | — |
| Maven | — |

---

## 🚀 Cómo ejecutar el proyecto

### Requisitos previos
- Java 25 instalado
- Maven instalado (o usar el wrapper incluido `mvnw`)

### Pasos

```bash
# Clonar el repositorio
git clone https://github.com/renatoaravena/LearningPlatform.git
cd LearningPlatform/LearningPlatform

# Ejecutar la aplicación
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

---

## 📡 Endpoints de la API

Base URL: `/api/cursos`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/cursos/disponibles` | Lista todos los cursos activos, ordenados alfabéticamente |
| `GET` | `/api/cursos/no-disponibles` | Lista todos los cursos inactivos, ordenados alfabéticamente |
| `GET` | `/api/cursos/todos-los-cursos` | Lista todos los cursos (activos e inactivos) |
| `POST` | `/api/cursos/agregar` | Agrega un nuevo curso |
| `PUT` | `/api/cursos/actualizar/{id}` | Actualiza un curso existente por ID |
| `DELETE` | `/api/cursos/eliminar/{id}` | Elimina un curso por ID |

### Ejemplos de uso

#### Obtener cursos disponibles
```bash
curl http://localhost:8080/api/cursos/disponibles
```

#### Agregar un curso
```bash
curl -X POST http://localhost:8080/api/cursos/agregar \
  -H "Content-Type: application/json" \
  -d '{"id": 5, "nombre": "Kubernetes Avanzado", "descripcion": "Orquestación de contenedores", "activo": true}'
```

#### Actualizar un curso
```bash
curl -X PUT http://localhost:8080/api/cursos/actualizar/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Spring Boot Avanzado", "descripcion": "Microservicios con Spring", "activo": true}'
```

#### Eliminar un curso
```bash
curl -X DELETE http://localhost:8080/api/cursos/eliminar/1
```

---

## 🗄️ Datos de ejemplo (precargados)

Al iniciar la aplicación, se cargan automáticamente 4 cursos en memoria:

| ID | Nombre | Descripción | Activo |
|---|---|---|---|
| 1 | Spring Boot Basico | Introduccion a microservicios | ✅ |
| 2 | Docker para Desarrolladores | Gestion de contenedores | ✅ |
| 3 | Arquitectura de Software | Patrones y diseño | ❌ |
| 4 | Bases de Datos con JPA | Persistencia de datos | ✅ |

> ⚠️ Los datos se almacenan **en memoria**. Al reiniciar la aplicación, se pierden los cambios y se vuelve a la lista original.

---

## 🔍 Herramientas adicionales

### Consola H2
Disponible en `http://localhost:8080/h2-console`

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:learningdb` |
| Usuario | `sa` |
| Contraseña | *(vacía)* |

### Actuator (Health Check)
```bash
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/info
```

---

## 📁 Estructura del proyecto

```
LearningPlatform/
└── src/
    └── main/
        ├── java/com/duoc/LearningPlatform/
        │   ├── LearningPlatformApplication.java   # Clase principal
        │   ├── controller/
        │   │   └── CursoController.java           # Endpoints REST
        │   ├── model/
        │   │   └── Curso.java                     # Entidad Curso
        │   ├── repository/
        │   │   └── CursoRepository.java           # Acceso a datos (en memoria)
        │   └── services/
        │       └── CursoService.java              # Lógica de negocio
        └── resources/
            └── application.properties             # Configuración
```
