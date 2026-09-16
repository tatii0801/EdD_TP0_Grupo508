package tp4.ejercicio2;

import java.util.Scanner;

/*
 * ============================================================
 * EJERCICIO 2 - COLA CIRCULAR
 * ============================================================
 *
 * Enunciado:
 *
 * Implementar una Cola Circular utilizando un arreglo.
 *
 * La cola debe tener tamaño fijo y utilizar los índices de
 * frente y final de manera circular.
 *
 * Se utilizará la cola para almacenar códigos de documentos.
 *
 * Varios impresores toman el primer documento disponible.
 *
 * Si el código es PAR:
 *     - Tiene prioridad alta.
 *     - Se envía a una segunda cola de impresión a color.
 *
 * Si el código es IMPAR:
 *     - Se imprime en blanco y negro.
 *     - Se descarta.
 *
 * Se debe:
 *
 * - Procesar los documentos.
 * - Mostrar los documentos enviados a color.
 * - Mostrar los documentos descartados.
 * - Contar los documentos pares enviados a color.
 *
 * ============================================================
 *
 * PREGUNTAS
 *
 * a) ¿Qué ventaja tiene una cola circular?
 *
 * RESPUESTA:
 * Permite reutilizar las posiciones del arreglo sin tener que
 * desplazar todos los elementos después de cada eliminación.
 *
 *
 * b) Si el tamaño es 5 y el frente está en la posición 4,
 *    ¿qué posición ocupa el nuevo frente después de desencolar?
 *
 * RESPUESTA:
 * La posición 0.
 *
 * Se utiliza:
 *
 * (frente + 1) % capacidad
 *
 *
 * c) ¿Por qué no desplazar todos los elementos?
 *
 * RESPUESTA:
 * Porque desplazar elementos puede requerir recorrer varias
 * posiciones. La cola circular permite realizar el avance
 * utilizando índices y resulta más eficiente.
 *
 * ============================================================
 */

/*
 * Clase ColaCircular.
 *
 * Se implementa con un arreglo.
 */
class ColaCircular {

    private int[] datos;

    private int frente;
    private int fin;
    private int cantidad;

    /*
     * Constructor.
     */
    public ColaCircular(int capacidad) {

        datos = new int[capacidad];

        frente = 0;
        fin = 0;
        cantidad = 0;
    }

    /*
     * Agrega un elemento a la cola.
     */
    public boolean encolar(int valor) {

        if (estaLlena()) {
            return false;
        }

        datos[fin] = valor;

        fin = (fin + 1) % datos.length;

        cantidad++;

        return true;
    }

    /*
     * Elimina y devuelve el elemento del frente.
     */
    public int desencolar() {

        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía.");
        }

        int valor = datos[frente];

        frente = (frente + 1) % datos.length;

        cantidad--;

        return valor;
    }

    /*
     * Indica si la cola está vacía.
     */
    public boolean estaVacia() {

        return cantidad == 0;
    }

    /*
     * Indica si la cola está llena.
     */
    public boolean estaLlena() {

        return cantidad == datos.length;
    }

    /*
     * Devuelve el tamaño actual.
     */
    public int tamanio() {

        return cantidad;
    }

    /*
     * Devuelve la capacidad.
     */
    public int capacidad() {

        return datos.length;
    }

    /*
     * Permite copiar la cola sin modificar la original.
     */
    public ColaCircular copiar() {

        ColaCircular copia = new ColaCircular(datos.length);

        for (int i = 0; i < cantidad; i++) {

            int posicion = (frente + i) % datos.length;

            copia.encolar(datos[posicion]);
        }

        return copia;
    }

    /*
     * Muestra la cola.
     */
    @Override
    public String toString() {

        String texto = "[";

        for (int i = 0; i < cantidad; i++) {

            int posicion = (frente + i) % datos.length;

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

        Scanner teclado = new Scanner(System.in);

        System.out.print(
                "Ingrese el tamaño de la cola circular: ");

        int capacidad = teclado.nextInt();

        while (capacidad <= 0) {

            System.out.print(
                    "Ingrese un tamaño mayor que 0: ");

            capacidad = teclado.nextInt();
        }

        ColaCircular cola = new ColaCircular(capacidad);

        /*
         * Cargamos la cola hasta completar su capacidad.
         */
        System.out.println(
                "\nIngrese los códigos de los documentos:");

        for (int i = 0; i < capacidad; i++) {

            System.out.print(
                    "Código " + (i + 1) + ": ");

            int codigo = teclado.nextInt();

            cola.encolar(codigo);
        }

        System.out.println("\nCola original:");
        System.out.println(cola);

        /*
         * Hacemos una copia para procesar los documentos.
         *
         * Así podemos demostrar que el recorrido de consulta
         * no modifica la cola original.
         */
        ColaCircular colaProcesar = cola.copiar();

        ColaCircular colaColor = new ColaCircular(capacidad);

        int descartados = 0;

        System.out.println(
                "\nProcesamiento de documentos:");

        while (!colaProcesar.estaVacia()) {

            int codigo = colaProcesar.desencolar();

            if (codigo % 2 == 0) {

                System.out.println(
                        "Documento " + codigo
                                + " -> impresión a COLOR.");

                colaColor.encolar(codigo);

            } else {

                System.out.println(
                        "Documento " + codigo
                                + " -> blanco y negro y descartado.");

                descartados++;
            }
        }

        System.out.println(
                "\nCola de documentos a color:");

        System.out.println(colaColor);

        /*
         * Contamos los documentos pares.
         */
        int cantidadColor = colaColor.tamanio();

        System.out.println(
                "Cantidad de documentos enviados a color: "
                        + cantidadColor);

        /*
         * Procesamos la segunda cola.
         */
        System.out.println(
                "\nProcesando cola de impresión a color:");

        while (!colaColor.estaVacia()) {

            int codigo = colaColor.desencolar();

            System.out.println(
                    "Imprimiendo documento: " + codigo);
        }

        System.out.println(
                "\nCantidad de documentos descartados: "
                        + descartados);

        /*
         * La cola original no fue modificada.
         */
        System.out.println(
                "\nCola original después de las consultas:");

        System.out.println(cola);

        teclado.close();
    }
}
