package tp4.ejercicio5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 5 - ENVÍOS
 * ============================================================
 *
 * Enunciado:
 *
 * Cada envío posee:
 *
 * - código de seguimiento
 * - peso en kg
 * - destino
 * - estado
 *
 * Destinos:
 *
 * - Local
 * - Nacional
 * - Internacional
 *
 * Estados:
 *
 * - En Camino
 * - Entregado
 * - Devuelto
 *
 * Se debe implementar:
 *
 * a) Calcular el peso total de los envíos de un destino indicado.
 * b) Encontrar el envío de mayor peso.
 * c) Contar los envíos devueltos.
 * d) Mantener la cola original sin modificaciones.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿Por qué una cola es adecuada para los envíos?
 *
 * RESPUESTA:
 * Porque una cola trabaja con FIFO: el primer envío que llega
 * es el primero que se procesa.
 *
 *
 * b) Si los envíos nacionales pesan:
 *
 * 10.5 kg
 * 20.0 kg
 * 15.2 kg
 *
 * ¿Cuál es el peso total?
 *
 * RESPUESTA:
 *
 * 10.5 + 20.0 + 15.2 = 45.7 kg
 *
 * El mayor de esos tres es 20.0 kg.
 *
 *
 * c) ¿Qué ocurre si usamos poll/remove para recorrer la cola?
 *
 * RESPUESTA:
 * Los elementos son eliminados. Para conservar la cola original
 * se debe utilizar una cola auxiliar o un recorrido no destructivo.
 *
 *
 * d) ¿El siguiente código encuentra el mayor?
 *
 * Envió mayor = cola.peek();
 *
 * while (!cola.isEmpty()) {
 *     Envio actual = cola.poll();
 *     if (actual.getPeso() > mayor.getPeso()) {
 *         mayor = actual;
 *     }
 * }
 *
 * RESPUESTA:
 * Sí, encuentra el mayor, pero modifica y vacía la cola original.
 * Además, se debe verificar que la cola no esté vacía antes de
 * usar peek().
 *
 * ============================================================
 */

class Envio {

    private String codigoSeguimiento;
    private double peso;
    private String destino;
    private String estado;

    public Envio(
            String codigoSeguimiento,
            double peso,
            String destino,
            String estado) {

        this.codigoSeguimiento = codigoSeguimiento;
        this.peso = peso;
        this.destino = destino;
        this.estado = estado;
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {

        return "Envio{codigo='"
                + codigoSeguimiento
                + "', peso="
                + peso
                + " kg, destino='"
                + destino
                + "', estado='"
                + estado
                + "'}";
    }
}

public class Ejercicio5 {

    /*
     * Calcula el peso total de un destino.
     */
    public static double pesoTotalDestino(
            Queue<Envio> cola,
            String destino) {

        double total = 0;

        for (Envio envio : cola) {

            if (envio.getDestino()
                    .equalsIgnoreCase(destino)) {

                total += envio.getPeso();
            }
        }

        return total;
    }

    /*
     * Busca el envío de mayor peso.
     */
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

    /*
     * Cuenta los envíos devueltos.
     */
    public static int contarDevueltos(
            Queue<Envio> cola) {

        int contador = 0;

        for (Envio envio : cola) {

            if (envio.getEstado()
                    .equalsIgnoreCase("Devuelto")) {

                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Queue<Envio> cola = new ArrayDeque<>();

        System.out.println(
                "Carga de envíos.");

        for (int i = 0; i < 5; i++) {

            System.out.println(
                    "\nEnvío " + (i + 1));

            System.out.print(
                    "Código de seguimiento: ");

            String codigo = teclado.nextLine();

            double peso;

            do {

                System.out.print(
                        "Peso en kg: ");

                peso = teclado.nextDouble();

            } while (peso < 0);

            teclado.nextLine();

            System.out.print(
                    "Destino (Local/Nacional/Internacional): ");

            String destino = teclado.nextLine();

            System.out.print(
                    "Estado (En Camino/Entregado/Devuelto): ");

            String estado = teclado.nextLine();

            cola.add(
                    new Envio(
                            codigo,
                            peso,
                            destino,
                            estado));
        }

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        System.out.print(
                "\nIngrese el destino a consultar: ");

        String destino = teclado.nextLine();

        double total = pesoTotalDestino(
                cola,
                destino);

        System.out.println(
                "Peso total para "
                        + destino
                        + ": "
                        + total
                        + " kg");

        Envio mayor = mayorPeso(cola);

        if (mayor != null) {

            System.out.println(
                    "\nEnvío de mayor peso:");

            System.out.println(mayor);
        }

        int devueltos = contarDevueltos(cola);

        System.out.println(
                "\nCantidad de envíos devueltos: "
                        + devueltos);

        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        teclado.close();
    }
}