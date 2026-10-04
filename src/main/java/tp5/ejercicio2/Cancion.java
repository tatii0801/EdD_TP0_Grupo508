package tp5.ejercicio2;

public class Cancion {

    private String titulo;
    private String artista;
    private int anioLanzamiento;
    private int duracionSegundos;

    public Cancion(String titulo,
            String artista,
            int anioLanzamiento,
            int duracionSegundos) {

        this.titulo = titulo;
        this.artista = artista;
        this.anioLanzamiento = anioLanzamiento;
        this.duracionSegundos = duracionSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    @Override
    public String toString() {

        return titulo +
                " - " +
                artista +
                " (" +
                anioLanzamiento +
                ", " +
                duracionSegundos +
                " seg.)";
    }
}