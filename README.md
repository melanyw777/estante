# Estante

Gestor de base de datos con interfaz gráfica desarrollado en Java y JavaFX.

## Características


🗄️ **Motores soportados**

* MySQL
* SQLite
* PostgreSQL

📤 **Exportación**

* CSV
* JSON
* Excel

✍️ **Editor SQL**

* Historial de consultas
* Favoritos
* Resaltado de sintaxis
* Generador de SQL

🛡️ **Seguridad y ejecución**

* Validación de operaciones DML
* Ejecución asíncrona de consultas

## ¿Qué es?

Estante es una aplicación que permite conectarse, explorar y administrar bases de datos MySQL mediante una interfaz gráfica intuitiva desarrollada con Java y JavaFX.

## ¿Para quién es?

Estante está dirigido a:

- Estudiantes de ingeniería
- Administradores de bases de datos (DBAs)
- Desarrolladores que trabajan con MySQL

## ¿Qué problema resuelve?

Estante ayuda a resolver:

- Tareas comunes de exploración y gestión de bases de datos
- Simplificar la administración de bases de datos para usuarios con menos experiencia técnica
- Visualizar datos de forma clara e intuitiva

## Instalación

### Requisitos del sistema

- Java 17 o superior
- JavaFX SDK compatible con tu versión de Java
- Un servidor MySQL en ejecución (local o remoto)
# Pasos


```bash
# 1. Clona el repositorio:
git clone https://github.com/tu-usuario/estante.git
cd estante

# 2. Compila el proyecto:
mvn compile

# 3. Ejecuta la aplicación:
mvn javafx:run
``` 

## Uso rápido
- Abre Estante y completa los datos de conexión (host, puerto, usuario y contraseña)
- Selecciona la base de datos que deseas explorar
- Navega por los esquemas y tablas desde el panel lateral
- Ejecuta consultas SQL desde el editor integrado y visualiza los resultados en la tabla de resultados

## Documentación
Ver la carpeta [docs/](docs/)

## Contribuir
Ver [CONTRIBUTING.md](CONTRIBUTING.md)

## Licencia
MIT — ver [LICENSE](LICENSE)

# Estante 📚

> Sistema de gestión y organización para bibliotecas y colecciones personales.

<!-- Badge del CI -->
[![validar-pr](https://github.com/sis-inf/estante/actions/workflows/validar-pr.yml/badge.svg)](https://github.com/sis-inf/estante/actions/workflows/validar-pr.yml)

---

## 🚀 Características Principal
El sistema cuenta con un motor flexible y soporte robusto para la gestión de datos:
* **Compatibilidad Multi-Base de Datos:** Soporte completo para motores relacionales como **MySQL**, **SQLite** y **PostgreSQL**.
* **Exportación de Datos:** Herramientas integradas para exportar tus reportes y colecciones directamente a formatos **CSV**, **JSON** y **Excel**.

---

## 🛠️ Compilación Rápida

Para compilar y ejecutar este proyecto de forma local utilizando Maven, ejecuta los siguientes comandos en tu terminal:

```bash
# 1. Compilar el proyecto y descargar dependencias
mvn compile

# 2. Levantar la aplicación con JavaFX
mvn javafx:run

