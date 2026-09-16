package tp4.ejercicio5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 5 - ENVÍOS
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Cada envío posee:
 *
 * - código de seguimiento
 * - peso en kg
 * - destino
 * - estado
 *
 * Destinos:
 * - Local
 * - Nacional
 * - Internacional
 *
 * Estados:
 * - En Camino
 * - Entregado
 * - Devuelto
 *
 * Se debe:
 *
 * A) Calcular el peso total de un destino.
 * B) Obtener el envío de mayor peso.
 * C) Contar los envíos devueltos.
 * D) Mantener la cola original sin modificaciones.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿Por qué una cola es adecuada?
 *
 * RESPUESTA:
 * Porque la cola trabaja con FIFO, es decir, el primero que
 * llega es el primero que se procesa.
 *
 *
 * b) Si los envíos nacionales pesan 10.5, 20.0 y 15.2 kg,
 *    ¿cuál es el total?
 *
 * RESPUESTA:
 * 45.7 kg.
 *
 * El mayor de esos tres envíos es el de 20.0 kg.
 *
 *
 * c) ¿Qué ocurre si utilizamos poll para recorrer?
 *
 * RESPUESTA:
 * Los elementos son eliminados. Por eso debemos restaurarlos
 * o utilizar un recorrido que no modifique la cola.
 *
 *
 * d) ¿El código que utiliza peek y poll encuentra el mayor?
 *
 * RESPUESTA:
 * Sí, puede encontrarlo, pero vacía la cola si no se restauran
 * los elementos.
 *
 * ============================================================
 */

public class Ejercicio5 {

    // Calcula el peso total de un destino
    public static double pesoTotalDestino(
            Queue<Envio> cola,
            String destino) {

        double total = 0;

        // Recorremos sin modificar la cola
        for (Envio envio : cola) {

            if (envio.getDestino().equalsIgnoreCase(destino)) {

                total += envio.getPeso();
            }
        }

        return total;
    }

    // Busca el envío de mayor peso
    public static Envio mayorPeso(
            Queue<Envio> cola) {

        if (cola.isEmpty()) {

            return null;
        }

        Envio mayor = cola.peek();

        for (Envio envio : cola) {

            if (envio.getPeso() > mayor.getPeso()) {

                mayor = envio;
            }
        }

        return mayor;
    }

    // Cuenta los envíos devueltos
    public static int contarDevueltos(
            Queue<Envio> cola) {

        int contador = 0;

        for (Envio envio : cola) {

            if (envio.getEstado().equalsIgnoreCase("Devuelto")) {

                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Queue<Envio> cola = new LinkedList<>();

        System.out.println("\n=========================================");
        System.out.println("             GESTIÓN DE ENVÍOS");
        System.out.println("=========================================");

        // ==========================================
        // CARGA DE DATOS
        // ==========================================

        int cantidad;

        do {

            System.out.print(
                    "\n¿Cuántos envíos desea ingresar? "
                    + "(Mínimo 5): ");

            cantidad = entrada.nextInt();

        } while (cantidad < 5);

        entrada.nextLine();

        for (int i = 1; i <= cantidad; i++) {

            System.out.println("\n--- Envío #" + i + " ---");

            System.out.print("Código de seguimiento: ");

            String codigo = entrada.nextLine();

            double peso;

            do {

                System.out.print("Peso en kg: ");

                peso = entrada.nextDouble();

            } while (peso < 0);

            entrada.nextLine();

            System.out.print(
                    "Destino "
                    + "(Local/Nacional/Internacional): ");

            String destino = entrada.nextLine();

            System.out.print(
                    "Estado "
                    + "(En Camino/Entregado/Devuelto): ");

            String estado = entrada.nextLine();

            Envio nuevo = new Envio(
                    codigo,
                    peso,
                    destino,
                    estado);

            cola.add(nuevo);
        }

        // ==========================================
        // RESULTADOS
        // ==========================================

        System.out.println("\nCola original:");
        System.out.println(cola);

        System.out.print(
                "\nIngrese destino a consultar: ");

        String destino = entrada.nextLine();

        double total = pesoTotalDestino(
                cola,
                destino);

        System.out.println(
                "\nA) Peso total del destino "
                + destino
                + ": "
                + total
                + " kg");

        Envio mayor = mayorPeso(cola);

        if (mayor != null) {

            System.out.println(
                    "\nB) Envío de mayor peso:");

            System.out.println(mayor);
        }

        int devueltos = contarDevueltos(cola);

        System.out.println(
                "\nC) Cantidad de envíos devueltos: "
                + devueltos);

        // Comprobamos que la cola no fue modificada
        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        entrada.close();
    }
}