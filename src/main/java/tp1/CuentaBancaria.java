package src.main.java.tp1;

// Clase que representa una cuenta bancaria.

/*
 * Enunciado:
 *
 * Crear una clase CuentaBancaria con los atributos:
 *
 * - titular
 * - saldo
 * - tipoCuenta
 *
 * La cuenta puede ser de ahorro o corriente.
 *
 * Debe tener:
 *
 * - Constructor predeterminado.
 * - Constructor con argumentos.
 * - Metodo depositar().
 * - Metodo retirar().
 * - Metodo toString().
 */

public class CuentaBancaria {

    // Atributos privados para aplicar encapsulamiento.
    private String titular;
    private double saldo;
    private String tipoCuenta;

    // Constructor predeterminado.
    public CuentaBancaria() {

        this.titular = "Invitado";
        this.saldo = 0;
        this.tipoCuenta = "ahorro";
    }

    // Constructor con argumentos.
    public CuentaBancaria(
            String titular,
            double saldo,
            String tipoCuenta) {

        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    // Metodo para depositar dinero.
    public void depositar(double monto) {

        // El monto debe ser positivo.
        if (monto > 0) {

            this.saldo = this.saldo + monto;

            System.out.println(
                    "Deposito realizado correctamente.");

        } else {

            System.out.println(
                    "Error: el monto debe ser positivo.");
        }
    }

    // Metodo para retirar dinero.
    // Retorna true si la operacion fue exitosa.
    // Retorna false si no se pudo realizar.
    public boolean retirar(double monto) {

        if (monto <= 0) {

            System.out.println(
                    "Error: el monto debe ser positivo.");

            return false;
        }

        if (monto > this.saldo) {

            System.out.println(
                    "Error: saldo insuficiente.");

            return false;
        }

        this.saldo = this.saldo - monto;

        System.out.println(
                "Retiro realizado correctamente.");

        return true;
    }

    // Metodo toString().
    // Devuelve los datos de la cuenta.
    @Override
    public String toString() {

        return String.format(
                "Titular: %s%nTipo de cuenta: %s%nSaldo: $%.2f",
                this.titular,
                this.tipoCuenta,
                this.saldo);
    }
}