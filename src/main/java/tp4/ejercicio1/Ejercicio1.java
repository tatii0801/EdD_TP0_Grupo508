package tp4.ejercicio1;

import java.util.LinkedList;
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
 * EJERCICIO 1 - NIVELES DE SEÑAL
 *
 * ENUNCIADO:
 *
 * Se desea simular una cola que contiene N niveles de señal.
 *
 * Se debe solicitar:
 *
 * - La cantidad N de elementos.
 * - Un valor umbral máximo.
 *
 * Los elementos que excedan el valor umbral deberán ser
 * retirados y reubicados al final de la misma cola.
 *
 * Se debe:
 *
 * a) Solicitar N y generar los valores aleatoriamente.
 * b) Solicitar el valor umbral.
 * c) Reubicar los elementos que superen el umbral.
 * d) Mostrar la cola después de la reordenación.
 * e) Contar los elementos que no superen el umbral.
 * f) Crear una nueva cola con los elementos que no superen
 *    el umbral.
 *
 * La cola debe mantenerse sin modificaciones cuando se realizan
 * recorridos de consulta.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) Para la cola [10, 50, 20, 5] y umbral 15,
 *    ¿cuál es el orden final?
 *
 * RESPUESTA:
 * [10, 5, 50, 20]
 *
 * Los elementos que no superan el umbral quedan primero y los
 * que lo superan se colocan al final, respetando su orden.
 *
 *
 * b) ¿Qué sucede si todos los elementos superan el umbral?
 *
 * RESPUESTA:
 * La cola mantiene el mismo orden relativo de los elementos.
 *
 *
 * c) ¿Por qué se debe utilizar el tamaño original?
 *
 * RESPUESTA:
 * Porque los elementos se vuelven a insertar en la cola.
 * Si utilizáramos !cola.isEmpty() podríamos volver a procesar
 * elementos y generar un ciclo que no termina.
 *
 *
 * d) ¿Qué se podría hacer si los elementos que superan el umbral
 *    deben guardarse en otra cola?
 *
 * RESPUESTA:
 * Se puede utilizar una cola auxiliar para guardar los elementos
 * que superan el umbral.
 *
 * ============================================================
 */

public class Ejercicio1 {

    // Reubica al final los elementos que superan el umbral
    public static void reubicarMayores(
            Queue<Integer> cola,
            int umbral) {

        Queue<Integer> noSuperan = new LinkedList<>();

        Queue<Integer> superan = new LinkedList<>();

        // Guardamos el tamaño original
        int tamañoOriginal = cola.size();

        // Procesamos solamente los elementos originales
        for (int i = 0; i < tamañoOriginal; i++) {

            int numero = cola.poll();

            if (numero > umbral) {

                superan.add(numero);

            } else {

                noSuperan.add(numero);
            }
        }

        // Primero colocamos los que no superan
        while (!noSuperan.isEmpty()) {

            cola.add(noSuperan.poll());
        }

        // Después colocamos los que superan
        while (!superan.isEmpty()) {

            cola.add(superan.poll());
        }
    }

    // Cuenta los elementos que no superan el umbral
    public static int contarNoSuperan(
            Queue<Integer> cola,
            int umbral) {

        int contador = 0;

        // Este recorrido NO modifica la cola
        for (int numero : cola) {

            if (numero <= umbral) {

                contador++;
            }
        }

        return contador;
    }

    // Crea una nueva cola con los elementos que no superan
    public static Queue<Integer> crearColaNoSuperan(
            Queue<Integer> cola,
            int umbral) {

        Queue<Integer> nuevaCola = new LinkedList<>();

        // Recorremos sin modificar la cola original
        for (int numero : cola) {

            if (numero <= umbral) {

                nuevaCola.add(numero);
            }
        }

        return nuevaCola;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Random aleatorio = new Random();

        Queue<Integer> cola = new LinkedList<>();

        // ==========================================
        // PASO 1: CARGA DE DATOS
        // ==========================================

        System.out.println("\n=========================================");
        System.out.println("       NIVELES DE SEÑAL");
        System.out.println("=========================================");

        int cantidad;

        do {

            System.out.print(
                    "\n¿Cuántos niveles desea generar? ");

            cantidad = entrada.nextInt();

            if (cantidad < 1) {

                System.out.println(
                        "-> Error: debe ingresar al menos 1.");
            }

        } while (cantidad < 1);

        // Generamos valores aleatorios entre 0 y 100
        for (int i = 0; i < cantidad; i++) {

            int numero = aleatorio.nextInt(101);

            cola.add(numero);
        }

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        // ==========================================
        // PASO 2: UMBRAL
        // ==========================================

        System.out.print(
                "\nIngrese el valor umbral: ");

        int umbral = entrada.nextInt();

        // ==========================================
        // PASO 3: REUBICACIÓN
        // ==========================================

        reubicarMayores(
                cola,
                umbral);

        System.out.println(
                "\nCola después de reubicar:");

        System.out.println(cola);

        // ==========================================
        // PASO 4: CONTAR
        // ==========================================

        int cantidadNoSuperan = contarNoSuperan(
                cola,
                umbral);

        System.out.println(
                "\nCantidad de elementos que no superan "
                        + umbral + ": "
                        + cantidadNoSuperan);

        // ==========================================
        // PASO 5: NUEVA COLA
        // ==========================================

        Queue<Integer> nuevaCola = crearColaNoSuperan(
                cola,
                umbral);

        System.out.println(
                "\nNueva cola con elementos que no superan "
                        + "el umbral:");

        System.out.println(nuevaCola);

        // Comprobamos que la cola original no cambió
        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        entrada.close();
    }
}