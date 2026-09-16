package tp4.ejercicio1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/*
 * ============================================================
 * ESTRUCTURA DE DATOS
 * TRABAJO PRÁCTICO N° 4 - CICLO 2026
 * TEMA: COLA (QUEUE)
 * ============================================================
 *
 * EJERCICIO 1
 *
 * Enunciado:
 *
 * Se desea simular una cola que contiene N niveles de señal.
 * Se debe solicitar un valor umbral máximo.
 *
 * Los elementos de la cola que excedan el valor umbral deberán
 * ser retirados y reubicados al final de la misma cola.
 *
 * Se debe:
 *
 * a) Solicitar N y generar aleatoriamente los valores.
 * b) Solicitar el valor umbral.
 * c) Reubicar los elementos que superan el umbral.
 * d) Mostrar la cola resultante.
 * e) Contar y mostrar los elementos que no superan el umbral.
 * f) Crear una nueva cola que contenga solamente los elementos
 *    que no superan el umbral.
 *
 * Al recorrer la cola para realizar consultas, la misma debe
 * mantenerse sin modificaciones.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) Para la cola [10, 50, 20, 5] y umbral 15,
 *    ¿cuál es el orden final?
 *
 * RESPUESTA:
 * [10, 5, 50, 20]
 *
 * Los valores que no superan 15 quedan primero y los que
 * superan 15 se reubican al final, manteniendo el orden.
 *
 *
 * b) ¿Qué sucede si todos los elementos superan el umbral?
 *
 * RESPUESTA:
 * La cola queda en el mismo orden original, pero todos sus
 * elementos pertenecen al grupo que fue reubicado.
 *
 *
 * c) ¿Por qué se debe trabajar con el tamaño original?
 *
 * RESPUESTA:
 * Porque al volver a insertar elementos en la cola, su tamaño
 * puede mantenerse o modificarse. Si utilizáramos como condición
 * !cola.isEmpty(), podríamos volver a procesar elementos y no
 * terminar nunca.
 *
 *
 * d) ¿Qué se puede hacer si los elementos que superan el umbral
 *    deben enviarse a otra cola?
 *
 * RESPUESTA:
 * Se puede utilizar una cola auxiliar para guardar los elementos
 * que superan el umbral y luego procesarlos por separado.
 *
 * ============================================================
 */

public class Ejercicio1 {

    /*
     * Reubica al final los elementos que superan el umbral.
     */
    public static void reubicarMayores(Queue<Integer> cola, int umbral) {

        Queue<Integer> noSuperan = new ArrayDeque<>();
        Queue<Integer> superan = new ArrayDeque<>();

        // Guardamos el tamaño original.
        int cantidadOriginal = cola.size();

        // Procesamos exactamente los elementos originales.
        for (int i = 0; i < cantidadOriginal; i++) {

            int numero = cola.remove();

            if (numero > umbral) {
                superan.add(numero);
            } else {
                noSuperan.add(numero);
            }
        }

        // Primero vuelven los que no superan el umbral.
        while (!noSuperan.isEmpty()) {
            cola.add(noSuperan.remove());
        }

        // Después vuelven los que superan el umbral.
        while (!superan.isEmpty()) {
            cola.add(superan.remove());
        }
    }

    /*
     * Cuenta los elementos que no superan el umbral.
     *
     * Se utiliza for-each para no modificar la cola.
     */
    public static int contarNoSuperan(Queue<Integer> cola, int umbral) {

        int contador = 0;

        for (int numero : cola) {

            if (numero <= umbral) {
                contador++;
            }
        }

        return contador;
    }

    /*
     * Crea una nueva cola solamente con los elementos
     * que no superan el umbral.
     *
     * La cola original no se modifica.
     */
    public static Queue<Integer> crearColaNoSuperan(
            Queue<Integer> cola, int umbral) {

        Queue<Integer> nuevaCola = new ArrayDeque<>();

        for (int numero : cola) {

            if (numero <= umbral) {
                nuevaCola.add(numero);
            }
        }

        return nuevaCola;
    }

    /*
     * Muestra los elementos de una cola.
     */
    public static void mostrarCola(Queue<Integer> cola) {

        System.out.println(cola);
    }

    /*
     * Lee un entero mayor o igual a cero.
     */
    public static int leerEnteroNoNegativo(Scanner teclado, String mensaje) {

        int numero;

        do {

            System.out.print(mensaje);
            numero = teclado.nextInt();

            if (numero < 0) {
                System.out.println("Debe ser un valor mayor o igual a 0.");
            }

        } while (numero < 0);

        return numero;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        Queue<Integer> cola = new ArrayDeque<>();

        // a) Solicitar N.
        int n = leerEnteroNoNegativo(
                teclado,
                "Ingrese la cantidad de niveles de señal: ");

        // Generamos valores aleatorios entre 0 y 100.
        for (int i = 0; i < n; i++) {

            int valor = random.nextInt(101);

            cola.add(valor);
        }

        System.out.println("\nCola original:");
        mostrarCola(cola);

        // b) Solicitar umbral.
        int umbral = leerEnteroNoNegativo(
                teclado,
                "Ingrese el valor umbral: ");

        // c) Reubicar mayores.
        reubicarMayores(cola, umbral);

        System.out.println("\nCola después de reubicar:");
        mostrarCola(cola);

        // d) Contar los que no superan el umbral.
        int cantidad = contarNoSuperan(cola, umbral);

        System.out.println(
                "\nCantidad de elementos que no superan el umbral: "
                        + cantidad);

        // e) Crear nueva cola.
        Queue<Integer> nuevaCola =
                crearColaNoSuperan(cola, umbral);

        System.out.println(
                "Nueva cola con elementos que no superan el umbral:");

        mostrarCola(nuevaCola);

        // La cola original permanece igual después de las consultas.
        System.out.println(
                "\nLa cola original se mantiene:");
        mostrarCola(cola);

        teclado.close();
    }
}