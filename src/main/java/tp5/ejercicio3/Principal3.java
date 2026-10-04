package tp5.ejercicio3;

/*
 * EJERCICIO 3 - LISTA
 *
 * Consigna:
 *
 * Se tienen dos listas de Suscripcion.
 *
 * a) Crear una nueva lista con las suscripciones cuyos usuarios
 *    aparecen en ambas listas.
 *
 * b) Contar la cantidad total de suscripciones de un usuario
 *    ingresado por teclado, considerando las dos listas.
 *
 * c) Crear una nueva lista con la union de ambas listas,
 *    ordenada por fechaInicio.
 */

import java.time.LocalDate;
import java.util.Scanner;

import tp5.Base_Profesor.SimpleLinkedList;

public class Principal3 {

    /*
     * Punto A
     *
     * Busca las suscripciones cuyos usuarios aparecen
     * en las dos listas.
     */
    public static SimpleLinkedList<Suscripcion> interseccion(
            SimpleLinkedList<Suscripcion> lista1,
            SimpleLinkedList<Suscripcion> lista2) {

        SimpleLinkedList<Suscripcion> resultado = new SimpleLinkedList<>();

        for (Suscripcion s1 : lista1) {

            boolean encontrado = false;

            for (Suscripcion s2 : lista2) {

                if (s1.getUsuario().equalsIgnoreCase(s2.getUsuario())) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                resultado.addLast(s1);
            }
        }

        return resultado;
    }

    /*
     * Punto B
     *
     * Cuenta todas las suscripciones de un usuario
     * en las dos listas.
     */
    public static int contarSuscripciones(
            SimpleLinkedList<Suscripcion> lista1,
            SimpleLinkedList<Suscripcion> lista2,
            String usuario) {

        int cantidad = 0;

        for (Suscripcion s : lista1) {

            if (s.getUsuario().equalsIgnoreCase(usuario)) {
                cantidad++;
            }
        }

        for (Suscripcion s : lista2) {

            if (s.getUsuario().equalsIgnoreCase(usuario)) {
                cantidad++;
            }
        }

        return cantidad;
    }

    /*
     * Punto C
     *
     * Une las dos listas y las ordena por fecha de inicio.
     *
     * Se utiliza una lista nueva para no modificar
     * las listas originales.
     */
    public static SimpleLinkedList<Suscripcion> unionOrdenada(
            SimpleLinkedList<Suscripcion> lista1,
            SimpleLinkedList<Suscripcion> lista2) {

        SimpleLinkedList<Suscripcion> resultado = new SimpleLinkedList<>();

        // Agregamos todos los elementos de la primera lista
        for (Suscripcion s : lista1) {
            insertarOrdenado(resultado, s);
        }

        // Agregamos todos los elementos de la segunda lista
        for (Suscripcion s : lista2) {
            insertarOrdenado(resultado, s);
        }

        return resultado;
    }

    /*
     * Inserta una suscripcion respetando el orden
     * por fecha de inicio.
     */
    private static void insertarOrdenado(
            SimpleLinkedList<Suscripcion> lista,
            Suscripcion nueva) {

        SimpleLinkedList<Suscripcion> auxiliar = new SimpleLinkedList<>();

        boolean insertado = false;

        while (lista.size() > 0) {

            Suscripcion actual = lista.removeFirst();

            if (!insertado &&
                    nueva.getFechaInicio().isBefore(actual.getFechaInicio())) {

                auxiliar.addLast(nueva);
                insertado = true;
            }

            auxiliar.addLast(actual);
        }

        if (!insertado) {
            auxiliar.addLast(nueva);
        }

        // Volvemos a colocar los elementos en la lista original
        while (auxiliar.size() > 0) {
            lista.addLast(auxiliar.removeFirst());
        }
    }

    /*
     * Muestra una lista de suscripciones.
     */
    public static void mostrarLista(
            SimpleLinkedList<Suscripcion> lista) {

        if (lista.size() == 0) {
            System.out.println("La lista esta vacia.");
            return;
        }

        for (Suscripcion s : lista) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SimpleLinkedList<Suscripcion> lista1 = new SimpleLinkedList<>();

        SimpleLinkedList<Suscripcion> lista2 = new SimpleLinkedList<>();

        // ==========================
        // CARGA DE LA LISTA 1
        // ==========================

        lista1.addLast(new Suscripcion(
                1, "tatiana", "Basico",
                LocalDate.of(2026, 1, 10)));

        lista1.addLast(new Suscripcion(
                2, "juan", "Premium",
                LocalDate.of(2026, 2, 15)));

        lista1.addLast(new Suscripcion(
                3, "maria", "Basico",
                LocalDate.of(2026, 3, 20)));

        // ==========================
        // CARGA DE LA LISTA 2
        // ==========================

        lista2.addLast(new Suscripcion(
                4, "lucas", "Premium",
                LocalDate.of(2026, 1, 5)));

        lista2.addLast(new Suscripcion(
                5, "tatiana", "Premium",
                LocalDate.of(2026, 4, 10)));

        lista2.addLast(new Suscripcion(
                6, "sofia", "Basico",
                LocalDate.of(2026, 5, 12)));

        System.out.println("===== LISTA 1 =====");
        mostrarLista(lista1);

        System.out.println("\n===== LISTA 2 =====");
        mostrarLista(lista2);

        // ==========================
        // PUNTO A
        // ==========================

        SimpleLinkedList<Suscripcion> interseccion = interseccion(lista1, lista2);

        System.out.println("\n===== INTERSECCION =====");
        mostrarLista(interseccion);

        // ==========================
        // PUNTO B
        // ==========================

        System.out.print("\nIngrese usuario a buscar: ");
        String usuario = scanner.nextLine();

        int cantidad = contarSuscripciones(
                lista1, lista2, usuario);

        System.out.println(
                "Cantidad de suscripciones de " +
                        usuario + ": " + cantidad);

        // ==========================
        // PUNTO C
        // ==========================

        SimpleLinkedList<Suscripcion> union = unionOrdenada(lista1, lista2);

        System.out.println("\n===== UNION ORDENADA POR FECHA =====");
        mostrarLista(union);

        scanner.close();
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) ¿Es necesario recorrer completamente la segunda lista
 * por cada elemento de la primera?
 *
 * Respuesta:
 * En esta solucion si, porque se compara cada elemento de
 * la primera lista con los elementos de la segunda.
 *
 * Si las listas estuvieran ordenadas por usuario se podria
 * optimizar recorriendo ambas listas al mismo tiempo.
 *
 *
 * b) ¿Que devuelve la union si ambas listas estan vacias?
 *
 * Respuesta:
 * Devuelve una nueva lista vacia.
 *
 *
 * c) Si un usuario tiene 3 suscripciones en la lista 1
 * y 2 en la lista 2, ¿cual es el resultado del punto B
 * y del punto A?
 *
 * Respuesta:
 * En el punto B el resultado es 5 porque se cuentan todas
 * las suscripciones del usuario.
 *
 * En el punto A se agregan las suscripciones cuyos usuarios
 * aparecen en ambas listas.
 *
 *
 * d) Al hacer la union, ¿hay que crear nuevos objetos
 * Suscripcion?
 *
 * Respuesta:
 * No es necesario crear nuevos objetos.
 * Podemos reutilizar las mismas referencias a los objetos
 * de las listas originales.
 *
 * Lo importante es crear una nueva lista para no modificar
 * las listas originales.
 */
