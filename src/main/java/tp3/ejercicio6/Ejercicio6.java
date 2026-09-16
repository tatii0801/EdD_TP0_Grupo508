package tp3.ejercicio6;

import tp3.ejemplo.implementaciones.StackGenerica;

/*
 * ============================================================
 * EJERCICIO 6 - PILA A ARREGLO
 * ============================================================
 *
 * Se debe desarrollar un método que reciba una pila de
 * enteros y devuelva un arreglo con los elementos en el mismo
 * orden en que van a salir de la pila.
 *
 * Es decir:
 *
 * - La cima debe ser la primera posición del arreglo.
 * - La base debe ser la última posición.
 *
 * La pila original debe quedar sin modificaciones.
 *
 * Se analizan dos soluciones.
 * ============================================================
 */

public class Ejercicio6 {

    public static void main(String[] args) {

        StackGenerica<Integer> pila = new StackGenerica<>();

        /*
         * Cargamos algunos elementos.
         */
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);

        System.out.println("Pila original:");

        mostrarPila(pila);

        /*
         * Utilizamos la Solución B.
         */
        int[] arreglo = pilaAArregloB(pila);

        System.out.println(
                "\nArreglo en orden de salida de la pila:");

        mostrarArreglo(arreglo);

        /*
         * Comprobamos que la pila sigue igual.
         */
        System.out.println(
                "\nPila después del método:");

        mostrarPila(pila);
    }

    /*
     * ========================================================
     * SOLUCIÓN A
     * ========================================================
     *
     * Esta solución utiliza un arreglo auxiliar.
     *
     * En nuestra implementación de StackGenerica no utilizamos
     * toArray(), porque el ejercicio pide trabajar con la pila
     * propuesta en clase.
     *
     * Por eso mostramos la solución B como principal.
     * ========================================================
     */

    /*
     * ========================================================
     * SOLUCIÓN B
     * ========================================================
     *
     * Sacamos los elementos de la pila original y los
     * colocamos directamente en el arreglo.
     *
     * Al mismo tiempo los guardamos en una pila auxiliar.
     *
     * Finalmente utilizamos la pila auxiliar para restaurar
     * la pila original.
     * ========================================================
     */
    public static int[] pilaAArregloB(
            StackGenerica<Integer> pila) {

        /*
         * El tamaño del arreglo será igual a la cantidad
         * de elementos de la pila.
         */
        int[] arreglo = new int[pila.count()];

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        int i = 0;

        /*
         * Sacamos los elementos de la pila.
         */
        while (!pila.isEmpty()) {

            int valor = pila.pop();

            /*
             * Lo guardamos en el arreglo.
             */
            arreglo[i] = valor;

            i++;

            /*
             * Lo guardamos también para restaurar
             * posteriormente la pila.
             */
            auxiliar.push(valor);
        }

        /*
         * Restauramos la pila original.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        return arreglo;
    }

    /*
     * Muestra un arreglo.
     */
    public static void mostrarArreglo(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {

            System.out.print(arreglo[i] + " ");
        }

        System.out.println();
    }

    /*
     * Muestra una pila sin modificarla.
     */
    public static void mostrarPila(
            StackGenerica<Integer> pila) {

        StackGenerica<Integer> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            int valor = pila.pop();

            System.out.print(valor + " ");

            auxiliar.push(valor);
        }

        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }

        System.out.println();
    }
}

/*
 * Respuesta del análisis del punto 6
 * 
 * 1. ¿Cuál solución respeta mejor la consigna?
 * 
 * La Solución B, porque crea un arreglo con el tamaño exacto de la pila y
 * utiliza una pila auxiliar para restaurar la pila original después de
 * recorrerla.
 * 
 * 2. ¿Cuál es más fácil de explicar?
 * 
 * La Solución B, porque muestra claramente el funcionamiento de una pila: se
 * extraen los elementos con pop(), se guardan en el arreglo y luego se utiliza
 * una pila auxiliar para recuperar la pila original.
 * 
 * 3. Ventajas y desventajas
 * 
 * Solución A: es más corta y utiliza métodos propios de Java, pero oculta el
 * funcionamiento de la pila y depende de toArray().
 * 
 * Solución B: es más larga porque necesita una pila auxiliar, pero permite
 * comprender mejor el funcionamiento de las pilas y garantiza que la pila
 * original pueda restaurarse.
 */