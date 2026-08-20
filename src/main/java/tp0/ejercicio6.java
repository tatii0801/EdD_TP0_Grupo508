package src.main.java.tp0;

// Programa que trabaja con cadenas de texto correspondientes
// al nombre de una ciudad y un pais.

// Importamos Scanner para ingresar cadenas por teclado.
import java.util.Scanner;

/*
 * Enunciado del ejercicio:
 *
 * Solicitar al usuario:
 *
 * - Nombre de una ciudad.
 * - Nombre de un pais.
 *
 * El programa debe concatenar ambas cadenas separandolas
 * mediante una coma y un espacio.
 *
 * Ejemplo:
 * "San Salvador de Jujuy, Argentina"
 *
 * Ademas debe:
 *
 * - Mostrar la cantidad de caracteres de la ciudad.
 * - Mostrar la cantidad de caracteres del pais.
 * - Indicar cual de las dos cadenas es mas larga.
 * - Indicar si tienen la misma longitud.
 * - Verificar si el nombre de la ciudad contiene la letra "ñ".
 * - Mostrar la cadena concatenada completamente en minusculas.
 */

public class ejercicio6 {

    // Metodo principal.
    public static void main(String[] args) {

        // Creamos el Scanner.
        Scanner scanner = new Scanner(System.in);

        // Declaracion de variables.
        String ciudad;
        String pais;
        String resultado;
        int cantidadCiudad;
        int cantidadPais;

        // ==============================
        // INGRESO DE DATOS
        // ==============================

        System.out.print("\nIngrese el nombre de la ciudad: ");
        ciudad = scanner.nextLine();

        System.out.print("Ingrese el nombre del pais: ");
        pais = scanner.nextLine();

        // ==============================
        // LIMPIEZA DE LAS CADENAS
        // ==============================

        // trim() elimina espacios al principio y al final.
        ciudad = ciudad.trim();
        pais = pais.trim();

        // ==============================
        // CONCATENACION
        // ==============================

        // Concatenamos ciudad y pais usando coma y espacio.
        resultado = ciudad + ", " + pais;

        // Mostramos el resultado.
        System.out.println();
        System.out.println("Ciudad y pais: " + resultado);

        // ==============================
        // CANTIDAD DE CARACTERES
        // ==============================

        // length() devuelve la cantidad de caracteres.
        cantidadCiudad = ciudad.length();
        cantidadPais = pais.length();

        System.out.println("Cantidad de caracteres de la ciudad: " + cantidadCiudad);

        System.out.println("Cantidad de caracteres del pais: "+ cantidadPais);

        // ==============================
        // COMPARACION DE LONGITUDES
        // ==============================

        if (cantidadCiudad > cantidadPais) {

            System.out.println("La ciudad tiene mas caracteres que el pais.");

        } else if (cantidadPais > cantidadCiudad) {

            System.out.println("El pais tiene mas caracteres que la ciudad.");

        } else {

            System.out.println("La ciudad y el pais tienen la misma cantidad de caracteres.");
        }

        // ==============================
        // BUSCAR LA LETRA Ñ
        // ==============================

        // contains() permite comprobar si una cadena
        // contiene determinado texto.
        if (ciudad.contains("ñ")) {

            System.out.println("La ciudad contiene la letra ñ.");

        } else {

            System.out.println("La ciudad no contiene la letra ñ.");
        }

        // ==============================
        // CONVERTIR A MINUSCULAS
        // ==============================

        // toLowerCase() convierte todos los caracteres a minusculas.
        String resultadoMinusculas = resultado.toLowerCase();

        System.out.println("Cadena en minusculas: " + resultadoMinusculas);

        // Cerramos el Scanner.
        scanner.close();
    }
}

/*
 * Preguntas sobre el problema
 * a) Al contar la cantidad de caracteres, ¿los espacios en blanco al principio
 * o al final del texto ingresado por
 * el usuario deberían contarse? ¿Qué método de la clase String podría usarse
 * para limpiar esos espacios
 * antes de contar?
 * No sería conveniente contar espacios innecesarios al principio o al final.
 * Podemos utilizar:
 * 
 * trim()
 * 
 * para eliminarlos antes de contar.
 * 
 * b) Un compañero propone comparar si las cadenas son iguales usando el
 * operador == y otro usando el
 * método .equals(). ¿Cuál de las dos representa mejor la comparación de textos
 * en Java y por qué?
 * Para comparar el contenido de dos String se utiliza:
 * 
 * .equals()
 * 
 * El operador == no es la forma adecuada para comparar el contenido de cadenas.
 * 
 * c) ¿Qué sucede si el usuario no ingresa nada (presiona Enter directamente) en
 * uno de los campos? ¿Qué
 * longitud tendría la cadena?
 * Si el usuario presiona Enter directamente, la cadena queda vacía:
 * 
 * ""
 * 
 * y su longitud es 0.
 * 
 * d) Un compañero escribe if (ciudad.equals(pais)) para saber cuál es más
 * larga. ¿Constituye esto un error
 * de lógica respecto a lo que pide el enunciado? Explique cuál sería el método
 * correcto a utilizar.
 * Sí, sería un error de lógica.
 * 
 * ciudad.equals(pais)
 * 
 * sirve para saber si ambas cadenas contienen el mismo texto.
 * 
 * Para saber cuál es más larga debemos comparar:
 * 
 * ciudad.length()
 * pais.length()
 * 
 */