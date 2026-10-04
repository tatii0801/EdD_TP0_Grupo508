package tp5.ejercicio8;

/*
 * EJERCICIO 8 - STACK
 *
 * Consigna:
 *
 * Cargar una pila con numeros enteros.
 *
 * Los valores que sean multiplos de 3 deben duplicarse.
 *
 * Los demas valores deben mantener su orden relativo.
 *
 * Ejemplo:
 *
 * Original:
 * 3 4 9
 *
 * Resultado:
 * 3 3 4 9 9
 */

import java.util.Random;
import java.util.Scanner;

public class Principal8 {

    /*
     * Muestra la pila desde el tope hasta la base
     * sin destruirla.
     */
    public static void mostrar(
            Stack<Integer> pila) {

        Stack<Integer> auxiliar = new Stack<>();

        System.out.print("Tope -> ");

        while (!pila.isEmpty()) {

            Integer numero = pila.pop();

            System.out.print(numero + " ");

            auxiliar.push(numero);
        }

        System.out.println("<- Base");

        /*
         * Restauramos la pila.
         *
         * Al pasar los elementos nuevamente
         * conservamos su orden.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }

    /*
     * Duplica los multiplos de 3.
     *
     * Se utiliza una pila auxiliar para poder
     * procesar los elementos sin perderlos.
     */
    public static void duplicarMultiplosDe3(
            Stack<Integer> pila) {

        Stack<Integer> auxiliar = new Stack<>();

        /*
         * Sacamos todos los elementos de la pila.
         */
        while (!pila.isEmpty()) {

            int numero = pila.pop();

            /*
             * Si es multiplo de 3,
             * lo colocamos dos veces.
             */
            if (numero % 3 == 0) {

                auxiliar.push(numero);
                auxiliar.push(numero);

            } else {

                auxiliar.push(numero);
            }
        }

        /*
         * Volvemos a pasar los elementos
         * a la pila original.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Stack<Integer> pila = new Stack<>();

        // ==========================
        // PEDIR CANTIDAD
        // ==========================

        System.out.print(
                "Ingrese cantidad de elementos: ");

        int n = scanner.nextInt();

        // ==========================
        // CARGAR PILA
        // ==========================

        for (int i = 0; i < n; i++) {

            int numero = random.nextInt(21);

            pila.push(numero);
        }

        // ==========================
        // PILA ORIGINAL
        // ==========================

        System.out.println("\n===== PILA ORIGINAL =====");

        mostrar(pila);

        // ==========================
        // DUPLICAR
        // ==========================

        duplicarMultiplosDe3(pila);

        // ==========================
        // RESULTADO
        // ==========================

        System.out.println(
                "\n===== PILA FINAL =====");

        mostrar(pila);

        scanner.close();
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) Si Stack utiliza SimpleLinkedList internamente,
 * ¿donde conviene insertar y eliminar?
 *
 * Respuesta:
 * Conviene hacerlo al principio.
 *
 * push() -> addFirst()
 * pop() -> removeFirst()
 *
 * De esta forma no necesitamos recorrer la lista.
 *
 *
 * b) ¿Que pasa si la pila esta vacia?
 *
 * Respuesta:
 * No hay elementos para duplicar.
 *
 * El proceso simplemente termina sin modificar nada.
 *
 *
 * c) Si tenemos:
 *
 * Tope -> 3, 4, 9 <- Base
 *
 * ¿Que pasa con los elementos?
 *
 * Los multiplos de 3 son 3 y 9.
 *
 * Por lo tanto se duplican.
 *
 * El resultado debe contener:
 *
 * 3, 3, 4, 9, 9
 *
 *
 * d) ¿Que problema tendriamos si modificamos
 * directamente la pila original?
 *
 * Respuesta:
 * Mientras hacemos:
 *
 * while (!pila.isEmpty())
 *
 * vamos sacando elementos de la misma pila.
 *
 * Si intentamos volver a agregar inmediatamente
 * elementos y continuar recorriendo, podemos procesarlos
 * nuevamente o alterar el orden.
 *
 * Por eso utilizamos una pila auxiliar.
 *
 *
 * DIAGRAMA:
 *
 * Stack
 * |
 * v
 * SimpleLinkedList<Integer>
 *
 * TOPE
 * |
 * v
 * [9]
 * |
 * [4]
 * |
 * [3]
 * |
 * null
 *
 * push() -> addFirst()
 * pop() -> removeFirst()
 * 
 * 
 * Lo importante de Stack
          TOPE
           ↓
         [ 9 ]
           ↓
         [ 4 ]
           ↓
         [ 3 ]
           ↓
          null

Por eso:

push() → addFirst()
pop()  → removeFirst()

Esto es LIFO.
 */