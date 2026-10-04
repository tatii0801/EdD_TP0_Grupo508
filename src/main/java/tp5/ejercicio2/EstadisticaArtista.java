package tp5.ejercicio2;

public class EstadisticaArtista
        implements Comparable<EstadisticaArtista> {

    private String nombreArtista;
    private int totalReproducciones;

    public EstadisticaArtista(
            String nombreArtista,
            int totalReproducciones) {

        this.nombreArtista = nombreArtista;
        this.totalReproducciones = totalReproducciones;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(
            int totalReproducciones) {

        this.totalReproducciones = totalReproducciones;
    }

    @Override
    public int compareTo(
            EstadisticaArtista otra) {

        // Mayor cantidad de segundos primero.
        return Integer.compare(
                otra.totalReproducciones,
                this.totalReproducciones);
    }

    @Override
    public String toString() {

        return nombreArtista +
                " -> " +
                totalReproducciones +
                " segundos";
    }
}
