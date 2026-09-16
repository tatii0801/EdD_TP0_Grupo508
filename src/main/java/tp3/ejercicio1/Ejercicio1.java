package tp3.ejercicio1;

import tp3.ejemplo.implementaciones.StackGenerica;
import java.util.Random;

/*
 * ============================================================
 * TRABAJO PRÁCTICO N° 3 - ESTRUCTURA DE DATOS
 * TEMA: PILAS
 * EJERCICIO 1
 * ============================================================
 *
 * Enunciado:
 *
 * Generar 15 números enteros aleatorios entre -20 y 20
 * y almacenarlos en una pila.
 *
 * Luego quitar los elementos de la pila original y guardar:
 *
 * - Los números positivos, incluyendo el 0, en una pila
 *   llamada positivos.
 *
 * - Los números negativos en una pila llamada negativos.
 *
 * También se debe calcular y mostrar:
 *
 * - El valor máximo y mínimo de la pila positivos.
 * - El valor máximo y mínimo de la pila negativos.
 *
 * Al finalizar, la pila original debe mantenerse sin
 * modificaciones y conservar el orden original.
 *
 * Para poder vaciar la pila original y luego recuperarla,
 * se utilizan pilas auxiliares.
 * ============================================================
 */

public class Ejercicio1 {

    /*
     * Método principal.
     * Aquí comienza la ejecución del programa.
     */
    public static void main(String[] args) {

        // Objeto Random para generar números aleatorios.
        Random random = new Random();

        // Creamos la pila original.
        StackGenerica<Integer> pilaOriginal = new StackGenerica<>();

        // Pila donde se almacenarán los números positivos y el 0.
        StackGenerica<Integer> positivos = new StackGenerica<>();

        // Pila donde se almacenarán los números negativos.
        StackGenerica<Integer> negativos = new StackGenerica<>();

        // Pila auxiliar que permitirá recuperar la pila original.
        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        System.out.println("======================================");
        System.out.println("       EJERCICIO 1 - PILAS");
        System.out.println("======================================");

        /*
         * Generamos 15 números aleatorios.
         *
         * random.nextInt(41) genera valores entre 0 y 40.
         * Al restarle 20 obtenemos valores entre -20 y 20.
         */
        for (int i = 0; i < 15; i++) {

            int numero = random.nextInt(41) - 20;

            pilaOriginal.push(numero);
        }

        // Mostramos la pila original.
        System.out.println("\nPila original:");
        mostrarPila(pilaOriginal);

        /*
         * Recorremos la pila mediante pop().
         *
         * Como pop() elimina elementos, guardamos cada elemento
         * también en una pila auxiliar para poder reconstruir
         * posteriormente la pila original.
         */
        while (!pilaOriginal.isEmpty()) {

            int numero = pilaOriginal.pop();

            // Guardamos el elemento para restaurar la pila.
            auxiliar.push(numero);

            // Si es mayor o igual a 0, va a positivos.
            if (numero >= 0) {
                positivos.push(numero);
            } else {
                // Si es menor que 0, va a negativos.
                negativos.push(numero);
            }
        }

        /*
         * Restauramos la pila original.
         *
         * Al sacar los elementos de auxiliar y volver a
         * introducirlos en la pila original recuperamos
         * el orden que tenía inicialmente.
         */
        while (!auxiliar.isEmpty()) {

            pilaOriginal.push(auxiliar.pop());
        }

        // Mostramos las pilas obtenidas.
        System.out.println("\nPila positivos:");
        mostrarPila(positivos);

        System.out.println("\nPila negativos:");
        mostrarPila(negativos);

        // Calculamos máximo y mínimo de positivos.
        mostrarMaximoMinimo(positivos, "positivos");

        // Calculamos máximo y mínimo de negativos.
        mostrarMaximoMinimo(negativos, "negativos");

        // Comprobamos que la pila original quedó igual.
        System.out.println("\nPila original después del proceso:");
        mostrarPila(pilaOriginal);
    }

    /*
     * Método para mostrar una pila sin modificarla.
     *
     * Se utiliza una pila auxiliar para poder hacer pop()
     * y luego restaurar la pila original.
     */
    public static void mostrarPila(StackGenerica<Integer> pila) {

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            int numero = pila.pop();

            System.out.print(numero + " ");

            auxiliar.push(numero);
        }

        /*
         * Restauramos la pila original.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        System.out.println();
    }

    /*
     * Método que calcula el valor máximo y mínimo
     * de una pila de números enteros.
     */
    public static void mostrarMaximoMinimo(
            StackGenerica<Integer> pila,
            String nombre) {

        /*
         * Si la pila está vacía no podemos calcular
         * máximo ni mínimo.
         */
        if (pila.isEmpty()) {

            System.out.println(
                "\nLa pila " + nombre +
                " está vacía. No se puede calcular máximo y mínimo."
            );

            return;
        }

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        // Tomamos el primer elemento como máximo y mínimo inicial.
        int primero = pila.pop();

        int maximo = primero;
        int minimo = primero;

        auxiliar.push(primero);

        /*
         * Recorremos el resto de la pila.
         */
        while (!pila.isEmpty()) {

            int numero = pila.pop();

            auxiliar.push(numero);

            if (numero > maximo) {
                maximo = numero;
            }

            if (numero < minimo) {
                minimo = numero;
            }
        }

        /*
         * Restauramos la pila.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        System.out.println("\nResultados de pila " + nombre + ":");
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
    }
}
