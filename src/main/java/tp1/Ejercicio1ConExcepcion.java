package tp1;

import java.util.Scanner;

public class Ejercicio1ConExcepcion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos una única instancia del cilindro
        Cilindro1 cilindro = new Cilindro1();

        double radio;
        double altura;

        System.out.println("=================================");
        System.out.println("        DATOS DEL CILINDRO");
        System.out.println("=================================");

        // Ingreso y validación del radio
        while (true) {

            try {

                System.out.print("Ingrese el radio: ");
                radio = scanner.nextDouble();

                // Utilizamos el método de la clase
                cilindro.setRadio(radio);

                // Si no se produce una excepción, salimos del ciclo
                break;

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Error: debe ingresar un valor numerico.");

                // Limpiamos el dato incorrecto ingresado
                scanner.nextLine();
            }
        }

        // Ingreso y validación de la altura
        while (true) {

            try {

                System.out.print("Ingrese la altura: ");
                altura = scanner.nextDouble();

                // Utilizamos el método de la clase
                cilindro.setAltura(altura);

                // Si no se produce una excepción, salimos del ciclo
                break;

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Error: debe ingresar un valor numerico.");

                // Limpiamos el dato incorrecto ingresado
                scanner.nextLine();
            }
        }

        // Calculamos el volumen utilizando el método de la clase
        double volumen = cilindro.calcularVolumen();

        // Calculamos el área utilizando el método de la clase
        double area = cilindro.calcularAreaSuperficie();

        // Mostramos los resultados
        System.out.println("\n=================================");
        System.out.println("          RESULTADOS");
        System.out.println("=================================");

        System.out.printf("Radio: %.2f%n", cilindro.getRadio());
        System.out.printf("Altura: %.2f%n", cilindro.getAltura());
        System.out.printf("Volumen: %.2f%n", volumen);
        System.out.printf("Area de superficie: %.2f%n", area);

        scanner.close();
    }
}