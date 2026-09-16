package tp4.ejercicio8;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ============================================================
 * EJERCICIO 8 - ELIMINAR MENORES DE EDAD
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Se dispone de una cola de clientes.
 *
 * Cada cliente posee una edad.
 *
 * Se deben eliminar todos los clientes menores de 18 años.
 *
 * Los clientes mayores o iguales a 18 años deben conservar
 * su orden original.
 *
 * ============================================================
 *
 * CÓDIGO PROPUESTO:
 *
 * public static void eliminarMenores(Queue<Cliente> cola) {
 *
 *     for(int i = 0; i < cola.size(); i++) {
 *
 *         Cliente c = cola.poll();
 *
 *         if(c.edad >= 18) {
 *             cola.add(c);
 *         }
 *     }
 * }
 *
 * ============================================================
 *
 * PROBLEMA:
 *
 * La condición i < cola.size() utiliza un tamaño que cambia
 * durante el recorrido.
 *
 * Cuando eliminamos un menor de edad, la cola disminuye.
 *
 * Por este motivo no necesariamente se procesan todos los
 * elementos originales.
 *
 * Además, si edad es private, no debemos utilizar:
 *
 * c.edad
 *
 * sino:
 *
 * c.getEdad()
 *
 * ============================================================
 *
 * SOLUCIÓN:
 *
 * Guardamos el tamaño original antes de comenzar:
 *
 * int cantidadOriginal = cola.size();
 *
 * Después procesamos exactamente esa cantidad.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿Por qué se guarda el tamaño original?
 *
 * RESPUESTA:
 * Porque la cantidad de elementos de la cola cambia durante
 * el proceso.
 *
 *
 * b) ¿Qué pasa con los mayores de edad?
 *
 * RESPUESTA:
 * Se vuelven a insertar y mantienen su orden relativo.
 *
 *
 * c) ¿Qué pasa con los menores?
 *
 * RESPUESTA:
 * Se eliminan porque no se vuelven a insertar.
 *
 * ============================================================
 */

public class Ejercicio8 {

    /*
     * Elimina todos los menores de 18 años.
     */
    public static void eliminarMenores(
            Queue<Cliente> cola) {

        // Guardamos la cantidad original
        int cantidadOriginal = cola.size();

        /*
         * Procesamos exactamente una vez cada
         * elemento que existía originalmente.
         */
        for (int i = 0; i < cantidadOriginal; i++) {

            // Sacamos el primer cliente
            Cliente cliente = cola.poll();

            /*
             * Si tiene 18 años o más,
             * vuelve a la cola.
             */
            if (cliente.getEdad() >= 18) {

                cola.add(cliente);
            }

            /*
             * Si tiene menos de 18,
             * no lo volvemos a insertar.
             */
        }
    }

    public static void main(String[] args) {

        Queue<Cliente> cola = new LinkedList<>();

        System.out.println("\n=========================================");
        System.out.println("       GESTIÓN DE CLIENTES");
        System.out.println("=========================================");

        // Cargamos clientes de ejemplo

        cola.add(
                new Cliente(
                        "Ana",
                        20));

        cola.add(
                new Cliente(
                        "Pedro",
                        15));

        cola.add(
                new Cliente(
                        "Lucia",
                        25));

        cola.add(
                new Cliente(
                        "Juan",
                        17));

        cola.add(
                new Cliente(
                        "Maria",
                        30));

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        // Eliminamos los menores
        eliminarMenores(cola);

        System.out.println(
                "\nCola después de eliminar menores de edad:");

        System.out.println(cola);

        System.out.println(
                "\nLos clientes mayores o iguales a 18 "
                        + "mantuvieron su orden.");
    }
}