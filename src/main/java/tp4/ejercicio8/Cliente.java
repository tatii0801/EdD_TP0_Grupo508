package tp4.ejercicio8;

/*
 * ============================================================
 * CLASE CLIENTE
 * ============================================================
 *
 * Atributos:
 *
 * - nombre
 * - edad
 *
 * ============================================================
 */

public class Cliente {

    private String nombre;

    private int edad;

    public Cliente(
            String nombre,
            int edad) {

        this.nombre =
                nombre;

        this.edad =
                edad;
    }

    public String getNombre() {

        return nombre;
    }

    public int getEdad() {

        return edad;
    }

    @Override
    public String toString() {

        return "Nombre: "
                + nombre
                + " | Edad: "
                + edad;
    }
}