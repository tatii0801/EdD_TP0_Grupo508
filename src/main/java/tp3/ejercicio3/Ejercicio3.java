package tp3.ejercicio3;

import tp3.ejemplo.implementaciones.StackGenerica;
import java.util.Random;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 3 - OPERACIONES SOBRE UNA PILA
 * ============================================================
 *
 * Dada una pila con N números enteros aleatorios:
 *
 * a) Eliminar todos los elementos que sean divisores exactos
 *    de X.
 *
 * b) Reemplazar todos los números impares por 0.
 *
 * c) Contar cuántos elementos son mayores que el elemento
 *    que se encuentra en la cima.
 *
 * d) Intercambiar el elemento de la cima con el elemento
 *    que se encuentra en la mitad de la pila.
 *
 * La pila se genera mediante números aleatorios.
 * ============================================================
 */

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        StackGenerica<Integer> pila = new StackGenerica<>();

        System.out.println("======================================");
        System.out.println("       EJERCICIO 3 - PILAS");
        System.out.println("======================================");

        /*
         * Solicitamos la cantidad de elementos.
         */
        System.out.print("\nIngrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        /*
         * Validamos que N sea positivo.
         */
        while (n <= 0) {

            System.out.print(
                    "Error. Ingrese una cantidad mayor a 0: ");

            n = scanner.nextInt();
        }

        /*
         * Generamos números aleatorios entre -20 y 20.
         */
        for (int i = 0; i < n; i++) {

            int numero = random.nextInt(41) - 20;

            pila.push(numero);
        }

        System.out.println("\nPila original:");
        mostrarPila(pila);

        /*
         * ====================================================
         * PUNTO A
         * ====================================================
         */

        System.out.print("\nIngrese X para eliminar sus divisores exactos: ");

        int x = scanner.nextInt();

        System.out.println("\nAntes del punto A:");
        mostrarPila(pila);

        eliminarDivisores(pila, x);

        System.out.println("\nDespués del punto A:");
        mostrarPila(pila);

        /*
         * ====================================================
         * PUNTO B
         * ====================================================
         */

        System.out.println("\nAntes del punto B:");
        mostrarPila(pila);

        reemplazarImpares(pila);

        System.out.println("\nDespués del punto B:");
        mostrarPila(pila);

        /*
         * ====================================================
         * PUNTO C
         * ====================================================
         */

        int cantidadMayores = contarMayoresQueCima(pila);

        System.out.println(
                "\nCantidad de elementos mayores que la cima: "
                        + cantidadMayores);

        /*
         * ====================================================
         * PUNTO D
         * ====================================================
         */

        System.out.println("\nAntes del intercambio:");
        mostrarPila(pila);

        intercambiarCimaMitad(pila);

        System.out.println("\nDespués del intercambio:");
        mostrarPila(pila);

        scanner.close();
    }

    /*
     * ========================================================
     * PUNTO A
     * ========================================================
     *
     * Elimina todos los elementos que sean divisores exactos
     * de X.
     *
     * Un número es divisor de X cuando:
     *
     * X % numero == 0
     *
     * Se utiliza una pila auxiliar para conservar los demás
     * elementos y luego reconstruir la pila.
     */
    public static void eliminarDivisores(
            StackGenerica<Integer> pila,
            int x) {

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            int numero = pila.pop();

            /*
             * Evitamos dividir por cero.
             */
            if (numero != 0 && x % numero == 0) {

                // No agregamos el elemento.
                // Por lo tanto queda eliminado.

            } else {

                auxiliar.push(numero);
            }
        }

        /*
         * Restauramos la pila.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }

    /*
     * ========================================================
     * PUNTO B
     * ========================================================
     *
     * Reemplaza todos los números impares por 0.
     */
    public static void reemplazarImpares(
            StackGenerica<Integer> pila) {

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            int numero = pila.pop();

            /*
             * Si el número es impar, lo reemplazamos por 0.
             */
            if (numero % 2 != 0) {

                numero = 0;
            }

            auxiliar.push(numero);
        }

        /*
         * Restauramos la pila.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }

    /*
     * ========================================================
     * PUNTO C
     * ========================================================
     *
     * Cuenta cuántos elementos son mayores que el elemento
     * que está actualmente en la cima.
     *
     * La pila original NO debe modificarse.
     */
    public static int contarMayoresQueCima(
            StackGenerica<Integer> pila) {

        /*
         * Si la pila está vacía, no existe cima.
         */
        if (pila.isEmpty()) {

            return 0;
        }

        /*
         * Guardamos la cima sin eliminarla.
         */
        int cima = pila.peek();

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        int contador = 0;

        while (!pila.isEmpty()) {

            int numero = pila.pop();

            if (numero > cima) {

                contador++;
            }

            auxiliar.push(numero);
        }

        /*
         * Restauramos la pila.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        return contador;
    }

    /*
     * ========================================================
     * PUNTO D
     * ========================================================
     *
     * Intercambia la cima con el elemento ubicado en la mitad.
     *
     * Para una cantidad par de elementos se toma la posición
     * size / 2 contando desde la cima.
     */
    public static void intercambiarCimaMitad(
            StackGenerica<Integer> pila) {

        int cantidad = pila.count();

        /*
         * Si tiene 0 o 1 elementos no hay intercambio útil
         * que realizar.
         */
        if (cantidad <= 1) {

            return;
        }

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        /*
         * Guardamos la cima.
         */
        int cima = pila.pop();

        /*
         * Calculamos la posición de la mitad.
         */
        int posicionMitad = cantidad / 2;

        /*
         * Sacamos elementos hasta llegar a la mitad.
         */
        for (int i = 1; i < posicionMitad; i++) {

            auxiliar.push(pila.pop());
        }

        /*
         * Guardamos el elemento de la mitad.
         */
        int mitad = pila.pop();

        /*
         * Ponemos la cima en la posición donde estaba la mitad.
         */
        pila.push(cima);

        /*
         * Restauramos los elementos auxiliares.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        /*
         * Ahora tenemos que reconstruir la pila para que
         * el elemento mitad ocupe la cima.
         *
         * Para este ejercicio se puede reconstruir utilizando
         * otra pila auxiliar.
         */
        StackGenerica<Integer> auxiliar2 = new StackGenerica<>();

        while (!pila.isEmpty()) {

            auxiliar2.push(pila.pop());
        }

        /*
         * Quitamos el antiguo elemento que estaba en la cima
         * y colocamos el elemento mitad.
         */
        pila.push(mitad);

        /*
         * Restauramos los restantes elementos.
         */
        while (!auxiliar2.isEmpty()) {

            pila.push(auxiliar2.pop());
        }
    }

    /*
     * Muestra una pila sin modificarla.
     */
    public static void mostrarPila(
            StackGenerica<Integer> pila) {

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            int numero = pila.pop();

            System.out.print(numero + " ");

            auxiliar.push(numero);
        }

        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        System.out.println();
    }
}