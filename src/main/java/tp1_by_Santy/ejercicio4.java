package tp1_by_Santy;

import java.util.InputMismatchException;
import java.util.Scanner;

import tp1_by_Santy.classes.Paciente;

/**
 * 4) Desarrollar una clase llamada Paciente para gestionar información de salud
 * básica. Esta clase debe tener los
 * siguientes atributos: nombre, dni, peso (en kg) y altura (en metros). La
 * clase Paciente debe incluir los
 * siguientes métodos:
 * a) Métodos para establecer y obtener el nombre, dni, peso y altura del
 * paciente.
 * b) Un método que calcule y devuelva el Índice de Masa Corporal (IMC)
 * (Fórmula: peso / (altura * altura)).
 * c) Un método que devuelva un String indicando el estado nutricional según el
 * IMC: "Bajo peso" si el IMC
 * es menor a 18.5, "Normal" si está entre 18.5 y 24.9, "Sobrepeso" si está
 * entre 25 y 29.9, y "Obesidad" si
 * es mayor o igual a 30.
 * En el programa principal (main) se debe:
 * d) Crear una instancia de la clase Paciente.
 * e) Solicitar al usuario que ingrese el nombre, el dni, el peso y la altura
 * del paciente, validando que peso y
 * altura sean valores numéricos positivos.
 * f) Utilizar los métodos de la clase Paciente para establecer estos valores.
 * g) Mostrar el nombre del paciente, el dni, el valor de su IMC (formateado a
 * dos decimales) y su estado
 * nutricional.
 * 
 * 
 * Indicaciones:
 * Este ejercicio necesita del objeto scanner para ingresar datos por la consola
 * o teclado, se espera que el
 * código controle los problemas que normalmente ocurren al operar con la
 * consola o teclado.
 * Se espera una correcta modularización entre el código que realiza el ingreso
 * y validación de los datos
 * respecto del código que hace lo que se solicita en el ejercicio.
 * 
 * 
 * Preguntas sobre el problema
 * a) Al diseñar la clase, ¿el IMC debería ser un atributo (ej. double imc;) o
 * solo el resultado de un método de
 * cálculo (ej. calcularIMC())? Tenga en cuenta que inicialmente el peso puede
 * recibir un valor, pero luego
 * se puede invocar al método setter para cambiarlo.
 * b) Encontrar valores de peso y altura tales que los cálculos de IMC
 * correspondientes sean iguales a 24.9 y
 * a 25.0 (Ayuda: fijar un valor para una de las variables y despejar la otra
 * usando la fórmula de IMC).
 * ¿Qué estado nutricional se obtiene en cada caso? ¿Por qué es crucial probar
 * estos límites en las
 * estructuras condicionales?
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
 * 
 * respuesta:
 * 
 * a) El IMC no debería ser un atributo, sino el resultado de un método de cálculo. Esto se 
 * debe a que el IMC depende directamente del peso y la altura del paciente. Si estos valores cambian, el 
 * IMC también cambiará. Mantenerlo como un atributo podría llevar a inconsistencias si no se actualiza 
 * correctamente cada vez que se modifica el peso o la altura.
 * 
 * b) Para obtener un IMC de 24.9, podemos fijar un peso de 70 kg y despejar la altura:
 * IMC = peso / (altura * altura)
 * 24.9 = 70 / (altura * altura)
 * altura * altura = 70 / 24.9
 * altura = sqrt(70 / 24.9) ≈ 1.68 m
 * Para un IMC de 25.0, podemos fijar el mismo peso de 70 kg:
 * 25.0 = 70 / (altura * altura)
 * altura * altura = 70 / 25.0
 * altura = sqrt(70 / 25.0) ≈ 1.67 m
 * En el primer caso, el estado nutricional sería "Normal", mientras que en el segundo caso sería "Sobrepeso". 
 * Probar estos límites es crucial porque asegura que las condiciones en las estructuras condicionales se comporten 
 * correctamente en los puntos críticos, evitando errores de clasificación.
 * 
 * c) Para garantizar que los atributos de la clase Paciente nunca tengan valores negativos, los métodos setter deben 
 * incluir validaciones que verifiquen que los valores proporcionados sean positivos antes de asignarlos a los atributos. Por 
 * ejemplo, en el método setAltura(double altura), se debería incluir una condición que lance una excepción o ignore la asignación 
 * si el valor es negativo. Esto asegura que cualquier intento de establecer un valor inválido sea manejado adecuadamente, manteniendo 
 * la integridad de los datos del objeto.
 * 
 * 
 */

public class ejercicio4 {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("    SISTEMA DE GESTIÓN DE SALUD DE PACIENTES  ");
        System.out.println("==============================================\n");

        // d) Crear una instancia de la clase Paciente (se usará el constructor por defecto y luego los setters)
        Paciente paciente = new Paciente();

        // e) Solicitar datos al usuario con validaciones
        String nombre = leerTextoNoVacio(scanner, "Ingrese el nombre del paciente: ");
        String dni = leerTextoNoVacio(scanner, "Ingrese el DNI del paciente: ");
        double peso = leerDoublePositivo(scanner, "Ingrese el peso en kg (ej. 75.5): ");
        double altura = leerDoublePositivo(scanner, "Ingrese la altura en metros (ej. 1.75): ");

        // f) Utilizar los métodos setters para establecer estos valores
        paciente.setNombre(nombre);
        paciente.setDni(dni);
        paciente.setPeso(peso);
        paciente.setAltura(altura);

        // g) Mostrar resumen con el IMC formateado a dos decimales y estado nutricional
        System.out.println("\n==============================================");
        System.out.println("            INFORME DEL PACIENTE              ");
        System.out.println("==============================================");
        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("DNI: " + paciente.getDni());
        System.out.printf("IMC: %.2f%n", paciente.calcularIMC());
        System.out.println("Estado Nutricional: " + paciente.obtenerEstadoNutricional());
        System.out.println("==============================================\n");
    }

    // =========================================================================
    // MÉTODOS AUXILIARES DE VALIDACIÓN Y MODULARIZACIÓN
    // =========================================================================

    /**
     * Solicita y valida que la entrada por consola sea un número decimal positivo.
     * Captura InputMismatchException para evitar fallos si se ingresan letras.
     */
    private static double leerDoublePositivo(Scanner scanner, String mensaje) {
        double valor = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();

                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El valor debe ser estrictamente positivo (mayor a cero).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un valor numérico válido (ej. 70.5 o 1.75).");
                scanner.nextLine(); // Limpieza de buffer
            }
        }
        return valor;
    }

    /**
     * Valida la lectura de cadenas de texto evitando entradas vacías o saltos de línea residuales.
     */
    private static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                texto = scanner.nextLine(); // Limpieza del buffer si venía de una lectura numérica anterior
            }
        }
        return texto.trim();
    }
}
