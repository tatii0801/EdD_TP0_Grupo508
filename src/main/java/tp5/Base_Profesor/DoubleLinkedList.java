package tp5.Base_Profesor;
/*
 * LISTA DOBLEMENTE ENLAZADA
 *
 * Cada nodo tiene:
 *
 * - elemento
 * - referencia al siguiente
 * - referencia al anterior
 *
 * Ejemplo:
 *
 * null <- [A] <-> [B] <-> [C] -> null
 */

import java.util.Iterator;

public class DoubleLinkedList<ELEMENT>
        implements ILinkedList<ELEMENT> {

    /*
     * Nodo de la lista.
     */
    protected static class Node<ELEMENT> {

        protected ELEMENT item;
        protected Node<ELEMENT> next;
        protected Node<ELEMENT> prev;

        public Node(ELEMENT item) {

            this.item = item;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {

            return item.toString();
        }
    }

    /*
     * Primer nodo.
     */
    protected Node<ELEMENT> head;

    /*
     * Ultimo nodo.
     */
    protected Node<ELEMENT> tail;

    /*
     * Cantidad de elementos.
     */
    protected int count;

    /*
     * Constructor.
     */
    public DoubleLinkedList() {

        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /*
     * Devuelve la cantidad de elementos.
     */
    @Override
    public int size() {

        return this.count;
    }

    /*
     * Agrega al principio.
     */
    @Override
    public void addFirst(ELEMENT item) {

        Node<ELEMENT> newNode = new Node<>(item);

        if (this.count == 0) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            newNode.next = this.head;

            this.head.prev = newNode;

            this.head = newNode;
        }

        this.count++;
    }

    /*
     * Agrega al final.
     */
    @Override
    public void addLast(ELEMENT item) {

        Node<ELEMENT> newNode = new Node<>(item);

        if (this.count == 0) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            newNode.prev = this.tail;

            this.tail.next = newNode;

            this.tail = newNode;
        }

        this.count++;
    }

    /*
     * Elimina el primer elemento.
     */
    @Override
    public ELEMENT removeFirst() {

        if (this.count == 0) {

            throw new RuntimeException(
                    "La lista esta vacia");
        }

        ELEMENT item = this.head.item;

        if (this.count == 1) {

            this.head = null;
            this.tail = null;

        } else {

            this.head = this.head.next;

            this.head.prev = null;
        }

        this.count--;

        return item;
    }

    /*
     * Elimina el ultimo elemento.
     */
    @Override
    public ELEMENT removeLast() {

        if (this.count == 0) {

            throw new RuntimeException(
                    "La lista esta vacia");
        }

        ELEMENT item = this.tail.item;

        if (this.count == 1) {

            this.head = null;
            this.tail = null;

        } else {

            this.tail = this.tail.prev;

            this.tail.next = null;
        }

        this.count--;

        return item;
    }

    /*
     * Muestra la lista.
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        Node<ELEMENT> current = this.head;

        while (current != null) {

            result.append(current.item);

            if (current.next != null) {
                result.append(" <-> ");
            }

            current = current.next;
        }

        return result.toString();
    }

    /*
     * Iterador.
     */
    @Override
    public Iterator<ELEMENT> iterator() {

        return new Iterator<ELEMENT>() {

            private Node<ELEMENT> current = head;

            @Override
            public boolean hasNext() {

                return current != null;
            }

            @Override
            public ELEMENT next() {

                ELEMENT item = current.item;

                current = current.next;

                return item;
            }
        };
    }
}