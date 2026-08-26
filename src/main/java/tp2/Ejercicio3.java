// Programa que permite ingresar una cantidad variable de caracteres
// y realizar diferentes operaciones sobre ellos.

package tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * ENUNCIADO DEL EJERCICIO:
 *
 * Permitir al usuario ingresar cualquier cantidad de caracteres.
 *
 * a) Obtener la cantidad de caracteres que aparecen más de una vez,
 *    sin distinguir entre mayúsculas y minúsculas.
 *
 * b) Buscar la posición de la primera vocal y la última consonante.
 *
 * c) Obtener un nuevo arreglo con los caracteres que sean dígitos.
 *
 * d) Intercambiar el primer carácter mayúscula encontrado con el último
 *    símbolo encontrado.
 *
 * Si no hay mayúsculas o símbolos, utilizar un carácter de una posición
 * aleatoria.
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<Character> caracteres = new ArrayList<>();

        System.out.println("Ingrese caracteres.");
        System.out.println("Presione Enter sin ingresar nada para finalizar.");

        String entrada;

        do {

            System.out.print("Ingrese un carácter: ");
            entrada = scanner.nextLine();

            if (!entrada.isEmpty()) {

                // Agregamos cada carácter ingresado.
                for (int i = 0; i < entrada.length(); i++) {
                    caracteres.add(entrada.charAt(i));
                }
            }

        } while (!entrada.isEmpty());

        // Punto a.
        mostrarDuplicados(caracteres);

        // Punto b.
        buscarVocalYConsonante(caracteres);

        // Punto c.
        ArrayList<Character> digitos = obtenerDigitos(caracteres);

        System.out.println("\nCaracteres numéricos:");

        for (Character caracter : digitos) {
            System.out.print(caracter + " ");
        }

        // Punto d.
        intercambiarCaracteres(caracteres, random);

        System.out.println("\n\nArreglo modificado:");

        for (Character caracter : caracteres) {
            System.out.print(caracter + " ");
        }

        scanner.close();
    }

    // Punto a: muestra los caracteres que aparecen más de una vez.
    public static void mostrarDuplicados(
            ArrayList<Character> caracteres) {

        ArrayList<Character> duplicados = new ArrayList<>();

        for (int i = 0; i < caracteres.size(); i++) {

            char actual = Character.toLowerCase(caracteres.get(i));

            int contador = 0;

            for (int j = 0; j < caracteres.size(); j++) {

                char comparado = Character.toLowerCase(caracteres.get(j));

                if (actual == comparado) {
                    contador++;
                }
            }

            if (contador > 1 && !duplicados.contains(actual)) {

                duplicados.add(actual);
            }
        }

        System.out.println(
                "\nCantidad de caracteres duplicados: "
                        + duplicados.size());

        System.out.println("Caracteres duplicados:");

        for (Character caracter : duplicados) {
            System.out.print(caracter + " ");
        }

        System.out.println();
    }

    // Punto b: busca la primera vocal y la última consonante.
    public static void buscarVocalYConsonante(
            ArrayList<Character> caracteres) {

        int primeraVocal = -1;
        int ultimaConsonante = -1;

        for (int i = 0; i < caracteres.size(); i++) {

            char caracter = Character.toLowerCase(caracteres.get(i));

            if (primeraVocal == -1 && esVocal(caracter)) {
                primeraVocal = i;
            }

            if (esConsonante(caracter)) {
                ultimaConsonante = i;
            }
        }

        if (primeraVocal != -1) {

            System.out.println(
                    "\nPrimera vocal: "
                            + caracteres.get(primeraVocal)
                            + " - posición: "
                            + primeraVocal);

        } else {

            System.out.println("\nNo se encontró ninguna vocal.");
        }

        if (ultimaConsonante != -1) {

            System.out.println(
                    "Última consonante: "
                            + caracteres.get(ultimaConsonante)
                            + " - posición: "
                            + ultimaConsonante);

        } else {

            System.out.println("No se encontró ninguna consonante.");
        }
    }

    // Determina si un carácter es una vocal.
    public static boolean esVocal(char caracter) {

        return caracter == 'a'
                || caracter == 'e'
                || caracter == 'i'
                || caracter == 'o'
                || caracter == 'u';
    }

    // Determina si un carácter es una consonante.
    public static boolean esConsonante(char caracter) {

        return Character.isLetter(caracter)
                && !esVocal(caracter);
    }

    // Punto c: obtiene solamente los dígitos.
    public static ArrayList<Character> obtenerDigitos(
            ArrayList<Character> caracteres) {

        ArrayList<Character> digitos = new ArrayList<>();

        for (Character caracter : caracteres) {

            if (Character.isDigit(caracter)) {
                digitos.add(caracter);
            }
        }

        return digitos;
    }

    /*
     * Punto d:
     *
     * Busca:
     * - Primera letra mayúscula.
     * - Último símbolo.
     *
     * Si alguno no existe, utiliza una posición aleatoria.
     */
    public static void intercambiarCaracteres(
            ArrayList<Character> caracteres,
            Random random) {

        if (caracteres.isEmpty()) {
            System.out.println("\nEl arreglo está vacío.");
            return;
        }

        int posicionMayuscula = -1;
        int posicionSimbolo = -1;

        // Buscamos la primera mayúscula.
        for (int i = 0; i < caracteres.size(); i++) {

            if (Character.isUpperCase(caracteres.get(i))) {

                posicionMayuscula = i;
                break;
            }
        }

        // Buscamos el último símbolo.
        for (int i = caracteres.size() - 1; i >= 0; i--) {

            char caracter = caracteres.get(i);

            if (!Character.isLetterOrDigit(caracter)) {

                posicionSimbolo = i;
                break;
            }
        }

        // Si no existe una mayúscula, usamos posición aleatoria.
        if (posicionMayuscula == -1) {

            posicionMayuscula = random.nextInt(caracteres.size());
        }

        // Si no existe un símbolo, usamos posición aleatoria.
        if (posicionSimbolo == -1) {

            posicionSimbolo = random.nextInt(caracteres.size());
        }

        // Intercambiamos utilizando una variable auxiliar.
        Character auxiliar = caracteres.get(posicionMayuscula);

        caracteres.set(
                posicionMayuscula,
                caracteres.get(posicionSimbolo));

        caracteres.set(
                posicionSimbolo,
                auxiliar);
    }
}

/*

*/