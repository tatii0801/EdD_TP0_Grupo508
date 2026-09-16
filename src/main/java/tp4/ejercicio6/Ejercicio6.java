package tp4.ejercicio6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 6 - FARMACIA
 * ============================================================
 *
 * Enunciado:
 *
 * Una farmacia atiende clientes mediante una cola de turnos.
 *
 * Cada turno posee:
 *
 * - DNI del cliente
 * - Obra Social
 * - Indicador de si fue atendido
 *
 * Se debe implementar:
 *
 * a) Crear una nueva cola con los turnos pendientes.
 * b) Contar cuántos turnos corresponden a una obra social dada.
 * c) Buscar un DNI y determinar si fue atendido.
 *
 * Si el DNI no existe o está esperando, se devuelve false.
 *
 * La cola original no debe modificarse.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿Cuándo puede terminar antes una búsqueda?
 *
 * RESPUESTA:
 * Si cada DNI es único, cuando se encuentra el DNI se puede
 * terminar la búsqueda.
 *
 * Si puede haber varios registros con el mismo DNI, habría que
 * continuar buscando según lo que se quiera comprobar.
 *
 *
 * b) ¿Qué ocurre si el DNI no existe?
 *
 * RESPUESTA:
 * Se devuelve false y no se genera ninguna excepción.
 *
 *
 * c) ¿Qué ocurre si se usa remove/poll sobre la cola original?
 *
 * RESPUESTA:
 * Se eliminan los elementos. Para conservar la cola original
 * debemos usar una cola auxiliar y luego restaurarla, o realizar
 * un recorrido que no la modifique.
 *
 *
 * d) ¿Se puede cambiar directamente fueAtendido?
 *
 * RESPUESTA:
 * Sí, si tenemos la referencia al objeto y utilizamos un setter.
 * En este ejercicio las consultas no modifican la cola.
 *
 * ============================================================
 */

class Turno {

    private int dniCliente;
    private String obraSocial;
    private boolean fueAtendido;

    public Turno(
            int dniCliente,
            String obraSocial,
            boolean fueAtendido) {

        this.dniCliente = dniCliente;
        this.obraSocial = obraSocial;
        this.fueAtendido = fueAtendido;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public boolean getFueAtendido() {
        return fueAtendido;
    }

    public void setFueAtendido(
            boolean fueAtendido) {

        this.fueAtendido = fueAtendido;
    }

    @Override
    public String toString() {

        return "Turno{DNI="
                + dniCliente
                + ", obraSocial='"
                + obraSocial
                + "', atendido="
                + fueAtendido
                + "}";
    }
}


public class Ejercicio6 {

    /*
     * Genera una nueva cola con los turnos pendientes.
     */
    public static Queue<Turno> generarPendientes(
            Queue<Turno> cola) {

        Queue<Turno> pendientes =
                new ArrayDeque<>();

        for (Turno turno : cola) {

            if (!turno.getFueAtendido()) {

                pendientes.add(turno);
            }
        }

        return pendientes;
    }

    /*
     * Cuenta turnos de una obra social.
     */
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

    /*
     * Busca un DNI.
     *
     * Devuelve true si fue atendido.
     * Devuelve false si está pendiente o no existe.
     */
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

        Scanner teclado =
                new Scanner(System.in);

        Queue<Turno> cola =
                new ArrayDeque<>();

        System.out.println(
                "Carga de turnos.");

        for (int i = 0; i < 5; i++) {

            System.out.println(
                    "\nTurno " + (i + 1));

            System.out.print(
                    "DNI: ");

            int dni =
                    teclado.nextInt();

            teclado.nextLine();

            System.out.print(
                    "Obra Social: ");

            String obraSocial =
                    teclado.nextLine();

            System.out.print(
                    "¿Fue atendido? (1 = Sí / 0 = No): ");

            int opcion =
                    teclado.nextInt();

            boolean atendido =
                    opcion == 1;

            cola.add(
                    new Turno(
                            dni,
                            obraSocial,
                            atendido));
        }

        teclado.nextLine();

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        Queue<Turno> pendientes =
                generarPendientes(cola);

        System.out.println(
                "\nTurnos pendientes:");

        System.out.println(pendientes);

        System.out.print(
                "\nIngrese una obra social: ");

        String obra =
                teclado.nextLine();

        int cantidad =
                contarObraSocial(
                        cola,
                        obra);

        System.out.println(
                "Cantidad de turnos de "
                        + obra
                        + ": "
                        + cantidad);

        System.out.print(
                "\nIngrese DNI a buscar: ");

        int dni =
                teclado.nextInt();

        boolean atendido =
                fueAtendido(
                        cola,
                        dni);

        System.out.println(
                "¿El cliente fue atendido?: "
                        + atendido);

        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        teclado.close();
    }
}
