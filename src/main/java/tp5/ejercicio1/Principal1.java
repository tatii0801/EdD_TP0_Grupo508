package tp5.ejercicio1;

import tp5.Base_Profesor.Helper;
import tp5.Base_Profesor.SimpleLinkedList;

public class Principal1 {

    public static void main(String[] args) {

        /*
         * =====================================================
         * EJERCICIO 1
         * =====================================================
         *
         * Crear una lista de productos.
         *
         * Agregar y eliminar productos en una posicion indicada
         * por el usuario.
         */

        SimpleLinkedList<Producto> productos =
                new SimpleLinkedList<>();

        // Cargamos algunos productos.
        productos.addLast(
                new Producto(1, "Mouse", 5000, 10));

        productos.addLast(
                new Producto(2, "Teclado", 8000, 5));

        productos.addLast(
                new Producto(3, "Monitor", 90000, 3));

        productos.addLast(
                new Producto(4, "Auriculares", 15000, 8));

        System.out.println("=================================");
        System.out.println("        EJERCICIO 1");
        System.out.println("=================================");

        System.out.println("\nLista inicial:");

        System.out.println(productos);

        // -----------------------------------------------------
        // AGREGAR
        // -----------------------------------------------------

        int posicionAgregar =
                Helper.getInteger(
                        "\nIngrese posicion para agregar: ");

        Producto nuevo =
                new Producto(
                        5,
                        "Webcam",
                        20000,
                        4);

        try {

            productos.agregarEnPosicion(
                    nuevo,
                    posicionAgregar);

            System.out.println(
                    "\nLista despues de agregar:");

            System.out.println(productos);

        } catch (IndexOutOfBoundsException e) {

            System.out.println(
                    "La posicion no es valida.");
        }

        // -----------------------------------------------------
        // ELIMINAR
        // -----------------------------------------------------

        int posicionEliminar =
                Helper.getInteger(
                        "\nIngrese posicion para eliminar: ");

        try {

            Producto eliminado =
                    productos.eliminarEnPosicion(
                            posicionEliminar);

            System.out.println(
                    "\nProducto eliminado:");

            System.out.println(eliminado);

            System.out.println(
                    "\nLista despues de eliminar:");

            System.out.println(productos);

        } catch (IndexOutOfBoundsException e) {

            System.out.println(
                    "La posicion no es valida.");
        }
    }

    /*
     * =========================================================
     * PREGUNTAS DEL EJERCICIO 1
     * =========================================================
     *
     * a) ¿Por que hay que recorrer nodo por nodo?
     *
     * Porque la lista enlazada no tiene posiciones directas como
     * un array.
     *
     * Para llegar a una posicion tenemos que avanzar por los
     * enlaces de los nodos.
     *
     *
     * b) ¿Que pasa si insertamos en posicion 0?
     *
     * Se agrega al principio utilizando addFirst().
     *
     * Si la lista estaba vacia, ese nodo pasa a ser head y tail.
     *
     * ¿Y si queremos eliminar en una posicion igual al tamaño?
     *
     * Esa posicion no existe porque la ultima posicion es
     * tamaño - 1.
     *
     *
     * c) Lista A, B, C.
     *
     * Insertamos D en posicion 1.
     *
     * Resultado:
     *
     * A -> D -> B -> C
     *
     * A apunta a D.
     *
     * D apunta a B.
     *
     *
     * d) ¿Por que guardamos temporalmente el siguiente nodo?
     *
     * Porque necesitamos conservar la referencia al resto de
     * la lista antes de cambiar los enlaces.
     */
}