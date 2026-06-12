# Dependencias del Proyecto

## Dependencias de Producción

| GroupId | ArtifactId | Versión | Scope | Propósito |
|----------|----------|----------|----------|----------|
| org.openjfx | javafx-controls | 21.0.2 | compile | Proporciona los controles y componentes gráficos de JavaFX para la interfaz de usuario. |
| org.openjfx | javafx-fxml | 21.0.2 | compile | Permite cargar interfaces definidas en archivos FXML y separar la vista de la lógica. |
| org.xerial | sqlite-jdbc | 3.46.0.0 | runtime | Controlador JDBC para trabajar con bases de datos SQLite. |
| com.mysql | mysql-connector-j | 8.3.0 | runtime | Controlador JDBC para conectarse a bases de datos MySQL. |
| org.postgresql | postgresql | 42.7.0 | runtime | Controlador JDBC para conectarse a bases de datos PostgreSQL. |
| org.apache.poi | poi-ooxml | 5.2.5 | compile | Permite leer, crear y modificar archivos Excel en formato XLSX. |
| org.fxmisc.richtext | richtextfx | 0.11.2 | compile | Proporciona componentes avanzados de texto enriquecido para aplicaciones JavaFX. |
| com.fasterxml.jackson.core | jackson-databind | 2.16.1 | compile | Convierte objetos Java a JSON y viceversa. |
| org.slf4j | slf4j-api | 2.0.12 | compile | API de registro de eventos (logging) utilizada por la aplicación. |
| org.slf4j | slf4j-simple | 2.0.12 | runtime | Implementación simple de SLF4J para mostrar mensajes de log en tiempo de ejecución. |

## Dependencias de Prueba

| GroupId | ArtifactId | Versión | Scope | Propósito |
|----------|----------|----------|----------|----------|
| org.junit.jupiter | junit-jupiter | 5.10.2 | test | Framework principal para la ejecución de pruebas unitarias. |
| org.mockito | mockito-core | 5.10.0 | test | Permite crear objetos simulados (mocks) para aislar dependencias durante las pruebas. |

## Política de Dependencias

### Drivers JDBC

Los controladores JDBC se utilizan únicamente durante la ejecución de la aplicación para establecer conexiones con distintos motores de bases de datos. Por este motivo se consideran dependencias de tipo **runtime**.

En este proyecto se incluyen:

- SQLite JDBC
- MySQL Connector/J
- PostgreSQL JDBC Driver

### Apache POI

Apache POI se utiliza para la importación, exportación y manipulación de archivos Excel. La dependencia `poi-ooxml` permite trabajar con documentos modernos en formato XLSX.

### JUnit y Mockito

Las bibliotecas JUnit y Mockito forman parte del entorno de pruebas y no son necesarias para la ejecución normal de la aplicación.

- **JUnit** se utiliza para escribir y ejecutar pruebas unitarias.
- **Mockito** permite simular dependencias y componentes externos para realizar pruebas aisladas.

Por esta razón ambas dependencias utilizan el scope **test**.

## ¿Por qué JDBC directo y no Hibernate?

El proyecto utiliza JDBC directo en lugar de un framework ORM como Hibernate por las siguientes razones:

- Mantiene una arquitectura más simple y fácil de comprender.
- Permite un control total sobre las consultas SQL ejecutadas.
- Reduce dependencias y complejidad de configuración.
- Facilita el soporte de múltiples motores de bases de datos mediante drivers JDBC estándar.
- Resulta adecuado para aplicaciones donde la capa de persistencia no requiere características avanzadas de un ORM.

Aunque Hibernate ofrece ventajas como mapeo automático de entidades y gestión avanzada de persistencia, JDBC directo proporciona una solución más ligera y suficiente para los requisitos actuales del proyecto.