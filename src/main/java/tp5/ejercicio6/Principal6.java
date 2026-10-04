package tp5.ejercicio6;

/*
 * EJERCICIO 6 - LISTA
 *
 * Consigna:
 *
 * Crear una lista de N numeros enteros aleatorios.
 *
 * a) Crear una nueva lista colocando primero los negativos
 *    y luego los positivos incluyendo el cero.
 *
 * b) Pedir dos valores A y B y calcular la suma de los elementos
 *    que se encuentran entre A y B.
 *
 * c) Crear una nueva lista ordenada de menor a mayor.
 *
 * En el main:
 * - Pedir N.
 * - Generar los numeros.
 * - Mostrar la lista original.
 * - Ejecutar los tres puntos.
 */

import java.util.Random;
import java.util.Scanner;

import tp5.Base_Profesor.SimpleLinkedList;

public class Principal6 {

    /*
     * Punto A
     *
     * Primero agregamos todos los negativos
     * y despues los positivos y el cero.
     */
    public static SimpleLinkedList<Integer> agrupar(
            SimpleLinkedList<Integer> lista) {

        SimpleLinkedList<Integer> resultado = new SimpleLinkedList<>();

        // Primero los negativos
        for (Integer numero : lista) {

            if (numero < 0) {
                resultado.addLast(numero);
            }
        }

        // Despues positivos y cero
        for (Integer numero : lista) {

            if (numero >= 0) {
                resultado.addLast(numero);
            }
        }

        return resultado;
    }

    /*
     * Punto B
     *
     * Suma los elementos que estan entre A y B.
     */
    public static int sumarEntre(
            SimpleLinkedList<Integer> lista,
            int a,
            int b) {

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        int suma = 0;

        for (Integer numero : lista) {

            if (numero >= menor &&
                    numero <= mayor) {

                suma += numero;
            }
        }

        return suma;
    }

    /*
     * Punto C
     *
     * Crea una nueva lista ordenada de menor a mayor.
     */
    public static SimpleLinkedList<Integer> ordenar(
            SimpleLinkedList<Integer> lista) {

        SimpleLinkedList<Integer> resultado = new SimpleLinkedList<>();

        for (Integer numero : lista) {

            insertarOrdenado(resultado, numero);
        }

        return resultado;
    }

    /*
     * Inserta un numero manteniendo el orden.
     *
     * Como SimpleLinkedList no tiene acceso publico
     * a sus nodos, usamos una lista auxiliar.
     */
    private static void insertarOrdenado(
            SimpleLinkedList<Integer> lista,
            Integer numero) {

        SimpleLinkedList<Integer> auxiliar = new SimpleLinkedList<>();

        boolean insertado = false;

        while (lista.size() > 0) {

            Integer actual = lista.removeFirst();

            if (!insertado && numero <= actual) {

                auxiliar.addLast(numero);
                insertado = true;
            }

            auxiliar.addLast(actual);
        }

        if (!insertado) {
            auxiliar.addLast(numero);
        }

        while (auxiliar.size() > 0) {

            lista.addLast(auxiliar.removeFirst());
        }
    }

    /*
     * Muestra una lista.
     */
    public static void mostrar(
            SimpleLinkedList<Integer> lista) {

        if (lista.size() == 0) {
            System.out.println("Lista vacia.");
            return;
        }

        for (Integer numero : lista) {
            System.out.print(numero + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        SimpleLinkedList<Integer> lista = new SimpleLinkedList<>();

        // ==========================
        // PEDIR N
        // ==========================

        System.out.print("Ingrese cantidad de numeros: ");
        int n = scanner.nextInt();

        // ==========================
        // GENERAR NUMEROS
        // ==========================

        for (int i = 0; i < n; i++) {

            // Numeros entre -50 y 50
            int numero = random.nextInt(101) - 50;

            lista.addLast(numero);
        }

        // ==========================
        // LISTA ORIGINAL
        // ==========================

        System.out.println("\n===== LISTA ORIGINAL =====");
        mostrar(lista);

        // ==========================
        // PUNTO A
        // ==========================

        SimpleLinkedList<Integer> agrupada = agrupar(lista);

        System.out.println("\n===== NEGATIVOS Y POSITIVOS =====");
        mostrar(agrupada);

        // ==========================
        // PUNTO B
        // ==========================

        System.out.print("\nIngrese A: ");
        int a = scanner.nextInt();

        System.out.print("Ingrese B: ");
        int b = scanner.nextInt();

        int suma = sumarEntre(lista, a, b);

        System.out.println(
                "Suma entre " + a + " y " + b +
                        ": " + suma);

        // ==========================
        // PUNTO C
        // ==========================

        SimpleLinkedList<Integer> ordenada = ordenar(lista);

        System.out.println("\n===== LISTA ORDENADA =====");
        mostrar(ordenada);

        scanner.close();
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) ¿El agrupamiento conserva el orden original?
 *
 * Respuesta:
 * Si.
 *
 * Dentro de los negativos se conserva el orden en el que
 * aparecian en la lista original.
 *
 * Lo mismo sucede con los positivos y el cero.
 *
 *
 * b) ¿Que pasa si A = 10 y B = 5?
 *
 * Respuesta:
 * En esta solucion se toman automaticamente los limites
 * como 5 y 10 utilizando Math.min y Math.max.
 *
 *
 * c) ¿Que es mejor: ordenar un array y luego pasarlo
 * a una lista o insertar ordenadamente?
 *
 * Respuesta:
 * Para este ejercicio es mejor practicar la insercion
 * ordenada porque estamos trabajando con una estructura
 * dinamica y con enlaces.
 *
 *
 * d) ¿Como eliminariamos duplicados de una lista ordenada?
 *
 * Respuesta:
 * Como la lista esta ordenada, podemos recorrerla una vez
 * y comparar cada elemento con el anterior.
 *
 * Si son iguales, no agregamos nuevamente el elemento.
 */
