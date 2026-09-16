package tp4.ejercicio7;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * ============================================================
 * EJERCICIO 7 - ANÁLISIS
 * ============================================================
 *
 * Enunciado:
 *
 * Implementar un método estático que reciba una cola de Integer
 * y devuelva la cantidad de números pares.
 *
 * La cola original debe quedar exactamente igual después de
 * ejecutar el método.
 *
 * Se presentan dos soluciones:
 *
 * SOLUCIÓN A:
 * Utiliza un arreglo auxiliar.
 *
 * SOLUCIÓN B:
 * Utiliza una cola auxiliar.
 *
 * ============================================================
 *
 * SOLUCIÓN A
 *
 * Se guarda cada elemento que se elimina de la cola en un arreglo.
 * Luego se vuelve a cargar la cola original.
 *
 *
 * SOLUCIÓN B
 *
 * Se utiliza una cola auxiliar.
 * Los elementos se pasan desde la cola original a la auxiliar.
 * Luego se pasan nuevamente a la cola original.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿Las dos soluciones restauran el orden?
 *
 * RESPUESTA:
 * Sí. Si se recorren y restauran los elementos en el mismo orden,
 * las dos soluciones dejan la cola con el mismo contenido y orden.
 *
 *
 * b) ¿Cuál es más adecuada para trabajar con una cola?
 *
 * RESPUESTA:
 * La solución B es más acorde al concepto de cola porque utiliza
 * otra cola como estructura auxiliar.
 *
 *
 * c) ¿Qué ventaja tiene la solución A?
 *
 * RESPUESTA:
 * Es sencilla y permite guardar los elementos temporalmente en
 * un arreglo.
 *
 *
 * d) ¿Qué ventaja tiene la solución B?
 *
 * RESPUESTA:
 * Mantiene la lógica de trabajo con colas y no mezcla la estructura
 * Queue con un arreglo.
 *
 * ============================================================
 */

public class Ejercicio7 {

    /*
     * ========================================================
     * SOLUCIÓN A
     * ========================================================
     *
     * Utiliza un arreglo auxiliar.
     */
    public static int contarParesA(
            Queue<Integer> cola) {

        int contador = 0;

        int tamanioOriginal =
                cola.size();

        int[] arregloAuxiliar =
                new int[tamanioOriginal];

        int i = 0;

        /*
         * Sacamos todos los elementos y los guardamos.
         */
        while (!cola.isEmpty()) {

            int numero =
                    cola.remove();

            arregloAuxiliar[i] =
                    numero;

            i++;

            if (numero % 2 == 0) {

                contador++;
            }
        }

        /*
         * Restauramos la cola.
         */
        for (int j = 0;
             j < tamanioOriginal;
             j++) {

            cola.add(
                    arregloAuxiliar[j]);
        }

        return contador;
    }

    /*
     * ========================================================
     * SOLUCIÓN B
     * ========================================================
     *
     * Utiliza otra cola.
     */
    public static int contarParesB(
            Queue<Integer> cola) {

        int contador = 0;

        Queue<Integer> auxiliar =
                new ArrayDeque<>();

        /*
         * Pasamos los elementos a la auxiliar.
         */
        while (!cola.isEmpty()) {

            int numero =
                    cola.remove();

            auxiliar.add(numero);

            if (numero % 2 == 0) {

                contador++;
            }
        }

        /*
         * Restauramos la cola original.
         */
        while (!auxiliar.isEmpty()) {

            cola.add(
                    auxiliar.remove());
        }

        return contador;
    }

    public static void main(String[] args) {

        Queue<Integer> colaA =
                new ArrayDeque<>();

        colaA.add(8);
        colaA.add(3);
        colaA.add(10);
        colaA.add(5);
        colaA.add(2);
        colaA.add(7);

        /*
         * Hacemos otra cola para probar
         * la solución B con los mismos datos.
         */
        Queue<Integer> colaB =
                new ArrayDeque<>(
                        colaA);

        System.out.println(
                "Cola original A:");

        System.out.println(colaA);

        int paresA =
                contarParesA(colaA);

        System.out.println(
                "Cantidad de pares con solución A: "
                        + paresA);

        System.out.println(
                "Cola A después del método:");

        System.out.println(colaA);

        System.out.println(
                "\nCola original B:");

        System.out.println(colaB);

        int paresB =
                contarParesB(colaB);

        System.out.println(
                "Cantidad de pares con solución B: "
                        + paresB);

        System.out.println(
                "Cola B después del método:");

        System.out.println(colaB);
    }
}

/*
Resultado esperado aproximadamente:
Cola original A:
[8, 3, 10, 5, 2, 7]

Cantidad de pares con solución A: 3

Cola A después del método:
[8, 3, 10, 5, 2, 7]

Y lo mismo para B.
*/