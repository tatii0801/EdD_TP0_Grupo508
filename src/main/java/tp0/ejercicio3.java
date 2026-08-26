package tp0;

// Programa que calcula el porcentaje de rendimiento de un estudiante.

// Importamos Scanner para ingresar datos por teclado.
import java.util.Scanner;

/*
 * Enunciado del ejercicio:
 *
 * Desarrollar un programa que solicite:
 *
 * - Cantidad total de preguntas de un examen.
 * - Cantidad de respuestas correctas.
 *
 * El programa debe calcular el porcentaje de rendimiento:
 *
 * Porcentaje = (Respuestas correctas / Total de preguntas) * 100
 *
 * Luego debe clasificar el rendimiento:
 *
 * Mayor o igual a 90%: Excelente
 * Entre 70% y 89.99%: Muy Bueno
 * Entre 50% y 69.99%: Aprobado
 * Menor a 50%: Desaprobado
 *
 * El programa debe mostrar:
 * - Porcentaje calculado.
 * - Categoria obtenida.
 */

public class ejercicio3 {

    // Metodo principal del programa.
    public static void main(String[] args) {

        // Creamos el Scanner.
        Scanner scanner = new Scanner(System.in);

        // Declaracion de variables.
        int totalPreguntas;
        int respuestasCorrectas;
        double porcentaje;
        String categoria;

        // Mostramos el titulo.
        System.out.print("\nEjercicio 3: Rendimiento de un estudiante\n");

        // Ingresamos la cantidad total de preguntas.
        System.out.print("Ingrese la cantidad total de preguntas: ");
        totalPreguntas = scanner.nextInt();

        // Validamos que sea mayor que cero.
        while (totalPreguntas <= 0) {

            System.out.println("Error: el total debe ser mayor que 0.");

            System.out.print("Ingrese nuevamente el total: ");
            totalPreguntas = scanner.nextInt();
        }

        // Ingresamos las respuestas correctas.
        System.out.print("Ingrese la cantidad de respuestas correctas: ");
        respuestasCorrectas = scanner.nextInt();

        // Validamos que las correctas sean validas.
        while (respuestasCorrectas < 0 || respuestasCorrectas > totalPreguntas) {

            System.out.println("Error: la cantidad de respuestas correctas "
                         + "debe estar entre 0 y " + totalPreguntas);

            System.out.print("Ingrese nuevamente las respuestas correctas: ");
            respuestasCorrectas = scanner.nextInt();
        }

        // Calculamos el porcentaje.
        // Se utiliza double para evitar la division entera.
        porcentaje = ((double) respuestasCorrectas / totalPreguntas) * 100;

        // Clasificamos el rendimiento.
        if (porcentaje >= 90) {

            categoria = "Excelente";

        } else if (porcentaje >= 70) {

            categoria = "Muy Bueno";

        } else if (porcentaje >= 50) {

            categoria = "Aprobado";

        } else {

            categoria = "Desaprobado";
        }

        // Mostramos los resultados.
        System.out.println("\n========== RESULTADOS ==========");
        System.out.println("Porcentaje de rendimiento: " + porcentaje + "%");
        System.out.println("Categoria: " + categoria);

        // Cerramos el Scanner.
        scanner.close();
    }
}
/*
 * Preguntas sobre el problema
 * a) ¿Qué validaciones se deben aplicar a las entradas? Considere la relación
 * lógica entre preguntas totales
 * y respuestas correctas.
 * 
 * 
 * b) Si un estudiante obtiene un porcentaje de rendimiento de exactamente
 * 89.995% ¿qué categoría le
 * corresponde de acuerdo al enunciado? ¿Qué acción se debería hacer para que el
 * porcentaje sea justo
 * 89.99%? ¿Por qué es importante probar valores justo en el límite de los
 * tramos?
 * 
 * 
 * c) Un compañero escribe la siguiente línea para calcular el porcentaje:
 * int porcentaje = (correctas / total) * 100;
 * Si correctas = 4 y total = 5, ¿qué resultado devuelve esa línea? ¿Constituye
 * un error? Justifique.
 */