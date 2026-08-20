package src.main.java.tp1;

// Programa principal para realizar operaciones bancarias.

import java.util.Scanner;

/*
 * Enunciado:
 *
 * Crear una instancia de CuentaBancaria.
 *
 * Inicializarla con:
 * titular: Juan Perez
 * saldo: 50000
 * tipo: corriente
 *
 * Permitir mediante un menu realizar depositos y retiros.
 * El menu debe repetirse hasta seleccionar salir.
 */

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creamos la cuenta bancaria.
        CuentaBancaria cuenta = new CuentaBancaria(
                "Juan Perez",
                50000.0,
                "corriente");

        int opcion;
        double monto;

        do {

            System.out.println("\n===== CUENTA BANCARIA =====");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Mostrar cuenta");
            System.out.println("4. Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print(
                            "Ingrese el monto a depositar: ");

                    monto = scanner.nextDouble();

                    cuenta.depositar(monto);

                    System.out.println(cuenta);

                    break;

                case 2:

                    System.out.print(
                            "Ingrese el monto a retirar: ");

                    monto = scanner.nextDouble();

                    cuenta.retirar(monto);

                    System.out.println(cuenta);

                    break;

                case 3:

                    System.out.println(cuenta);

                    break;

                case 4:

                    System.out.println(
                            "Programa finalizado.");

                    break;

                default:

                    System.out.println(
                            "Error: opcion inexistente.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}

/*
 * Preguntas sobre el problema
 * a) ¿Por qué es conveniente que el atributo saldo sea privado y no se pueda
 * modificar directamente
 * desde el método main (ej. cuenta.saldo = 1000000;)? ¿Qué garantiza el uso de
 * los métodos depositar y
 * retirar?
 * saldo debe ser privado para evitar que desde main se pueda modificar
 * directamente. Los métodos depositar() y retirar() permiten controlar las
 * operaciones y validar los montos.
 * 
 * b) Un compañero propone que el método retirar sea de tipo void (sin retorno)
 * y que solo muestre un
 * mensaje de error si falla. Otro propone que retorne un boolean como pide el
 * enunciado. ¿Qué ventajas y
 * desventajas presenta cada alternativa? ¿Cuál solución permite que se tomen
 * mejores decisiones?
 * Un método void solamente informa si ocurrió un problema. En cambio, boolean
 * permite que el programa que llama al método sepa si la operación fue exitosa
 * y pueda tomar decisiones. Para este ejercicio, boolean es mejor porque es lo
 * solicitado.
 * 
 * c) ¿Qué sucede si el usuario intenta retirar exactamente el mismo monto que
 * tiene de saldo
 * disponible? ¿Y si intenta depositar un monto negativo?
 * Si se retira exactamente el saldo disponible, la operación es válida y el
 * saldo queda en 0. Si se intenta depositar un monto negativo, el depósito es
 * rechazado.
 * 
 * d) El banco ahora pide agregar un límite de descubierto para las cuentas
 * "corriente". Es decir, si es de
 * tipo corriente, el saldo puede llegar a ser negativo hasta un límite (ej.
 * -50000). ¿Qué método de la clase
 * debería modificar? y ¿qué nueva validación debería agregar?
 * Se debería modificar retirar(). Para una cuenta corriente se debería permitir
 * retirar dinero hasta el límite establecido, por ejemplo -50000.
 */