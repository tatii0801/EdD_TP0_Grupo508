package tp1;

// Programa principal para gestionar reservas de hotel.

import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.Scanner;

/*
 * Enunciado:
 *
 * Crear al menos dos objetos Reserva diferentes.
 *
 * Solicitar una fecha de consulta.
 *
 * Para cada reserva:
 *
 * - Mostrar sus datos.
 * - Determinar si esta activa.
 * - Calcular dias restantes o transcurridos.
 * - Simular una prorroga.
 */

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos dos reservas diferentes.
        Reserva reserva1 = crearReserva(
                scanner,
                "RES001");

        Reserva reserva2 = crearReserva(
                scanner,
                "RES002");

        // Solicitamos la fecha de consulta.
        LocalDate fechaConsulta = ingresarFecha(scanner, "fecha de consulta");

        // Analizamos la primera reserva.
        mostrarReserva(
                reserva1,
                fechaConsulta,
                scanner);

        // Analizamos la segunda reserva.
        mostrarReserva(
                reserva2,
                fechaConsulta,
                scanner);

        scanner.close();
    }

    // Metodo para crear una reserva solicitando los datos.
    public static Reserva crearReserva(
            Scanner scanner,
            String codigo) {

        System.out.println(
                "\n===== CREAR RESERVA " + codigo + " =====");

        System.out.print("Ingrese nombre del huesped: ");
        String nombre = scanner.nextLine();

        LocalDate checkIn = ingresarFecha(scanner, "check-in");

        LocalDate checkOut = ingresarFecha(scanner, "check-out");

        return new Reserva(
                codigo,
                nombre,
                checkIn,
                checkOut);
    }

    // Metodo para ingresar una fecha.
    public static LocalDate ingresarFecha(
            Scanner scanner,
            String descripcion) {

        LocalDate fecha = null;

        while (fecha == null) {

            try {

                System.out.println(
                        "\nIngrese " + descripcion);

                System.out.print("Dia: ");
                int dia = scanner.nextInt();

                System.out.print("Mes: ");
                int mes = scanner.nextInt();

                System.out.print("Año: ");
                int año = scanner.nextInt();

                scanner.nextLine();

                fecha = LocalDate.of(
                        año,
                        mes,
                        dia);

            } catch (DateTimeException e) {

                System.out.println(
                        "Error: la fecha ingresada no es valida.");

            }
        }

        return fecha;
    }

    // Metodo que muestra y analiza una reserva.
    public static void mostrarReserva(
            Reserva reserva,
            LocalDate fechaConsulta,
            Scanner scanner) {

        System.out.println(
                "\n==============================");

        System.out.println(reserva);

        boolean activa = reserva.estaActiva(fechaConsulta);

        System.out.println(
                "\nReserva activa: " + activa);

        long dias = reserva.calcularDiasRestantesOTranscurridos(
                fechaConsulta);

        System.out.println(
                "Dias restantes/transcurridos: " + dias);

        System.out.print(
                "Ingrese cantidad de dias para la prorroga: ");

        int cantidadDias = scanner.nextInt();

        LocalDate nuevaFecha = reserva.simularProrroga(cantidadDias);

        System.out.println(
                "Nueva fecha de check-out simulada: "
                        + nuevaFecha);
    }
}

/*
 * Preguntas sobre el problema
 * a) ¿Por qué se pide que la validación de fechas sea un "método auxiliar"
 * dentro de la clase Reserva? ¿Qué
 * ocurriría si esa validación se hiciera en el método main antes de llamar al
 * constructor?
 * La validación debe estar dentro de Reserva porque la propia clase debe
 * garantizar que sus objetos sean válidos. Si se hiciera solamente en main,
 * otro programa podría crear una Reserva inválida.
 * 
 * b) ¿Qué sucede si el usuario ingresa la misma fecha para check-in y
 * check-out? Según la regla del inciso (e)
 * ¿qué debería ocurrir con el objeto?
 * Si el check-in y check-out son iguales, la condición checkIn < checkOut no se
 * cumple. Por lo tanto, el objeto debe reemplazar las fechas por la fecha
 * actual y el día siguiente.
 * 
 * c) Si una reserva tiene fechaCheckIn = 2025-05-01 y fechaCheckOut =
 * 2025-05-05, y el usuario ingresa
 * fechaConsulta = 2025-05-03. Sin ejecutar el programa: ¿El método estaActiva
 * retorna true o false?
 * ¿Qué valor exacto retorna calcularDiasRestantesOTranscurridos?
 * Para:
 * 
 * check-in: 2025-05-01
 * check-out: 2025-05-05
 * consulta: 2025-05-03
 * 
 * estaActiva() devuelve:
 * 
 * true
 * 
 * y calcularDiasRestantesOTranscurridos() devuelve:
 * 
 * 0
 * 
 * porque la fecha está dentro de la estadía.
 * 
 * d) Un compañero escribe el método simularProrroga de la siguiente manera:
 * return this.fechaCheckOut.plusDays(cantidadDias);
 * ¿Esta línea constituye un error de lógica respecto al principio de
 * encapsulamiento o inmutabilidad?
 * ¿Modifica el estado real del objeto o solo devuelve un cálculo? Argumente si
 * esto cumple con lo
 * solicitado en el inciso (h).
 * Esta línea:
 * 
 * return this.fechaCheckOut.plusDays(cantidadDias);
 * 
 * no modifica la fecha almacenada en el objeto. LocalDate es inmutable, por lo
 * que devuelve una nueva fecha. Esto cumple con lo solicitado porque
 * simularProrroga() solamente debe calcular y retornar la nueva fecha.
 * 
 */
