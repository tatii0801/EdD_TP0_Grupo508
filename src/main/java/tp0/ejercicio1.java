package src.main.java.tp0;

// Programa que calcula el salario neto semanal de un trabajador.

// Importamos la clase Scanner para leer datos ingresados por el usuario.
import java.util.Scanner;

/*
 * Enunciado del ejercicio:
 *
 * Desarrollar un programa que calcule el salario neto de un trabajador
 * en funcion de las horas trabajadas.
 *
 * El programa debe solicitar al usuario:
 * - El nombre del empleado.
 * - La cantidad de horas trabajadas en la semana.
 * - El valor de la hora trabajada.
 *
 * El salario bruto se calcula teniendo en cuenta las horas trabajadas.
 *
 * Si el empleado trabaja hasta 40 horas:
 * pagoNormal = horasTrabajadas * valorHora
 *
 * Si trabaja mas de 40 horas:
 *
 * horasExtras = horasTrabajadas - 40
 * pagoExtra = horasExtras * (valorHora * 1.5)
 *
 * Las primeras 40 horas se pagan normalmente.
 *
 * Salario Bruto:
 * salarioBruto = pagoNormal + pagoExtra
 *
 * Luego se aplica un descuento sobre el salario bruto:
 *
 * Si salarioBruto <= $1.000.000 -> descuento del 9%
 * Si salarioBruto <= $3.000.000 -> descuento del 12%
 * Si salarioBruto > $3.000.000  -> descuento del 15%
 *
 * Finalmente:
 * salarioNeto = salarioBruto - descuento
 *
 * El programa debe mostrar:
 * - Salario bruto.
 * - Monto del descuento.
 * - Salario neto.
 */

// Clase principal del programa.
public class ejercicio1 {

    // Metodo principal del programa.
    public static void main(String[] args) {

        // Creamos el objeto Scanner para ingresar datos por teclado.
        Scanner scanner = new Scanner(System.in);

        // Declaracion de variables.
        String nombre;
        double horasTrabajadas = 0.0;
        double valorHora = 0.0;
        double pagoNormal = 0.0;
        double pagoExtra = 0.0;
        double salarioBruto = 0.0;
        double descuento = 0.0;
        double salarioNeto = 0.0;

        // Mostramos el titulo del ejercicio.
        System.out.print("\nEjercicio 1: Calculo del salario neto semanal\n");

        // Ingresamos el nombre del trabajador.
        System.out.print("Ingrese el nombre del trabajador.........: ");
        nombre = scanner.nextLine();

        // Ingresamos la cantidad de horas trabajadas.
        System.out.print("Ingrese las horas trabajadas en la semana: ");
        horasTrabajadas = scanner.nextDouble();

        // Controlamos que las horas no sean negativas.
        while (horasTrabajadas < 0) {

            System.out.println("Error: las horas no pueden ser negativas.");

            System.out.print("Ingrese nuevamente las horas trabajadas: ");
            horasTrabajadas = scanner.nextDouble();
        }

        // Ingresamos el valor de cada hora.
        System.out.print("Ingrese el valor de cada hora............: ");
        valorHora = scanner.nextDouble();

        // Controlamos que el valor de la hora no sea negativo.
        while (valorHora < 0) {

            System.out.println("Error: el valor de la hora no puede ser negativo.");

            System.out.print("Ingrese nuevamente el valor de la hora: ");
            valorHora = scanner.nextDouble();
        }

        // Calculamos el pago normal y el pago de horas extras.
        if (horasTrabajadas > 40) {

            // Las primeras 40 horas se pagan normalmente.
            pagoNormal = 40 * valorHora;

            // Calculamos la cantidad de horas extras.
            double horasExtras = horasTrabajadas - 40;

            // Las horas extras tienen un recargo del 50%.
            pagoExtra = horasExtras * (valorHora * 1.5);

        } else {

            // Si no supera las 40 horas, todas se pagan normalmente.
            pagoNormal = horasTrabajadas * valorHora;
        }

        // Calculamos el salario bruto.
        salarioBruto = pagoNormal + pagoExtra;

        // Calculamos el descuento correspondiente.
        if (salarioBruto <= 1000000) {

            // Descuento del 9%.
            descuento = salarioBruto * 0.09;

        } else if (salarioBruto <= 3000000) {

            // Descuento del 12%.
            descuento = salarioBruto * 0.12;

        } else {

            // Descuento del 15%.
            descuento = salarioBruto * 0.15;
        }

        // Calculamos el salario neto.
        salarioNeto = salarioBruto - descuento;

        // Mostramos los resultados.
        System.out.println("\n========== RESULTADOS ==========");
        System.out.println("Trabajador..........: " + nombre);
        System.out.println("Salario bruto.......: " + salarioBruto);
        System.out.println("Descuento...........: " + descuento);
        System.out.println("Salario neto semanal: " + salarioNeto);

        // Cerramos el Scanner.
        scanner.close();
    }
}

/*
Preguntas sobre el problema
a) ¿Cuáles son las entradas y salidas del programa?
Entradas:

Nombre del empleado.
Horas trabajadas.
Valor de la hora.

Salidas:

Salario bruto.
Descuento.
Salario neto.

b) ¿Qué sucede si el usuario ingresa un valor negativo en la cantidad de horas trabajadas?
Si se ingresa una cantidad negativa de horas, el programa debe considerarla inválida y solicitar nuevamente el dato.

c) Si el salario bruto es 2.500.000 y el descuento es de 375.000 ¿Se calculó correctamente el descuento?
No. Para un salario bruto de $2.500.000, corresponde un descuento del 12%.

2.500.000 × 0,12 = 300.000

Por lo tanto, $375.000 sería incorrecto.

d) ¿Qué resultados se obtienen si el empleado no realizó horas extras?
Si no realizó horas extras, todas las horas se pagan al valor normal. El pago extra queda en 0.

*/