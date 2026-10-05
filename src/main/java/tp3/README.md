# EdD_Grupo508 - Estructura de Datos - TP3 

## 📝 Trabajo Práctico N° 3 - Pilas (Stack)

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo aplicar el Tipo de Dato Abstracto (TDA) **Pila (Stack)** utilizando el lenguaje **Java**, respetando el principio LIFO (Last In, First Out) y las reglas de procesamiento mediante el uso de estructuras auxiliares sin alterar el orden original de los datos.

### Java - Stack - Pilas Auxiliares - Encapsulamiento - Estructuras de Control - Git

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

El objetivo de este trabajo práctico es estudiar, diseñar y utilizar el Tipo de Dato Abstracto (TDA) **Pila (Stack)** utilizando una política de acceso restrictivo LIFO (Last In, First Out) en Java.

Durante el desarrollo se trabajan conceptos como:

- Estructuras de datos lineales y dinámicas
- Operaciones primitivas de apilado (`push()`)
- Operaciones de desapilado (`pop()`) y lectura de cima (`peek()`)
- Control de desbordamiento y estados mediante `isEmpty()` y `size()`
- Patrón de procesamiento destructivo mediante desapilado secuencial
- Uso de Pilas Auxiliares transitorias para la preservación de datos
- Restauración del orden relativo original de los elementos
- Inversión de secuencias lógicas utilizando la propiedad nativa de la pila
- Filtrado, búsqueda y mutación de atributos sobre objetos encolados
- Abstracción de tipos mediante colecciones genéricas


---

# 🛠️ Tecnologías Utilizadas

- Java
- Stack (TDA)
- Scanner
- Random
- Visual Studio Code
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
src
└── main
    └── java
        └── tp3
            ├── ejemplo\implementaciones
            │   ├── Main.java
            │   ├── StackChar.java
            │   └── StackGenerica.java
            ├── ejercicio1
            │   └── Ejercicio1.java
            ├── ejercicio2
            │   └── Ejercicio2.java
            ├── ejercicio3
            │   └── Ejercicio3.java
            ├── ejercicio4
            │   ├── Ejercicio4.java
            │   └── Tarea.java
            ├── ejercicio5
            │   └── Pedido.java
            ├── ejercicio6
            │   └── Ejercicio6.java
            └── ejercicio7
                ├── Ejercicio7.java
                └── Producto.java
```

---

# 📜 About

• Trabajo Práctico N° 3 - Pilas (Stack)  
• Materia: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo: 2026  

---

# 📝 Detalle de los Ejercicios

### Ejercicio 1 - Separación de números positivos y negativos
Se generan 15 números aleatorios entre -20 y 20 y se cargan en una pila. Luego se separan los números positivos y negativos en dos pilas diferentes calculando el valor máximo y mínimo de cada una, manteniendo la pila original sin modificaciones.

### Ejercicio 2 - Inversión de números múltiplos de 3
Dado un arreglo de números enteros, se utiliza una estructura de tipo pila para invertir únicamente el orden de aquellos elementos que son múltiplos de 3, manteniendo el resto del arreglo en su posición original.

### Ejercicio 3 - Operaciones aritméticas y modificaciones sobre una pila
Se genera una pila de números enteros aleatorios y se implementan métodos externos para eliminar divisores exactos de un número X, reemplazar elementos impares por 0, contar valores mayores a la cima e intercambiar el elemento del extremo con el nodo central.

### Ejercicio 4 - Gestión de tareas pendientes por prioridad
Se crea la clase `Tarea` con ID, prioridad y descripción. Las tareas pendientes se almacenan en una pila y se desarrollan algoritmos para agregar elementos, buscar por ID, contar tareas de prioridad alta y remover nodos según la prioridad indicada sin alterar el orden.

### Ejercicio 5 - Simulación de procesamiento de deudas y pedidos
Se diseña la clase `Pedido` que contiene monto y estado de pago. El programa almacena los registros en una pila, permitiendo marcar pedidos como pagados de forma remota, calcular la deuda acumulada total y vaciar físicamente los elementos ya abonados de la estructura.

### Ejercicio 6 - Análisis comparativo de conversión de pila a arreglo
Se evalúan dos propuestas para transformar una pila de enteros en un arreglo estático respetando el orden de salida de la cima. Se analiza el método nativo `toArray()` (Solución A) frente al desapilado manual controlado por estructuras auxiliares (Solución B).

### Ejercicio 7 - Depuración de búsquedas y descuentos en productos
Se analiza y corrige una solución propuesta por un alumno para aplicar un descuento del 10% a un objeto `Producto` mediante su ID. Se reescribe la lógica resolviendo problemas de comparación de `String` (`==` por `.equals()`) y controlando la restauración total de la estructura.
