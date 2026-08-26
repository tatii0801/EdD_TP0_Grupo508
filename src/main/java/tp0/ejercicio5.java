package tp0;

// Programa que genera numeros aleatorios y busca aquellos
// que sean divisibles por un determinado divisor.

// Importamos Random para generar numeros aleatorios.
import java.util.Random;

/*
 * Enunciado del ejercicio:
 *
 * Generar aleatoriamente tres numeros enteros:
 *
 * - limiteInferior entre 1 y 100.
 * - limiteSuperior entre 101 y 200.
 * - divisor entre 2 y 9.
 *
 * El programa debe:
 *
 * a) Mostrar los tres numeros generados.
 *
 * b) Generar y mostrar todos los numeros desde limiteInferior
 *    hasta limiteSuperior que sean divisibles exactamente
 *    por el divisor.
 *
 * c) Calcular y mostrar el promedio entero de los numeros
 *    que cumplieron la condicion.
 */

public class ejercicio5 {

    // Metodo principal.
    public static void main(String[] args) {

        // Creamos el objeto Random.
        Random random = new Random();

        // Declaracion de variables.
        int limiteInferior;
        int limiteSuperior;
        int divisor;
        int suma = 0;
        int cantidad = 0;
        int promedio;

        // Generamos un limite inferior entre 1 y 100.
        limiteInferior = random.nextInt(100) + 1;

        // Generamos un limite superior entre 101 y 200.
        limiteSuperior = random.nextInt(100) + 101;

        // Generamos un divisor entre 2 y 9.
        divisor = random.nextInt(8) + 2;

        // Mostramos los numeros generados.
        System.out.println("\n========== NUMEROS GENERADOS ==========");
        System.out.println("Limite inferior: " + limiteInferior);
        System.out.println("Limite superior: " + limiteSuperior);
        System.out.println("Divisor: " + divisor);

        System.out.println();
        System.out.println("Numeros divisibles por " + divisor + ":");

        // Recorremos todos los numeros del rango.
        for (int numero = limiteInferior; numero <= limiteSuperior; numero++) {

            // El operador % devuelve el resto de una division.
            // Si el resto es 0, el numero es divisible exactamente.
            if (numero % divisor == 0) {

                // Mostramos el numero.
                System.out.println(numero);

                // Acumulamos el numero.
                suma = suma + numero;

                // Contamos la cantidad de numeros encontrados.
                cantidad++;
            }
        }

        // Verificamos que exista al menos un numero divisible.
        if (cantidad > 0) {

            // Calculamos el promedio entero.
            promedio = suma / cantidad;

            System.out.println();
            System.out.println("Suma de los numeros: " + suma);
            System.out.println("Cantidad de numeros: " + cantidad);
            System.out.println("Promedio entero: " + promedio);

        } else {

            // Si no encontramos numeros, no podemos calcular el promedio.
            System.out.println();
            System.out.println("No se encontraron numeros divisibles.");
        }
    }
}

/*
 * Preguntas sobre el problema
 * a) ¿Qué información debe mantenerse almacenada durante toda la ejecución del
 * programa para poder
 * calcular el promedio al final?
 * Debemos guardar:
 * 
 * La suma de los números.
 * La cantidad de números encontrados.
 * 
 * b) Si limiteInferior = 10, limiteSuperior = 20, y divisor = 3. Sin ejecutar
 * el programa: ¿Qué números se
 * mostrarán en pantalla? ¿Cuál será el promedio entero?
 * Si:
 * 
 * limiteInferior = 10
 * limiteSuperior = 20
 * divisor = 3
 * 
 * se muestran:
 * 
 * 12
 * 15
 * 18
 * 
 * El promedio entero es:
 * 
 * (12 + 15 + 18) / 3 = 15
 * 
 * c) ¿Qué ocurre si en el rango generado (por ejemplo, limiteInferior=12,
 * limiteSuperior=14, divisor=5)
 * ningún número es divisible? ¿Cómo se debe manejar el cálculo del promedio
 * para evitar un error
 * matemático de división por cero?
 * Si ningún número es divisible, la cantidad queda en 0. No se debe realizar
 * suma / cantidad porque sería una división por cero.
 * 
 * d) En el ejercicio se pide el "promedio entero". Si la suma de los números es
 * 15 y la cantidad es 2, ¿qué
 * diferencia hay en Java entre usar tipos int o double para almacenar y mostrar
 * este resultado?
 * Si la suma es 15 y la cantidad es 2:
 * 
 * Con int:
 * 
 * 15 / 2 = 7
 * 
 * Con double:
 * 
 * 15.0 / 2 = 7.5
 * 
 * Como el ejercicio solicita un promedio entero, corresponde utilizar int.
 * 
 */