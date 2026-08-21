package tp1_by_Santy.classes;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String tipoCuenta; // "ahorro" o "corriente"

    // a) Constructor predeterminado
    public CuentaBancaria() {
        this.titular = "Invitado";
        this.saldo = 0.0;
        this.tipoCuenta = "ahorro";
    }

    // b) Constructor con argumentos
    public CuentaBancaria(String titular, double saldo, String tipoCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    // Getters y Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    // c) Método depositar con validación
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.printf("Depósito exitoso. Se añadieron $%.2f%n", monto);
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a cero.");
        }
    }

    // d) Método retirar con validación de fondos y retorno boolean
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor a cero.");
            return false;
        }

        if (monto > this.saldo) {
            System.out.println("Error: Saldo insuficiente. No se puede realizar la extracción.");
            return false;
        }

        this.saldo -= monto;
        System.out.printf("Retiro exitoso. Se extrajeron $%.2f%n", monto);
        return true;
    }

    // e) Método toString()
    @Override
    public String toString() {
        return String.format("Titular: %s | Tipo de Cuenta: %s | Saldo Actual: $%.2f", 
                titular, tipoCuenta, saldo);
    }
}