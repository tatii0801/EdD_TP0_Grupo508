package tp5.ejercicio7;

/*
 * EJERCICIO 7 - QUEUE
 *
 * Consigna:
 *
 * Implementar una Queue generica usando una lista.
 *
 * Para el ejemplo del autoservicio:
 *
 * - Pedir N numeros aleatorios entre 0 y 50.
 * - El numero 0 representa una cancelacion.
 * - Procesar la cola eliminando los ceros.
 * - Mantener el orden de los numeros validos.
 * - Calcular el promedio de los numeros validos.
 */

import java.util.Random;
import java.util.Scanner;

public class Principal7 {

    /*
     * Muestra una cola sin modificarla.
     *
     * Se utiliza una cola auxiliar para recorrerla.
     */
    public static void mostrar(
            Queue<Integer> cola) {

        Queue<Integer> auxiliar = new Queue<>();

        System.out.print("Frente -> ");

        while (!cola.isEmpty()) {

            Integer numero = cola.remove();

            System.out.print(numero + " ");

            auxiliar.add(numero);
        }

        System.out.println("<- Final");

        // Restauramos la cola original
        while (!auxiliar.isEmpty()) {

            cola.add(auxiliar.remove());
        }
    }

    /*
     * Procesa las cancelaciones.
     *
     * Los ceros se eliminan.
     * Los demas elementos mantienen su orden.
     *
     * Ademas calcula la suma y la cantidad
     * de elementos validos.
     */
    public static double procesar(
            Queue<Integer> cola) {

        Queue<Integer> auxiliar = new Queue<>();

        int suma = 0;
        int cantidad = 0;

        while (!cola.isEmpty()) {

            int numero = cola.remove();

            if (numero != 0) {

                auxiliar.add(numero);

                suma += numero;
                cantidad++;
            }
        }

        // Volvemos a colocar los elementos validos
        while (!auxiliar.isEmpty()) {

            cola.add(auxiliar.remove());
        }

        if (cantidad == 0) {
            return 0;
        }

        return (double) suma / cantidad;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Queue<Integer> cola = new Queue<>();

        // ==========================
        // PEDIR N
        // ==========================

        System.out.print(
                "Ingrese cantidad de elementos: ");

        int n = scanner.nextInt();

        // ==========================
        // CARGAR COLA
        // ==========================

        for (int i = 0; i < n; i++) {

            int numero = random.nextInt(51);

            cola.add(numero);
        }

        // ==========================
        // COLA ORIGINAL
        // ==========================

        System.out.println("\n===== COLA ORIGINAL =====");

        mostrar(cola);

        // ==========================
        // PROCESAR
        // ==========================

        double promedio = procesar(cola);

        // ==========================
        // RESULTADO
        // ==========================

        System.out.println(
                "\n===== COLA SIN CANCELACIONES =====");

        mostrar(cola);

        System.out.println(
                "Promedio: " + promedio);

        scanner.close();
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) Comparando esta cola con una cola implementada
 * con array circular:
 *
 * Respuesta:
 * La cola implementada con lista no tiene una capacidad
 * maxima fija.
 *
 * Puede seguir agregando elementos mientras haya memoria
 * disponible.
 *
 * En un array circular si existe una capacidad definida.
 *
 *
 * b) ¿Que pasa si la cola esta vacia al calcular
 * el promedio?
 *
 * Respuesta:
 * No debemos dividir por cero.
 *
 * Por eso se verifica:
 *
 * if (cantidad == 0)
 *
 * y se devuelve 0.
 *
 *
 * c) Si tenemos:
 *
 * 5, 0, 8, 0, 9
 *
 * ¿Que queda?
 *
 * Respuesta:
 *
 * 5, 8, 9
 *
 * Se eliminan solamente los ceros.
 *
 *
 * d) ¿Por que utilizamos una cola auxiliar?
 *
 * Respuesta:
 * Para poder procesar los elementos y conservar
 * el orden de los elementos validos.
 *
 * Ademas hace mas claro el proceso y permite
 * mantener la cola resultante.
 *
 *
 * DIAGRAMA:
 *
 * Queue
 * |
 * v
 * SimpleLinkedList<Integer>
 *
 *
 * Frente                       Final
 *   |                            |
 *   v                            v
 * [5] -> [8] -> [9] -> null
 * 
 * Lo importante de Queue
ENTRA POR EL FINAL
       ↓
[5] [8] [9]
 ↑
SALE POR EL PRINCIPIO

Por eso:

add()    → addLast()
remove() → removeFirst()

Eso es FIFO.
 */
