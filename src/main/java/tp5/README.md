# EdD_Grupo508 - Estructura de Datos - TP5

## 📝 Trabajo Práctico N° 5 - Listas (List)

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo profundizar en el conocimiento, diseño y desarrollo del Tipo de Dato Abstracto (TDA) **Lista**, analizando sus diferentes variantes estructurales (Listas Simplemente Enlazadas, Doblemente Enlazadas y Listas Ordenadas) y la manipulación directa de punteros.

### Java - List - LinkedList - Pointers - Memory Allocation - Git - GitHub

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

El objetivo de este trabajo práctico es profundizar en el análisis, diseño y codificación de las estructuras de datos dinámicas mediante las variantes del Tipo de Dato Abstracto (TDA) **Lista (List)**.

Durante el desarrollo se trabajan conceptos como:

- Listas simplemente enlazadas (`SimpleLinkedList`)
- Listas doblemente enlazadas con punteros bidireccionales (`DoubleLinkedList`)
- Inserción ordenada automática sobre estructuras dinámicas (`OrderedList`)
- Manipulación e interconexión directa de nodos y punteros (`next` y `prev`)
- Atributos de frontera estructurales (`head`, `tail` y contador `count`)
- Abstracción de recorridos de solo lectura mediante la interfaz `Iterable` / `Iterator`
- Patrón de diseño *Iterator* y bucles for-each para la inmutabilidad de datos
- Análisis de casos borde (Estructuras vacías, mutaciones en extremos cabeza y cola)
- Redireccionamiento coordinado mediante punteros en tándem (`anterior` y `actual`)
- Implementación de TDAs derivados (Colas y Pilas enlazadas) compartiendo código base
- Análisis asintótico de complejidad temporal (**Complejidad Big O**)
- Administración automática de memoria dinâmica y recolección de basura (*Garbage Collector*)

---

# 🛠️ Tecnologías Utilizadas

- Java
- Listas Genéricas (TDA SimpleLinkedList / DoubleLinkedList)
- Colas y Pilas Dinámicas (Queue / Stack)
- Scanner & Randomization Lógica
- Visual Studio Code
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
src
└── main
    └── java
        └── tp5
            ├── 00_Base_Profesor
            │   ├── ILinkedList.java
            │   ├── SimpleLinkedList.java
            │   ├── DoubleLinkedList.java
            │   ├── ILinkedOrderedList.java
            │   ├── DoubleLinkedOrderedList.java
            │   └── Helper.java
            │
            ├── 01_Ejercicio1
            │   ├── Producto.java
            │   └── Principal1.java
            │
            ├── 02_Ejercicio2
            │   ├── Cancion.java
            │   ├── EstadisticaArtista.java
            │   └── Principal2.java
            │
            ├── 03_Ejercicio3
            │   ├── Suscripcion.java
            │   └── Principal3.java
            │
            ├── 04_Ejercicio4
            │   ├── Tarea.java
            │   ├── GestorTareas.java
            │   └── Principal4.java
            │
            ├── 05_Ejercicio5
            │   ├── Aspirante.java
            │   └── Principal5.java
            │
            ├── 06_Ejercicio6
            │   └── Principal6.java
            │
            ├── 07_Ejercicio7
            │   ├── Queue.java
            │   └── Principal7.java
            │
            ├── 08_Ejercicio8
            │   ├── Stack.java
            │   └── Principal8.java
            │
            ├── 09_Ejercicio9
            │   └── Principal9.java
            │
            └── 10_Ejercicio10
                └── Principal10.java
```

---

# 📜 About

• Trabajo Práctico N° 5 - Listas (List)  
• Materia: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo: 2026  

---

# 📝 Detalle de los Ejercicios

### Ejercicio 1 - Inserción y eliminación por posición en SimpleLinkedList
Se agregan métodos a la clase `SimpleLinkedList` para insertar y eliminar elementos en posiciones específicas indicadas por el usuario. Se valida controlando los límites de la estructura mediante un menú de opciones y una lista de objetos `Producto`.

### Ejercicio 2 - Gestión de canciones y lista doblemente ordenada de estadísticas
Se utiliza una lista doblemente enlazada con objetos `Cancion` para obtener la pista más antigua y filtrar por artista. Además, se genera una nueva lista doble ordenada de mayor a menor con objetos `EstadisticaArtista` que acumulan los segundos totales.

### Ejercicio 3 - Intersección y unión ordenada de suscripciones
Se crean dos listas simples con objetos `Suscripcion`. El programa genera una lista con la intersección de usuarios comunes, cuenta las suscripciones totales de un usuario sumando ambas estructuras y realiza la unión ordenada de las dos listas por fecha de inicio.

### Ejercicio 4 - Gestor de tareas pendientes y futuras
Se implementa la clase `GestorTareas` mediante una lista enlazada simple para administrar objetos `Tarea`. Se desarrollan operaciones para agregar, completar, eliminar y listar tareas pendientes o futuras filtradas por un responsable específico.

### Ejercicio 5 - Procesamiento de aspirantes y promedios individuales
Se administra una lista de objetos `Aspirante` calculando el promedio individual de sus tres notas. El programa identifica al aspirante con el promedio más alto y genera de forma dinámica una nueva lista con los postulantes aprobados con nota mayor o igual a 7.

### Ejercicio 6 - Filtrado y ordenamiento de enteros aleatorios
Se genera una lista con N números enteros aleatorios. Se implementan métodos para agrupar los números negativos al principio y los positivos al final, sumar los elementos contenidos dentro de un rango numérico [A, B] e insertar los elementos ordenados de forma ascendente.

### Ejercicio 7 - Simulación de pedidos (Drive-Thru) con Queue enlazada
Se codifica una implementación de la clase genérica `Queue` utilizando internamente una lista genérica. Se simula una cola de pedidos procesando la estructura para eliminar las cancelaciones (valores iguales a 0) manteniendo el orden original de llegada.

### Ejercicio 8 - Duplicación de múltiplos de 3 con Stack enlazada
Se codifica una implementación de la clase genérica `Stack` utilizando la estructura de una lista genérica. Se desarrolla un método externo que recorre la pila y duplica los valores que son múltiplos de 3, garantizando que el orden relativo de los demás elementos no se altere.

### Ejercicio 9 - Análisis de soluciones (Suma de elementos)
Se analizan y contrastan dos soluciones propuestas por estudiantes para obtener la suma de los elementos de una lista sin modificarla. Se evalúa conceptualmente el uso del patrón *Iterator* (for-each) frente a la alteración estructural por rotación de nodos.

### Ejercicio 10 - Depuración de código (eliminarPares)
Se analiza línea por línea un método defectuoso diseñado para eliminar números pares manipulando los punteros directamente. Se identifican errores críticos de saltos de nodos y excepciones `NullPointerException` en la cola, y se provee la refactorización algorítmica correcta con punteros en tándem.
