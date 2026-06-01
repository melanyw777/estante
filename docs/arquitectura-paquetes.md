# Arquitectura de Paquetes Java

Este documento describe la estructura de paquetes del proyecto, sus responsabilidades y las reglas de dependencia entre ellos.

## Tabla de Paquetes

| Paquete | Responsabilidad | ¿Qué tipo de clases contiene? | Ejemplo |
|---------|-----------------|------------------------------|---------|
| `modelo` | Define las entidades y objetos de dominio del negocio. | Clases POJO (Plain Old Java Object), entidades, DTOs. | `Usuario`, `Producto`, `Pedido` |
| `core` | Contiene la lógica de negocio central y algoritmos independientes de la infraestructura. | Clases con algoritmos, utilidades matemáticas, validadores. | `Calculadora`, `Validador`, `Contrato` |
| `dao` | Acceso a datos. Abstrae la persistencia (base de datos, archivos, APIs). | Interfaces DAO, implementaciones JDBC, repositorios. | `UsuarioDAO`, `ProductoDAOImpl` |
| `servicio` | Orquesta la lógica de negocio, coordina DAOs y modelos. | Clases de servicio, fachadas, casos de uso. | `UsuarioServicio`, `PedidoServicio` |
| `util` | Funciones auxiliares reutilizables en cualquier capa. | Helpers, formatters, constantes, manejadores de fechas. | `DateUtil`, `StringUtil`, `Formato` |
| `vista` | Presentación de la interfaz de usuario (consola, GUI, web). | Clases de UI, pantallas, formularios, renderizadores. | `VentanaPrincipal`, `PanelLogin` |
| `controller` | Recibe entrada del usuario, delega al servicio y devuelve respuesta a la vista. | Controladores, handlers, listeners de eventos. | `UsuarioController`, `LoginController` |

## Diagrama de Arquitectura en Capas
┌─────────────────────────────────────┐
│            VISTA                    │
│  (Interfaz de usuario: consola,     │
│   GUI, web, renderizadores)         │
└─────────────┬───────────────────────┘
│ llama a
┌─────────────▼───────────────────────┐
│          CONTROLLER                 │
│  (Recibe entrada, valida básica,    │
│   delega al servicio)               │
└─────────────┬───────────────────────┘
│ llama a
┌─────────────▼───────────────────────┐
│          SERVICIO                   │
│  (Lógica de negocio, orquesta       │
│   DAOs y modelos)                   │
└─────────────┬───────────────────────┘
│ llama a
┌─────────────▼───────────────────────┐
│            DAO                      │
│  (Acceso a datos, persistencia,     │
│   consultas a base de datos)        │
└─────────────┬───────────────────────┘
│ llama a
┌─────────────▼───────────────────────┐
│     CORE / MODELO                   │
│  (Entidades de dominio, algoritmos,  │
│   validaciones independientes)      │
└─────────────────────────────────────┘
▲
│ usa
┌─────────────┴───────────────────────┐
│            UTIL                     │
│  (Helpers, formatters, constantes   │
│   compartidas por todas las capas)  │
└─────────────────────────────────────┘

## Reglas de Dependencia

Las flechas indican qué paquete **puede importar** a cuál. **Nunca** en dirección contraria.

| Paquete | Puede importar | **NO** puede importar |
|---------|----------------|----------------------|
| `vista` | `controller`, `util` | `servicio`, `dao`, `core`, `modelo` |
| `controller` | `servicio`, `util`, `modelo` | `dao`, `vista` |
| `servicio` | `dao`, `core`, `modelo`, `util` | `vista`, `controller` |
| `dao` | `core`, `modelo`, `util` | `servicio`, `vista`, `controller` |
| `core` | `modelo`, `util` | `vista`, `controller`, `servicio`, `dao` |
| `modelo` | `util` | `vista`, `controller`, `servicio`, `dao`, `core` |
| `util` | *(ninguno)* | `vista`, `controller`, `servicio`, `dao`, `core`, `modelo` |

### Principios clave

1. **Dependencias solo hacia abajo.** Una capa superior puede usar la inferior, nunca al revés.
2. **`util` es independiente.** No debe importar ningún otro paquete del proyecto (solo librerías externas).
3. **`modelo` es puro.** Solo contiene datos, sin lógica de negocio ni acceso a infraestructura.
4. **`core` no conoce la infraestructura.** Algoritmos y validaciones independientes de base de datos o UI.

## ¿Dónde crear mi clase?

| Si tu clase... | Va en el paquete |
|----------------|------------------|
| Representa un dato/entidad del negocio | `modelo` |
| Accede a base de datos o archivos | `dao` |
| Tiene lógica de negocio compleja | `servicio` |
| Es un algoritmo reutilizable sin dependencias | `core` |
| Muestra información al usuario | `vista` |
| Recibe clicks/inputs del usuario | `controller` |
| Es una función helper usada en varios lugares | `util` |