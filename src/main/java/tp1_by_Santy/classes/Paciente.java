package tp1_by_Santy.classes;

public class Paciente {
    private String nombre;
    private String dni;
    private double peso;   // en kg
    private double altura; // en metros

    // Constructor por defecto
    public Paciente() {
        this.nombre = "Sin nombre";
        this.dni = "00000000";
        this.peso = 70.0;
        this.altura = 1.70;
    }

    // Constructor con parámetros
    public Paciente(String nombre, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // a) Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // b) Método para calcular el IMC: peso / (altura * altura)
    public double calcularIMC() {
        if (this.altura <= 0) return 0.0;
        return this.peso / Math.pow(this.altura, 2);
    }

    // c) Método para determinar el estado nutricional según el IMC
    public String obtenerEstadoNutricional() {
        double imc = calcularIMC();

        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}