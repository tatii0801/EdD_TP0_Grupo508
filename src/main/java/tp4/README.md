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

# Objetivo

El objetivo de este trabajo práctico es conocer, distinguir, desarrollar y utilizar las implementaciones y operaciones del Tipo de Dato Abstracto (TDA) **Cola (Queue)** bajo la política de procesamiento FIFO (First In, First Out).

Durante el desarrollo se trabajan conceptos como:

- Colas dinámicas lineales mediante `LinkedList`
- Operaciones de inserción (`add()` / `enqueue()`)
- Operaciones de extracción (`poll()` / `dequeue()`)
- Consulta de frente (`peek()`) sin alteración del nodo
- Implementación de `ColaCircular` de tamaño fijo sobre arreglos estáticos
- Rotación lógica de índices flotantes (`head` y `tail`)
- Operador residuo o módulo matemático (`%`) para desbordamientos circulares
- Bucles de control limitados de forma estricta por el `size()` original
- Uso de Colas Auxiliares de respaldo para cumplir con el principio de inmutabilidad
- Procesamiento y clasificación de flujos contiguos según propiedades de objetos
- Control de excepciones de tipo `NullPointerException` en elementos terminales

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
Se ingresan N niveles de señal aleatorios en una cola. Los elementos que exceden un umbral máximo son retirados y reubicados al final de la estructura. Además, se genera una nueva cola secundaria con los elementos filtrados por debajo de dicho valor.

### Ejercicio 2 - Impresión y cola circular de tamaño fijo
Se diseña la clase `ColaCircular` utilizando un arreglo para evitar desplazamientos de memoria. Se simula una cola de documentos donde los códigos pares van a una segunda cola de alta prioridad (color) y los impares se imprimen en blanco y negro.

### Ejercicio 3 - Clasificación de llamadas por longitud de nombres
Se procesa una secuencia de nombres de clientes ingresados por teclado en una cola de Strings. La estructura se divide en tres nuevas colas según la longitud del nombre (cortos, medianos y largos). Al finalizar se calcula el nombre más largo y se unifican en una cola final.

### Ejercicio 4 - Soporte técnico y gestión de tickets
Se administra una cola de soporte mediante objetos de la clase `Ticket` (con ID, departamento y urgencia). El programa permite filtrar colas por departamento, calcular urgencias promedio, aislar el primer caso crítico e identificar IDs de alta prioridad.

### Ejercicio 5 - Sistema logístico de procesamiento de envíos
Se trabaja con objetos de la clase `Envio` cargados en una cola dinámica para simular la cadena de distribución física de paquetes postales. El algoritmo permite consultar pesos acumulados por destino e identificar el paquete con mayor carga física.

### Ejercicio 6 - Asignación de turnos y obras sociales en farmacia
Se utiliza la clase `Turno` para simular la cola de espera de una farmacia u hospital. El sistema maneja de forma fluida el aislamiento de turnos no atendidos, la cuenta por obra social y la verificación de estados de atención mediante búsquedas por DNI.

### Ejercicio 7 - Análisis de soluciones (Contar pares)
Se analizan y contrastan dos soluciones propuestas por estudiantes para contar números pares dentro de una cola. Se evalúa conceptualmente el impacto de usar un arreglo estático como memoria auxiliar frente al uso de una segunda cola transitoria para restaurar el orden original.

### Ejercicio 8 - Depuración de código (eliminarMenores)
Se analiza línea por línea un método defectuoso que intentaba remover objetos `Cliente` menores de edad dentro de un ciclo `for`. Se corrige el error de control dinámico causado por el método `cola.size()` y se reescribe la lógica fijando el tamaño original.
