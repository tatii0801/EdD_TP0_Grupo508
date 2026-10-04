package tp5.ejercicio4;

/*
 * EJERCICIO 4 - LISTA
 *
 * Consigna:
 * Crear la clase Tarea con:
 * - idTarea
 * - titulo
 * - responsable
 * - fechaLimite
 * - completada
 */

import java.time.LocalDate;

public class Tarea {

    private int idTarea;
    private String titulo;
    private String responsable;
    private LocalDate fechaLimite;
    private boolean completada;

    public Tarea(int idTarea, String titulo, String responsable,
            LocalDate fechaLimite, boolean completada) {

        this.idTarea = idTarea;
        this.titulo = titulo;
        this.responsable = responsable;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {

        return "ID: " + idTarea +
                " | Titulo: " + titulo +
                " | Responsable: " + responsable +
                " | Fecha limite: " + fechaLimite +
                " | Completada: " + completada;
    }
}
