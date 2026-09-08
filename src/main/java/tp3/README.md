# Estructura de Datos - TP N° 3

## Trabajo Práctico N° 3 - Ciclo 2026

**Tema:** Pilas  
**Carrera:** Ingeniería Informática – Licenciatura en Sistemas  
**Facultad:** Facultad de Ingeniería – Universidad Nacional de Jujuy  

## Integrantes

- Nicolas Daniel Anachuri
- Gaston Yamil Gregorio
- Tatiana Valeria Nieva
- Romina Ester Santos
- Santiago Tintilay
- Estefania Alejandra Trujillo

**Grupo:** C5 - Grupo 508

---

## Descripción

En este trabajo práctico se desarrollan ejercicios relacionados con el uso de **Pilas (Stack) en Java**.

Se trabaja con la implementación de Stack propuesta en clases y se aplican operaciones de carga, extracción, búsqueda, modificación y reorganización de elementos.

También se utilizan pilas de números enteros y pilas de objetos.

---

## Ejercicios

### Ejercicio 1 - Separación de números

Se generan números aleatorios y se cargan en una pila.

Luego se separan los números positivos y negativos en dos pilas diferentes y se obtiene el valor máximo y mínimo de cada una.

La pila original debe mantenerse sin modificaciones.

---

### Ejercicio 2 - Inversión de múltiplos de 3

Se trabaja con un arreglo de números enteros.

Utilizando una pila, se invierte únicamente el orden de los números que son múltiplos de 3, manteniendo el resto de los elementos sin modificaciones.

---

### Ejercicio 3 - Operaciones sobre una pila

Se genera una pila de números enteros aleatorios y se implementan diferentes métodos para:

- Eliminar divisores exactos de un número X.
- Reemplazar números impares por 0.
- Contar elementos mayores al elemento de la cima.
- Intercambiar la cima con el elemento de la mitad de la pila.

---

### Ejercicio 4 - Gestión de tareas

Se crea la clase `Tarea` con los atributos:

- ID de tarea.
- Prioridad.
- Descripción.

Las tareas pendientes se almacenan en una pila.

El programa permite:

- Agregar tareas.
- Buscar tareas por ID.
- Contar tareas de prioridad Alta.
- Eliminar tareas según su prioridad.

---

### Ejercicio 5 - Gestión de pedidos

Se crea la clase `Pedido` con:

- ID del pedido.
- Monto.
- Estado de pago.

Se utiliza una pila para almacenar los pedidos.

El programa permite:

- Agregar pedidos.
- Marcar pedidos como pagados.
- Calcular la deuda total.
- Eliminar los pedidos que ya fueron pagados.

---

### Ejercicio 6 - Pila a arreglo

Se implementan y analizan dos soluciones para convertir una pila de enteros en un arreglo.

El arreglo debe mantener el mismo orden en que los elementos salen de la pila y la pila original debe conservarse sin modificaciones.

---

### Ejercicio 7 - Gestión de productos

Se analiza y corrige una solución para buscar un producto dentro de una pila y aplicarle un descuento del 10%.

Se trabaja especialmente con:

- Comparación de `String`.
- Encapsulamiento.
- Pilas auxiliares.
- Restauración del orden original.

---

## Conceptos utilizados

Durante el trabajo se utilizan principalmente:

- Pilas `Stack`.
- Operaciones `push()` y `pop()`.
- `peek()`.
- `isEmpty()`.
- `size()`.
- Pilas auxiliares.
- Arreglos.
- Objetos.
- Clases.
- Métodos.
- Encapsulamiento.
- Búsqueda de elementos.
- Recorridos.
- Contadores y acumuladores.
- Números aleatorios.
- Validación de datos.
- `Scanner`.

---

## Tecnologías

- Java
- Maven
- Visual Studio Code
- Git
- GitHub

---

## Estructura del proyecto

```text
src
└── main
    └── java
        └── tp3
            ├── ejercicio1
            ├── ejercicio2
            ├── ejercicio3
            ├── ejercicio4
            ├── ejercicio5
            ├── ejercicio6
            └── ejercicio7