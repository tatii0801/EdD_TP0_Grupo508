package src.main.java.tp1;

// Programa principal que permite trabajar con un objeto Cilindro.

// Importamos Scanner para ingresar datos por teclado.
import java.util.Scanner;

/*
 * Enunciado:
 *
 * Crear una unica instancia de la clase Cilindro.
 *
 * Solicitar al usuario el radio y la altura.
 * Los valores deben ser estrictamente positivos.
 *
 * Utilizar los metodos de la clase Cilindro para establecer
 * las dimensiones.
 *
 * Finalmente calcular y mostrar el volumen y el area,
 * mostrando los resultados con dos cifras decimales.
 */

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos una unica instancia de Cilindro.
        Cilindro cilindro = new Cilindro();

        double radio;
        double altura;

        System.out.println("===== EJERCICIO 1 =====");
        System.out.println("CALCULO DE UN CILINDRO");

        // Solicitamos el radio hasta que sea positivo.
        do {

            System.out.print("Ingrese el radio: ");
            radio = scanner.nextDouble();

            if (radio <= 0) {
                System.out.println(
                    "Error: el radio debe ser mayor a cero."
                );
            }

        } while (radio <= 0);

        // Solicitamos la altura hasta que sea positiva.
        do {

            System.out.print("Ingrese la altura: ");
            altura = scanner.nextDouble();

            if (altura <= 0) {
                System.out.println(
                    "Error: la altura debe ser mayor a cero."
                );
            }

        } while (altura <= 0);

        // Establecemos los valores en el objeto.
        cilindro.setRadio(radio);
        cilindro.setAltura(altura);

        // Calculamos los resultados utilizando
        // los metodos de la clase Cilindro.
        double volumen = cilindro.calcularVolumen();
        double area = cilindro.calcularArea();

        // Mostramos los resultados con dos decimales.
        System.out.printf(
            "\nVolumen: %.2f%n",
            volumen
        );

        System.out.printf(
            "Area de la superficie: %.2f%n",
            area
        );

        scanner.close();
    }
}

/*
Preguntas sobre el problema
a) ¿Cuáles son las entradas y salidas del programa? ¿Qué información debe mantenerse almacenada en el
objeto durante toda la ejecución y qué información es sólo temporal?
Las entradas son el radio y la altura. Las salidas son el volumen y el área. El radio y la altura deben permanecer almacenados en el objeto. El volumen y el área son resultados temporales que se calculan mediante métodos.

b) ¿Qué ocurre si el usuario intenta ingresar un radio o altura igual a cero o a un valor negativo? ¿Cómo
garantiza su código que el objeto Cilindro nunca contenga dimensiones inválidas?
Si se ingresa 0 o un número negativo, el programa lo rechaza y vuelve a solicitar el dato. Además, los setters también controlan que no se puedan establecer dimensiones inválidas.

c) Compruebe el comportamiento de un objeto cilindro cuando se usan: valores positivos, valores que
intenten vulnerar la validación (por ej. valor negativo) y cuando el radio y la altura son iguales.
Con valores positivos el objeto funciona normalmente. Si se intenta ingresar un valor negativo, la validación lo rechaza. Si radio y altura son iguales, ambos atributos tendrán el mismo valor y los métodos calcularán normalmente el volumen y el área.

d) ¿Qué ventajas tiene implementar los cálculos de volumen y área como métodos en la clase Cilindro en
lugar de hacer las operaciones matemáticas directamente en el método main?
Es mejor implementar los cálculos dentro de Cilindro porque los datos y las operaciones relacionadas con el cilindro quedan juntos. Esto mejora el encapsulamiento, facilita reutilizar los métodos y evita colocar la lógica matemática directamente en main.
*/