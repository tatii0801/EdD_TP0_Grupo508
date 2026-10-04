# EdD_Grupo508 - Estructura de Datos - TP2 

## 📝 Trabajo Práctico N° 2 - Estructuras de Datos Estáticas (Arreglos y Matrices)

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo resolver problemas lógicos utilizando estructuras de almacenamiento contiguas de tamaño fijo (arreglos unidimensionales y matrices bidimensionales) bajo el paradigma orientado a objetos, analizando problemas de ordenamiento, búsquedas lineales y consistencia de datos paralelos.

### Java - Arreglos - Matrices - Arreglos Paralelos - Colecciones - Git

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

# Objetivo

El objetivo de este trabajo práctico es comprender y aplicar los conceptos de estructuras de datos estáticas contiguas mediante la manipulación de vectores unidimensionales y matrices bidimensionales en Java.

Durante el desarrollo se trabajan conceptos como:

- Arreglos unidimensionales primitivos
- Matrices bidimensionales (Filas y Columnas)
- Arreglos paralelos de datos sincronizados
- Colecciones dinámicas mediante `ArrayList`
- Recorridos e indexación de celdas en memoria
- Bucles anidados para matrices
- Algoritmos de ordenamiento e inversión *in-place*
- Búsquedas lineales por coincidencia de atributos
- Conteo, acumulación y cálculo de promedios
- Consistencia de punteros e índices de frontera
- Modularización de operaciones estáticas sobre vectores

---

# 🛠️ Tecnologías Utilizadas

- Java
- Arreglos Primitivos (`int[]`, `char[]`)
- Matrices Bidimensionales (`double[][]`)
- ArrayList (Colecciones dinámicas de objetos)
- Visual Studio Code
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
src
└── main
    └── java
        └── tp2
            ├── Ejercicio1.java
            ├── Ejercicio2.java
            ├── Ejercicio3.java
            ├── Ejercicio4.java
            ├── Ejercicio5.java
            ├── Ejercicio6.java
            ├── Ejercicio7.java
            └── Ejercicio8.java
```

---

# 📜 About

• Trabajo Práctico N° 2 - Arreglos y Matrices  
• Materia: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo: 2026  

---

# 📝 Detalle de los Ejercicios

### Ejercicio 1 - Desplazamiento aritmético e inversión de arreglos
Se cargan N enteros aleatorios en un arreglo estático. Se desarrollan métodos independientes para desplazar circularmente los valores una posición hacia la izquierda, acumular las sumas de positivos y negativos de forma separada, e invertir el orden de los elementos modificando el vector original *in-place*.

### Ejercicio 2 - Control de vuelos mediante arreglos paralelos
Se gestiona el estado de operaciones de un aeródromo guardando la información en dos vectores paralelos (ID de vuelo y estado). El programa implementa búsquedas lineales de estados, filtrado de datos y un algoritmo de reorganización para agrupar los vuelos cancelados al final de las estructuras de forma sincronizada.

### Ejercicio 3 - Análisis y filtrado de cadenas de caracteres
Se procesa un arreglo de tipo `char` para buscar caracteres duplicados (ignorando mayúsculas y minúsculas), aislar la primera vocal junto con la última consonante, y generar un sub-arreglo limpio que almacene de manera exclusiva los dígitos numéricos encontrados.

### Ejercicio 4 - Sistema de estadísticas y descenso de la Liga de Equipos
Se administra un arreglo de objetos `Equipo` de fútbol. El software procesa de forma modular el total de partidos jugados de la liga, calcula el promedio general de puntajes e identifica cuáles instituciones se encuentran con marcas inferiores para marcarlas en "zona de descenso".

### Ejercicio 5 - Simulación de biblioteca personal (ISBN único)
Se modela un sistema de almacenamiento de objetos `Libro` sobre colecciones. Se programan validaciones previas para evitar la duplicación de claves de seguridad ISBN, permitiendo realizar búsquedas textuales, modificaciones en línea de autores y borrado físico con reajuste de índices contiguos.

### Ejercicio 6 - Matriz bidimensional de control de ventas comerciales
Se procesa una matriz donde las filas representan vendedores y las columnas los días del mes. El algoritmo calcula los totales acumulados por empleado, los promedios diarios de rendimiento comercial, detecta las coordenadas físicas (fila/columna) del monto récord e identifica cuántos vendedores superaron el objetivo global.

### Ejercicio 7 - Análisis comparativo de filtrado de números pares
Se comparan dos soluciones estudiantiles para extraer números pares a un vector nuevo. Se analiza la ineficiencia de la Solución A al generar espacios vacíos nulos y se valida el correcto diseño de la Solución B, la cual realiza una pasada previa de conteo para instanciar el arreglo con la dimensión exacta del resultado.

### Ejercicio 8 - Depuración de lógica y encapsulamiento en RRHH
Se analiza y refactoriza un programa de gestión de objetos `Empleado` que contenía graves fallos lógicos. Se corrige el bucle de búsqueda para evitar falsos negativos en los mensajes de salida por pantalla y se reescribe el algoritmo del sueldo máximo para evitar la destrucción accidental de los datos del objeto líder.
