# Estructura de Datos - TP N° 5

## Trabajo Práctico N° 5 - Ciclo 2026

**Tema:** Listas  
**Carrera:** Ingeniería Informática – Licenciatura en Sistemas  
**Facultad:** Facultad de Ingeniería – Universidad Nacional de Jujuy  

## Integrantes

- Nicolas Daniel Anachuri
- Tatiana Valeria Nieva
- Romina Ester Santos
- Estefania Alejandra Trujillo

**Grupo:** C5 - Grupo 508

---

## Descripción

En este trabajo práctico se desarrollan ejercicios relacionados con el uso de **Listas (List) en Java**.

Se trabaja con las implementaciones lineales propuestas en clases (`SimpleLinkedList`, `DoubleLinkedList` y listas ordenadas), aplicando manipulación directa de punteros, operaciones de inserción, eliminación, filtrado, ordenamiento y reutilización de estructuras dinámicas.

---

## Ejercicios

### Ejercicio 1 - Inserción y eliminación por posición

Se agregan métodos a la clase `SimpleLinkedList` para insertar y eliminar elementos en una posición específica ingresada por el usuario. 

Se valida el correcto funcionamiento controlando los límites de la lista mediante un menú de opciones y una lista de objetos `Producto`.

---

### Ejercicio 2 - Gestión de canciones y estadísticas

Se utiliza una lista doblemente enlazada con objetos `Cancion` para obtener la canción más antigua y filtrar por artista. 

Además, se genera una nueva lista doble ordenada de mayor a menor con objetos `EstadisticaArtista` que acumulan las duraciones totales de reproducción.

---

### Ejercicio 3 - Intersección y unión de suscripciones

Se crean dos listas simples con objetos `Suscripcion`. 

El programa permite generar una lista con la intersección de usuarios comunes, contar las suscripciones totales de un usuario sumando ambas estructuras y realizar la unión de las dos listas ordenadas por fecha de inicio.

---

### Ejercicio 4 - Gestor de tareas pendientes y futuras

Se implementa la clase `GestorTareas` mediante una lista enlazada simple para administrar objetos `Tarea`. 

Se desarrollan operaciones para agregar, completar, eliminar y listar tareas pendientes o futuras filtradas por un responsable específico.

---

### Ejercicio 5 - Procesamiento de aspirantes y promedios

Se administra una lista de objetos `Aspirante` calculando el promedio individual de sus tres notas. 

El programa identifica al aspirante con el promedio más alto y genera de forma dinámica una nueva lista con los postulantes que aprobaron con una nota mayor o igual a 7.

---

### Ejercicio 6 - Filtrado y ordenamiento de enteros aleatorios

Se genera una lista con N números enteros aleatorios. 

Se implementan métodos para agrupar los números negativos al principio y los positivos al final, sumar los elementos contenidos dentro de un rango numérico [A, B] e insertar los elementos de manera ordenada ascendente en una nueva lista.

---

### Ejercicio 7 - Simulación de pedidos (Drive-Thru) con Queue

Se codifica una implementación de la clase genérica `Queue` (Cola) utilizando internamente una lista del profesor. 

Se simula una cola de pedidos, procesando la estructura para eliminar las cancelaciones (valores iguales a 0) manteniendo el orden original de llegada y calculando el promedio de las mesas válidas.

---

### Ejercicio 8 - Duplicación de múltiplos de 3 con Stack

Se codifica una implementación de la clase genérica `Stack` (Pila) utilizando la estructura de la lista base. 

Se desarrolla un método externo que recorre la pila y duplica los valores que son múltiplos de 3, garantizando que el orden relativo del resto de los elementos de la estructura no se altere.

---

### Ejercicio 9 - Análisis de soluciones (Suma de elementos)

Se analizan y contrastan dos soluciones propuestas por estudiantes para obtener la suma de los elementos de una lista sin modificarla. 

Se evalúa conceptualmente el uso del patrón *Iterator* (for-each) frente a la alteración estructural por rotación de nodos (`removeFirst` y `addLast`).

---

### Ejercicio 10 - Depuración de código (eliminarPares)

Se analiza línea por línea un método defectuoso diseñado para eliminar números pares manipulando los punteros directamente. 

Se identifican errores críticos de saltos de nodos y excepciones `NullPointerException` en el nodo final (`tail`), y se provee la refactorización algorítmica correcta utilizando punteros en tándem (`anterior` y `actual`).

---

## Conceptos utilizados

Durante el trabajo se utilizan principalmente:

- Listas simplemente enlazadas (`SimpleLinkedList`).
- Listas doblemente enlazadas (`DoubleLinkedList`).
- Listas ordenadas (`LinkedOrderedList`).
- Estructuras lineales derivadas (`Queue` y `Stack`).
- Manipulación directa de punteros (`head`, `tail`, `next`, `prev`).
- Patrón de diseño *Iterator* (recorridos for-each).
- Complejidad temporal y eficiencia algorítmica (O(1) y O(n)).
- Gestión de memoria dinámica y Garbage Collector.
- Casos borde (validación de rangos, listas vacías y extremos).
- Modularización de software.
- Carga de datos aleatorios y control del objeto `Scanner`.

---

## Tecnologías

- Java
- Maven
- Visual Studio Code
- Git
- GitHub
- Script de automatización (`run.bat`)

---

## Estructura del proyecto

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
