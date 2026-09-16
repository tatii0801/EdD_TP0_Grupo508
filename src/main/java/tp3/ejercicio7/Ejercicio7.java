package tp3.ejercicio7;

import tp3.ejemplo.implementaciones.StackGenerica;

/*
 * ============================================================
 * EJERCICIO 7 - DESCUENTO EN PRODUCTOS
 * ============================================================
 *
 * Se debe desarrollar un método que reciba:
 *
 * - Una pila de objetos Producto.
 * - Un String que representa un ID buscado.
 *
 * El método debe buscar el producto cuyo ID coincida
 * y aplicar un descuento del 10% sobre su precio.
 *
 * La pila debe conservar el mismo orden.
 *
 * Si el producto no existe, no se realiza ninguna modificación.
 * ============================================================
 */

public class Ejercicio7 {

    public static void main(String[] args) {

        StackGenerica<Producto> pila = new StackGenerica<>();

        /*
         * Cargamos productos.
         */
        pila.push(
                new Producto("P001", 10000));

        pila.push(
                new Producto("P002", 20000));

        pila.push(
                new Producto("P003", 30000));

        pila.push(
                new Producto("P004", 40000));

        System.out.println("======================================");
        System.out.println("       EJERCICIO 7 - PRODUCTOS");
        System.out.println("======================================");

        System.out.println("\nPila original:");
        mostrarPila(pila);

        /*
         * Aplicamos el descuento al producto P002.
         */
        aplicarDescuento(pila, "P002");

        System.out.println(
                "\nPila después del descuento:");

        mostrarPila(pila);
    }

    /*
     * ========================================================
     * MÉTODO aplicarDescuento
     * ========================================================
     *
     * Recorre toda la pila.
     *
     * Cuando encuentra el ID buscado:
     *
     * precio = precio * 0.90
     *
     * Esto significa que se conserva el 90% del precio,
     * es decir, se aplica un descuento del 10%.
     * ========================================================
     */
    public static void aplicarDescuento(
            StackGenerica<Producto> pila,
            String idBuscado) {

        StackGenerica<Producto> auxiliar = new StackGenerica<>();

        /*
         * Recorremos toda la pila.
         */
        while (!pila.isEmpty()) {

            Producto producto = pila.pop();

            /*
             * Para comparar Strings utilizamos equals()
             * y no ==.
             */
            if (producto.getId().equals(idBuscado)) {

                /*
                 * Calculamos el nuevo precio.
                 */
                double nuevoPrecio = producto.getPrecio() * 0.90;

                /*
                 * Modificamos el objeto Producto.
                 */
                producto.setPrecio(nuevoPrecio);
            }

            /*
             * Guardamos el producto en la pila auxiliar.
             */
            auxiliar.push(producto);
        }

        /*
         * Restauramos TODA la pila original.
         *
         * Esto es importante porque la solución propuesta
         * solamente hacía un push(aux.pop()), por lo que
         * dejaba elementos afuera.
         */
        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }

    /*
     * Muestra la pila sin modificarla.
     */
    public static void mostrarPila(
            StackGenerica<Producto> pila) {

        StackGenerica<Producto> auxiliar = new StackGenerica<>();

        while (!pila.isEmpty()) {

            Producto producto = pila.pop();

            System.out.println(producto);

            auxiliar.push(producto);
        }

        while (!auxiliar.isEmpty()) {

            pila.push(auxiliar.pop());
        }
    }
}

/*
 * Análisis del ejercicio 7
 * Error 1: comparar String con ==
 * 
 * La solución propuesta utiliza:
 * 
 * if (p.id == idBuscado)
 * 
 * Esto es incorrecto para comparar el contenido de dos String.
 * 
 * Debe utilizarse:
 * 
 * if (producto.getId().equals(idBuscado))
 * Error 2: falta de encapsulamiento
 * 
 * La solución tiene:
 * 
 * String id;
 * double precio;
 * 
 * sin private.
 * 
 * Es mejor:
 * 
 * private String id;
 * private double precio;
 * 
 * y acceder mediante métodos:
 * 
 * getId()
 * getPrecio()
 * setPrecio()
 * 
 * Esto respeta el encapsulamiento.
 * 
 * Error 3: no restaura toda la pila
 * 
 * La solución propuesta termina con:
 * 
 * pila.push(aux.pop());
 * 
 * Esto solamente devuelve un elemento desde la pila auxiliar.
 * 
 * Debería utilizar:
 * 
 * while (!aux.isEmpty()) {
 * pila.push(aux.pop());
 * }
 * 
 * Así se restauran todos los elementos.
 */