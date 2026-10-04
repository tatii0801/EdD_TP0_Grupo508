# EdD_Grupo508 - Estructura de Datos - TP4 

## 📝 Trabajo Práctico N° 4 - Colas (Queue)

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo aplicar el Tipo de Dato Abstracto (TDA) **Cola (Queue)** utilizando el lenguaje **Java**, respetando el principio FIFO (First In, First Out) y las reglas de procesamiento sin alterar la estructura original de los datos.

### Java - Queue - LinkedList - Estructuras de Control - Git - GitHub

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

# 🛠️ Tecnologías Utilizadas

- Java
- Queue (TDA)
- LinkedList
- Scanner
- Maven
- Visual Studio Code
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
src
└── main
    └── java
        └── tp4
            ├── ejercicio1
            │   └── Ejercicio1.java
            ├── ejercicio2
            │   └── Ejercicio2.java
            ├── ejercicio3
            │   └── Ejercicio3.java
            ├── ejercicio4
            │   ├── Ejercicio4.java
            │   └── Ticket.java
            ├── ejercicio5
            │   ├── Ejercicio5.java
            │   └── Envio.java
            ├── ejercicio6
            │   ├── Ejercicio6.java
            │   └── Turno.java
            ├── ejercicio7
            │   └── Ejercicio7.java
            └── ejercicio8
                ├── Cliente.java
                └── Ejercicio8.java
```

---

# 📜 About

• Trabajo Práctico N° 4 - Colas (Queue)  
• Materia: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo: 2026  

---

# 📝 Detalle de los Ejercicios

### Ejercicio 1 - Reubicación de señales por umbral
Se ingresan N niveles de señal generados aleatoriamente en una cola. Los elementos que exceden un umbral máximo son retirados y reubicados al final de la estructura, preservando intactos los valores que no lo superan. Además, se genera una nueva cola secundaria con los elementos filtrados por debajo del umbral.

### Ejercicio 2 - Gestión de impresión y cola circular
Se diseña e implementa la clase `ColaCircular` utilizando un arreglo estático optimizado en velocidad para evitar desplazamientos. Se simula una cola de documentos pendientes donde los códigos pares van a una segunda cola de alta prioridad (color) y los impares se imprimen en blanco y negro.

### Ejercicio 3 - Clasificación de llamadas por longitud
Se procesa una secuencia de nombres de clientes ingresados por teclado en una cola de strings. La estructura se divide en tres nuevas colas según la longitud del nombre (cortos, medianos y largos). Al finalizar, se analiza la información de cada una y se vuelven a unir en una cola única en orden de clasificación.

### Ejercicio 4 - Gestión de tickets de soporte técnico
Se administra una cola de soporte mediante objetos de la clase `Ticket` que contienen ID, departamento y nivel de urgencia (1 a 5). El programa permite filtrar colas por departamento, calcular niveles de urgencia promedio, aislar el primer caso crítico e identificar IDs de alta prioridad.

### Ejercicio 5 - Sistema logístico de envíos
Se trabaja con objetos de la clase `Envio` cargados en una cola dinámica para simular la cadena de distribución física de paquetes postales. El algoritmo permite consultar pesos acumulados por destino e identificar el paquete con mayor carga física sin destruir la estructura.

### Ejercicio 6 - Asignación de turnos médicos
Se utiliza la clase `Turno` para simular la cola de espera de una farmacia u hospital según la obra social de los clientes. El sistema maneja de forma fluida el aislamiento de turnos no atendidos y la verificación de estados de atención mediante búsquedas indexadas por DNI.

### Ejercicio 7 - Análisis de soluciones (Contar pares)
Se analizan y contrastan dos soluciones propuestas por estudiantes para contar los números pares dentro de una cola. Se evalúa conceptualmente el impacto de usar un arreglo estático como memoria auxiliar frente al uso de una segunda cola transitoria para restaurar el orden original.

### Ejercicio 8 - Depuración de código (eliminarMenores)
Se analiza línea por línea un método defectuoso que intentaba remover objetos `Cliente` menores de edad dentro de un ciclo `for`. Se corrige el error de control dinámico causado por el método `cola.size()` y se reescribe la lógica fijando el tamaño original para evaluar todos los nodos en una sola pasada.

---

# 🧠 Fundamentos Teóricos y Análisis de Complejidad

Para complementar el desarrollo práctico del **Grupo 508**, se detallan los pilares conceptuales que gobiernan las estructuras lineales de tipo FIFO implementadas en este trabajo práctico:

### 1. Gestión de Memoria Dinámica vs. Estructuras Contiguas (Arreglos)
*   **Colas Enlazadas (`LinkedList`):** La asignación de memoria ocurre en el espacio Heap de forma dinámica y no contigua nodo por nodo. La capacidad estructural es teóricamente ilimitada, restringida únicamente por los recursos del sistema. No requiere operaciones de reajuste de tamaño (*resize*), lo que optimiza la inserción en flujos de datos continuos.
*   **Colas Circulares Basadas en Arreglos:** Utilizan un espacio contiguo preasignado de tamaño fijo. La optimización radical de esta estructura radica en eliminar el desplazamiento de elementos (O(n)) al desencolar. Mediante el uso de punteros aritméticos flotantes (`head` y `tail`) administrados con el operador residuo o módulo matemático (`%`), el frente y el final de la cola rotan de forma lógica sobre los índices del arreglo, logrando un rendimiento de tiempo constante **O(1)** para todas las operaciones primitivas.

### 2. Preservación del Principio de Inmutabilidad de las Estructuras
De acuerdo con las directrices de la asignatura, el análisis o filtrado externo de una cola exige mantener el estado, contenido y orden original intacto al finalizar el método. Al ser una estructura de acceso restringido donde solo es visible el nodo del frente (`peek`), es un requisito algorítmico obligatorio implementar mecanismos de rotación completa controlados por el tamaño original (`cola.size()`) o el respaldo transitorio de los datos desencolados mediante estructuras auxiliares (otra `Queue` o un arreglo local) para su posterior restauración.

### 3. Eficiencia Algorítmica y Complejidad Asintótica (Big O)
*   **Inserción (`add` / `enqueue`) y Extracción (`poll` / `dequeue`):** Presentan una complejidad de **O(1)** tanto en la cola circular indexada como en la enlazada. Esto garantiza que el tiempo de ejecución no dependa del volumen de elementos almacenados en la estructura.
*   **Búsqueda y Filtrado Lineal:** Para operaciones de inspección de propiedades (como el filtrado de tickets por departamento o la clasificación de cadenas por longitud), la complejidad se establece en **O(n)**, requiriendo exactamente n ciclos de control para evaluar la totalidad de la muestra.
*   **Recolección de Basura (Garbage Collector):** En la remoción de nodos dinámicos (como en la depuración de clientes menores de edad), Java administra la liberación de memoria de forma automática. Al romper las referencias físicas de los punteros, los objetos aislados quedan inmediatamente disponibles para el recolector de basura del entorno virtual.
