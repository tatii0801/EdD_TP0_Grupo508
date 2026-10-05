# EdD_Grupo508 - Estructuras de Datos (UNJu)

## 📝 Repositorio General de Trabajos Prácticos - Ciclo 2026

Repositorio unificado que contiene el desarrollo completo de las guías de trabajos prácticos de la materia **Estructura de Datos**, correspondiente al ciclo lectivo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El objetivo de este proyecto es implementar, analizar y optimizar diferentes Tipos de Datos Abstractos (TDA) utilizando el lenguaje **Java**, aplicando manipulación directa de memoria (punteros), optimización asintótica (Complejidad Big O) y buenas prácticas de diseño modular de software.

### Java - POO - Arrays - Stack - Queue - List - Git - GitHub

---

# 👥 Integrantes

**C5 - Grupo 508**

- Nicolas Daniel Anachuri
- Gaston Yamil Gregorio
- Tatiana Valeria Nieva
- Romina Ester Santos
- Santiago Tintilay
- Estefania Alejandra Trujillo

---

# Objetivo General del Repositorio

El objetivo de este espacio es unificar y documentar la evolución del **Grupo 508** en la materia Estructura de Datos. El proyecto recopila de forma incremental el diseño e implementación de soluciones algorítmicas avanzadas, transitando desde la programación estructurada y orientada a objetos hasta la abstracción e ingeniería de Tipos de Datos Abstractos complejos.

Los ejes de aprendizaje centrales consolidados a lo largo de las guías son:

- **Evolución del almacenamiento:** Migración de memoria estática rígida (Arreglos y Matrices) hacia asignación dinámica flexible en el Heap (Pilas, Colas y Listas enlazadas).
- **Abstracción de código:** Aplicación de encapsulamiento estricto, ocultamiento de información y uso de interfaces de herencia.
- **Integridad de datos:** Control estricto de punteros, manejo de excepciones en tiempo de ejecución y diseño de algoritmos que preservan el orden y contenido original de los clientes.
- **Rendimiento:** Análisis crítico del costo computacional de las operaciones primarias en tiempo constante \(O(1)\) frente a costos lineales \(O(n)\) o cuadráticos \(O(n^2)\).
- **Portabilidad y equipo:** Trabajo colaborativo modularizado bajo control de versiones Git/GitHub y automatización de despliegue local.


---

# 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java 17 o superior.
- **Estructuras:** Arreglos Estáticos, Matrices, Pilas (Stack), Colas (Queue), Listas Enlazadas (Simple, Doble y Ordenada).
- **Herramientas:** Visual Studio Code, Maven, Git, GitHub.
- **Automatización:** Script nativo de compilación y ejecución relativa (`run.bat`).

---

# 📂 Estructura General del Repositorio

```text
src/
└── main/
    └── java/
        ├── tp0/             # Programación Básica (Diagnóstico)
        │   ├── ejemplo.java
        │   └── ejercicio[1-6].java
        │
        ├── tp1/             # Programación Orientada a Objetos (POO)
        │   ├── Bateria.java, Cilindro.java, CuentaBancaria.java...
        │   └── ejercicio[1-6].java
        │
        ├── tp2/             # Estructuras Estáticas (Arreglos y Matrices)
        │   └── Ejercicio[1-8].java
        │
        ├── tp3/             # Tipo de Dato Abstracto: Pilas (Stack)
        │   ├── ejemplo/implementaciones/
        │   └── ejercicio[1-7].java (Tarea.java, Pedido.java, Producto.java)
        │
        ├── tp4/             # Tipo de Dato Abstracto: Colas (Queue)
        │   └── ejercicio[1-8].java (Ticket.java, Envio.java, Turno.java, Cliente.java)
        │
        └── tp5/             # Tipo de Dato Abstracto: Listas (List)
            ├── 00_Base_Profesor/  # Estructuras base provistas por la cátedra
            └── [01-10]_Ejercicio[1-10]/
```

---

# 📜 About

• Asignatura: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo Lectivo: 2026  

---

# 📂 Resumen Temático de los Trabajos Prácticos

### 🔹 TP 0: Programación Básica y Estructuras de Control (Diagnóstico)
*   **Contenido:** Auto-evaluación diagnóstica de algoritmos secuenciales, condicionales e iterativos.
*   **Desarrollo:** Control de flujo de sueldos y horas extras, simulación de sensores de temperatura aleatorios, validación de notas académicas, menús geométricos modulares y procesamiento de objetos de la clase `String`.

### 🔹 TP 1: Programación Orientada a Objetos (POO)
*   **Contenido:** Aplicación estricta de encapsulamiento, ocultamiento de información y abstracción de datos.
*   **Desarrollo:** Modelado de clases físicas y de negocio (`Cilindro`, `CuentaBancaria`, `Paciente`, `Reserva`). Depuración de fallos lógicos en el control de estados internos (`Bateria` y `TanqueAgua`) y protección de setters contra valores inválidos.

### 🔹 TP 2: Estructuras Estáticas (Arreglos y Matrices)
*   **Contenido:** Procesamiento contiguo de datos de tamaño fijo en una y dos dimensiones.
*   **Desarrollo:** Desplazamientos circulares e inversión *in-place* de vectores, gestión de vuelos con arreglos paralelos, matrices de ventas bidimensionales (vendedores/días) y análisis comparativo del consumo de memoria en arreglos estáticos frente a `ArrayList`.

### 🔹 TP 3: Tipo de Dato Abstracto - Pilas (Stack)
*   **Contenido:** Implementación y operaciones bajo la política LIFO (Last In, First Out).
*   **Desarrollo:** Algoritmos de inversión de datos (múltiplos de 3), separación de flujos numéricos en pilas transitorias, reemplazos sobre la estructura sin pérdida de orden y gestión de colecciones de objetos (`Tarea`, `Pedido`, `Producto`) utilizando pilas auxiliares de restauración.

### 🔹 TP 4: Tipo de Dato Abstracto - Colas (Queue)
*   **Contenido:** Implementación y operaciones bajo la política FIFO (First In, First Out).
*   **Desarrollo:** Reubicación de señales mediante umbrales controlados por el tamaño original, diseño de la clase `ColaCircular` en arreglos para optimizar la velocidad sin desplazamientos, clasificación de llamadas por longitud y depuración de iteraciones dinámicas destructivas (`eliminarMenores`).

### 🔹 TP 5: Tipo de Dato Abstracto - Listas (List)
*   **Contenido:** Estructuras lineales dinámicas enlazadas y direccionamiento explícito de memoria.
*   **Desarrollo:** Inserción y eliminación por índice en `SimpleLinkedList`, acumulación lineal sobre `DoubleLinkedList` (canciones), conjuntos y apareos ordenados (suscripciones), abstracción mediante el patrón de diseño *Iterator* y refactorización algorítmica de punteros en tándem (`anterior` y `actual`) para el método `eliminarPares`.


