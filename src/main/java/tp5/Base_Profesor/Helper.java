package tp5.Base_Profesor;
/*
 * HELPER
 *
 * Clase auxiliar utilizada para facilitar
 * la entrada de datos y la generacion de
 * valores aleatorios.
 */

import java.util.Random;
import java.util.Scanner;

public class Helper {

    /*
     * Generador de numeros aleatorios.
     */
    public static Random random = new Random();

    /*
     * Scanner para entrada por teclado.
     */
    public static Scanner scanner = new Scanner(System.in);

    /*
     * Obtiene un caracter.
     */
    public static char getCharacter(
            String message) {

        System.out.print(message);

        String input = scanner.nextLine();

        while (input.length() == 0) {

            System.out.println(
                    "Debe ingresar un caracter.");

            System.out.print(message);

            input = scanner.nextLine();
        }

        return input.charAt(0);
    }

    /*
     * Obtiene un entero.
     */
    public static int getInteger(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingrese un numero entero valido.");
            }
        }
    }

    /*
     * Obtiene un entero dentro de un rango.
     */
    public static int getInteger(
            String message,
            int min,
            int max) {

        while (true) {

            int value = getInteger(message);

            if (value >= min &&
                    value <= max) {

                return value;
            }

            System.out.println(
                    "El valor debe estar entre " +
                            min + " y " + max + ".");
        }
    }

    /*
     * Obtiene un numero decimal.
     */
    public static double getDouble(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingrese un numero decimal valido.");
            }
        }
    }

    /*
     * Obtiene un texto.
     */
    public static String getString(
            String message) {

        System.out.print(message);

        return scanner.nextLine();
    }
}