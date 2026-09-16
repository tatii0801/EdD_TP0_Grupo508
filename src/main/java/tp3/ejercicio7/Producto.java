package tp3.ejercicio7;

/*
 * ============================================================
 * CLASE PRODUCTO
 * ============================================================
 *
 * Atributos:
 * - id
 * - precio
 * ============================================================
 */

public class Producto {

    private String id;
    private double precio;

    /*
     * Constructor.
     */
    public Producto(
            String id,
            double precio) {

        this.id = id;
        this.precio = precio;
    }

    /*
     * Getter del ID.
     */
    public String getId() {

        return id;
    }

    /*
     * Getter del precio.
     */
    public double getPrecio() {

        return precio;
    }

    /*
     * Setter del precio.
     */
    public void setPrecio(double precio) {

        this.precio = precio;
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Precio: $" + precio;
    }
}