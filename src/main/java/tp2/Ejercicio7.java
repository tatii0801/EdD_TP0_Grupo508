// ============================================================
// TRABAJO PRÁCTICO N° 2 - CICLO 2026
// Tema: Arreglo
// Punto 7 - Análisis de soluciones
// ============================================================

// Paquete al que pertenece la clase
package tp2;

// Importamos Scanner para ingresar datos por teclado
import java.util.Scanner;

/*
 * ============================================================
 * CONSIGNA
 * ============================================================
 *
 * Desarrollar un método que reciba un arreglo de números
 * enteros y devuelva un nuevo arreglo que contenga únicamente
 * los números pares del arreglo original, manteniendo su orden.
 *
 * No se debe modificar el arreglo original.
 *
 * Se presentan dos soluciones propuestas:
 *
 * SOLUCIÓN A:
 *
 * public static int[] obtenerParesA(int[] arr) {
 *     int[] nuevo = new int[arr.length];
 *     int j = 0;
 *
 *     for (int i = 0; i < arr.length; i++) {
 *         if (arr[i] % 2 == 0) {
 *             nuevo[j] = arr[i];
 *             j++;
 *         }
 *     }
 *
 *     return nuevo;
 * }
 *
 *
 * SOLUCIÓN B:
 *
 * public static int[] obtenerParesB(int[] arr) {
 *     int contador = 0;
 *
 *     for (int i = 0; i < arr.length; i++) {
 *         if (arr[i] % 2 == 0) {
 *             contador++;
 *         }
 *     }
 *
 *     int[] nuevo = new int[contador];
 *     int j = 0;
 *
 *     for (int i = 0; i < arr.length; i++) {
 *         if (arr[i] % 2 == 0) {
 *             nuevo[j] = arr[i];
 *             j++;
 *         }
 *     }
 *
 *     return nuevo;
 * }
 *
 * ============================================================
 * OBJETIVO
 * ============================================================
 *
 * Analizar ambas soluciones y determinar cuál representa mejor
 * la consigna.
 *
 * La solución debe:
 *
 * - Recibir un arreglo de números enteros.
 * - Buscar los números pares.
 * - Mantener el orden original.
 * - Crear un NUEVO arreglo.
 * - No modificar el arreglo original.
 *
 */

// Clase principal
public class Ejercicio7 {

    // ============================================================
    // SOLUCIÓN A
    // ============================================================

    /*
     * Este método recibe un arreglo de números enteros
     * y devuelve otro arreglo que contiene los números pares.
     *
     * En esta solución el nuevo arreglo tiene el mismo tamaño
     * que el arreglo original.
     */
    public static int[] obtenerParesA(int[] arr) {

        // Creamos un nuevo arreglo con el mismo tamaño
        // que el arreglo original.
        int[] nuevo = new int[arr.length];

        // Variable utilizada para indicar la posición
        // donde se guardará el próximo número par.
        int j = 0;

        // Recorremos todo el arreglo original.
        for (int i = 0; i < arr.length; i++) {

            // Comprobamos si el elemento es par.
            // Si el resto de dividir por 2 es 0, es par.
            if (arr[i] % 2 == 0) {

                // Guardamos el número par en el nuevo arreglo.
                nuevo[j] = arr[i];

                // Avanzamos a la siguiente posición.
                j++;
            }
        }

        // Devolvemos el nuevo arreglo.
        return nuevo;
    }

    // ============================================================
    // SOLUCIÓN B
    // ============================================================

    /*
     * Esta solución primero cuenta cuántos números pares
     * existen en el arreglo.
     *
     * Luego crea un nuevo arreglo exactamente del tamaño
     * necesario.
     *
     * Finalmente vuelve a recorrer el arreglo original
     * para guardar los números pares.
     */
    public static int[] obtenerParesB(int[] arr) {

        // Variable que contará la cantidad de números pares.
        int contador = 0;

        // Primer recorrido del arreglo.
        for (int i = 0; i < arr.length; i++) {

            // Comprobamos si el número es par.
            if (arr[i] % 2 == 0) {

                // Aumentamos el contador.
                contador++;
            }
        }

        // Creamos el nuevo arreglo con exactamente
        // la cantidad de posiciones necesarias.
        int[] nuevo = new int[contador];

        // Variable que indica dónde guardar el próximo par.
        int j = 0;

        // Segundo recorrido del arreglo original.
        for (int i = 0; i < arr.length; i++) {

            // Comprobamos si el número es par.
            if (arr[i] % 2 == 0) {

                // Guardamos el número par.
                nuevo[j] = arr[i];

                // Avanzamos a la siguiente posición.
                j++;
            }
        }

        // Devolvemos el nuevo arreglo.
        return nuevo;
    }

    // ============================================================
    // MÉTODO PARA MOSTRAR UN ARREGLO
    // ============================================================

    /*
     * Este método recibe un arreglo y muestra todos
     * sus elementos por pantalla.
     */
    public static void mostrarArreglo(int[] arr) {

        // Recorremos el arreglo.
        for (int i = 0; i < arr.length; i++) {

            // Mostramos cada elemento.
            System.out.print(arr[i] + " ");
        }

        // Salto de línea.
        System.out.println();
    }

    // ============================================================
    // MÉTODO PRINCIPAL
    // ============================================================

    public static void main(String[] args) {

        // Creamos Scanner para ingresar datos por teclado.
        Scanner scanner = new Scanner(System.in);

        // --------------------------------------------------------
        // INGRESO DEL TAMAÑO DEL ARREGLO
        // --------------------------------------------------------

        System.out.println("======================================");
        System.out.println("       TRABAJO PRACTICO N° 2");
        System.out.println("              PUNTO 7");
        System.out.println("======================================");

        System.out.print("\nIngrese la cantidad de elementos del arreglo: ");
        int cantidad = scanner.nextInt();

        // Validamos que la cantidad sea positiva.
        while (cantidad <= 0) {

            System.out.println("Error: la cantidad debe ser mayor que 0.");

            System.out.print("Ingrese nuevamente la cantidad: ");
            cantidad = scanner.nextInt();
        }

        // --------------------------------------------------------
        // CREACIÓN DEL ARREGLO ORIGINAL
        // --------------------------------------------------------

        int[] arreglo = new int[cantidad];

        // --------------------------------------------------------
        // CARGA DEL ARREGLO
        // --------------------------------------------------------

        System.out.println("\nIngrese los elementos del arreglo:");

        for (int i = 0; i < arreglo.length; i++) {

            System.out.print("Elemento [" + i + "]: ");
            arreglo[i] = scanner.nextInt();
        }

        // --------------------------------------------------------
        // MOSTRAMOS EL ARREGLO ORIGINAL
        // --------------------------------------------------------

        System.out.println("\n======================================");
        System.out.println("ARREGLO ORIGINAL");
        System.out.println("======================================");

        mostrarArreglo(arreglo);

        // ========================================================
        // EJECUTAMOS LA SOLUCIÓN A
        // ========================================================

        int[] resultadoA = obtenerParesA(arreglo);

        System.out.println("\n======================================");
        System.out.println("SOLUCIÓN A");
        System.out.println("======================================");

        System.out.println("Números pares obtenidos:");

        mostrarArreglo(resultadoA);

        // ========================================================
        // EJECUTAMOS LA SOLUCIÓN B
        // ========================================================

        int[] resultadoB = obtenerParesB(arreglo);

        System.out.println("\n======================================");
        System.out.println("SOLUCIÓN B");
        System.out.println("======================================");

        System.out.println("Números pares obtenidos:");

        mostrarArreglo(resultadoB);

        // --------------------------------------------------------
        // COMPROBAMOS QUE EL ARREGLO ORIGINAL NO FUE MODIFICADO
        // --------------------------------------------------------

        System.out.println("\n======================================");
        System.out.println("ARREGLO ORIGINAL DESPUÉS DE LAS SOLUCIONES");
        System.out.println("======================================");

        mostrarArreglo(arreglo);

        // Cerramos Scanner.
        scanner.close();
    }
}

/*
 * Preguntas sobre el problema a resolver
 * 1. ¿Cuál de las dos soluciones respeta mejor las restricciones del ejercicio?
 * Piense específicamente en la
 * instrucción "devolver un nuevo arreglo". ¿Qué sucede con la Solución A si el
 * arreglo original tiene 30
 * elementos y solo 2 son pares? ¿Qué contiene el arreglo devuelto por A en las
 * posiciones no usadas?
 * La Solución B.
 * 
 * La consigna pide devolver un arreglo que contenga únicamente los números
 * pares.
 * 
 * Por ejemplo:
 * 
 * Original:
 * 10 3 7 8 5 2
 * 
 * La solución B devuelve:
 * 
 * 10 8 2
 * 
 * La solución A crea:
 * 
 * 10 8 2 0 0 0
 * 
 * porque el arreglo tiene el mismo tamaño que el original y las posiciones que
 * no se utilizan quedan con el valor 0.
 * 
 * 2. ¿Cuál solución es más fácil de explicar a un compañero? Argumente sobre la
 * claridad del código.
 * La Solución B puede resultar un poco más larga, pero es más clara
 * conceptualmente porque primero cuenta cuántos pares existen y después crea un
 * arreglo del tamaño exacto.
 * 
 * 3. ¿Qué ventajas y desventajas presenta cada solución? Haga referencia al
 * consumo de memoria y la exactitud
 * del tamaño del arreglo resultante.
 * Solución A
 * 
 * Ventaja:
 * 
 * Es más sencilla.
 * Hace un solo recorrido para cargar los valores.
 * 
 * Desventaja:
 * 
 * Puede ocupar más memoria de la necesaria.
 * El arreglo resultante puede contener ceros que no representan números pares
 * originales.
 * Solución B
 * 
 * Ventaja:
 * 
 * El arreglo tiene exactamente la cantidad de elementos necesarios.
 * No quedan posiciones sobrantes.
 * 
 * Desventaja:
 * 
 * Recorre el arreglo dos veces.
 * 
 * 4. Si la consigna permitiera usar ArrayList en lugar de arreglo estático,
 * ¿cuál de los dos problemas de diseño se
 * resolvería automáticamente? Explique por qué.
 * Con ArrayList no necesitamos conocer previamente el tamaño.
 * 
 * Podemos hacer:
 * 
 * ArrayList<Integer> pares = new ArrayList<>();
 * 
 * y agregar cada número par:
 * 
 * pares.add(arr[i]);
 * 
 * El ArrayList aumenta dinámicamente su tamaño.
 * 
 */