// Programa que trabaja con un arreglo de números enteros aleatorios.

// El paquete permite organizar las clases del programa.
package tp2;

// Importamos Scanner para ingresar datos por teclado.
import java.util.Scanner;

// Importamos Random para generar números aleatorios.
import java.util.Random;

/*
 * ENUNCIADO DEL EJERCICIO:
 *
 * Desarrollar un programa que solicite al usuario un valor entero N.
 * Generar N números aleatorios entre -50 y 50 y cargarlos en un arreglo.
 *
 * Luego el programa debe implementar:
 *
 * a) Un método que reciba el arreglo inicial y devuelva otro arreglo
 *    que contenga los elementos desplazados una posición hacia la izquierda.
 *    El primer elemento debe pasar a la última posición.
 *
 * b) Un método que calcule y muestre la suma de los números positivos
 *    y la suma de los números negativos por separado.
 *
 * c) Un método que invierta el orden de los elementos del arreglo original
 *    modificándolo directamente, sin crear un arreglo nuevo, y luego lo muestre.
 */
public class Ejercicio1 {

    // Método principal del programa.
    public static void main(String[] args) {

        // Creamos el objeto Scanner para ingresar datos.
        Scanner scanner = new Scanner(System.in);

        // Creamos el objeto Random para generar números aleatorios.
        Random random = new Random();

        int n;

        // Solicitamos la cantidad de elementos.
        do {
            System.out.print("Ingrese la cantidad de elementos del arreglo: ");
            n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Error: la cantidad no puede ser negativa.");
            }

        } while (n < 0);

        // Creamos el arreglo con la cantidad indicada.
        int[] arreglo = new int[n];

        // Cargamos el arreglo con números aleatorios entre -50 y 50.
        for (int i = 0; i < arreglo.length; i++) {

            // nextInt(101) genera valores entre 0 y 100.
            // Al restar 50 obtenemos valores entre -50 y 50.
            arreglo[i] = random.nextInt(101) - 50;
        }

        // Mostramos el arreglo original.
        System.out.println("\nArreglo original:");
        mostrarArreglo(arreglo);

        // Punto a:
        // Desplazamos los elementos una posición hacia la izquierda.
        int[] desplazado = desplazarIzquierda(arreglo);

        System.out.println("\nArreglo desplazado hacia la izquierda:");
        mostrarArreglo(desplazado);

        // Punto b:
        // Calculamos la suma de positivos y negativos.
        calcularSumas(arreglo);

        // Punto c:
        // Invertimos el arreglo original.
        invertirArreglo(arreglo);

        System.out.println("\nArreglo original invertido:");
        mostrarArreglo(arreglo);

        // Cerramos Scanner.
        scanner.close();
    }

    /*
     * Método que desplaza los elementos una posición hacia la izquierda.
     *
     * Ejemplo:
     *
     * Original:
     * 10 20 30 40
     *
     * Resultado:
     * 20 30 40 10
     *
     * Se crea y devuelve un nuevo arreglo.
     */
    public static int[] desplazarIzquierda(int[] arreglo) {

        // Creamos un nuevo arreglo del mismo tamaño.
        int[] nuevo = new int[arreglo.length];

        // Recorremos el arreglo original.
        for (int i = 0; i < arreglo.length - 1; i++) {

            // El elemento siguiente pasa a la posición actual.
            nuevo[i] = arreglo[i + 1];
        }

        // El primer elemento pasa a la última posición.
        if (arreglo.length > 0) {
            nuevo[arreglo.length - 1] = arreglo[0];
        }

        // Devolvemos el nuevo arreglo.
        return nuevo;
    }

    /*
     * Método que calcula la suma de los números positivos
     * y la suma de los números negativos.
     */
    public static void calcularSumas(int[] arreglo) {

        int sumaPositivos = 0;
        int sumaNegativos = 0;

        // Recorremos todos los elementos.
        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] > 0) {
                sumaPositivos += arreglo[i];

            } else if (arreglo[i] < 0) {
                sumaNegativos += arreglo[i];
            }
        }

        System.out.println("\nSuma de positivos: " + sumaPositivos);
        System.out.println("Suma de negativos: " + sumaNegativos);
    }

    /*
     * Método que invierte el arreglo original.
     *
     * No devuelve un arreglo nuevo.
     * Modifica directamente el arreglo recibido.
     */
    public static void invertirArreglo(int[] arreglo) {

        int inicio = 0;
        int fin = arreglo.length - 1;

        // Mientras los índices no se crucen.
        while (inicio < fin) {

            // Guardamos temporalmente el elemento.
            int auxiliar = arreglo[inicio];

            // Intercambiamos los elementos.
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = auxiliar;

            inicio++;
            fin--;
        }
    }

    // Método para mostrar todos los elementos del arreglo.
    public static void mostrarArreglo(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }

        System.out.println();
    }
}

/*
 * Preguntas sobre el problema
 * a) En el punto a), el método debe devolver un nuevo arreglo, mientras que en
 * el punto c) se debe
 * modificar el arreglo original. ¿Qué diferencia existe en la firma del método
 * entre ambos puntos? ¿Por
 * qué el punto c) no necesita devolver un valor?
 * En el punto a) se devuelve un nuevo arreglo, por eso el método es:
 * 
 * public static int[] desplazarIzquierda(int[] arreglo)
 * 
 * En cambio, en el punto c) se modifica directamente el arreglo original:
 * 
 * public static void invertirArreglo(int[] arreglo)
 * 
 * Por eso no necesita devolver nada y utiliza void.
 * 
 * b) ¿Qué ocurre si el usuario ingresa N=0? ¿Cómo se comporta el método de
 * desplazamiento y el de
 * inversión? ¿El programa soporta esta situación sin lanzar excepciones?
 * Si N = 0, se crea un arreglo vacío. Los métodos están preparados para
 * trabajar con length = 0 sin acceder a posiciones inexistentes.
 * 
 * c) Si el arreglo generado contiene 10, -5, 3 y 0, sin ejecutar el programa:
 * ¿Cuál será el contenido del
 * arreglo después de ejecutar el punto a)? ¿Y después de ejecutar el punto c)
 * sobre el arreglo original?
 * Para:
 * 
 * 10 -5 3 0
 * 
 * Desplazado:
 * 
 * -5 3 0 10
 * 
 * Invertido:
 * 
 * 0 3 -5 10
 * 
 * d) En el punto c), se pide modificar el arreglo original. ¿Qué ventajas y
 * desventajas tiene modificar el
 * arreglo original frente a crear y devolver un arreglo nuevo?
 * Modificar el arreglo original evita crear otro arreglo y consume menos
 * memoria, pero modifica los datos originales. Crear otro arreglo conserva el
 * original, pero utiliza más memoria.
 * 
 */