package tp3.ejercicio2;

import java.util.Scanner;

import tp3.ejemplo.implementaciones.StackChar;
import tp3.ejemplo.implementaciones.StackGenerica;

/*
 * ============================================================
 * EJERCICIO 2 - INVERSIÓN DE MÚLTIPLOS DE 3
 * ============================================================
 *
 * Dado un arreglo de números enteros, invertir únicamente
 * los números que sean múltiplos de 3.
 *
 * Para realizar la inversión se debe utilizar una pila.
 *
 * Los números que no son múltiplos de 3 deben permanecer
 * exactamente en la misma posición.
 *
 * Ejemplo:
 *
 * Original:
 * 4 3 7 9 12 2 15
 *
 * Múltiplos de 3:
 * 3 9 12 15
 *
 * Invertidos:
 * 15 12 9 3
 *
 * Resultado:
 * 4 15 7 12 9 2 3
 * ================================================================
 *
 * PREGUNTAS SOBRE EL PROBLEMA
 *
 * a) ¿Por qué la pila es ideal para invertir el orden?
 *
 * RESPUESTA:
 * Porque una pila trabaja con el principio LIFO:
 * Last In, First Out.
 *
 * El último elemento agregado es el primero que sale.
 * Por eso permite invertir fácilmente una secuencia.
 *
 *
 * b) ¿Es suficiente almacenar el valor?
 *
 * RESPUESTA:
 * Sí. No necesitamos guardar la posición porque recorremos
 * nuevamente el arreglo y colocamos los valores extraídos de
 * la pila solamente en las posiciones que contienen múltiplos
 * de 3.
 *
 *
 * c) ¿Funciona guardar el valor y la posición?
 *
 * RESPUESTA:
 * Sí, también funcionaría, pero para este ejercicio no es
 * necesario guardar la posición.
 *
 *
 * d) ¿Qué ocurre si no hay múltiplos de 3?
 *
 * RESPUESTA:
 * La pila queda vacía y el arreglo permanece sin modificaciones.
 *
 * ================================================================
 */

public class Ejercicio2 {

    // Método que invierte los múltiplos de 3.
    public static void invertirMultiplosDeTres(int[] arreglo) {

        StackGenerica<Integer> pila = new StackGenerica<>();


        // Primero guardamos en la pila los múltiplos de 3.
        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] % 3 == 0) {

                pila.push(arreglo[i]);
            }
        }

        // Recorremos nuevamente el arreglo.
        // Cuando encontramos un múltiplo de 3,
        // colocamos el elemento que sale de la pila.
        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] % 3 == 0) {

                arreglo[i] = pila.pop();
            }
        }
    }

    // Método para mostrar el arreglo.
    public static void mostrarArreglo(int[] arreglo) {

        System.out.print("[ ");

        for (int i = 0; i < arreglo.length; i++) {

            System.out.print(arreglo[i] + " ");
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       EJERCICIO 2 - PILAS");
        System.out.println("=================================");

        System.out.print("\nIngrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        while (n < 0) {

            System.out.print("La cantidad no puede ser negativa. Ingrese nuevamente: ");
            n = scanner.nextInt();
        }

        int[] arreglo = new int[n];

        // Cargamos el arreglo.
        for (int i = 0; i < arreglo.length; i++) {

            System.out.print("Ingrese el elemento " + i + ": ");
            arreglo[i] = scanner.nextInt();
        }

        System.out.println("\nArreglo original:");
        mostrarArreglo(arreglo);

        invertirMultiplosDeTres(arreglo);

        System.out.println("\nArreglo después de invertir los múltiplos de 3:");
        mostrarArreglo(arreglo);

        scanner.close();
    }
}