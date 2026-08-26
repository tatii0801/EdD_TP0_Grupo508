package tp1;

public class Cilindro1 {

    // Atributos privados para aplicar encapsulamiento
    private double radio;
    private double altura;

    // Constructor predeterminado
    // Inicializa el radio y la altura en 1.0
    public Cilindro1() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    // Constructor con argumentos
    public Cilindro1(double radio, double altura) {

        // Validamos que el radio sea mayor que cero
        if (radio <= 0) {
            throw new IllegalArgumentException(
                    "El radio debe ser mayor que cero.");
        }

        // Validamos que la altura sea mayor que cero
        if (altura <= 0) {
            throw new IllegalArgumentException(
                    "La altura debe ser mayor que cero.");
        }

        this.radio = radio;
        this.altura = altura;
    }

    // Método para establecer el radio
    public void setRadio(double radio) {

        if (radio <= 0) {
            throw new IllegalArgumentException(
                    "El radio debe ser mayor que cero.");
        }

        this.radio = radio;
    }

    // Método para establecer la altura
    public void setAltura(double altura) {

        if (altura <= 0) {
            throw new IllegalArgumentException(
                    "La altura debe ser mayor que cero.");
        }

        this.altura = altura;
    }

    // Método para obtener el radio
    public double getRadio() {
        return radio;
    }

    // Método para obtener la altura
    public double getAltura() {
        return altura;
    }

    // Calcula y devuelve el volumen del cilindro
    // Fórmula: PI * radio^2 * altura
    public double calcularVolumen() {
        return Math.PI * radio * radio * altura;
    }

    // Calcula y devuelve el área de la superficie total
    // Fórmula: 2 * PI * radio * (radio + altura)
    public double calcularAreaSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}