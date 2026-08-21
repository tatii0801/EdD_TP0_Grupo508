package tp1;

// Programa principal para probar la clase Bateria.

/*
 * Enunciado:
 *
 * Crear una bateria con 50% de carga.
 *
 * Consumir 60 unidades.
 *
 * La carga final debe quedar en 0%.
 */

public class Ejercicio5 {

    public static void main(String[] args) {

        // Creamos una bateria con 50% de carga.
        Bateria bateria = new Bateria(50);

        // Consumimos 60 unidades.
        bateria.consumir(60);

        // Mostramos la carga final.
        System.out.println(
                "Carga final: "
                        + bateria.getCarga()
                        + "%");
    }
}

/*
 * Preguntas sobre el problema
 * 1. ¿Cuál de las dos soluciones representa mejor los principios de la
 * Programación Orientada a Objetos
 * estudiados? Justifique su respuesta haciendo referencia al concepto de
 * encapsulamiento.
 * La Solución B representa mejor los principios de POO porque aplica
 * encapsulamiento.
 * 
 * En la Solución A:
 * 
 * public int carga;
 * 
 * la carga puede modificarse directamente desde fuera de la clase.
 * 
 * Por ejemplo:
 * 
 * b.carga = -500;
 * 
 * Eso permite que el objeto tenga un estado inválido.
 * 
 * En la Solución B:
 * 
 * private int carga;
 * 
 * el atributo está protegido y solamente se puede modificar mediante los
 * métodos de la clase.
 * 
 * Por eso la Solución B es mejor diseño orientado a objetos.
 * 
 * 2. Si tuvieras que explicar por qué la Solución B es un mejor diseño de
 * software a un compañero que
 * recién empieza a programar, ¿qué argumentos le darías?
 * La Solución B es mejor porque la clase Bateria controla su propio estado.
 * 
 * Por ejemplo:
 * 
 * b.consumir(60);
 * 
 * La clase se encarga de verificar que la carga no quede debajo de 0.
 * 
 * Esto significa que main no necesita conocer cómo se realiza internamente el
 * cálculo.
 * 
 * Además, si en el futuro cambia la forma de controlar la carga, solamente
 * habría que modificar la clase Bateria.
 * 
 * 3. El enunciado pide que el valor "no baje de 0". ¿Cuál de las dos soluciones
 * respeta mejor esta
 * restricción de manera robusta? ¿Qué sucede en la Solución A si en el futuro
 * otro programador escribe
 * b.consumir(200) sin incluir una estructura selectiva if en el método main? ¿Y
 * qué sucede en la Solución B en
 * ese mismo caso?
 * La Solución B respeta mejor la restricción.
 * 
 * En la Solución A, si otro programador escribe:
 * 
 * b.consumir(200);
 * 
 * el método:
 * 
 * this.carga = this.carga - cantidad;
 * 
 * podría dejar:
 * 
 * -150
 * 
 * si la batería tenía 50.
 * 
 * En cambio, en la Solución B:
 * 
 * public void consumir(int cantidad) {
 * 
 * 
 * this.carga -= cantidad;
 * 
 * 
 * if (this.carga < 0) {
 * this.carga = 0;
 * }
 * }
 * 
 * la propia clase garantiza que la carga nunca sea menor que 0.
 * 
 * 4. Identificar al menos una ventaja de la Solución A y una ventaja de la
 * Solución B. Luego, explicar por
 * qué la Solución B puede ser más valiosa en un sistema de software real que
 * puede crecer en el futuro.
 * Ventaja de la Solución A
 * 
 * Es sencilla y rápida de escribir para un ejemplo pequeño.
 * 
 * Ventaja de la Solución B
 * 
 * Mantiene los datos protegidos y concentra las reglas dentro de la clase.
 * 
 * La Solución B es más útil en un sistema real porque el programa puede crecer
 * y otros programadores pueden utilizar la clase sin tener que preocuparse por
 * controlar manualmente todas las restricciones.
 * 
 */
