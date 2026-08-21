package tp1_by_Santy;


import java.util.InputMismatchException;
import java.util.Scanner;

import tp1_by_Santy.classes.CuentaBancaria;

/**
 * 2) Crear una clase llamada CuentaBancaria que modele una cuenta bancaria.
 * Esta clase debe contener los
 * siguientes atributos: titular, saldo y tipoCuenta (ahorro o corriente). La
 * clase CuentaBancaria debe
 * implementar:
 * a) Constructor predeterminado que inicializa el titular con "Invitado", saldo
 * en 0 y tipoCuenta en "ahorro".
 * b) Constructor con argumentos que permite establecer el titular, saldo
 * inicial y tipo de cuenta.
 * c) Un método depositar(double monto) que simule la adición de fondos a la
 * cuenta. Debe validar que el
 * monto sea positivo.
 * d) Un método retirar(double monto) que simule la extracción de dinero. Debe
 * disminuir el saldo y
 * retornar true si la operación es exitosa. Si el monto excede el saldo
 * disponible, no debe realizar la
 * extracción, debe mostrar un mensaje de error por consola y retornar false.
 * e) El método toString() que imprima en consola el titular, tipo de cuenta y
 * saldo actual formateado.
 * En el programa principal (main) se debe:
 * f) Crear una instancia de CuentaBancaria.
 * g) Inicializar la cuenta con algunos valores (ej. "Juan Perez", 50000.0,
 * "corriente").
 * h) Permitir al usuario, a través de un menú sencillo, realizar operaciones de
 * depósito o retiro para esta
 * cuenta, mostrando los detalles actualizados después de cada operación. El
 * menú debe repetirse hasta
 * que el usuario decida salir.
 * 
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
 * a) ¿Por qué es conveniente que el atributo saldo sea privado y no se pueda
 * modificar directamente
 * desde el método main (ej. cuenta.saldo = 1000000;)? ¿Qué garantiza el uso de
 * los métodos depositar y
 * retirar?
 * b) Un compañero propone que el método retirar sea de tipo void (sin retorno)
 * y que solo muestre un
 * mensaje de error si falla. Otro propone que retorne un boolean como pide el
 * enunciado. ¿Qué ventajas y
 * desventajas presenta cada alternativa? ¿Cuál solución permite que se tomen
 * mejores decisiones?
 * c) ¿Qué sucede si el usuario intenta retirar exactamente el mismo monto que
 * tiene de saldo
 * disponible? ¿Y si intenta depositar un monto negativo?
 * d) El banco ahora pide agregar un límite de descubierto para las cuentas
 * "corriente". Es decir, si es de
 * tipo corriente, el saldo puede llegar a ser negativo hasta un límite (ej.
 * -50000). ¿Qué método de la clase
 * debería modificar? y ¿qué nueva validación debería agregar?
 * 
 * respuestas:
 * 
 * a) Es conveniente que el atributo saldo sea privado para proteger la integridad de los 
 * datos y evitar modificaciones directas que puedan llevar a inconsistencias. El uso de los métodos 
 * depositar y retirar garantiza que las operaciones sobre el saldo se realicen de manera controlada, aplicando 
 * validaciones necesarias.
 * 
 * b) Si el método retirar es de tipo void, no se puede saber desde el main si la operación fue exitosa o no, lo que 
 * limita la capacidad de tomar decisiones basadas en el resultado. Retornar un boolean permite al main actuar según 
 * el éxito o fracaso de la operación, ofreciendo mayor control y flexibilidad.
 * 
 * c) Si el usuario intenta retirar exactamente el mismo monto que tiene de saldo disponible, la operación será exitosa 
 * y el saldo quedará en cero. Si intenta depositar un monto negativo, el método depositar rechazará la operación y mostrará 
 * un mensaje de error, manteniendo el saldo sin cambios.
 * 
 * d) Para agregar un límite de descubierto para las cuentas "corriente", se debería modificar el método retirar y se debería agregar 
 * una validación que permita que el saldo llegue a un valor negativo hasta el límite establecido (ej. -50000) solo si la cuenta 
 * es de tipo corriente. Esto implicaría verificar el tipo de cuenta antes de permitir la operación de retiro.
 * 
 */


public class ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // f) y g) Instancia de CuentaBancaria con valores iniciales
        CuentaBancaria cuenta = new CuentaBancaria("Juan Perez", 50000.0, "corriente");

        System.out.println("=== BIENVENIDO AL SISTEMA BANCARIO ===");
        System.out.println(cuenta);

        // h) Menú interactivo repetitivo
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcionEntera(scanner, 1, 3);

            switch (opcion) {
                case 1:
                    double deposito = leerMontoPositivo(scanner, "Ingrese el monto a depositar: ");
                    cuenta.depositar(deposito);
                    System.out.println("Estado actualizado: " + cuenta);
                    break;

                case 2:
                    double retiro = leerMontoPositivo(scanner, "Ingrese el monto a retirar: ");
                    cuenta.retirar(retiro);
                    System.out.println("Estado actualizado: " + cuenta);
                    break;

                case 3:
                    System.out.println("Gracias por utilizar nuestros servicios. ¡Hasta luego!");
                    salir = true;
                    break;
            }
            System.out.println("----------------------------------------");
        }
    }

    // Muestra las opciones del menú
    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Depositar fondos");
        System.out.println("2. Retirar fondos");
        System.out.println("3. Salir");
    }

    // Método modularizado para leer enteros dentro de un rango
    private static int leerOpcionEntera(Scanner scanner, int min, int max) {
        int opcion = -1;
        boolean valida = false;

        while (!valida) {
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                if (opcion >= min && opcion <= max) {
                    valida = true;
                } else {
                    System.out.println("Error: Seleccione una opción entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); // Limpieza de buffer
            }
        }
        return opcion;
    }

    // Método modularizado para solicitar montos decimales positivos
    private static double leerMontoPositivo(Scanner scanner, String mensaje) {
        double monto = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                monto = scanner.nextDouble();

                if (monto > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El monto debe ser estrictamente positivo (mayor a cero).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido (ej. 1500.50).");
                scanner.nextLine(); // Limpieza de buffer
            }
        }
        return monto;
    }
}