package tp1;

// Clase que representa un libro.

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

// Clase Libro.
public class Libro {

    // Declaracion de los atributos de la clase.
    // Los atributos se declaran como private para proteger
    // los datos de la clase.

    private String titulo;
    private String autor;
    private String editorial;
    private String añoDePublicacion;
    private float precio;

    // Constructor vacio.
    // Permite crear un objeto Libro sin pasar datos.
    public Libro() {

    }

    // Constructor con parametros.
    // Permite crear un objeto Libro pasando todos sus datos.
    public Libro(
        String titulo,
        String autor,
        String editorial,
        String añoDePublicacion,
        float precio
    ) {

        // Asignamos los valores recibidos a los atributos
        // correspondientes del objeto.

        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.añoDePublicacion = añoDePublicacion;
        this.precio = precio;
    }

    // Getter del atributo titulo.
    // Permite obtener el titulo del libro.
    public String getTitulo() {
        return this.titulo;
    }

    // Setter del atributo titulo.
    // Permite modificar el titulo del libro.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter del atributo autor.
    public String getAutor() {
        return this.autor;
    }

    // Setter del atributo autor.
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Getter del atributo editorial.
    public String getEditorial() {
        return this.editorial;
    }

    // Setter del atributo editorial.
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // Getter del año de publicacion.
    public String getAñoDePublicacion() {
        return this.añoDePublicacion;
    }

    // Setter del año de publicacion.
    public void setAñoDePublicacion(String añoDePublicacion) {
        this.añoDePublicacion = añoDePublicacion;
    }

    // Getter del precio.
    public float getPrecio() {
        return this.precio;
    }

    // Setter del precio.
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Metodo toString.
    // Permite mostrar todos los atributos del objeto.
    @Override
    public String toString() {

        return "Libro [" +
               "titulo=" + titulo +
               ", autor=" + autor +
               ", editorial=" + editorial +
               ", añoDePublicacion=" + añoDePublicacion +
               ", precio=" + precio +
               "]";
    }
}
