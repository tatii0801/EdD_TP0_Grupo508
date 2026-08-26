package tp1;

// Programa principal para probar la clase TanqueAgua.

/*
 * Programa de prueba para la clase TanqueAgua.
 *
 * Se crea un tanque con una capacidad maxima de 100 litros
 * y una cantidad inicial de 50 litros.
 *
 * Luego se agrega agua y se retira agua para comprobar
 * que las restricciones se cumplen.
 */

public class Ejercicio6 {

    public static void main(String[] args) {

        // Creamos un tanque con:
        // capacidad maxima = 100 litros
        // cantidad actual = 50 litros

        TanqueAgua tanque = new TanqueAgua(100, 50);

        System.out.println("===== ESTADO INICIAL =====");

        tanque.mostrarEstado();

        // Agregamos 70 litros.
        // 50 + 70 = 120.
        // Como supera 100, debe quedar en 100.

        System.out.println("\n===== AGREGAR AGUA =====");

        tanque.agregarAgua(70);

        tanque.mostrarEstado();

        // Retiramos 150 litros.
        // Como hay 100, el tanque debe quedar en 0.

        System.out.println("\n===== RETIRAR AGUA =====");

        tanque.retirarAgua(150);

        tanque.mostrarEstado();
    }
}

/*
 * Actividad:
 * 1. Analizar el código línea por línea e identificar los errores conceptuales
 * y lógicos.
 * 2. Argumentar acerca de por qué constituyen errores. (Ayuda: Hay un error
 * grave de encapsulamiento,
 * un error en el constructor parametrizado, un error de lógica en agregarAgua y
 * otro en retirarAgua).
 * 3. ¿La solución responde completamente a lo solicitado por la consigna? ¿Se
 * cumple la regla de que el
 * tanque "debe quedar lleno" o "debe quedar en 0" en los casos límite?
 * 4. Reescribir la clase TanqueAgua para que la solución sea correcta,
 * respetando los principios de la
 * Programación Orientada a Objetos.
 * 
 * Errores de la solución propuesta
 * Error 1: encapsulamiento
 * 
 * La solución utiliza:
 * 
 * public double capacidadMaxima;
 * public double cantidadActual;
 * 
 * Esto está mal desde el punto de vista del encapsulamiento.
 * 
 * Debería ser:
 * 
 * private double capacidadMaxima;
 * private double cantidadActual;
 * 
 * Así evitamos que desde main alguien pueda hacer:
 * 
 * tanque.cantidadActual = -500;
 * Error 2: constructor parametrizado
 * 
 * La solución hace:
 * 
 * this.capacidadMaxima = capacidadMaxima;
 * this.cantidadActual = cantidadActual;
 * 
 * Pero el enunciado dice que si cantidadActual supera la capacidad máxima, debe
 * ajustarse.
 * 
 * Por ejemplo:
 * 
 * capacidadMaxima = 100
 * cantidadActual = 150
 * 
 * debería terminar como:
 * 
 * cantidadActual = 100
 * Error 3: agregarAgua()
 * 
 * La solución hace:
 * 
 * this.cantidadActual =
 * this.cantidadActual + litros;
 * 
 * y solamente muestra un mensaje si se supera la capacidad.
 * 
 * Pero el enunciado dice que el tanque debe quedar lleno.
 * 
 * Por ejemplo:
 * 
 * cantidadActual = 80
 * agregar 50
 * 
 * no debería quedar:
 * 
 * 130
 * 
 * sino:
 * 
 * 100
 * Error 4: retirarAgua()
 * 
 * La solución hace:
 * 
 * this.cantidadActual =
 * this.cantidadActual - litros;
 * 
 * Si tenemos:
 * 
 * cantidadActual = 20
 * 
 * y retiramos:
 * 
 * 50
 * 
 * el resultado sería:
 * 
 * -30
 * 
 * Pero la consigna dice que debe quedar en 0.
 */