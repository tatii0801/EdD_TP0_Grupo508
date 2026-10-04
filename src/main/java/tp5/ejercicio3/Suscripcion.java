package tp5.ejercicio3;

/*
 * EJERCICIO 3 - LISTA
 *
 * Consigna:
 * Crear la clase Suscripcion con:
 * - idSuscripcion
 * - usuario
 * - plan
 * - fechaInicio
 */

import java.time.LocalDate;

public class Suscripcion {

    private int idSuscripcion;
    private String usuario;
    private String plan;
    private LocalDate fechaInicio;

    public Suscripcion(int idSuscripcion, String usuario, String plan, LocalDate fechaInicio) {
        this.idSuscripcion = idSuscripcion;
        this.usuario = usuario;
        this.plan = plan;
        this.fechaInicio = fechaInicio;
    }

    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public String toString() {
        return "ID: " + idSuscripcion +
                " | Usuario: " + usuario +
                " | Plan: " + plan +
                " | Fecha: " + fechaInicio;
    }
}
