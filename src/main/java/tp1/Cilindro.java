package tp1;

// Clase que representa un cilindro.

/*
 * Enunciado del ejercicio:
 *
 * Diseñar una clase llamada Cilindro que representa una figura
 * geometrica tridimensional.
 *
 * La clase debe tener los atributos radio y altura.
 *
 * La clase Cilindro debe incluir:
 *
 * a) Constructor predeterminado que inicialice ambos valores en 1.0.
 *
 * b) Un constructor con argumentos para establecer el radio y la altura.
 *
 * c) Un metodo que devuelva el volumen del cilindro.
 *
 * Formula:
 * volumen = PI * radio^2 * altura
 *
 * d) Un metodo que devuelva el area de la superficie total.
 *
 * Formula:
 * area = 2 * PI * radio * (radio + altura)
 */

// Clase Cilindro.
public class Cilindro {

    // Atributos privados de la clase.
    // Se utiliza private para aplicar encapsulamiento.

    private double radio;
    private double altura;

    // Constructor predeterminado.
    // Inicializa el radio y la altura en 1.0.
    public Cilindro() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    // Constructor con argumentos.
    public Cilindro(double radio, double altura) {

        // Utilizamos los setters para garantizar
        // que los valores sean positivos.
        setRadio(radio);
        setAltura(altura);
    }

    // Getter del radio.
    public double getRadio() {
        return this.radio;
    }

    // Setter del radio.
    // Solo permite valores mayores a cero.
    public void setRadio(double radio) {

        if (radio > 0) {
            this.radio = radio;
        } else {
            System.out.println("Error: el radio debe ser mayor a cero.");
        }
    }

    // Getter de la altura.
    public double getAltura() {
        return this.altura;
    }

    // Setter de la altura.
    // Solo permite valores mayores a cero.
    public void setAltura(double altura) {

        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Error: la altura debe ser mayor a cero.");
        }
    }

    // Metodo que calcula y devuelve el volumen del cilindro.
    public double calcularVolumen() {

        return Math.PI * Math.pow(this.radio, 2) * this.altura;
    }

    // Metodo que calcula y devuelve el area de la superficie total.
    public double calcularArea() {

        return 2 * Math.PI * this.radio *
                (this.radio + this.altura);
    }
}