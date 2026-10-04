package tp5.ejercicio9;

import tp5.Base_Profesor.SimpleLinkedList;

/*
 * EJERCICIO 9 - LISTA
 *
 * Consigna:
 *
 * Crear un metodo statico externo que reciba
 * una SimpleLinkedList<Integer> y devuelva
 * la suma de sus elementos.
 *
 * La lista original NO debe modificarse.
 */

public class Principal9 {

    /*
     * SOLUCION A
     *
     * Recorremos la lista utilizando for-each.
     *
     * No modificamos la estructura.
     */
    public static int sumarElementosA(
            SimpleLinkedList<Integer> lista) {

        int suma = 0;

        for (Integer numero : lista) {

            suma += numero;
        }

        return suma;
    }

    /*
     * SOLUCION B
     *
     * Sacamos elementos del principio
     * y los volvemos a colocar al final.
     *
     * Al terminar, la lista queda con el mismo
     * contenido y el mismo orden.
     */
    public static int sumarElementosB(
            SimpleLinkedList<Integer> lista) {

        int suma = 0;

        int tamanioOriginal = lista.size();

        for (int i = 0; i < tamanioOriginal; i++) {

            Integer numero = lista.removeFirst();

            suma += numero;

            lista.addLast(numero);
        }

        return suma;
    }

    public static void main(String[] args) {

        SimpleLinkedList<Integer> lista = new SimpleLinkedList<>();

        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addLast(40);

        System.out.println(
                "Lista original: " + lista);

        int sumaA = sumarElementosA(lista);

        System.out.println(
                "Suma usando solucion A: " + sumaA);

        System.out.println(
                "Lista despues de A: " + lista);

        int sumaB = sumarElementosB(lista);

        System.out.println(
                "Suma usando solucion B: " + sumaB);

        System.out.println(
                "Lista despues de B: " + lista);
    }
}

/*
 * ==============================
 * PREGUNTAS SOBRE EL PROBLEMA
 * ==============================
 *
 * a) ¿Cual respeta mejor la condicion de no modificar
 * la lista?
 *
 * Respuesta:
 * La solucion A.
 *
 * La solucion A solamente recorre los elementos.
 *
 * La solucion B modifica internamente la estructura,
 * porque elimina elementos y luego los vuelve a agregar.
 *
 * Aunque al final queda igual, durante el proceso
 * la lista si fue modificada.
 *
 *
 * b) ¿Cual es mas facil de explicar?
 *
 * Respuesta:
 * La solucion A.
 *
 * Simplemente recorremos:
 *
 * for (Integer numero : lista)
 *
 * y acumulamos cada numero.
 *
 *
 * c) Ventajas y desventajas.
 *
 * SOLUCION A:
 *
 * + Simple.
 * + No modifica la lista.
 * + Facil de entender.
 * + Recorre una vez los elementos.
 *
 *
 * SOLUCION B:
 *
 * + Utiliza solamente los metodos publicos de la lista.
 * + Al finalizar conserva el orden.
 *
 * - Modifica la estructura durante el proceso.
 * - Es mas dificil de explicar.
 * - Realiza mas operaciones.
 *
 *
 * d) ¿Las dos soluciones devuelven el mismo resultado?
 *
 * Respuesta:
 * Si.
 *
 * Las dos calculan la misma suma.
 *
 * La diferencia esta en la forma de recorrer la lista.
 */
