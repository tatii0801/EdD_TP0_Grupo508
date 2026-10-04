package tp5.ejercicio5;

import tp5.Base_Profesor.SimpleLinkedList;

/*
 * EJERCICIO 5 - LISTA
 *
 * a) Calcular y mostrar el promedio de cada aspirante.
 * b) Retornar el aspirante con mayor promedio.
 * c) Crear una nueva lista con los aprobados.
 */

public class Principal5 {

    /*
     * Punto B
     *
     * Busca el aspirante que tiene el mayor promedio.
     */
    public static Aspirante mayorPromedio(
            SimpleLinkedList<Aspirante> lista) {

        if (lista.size() == 0) {
            return null;
        }

        Aspirante mayor = null;

        for (Aspirante aspirante : lista) {

            if (mayor == null ||
                    aspirante.promedio() > mayor.promedio()) {

                mayor = aspirante;
            }
        }

        return mayor;
    }

    /*
     * Punto C
     *
     * Crea una nueva lista con promedio >= 7.
     */
    public static SimpleLinkedList<Aspirante> aprobados(
            SimpleLinkedList<Aspirante> lista) {

        SimpleLinkedList<Aspirante> resultado = new SimpleLinkedList<>();

        for (Aspirante aspirante : lista) {

            if (aspirante.promedio() >= 7) {
                resultado.addLast(aspirante);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {

        SimpleLinkedList<Aspirante> lista = new SimpleLinkedList<>();

        // Carga de aspirantes

        lista.addLast(new Aspirante(
                1001, "Ana", "Perez",
                8, 7, 9));

        lista.addLast(new Aspirante(
                1002, "Juan", "Gomez",
                6, 6, 7));

        lista.addLast(new Aspirante(
                1003, "Maria", "Lopez",
                9, 9, 8));

        lista.addLast(new Aspirante(
                1004, "Lucas", "Diaz",
                5, 6, 6));

        lista.addLast(new Aspirante(
                1005, "Sofia", "Ruiz",
                7, 7, 7));

        // ==========================
        // PUNTO A
        // ==========================

        System.out.println("===== ASPIRANTES =====");

        for (Aspirante aspirante : lista) {
            System.out.println(aspirante);
        }

        // ==========================
        // PUNTO B
        // ==========================

        Aspirante mayor = mayorPromedio(lista);

        System.out.println("\n===== MAYOR PROMEDIO =====");

        if (mayor != null) {
            System.out.println(mayor);
        } else {
            System.out.println("No hay aspirantes.");
        }

        // ==========================
        // PUNTO C
        // ==========================

        SimpleLinkedList<Aspirante> aprobados = aprobados(lista);

        System.out.println("\n===== APROBADOS =====");

        for (Aspirante aspirante : aprobados) {
            System.out.println(aspirante);
        }
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) ¿En la lista de aprobados creamos nuevos objetos?
 *
 * Respuesta:
 * No es necesario.
 * Podemos reutilizar las referencias a los mismos objetos
 * Aspirante.
 *
 * Si después modificamos el objeto original, también se
 * verá modificado desde la lista de aprobados porque ambas
 * referencias apuntan al mismo objeto.
 *
 *
 * b) ¿Que pasa si todos tienen promedio menor que 7?
 *
 * Respuesta:
 * La lista de aprobados queda vacia.
 *
 * Si la lista original esta vacia, mayorPromedio devuelve null.
 *
 *
 * c) Si los promedios son 8, 6, 9 y 7:
 *
 * Respuesta:
 * El mayor promedio es 9.
 *
 * Los aprobados son:
 * 8, 9 y 7.
 *
 * Por lo tanto hay 3 aprobados.
 *
 *
 * d) ¿Donde conviene colocar el calculo del promedio?
 *
 * Respuesta:
 * En la clase Aspirante, porque el promedio depende de
 * los datos propios del aspirante.
 *
 * De esta manera la lista solamente se encarga de recorrer
 * y trabajar con los objetos.
 */