package tp3.ejercicio4;

public class Tarea {
    private String idTarea;
    private String prioridad; // "Alta", "Media", "Baja"
    private String descripcion;

    // Constructor para iniciar la tarea
    public Tarea(String idTarea, String prioridad, String descripcion) {
        this.idTarea = idTarea;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método toString para imprimir prolijo por pantalla
    @Override
    public String toString() {
        return "[ID: " + idTarea + " | Prioridad: " + prioridad + " | Desc: " + descripcion + "]";
    }
}