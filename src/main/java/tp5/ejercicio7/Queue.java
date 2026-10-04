package tp5.ejercicio7;

import tp5.Base_Profesor.SimpleLinkedList;

/*
 * EJERCICIO 7 - QUEUE
 *
 * Implementar una cola generica utilizando
 * una lista generica internamente.
 *
 * La cola trabaja con FIFO:
 *
 * First In - First Out
 *
 * El primero que entra es el primero que sale.
 */

public class Queue<ELEMENT> {

    private SimpleLinkedList<ELEMENT> lista;

    /*
     * Constructor.
     */
    public Queue() {

        lista = new SimpleLinkedList<>();
    }

    /*
     * Agrega un elemento al final de la cola.
     */
    public void add(ELEMENT elemento) {

        lista.addLast(elemento);
    }

    /*
     * Elimina y devuelve el primer elemento.
     */
    public ELEMENT remove() {

        return lista.removeFirst();
    }

    /*
     * Indica si la cola esta vacia.
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

    /*
     * Devuelve una representacion de la cola.
     */
    @Override
    public String toString() {

        return lista.toString();
    }
}
