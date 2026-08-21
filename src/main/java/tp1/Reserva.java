package tp1;

// Clase que representa una reserva de hotel.

// Importamos LocalDate para trabajar con fechas.
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Enunciado:
 *
 * Crear una clase Reserva con:
 *
 * - codigoReserva
 * - nombreHuesped
 * - fechaCheckIn
 * - fechaCheckOut
 *
 * La fecha de check-in debe ser anterior al check-out.
 */

public class Reserva {

    // Atributos privados.
    private String codigoReserva;
    private String nombreHuesped;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;

    // Constructor predeterminado.
    public Reserva() {

        this.codigoReserva = "000";
        this.nombreHuesped = "Por confirmar";

        // La fecha actual se obtiene con LocalDate.now().
        this.fechaCheckIn = LocalDate.now();

        // El check-out es un dia despues.
        this.fechaCheckOut = LocalDate.now().plusDays(1);
    }

    // Constructor parametrizado.
    public Reserva(
            String codigoReserva,
            String nombreHuesped,
            LocalDate fechaCheckIn,
            LocalDate fechaCheckOut) {

        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;

        // Validamos las fechas.
        validarFechas();
    }

    // Metodo auxiliar para validar las fechas.
    private void validarFechas() {

        // El check-in debe ser estrictamente anterior
        // al check-out.
        if (!this.fechaCheckIn.isBefore(this.fechaCheckOut)) {

            System.out.println(
                    "Las fechas ingresadas no son validas.");

            // Si son invalidas, se utilizan
            // las fechas indicadas por el enunciado.
            this.fechaCheckIn = LocalDate.now();

            this.fechaCheckOut = this.fechaCheckIn.plusDays(1);
        }
    }

    // Metodo que determina si la reserva esta activa.
    public boolean estaActiva(LocalDate fechaConsulta) {

        // La fecha debe ser igual o posterior al check-in
        // y estrictamente anterior al check-out.
        return !fechaConsulta.isBefore(this.fechaCheckIn)
                && fechaConsulta.isBefore(this.fechaCheckOut);
    }

    // Metodo que calcula dias restantes o transcurridos.
    public long calcularDiasRestantesOTranscurridos(
            LocalDate fechaConsulta) {

        // Si la fecha de consulta es anterior al check-in,
        // devolvemos los dias que faltan.
        if (fechaConsulta.isBefore(this.fechaCheckIn)) {

            return ChronoUnit.DAYS.between(
                    fechaConsulta,
                    this.fechaCheckIn);
        }

        // Si esta dentro de la estadia, devuelve 0.
        if (estaActiva(fechaConsulta)) {
            return 0;
        }

        // Si es posterior al check-out, devuelve
        // un valor negativo.
        return -ChronoUnit.DAYS.between(
                this.fechaCheckOut,
                fechaConsulta);
    }

    // Metodo que simula una prorroga.
    // No modifica la reserva.
    public LocalDate simularProrroga(int cantidadDias) {

        return this.fechaCheckOut.plusDays(cantidadDias);
    }

    // Metodo toString().
    @Override
    public String toString() {

        return "Codigo de reserva: " + codigoReserva
                + "\nHuesped: " + nombreHuesped
                + "\nCheck-in: " + fechaCheckIn
                + "\nCheck-out: " + fechaCheckOut;
    }

    public static void main(String[] argv) {
        System.out.println("AAA");
    }

}
