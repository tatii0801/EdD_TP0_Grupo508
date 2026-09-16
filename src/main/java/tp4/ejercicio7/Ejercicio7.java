package tp4.ejercicio7;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ============================================================
 * EJERCICIO 7 - ANÁLISIS DE SOLUCIONES
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Implementar un método estático que reciba una cola de Integer
 * y devuelva la cantidad de números pares.
 *
 * La cola original debe quedar exactamente igual.
 *
 * Se analizan dos soluciones:
 *
 * A) Utilizar un arreglo auxiliar.
 * B) Utilizar una cola auxiliar.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿Las dos soluciones restauran el orden?
 *
 * RESPUESTA:
 * Sí. Si los elementos se guardan y se vuelven a insertar en
 * el mismo orden, las dos soluciones restauran la cola.
 *
 *
 * b) ¿Cuál está más relacionada con el concepto de cola?
 *
 * RESPUESTA:
 * La solución B, porque utiliza otra cola como estructura auxiliar.
 *
 *
 * c) ¿Qué ventaja tiene la solución A?
 *
 * RESPUESTA:
 * Es sencilla y permite almacenar temporalmente los elementos
 * en un arreglo.
 *
 *
 * d) ¿Qué ventaja tiene la solución B?
 *
 * RESPUESTA:
 * Mantiene la lógica de trabajo utilizando exclusivamente
 * estructuras de cola.
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

        int tamañoOriginal = cola.size();

        // Creamos arreglo con el tamaño exacto
        int[] auxiliar = new int[tamañoOriginal];

        int indice = 0;

        // Sacamos todos los elementos
        while (!cola.isEmpty()) {

            int numero = cola.poll();

            auxiliar[indice] = numero;

            indice++;

            if (numero % 2 == 0) {

                contador++;
            }
        }

        // Restauramos la cola
        for (int i = 0; i < tamañoOriginal; i++) {

            cola.add(auxiliar[i]);
        }

        return contador;
    }

    /*
     * ========================================================
     * SOLUCIÓN B
     * ========================================================
     *
     * Utiliza una cola auxiliar.
     */
    public static int contarParesB(
            Queue<Integer> cola) {

        int contador = 0;

        Queue<Integer> auxiliar = new LinkedList<>();

        // Pasamos los elementos a la auxiliar
        while (!cola.isEmpty()) {

            int numero = cola.poll();

            auxiliar.add(numero);

            if (numero % 2 == 0) {

                contador++;
            }
        }

        // Restauramos la cola original
        while (!auxiliar.isEmpty()) {

            cola.add(
                    auxiliar.poll());
        }

        return contador;
    }

    public static void main(String[] args) {

        Queue<Integer> colaA = new LinkedList<>();

        colaA.add(8);
        colaA.add(3);
        colaA.add(10);
        colaA.add(5);
        colaA.add(2);
        colaA.add(7);

        // Copia para probar la solución B
        Queue<Integer> colaB = new LinkedList<>(
                colaA);

        System.out.println(
                "\n=========================================");
        System.out.println("       SOLUCIÓN A - ARREGLO");
        System.out.println("=========================================");

        System.out.println(
                "\nCola original:");

        System.out.println(colaA);

        int paresA = contarParesA(colaA);

        System.out.println(
                "\nCantidad de pares: "
                        + paresA);

        System.out.println(
                "Cola después del método:");

        System.out.println(colaA);

        System.out.println(
                "\n=========================================");
        System.out.println("       SOLUCIÓN B - COLA");
        System.out.println("=========================================");

        System.out.println(
                "\nCola original:");

        System.out.println(colaB);

        int paresB = contarParesB(colaB);

        System.out.println(
                "\nCantidad de pares: "
                        + paresB);

        System.out.println(
                "Cola después del método:");

        System.out.println(colaB);
    }
}

/*
 * Resultado esperado aproximadamente:
 * Cola original A:
 * [8, 3, 10, 5, 2, 7]
 * 
 * Cantidad de pares con solución A: 3
 * 
 * Cola A después del método:
 * [8, 3, 10, 5, 2, 7]
 * 
 * Y lo mismo para B.
 */