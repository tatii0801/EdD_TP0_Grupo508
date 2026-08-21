package tp1_by_Santy.classes;

// ==========================================
// Clase Cilindro (Representación Geométrica)
// ==========================================
public class Cilindro {
    private double radio;
    private double altura;

    // a) Constructor predeterminado (inicializa en 1.0)
    public Cilindro() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    // b) Constructor con argumentos
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    // Getters y Setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // c) Método para calcular el volumen: π * r² * h
    public double calcularVolumen() {
        return Math.PI * Math.pow(this.radio, 2) * this.altura;
    }

    // d) Método para calcular el área total: 2 * π * r * (r + h)
    public double calcularAreaSuperficie() {
        return 2 * Math.PI * this.radio * (this.radio + this.altura);
    }
}