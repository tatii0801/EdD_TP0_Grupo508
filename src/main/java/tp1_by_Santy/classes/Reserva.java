package tp1_by_Santy.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
    
    private String codigoReserva;
    private String nombreHuesped;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;

    // Formateador estándar para mostrar las fechas en formato dd/MM/yyyy
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // b) Constructor predeterminado
    public Reserva() {
        this.codigoReserva = "000";
        this.nombreHuesped = "Por confirmar";
        this.fechaCheckIn = LocalDate.now();
        this.fechaCheckOut = LocalDate.now().plusDays(1);
    }

    // c) Constructor parametrizado
    public Reserva(String codigoReserva, String nombreHuesped, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        validarFechas(); // e) Se verifica y ajusta en caso de que sean inválidas
    }

    // Getters y Setters
    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
        validarFechas();
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
        validarFechas();
    }

    // e) Método auxiliar para validar fechas
    private void validarFechas() {
        if (this.fechaCheckIn == null || this.fechaCheckOut == null || !this.fechaCheckIn.isBefore(this.fechaCheckOut)) {
            System.out.println("⚠️ ADVERTENCIA: La fecha de check-in debe ser estrictamente anterior al check-out.");
            System.out.println("   Ajustando automáticamente: Check-In = HOY, Check-Out = MAÑANA.");
            this.fechaCheckIn = LocalDate.now();
            this.fechaCheckOut = LocalDate.now().plusDays(1);
        }
    }

    // f) Método estaActiva
    public boolean estaActiva(LocalDate fechaConsulta) {
        return (fechaConsulta.isEqual(fechaCheckIn) || fechaConsulta.isAfter(fechaCheckIn))
                && fechaConsulta.isBefore(fechaCheckOut);
    }

    // g) Método calcularDiasRestantesOTranscurridos
    public long calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta) {
        if (fechaConsulta.isBefore(fechaCheckIn)) {
            // Días faltantes (positivo)
            return ChronoUnit.DAYS.between(fechaConsulta, fechaCheckIn);
        } else if (estaActiva(fechaConsulta)) {
            // Dentro de la estadía
            return 0;
        } else {
            // Posterior al check-out: días transcurridos (negativo)
            return -ChronoUnit.DAYS.between(fechaCheckOut, fechaConsulta);
        }
    }

    // h) Método simularProrroga
    public LocalDate simularProrroga(int cantidadDias) {
        return this.fechaCheckOut.plusDays(cantidadDias);
    }

    // d) Método toString
    @Override
    public String toString() {
        return String.format("Reserva [%s] | Huésped: %s | Check-In: %s | Check-Out: %s",
                codigoReserva,
                nombreHuesped,
                fechaCheckIn.format(FORMATO_FECHA),
                fechaCheckOut.format(FORMATO_FECHA));
    }
}