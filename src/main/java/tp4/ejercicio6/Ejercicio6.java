package tp4.ejercicio6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 6 - FARMACIA
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Una farmacia atiende mediante una cola de turnos.
 *
 * Cada turno posee:
 *
 * - DNI del cliente.
 * - Obra social.
 * - Indicador de si fue atendido.
 *
 * Se debe:
 *
 * A) Crear una nueva cola con los turnos pendientes.
 * B) Contar turnos de una obra social determinada.
 * C) Buscar un DNI y determinar si fue atendido.
 *
 * La cola original debe permanecer sin modificaciones.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿Cuándo puede terminar antes una búsqueda?
 *
 * RESPUESTA:
 * Si el DNI es único, cuando encontramos el DNI podemos terminar.
 *
 *
 * b) ¿Qué sucede si el DNI no existe?
 *
 * RESPUESTA:
 * Se devuelve false.
 *
 *
 * c) ¿Qué sucede si utilizamos poll sobre la cola original?
 *
 * RESPUESTA:
 * Los elementos se eliminan. Para conservarla debemos restaurar
 * los elementos o utilizar un recorrido que no modifique.
 *
 *
 * d) ¿Se puede modificar directamente el atributo fueAtendido?
 *
 * RESPUESTA:
 * Sí, mediante un setter si el atributo es privado.
 *
 * ============================================================
 */

public class Ejercicio6 {

    // Genera una cola solamente con los pendientes
    public static Queue<Turno> generarPendientes(
            Queue<Turno> cola) {

        Queue<Turno> pendientes =
                new LinkedList<>();

        for (Turno turno : cola) {

            if (!turno.getFueAtendido()) {

                pendientes.add(turno);
            }
        }

        return pendientes;
    }

    // Cuenta turnos de una obra social
    public static int contarObraSocial(
            Queue<Turno> cola,
            String obraSocial) {

        int contador = 0;

        for (Turno turno : cola) {

            if (turno.getObraSocial()
                    .equalsIgnoreCase(obraSocial)) {

                contador++;
            }
        }

        return contador;
    }

    // Busca un DNI
    public static boolean fueAtendido(
            Queue<Turno> cola,
            int dni) {

        for (Turno turno : cola) {

            if (turno.getDniCliente() == dni) {

                return turno.getFueAtendido();
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner entrada =
                new Scanner(System.in);

        Queue<Turno> cola =
                new LinkedList<>();

        System.out.println("\n=========================================");
        System.out.println("          TURNOS DE FARMACIA");
        System.out.println("=========================================");

        // ==========================================
        // CARGA
        // ==========================================

        int cantidad;

        do {

            System.out.print(
                    "\n¿Cuántos turnos desea ingresar? "
                            + "(Mínimo 5): ");

            cantidad =
                    entrada.nextInt();

        } while (cantidad < 5);

        entrada.nextLine();

        for (int i = 1;
             i <= cantidad;
             i++) {

            System.out.println(
                    "\n--- Turno #" + i + " ---");

            System.out.print(
                    "DNI: ");

            int dni =
                    entrada.nextInt();

            entrada.nextLine();

            System.out.print(
                    "Obra Social: ");

            String obraSocial =
                    entrada.nextLine();

            System.out.print(
                    "¿Fue atendido? "
                            + "(1 = Sí / 0 = No): ");

            int opcion =
                    entrada.nextInt();

            boolean atendido =
                    opcion == 1;

            Turno turno =
                    new Turno(
                            dni,
                            obraSocial,
                            atendido);

            cola.add(turno);
        }

        entrada.nextLine();

        // ==========================================
        // RESULTADOS
        // ==========================================

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        Queue<Turno> pendientes =
                generarPendientes(cola);

        System.out.println(
                "\nA) Turnos pendientes:");

        System.out.println(pendientes);

        System.out.print(
                "\nB) Ingrese obra social: ");

        String obra =
                entrada.nextLine();

        int cantidadObra =
                contarObraSocial(
                        cola,
                        obra);

        System.out.println(
                "Cantidad de turnos de "
                        + obra
                        + ": "
                        + cantidadObra);

        System.out.print(
                "\nC) Ingrese DNI a buscar: ");

        int dni =
                entrada.nextInt();

        boolean atendido =
                fueAtendido(
                        cola,
                        dni);

        System.out.println(
                "¿Fue atendido?: "
                        + atendido);

        // ==========================================
        // COMPROBACIÓN
        // ==========================================

        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        entrada.close();
    }
}