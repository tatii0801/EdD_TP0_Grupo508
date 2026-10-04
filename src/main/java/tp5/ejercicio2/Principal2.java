package tp5.ejercicio2;

import tp5.Base_Profesor.DoubleLinkedList;
import tp5.Base_Profesor.DoubleLinkedOrderedList;
import tp5.Base_Profesor.Helper;

public class Principal2 {

    /*
     * Buscar la cancion mas antigua.
     */
    public static Cancion cancionMasAntigua(
            DoubleLinkedList<Cancion> lista) {

        if (lista.size() == 0) {
            return null;
        }

        Cancion masAntigua = null;

        for (Cancion cancion : lista) {

            if (masAntigua == null ||
                    cancion.getAnioLanzamiento() < masAntigua.getAnioLanzamiento()) {

                masAntigua = cancion;
            }
        }

        return masAntigua;
    }

    /*
     * Buscar todas las canciones de un artista.
     */
    public static DoubleLinkedList<Cancion> cancionesDeArtista(
            DoubleLinkedList<Cancion> lista,
            String artista) {

        DoubleLinkedList<Cancion> resultado = new DoubleLinkedList<>();

        for (Cancion cancion : lista) {

            if (cancion.getArtista()
                    .equalsIgnoreCase(artista)) {

                resultado.addLast(cancion);
            }
        }

        return resultado;
    }

    /*
     * Crear estadisticas por artista.
     */
    public static DoubleLinkedOrderedList<EstadisticaArtista> generarEstadisticas(
            DoubleLinkedList<Cancion> lista) {

        DoubleLinkedOrderedList<EstadisticaArtista> resultado = new DoubleLinkedOrderedList<>();

        DoubleLinkedList<EstadisticaArtista> acumuladas = new DoubleLinkedList<>();

        for (Cancion cancion : lista) {

            EstadisticaArtista encontrada = null;

            for (EstadisticaArtista estadistica : acumuladas) {

                if (estadistica.getNombreArtista()
                        .equalsIgnoreCase(
                                cancion.getArtista())) {

                    encontrada = estadistica;

                    break;
                }
            }

            if (encontrada == null) {

                acumuladas.addLast(
                        new EstadisticaArtista(
                                cancion.getArtista(),
                                cancion.getDuracionSegundos()));

            } else {

                encontrada.setTotalReproducciones(
                        encontrada.getTotalReproducciones()
                                + cancion.getDuracionSegundos());
            }
        }

        // Ahora pasamos las estadisticas a la lista ordenada.
        for (EstadisticaArtista estadistica : acumuladas) {

            resultado.addInOrder(estadistica);
        }

        return resultado;
    }

    public static void main(String[] args) {

        DoubleLinkedList<Cancion> canciones = new DoubleLinkedList<>();

        // Cargamos 10 canciones.
        canciones.addLast(
                new Cancion(
                        "Cancion 1",
                        "Artista A",
                        2010,
                        200));

        canciones.addLast(
                new Cancion(
                        "Cancion 2",
                        "Artista B",
                        2005,
                        180));

        canciones.addLast(
                new Cancion(
                        "Cancion 3",
                        "Artista A",
                        2015,
                        220));

        canciones.addLast(
                new Cancion(
                        "Cancion 4",
                        "Artista C",
                        2001,
                        250));

        canciones.addLast(
                new Cancion(
                        "Cancion 5",
                        "Artista B",
                        2012,
                        190));

        canciones.addLast(
                new Cancion(
                        "Cancion 6",
                        "Artista D",
                        1999,
                        300));

        canciones.addLast(
                new Cancion(
                        "Cancion 7",
                        "Artista A",
                        2020,
                        210));

        canciones.addLast(
                new Cancion(
                        "Cancion 8",
                        "Artista C",
                        2018,
                        230));

        canciones.addLast(
                new Cancion(
                        "Cancion 9",
                        "Artista D",
                        2003,
                        280));

        canciones.addLast(
                new Cancion(
                        "Cancion 10",
                        "Artista B",
                        2021,
                        170));

        System.out.println("=================================");
        System.out.println("        EJERCICIO 2");
        System.out.println("=================================");

        System.out.println("\nCanciones:");

        System.out.println(canciones);

        System.out.println("\nCancion mas antigua:");

        System.out.println(
                cancionMasAntigua(canciones));

        String artista = Helper.getString(
                "\nIngrese un artista: ");

        System.out.println(
                "\nCanciones del artista:");

        System.out.println(
                cancionesDeArtista(
                        canciones,
                        artista));

        System.out.println(
                "\nEstadisticas por artista:");

        System.out.println(
                generarEstadisticas(canciones));
    }

    /*
     * =========================================================
     * PREGUNTAS
     * =========================================================
     *
     * a) ¿Que ventaja tiene la lista doble?
     *
     * Tiene enlaces next y prev.
     *
     * Esto permite avanzar y retroceder por la lista.
     *
     *
     * b) ¿Que pasa si el artista no existe?
     *
     * La nueva lista queda vacia.
     *
     *
     * c) ¿Ordenar al final o insertar ordenado?
     *
     * Insertar ordenado permite mantener la lista ordenada
     * mientras agregamos los elementos.
     *
     *
     * d) ¿Cuantos enlaces se actualizan al eliminar un nodo
     * del medio?
     *
     * Principalmente dos:
     *
     * - El next del nodo anterior.
     * - El prev del nodo siguiente.
     */
}
