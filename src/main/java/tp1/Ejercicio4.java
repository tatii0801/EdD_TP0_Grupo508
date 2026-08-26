package tp1;

// Programa principal para gestionar los datos de un paciente.

import java.util.Scanner;

/*
 * Enunciado:
 *
 * Crear una instancia de Paciente.
 *
 * Solicitar nombre, DNI, peso y altura.
 *
 * Validar que peso y altura sean positivos.
 *
 * Mostrar:
 * - Nombre
 * - DNI
 * - IMC
 * - Estado nutricional
 */

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos una instancia de Paciente.
        Paciente paciente = new Paciente();

        System.out.println("===== EJERCICIO 4 =====");

        // Ingresamos el nombre.
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        // Ingresamos el DNI.
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();

        double peso;

        // Validamos el peso.
        do {

            System.out.print("Ingrese el peso en kg: ");
            peso = scanner.nextDouble();

            if (peso <= 0) {
                System.out.println(
                        "Error: el peso debe ser positivo.");
            }

        } while (peso <= 0);

        double altura;

        // Validamos la altura.
        do {

            System.out.print(
                    "Ingrese la altura en metros: ");

            altura = scanner.nextDouble();

            if (altura <= 0) {
                System.out.println(
                        "Error: la altura debe ser positiva.");
            }

        } while (altura <= 0);

        // Establecemos los datos en el objeto.
        paciente.setNombre(nombre);
        paciente.setDni(dni);
        paciente.setPeso(peso);
        paciente.setAltura(altura);

        // Calculamos el IMC.
        double imc = paciente.calcularIMC();

        // Mostramos los resultados.
        System.out.println("\n===== DATOS DEL PACIENTE =====");

        System.out.println(
                "Nombre: " + paciente.getNombre());

        System.out.println(
                "DNI: " + paciente.getDni());

        System.out.printf(
                "IMC: %.2f%n",
                imc);

        System.out.println(
                "Estado nutricional: "
                        + paciente.estadoNutricional());

        scanner.close();
    }
}

/*
 * Preguntas sobre el problema
 * a) Al diseñar la clase, ¿el IMC debería ser un atributo (ej. double imc;) o
 * solo el resultado de un método de
 * cálculo (ej. calcularIMC())? Tenga en cuenta que inicialmente el peso puede
 * recibir un valor, pero luego
 * se puede invocar al método setter para cambiarlo.
 * El IMC no debería ser un atributo porque depende del peso y la altura. Si
 * alguno cambia mediante un setter, el IMC también cambia. Por eso es mejor
 * calcularlo mediante calcularIMC().
 * 
 * b) Encontrar valores de peso y altura tales que los cálculos de IMC
 * correspondientes sean iguales a 24.9 y
 * a 25.0 (Ayuda: fijar un valor para una de las variables y despejar la otra
 * usando la fórmula de IMC).
 * ¿Qué estado nutricional se obtiene en cada caso? ¿Por qué es crucial probar
 * estos límites en las
 * estructuras condicionales?
 * Para obtener un IMC de 24.9 y 25.0 se pueden utilizar, por ejemplo, distintos
 * valores de peso y altura aplicando:
 * 
 * IMC = peso / altura²
 * 
 * Un IMC de 24.9 corresponde a Normal, mientras que 25.0 corresponde a
 * Sobrepeso. Estos límites son importantes porque una pequeña diferencia puede
 * cambiar la categoría.
 * 
 * c) Un compañero escribe la validación de la altura de una persona en el
 * método main de esta manera:
 * if (altura > 0) {
 * paciente.setAltura(altura);
 * }
 * Sin embargo, más tarde descubre que usando los setters de forma directa
 * alguien pudo asignarle una
 * altura de -2 al objeto. ¿Qué falta en el diseño de la clase Paciente para
 * garantizar que sus atributos
 * NUNCA tengan valores negativos sin importar quién use la clase? Argumente
 * sobre cómo deberían ser
 * los métodos setter.
 * No alcanza con validar solamente en main. Los setters también deben validar:
 * 
 * public void setAltura(double altura) {
 * if (altura > 0) {
 * this.altura = altura;
 * }
 * }
 * 
 * Así, aunque otro programa utilice directamente setAltura(-2), el objeto no
 * aceptará el valor.
 * 
 */