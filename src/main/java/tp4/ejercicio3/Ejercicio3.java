package tp4.ejercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 3 - CALL CENTER
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Se dispone de una cola de clientes de un Call Center.
 *
 * Se deben separar los nombres en tres colas:
 *
 * - CORTOS: de 1 a 4 letras.
 * - MEDIOS: de 5 a 8 letras.
 * - LARGOS: de 9 o más letras.
 *
 * Para cada cola se debe:
 *
 * - Contar clientes.
 * - Obtener el nombre más largo.
 *
 * Luego se deben unir las tres colas:
 *
 * CORTOS -> MEDIOS -> LARGOS
 *
 * La cola original debe permanecer sin modificaciones.
 *
 * La carga termina ingresando FIN.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿La cola original debe quedar vacía?
 *
 * RESPUESTA:
 * No. En esta solución se recorre sin eliminar elementos,
 * por lo tanto la cola original permanece igual.
 *
 *
 * b) ¿Qué pasa si una categoría está vacía?
 *
 * RESPUESTA:
 * Se informa que no existen clientes en esa categoría.
 *
 *
 * c) ¿Se necesita una cola auxiliar para unirlas?
 *
 * RESPUESTA:
 * No. Se puede crear una nueva cola y agregar primero los
 * elementos cortos, después los medios y finalmente los largos.
 *
 * ============================================================
 */

public class Ejercicio3 {

        // Devuelve la cantidad de letras del nombre
        public static int longitudNombre(String nombre) {

                return nombre.replace(" ", "").length();
        }

        // Divide los nombres en las tres colas
        public static void dividirColas(
                        Queue<String> original,
                        Queue<String> cortos,
                        Queue<String> medios,
                        Queue<String> largos) {

                for (String nombre : original) {

                        int longitud = longitudNombre(nombre);

                        if (longitud >= 1
                                        && longitud <= 4) {

                                cortos.add(nombre);

                        } else if (longitud <= 8) {

                                medios.add(nombre);

                        } else {

                                largos.add(nombre);
                        }
                }
        }

        // Busca el nombre más largo
        public static String nombreMasLargo(
                        Queue<String> cola) {

                if (cola.isEmpty()) {

                        return "No hay clientes";
                }

                String mayor = null;

                for (String nombre : cola) {

                        if (mayor == null
                                        || longitudNombre(nombre) > longitudNombre(mayor)) {

                                mayor = nombre;
                        }
                }

                return mayor;
        }

        // Une las tres colas
        public static Queue<String> unirColas(
                        Queue<String> cortos,
                        Queue<String> medios,
                        Queue<String> largos) {

                Queue<String> resultado = new LinkedList<>();

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

                Scanner entrada = new Scanner(System.in);

                Queue<String> original = new LinkedList<>();

                Queue<String> cortos = new LinkedList<>();

                Queue<String> medios = new LinkedList<>();

                Queue<String> largos = new LinkedList<>();

                System.out.println("\n=========================================");
                System.out.println("          CALL CENTER");
                System.out.println("=========================================");

                System.out.println(
                                "\nIngrese los nombres.");
                System.out.println(
                                "Escriba FIN para terminar.");

                String nombre;

                do {

                        System.out.print(
                                        "\nNombre: ");

                        nombre = entrada.nextLine();

                        if (!nombre.equalsIgnoreCase("FIN")
                                        && !nombre.trim().isEmpty()) {

                                original.add(nombre);
                        }

                } while (!nombre.equalsIgnoreCase("FIN"));

                // Dividimos las colas
                dividirColas(
                                original,
                                cortos,
                                medios,
                                largos);

                System.out.println(
                                "\nCola original:");

                System.out.println(original);

                System.out.println(
                                "\n--- CLIENTES CORTOS ---");

                System.out.println(cortos);

                System.out.println(
                                "Cantidad: "
                                                + cortos.size());

                System.out.println(
                                "Nombre más largo: "
                                                + nombreMasLargo(cortos));

                System.out.println(
                                "\n--- CLIENTES MEDIOS ---");

                System.out.println(medios);

                System.out.println(
                                "Cantidad: "
                                                + medios.size());

                System.out.println(
                                "Nombre más largo: "
                                                + nombreMasLargo(medios));

                System.out.println(
                                "\n--- CLIENTES LARGOS ---");

                System.out.println(largos);

                System.out.println(
                                "Cantidad: "
                                                + largos.size());

                System.out.println(
                                "Nombre más largo: "
                                                + nombreMasLargo(largos));

                Queue<String> unificada = unirColas(
                                cortos,
                                medios,
                                largos);

                System.out.println(
                                "\n--- COLA UNIFICADA ---");

                System.out.println(unificada);

                System.out.println(
                                "\nCola original después del recorrido:");

                System.out.println(original);

                entrada.close();
        }
}