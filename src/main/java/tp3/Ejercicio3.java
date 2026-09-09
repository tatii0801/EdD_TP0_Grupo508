package tp3;

import java.util.Scanner;
import java.util.Random;
import java.util.Stack;

/*
 * ENUNCIADO:
 *
 * Dada una pila cargada con N números enteros generados de manera
 * aleatoria, implementar lo siguiente:
 *
 * a) Un método que reciba una pila de enteros y un número X, y elimine
 *    todos los elementos que sean divisores exactos de X. Los demás
 *    elementos deben mantenerse en la pila en el mismo orden original.
 *
 * b) Un método que reemplace todos los números impares de la pila
 *    por el número 0, manteniendo la posición de los elementos.
 *
 * c) Un método que cuente la cantidad de elementos que son mayores al
 *    elemento que se encuentra en la cima de la pila. La pila original
 *    no debe modificarse.
 *
 * d) Un método que intercambie el elemento que se encuentra en la cima
 *    con el elemento que se encuentra justo en la mitad de la pila.
 *
 * En el main se debe generar la pila aleatoriamente, mostrarla, y
 * ejecutar cada método mostrando el estado antes y después.
 *
 * ================================================================
 *
 * PREGUNTAS SOBRE EL PROBLEMA
 *
 * a) En el punto (d), ¿qué sucede si la pila tiene un número par de
 *    elementos? ¿Cuál se considera la "mitad"? ¿Qué pasa si la pila
 *    tiene 1 elemento o está vacía?
 *
 * RESPUESTA:
 * Con cantidad par no hay un único elemento central: por ejemplo con
 * 4 elementos hay dos candidatos (2do y 3ro desde la cima). Por eso
 * hay que fijar una convención: en este código se usa indice = size/2
 * contando desde la cima (0 = cima). Si la pila tiene 1 elemento, la
 * cima y la "mitad" son el mismo elemento, entonces el intercambio no
 * tiene efecto real. Si la pila está vacía, no hay nada para
 * intercambiar; el método lo controla antes para no lanzar
 * EmptyStackException.
 *
 *
 * b) Si la pila (de base a cima) contiene 8, 2, 5 y 1: ¿cuál es el
 *    resultado de contarMayoresQueCima? ¿Cómo queda la pila después
 *    de intercambiar la cima con la mitad?
 *
 * RESPUESTA:
 * De base a cima: 8, 2, 5, 1 significa que de cima a base es: 1, 5, 2, 8.
 * La cima es 1. Son mayores a 1: el 5, el 2 y el 8, entonces
 * contarMayoresQueCima devuelve 3.
 * Para el intercambio, con 4 elementos el indice de la mitad es 2
 * (contando desde la cima: 1 -> 0, 5 -> 1, 2 -> 2). Se intercambian
 * el 1 y el 2. Queda de cima a base: 2, 5, 1, 8.
 *
 *
 * c) Si un compañero hace pop() de todos los elementos para contarlos
 *    y los mete en una pila auxiliar, ¿qué paso le falta?
 *
 * RESPUESTA:
 * Le falta devolver todos los elementos de la pila auxiliar a la
 * pila original. Si los deja solamente en la auxiliar, la pila
 * original queda vacía, y eso es modificarla, justo lo que la
 * consigna prohíbe.
 *
 *
 * d) Si se quisiera agregar ordenarPilaAscendente() que devuelva otra
 *    pila ordenada sin modificar la original, ¿se podría hacer con
 *    una sola pila auxiliar? Justificar.
 *
 * RESPUESTA:
 * No completamente. El algoritmo clásico para ordenar una pila con
 * una sola pila auxiliar (más una variable temporal) funciona, pero
 * consume la pila que ordena, así que no sirve para dejar la original
 * intacta y a la vez devolver una nueva pila ordenada. Para lograr
 * las dos cosas a la vez hacen falta dos estructuras auxiliares: una
 * para copiar el contenido sin alterar el orden de la original, y
 * otra para aplicar el algoritmo de ordenamiento sobre esa copia.
 *
 * ================================================================
 */

public class Ejercicio3 {

    // a) Elimina los elementos que son divisores exactos de X.
    public static void eliminarDivisoresDeX(Stack<Integer> pila, int x) {

        Stack<Integer> aux = new Stack<>();

        while (!pila.isEmpty()) {

            int valor = pila.pop();

            // El 0 se descarta de la comparación: no se puede dividir
            // por cero, y el 0 no se considera divisor de ningún entero.
            boolean esDivisor = (valor != 0) && (x % valor == 0);

            if (!esDivisor) {

                aux.push(valor);
            }
        }

        while (!aux.isEmpty()) {

            pila.push(aux.pop());
        }
    }

    // b) Reemplaza los números impares por 0, manteniendo la posición.
    public static void reemplazarImparesPorCero(Stack<Integer> pila) {

        Stack<Integer> aux = new Stack<>();

        while (!pila.isEmpty()) {

            int valor = pila.pop();

            if (valor % 2 != 0) {

                valor = 0;
            }

            aux.push(valor);
        }

        while (!aux.isEmpty()) {

            pila.push(aux.pop());
        }
    }

    // c) Cuenta los elementos mayores a la cima, sin modificar la pila.
    public static int contarMayoresQueCima(Stack<Integer> pila) {

        if (pila.isEmpty()) {

            return 0;
        }

        int cima = pila.peek();
        int contador = 0;

        Stack<Integer> aux = new Stack<>();

        while (!pila.isEmpty()) {

            int valor = pila.pop();

            if (valor > cima) {

                contador++;
            }

            aux.push(valor);
        }

        // Se restaura la pila original completa.
        while (!aux.isEmpty()) {

            pila.push(aux.pop());
        }

        return contador;
    }

    // d) Intercambia el elemento de la cima con el de la mitad.
    public static void intercambiarCimaConMitad(Stack<Integer> pila) {

        int size = pila.size();

        if (size < 2) {

            return;
        }

        int indiceMitad = size / 2;

        Stack<Integer> aux = new Stack<>();

        int cima = -1;
        int mitad = -1;

        for (int i = 0; i <= indiceMitad; i++) {

            int valor = pila.pop();

            if (i == 0) {

                cima = valor;
            }

            if (i == indiceMitad) {

                mitad = valor;
            }

            aux.push(valor);
        }

        int i = indiceMitad;

        while (!aux.isEmpty()) {

            int valor = aux.pop();

            if (i == indiceMitad) {

                pila.push(cima);

            } else if (i == 0) {

                pila.push(mitad);

            } else {

                pila.push(valor);
            }

            i--;
        }
    }

    // Muestra la pila sin modificarla.
    public static void mostrarPila(String etiqueta, Stack<Integer> pila) {

        Stack<Integer> aux = new Stack<>();

        System.out.print(etiqueta + " (cima -> base): [ ");

        while (!pila.isEmpty()) {

            int valor = pila.pop();

            System.out.print(valor + " ");

            aux.push(valor);
        }

        while (!aux.isEmpty()) {

            pila.push(aux.pop());
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=================================");
        System.out.println("       EJERCICIO 3 - PILAS");
        System.out.println("=================================");

        // e) Solicitar N y cargar la pila con valores aleatorios.
        System.out.print("\nIngrese la cantidad N de elementos: ");
        int n = scanner.nextInt();

        while (n <= 0) {

            System.out.print("La cantidad debe ser mayor a 0. Ingrese nuevamente: ");
            n = scanner.nextInt();
        }

        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < n; i++) {

            int valor = random.nextInt(41) - 20; // entre -20 y 20

            pila.push(valor);
        }

        // f) Mostrar la pila original.
        System.out.println();
        mostrarPila("Pila original", pila);

        // g) Ejecutar cada método mostrando antes y después.

        System.out.println("\n--- a) Eliminar divisores de X ---");
        System.out.print("Ingrese el valor de X: ");
        int x = scanner.nextInt();

        mostrarPila("Antes", pila);
        eliminarDivisoresDeX(pila, x);
        mostrarPila("Después", pila);

        System.out.println("\n--- b) Reemplazar impares por 0 ---");
        mostrarPila("Antes", pila);
        reemplazarImparesPorCero(pila);
        mostrarPila("Después", pila);

        System.out.println("\n--- c) Contar mayores que la cima ---");
        mostrarPila("Pila (no se modifica)", pila);
        int cantidad = contarMayoresQueCima(pila);
        System.out.println("Cantidad de elementos mayores a la cima: " + cantidad);
        mostrarPila("Pila luego de contar", pila);

        System.out.println("\n--- d) Intercambiar cima con la mitad ---");
        mostrarPila("Antes", pila);
        intercambiarCimaConMitad(pila);
        mostrarPila("Después", pila);

        scanner.close();
    }
}