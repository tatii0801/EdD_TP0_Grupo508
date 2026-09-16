package tp4.ejercicio8;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * ============================================================
 * EJERCICIO 8 - CLIENTES
 * ============================================================
 *
 * Enunciado:
 *
 * Se dispone de una cola de clientes.
 *
 * Cada cliente posee una edad.
 *
 * Se deben eliminar de la cola todos los clientes menores
 * de 18 años.
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
 * PROBLEMAS DEL CÓDIGO:
 *
 * 1) La condición i < cola.size() utiliza un tamaño que puede
 *    cambiar durante el recorrido.
 *
 * 2) Cuando se elimina un menor, el tamaño de la cola disminuye.
 *
 * 3) Esto puede hacer que el ciclo termine antes de procesar
 *    todos los elementos originales.
 *
 * 4) c.edad puede generar un problema de encapsulamiento si
 *    edad es private.
 *
 * ============================================================
 *
 * SOLUCIÓN:
 *
 * Primero guardamos el tamaño original:
 *
 * int cantidadOriginal = cola.size();
 *
 * Luego procesamos exactamente esa cantidad de elementos.
 *
 * Los mayores de edad se vuelven a insertar.
 * Los menores simplemente no se vuelven a insertar.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿Por qué se debe guardar el tamaño original?
 *
 * RESPUESTA:
 * Porque la cantidad de elementos cambia al eliminar menores.
 * Guardar el tamaño original permite procesar exactamente una
 * vez cada elemento que estaba inicialmente en la cola.
 *
 *
 * b) ¿Qué pasa con los clientes mayores?
 *
 * RESPUESTA:
 * Se vuelven a insertar al final y mantienen el orden relativo
 * que tenían originalmente.
 *
 *
 * c) ¿Qué pasa con los menores?
 *
 * RESPUESTA:
 * Se eliminan porque no se vuelven a insertar en la cola.
 *
 * ============================================================
 */

class Cliente {

    private String nombre;
    private int edad;

    public Cliente(
            String nombre,
            int edad) {

        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {

        return "Cliente{nombre='"
                + nombre
                + "', edad="
                + edad
                + "}";
    }
}

public class Ejercicio8 {

    /*
     * ========================================================
     * MÉTODO CORREGIDO
     * ========================================================
     */
    public static void eliminarMenores(
            Queue<Cliente> cola) {

        /*
         * Guardamos la cantidad ORIGINAL.
         */
        int cantidadOriginal = cola.size();

        /*
         * Procesamos exactamente los elementos
         * que existían al comienzo.
         */
        for (int i = 0; i < cantidadOriginal; i++) {

            Cliente cliente = cola.poll();

            /*
             * Si es mayor o igual a 18,
             * vuelve a la cola.
             */
            if (cliente.getEdad() >= 18) {

                cola.add(cliente);
            }

            /*
             * Si es menor de 18,
             * no lo agregamos nuevamente.
             */
        }
    }

    public static void main(String[] args) {

        Queue<Cliente> cola = new ArrayDeque<>();

        /*
         * Cargamos algunos clientes.
         */
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
                "Cola original:");

        System.out.println(cola);

        /*
         * Eliminamos los menores.
         */
        eliminarMenores(cola);

        System.out.println(
                "\nCola después de eliminar menores de edad:");

        System.out.println(cola);
    }
}
