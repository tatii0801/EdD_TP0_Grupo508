package tp1;

// Clase que representa un tanque de agua.

/*
 * Enunciado:
 *
 * Diseñar una clase TanqueAgua con:
 *
 * - capacidadMaxima
 * - cantidadActual
 *
 * El constructor predeterminado debe establecer:
 *
 * capacidadMaxima = 100
 * cantidadActual = 0
 *
 * El constructor parametrizado recibe ambos valores.
 *
 * Si la cantidad actual supera la capacidad maxima,
 * debe ajustarse a la capacidad maxima.
 *
 * agregarAgua() debe sumar agua sin superar la capacidad.
 *
 * retirarAgua() debe retirar agua sin que la cantidad
 * actual sea menor que cero.
 */

public class TanqueAgua {

    // Atributos privados.
    private double capacidadMaxima;
    private double cantidadActual;

    // Constructor predeterminado.
    public TanqueAgua() {

        this.capacidadMaxima = 100;
        this.cantidadActual = 0;
    }

    // Constructor parametrizado.
    public TanqueAgua(
            double capacidadMaxima,
            double cantidadActual) {

        this.capacidadMaxima = capacidadMaxima;

        // Verificamos que la cantidad actual
        // no supere la capacidad maxima.

        if (cantidadActual > capacidadMaxima) {

            this.cantidadActual = capacidadMaxima;

        } else if (cantidadActual < 0) {

            this.cantidadActual = 0;

        } else {

            this.cantidadActual = cantidadActual;
        }
    }

    // Metodo para agregar agua.
    public void agregarAgua(double litros) {

        // Solo aceptamos cantidades positivas.
        if (litros > 0) {

            this.cantidadActual = this.cantidadActual + litros;

            // Si se supera la capacidad,
            // el tanque queda lleno.
            if (this.cantidadActual > this.capacidadMaxima) {

                this.cantidadActual = this.capacidadMaxima;

                System.out.println(
                        "Advertencia: se excedio la capacidad. "
                                + "El tanque quedo lleno.");
            }
        }
    }

    // Metodo para retirar agua.
    public void retirarAgua(double litros) {

        // Solo aceptamos cantidades positivas.
        if (litros > 0) {

            this.cantidadActual = this.cantidadActual - litros;

            // Si queda un valor negativo,
            // el tanque queda en 0.
            if (this.cantidadActual < 0) {

                this.cantidadActual = 0;
            }
        }
    }

    // Metodo para mostrar el estado del tanque.
    public void mostrarEstado() {

        System.out.println(
                "Cantidad actual: "
                        + this.cantidadActual
                        + " litros");

        System.out.println(
                "Capacidad maxima: "
                        + this.capacidadMaxima
                        + " litros");
    }
}