package tp5.ejercicio8;

import tp5.Base_Profesor.SimpleLinkedList;

/*
 * EJERCICIO 8 - STACK
 *
 * Implementar una pila generica utilizando
 * una lista generica internamente.
 *
 * La pila trabaja con LIFO:
 *
 * Last In - First Out
 *
 * El ultimo que entra es el primero que sale.
 */

public class Stack<ELEMENT> {

    private SimpleLinkedList<ELEMENT> lista;

    /*
     * Constructor.
     */
    public Stack() {

        lista = new SimpleLinkedList<>();
    }

    /*
     * Agrega un elemento en el tope.
     */
    public void push(ELEMENT elemento) {

        lista.addFirst(elemento);
    }

    /*
     * Elimina y devuelve el elemento del tope.
     */
    public ELEMENT pop() {

        return lista.removeFirst();
    }

    /*
     * Indica si la pila esta vacia.
     */
    public boolean isEmpty() {

        return lista.size() == 0;
    }

    /*
     * Devuelve la cantidad de elementos.
     */
    public int size() {

        return lista.size();
    }

    @Override
    public String toString() {

        return lista.toString();
    }
}
