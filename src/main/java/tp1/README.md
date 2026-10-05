# EdD_Grupo508 - Estructura de Datos - TP1 

## 📝 Trabajo Práctico N° 1 - Programación Orientada a Objetos (POO)

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo aplicar los pilares fundamentales de la Programación Orientada a Objetos utilizando **Java**, haciendo especial énfasis en el encapsulamiento estricto, la abstracción, el diseño deconstructivo de clases y la validación de estados internos mediante constructores y métodos mutadores (*setters*).

### Java - POO - Encapsulamiento - Constructores - Objetos - Git

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

El objetivo de este trabajo práctico es aplicar los conceptos básicos de la **Programación Orientada a Objetos** mediante la creación y utilización de clases y objetos en Java.

Durante el desarrollo se trabajan conceptos como:

- Clases
- Objetos
- Atributos
- Métodos
- Constructores
- Encapsulamiento
- Getters y Setters
- Validaciones
- Métodos `toString()`
- Manejo de fechas
- `LocalDate`
- Retorno de valores
- Estructuras condicionales
- Manejo de objetos

---

# 🛠️ Tecnologías Utilizadas

- Java
- Scanner
- LocalDate (Java Time API)
- Visual Studio Code
- Git
- GitHub

---

# 📂 Estructura del Proyecto

```text
src
└── main
    └── java
        └── tp1
            ├── Bateria.java
            ├── Cilindro.java
            ├── Cilindro1.java
            ├── CuentaBancaria.java
            ├── Ejercicio1.java
            ├── Ejercicio1ConExcepcion.java
            ├── Ejercicio2.java
            ├── Ejercicio3.java
            ├── Ejercicio4.java
            ├── Ejercicio5.java
            ├── Ejercicio6.java
            ├── Libro.java
            ├── Paciente.java
            ├── Principal.java
            ├── Reserva.java
            └── TanqueAgua.java
```

---

# 📜 About

• Trabajo Práctico N° 1 - Programación Orientada a Objetos  
• Materia: Estructura de Datos  
• Carreras: Ingeniería Informática - Licenciatura en Sistemas  
• Facultad: Facultad de Ingeniería - Universidad Nacional de Jujuy  
• Comisión: C5  
• Grupo: 508  
• Ciclo: 2026  

---

# 📝 Detalle de los Ejercicios

### Ejercicio 1 - Modelado geométrico tridimensional (Cilindro)
Se diseña la clase `Cilindro` con atributos encapsulados para radio y altura. Incluye constructores parametrizados y métodos especializados para calcular el volumen y el área de la superficie total, validando que las dimensiones ingresadas en el `main` sean estrictamente positivas.

### Ejercicio 2 - Simulación de transacciones de Cuenta Bancaria
Se construye la clase `CuentaBancaria` que modela el comportamiento de fondos financieros. Los métodos depositar y retirar gestionan el saldo de forma segura, controlando que no se extraiga más dinero del disponible y manejando respuestas mediante flags booleanos.

### Ejercicio 3 - Sistema de gestión y prórrogas de Reservas de Hotel
Se implementa la clase `Reserva` utilizando la API de fechas de Java (`LocalDate`). El objeto valida de forma autónoma que la fecha de check-in sea anterior al check-out, calcula días faltantes o transcurridos y simula extensiones cronológicas de estadía.

### Ejercicio 4 - Registro de salud y estado nutricional (Paciente)
Se diseña la clase `Paciente` para calcular el Índice de Masa Corporal (IMC). El sistema evalúa el rango numérico obtenido y devuelve el diagnóstico nutricional correspondiente (Bajo peso, Normal, Sobrepeso u Obesidad), controlando la inmutabilidad de la altura y peso negativos en los setters.

### Ejercicio 5 - Control de carga y consumo de Baterías
Se analizan y contrastan dos soluciones de software para la clase `Bateria`. Se demuestra cómo la Solución B aplica un correcto principio de encapsulamiento al contener la lógica de límites (0-100) dentro del objeto, evitando que operaciones externas de consumo corrompan el estado del dispositivo.

### Ejercicio 6 - Depuración y consistencia en Tanque de Agua
Se detectan y solucionan errores críticos de lógica en la clase `TanqueAgua`. Se refactoriza el código para privatizar los atributos de capacidad máxima y cantidad actual, asegurando que los métodos agregar y retirar agua mantengan la estructura estable ante desbordamientos o vaciados extremos.
