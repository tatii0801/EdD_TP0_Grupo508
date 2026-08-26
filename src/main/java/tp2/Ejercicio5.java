// Programa que simula una biblioteca personal.

package tp2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ENUNCIADO:
 *
 * Crear un programa que simule una biblioteca personal.
 *
 * Crear la clase Libro con los atributos:
 *
 * - isbn
 * - titulo
 * - autor
 * - anioPublicacion
 *
 * El usuario puede guardar cualquier cantidad de libros.
 *
 * El programa debe permitir:
 *
 * a) Agregar nuevos libros.
 *    El ISBN no puede repetirse.
 *
 * b) Buscar un libro por título o ISBN.
 *
 * c) Modificar autor o año de publicación mediante ISBN.
 *
 * d) Eliminar un libro mediante ISBN.
 */

// Clase Libro.
class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    // Constructor.
    public Libro(
            String isbn,
            String titulo,
            String autor,
            int anioPublicacion) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters.
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    // Setter para modificar el autor.
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Setter para modificar el año.
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    // Método toString para mostrar toda la información.
    @Override
    public String toString() {

        return "ISBN: " + isbn
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Año: " + anioPublicacion;
    }
}

// Clase principal.
public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ArrayList permite almacenar cualquier cantidad de libros.
        ArrayList<Libro> biblioteca = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("       BIBLIOTECA PERSONAL");
            System.out.println("==============================");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Modificar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Salir");
            System.out.println("==============================");

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {

                case 1:

                    agregarLibro(biblioteca, scanner);
                    break;

                case 2:

                    buscarLibro(biblioteca, scanner);
                    break;

                case 3:

                    modificarLibro(biblioteca, scanner);
                    break;

                case 4:

                    eliminarLibro(biblioteca, scanner);
                    break;

                case 5:

                    mostrarLibros(biblioteca);
                    break;

                case 6:

                    System.out.println(
                            "Saliendo de la biblioteca...");
                    break;

                default:

                    System.out.println(
                            "Opción inválida.");
            }

        } while (opcion != 6);

        scanner.close();
    }

    // Agrega un libro a la biblioteca.
    public static void agregarLibro(
            ArrayList<Libro> biblioteca,
            Scanner scanner) {

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        // Primero verificamos que el ISBN no exista.
        if (buscarPorISBN(biblioteca, isbn) != null) {

            System.out.println(
                    "Error: el ISBN ya existe.");

            return;
        }

        System.out.print("Ingrese título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ingrese año de publicación: ");
        int anio = scanner.nextInt();

        scanner.nextLine();

        // Creamos el objeto Libro.
        Libro libro = new Libro(
                isbn,
                titulo,
                autor,
                anio);

        // Agregamos el objeto al ArrayList.
        biblioteca.add(libro);

        System.out.println(
                "Libro agregado correctamente.");
    }

    // Busca un libro por ISBN o título.
    public static void buscarLibro(
            ArrayList<Libro> biblioteca,
            Scanner scanner) {

        System.out.print(
                "Ingrese ISBN o título a buscar: ");

        String dato = scanner.nextLine();

        boolean encontrado = false;

        for (Libro libro : biblioteca) {

            if (libro.getIsbn().equalsIgnoreCase(dato)
                    || libro.getTitulo().equalsIgnoreCase(dato)) {

                System.out.println("\nLibro encontrado:");
                System.out.println(libro);

                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println(
                    "No se encontró ningún libro.");
        }
    }

    // Modifica el autor o año de un libro.
    public static void modificarLibro(
            ArrayList<Libro> biblioteca,
            Scanner scanner) {

        System.out.print(
                "Ingrese ISBN del libro a modificar: ");

        String isbn = scanner.nextLine();

        Libro libro = buscarPorISBN(biblioteca, isbn);

        if (libro == null) {

            System.out.println(
                    "No existe un libro con ese ISBN.");

            return;
        }

        System.out.println("1. Modificar autor");
        System.out.println("2. Modificar año");

        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        scanner.nextLine();

        if (opcion == 1) {

            System.out.print("Nuevo autor: ");
            String nuevoAutor = scanner.nextLine();

            libro.setAutor(nuevoAutor);

            System.out.println(
                    "Autor modificado correctamente.");

        } else if (opcion == 2) {

            System.out.print("Nuevo año: ");
            int nuevoAnio = scanner.nextInt();

            scanner.nextLine();

            libro.setAnioPublicacion(nuevoAnio);

            System.out.println(
                    "Año modificado correctamente.");

        } else {

            System.out.println(
                    "Opción inválida.");
        }
    }

    // Elimina un libro por ISBN.
    public static void eliminarLibro(
            ArrayList<Libro> biblioteca,
            Scanner scanner) {

        System.out.print(
                "Ingrese ISBN del libro a eliminar: ");

        String isbn = scanner.nextLine();

        Libro libro = buscarPorISBN(biblioteca, isbn);

        if (libro == null) {

            System.out.println(
                    "No existe un libro con ese ISBN.");

            return;
        }

        biblioteca.remove(libro);

        System.out.println(
                "Libro eliminado correctamente.");
    }

    // Busca un libro por ISBN.
    public static Libro buscarPorISBN(
            ArrayList<Libro> biblioteca,
            String isbn) {

        for (Libro libro : biblioteca) {

            if (libro.getIsbn().equalsIgnoreCase(isbn)) {

                return libro;
            }
        }

        return null;
    }

    // Muestra todos los libros.
    public static void mostrarLibros(
            ArrayList<Libro> biblioteca) {

        if (biblioteca.isEmpty()) {

            System.out.println(
                    "La biblioteca está vacía.");

            return;
        }

        System.out.println("\nLIBROS:");

        for (Libro libro : biblioteca) {

            System.out.println(libro);
        }
    }
}

/*
 * Lo importante de este ejercicio
 * 
 * Acá aparece algo fundamental de Arreglos dinámicos:
 * 
 * ArrayList<Libro> biblioteca = new ArrayList<>();
 * 
 * A diferencia de:
 * 
 * Libro[] biblioteca = new Libro[1000];
 * 
 * el ArrayList puede crecer y disminuir según la cantidad de libros.
 */