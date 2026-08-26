package tp0;

// Programa que funciona como una calculadora de areas de figuras geometricas.

// Importamos Scanner para ingresar datos por teclado.
import java.util.Scanner;

/*
 * Enunciado del ejercicio:
 *
 * Desarrollar un programa que funcione como una calculadora
 * de figuras geometricas.
 *
 * El programa debe mostrar un menu con las siguientes opciones:
 *
 * 1. Area de Cuadrado
 * 2. Area de Triangulo
 * 3. Area de Circulo
 * 4. Salir
 *
 * El usuario debe seleccionar una opcion e ingresar los valores
 * necesarios para realizar el calculo.
 *
 * El menu debe volver a mostrarse despues de cada operacion
 * hasta seleccionar la opcion Salir.
 *
 * Si se ingresa un valor negativo para una dimension,
 * se debe mostrar un mensaje de error.
 */

public class ejercicio4 {

    // Metodo principal.
    public static void main(String[] args) {

        // Creamos el Scanner.
        Scanner scanner = new Scanner(System.in);

        // Declaracion de variables.
        int opcion;
        double lado;
        double base;
        double altura;
        double radio;
        double area;

        // Inicializamos la opcion.
        opcion = 0;

        // Repetimos el menu hasta elegir Salir.
        while (opcion != 4) {

            // Mostramos el menu.
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Area de Cuadrado");
            System.out.println("2. Area de Triangulo");
            System.out.println("3. Area de Circulo");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            // Analizamos la opcion seleccionada.
            switch (opcion) {

                case 1:

                    // Ingresamos el lado del cuadrado.
                    System.out.print("Ingrese el lado del cuadrado: ");
                    lado = scanner.nextDouble();

                    // Controlamos que no sea negativo.
                    while (lado < 0) {

                        System.out.println("Error: el lado no puede ser negativo.");

                        System.out.print("Ingrese nuevamente el lado: ");
                        lado = scanner.nextDouble();
                    }

                    // Calculamos el area del cuadrado.
                    area = lado * lado;

                    // Mostramos el resultado.
                    System.out.println("Area del cuadrado: " + area);
                    break;

                case 2:

                    // Ingresamos la base.
                    System.out.print("Ingrese la base del triangulo: ");
                    base = scanner.nextDouble();

                    // Controlamos que la base no sea negativa.
                    while (base < 0) {

                        System.out.println("Error: la base no puede ser negativa.");

                        System.out.print("Ingrese nuevamente la base: ");
                        base = scanner.nextDouble();
                    }

                    // Ingresamos la altura.
                    System.out.print("Ingrese la altura del triangulo: ");
                    altura = scanner.nextDouble();

                    // Controlamos que la altura no sea negativa.
                    while (altura < 0) {

                        System.out.println("Error: la altura no puede ser negativa.");

                        System.out.print("Ingrese nuevamente la altura: ");
                        altura = scanner.nextDouble();
                    }

                    // Calculamos el area del triangulo.
                    area = (base * altura) / 2;

                    // Mostramos el resultado.
                    System.out.println("Area del triangulo: " + area);
                    break;

                case 3:

                    // Ingresamos el radio.
                    System.out.print("Ingrese el radio del circulo: ");
                    radio = scanner.nextDouble();

                    // Controlamos que no sea negativo.
                    while (radio < 0) {

                        System.out.println("Error: el radio no puede ser negativo.");

                        System.out.print("Ingrese nuevamente el radio: ");
                        radio = scanner.nextDouble();
                    }

                    // Calculamos el area del circulo.
                    area = Math.PI * radio * radio;

                    // Mostramos el resultado.
                    System.out.println("Area del circulo: " + area);

                    break;

                case 4:

                    // Mensaje de salida.
                    System.out.println("Fin del programa.");

                    break;

                default:
                    // La opcion no existe.
                    System.out.println("Error: la opcion ingresada no existe.");
            }
        }

        // Cerramos el Scanner.
        scanner.close();
    }
}

/*
 * Preguntas sobre el problema
 * a) Un compañero propone usar una estructura anidada if-else if para ejecutar
 * las opciones del menú. Otro
 * propone usar un switch. ¿Cuál solución es más fácil de explicar y mantener
 * para este problema? ¿Qué
 * ventajas y desventajas tiene cada una?
 * Para este problema switch resulta más fácil de leer y mantener porque cada
 * opción del menú corresponde a un número determinado.
 * 
 * if-else if también puede utilizarse, pero para un menú puede resultar más
 * extenso.
 * 
 * 
 * b) ¿Qué sucede si el usuario ingresa una opción inexistente en el menú (ej.
 * la opción 9)? ¿Cómo debe
 * manejarlo el programa?
 * Si el usuario ingresa 9, se ejecuta default y se informa que la opción no
 * existe. Luego se vuelve a mostrar el menú.
 * 
 * c) Si quisiéramos agregar la opción "5. Perímetro de Cuadrado", ¿el diseño
 * modular actual facilita esta
 * extensión? ¿Qué cambios serían necesarios?
 * Sí, el diseño facilita agregar una nueva opción. Se agregaría un nuevo case,
 * por ejemplo:
 * 
 * case 5:
 * // Calcular perimetro del cuadrado
 * break;
 * 
 */