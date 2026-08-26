package tp1;

// Programa principal que permite crear y mostrar objetos Libro.

/*
 * Enunciado:
 *
 * Escribir el codigo necesario para crear y mostrar objetos
 * del tipo Libro.
 *
 * El libro cuenta con los siguientes atributos:
 *
 * - Titulo
 * - Autor
 * - Editorial
 * - Año de Publicacion
 * - Precio
 */

public class Principal {

    // Metodo principal del programa.
    public static void main(String[] args) {

        // ==========================================
        // CREACION DE OBJETOS
        // ==========================================

        // Creamos un objeto Libro utilizando el constructor vacio.
        Libro libro1 = new Libro();

        // Utilizamos los setters para asignar valores
        // a los atributos del objeto libro1.

        libro1.setTitulo("El Principito");
        libro1.setAutor("Antoine de Saint-Exupery");
        libro1.setEditorial("Salamandra");
        libro1.setAñoDePublicacion("1943");
        libro1.setPrecio(15000.0f);

        // Creamos otro objeto Libro utilizando
        // el constructor con parametros.

        Libro libro2 = new Libro(
                "Harry Potter y la piedra filosofal",
                "J. K. Rowling",
                "Salamandra",
                "1997",
                25000.0f);

        // ==========================================
        // MOSTRAR LOS OBJETOS
        // ==========================================

        // Mostramos los datos del primer libro.
        System.out.println("========== LIBRO 1 ==========");

        System.out.println("Titulo: " + libro1.getTitulo());

        System.out.println("Autor: " + libro1.getAutor());

        System.out.println("Editorial: " + libro1.getEditorial());

        System.out.println("Anio de publicacion: " + libro1.getAñoDePublicacion());

        System.out.println("Precio: $" + libro1.getPrecio());

        // Mostramos los datos del segundo libro.
        System.out.println("\n========== LIBRO 2 ==========");

        System.out.println("Titulo: " + libro2.getTitulo());

        System.out.println("Autor: " + libro2.getAutor());

        System.out.println("Editorial: " + libro2.getEditorial());

        System.out.println("Anio de publicacion: " + libro2.getAñoDePublicacion());

        System.out.println("Precio: $" + libro2.getPrecio());

        // ==========================================
        // MOSTRAR EL OBJETO COMPLETO
        // ==========================================

        // Al colocar el objeto dentro de println,
        // Java utiliza automaticamente el metodo toString().
        System.out.println("\n========== OBJETOS COMPLETOS ==========");

        System.out.println(libro1);
        System.out.println(libro2);
    }
}