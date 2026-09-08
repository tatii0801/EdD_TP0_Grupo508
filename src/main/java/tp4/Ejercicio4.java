package tp4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // Creamos la cola vacía donde guardaremos los tickets
        Queue<Ticket> colaOriginal = new LinkedList<>();

        // --- ENCABEZADO VISUAL ---
        System.out.println("\n=========================================");
        System.out.println(" GESTIÓN DE TICKETS DE SOPORTE TÉCNICO");
        System.out.println("=========================================");
        
        // ==========================================
        // PASO 1: CARGA Y VALIDACIÓN DE DATOS
        // ==========================================
        
        // Validamos que se carguen al menos 5 tickets
        int cantidad;
        do {
            System.out.print("\n¿Cuántos tickets vas a ingresar? (Mínimo 5): ");
            cantidad = entrada.nextInt();
            
            if (cantidad < 5) {
                System.out.println("-> Error: C4argar al menos 5 tickets. Intentá de nuevo.");
            }
        } while (cantidad < 5);

        // Bucle para pedir los datos de cada ticket
        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\n--- Ingresando el ticket #" + i + " ---");
            
            System.out.print("ID del ticket (número): ");
            int id = entrada.nextInt();
            entrada.nextLine(); // Limpiamos el "Enter" fantasma del teclado
            
            // Validamos que el departamento no se quede vacío
            String depto;
            do {
                System.out.print("Departamento (Ej: Redes, Software, Hardware): ");
                depto = entrada.nextLine();
                
                if (depto.trim().isEmpty()) {
                    System.out.println("-> Error: El departamento no puede estar vacío.");
                }
            } while (depto.trim().isEmpty());
            
            // Validamos que la urgencia esté si o si entre 1 y 5[cite: 1]
            int urgencia;
            do {
                System.out.print("Nivel de urgencia (1 al 5): ");
                urgencia = entrada.nextInt();
                
                if (urgencia < 1 || urgencia > 5) {
                    System.out.println("-> Error: La urgencia debe ser un número entre 1 y 5.");
                }
            } while (urgencia < 1 || urgencia > 5);
            
            // Fabricamos el ticket con nuestro molde y lo agregamos al final de la cola
            Ticket nuevoTicket = new Ticket(id, depto, urgencia);
            colaOriginal.add(nuevoTicket);
        }

        System.out.println("\n¡Se cargaron " + cantidad + " tickets en la cola exitosamente!");

        // ==========================================
        // PASO 2: ANÁLISIS Y FILTRADO DE LA COLA
        // ==========================================
        
        entrada.nextLine(); // Limpiamos el último "Enter" sobrante
        
        System.out.println("\n=========================================");
        System.out.println("      ANÁLISIS Y FILTRADO DE TICKETS     ");
        System.out.println("=========================================");
        
        System.out.print("Ingrese el departamento a filtrar (Ej: Redes): ");
        String deptoFiltro = entrada.nextLine();

        // Variables auxiliares para resolver los puntos del TP
        Queue<Ticket> colaFiltrada = new LinkedList<>(); // Para el Inciso A
        double sumaUrgencias = 0;                        // Para calcular el promedio (Inciso B)
        Ticket primerCritico = null;                     // Para guardar el primer nivel 5 (Inciso C)
        int contadorUrgentes = 0;                        // Para medir el arreglo del (Inciso D)
        int tamañoOriginal = colaOriginal.size();        // Guardamos el tamaño fijo de la fila

        System.out.println("\nProcesando... (recorriendo la fila)...");

        // RECORRIDO 1: Atendemos a todos, hacemos los cálculos y los devolvemos al fondo
        for (int i = 0; i < tamañoOriginal; i++) {
            Ticket actual = colaOriginal.poll(); // Sacamos al primero de la fila

            // Inciso A: Si coincide el departamento, lo guardamos en la nueva cola
            if (actual.getDepartamento().equalsIgnoreCase(deptoFiltro)) {
                colaFiltrada.add(actual);
            }

            // Inciso B: Sumamos los niveles de urgencia[cite: 1]
            sumaUrgencias += actual.getNivelUrgencia();

            // Inciso C: Guardamos el primer ticket de nivel 5 que encontremos
            if (actual.getNivelUrgencia() == 5 && primerCritico == null) {
                primerCritico = actual;
            }

            // Inciso D (Parte 1): Contamos cuántos son de urgencia 4 o 5
            if (actual.getNivelUrgencia() >= 4) {
                contadorUrgentes++;
            }

            // REGLA DE ORO: Devolvemos el ticket al final de la fila original
            colaOriginal.add(actual);
        }

        // Inciso D (Parte 2): Creamos el arreglo con el tamaño exacto y lo llenamos en otra pasada
        int[] arregloUrgentes = new int[contadorUrgentes];
        int indice = 0;
        
        for (int i = 0; i < tamañoOriginal; i++) {
            Ticket actual = colaOriginal.poll();
            
            if (actual.getNivelUrgencia() >= 4) {
                arregloUrgentes[indice] = actual.getIdTicket();
                indice++;
            }
            
            colaOriginal.add(actual); // Lo devolvemos al fondo otra vez
        }

        // ==========================================
        // PASO 3: MOSTRAR RESULTADOS FINALES
        // ==========================================
        
        System.out.println("\n-----------------------------------------");
        System.out.println("           RESULTADOS FINALES            ");
        System.out.println("-----------------------------------------");
        
        // Inciso A
        System.out.println("A) Tickets de " + deptoFiltro + ": " + colaFiltrada);
        
        // Inciso B
        System.out.println("B) Promedio de urgencia total: " + (sumaUrgencias / tamañoOriginal));
        
        // Inciso C
        if (primerCritico != null) {
            System.out.println("C) Primer ticket crítico: " + primerCritico.toString());
        } else {
            System.out.println("C) No hay tickets de nivel 5.");
        }
        
        // Inciso D
        System.out.print("D) IDs de tickets urgentes (Nivel 4 o 5): [ ");
        for (int idUrgente : arregloUrgentes) {
            System.out.print(idUrgente + " ");
        }
        System.out.println("]");
        
        // --- MENSAJE DE CIERRE ---
        System.out.println("\n=========================================");
        System.out.println("   Proceso terminado con éxito. ¡Gracias!  ");
        System.out.println("=========================================");
        System.out.println("\n");

        entrada.close(); // Cerramos el uso del teclado
    } // Cierramos el main
} // Cierramos la clase