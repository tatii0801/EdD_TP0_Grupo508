package tp1_by_Santy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import tp1_by_Santy.classes.Reserva;

/**
 * 3) Desarrollar un programa que simule la gestión de una reserva de hotel con
 * fecha de check-in y fecha de
 * check-out, incorporando funcionalidades de verificación y modificación.
 * El programa debe incluir:
 * a) Una Clase Reserva con los atributos: codigoReserva (String único),
 * nombreHuesped, fechaCheckIn y
 * fechaCheckOut.
 * b) Constructor predeterminado que inicializa codigoReserva en "000",
 * nombreHuesped en "Por
 * confirmar", fechaCheckIn con la fecha actual y fechaCheckOut igual a un día
 * después de la fecha actual.
 * c) Constructor parametrizado que permite establecer todos los atributos
 * mediante argumentos.
 * d) Método toString() para retornar una representación textual completa y
 * legible del objeto Reserva.
 * e) Método auxiliar para validar fechas que comprueba si las fechas de
 * check-in y check-out son válidas (la
 * fecha de check-in debe ser estrictamente anterior a la fecha de check-out).
 * Si las fechas no son válidas,
 * se ajustan automáticamente asignando la fecha actual al check-in y el día
 * siguiente al check-out.
 * f) Un método estaActiva(LocalDate fechaConsulta) para determinar si la
 * reserva está vigente en una fecha
 * dada por el usuario. Debe retornar true si la fechaConsulta es igual o
 * posterior a fechaCheckIn y
 * estrictamente anterior a fechaCheckOut. De lo contrario, retorna false.
 * g) Método calcularDiasRestantesOTranscurridos(LocalDate fechaConsulta). Si la
 * fecha de consulta es
 * anterior al check-in, debe retornar un valor positivo que represente los días
 * faltantes para el check-in. Si
 * la fecha de consulta está dentro de la estadía, retornar 0. Si la fecha de
 * consulta es posterior al
 * check-out, debe retornar un valor negativo que represente los días que han
 * transcurrido desde el
 * check-out hasta la fechaConsulta.
 * h) Método simularProrroga(int cantidadDias) que calcula y retorna la nueva
 * fecha de check-out si la
 * estadía se extendiera por una cantidad específica de días a partir de la
 * fecha de check-out actual.
 * En el programa principal (main) se debe:
 * i) Solicitar al usuario los datos para crear al menos dos objetos Reserva
 * diferentes, por ejemplo: una
 * reserva futura y una reserva ya finalizada. Se deben realizar las
 * validaciones correspondientes.
 * j) Después de crear las reservas, el programa debe solicitar al usuario una
 * "fecha de consulta" (día, mes,
 * año) para verificar el estado de las mismas. Esta fecha también debe ser
 * validada.
 * Para cada objeto Reserva creado, el programa debe:
 * k) Mostrar sus detalles utilizando el método toString().
 * l) Llamar al método estaActiva() pasándole la "fecha de consulta" y mostrar
 * el resultado.
 * m) Llamar al método calcularDiasRestantesOTranscurridos() pasándole la misma
 * "fecha de consulta" y
 * mostrar la cantidad de días.
 * n) Solicitar al usuario una cantidad de días para simular una prórroga,
 * llamar al método simularProrroga()
 * y mostrar la nueva fecha de check-out calculada.
 * 
 * 
 * Indicaciones:
 * Este ejercicio necesita del objeto scanner para ingresar datos por la consola
 * o teclado, se espera que el
 * código controle los problemas que normalmente ocurren al operar con la
 * consola o teclado.
 * Se espera una correcta modularización entre el código que realiza el ingreso
 * y validación de los datos
 * respecto del código que hace lo que se solicita en el ejercicio.
 * 
 * 
 * Preguntas sobre el problema
 * a) ¿Por qué se pide que la validación de fechas sea un "método auxiliar"
 * dentro de la clase Reserva? ¿Qué
 * ocurriría si esa validación se hiciera en el método main antes de llamar al
 * constructor?
 * b) ¿Qué sucede si el usuario ingresa la misma fecha para check-in y
 * check-out? Según la regla del inciso (e)
 * ¿qué debería ocurrir con el objeto?
 * c) Si una reserva tiene fechaCheckIn = 2025-05-01 y fechaCheckOut =
 * 2025-05-05, y el usuario ingresa
 * fechaConsulta = 2025-05-03. Sin ejecutar el programa: ¿El método estaActiva
 * retorna true o false?
 * ¿Qué valor exacto retorna calcularDiasRestantesOTranscurridos?
 * d) Un compañero escribe el método simularProrroga de la siguiente manera:
 * return this.fechaCheckOut.plusDays(cantidadDias);
 * ¿Esta línea constituye un error de lógica respecto al principio de
 * encapsulamiento o inmutabilidad?
 * ¿Modifica el estado real del objeto o solo devuelve un cálculo? Argumente si
 * esto cumple con lo
 * solicitado en el inciso (h).
 * 
 * respuestas:
 * 
 * a) La validación de fechas se pide como un "método auxiliar" dentro de la clase 
 * Reserva para garantizar que cualquier instancia de Reserva creada tenga fechas válidas, 
 * independientemente de dónde o cómo se cree. Si la validación se hiciera en el método main antes 
 * de llamar al constructor, se correría el riesgo de que otras partes del código que creen reservas 
 * no realicen la validación, lo que podría llevar a inconsistencias y errores en el estado del objeto.
 * 
 * b) Si el usuario ingresa la misma fecha para check-in y check-out, según la regla del inciso (e),
 * el objeto debería ajustarse automáticamente, asignando la fecha actual al check-in y el día siguiente al
 * check-out, ya que la fecha de check-in debe ser estrictamente anterior a la fecha de check-out.
 * 
 * c) Si una reserva tiene fechaCheckIn = 2025-05-01 y fechaCheckOut = 2025-05-05, y el usuario ingresa 
 * fechaConsulta = 2025-05-03, el método estaActiva retornará true, ya que la fecha de consulta está dentro 
 * del rango de la estadía. El método calcularDiasRestantesOTranscurridos retornará 0, indicando que la fecha 
 * de consulta está dentro de la estadía.
 * 
 * d) La línea return this.fechaCheckOut.plusDays(cantidadDias); no constituye un error de lógica respecto al 
 * principio de encapsulamiento o inmutabilidad. Esta línea no modifica el estado real del objeto, sino que 
 * devuelve un nuevo valor calculado basado en la fecha de check-out actual. Esto cumple con lo solicitado en el 
 * inciso (h), ya que se espera que el método simule una prórroga y devuelva la nueva fecha de check-out sin alterar 
 * el estado interno del objeto Reserva.
 */

public class ejercicio3 {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("    SISTEMA DE GESTIÓN DE RESERVAS DE HOTEL   ");
        System.out.println("==============================================\n");

        // i) Crear al menos dos reservas
        Reserva[] reservas = new Reserva[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("--- Ingreso de datos para la Reserva #" + (i + 1) + " ---");
            String codigo = leerTextoNoVacio(scanner, "Ingrese el código de reserva: ");
            String huesped = leerTextoNoVacio(scanner, "Ingrese el nombre del huésped: ");

            System.out.println("FECHA DE CHECK-IN:");
            LocalDate checkIn = leerFechaValida(scanner);

            System.out.println("FECHA DE CHECK-OUT:");
            LocalDate checkOut = leerFechaValida(scanner);

            reservas[i] = new Reserva(codigo, huesped, checkIn, checkOut);
            System.out.println();
        }

        // j) Solicitar fecha de consulta
        System.out.println("==============================================");
        System.out.println("CONSULTA DE ESTADO DE RESERVAS");
        System.out.println("Ingrese la fecha de consulta para verificar el estado de las reservas:");
        LocalDate fechaConsulta = leerFechaValida(scanner);
        System.out.println("==============================================\n");

        // k), l), m), n) Procesar e imprimir el estado de cada reserva
        for (int i = 0; i < reservas.length; i++) {
            Reserva r = reservas[i];
            System.out.println(">>> PROCESANDO RESERVA #" + (i + 1) + " <<<");

            // k) Mostrar detalles con toString()
            System.out.println("Detalles: " + r);

            // l) Verificar si está activa
            boolean activa = r.estaActiva(fechaConsulta);
            System.out
                    .println("¿Está activa en " + fechaConsulta.format(FORMATO_FECHA) + "? " + (activa ? "SÍ" : "NO"));

            // m) Días restantes o transcurridos
            long dias = r.calcularDiasRestantesOTranscurridos(fechaConsulta);
            if (dias > 0) {
                System.out.println("Días faltantes para el Check-In: " + dias + " día(s)");
            } else if (dias == 0) {
                System.out.println("La fecha elegida está dentro de la estadía.");
            } else {
                System.out
                        .println("Días transcurridos desde el Check-Out: " + Math.abs(dias) + " día(s) (" + dias + ")");
            }

            // n) Simular prórroga
            int diasProrroga = leerEnteroPositivo(scanner, "Ingrese la cantidad de días para simular una prórroga: ");
            LocalDate nuevaFechaCheckOut = r.simularProrroga(diasProrroga);
            System.out.println(
                    "Nueva fecha estimada de Check-Out tras prórroga: " + nuevaFechaCheckOut.format(FORMATO_FECHA));

            System.out.println("----------------------------------------------\n");
        }
    }

    // =========================================================================
    // MÉTODOS DE MODULARIZACIÓN Y VALIDACIÓN
    // =========================================================================

    /**
     * Solicita día, mes y año por separado y valida que formen una fecha real en el
     * calendario.
     */
    private static LocalDate leerFechaValida(Scanner scanner) {
        while (true) {
            int dia = leerEnteroEnRango(scanner, "  Ingrese día (1-31): ", 1, 31);
            int mes = leerEnteroEnRango(scanner, "  Ingrese mes (1-12): ", 1, 12);
            int anio = leerEnteroEnRango(scanner, "  Ingrese año (ej. 2026): ", 1900, 2100);

            try {
                return LocalDate.of(anio, mes, dia);
            } catch (Exception e) {
                System.out.println("❌ Error: La fecha ingresada (" + dia + "/" + mes + "/" + anio
                        + ") no existe en el calendario. Intente de nuevo.\n");
            }
        }
    }

    /**
     * Valida números enteros dentro de un rango determinado.
     */
    private static int leerEnteroEnRango(Scanner scanner, String mensaje, int min, int max) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Error: El número debe estar entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return valor;
    }

    /**
     * Valida números enteros estrictamente positivos (> 0).
     */
    private static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextInt();
                if (valor > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El valor debe ser mayor a cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return valor;
    }

    /**
     * Valida la lectura de cadenas de texto evitando entradas vacías.
     */
    private static String leerTextoNoVacio(Scanner scanner, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            // Si el buffer traía un salto de línea previo, reintentar
            if (texto.trim().isEmpty()) {
                texto = scanner.nextLine();
            }
        }
        return texto;
    }
}
