// Programa para gestionar equipos de una liga.

package tp2;

import java.util.Scanner;

/*
 * ENUNCIADO:
 *
 * Crear la clase Equipo con los atributos:
 *
 * - idEquipo
 * - nombre
 * - puntajeAcumulado
 * - partidosJugados
 *
 * El programa debe solicitar la cantidad de equipos.
 *
 * Luego debe permitir:
 *
 * a) Actualizar el puntaje de un equipo dado su id.
 * b) Calcular el total de partidos jugados.
 * c) Calcular el promedio general de puntajes.
 * d) Identificar el equipo con mayor puntaje.
 * e) Mostrar los equipos que estén por debajo del promedio.
 */

// Clase Equipo.
class Equipo {

    // Atributos privados para aplicar encapsulamiento.
    private int idEquipo;
    private String nombre;
    private int puntajeAcumulado;
    private int partidosJugados;

    // Constructor.
    public Equipo(
            int idEquipo,
            String nombre,
            int puntajeAcumulado,
            int partidosJugados) {

        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.puntajeAcumulado = puntajeAcumulado;
        this.partidosJugados = partidosJugados;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    // Método para sumar puntos.
    public void sumarPuntos(int puntos) {

        puntajeAcumulado += puntos;
    }

    // Muestra los datos del equipo.
    public void mostrarDatos() {

        System.out.println(
                "ID: " + idEquipo
                        + " | Nombre: " + nombre
                        + " | Puntos: " + puntajeAcumulado
                        + " | Partidos: " + partidosJugados);
    }
}

// Clase principal.
public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cantidad;

        do {

            System.out.print("Ingrese la cantidad de equipos: ");
            cantidad = scanner.nextInt();

            if (cantidad <= 0) {
                System.out.println(
                        "La cantidad debe ser mayor a cero.");
            }

        } while (cantidad <= 0);

        // Creamos el arreglo de equipos.
        Equipo[] equipos = new Equipo[cantidad];

        // Cargamos los equipos.
        for (int i = 0; i < equipos.length; i++) {

            System.out.println("\nEquipo " + (i + 1));

            System.out.print("ID: ");
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Puntaje acumulado: ");
            int puntaje = scanner.nextInt();

            System.out.print("Partidos jugados: ");
            int partidos = scanner.nextInt();

            equipos[i] = new Equipo(
                    id,
                    nombre,
                    puntaje,
                    partidos);
        }

        // Punto a.
        System.out.print("\nIngrese el ID del equipo al que desea sumar puntos: ");
        int idBuscado = scanner.nextInt();

        System.out.print("Ingrese la cantidad de puntos a sumar: ");
        int puntos = scanner.nextInt();

        actualizarPuntaje(equipos, idBuscado, puntos);

        // Punto b.
        int totalPartidos = calcularTotalPartidos(equipos);

        System.out.println(
                "\nTotal de partidos jugados: "
                        + totalPartidos);

        // Punto c.
        double promedio = calcularPromedio(equipos);

        System.out.println(
                "Promedio general de puntos: "
                        + promedio);

        // Punto d.
        Equipo lider = obtenerLider(equipos);

        System.out.println("\nEquipo líder:");

        if (lider != null) {
            lider.mostrarDatos();
        }

        // Punto e.
        System.out.println(
                "\nEquipos en zona de descenso:");

        mostrarZonaDescenso(equipos, promedio);

        scanner.close();
    }

    // Busca un equipo y suma puntos.
    public static void actualizarPuntaje(
            Equipo[] equipos,
            int idBuscado,
            int puntos) {

        boolean encontrado = false;

        for (Equipo equipo : equipos) {

            if (equipo.getIdEquipo() == idBuscado) {

                equipo.sumarPuntos(puntos);

                encontrado = true;

                System.out.println(
                        "Puntaje actualizado correctamente.");

                break;
            }
        }

        if (!encontrado) {
            System.out.println(
                    "No se encontró un equipo con ese ID.");
        }
    }

    // Calcula el total de partidos.
    public static int calcularTotalPartidos(
            Equipo[] equipos) {

        int total = 0;

        for (Equipo equipo : equipos) {
            total += equipo.getPartidosJugados();
        }

        return total;
    }

    // Calcula el promedio general de puntos.
    public static double calcularPromedio(
            Equipo[] equipos) {

        if (equipos.length == 0) {
            return 0;
        }

        int suma = 0;

        for (Equipo equipo : equipos) {
            suma += equipo.getPuntajeAcumulado();
        }

        return (double) suma / equipos.length;
    }

    // Obtiene el equipo con mayor puntaje.
    public static Equipo obtenerLider(
            Equipo[] equipos) {

        if (equipos.length == 0) {
            return null;
        }

        Equipo lider = equipos[0];

        for (int i = 1; i < equipos.length; i++) {

            if (equipos[i].getPuntajeAcumulado() > lider.getPuntajeAcumulado()) {

                lider = equipos[i];
            }
        }

        return lider;
    }

    // Muestra los equipos que están debajo del promedio.
    public static void mostrarZonaDescenso(
            Equipo[] equipos,
            double promedio) {

        for (Equipo equipo : equipos) {

            if (equipo.getPuntajeAcumulado() < promedio) {

                equipo.mostrarDatos();

                System.out.println(
                        "Estado: ZONA DE DESCENSO");
            }
        }
    }
}