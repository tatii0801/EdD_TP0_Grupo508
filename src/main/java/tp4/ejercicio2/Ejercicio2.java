package tp4.ejercicio2;

import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 2 - COLA CIRCULAR
 * ============================================================
 *
 * ENUNCIADO:
 *
 * Implementar una Cola Circular utilizando un arreglo.
 *
 * La cola tendrá un tamaño fijo.
 *
 * Se utilizará para almacenar códigos de documentos.
 *
 * Los códigos pares tienen prioridad alta y se envían a una
 * segunda cola para impresión a color.
 *
 * Los códigos impares se imprimen en blanco y negro y se
 * descartan.
 *
 * Se debe:
 *
 * - Procesar los documentos.
 * - Mostrar los documentos enviados a color.
 * - Mostrar los documentos descartados.
 * - Contar los documentos enviados a color.
 *
 * ============================================================
 *
 * PREGUNTAS Y RESPUESTAS
 * ============================================================
 *
 * a) ¿Cuál es la ventaja de una cola circular?
 *
 * RESPUESTA:
 * Permite reutilizar las posiciones del arreglo sin desplazar
 * todos los elementos.
 *
 *
 * b) Si el tamaño es 5 y el frente está en la posición 4,
 *    ¿cuál será el nuevo frente?
 *
 * RESPUESTA:
 * Será la posición 0.
 *
 * Se calcula:
 *
 * (frente + 1) % capacidad
 *
 *
 * c) ¿Por qué no se desplazan los elementos?
 *
 * RESPUESTA:
 * Porque la cola circular utiliza índices que avanzan de manera
 * circular y permite realizar las operaciones de forma más
 * eficiente.
 *
 * ============================================================
 */

/*
 * ============================================================
 * CLASE COLA CIRCULAR
 * ============================================================
 */

class ColaCircular {

    private int[] datos;

    private int frente;

    private int fin;

    private int cantidad;

    public ColaCircular(int capacidad) {

        datos = new int[capacidad];

        frente = 0;

        fin = 0;

        cantidad = 0;
    }

    // Agregar elemento
    public boolean encolar(int valor) {

        if (estaLlena()) {

            return false;
        }

        datos[fin] = valor;

        fin = (fin + 1) % datos.length;

        cantidad++;

        return true;
    }

    // Sacar elemento
    public int desencolar() {

        if (estaVacia()) {

            throw new RuntimeException(
                    "La cola está vacía.");
        }

        int valor = datos[frente];

        frente = (frente + 1) % datos.length;

        cantidad--;

        return valor;
    }

    public boolean estaVacia() {

        return cantidad == 0;
    }

    public boolean estaLlena() {

        return cantidad == datos.length;
    }

    public int tamanio() {

        return cantidad;
    }

    // Copia la cola sin modificarla
    public ColaCircular copiar() {

        ColaCircular copia = new ColaCircular(
                datos.length);

        for (int i = 0; i < cantidad; i++) {

            int posicion = (frente + i)
                    % datos.length;

            copia.encolar(
                    datos[posicion]);
        }

        return copia;
    }

    @Override
    public String toString() {

        String texto = "[";

        for (int i = 0; i < cantidad; i++) {

            int posicion = (frente + i)
                    % datos.length;

            texto += datos[posicion];

            if (i < cantidad - 1) {

                texto += ", ";
            }
        }

        texto += "]";

        return texto;
    }
}

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("\n=========================================");
        System.out.println("          COLA CIRCULAR");
        System.out.println("=========================================");

        // ==========================================
        // PASO 1: TAMAÑO
        // ==========================================

        int capacidad;

        do {

            System.out.print(
                    "\nIngrese el tamaño de la cola circular: ");

            capacidad = entrada.nextInt();

            if (capacidad <= 0) {

                System.out.println(
                        "-> El tamaño debe ser mayor que 0.");
            }

        } while (capacidad <= 0);

        ColaCircular cola = new ColaCircular(capacidad);

        // ==========================================
        // PASO 2: CARGA
        // ==========================================

        System.out.println(
                "\nIngrese los códigos:");

        for (int i = 0; i < capacidad; i++) {

            System.out.print(
                    "Código " + (i + 1) + ": ");

            int codigo = entrada.nextInt();

            cola.encolar(codigo);
        }

        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        // Hacemos una copia para procesar
        ColaCircular colaProcesar = cola.copiar();

        ColaCircular colaColor = new ColaCircular(capacidad);

        int descartados = 0;

        // ==========================================
        // PASO 3: PROCESAMIENTO
        // ==========================================

        System.out.println(
                "\nProcesando documentos:");

        while (!colaProcesar.estaVacia()) {

            int codigo = colaProcesar.desencolar();

            if (codigo % 2 == 0) {

                System.out.println(
                        "Documento "
                                + codigo
                                + " -> COLOR");

                colaColor.encolar(codigo);

            } else {

                System.out.println(
                        "Documento "
                                + codigo
                                + " -> BLANCO Y NEGRO "
                                + "y descartado.");

                descartados++;
            }
        }

        // ==========================================
        // PASO 4: RESULTADOS
        // ==========================================

        System.out.println(
                "\nCola de impresión a color:");

        System.out.println(colaColor);

        System.out.println(
                "Cantidad de documentos a color: "
                        + colaColor.tamanio());

        System.out.println(
                "Cantidad de documentos descartados: "
                        + descartados);

        // ==========================================
        // PASO 5: PROCESAR SEGUNDA COLA
        // ==========================================

        System.out.println(
                "\nProcesando cola a color:");

        while (!colaColor.estaVacia()) {

            int codigo = colaColor.desencolar();

            System.out.println(
                    "Imprimiendo documento "
                            + codigo);
        }

        // La original se mantiene
        System.out.println(
                "\nCola original:");

        System.out.println(cola);

        entrada.close();
    }
}