package tp4.ejercicio3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 3 - CALL CENTER
 * ============================================================
 *
 * Enunciado:
 *
 * Se dispone de una cola de clientes de un Call Center.
 *
 * Los clientes deben separarse en tres nuevas colas:
 *
 * - Cola corta: nombres de 1 a 4 letras.
 * - Cola media: nombres de 5 a 8 letras.
 * - Cola larga: nombres de 9 o más letras.
 *
 * Para cada cola se debe:
 *
 * - Contar la cantidad de clientes.
 * - Obtener el nombre más largo.
 *
 * Luego se deben unir las tres colas en una nueva cola,
 * respetando el siguiente orden:
 *
 * CORTOS -> MEDIOS -> LARGOS
 *
 * La cola original y las colas resultantes no deben modificarse
 * cuando se realizan recorridos de consulta.
 *
 * La carga finaliza cuando se ingresa FIN.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿La cola original queda vacía después de dividirla?
 *
 * RESPUESTA:
 * No necesariamente. En esta solución se utiliza un recorrido
 * que no elimina los elementos, por lo tanto la cola original
 * permanece igual.
 *
 *
 * b) ¿Qué sucede si una categoría está vacía?
 *
 * RESPUESTA:
 * Se informa que no hay clientes en esa categoría y no se intenta
 * obtener un elemento inexistente.
 *
 *
 * c) ¿Se necesita una cola auxiliar para unir las tres colas?
 *
 * RESPUESTA:
 * No. Se puede crear una nueva cola y copiar primero los clientes
 * cortos, después los medios y finalmente los largos.
 *
 * ============================================================
 */

public class Ejercicio3 {

    /*
     * Devuelve la cantidad de letras del nombre.
     *
     * Se eliminan los espacios para que, por ejemplo,
     * "Ana Maria" se considere por sus letras.
     */
    public static int longitudNombre(String nombre) {

        return nombre.replace(" ", "").length();
    }

    /*
     * Divide los clientes en las tres colas.
     */
    public static void dividirColas(
            Queue<String> original,
            Queue<String> cortos,
            Queue<String> medios,
            Queue<String> largos) {

        for (String nombre : original) {

            int longitud =
                    longitudNombre(nombre);

            if (longitud >= 1 && longitud <= 4) {

                cortos.add(nombre);

            } else if (longitud <= 8) {

                medios.add(nombre);

            } else {

                largos.add(nombre);
            }
        }
    }

    /*
     * Cuenta los elementos.
     */
    public static int contar(Queue<String> cola) {

        return cola.size();
    }

    /*
     * Busca el nombre más largo.
     */
    public static String nombreMasLargo(
            Queue<String> cola) {

        if (cola.isEmpty()) {

            return "No hay clientes";
        }

        String mayor = null;

        for (String nombre : cola) {

            if (mayor == null ||
                    longitudNombre(nombre)
                            > longitudNombre(mayor)) {

                mayor = nombre;
            }
        }

        return mayor;
    }

    /*
     * Une las tres colas en el orden indicado.
     */
    public static Queue<String> unirColas(
            Queue<String> cortos,
            Queue<String> medios,
            Queue<String> largos) {

        Queue<String> resultado =
                new ArrayDeque<>();

        for (String nombre : cortos) {
            resultado.add(nombre);
        }

        for (String nombre : medios) {
            resultado.add(nombre);
        }

        for (String nombre : largos) {
            resultado.add(nombre);
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        Queue<String> original =
                new ArrayDeque<>();

        Queue<String> cortos =
                new ArrayDeque<>();

        Queue<String> medios =
                new ArrayDeque<>();

        Queue<String> largos =
                new ArrayDeque<>();

        System.out.println(
                "Ingrese nombres de clientes.");
        System.out.println(
                "Ingrese FIN para terminar.");

        String nombre;

        do {

            System.out.print("Nombre: ");

            nombre =
                    teclado.nextLine();

            if (!nombre.equalsIgnoreCase("FIN")) {

                if (!nombre.trim().isEmpty()) {

                    original.add(nombre);
                }
            }

        } while (!nombre.equalsIgnoreCase("FIN"));

        /*
         * Dividimos las colas.
         */
        dividirColas(
                original,
                cortos,
                medios,
                largos);

        System.out.println(
                "\nCola original:");

        System.out.println(original);

        System.out.println(
                "\nCOLA CORTOS:");

        System.out.println(cortos);

        System.out.println(
                "Cantidad: " + contar(cortos));

        System.out.println(
                "Nombre más largo: "
                        + nombreMasLargo(cortos));

        System.out.println(
                "\nCOLA MEDIOS:");

        System.out.println(medios);

        System.out.println(
                "Cantidad: " + contar(medios));

        System.out.println(
                "Nombre más largo: "
                        + nombreMasLargo(medios));

        System.out.println(
                "\nCOLA LARGOS:");

        System.out.println(largos);

        System.out.println(
                "Cantidad: " + contar(largos));

        System.out.println(
                "Nombre más largo: "
                        + nombreMasLargo(largos));

        /*
         * Unimos las tres colas.
         */
        Queue<String> unificada =
                unirColas(
                        cortos,
                        medios,
                        largos);

        System.out.println(
                "\nCOLA UNIFICADA:");

        System.out.println(unificada);

        /*
         * Comprobamos que las colas originales
         * siguen teniendo sus elementos.
         */
        System.out.println(
                "\nCola original después de los recorridos:");

        System.out.println(original);

        teclado.close();
    }
}
