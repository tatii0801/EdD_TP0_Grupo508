package tp1_by_Santy;

import java.util.InputMismatchException;
import java.util.Scanner;

import tp1_by_Santy.classes.Cilindro;

/**
 * 1) Diseñar una clase llamada Cilindro que representa una figura geométrica
 * tridimensional. Esta clase debe
 * tener los atributos radio (de la base) y altura. La clase Cilindro debe
 * incluir:
 * a) Constructor predeterminado que inicialice ambos valores en 1.0.
 * b) Un constructor con argumentos para establecer el radio y la altura del
 * cilindro.
 * c) Un método que devuelva el volumen del cilindro (Fórmula: π * radio2 *
 * altura).
 * d) Un método que devuelva el área de la superficie total (Fórmula: 2 * π *
 * radio * (radio + altura)).
 * En el programa principal (main) se debe:
 * e) Crear una única instancia de la clase Cilindro.
 * f) Solicitar al usuario que ingrese el radio y la altura verificando que los
 * valores sean estrictamente
 * positivos (mayores a cero).
 * g) Utilizar los métodos de la clase Cilindro para establecer estas
 * dimensiones.
 * h) Calcular y mostrar el volumen y el área de la superficie del cilindro
 * creado, formateando los decimales a
 * dos cifras.
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
 * a) ¿Cuáles son las entradas y salidas del programa? ¿Qué información debe
 * mantenerse almacenada en el
 * objeto durante toda la ejecución y qué información es sólo temporal?
 * b) ¿Qué ocurre si el usuario intenta ingresar un radio o altura igual a cero
 * o a un valor negativo? ¿Cómo
 * garantiza su código que el objeto Cilindro nunca contenga dimensiones
 * inválidas?
 * c) Compruebe el comportamiento de un objeto cilindro cuando se usan: valores
 * positivos, valores que
 * intenten vulnerar la validación (por ej. valor negativo) y cuando el radio y
 * la altura son iguales.ejercicio1
 * d) ¿Qué ventajas tiene implementar los cálculos de volumen y área como
 * métodos en la clase Cilindro en
 * lugar de hacer las operaciones matemáticas directamente en el método main?
 * 
 * Respuestas:
 * 
 * a) Entradas: radio y altura del cilindro. Salidas: volumen y área de la superficie total del cilindro. La 
 * información que debe mantenerse almacenada en el objeto durante toda la ejecución son los atributos radio y
 * altura, mientras que el volumen y el área son información temporal calculada a partir de esos atributos.
 * 
 * b) Si el usuario intenta ingresar un radio o altura igual a cero o a un valor negativo, el programa solicita
 * nuevamente el ingreso del valor hasta que se ingrese un valor estrictamente positivo. Esto garantiza 
 * que el objeto Cilindro nunca contenga dimensiones inválidas, ya que los setters solo se llaman con valores válidos.
 * 
 * c) Al probar el comportamiento del objeto Cilindro con valores positivos, el programa calcula correctamente el
 * volumen y el área. Si se ingresan valores negativos o cero, el programa solicita nuevamente
 * el ingreso hasta que se ingrese un valor válido. Cuando el radio y la altura son iguales, el cálculo de volumen y área 
 * sigue siendo correcto.
 * 
 * d) Implementar los cálculos de volumen y área como métodos en la clase Cilindro permite encapsular la lógica relacionada 
 * con el cilindro dentro de la propia clase, promoviendo la reutilización del código y facilitando el mantenimiento. Además, mejora 
 * la legibilidad del código en el método main, ya que se delega la responsabilidad de los cálculos a la clase Cilindro.
 * 
 */

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // e) Crear una única instancia de la clase Cilindro (usa el constructor por
        // defecto)
        Cilindro miCilindro = new Cilindro();

        System.out.println("=== CÁLCULO DE PROPIEDADES DEL CILINDRO ===");

        // f) Solicitar radio y altura verificando que sean estrictamente positivos (>
        // 0)
        double radioIngresado = leerDoublePositivo(scanner, "Ingrese el radio de la base: ");
        double alturaIngresada = leerDoublePositivo(scanner, "Ingrese la altura del cilindro: ");

        // g) Utilizar los métodos para establecer estas dimensiones (Setters)
        miCilindro.setRadio(radioIngresado);
        miCilindro.setAltura(alturaIngresada);

        // h) Calcular y mostrar el volumen y área formateados a dos decimales
        System.out.println("\n=== RESULTADOS ===");
        System.out.printf("Volumen del cilindro: %.2f%n", miCilindro.calcularVolumen());
        System.out.printf("Área de la superficie total: %.2f%n", miCilindro.calcularAreaSuperficie());

        scanner.close();
    }

    /**
     * Método modularizado para solicitar un número decimal estrictamente positivo.
     * Maneja excepciones de tipo de entrada (letras o caracteres inválidos) y
     * limpia el buffer.
     */

    private static double leerDoublePositivo(Scanner scanner, String mensaje) {
        double valor = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();

                if (valor > 0) {
                    entradaValida = true;
                } else {
                    System.out.println(
                            "Error: El valor debe ser estrictamente positivo (mayor a cero). Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido (ej. 4.5 o 3).");
                scanner.nextLine(); // Limpia el buffer de entradas no válidas para evitar un bucle infinito
            }
        }

        return valor;
    }

}
