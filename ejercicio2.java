// Programa que simula el registro de temperaturas de un sensor durante un dia.

// Importamos Scanner para ingresar datos por teclado.
import java.util.Scanner;

// Importamos Random para generar temperaturas aleatorias.
import java.util.Random;

/*
 * Enunciado del ejercicio:
 *
 * Desarrollar un programa que simule el registro de temperaturas
 * de un sensor durante un dia.
 *
 * El usuario debe ingresar la cantidad de mediciones que desea simular.
 *
 * Por cada medicion el programa debe:
 *
 * a) Generar y mostrar un numero aleatorio entre -10 y 40 grados Celsius.
 *
 * b) Al finalizar las mediciones:
 *    - Calcular la temperatura promedio.
 *    - Contar cuantas mediciones fueron menores a 0 grados.
 *    - Contar cuantas mediciones fueron mayores o iguales a 30 grados.
 *
 * Las temperaturas menores a 0 se consideran "Heladas".
 *
 * Las temperaturas mayores o iguales a 30 se consideran "Calidas".
 */

public class ejercicio2 {

    // Metodo principal del programa.
    public static void main(String[] args) {

        // Creamos el objeto Scanner para ingresar datos.
        Scanner scanner = new Scanner(System.in);

        // Creamos el objeto Random para generar temperaturas.
        Random random = new Random();

        // Declaracion de variables.
        int cantidadMediciones;
        int temperatura;
        int sumaTemperaturas = 0;
        int heladas = 0;
        int calidas = 0;
        double promedio;

        // Mostramos el titulo.
        System.out.print("\nEjercicio 2: Registro de temperaturas\n");

        // Solicitamos la cantidad de mediciones.
        System.out.print("Ingrese la cantidad de mediciones: ");
        cantidadMediciones = scanner.nextInt();

        // Controlamos que la cantidad sea mayor que cero.
        while (cantidadMediciones <= 0) {

            System.out.println("Error: la cantidad debe ser mayor que 0.");

            System.out.print("Ingrese nuevamente la cantidad: ");
            cantidadMediciones = scanner.nextInt();
        }

        // Repetimos el proceso para cada medicion.
        for (int i = 1; i <= cantidadMediciones; i++) {

            // Generamos una temperatura entre -10 y 40.
            temperatura = random.nextInt(51) - 10;

            // Mostramos la temperatura generada.
            System.out.println("Medicion " + i + ": " + temperatura + " °C");

            // Acumulamos la temperatura para calcular el promedio.
            sumaTemperaturas = sumaTemperaturas + temperatura;

            // Controlamos si la temperatura es una helada.
            if (temperatura < 0) {
                heladas++;
            }

            // Controlamos si la temperatura es calida.
            if (temperatura >= 30) {
                calidas++;
            }
        }

        // Calculamos el promedio.
        promedio = (double) sumaTemperaturas / cantidadMediciones;

        // Mostramos los resultados.
        System.out.println("\n========== RESULTADOS ==========");
        System.out.println("Temperatura promedio: " + promedio + " °C");
        System.out.println("Cantidad de heladas: " + heladas);
        System.out.println("Cantidad de calidas: " + calidas);

        // Cerramos el Scanner.
        scanner.close();
    }
}

/*
 * Preguntas sobre el problema
 * a) Si se necesitara guardar el historial de todas las temperaturas para
 * analizarlas nuevamente al final del
 * programa, ¿alcanzaría con usar una única variable simple? Justifique.
 * 
 * No alcanza una única variable simple porque solo permite almacenar una
 * temperatura a la vez. Para guardar todas las temperaturas se podría utilizar
 * un arreglo.
 * 
 * 
 * b) ¿Qué ocurriría si la cantidad de mediciones ingresada fuera igual a 0?
 * ¿Cómo se calcula el promedio en
 * ese caso y cómo debería reaccionar el programa?
 * 
 * Si la cantidad es 0, no se puede calcular el promedio porque implicaría
 * dividir por cero. Por eso el programa debe rechazar ese valor.
 * 
 * 
 * c) Si las mediciones aleatorias simuladas fueran: -5, 0, 15 y 35, sin
 * ejecutar el programa, ¿cuál será el
 * promedio? ¿Cuántas son "Heladas" y cuántas "Calidas"?
 *
 * Temperaturas: -5, 0, 15, 35
 * Suma = -5 + 0 + 15 + 35 = 45
 * Promedio = 45 / 4 = 11,25 °C
 * 
 * Heladas: 1
 * Cálidas: 1
 * 
 * d) Ahora se desea conocer también la temperatura máxima y mínima registrada.
 * ¿Qué variables
 * necesitarías agregar y cómo afectaría esto a la lógica dentro del ciclo?
 * 
 * Se necesitarían dos variables:
 * 
 * int temperaturaMaxima;
 * int temperaturaMinima;
 * 
 * Dentro del ciclo se compararían con cada nueva temperatura.
 * 
 */