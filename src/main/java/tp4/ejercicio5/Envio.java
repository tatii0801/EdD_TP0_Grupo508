package tp4.ejercicio5;

/*
 * Clase que representa un envío.
 */

public class Envio {

    private String codigoSeguimiento;
    private double peso;
    private String destino;
    private String estado;

    // Constructor
    public Envio(
            String codigoSeguimiento,
            double peso,
            String destino,
            String estado) {

        this.codigoSeguimiento = codigoSeguimiento;
        this.peso = peso;
        this.destino = destino;
        this.estado = estado;
    }

    // Getter del código
    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    // Getter del peso
    public double getPeso() {
        return peso;
    }

    // Getter del destino
    public String getDestino() {
        return destino;
    }

    // Getter del estado
    public String getEstado() {
        return estado;
    }

    // Muestra los datos del envío
    @Override
    public String toString() {

        return "Código: " + codigoSeguimiento
                + " | Peso: " + peso + " kg"
                + " | Destino: " + destino
                + " | Estado: " + estado;
    }
}