package src.main.java.tp1;

// Clase que representa un paciente.

/*
 * Enunciado:
 *
 * Crear una clase Paciente con los atributos:
 *
 * - nombre
 * - dni
 * - peso
 * - altura
 *
 * La clase debe permitir establecer y obtener
 * los datos del paciente.
 *
 * Tambien debe calcular el IMC y determinar
 * el estado nutricional.
 */

public class Paciente {

    // Atributos privados.
    private String nombre;
    private String dni;
    private double peso;
    private double altura;

    // Getter del nombre.
    public String getNombre() {
        return this.nombre;
    }

    // Setter del nombre.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter del DNI.
    public String getDni() {
        return this.dni;
    }

    // Setter del DNI.
    public void setDni(String dni) {
        this.dni = dni;
    }

    // Getter del peso.
    public double getPeso() {
        return this.peso;
    }

    // Setter del peso.
    // Solo permite valores positivos.
    public void setPeso(double peso) {

        if (peso > 0) {
            this.peso = peso;
        } else {
            System.out.println(
                    "Error: el peso debe ser positivo.");
        }
    }

    // Getter de la altura.
    public double getAltura() {
        return this.altura;
    }

    // Setter de la altura.
    // Solo permite valores positivos.
    public void setAltura(double altura) {

        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println(
                    "Error: la altura debe ser positiva.");
        }
    }

    // Metodo que calcula el IMC.
    public double calcularIMC() {

        return this.peso /
                (this.altura * this.altura);
    }

    // Metodo que determina el estado nutricional.
    public String estadoNutricional() {

        double imc = calcularIMC();

        if (imc < 18.5) {

            return "Bajo peso";

        } else if (imc < 25) {

            return "Normal";

        } else if (imc < 30) {

            return "Sobrepeso";

        } else {

            return "Obesidad";
        }
    }
}