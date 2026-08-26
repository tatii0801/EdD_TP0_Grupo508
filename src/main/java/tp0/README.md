# EdD_TP0_Grupo508 - Estructura de Datos - TP0

## Trabajo Práctico N° 0 - Programación Básica

Trabajo Práctico desarrollado para la materia **Estructura de Datos**, correspondiente al ciclo 2026 de las carreras **Ingeniería Informática y Licenciatura en Sistemas** de la **Facultad de Ingeniería - Universidad Nacional de Jujuy**.

El trabajo tiene como objetivo realizar una autoevaluación de conocimientos y habilidades básicas de programación utilizando el lenguaje **Java**.

### Java - Scanner - Random - Estructuras de Control - Git - GitHub

---

# Integrantes

**C5 - Grupo 508**

- Nicolas Daniel Anachuri
- Gaston Yamil Gregorio
- Tatiana Valeria Nieva
- Romina Ester Santos
- Santiago Tintilay
- Estefania Alejandra Trujillo

---

# Tecnologías Utilizadas

- Java
- Scanner
- Random
- Maven
- Visual Studio Code
- Git
- GitHub

---

# Estructura del Proyecto

```text
src/
│
└── main/
    └── java/
        │
        ├── tp0/
        │   ├── ejemplo.java
        │   ├── ejercicio1.java
        │   ├── ejercicio2.java
        │   ├── ejercicio3.java
        │   ├── ejercicio4.java
        │   ├── ejercicio5.java
        │   ├── ejercicio6.java
        │   ├── Main.java
        │   └── TP0_01.java
        │
        ├── tp1/
        └── tp2/

pom.xml
README.md
```

---

# Objetivo

Desarrollar diferentes programas en Java para aplicar los conceptos básicos de programación trabajados durante la cursada.

Los principales conceptos utilizados son:

- Variables y tipos de datos.
- Entrada y salida por consola.
- Estructuras secuenciales.
- Estructuras condicionales.
- Estructuras repetitivas.
- Validación de datos.
- Operaciones matemáticas.
- Generación de números aleatorios.
- Manejo de cadenas de caracteres.
- Modularización.

---

# Ejercicios Propuestos

## Ejercicio 1 - Salario de un trabajador

Se desarrolló un programa que calcula el salario neto de un trabajador en función de las horas trabajadas y el valor de la hora.

El programa solicita:

- Nombre del empleado.
- Cantidad de horas trabajadas.
- Valor de la hora.

Si el trabajador supera las 40 horas semanales, se calculan las horas extras con un recargo del 50%.

```text
horasExtras = horasTrabajadas - 40
pagoExtra = horasExtras * (valorHora * 1.5)
```

El salario bruto se obtiene mediante:

```text
salarioBruto = pagoNormal + pagoExtra
```

Luego se aplica el descuento correspondiente:

- Hasta $1.000.000 → 9%.
- Mayor a $1.000.000 y hasta $3.000.000 → 12%.
- Mayor a $3.000.000 → 15%.

Finalmente se muestra:

- Salario bruto.
- Monto del descuento.
- Salario neto.

---

## Ejercicio 2 - Registro de temperaturas

Se desarrolló un programa que simula el registro de temperaturas de un sensor durante un día.

El usuario ingresa la cantidad de mediciones y el programa genera aleatoriamente temperaturas entre **-10°C y 40°C**.

Por cada medición se muestra la temperatura generada.

Al finalizar se calcula:

- Temperatura promedio.
- Cantidad de mediciones consideradas "Heladas".
- Cantidad de mediciones consideradas "Cálidas".

Se considera:

- **Helada:** temperatura menor a 0°C.
- **Cálida:** temperatura mayor o igual a 30°C.

Para generar las temperaturas aleatorias se utiliza `Random`.

---

## Ejercicio 3 - Rendimiento de un estudiante

Se desarrolló un programa que calcula el porcentaje de rendimiento de un estudiante en un examen.

El usuario ingresa:

- Cantidad total de preguntas.
- Cantidad de respuestas correctas.

El porcentaje se calcula mediante:

```text
Porcentaje = (Respuestas correctas / Total de preguntas) * 100
```

El rendimiento se clasifica de la siguiente manera:

- **90% o más:** Excelente.
- **70% a 89,99%:** Muy Bueno.
- **50% a 69,99%:** Aprobado.
- **Menor a 50%:** Desaprobado.

El programa muestra el porcentaje obtenido y la categoría correspondiente.

También se realizan validaciones para evitar datos incorrectos.

---

## Ejercicio 4 - Calculadora de figuras geométricas

Se desarrolló una calculadora mediante un menú de opciones.

```text
1. Área de Cuadrado
2. Área de Triángulo
3. Área de Círculo
4. Salir
```

Según la opción seleccionada, el usuario debe ingresar los valores necesarios para realizar el cálculo.

Las fórmulas utilizadas son:

```text
Área del cuadrado = lado × lado

Área del triángulo = (base × altura) / 2

Área del círculo = π × radio²
```

Se controla que las dimensiones ingresadas no sean negativas.

El menú continúa mostrándose hasta que el usuario selecciona la opción **Salir**.

Para controlar las opciones del menú se utiliza `switch`.

---

## Ejercicio 5 - Números divisibles

Se desarrolló un programa que genera aleatoriamente tres números enteros:

- `limiteInferior` entre 1 y 100.
- `limiteSuperior` entre 101 y 200.
- `divisor` entre 2 y 9.

El programa muestra los valores generados y recorre el rango comprendido entre los límites.

Se muestran todos los números que son divisibles exactamente por el divisor generado.

Finalmente se calcula el promedio entero de los números que cumplen la condición.

También se controla el caso en el que ningún número sea divisible para evitar una división por cero.

---

## Ejercicio 6 - Cadenas de texto

Se desarrolló un programa que solicita al usuario:

- Nombre de una ciudad.
- Nombre de un país.

Luego se concatenan ambas cadenas utilizando una coma y un espacio.

Ejemplo:

```text
San Salvador de Jujuy, Argentina
```

El programa también permite:

- Mostrar la cantidad de caracteres de la ciudad.
- Mostrar la cantidad de caracteres del país.
- Comparar las longitudes.
- Indicar cuál es más larga.
- Indicar si ambas tienen la misma longitud.
- Verificar si la ciudad contiene la letra `ñ`.
- Mostrar la cadena final completamente en minúsculas.

Para trabajar con las cadenas se utilizan métodos de la clase `String`.

---

# Preguntas de los Ejercicios

## Ejercicio 1

### a) ¿Cuáles son las entradas y salidas?

**Entradas:**

- Nombre del empleado.
- Horas trabajadas.
- Valor de la hora.

**Salidas:**

- Salario bruto.
- Descuento.
- Salario neto.

### b) ¿Qué sucede si se ingresa una cantidad negativa de horas?

El valor es inválido, por lo que el programa debe solicitar nuevamente una cantidad válida.

### c) Salario bruto de $2.500.000 y descuento de $375.000

No se calculó correctamente.

Para un salario bruto de $2.500.000 corresponde un descuento del 12%:

```text
2.500.000 × 0,12 = 300.000
```

Por lo tanto, el descuento correcto es de **$300.000**.

### d) ¿Qué sucede si no realizó horas extras?

Se calcula únicamente el pago correspondiente a las horas normales y luego se aplica el descuento correspondiente.

---

## Ejercicio 2

### a) ¿Alcanza una única variable para guardar todas las temperaturas?

No. Una única variable simple solamente puede almacenar un valor a la vez.

Para guardar todo el historial se necesitaría una estructura capaz de almacenar varios valores, por ejemplo un arreglo.

### b) ¿Qué sucede si la cantidad de mediciones es 0?

No se puede calcular el promedio porque implicaría dividir por cero.

El programa debe controlar esta situación y mostrar un mensaje indicando que no hay mediciones para calcular el promedio.

### c) Temperaturas -5, 0, 15 y 35

El promedio es:

```text
(-5 + 0 + 15 + 35) / 4 = 11,25°C
```

Resultados:

- Heladas: **1**
- Cálidas: **1**

### d) Temperatura máxima y mínima

Se necesitarían dos variables:

```text
temperaturaMaxima
temperaturaMinima
```

Durante cada medición se compararían los valores generados para actualizar el máximo y el mínimo.

---

## Ejercicio 3

### a) Validaciones

Se debe controlar que:

- El total de preguntas sea mayor que 0.
- Las respuestas correctas no sean negativas.
- Las respuestas correctas no sean mayores que el total de preguntas.

### b) Porcentaje de 89,995%

El valor **89,995%** corresponde a la categoría **Muy Bueno**, porque es menor a 90%.

Si se desea mostrar exactamente **89,99%**, se debe aplicar el criterio de redondeo o truncamiento correspondiente.

Es importante probar valores cercanos a los límites para comprobar que las condiciones funcionan correctamente.

### c) División utilizando `int`

Si:

```text
correctas = 4
total = 5
```

y se utiliza:

```java
int porcentaje = (correctas / total) * 100;
```

Java realiza una división entera:

```text
4 / 5 = 0
```

Por lo tanto:

```text
0 × 100 = 0
```

El resultado es incorrecto para calcular el porcentaje.

Se debe utilizar `double` para realizar correctamente la división decimal.

---

## Ejercicio 4

### a) `if-else if` o `switch`

Para este menú, `switch` resulta más claro y fácil de mantener porque cada opción tiene un caso determinado.

`if-else if` también permite resolver el problema, pero puede resultar menos organizado cuando existen muchas opciones.

### b) Opción inexistente

Si el usuario ingresa una opción como `9`, el programa debe informar que la opción no es válida y volver a mostrar el menú.

### c) Agregar perímetro de cuadrado

El diseño permite agregar nuevas opciones.

Se debería agregar:

```text
5. Perímetro de Cuadrado
```

y realizar el cálculo:

```text
Perímetro = lado × 4
```

---

## Ejercicio 5

### a) Información necesaria para calcular el promedio

Se deben mantener:

- La suma de los números divisibles.
- La cantidad de números divisibles.

### b) Rango de 10 a 20 con divisor 3

Los números divisibles son:

```text
12
15
18
```

El promedio entero es:

```text
(12 + 15 + 18) / 3 = 15
```

### c) Ningún número divisible

Si ningún número cumple la condición, la cantidad de números divisibles será 0.

No se debe realizar la división porque produciría una división por cero.

El programa debe informar que no se encontraron números divisibles.

### d) Promedio entero

Si la suma es 15 y la cantidad es 2:

Con `int`:

```text
15 / 2 = 7
```

Con `double`:

```text
15 / 2.0 = 7,5
```

Como el ejercicio solicita un promedio entero, se utiliza `int`.

---

## Ejercicio 6

### a) Espacios en blanco

Los espacios al principio y al final del texto no deberían considerarse parte del nombre.

Se puede utilizar:

```java
trim()
```

para eliminarlos antes de contar los caracteres.

### b) `==` o `.equals()`

Para comparar el contenido de cadenas en Java se utiliza `.equals()`.

```java
ciudad.equals(pais)
```

El operador `==` compara referencias de objetos y no es el método adecuado para comparar el contenido de dos `String`.

### c) Campo vacío

Si el usuario presiona Enter sin ingresar ningún texto, se obtiene una cadena vacía.

Su longitud es:

```text
0
```

### d) Comparación de longitud

La expresión:

```java
ciudad.equals(pais)
```

no permite saber cuál cadena es más larga.

Para comparar las longitudes se utiliza:

```java
ciudad.length()
pais.length()
```

---

# Conceptos Aplicados

Durante el desarrollo de los ejercicios se aplicaron los siguientes conceptos:

- Variables.
- Tipos de datos.
- Operadores.
- Entrada de datos.
- Salida de datos.
- Estructuras secuenciales.
- Estructuras condicionales.
- Estructuras repetitivas.
- `Scanner`.
- `Random`.
- `String`.
- Validaciones.
- Modularización.
- Métodos.
- Git y GitHub.

---

# Estructuras de Control

## Estructura Secuencial

Se utilizan instrucciones que se ejecutan una después de otra.

## Estructura de Decisión

Se utilizan:

```java
if
else if
else
switch
```

para tomar decisiones según diferentes condiciones.

## Estructura de Repetición

Se utilizan ciclos para repetir instrucciones:

```java
for
while
```

---

# Entrada de Datos

Para ingresar datos desde la consola se utiliza `Scanner`.

Ejemplo:

```java
Scanner scanner = new Scanner(System.in);
```

Permite ingresar diferentes tipos de datos mediante la consola.

---

# Números Aleatorios

En los ejercicios que requieren generación de valores aleatorios se utiliza la clase `Random`.

Ejemplo:

```java
Random random = new Random();
```

---

# Manejo de Cadenas

En el ejercicio 6 se utilizan diferentes métodos de `String`, entre ellos:

```java
trim()
length()
equals()
contains()
toLowerCase()
```

Estos permiten trabajar y analizar los textos ingresados por el usuario.

---

# Validación de Datos

Los programas realizan diferentes controles para evitar errores durante la ejecución.

Entre ellos:

- Valores negativos.
- Valores fuera de rango.
- Datos inválidos.
- División por cero.
- Opciones inexistentes.
- Respuestas correctas mayores al total.
- Cantidad de mediciones igual a cero.
- Cadenas vacías.

---

# Modularización

Se busca separar las diferentes partes de los programas para mantener un código más ordenado.

Principalmente se separan:

- Ingreso de datos.
- Validación.
- Procesamiento.
- Cálculos.
- Mostrar resultados.

---

# Ejecución

El proyecto utiliza **Maven** para su organización.

Para ejecutar el proyecto se puede utilizar Visual Studio Code o la terminal.

Comando para compilar:

```bash
mvn compile
```

Comando para ejecutar el proyecto según la configuración de Maven:

```bash
mvn exec:java
```

También se puede ejecutar cada clase directamente desde Visual Studio Code.

---

# Git y GitHub

El proyecto utiliza Git para llevar un control de las modificaciones realizadas.

Comandos utilizados:

```bash
git add .
git commit -m "Primer commit TP0"
git push
```

---

# Características del Trabajo

- Programas desarrollados en Java.
- Uso de `Scanner`.
- Uso de `Random`.
- Entrada y salida por consola.
- Estructuras secuenciales.
- Estructuras condicionales.
- Estructuras repetitivas.
- Validación de datos.
- Operaciones matemáticas.
- Manejo de cadenas.
- Modularización.
- Uso de Maven.
- Control de versiones con Git.
- Repositorio en GitHub.

---

# Conclusión

Este Trabajo Práctico N° 0 permitió repasar y aplicar los conceptos básicos de programación utilizando Java.

A través de los seis ejercicios se trabajó con variables, entrada y salida de datos, estructuras de decisión y repetición, validaciones, cálculos matemáticos, números aleatorios y manejo de cadenas.

También permitió familiarizarse con herramientas utilizadas durante la cursada como **Java, Maven, Visual Studio Code, Git y GitHub**.

Los ejercicios sirven como base para continuar trabajando con los contenidos de **Estructura de Datos** durante el ciclo 2026.

---

## About

**Trabajo Práctico N° 0 - Programación Básica**

**Materia:** Estructura de Datos
**Carreras:** Ingeniería Informática - Licenciatura en Sistemas
**Facultad:** Facultad de Ingeniería - Universidad Nacional de Jujuy
**Ciclo:** 2026
**Comisión:** C5
**Grupo:** 508
