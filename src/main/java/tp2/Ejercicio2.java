// Programa para gestionar vuelos de un aeródromo utilizando arreglos paralelos.

package tp2;

import java.util.Scanner;

/*
 * ENUNCIADO DEL EJERCICIO:
 *
 * Crear un programa para la gestión de vuelos en un aeródromo.
 *
 * Solicitar la cantidad de vuelos a gestionar.
 *
 * Para cada vuelo se debe ingresar:
 * - Número de vuelo.
 * - Estado actual.
 *
 * Los estados permitidos son:
 * "Programado", "En Vuelo", "Cancelado" o "Aterrizado".
 *
 * Los datos deben almacenarse en arreglos paralelos.
 *
 * El programa debe permitir:
 *
 * a) Buscar un número de vuelo y mostrar su estado y posición.
 *
 * b) Obtener la cantidad de vuelos de un estado determinado.
 *
 * c) Solicitar un estado y devolver un arreglo con los números
 *    de vuelos correspondientes a ese estado.
 *
 * d) Reorganizar los arreglos para mover los vuelos "Cancelados"
 *    al final manteniendo el orden relativo del resto.
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cantidad;

        // Validamos que la cantidad no sea negativa.
        do {
            System.out.print("Ingrese la cantidad de vuelos: ");
            cantidad = scanner.nextInt();

            if (cantidad < 0) {
                System.out.println("La cantidad no puede ser negativa.");
            }

        } while (cantidad < 0);

        // Arreglos paralelos.
        int[] numeros = new int[cantidad];
        String[] estados = new String[cantidad];

        scanner.nextLine();

        // Carga de los vuelos.
        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nVuelo " + (i + 1));

            System.out.print("Ingrese el número de vuelo: ");
            numeros[i] = scanner.nextInt();

            scanner.nextLine();

            estados[i] = ingresarEstado(scanner);
        }

        // Mostramos los vuelos.
        System.out.println("\nVuelos registrados:");
        mostrarVuelos(numeros, estados);

        // Punto a.
        System.out.print("\nIngrese el número de vuelo a buscar: ");
        int vueloBuscado = scanner.nextInt();

        buscarVuelo(numeros, estados, vueloBuscado);

        scanner.nextLine();

        // Punto b.
        System.out.print("\nIngrese un estado para contar: ");
        String estadoBuscado = scanner.nextLine();

        int cantidadEstado = contarEstado(estados, estadoBuscado);

        System.out.println("Cantidad de vuelos en estado " + estadoBuscado
                + ": " + cantidadEstado);

        // Punto c.
        System.out.print("\nIngrese un estado para obtener sus vuelos: ");
        estadoBuscado = scanner.nextLine();

        int[] vuelosEstado = obtenerVuelosPorEstado(
                numeros,
                estados,
                estadoBuscado);

        System.out.println("Vuelos correspondientes al estado:");

        for (int i = 0; i < vuelosEstado.length; i++) {
            System.out.print(vuelosEstado[i] + " ");
        }

        System.out.println();

        // Punto d.
        reorganizarCancelados(numeros, estados);

        System.out.println("\nVuelos después de mover los cancelados al final:");

        mostrarVuelos(numeros, estados);

        scanner.close();
    }

    // Método para ingresar un estado válido.
    public static String ingresarEstado(Scanner scanner) {

        String estado;

        do {

            System.out.print(
                    "Ingrese estado (Programado / En Vuelo / Cancelado / Aterrizado): ");

            estado = scanner.nextLine();

            if (!estado.equalsIgnoreCase("Programado")
                    && !estado.equalsIgnoreCase("En Vuelo")
                    && !estado.equalsIgnoreCase("Cancelado")
                    && !estado.equalsIgnoreCase("Aterrizado")) {

                System.out.println("Estado inválido.");
            }

        } while (!estado.equalsIgnoreCase("Programado")
                && !estado.equalsIgnoreCase("En Vuelo")
                && !estado.equalsIgnoreCase("Cancelado")
                && !estado.equalsIgnoreCase("Aterrizado"));

        return estado;
    }

    // Busca un vuelo por su número.
    public static void buscarVuelo(
            int[] numeros,
            String[] estados,
            int vueloBuscado) {

        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {

            if (numeros[i] == vueloBuscado) {

                System.out.println(
                        "Vuelo encontrado en la posición: " + i);

                System.out.println(
                        "Estado: " + estados[i]);

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El vuelo no existe.");
        }
    }

    // Cuenta cuántos vuelos tienen un determinado estado.
    public static int contarEstado(
            String[] estados,
            String estadoBuscado) {

        int contador = 0;

        for (int i = 0; i < estados.length; i++) {

            if (estados[i].equalsIgnoreCase(estadoBuscado)) {
                contador++;
            }
        }

        return contador;
    }

    /*
     * Devuelve un nuevo arreglo con los números de vuelos
     * que tienen el estado solicitado.
     */
    public static int[] obtenerVuelosPorEstado(
            int[] numeros,
            String[] estados,
            String estadoBuscado) {

        // Primero contamos cuántos vuelos cumplen la condición.
        int cantidad = contarEstado(estados, estadoBuscado);

        // Creamos el arreglo con el tamaño exacto.
        int[] resultado = new int[cantidad];

        int posicion = 0;

        for (int i = 0; i < estados.length; i++) {

            if (estados[i].equalsIgnoreCase(estadoBuscado)) {

                resultado[posicion] = numeros[i];
                posicion++;
            }
        }

        return resultado;
    }

    /*
     * Mueve todos los vuelos cancelados al final.
     *
     * Se utiliza un método sencillo de ordenamiento estable:
     * cuando encontramos un cancelado, lo intercambiamos con
     * el siguiente vuelo que no sea cancelado.
     */
    public static void reorganizarCancelados(
            int[] numeros,
            String[] estados) {

        for (int i = 0; i < estados.length; i++) {

            if (estados[i].equalsIgnoreCase("Cancelado")) {

                int posicion = i + 1;

                while (posicion < estados.length
                        && estados[posicion].equalsIgnoreCase("Cancelado")) {

                    posicion++;
                }

                if (posicion < estados.length) {

                    int auxiliarNumero = numeros[i];
                    numeros[i] = numeros[posicion];
                    numeros[posicion] = auxiliarNumero;

                    String auxiliarEstado = estados[i];
                    estados[i] = estados[posicion];
                    estados[posicion] = auxiliarEstado;
                }
            }
        }
    }

    // Muestra los vuelos y sus estados.
    public static void mostrarVuelos(
            int[] numeros,
            String[] estados) {

        for (int i = 0; i < numeros.length; i++) {

            System.out.println(
                    "Posición " + i
                            + " - Vuelo: " + numeros[i]
                            + " - Estado: " + estados[i]);
        }
    }
}

/*
 * Preguntas sobre el problema
 * a) ¿Por qué se utilizan arreglos paralelos en lugar de un solo arreglo? ¿Qué
 * riesgo existe al reorganizar los
 * arreglos en el punto d) si nos olvidamos de actualizar uno de los dos
 * arreglos?
 * 
 * 
 * b) Comprobar el funcionamiento del programa en diferentes situaciones, es
 * decir, cuando haya vuelos
 * "Cancelados" al principio, en el medio y al final. ¿Qué resultado espera
 * obtener en el punto d)?
 * 
 * 
 * c) Si ahora se deseara agregar la fecha de salida a cada vuelo, ¿cómo se
 * vería afectada la estructura de
 * arreglos paralelos? ¿Cree que existe otra forma de almacenar más datos sobre
 * los vuelos y mantenerlos
 * en un solo arreglo?
 * 
 * 
 * d) En el punto c), el tamaño del arreglo a devolver no se conoce de antemano.
 * ¿Cómo resolvería la
 * creación de este nuevo arreglo sabiendo que los arreglos estáticos no pueden
 * cambiar de tamaño una
 * vez creados?
 * 
 * Los arreglos son paralelos:
 * 
 * numeros: 101 102 103
 * estados: "..." "..." "..."
 * 
 * La posición 0 de un arreglo corresponde a la posición 0 del otro.
 * 
 * Por eso, cuando intercambiamos vuelos, hay que intercambiar ambos arreglos.
 * 
 */