package tp5.ejercicio4;

/*
 * EJERCICIO 4
 *
 * Gestor de tareas utilizando SimpleLinkedList.
 */

import java.time.LocalDate;

import tp5.Base_Profesor.SimpleLinkedList;

public class GestorTareas {

    private SimpleLinkedList<Tarea> tareas;

    public GestorTareas() {
        tareas = new SimpleLinkedList<>();
    }

    /*
     * Punto A
     *
     * Agrega una tarea al final.
     */
    public void agregarTarea(Tarea tarea) {
        tareas.addLast(tarea);
    }

    /*
     * Punto B
     *
     * Busca una tarea por ID y la marca como completada.
     */
    public boolean completarTarea(int id) {

        for (Tarea tarea : tareas) {

            if (tarea.getIdTarea() == id) {

                tarea.setCompletada(true);
                return true;
            }
        }

        return false;
    }

    /*
     * Punto C
     *
     * Devuelve una nueva lista con las tareas
     * de un determinado responsable.
     */
    public SimpleLinkedList<Tarea> tareasPorResponsable(
            String responsable) {

        SimpleLinkedList<Tarea> resultado = new SimpleLinkedList<>();

        for (Tarea tarea : tareas) {

            if (tarea.getResponsable()
                    .equalsIgnoreCase(responsable)) {

                resultado.addLast(tarea);
            }
        }

        return resultado;
    }

    /*
     * Punto D
     *
     * Devuelve una nueva lista solamente con
     * las tareas pendientes.
     */
    public SimpleLinkedList<Tarea> tareasPendientes() {

        SimpleLinkedList<Tarea> resultado = new SimpleLinkedList<>();

        for (Tarea tarea : tareas) {

            if (!tarea.isCompletada()) {
                resultado.addLast(tarea);
            }
        }

        return resultado;
    }

    /*
     * Punto E
     *
     * Elimina una tarea por ID.
     */
    public boolean eliminarTarea(int id) {

        SimpleLinkedList<Tarea> auxiliar = new SimpleLinkedList<>();

        boolean eliminada = false;

        while (tareas.size() > 0) {

            Tarea tarea = tareas.removeFirst();

            if (tarea.getIdTarea() == id) {
                eliminada = true;
                break;
            }

            auxiliar.addLast(tarea);
        }

        // Restauramos las tareas que no fueron eliminadas.
        while (auxiliar.size() > 0) {
            tareas.addLast(auxiliar.removeFirst());
        }

        return eliminada;
    }

    /*
     * Punto F
     *
     * Devuelve las tareas futuras de un responsable.
     */
    public SimpleLinkedList<Tarea> tareasProximas(
            String responsable) {

        SimpleLinkedList<Tarea> resultado = new SimpleLinkedList<>();

        LocalDate hoy = LocalDate.now();

        for (Tarea tarea : tareas) {

            if (tarea.getResponsable()
                    .equalsIgnoreCase(responsable)
                    &&
                    tarea.getFechaLimite().isAfter(hoy)) {

                resultado.addLast(tarea);
            }
        }

        return resultado;
    }

    /*
     * Devuelve todas las tareas.
     */
    public SimpleLinkedList<Tarea> getTareas() {
        return tareas;
    }
}
