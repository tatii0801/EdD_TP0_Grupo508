package tp1;

// Clase que representa la bateria de un dispositivo.

/*
 * La bateria tiene una carga entre 0 y 100.
 *
 * Debe permitir:
 *
 * - Cargar bateria sin superar 100.
 * - Consumir bateria sin bajar de 0.
 */

public class Bateria {

    // El atributo es privado para aplicar encapsulamiento.
    private int carga;

    // Constructor.
    public Bateria(int cargaInicial) {

        // Si la carga es menor que 0,
        // se establece en 0.
        if (cargaInicial < 0) {
            cargaInicial = 0;
        }

        // Si la carga supera 100,
        // se establece en 100.
        if (cargaInicial > 100) {
            cargaInicial = 100;
        }

        this.carga = cargaInicial;
    }

    // Metodo para cargar la bateria.
    public void cargar(int cantidad) {

        if (cantidad > 0) {

            this.carga += cantidad;

            // La carga nunca puede superar 100.
            if (this.carga > 100) {
                this.carga = 100;
            }
        }
    }

    // Metodo para consumir bateria.
    public void consumir(int cantidad) {

        if (cantidad > 0) {

            this.carga -= cantidad;

            // La carga nunca puede ser menor que 0.
            if (this.carga < 0) {
                this.carga = 0;
            }
        }
    }

    // Getter de la carga.
    public int getCarga() {
        return this.carga;
    }
}
