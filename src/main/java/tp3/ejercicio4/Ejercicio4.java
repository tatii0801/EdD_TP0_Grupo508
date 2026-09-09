package tp3.ejercicio4;

import java.util.Stack;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creamos nuestra pila principal de tareas
        Stack<Tarea> pilaTareas = new Stack<>(); // Stack ahhhh!

        System.out.println("\n=================================================");
        System.out.println("   Ejercicio N°4 - Gestión de Tareas con Pilas");
        System.out.println("=================================================");

        // e) Cargamos la pila con al menos 5 tareas iniciales de diferentes prioridades
        pilaTareas.push(new Tarea("T01", "Baja", "Limpiar y organizar el escritorio"));
        pilaTareas.push(new Tarea("T02", "Alta", "Corregir errores de red en el laboratorio"));
        pilaTareas.push(new Tarea("T03", "Media", "Actualizar la documentación del proyecto"));
        pilaTareas.push(new Tarea("T04", "Alta", "Revisar la seguridad de los servidores"));
        pilaTareas.push(new Tarea("T05", "Baja", "Comprar insumos de librería"));

        // f) Mostramos el estado inicial de la pila
        System.out.println("\n--- ESTADO INICIAL DE LA PILA DE TAREAS ---");
        mostrarPila(pilaTareas);

        // --- Opcion: Ingreso de Nueva Tarea ---
        System.out.print("\n¿Desea agregar una nueva tarea a la pila? (s/n): ");
        String respuesta = scanner.nextLine().trim();
        
        if (respuesta.equalsIgnoreCase("s")) {
            // 1. Validación para el ID (no puede estar vacío)
            String idUsuario = "";
            while (idUsuario.isEmpty()) {
                System.out.print("Ingrese el ID de la nueva tarea (Ej: T06): ");
                idUsuario = scanner.nextLine().trim();
                if (idUsuario.isEmpty()) {
                    System.out.println("❌ El ID no puede estar vacío. Intente nuevamente.");
                }
            }
            
            // 2. Validación para la Prioridad (insiste hasta que sea Alta, Media o Baja)
            String prioridadUsuario = "";
            while (!prioridadUsuario.equalsIgnoreCase("Alta") && 
                   !prioridadUsuario.equalsIgnoreCase("Media") && 
                   !prioridadUsuario.equalsIgnoreCase("Baja")) {
                System.out.print("Ingrese la prioridad (Alta, Media, Baja): ");
                prioridadUsuario = scanner.nextLine().trim();
                if (!prioridadUsuario.equalsIgnoreCase("Alta") && 
                    !prioridadUsuario.equalsIgnoreCase("Media") && 
                    !prioridadUsuario.equalsIgnoreCase("Baja")) {
                    System.out.println("❌ Prioridad inválida. Debe escribir exactamente: Alta, Media o Baja.");
                }
            }
            
            // 3. Validación para la Descripción (no puede estar vacía)
            String descUsuario = "";
            while (descUsuario.isEmpty()) {
                System.out.print("Ingrese la descripción de la tarea: ");
                descUsuario = scanner.nextLine().trim();
                if (descUsuario.isEmpty()) {
                    System.out.println("❌ La descripción no puede estar vacía.");
                }
            }
            
            // Agregamos la tarea validada a la pila
            agregarTarea(pilaTareas, new Tarea(idUsuario, prioridadUsuario, descUsuario));
            
            System.out.println("\n--- ESTADO DE LA PILA TRAS AGREGAR LA NUEVA TAREA ---");
            mostrarPila(pilaTareas);
        }

        // g) Ejecutamos los métodos solicitados por la consigna:

        // 1. Contar cuántas tareas de prioridad "Alta" hay
        int totalAltas = contarTareasAlta(pilaTareas);
        System.out.println("\n[Resultado] Cantidad de tareas con prioridad 'Alta': " + totalAltas);

        // 2. Buscar una tarea por su ID con bucle de validación (insiste hasta que escribas uno válido)
        Tarea tareaEncontrada = null;
        while (tareaEncontrada == null) {
            System.out.print("\nIngrese el ID de la tarea a buscar (Ej: T02): ");
            String idBuscado = scanner.nextLine().trim();
            
            tareaEncontrada = buscarTareaPorId(pilaTareas, idBuscado);
            
            if (tareaEncontrada != null) {
                System.out.println("¡Tarea encontrada! -> " + tareaEncontrada);
            } else {
                System.out.println("❌ No se encontró ninguna tarea con el ID: " + idBuscado + ". Intente nuevamente.");
            }
        }

        // 3. Eliminar tareas por prioridad (ej: eliminar las de prioridad "Baja")
        System.out.print("\nIngrese una prioridad para eliminar (Alta, Media, Baja): ");
        String prioridadAEliminar = scanner.nextLine().trim();
        
        eliminarTareasPorPrioridad(pilaTareas, prioridadAEliminar);
        
        // Mostramos el estado final para verificar que el resto conservó su orden intacto
        System.out.println("\n--- ESTADO DE LA PILA DESPUÉS DE ELIMINAR ---");
        mostrarPila(pilaTareas);

        System.out.println("\n=================================================");
        System.out.println("   ¡Programa finalizado con éxito!               ");
        System.out.println("=================================================");
        
        scanner.close();
    }

    // =================================================================
    // MÉTODOS REQUERIDOS PARA LA PILA DE TAREAS
    // =================================================================

    // a) Método para agregar una tarea a la pila
    public static void agregarTarea(Stack<Tarea> pila, Tarea nuevaTarea) {
        pila.push(nuevaTarea);
    }

    // d) Contar cuántas tareas tienen prioridad "Alta" (respetando la pila original)
    public static int contarTareasAlta(Stack<Tarea> pila) {
        Stack<Tarea> aux1 = new Stack<>();
        Stack<Tarea> aux2 = new Stack<>();
        int contador = 0;

        // Pasamos todo a aux1 (se invierte) y contamos las "Alta"
        while (!pila.isEmpty()) {
            Tarea t = pila.pop();
            if (t.getPrioridad().equalsIgnoreCase("Alta")) {
                contador++;
            }
            aux1.push(t);
        }

        // Devolvemos el orden original usando aux2
        while (!aux1.isEmpty()) {
            aux2.push(aux1.pop());
        }
        while (!aux2.isEmpty()) {
            pila.push(aux2.pop());
        }

        return contador;
    }

    // c) Buscar tarea por ID sin modificar la pila original
    public static Tarea buscarTareaPorId(Stack<Tarea> pila, String idBuscado) {
        Stack<Tarea> aux1 = new Stack<>();
        Stack<Tarea> aux2 = new Stack<>();
        Tarea encontrada = null;

        while (!pila.isEmpty()) {
            Tarea t = pila.pop();
            if (t.getIdTarea().equalsIgnoreCase(idBuscado)) {
                encontrada = t;
            }
            aux1.push(t);
        }

        // Restauramos el orden original de la pila
        while (!aux1.isEmpty()) {
            aux2.push(aux1.pop());
        }
        while (!aux2.isEmpty()) {
            pila.push(aux2.pop());
        }

        return encontrada;
    }

    // b) Eliminar tareas por prioridad sin alterar el orden del resto
    public static void eliminarTareasPorPrioridad(Stack<Tarea> pila, String prioridadEliminar) {
        Stack<Tarea> aux1 = new Stack<>();
        Stack<Tarea> aux2 = new Stack<>();

        // Filtramos dejando afuera las que coinciden con la prioridad a eliminar
        while (!pila.isEmpty()) {
            Tarea t = pila.pop();
            if (!t.getPrioridad().equalsIgnoreCase(prioridadEliminar)) {
                aux1.push(t);
            }
        }

        // Restauramos el orden original en aux2 y devolvemos a la pila principal
        while (!aux1.isEmpty()) {
            aux2.push(aux1.pop());
        }
        while (!aux2.isEmpty()) {
            pila.push(aux2.pop());
        }
    }

    // Método auxiliar para mostrar la pila prolijamente por consola
    public static void mostrarPila(Stack<Tarea> pila) {
        if (pila.isEmpty()) {
            System.out.println("  (La pila está vacía)");
            return;
        }
        
        Stack<Tarea> copiaTemp = new Stack<>();
        copiaTemp.addAll(pila);
        
        while (!copiaTemp.isEmpty()) {
            System.out.println("  -> " + copiaTemp.pop());
        }
    }
/* ====================================================================
     * RESPUESTAS A LAS PREGUNTAS SOBRE EL PROBLEMA:
     * 
     * a) ¿Se garantiza el orden al usar pilas auxiliares?
     *    - Sí. Se produce un "doble reverso" que restituye el orden original.
     *    -> Se ve reflejado en los métodos como buscarTareaPorId() y contarTareasAlta(),
     *       en los bucles finales donde se pasan los elementos de aux2 a la original.
     * 
     * b) Ventajas y desventajas de usar un ArrayList:
     *    - Ventaja: Permite buscar fácilmente mediante índices (.get()).
     *    - Desventaja: Rompe con el principio estricto del TDA Pila (LIFO).
     * 
     * c) ¿Qué pasa al eliminar prioridades inexistentes o vacías?
     *    - Si la prioridad no existe: La pila queda exactamente igual.
     *    - Si todas coinciden: La pila queda completamente vacía.
     *    -> Se ve reflejado en el método eliminarTareasPorPrioridad().
     * 
     * d) ¿Es un error el doble pop() del compañero?
     *    - Sí. Hacer un pop() en el if y otro adentro hace que se descarten 
     *      dos elementos por vuelta sin evaluar uno de ellos, perdiendo datos.
     *    -> Se contrasta con nuestro método eliminarTareasPorPrioridad(), 
     *       donde usamos un único pop() por ciclo para evaluar de forma segura.
     * ==================================================================== */
}