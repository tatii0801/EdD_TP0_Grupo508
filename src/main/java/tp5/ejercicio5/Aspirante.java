package tp5.ejercicio5;

/*
 * EJERCICIO 5 - LISTA
 *
 * Consigna:
 * Crear la clase Aspirante con:
 * - dni
 * - nombre
 * - apellido
 * - notaEscrito
 * - notaOral
 * - notaPractico
 */

public class Aspirante {

    private int dni;
    private String nombre;
    private String apellido;
    private double notaEscrito;
    private double notaOral;
    private double notaPractico;

    public Aspirante(int dni, String nombre, String apellido,
            double notaEscrito, double notaOral,
            double notaPractico) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notaEscrito = notaEscrito;
        this.notaOral = notaOral;
        this.notaPractico = notaPractico;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNotaEscrito() {
        return notaEscrito;
    }

    public double getNotaOral() {
        return notaOral;
    }

    public double getNotaPractico() {
        return notaPractico;
    }

    /*
     * Calcula el promedio de las tres notas.
     */
    public double promedio() {

        return (notaEscrito +
                notaOral +
                notaPractico) / 3;
    }

    @Override
    public String toString() {

        return "DNI: " + dni +
                " | Nombre: " + nombre +
                " " + apellido +
                " | Escrito: " + notaEscrito +
                " | Oral: " + notaOral +
                " | Practico: " + notaPractico +
                " | Promedio: " + promedio();
    }
}
