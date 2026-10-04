package tp5.ejercicio4;

/*
 * EJERCICIO 4 - LISTA
 *
 * Programa principal para probar GestorTareas.
 */

import java.time.LocalDate;
import java.util.Scanner;

import tp5.Base_Profesor.SimpleLinkedList;

public class Principal4 {

    public static void mostrarLista(
            SimpleLinkedList<Tarea> lista) {

        if (lista.size() == 0) {
            System.out.println("No hay tareas.");
            return;
        }

        for (Tarea tarea : lista) {
            System.out.println(tarea);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestorTareas gestor = new GestorTareas();

        // ==========================
        // CARGA DE TAREAS
        // ==========================

        gestor.agregarTarea(
                new Tarea(
                        1,
                        "TP de Java",
                        "Tatiana",
                        LocalDate.of(2026, 10, 10),
                        false));

        gestor.agregarTarea(
                new Tarea(
                        2,
                        "Parcial",
                        "Juan",
                        LocalDate.of(2026, 10, 15),
                        false));

        gestor.agregarTarea(
                new Tarea(
                        3,
                        "Trabajo Practico",
                        "Tatiana",
                        LocalDate.of(2026, 11, 5),
                        false));

        gestor.agregarTarea(
                new Tarea(
                        4,
                        "Informe",
                        "Maria",
                        LocalDate.of(2026, 9, 20),
                        true));

        gestor.agregarTarea(
                new Tarea(
                        5,
                        "Presentacion",
                        "Tatiana",
                        LocalDate.of(2026, 12, 1),
                        false));

        System.out.println("===== TAREAS INICIALES =====");
        mostrarLista(gestor.getTareas());

        // ==========================
        // COMPLETAR TAREA
        // ==========================

        System.out.print("\nIngrese ID de tarea a completar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (gestor.completarTarea(id)) {
            System.out.println("Tarea completada.");
        } else {
            System.out.println("No existe una tarea con ese ID.");
        }

        System.out.println("\n===== TAREAS =====");
        mostrarLista(gestor.getTareas());

        // ==========================
        // TAREAS POR RESPONSABLE
        // ==========================

        System.out.print("\nIngrese responsable: ");
        String responsable = scanner.nextLine();

        System.out.println("\n===== TAREAS DEL RESPONSABLE =====");

        mostrarLista(
                gestor.tareasPorResponsable(responsable));

        // ==========================
        // TAREAS PENDIENTES
        // ==========================

        System.out.println("\n===== TAREAS PENDIENTES =====");

        mostrarLista(
                gestor.tareasPendientes());

        // ==========================
        // TAREAS PROXIMAS
        // ==========================

        System.out.print(
                "\nIngrese responsable para tareas proximas: ");

        responsable = scanner.nextLine();

        System.out.println("\n===== TAREAS PROXIMAS =====");

        mostrarLista(
                gestor.tareasProximas(responsable));

        // ==========================
        // ELIMINAR TAREA
        // ==========================

        System.out.print("\nIngrese ID de tarea a eliminar: ");

        id = scanner.nextInt();

        if (gestor.eliminarTarea(id)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("No existe una tarea con ese ID.");
        }

        System.out.println("\n===== TAREAS FINALES =====");

        mostrarLista(gestor.getTareas());

        scanner.close();
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) ¿Por que necesitamos el nodo anterior para eliminar
 * en una lista simplemente enlazada?
 *
 * Respuesta:
 * Porque cada nodo solamente conoce al siguiente.
 * Para eliminar un nodo del medio necesitamos modificar
 * el enlace del nodo anterior para que apunte al siguiente.
 *
 *
 * b) ¿Que hacemos si el ID no existe?
 *
 * Respuesta:
 * Se devuelve false y se informa al usuario que no existe
 * una tarea con ese ID.
 *
 *
 * c) ¿Es mejor modificar la lista original eliminando
 * las tareas completadas o crear una nueva lista?
 *
 * Respuesta:
 * Es mejor crear una nueva lista.
 * De esta forma no destruimos los datos de la lista original.
 *
 *
 * d) ¿Es correcto hacer:
 *
 * nodo.getValor().setCompletada(true)
 *
 * mientras recorremos la lista?
 *
 * Respuesta:
 * Si, siempre que el elemento sea un objeto mutable.
 * En este caso Tarea tiene el método setCompletada(),
 * por lo que podemos modificar ese objeto.
 */
