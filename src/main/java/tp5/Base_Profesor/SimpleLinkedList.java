package tp5.Base_Profesor;

/*
 * LISTA SIMPLEMENTE ENLAZADA
 *
 * Cada nodo contiene:
 *
 * - un elemento
 * - una referencia al siguiente nodo
 *
 * Estructura:
 *
 * [A] -> [B] -> [C] -> null
 */

import java.util.Iterator;

public class SimpleLinkedList<ELEMENT>
        implements ILinkedList<ELEMENT> {

    /*
     * Nodo de la lista.
     */
    protected static class Node<ELEMENT> {

        protected ELEMENT item;
        protected Node<ELEMENT> next;

        public Node(ELEMENT item) {
            this.item = item;
            this.next = null;
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
     * Cantidad de elementos.
     */
    protected int count;

    /*
     * Ultimo nodo.
     */
    protected Node<ELEMENT> tail;

    /*
     * Constructor.
     */
    public SimpleLinkedList() {

        this.head = null;
        this.count = 0;
        this.tail = null;
    }

    /*
     * Devuelve la cantidad de elementos.
     */
    @Override
    public int size() {

        return this.count;
    }

    /*
     * Agrega un elemento al principio.
     *
     * Ejemplo:
     *
     * Antes:
     *
     * [10] -> [20] -> null
     *
     * addFirst(5)
     *
     * Despues:
     *
     * [5] -> [10] -> [20] -> null
     */
    @Override
    public void addFirst(ELEMENT item) {

        Node<ELEMENT> newNode = new Node<>(item);

        newNode.next = this.head;

        this.head = newNode;

        this.count++;

        /*
         * Si la lista estaba vacia,
         * el nuevo nodo tambien es el ultimo.
         */
        if (this.count == 1) {
            this.tail = this.head;
        }
    }

    /*
     * Agrega un elemento al final.
     *
     * Ejemplo:
     *
     * Antes:
     *
     * [10] -> [20] -> null
     *
     * addLast(30)
     *
     * Despues:
     *
     * [10] -> [20] -> [30] -> null
     */
    @Override
    public void addLast(ELEMENT item) {

        Node<ELEMENT> newNode = new Node<>(item);

        if (this.count == 0) {

            this.head = newNode;
            this.tail = newNode;

        } else {

            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.count++;
    }

    /*
     * Elimina y devuelve el primer elemento.
     */
    @Override
    public ELEMENT removeFirst() {

        if (this.count == 0) {
            throw new RuntimeException(
                    "La lista esta vacia");
        }

        ELEMENT item = this.head.item;

        this.head = this.head.next;

        this.count--;

        /*
         * Si quedo vacia,
         * tambien debemos actualizar tail.
         */
        if (this.count == 0) {
            this.tail = null;
        }

        return item;
    }

    /*
     * Elimina y devuelve el ultimo elemento.
     */
    @Override
    public ELEMENT removeLast() {

        if (this.count == 0) {
            throw new RuntimeException(
                    "La lista esta vacia");
        }

        /*
         * Si hay un solo elemento.
         */
        if (this.count == 1) {

            ELEMENT item = this.head.item;

            this.head = null;
            this.tail = null;

            this.count--;

            return item;
        }

        /*
         * Buscamos el nodo anterior al tail.
         */
        Node<ELEMENT> current = this.head;

        while (current.next != this.tail) {

            current = current.next;
        }

        ELEMENT item = this.tail.item;

        current.next = null;

        this.tail = current;

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
                result.append(" -> ");
            }

            current = current.next;
        }

        return result.toString();
    }

    /*
     * Permite recorrer la lista con:
     *
     * for (ELEMENT item : lista)
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

    /*
     * ==========================================
     * EJERCICIO 1 DEL TP5
     * ==========================================
     *
     * Agrega un elemento en una posicion determinada.
     *
     * Las posiciones comienzan desde 0.
     *
     * Ejemplo:
     *
     * [A] -> [B] -> [C]
     *
     * agregarEnPosicion(D, 1)
     *
     * Resultado:
     *
     * [A] -> [D] -> [B] -> [C]
     */

    public void agregarEnPosicion(
            ELEMENT item,
            int posicion) {

        if (posicion < 0 ||
                posicion > this.count) {

            throw new IndexOutOfBoundsException(
                    "Posicion fuera de rango");
        }

        /*
         * Si queremos agregar al principio,
         * utilizamos addFirst.
         */
        if (posicion == 0) {

            addFirst(item);
            return;
        }

        /*
         * Si queremos agregar al final,
         * utilizamos addLast.
         */
        if (posicion == this.count) {

            addLast(item);
            return;
        }

        /*
         * Buscamos el nodo anterior
         * a la posicion indicada.
         */
        Node<ELEMENT> anterior = this.head;

        for (int i = 0; i < posicion - 1; i++) {

            anterior = anterior.next;
        }

        /*
         * Creamos el nuevo nodo.
         */
        Node<ELEMENT> nuevo = new Node<>(item);

        /*
         * Guardamos el siguiente.
         */
        nuevo.next = anterior.next;

        /*
         * El anterior ahora apunta al nuevo.
         */
        anterior.next = nuevo;

        this.count++;
    }

    /*
     * ==========================================
     * ELIMINAR ELEMENTO EN UNA POSICION
     * ==========================================
     *
     * Elimina y devuelve el elemento
     * ubicado en la posicion indicada.
     */
    public ELEMENT eliminarEnPosicion(
            int posicion) {

        if (posicion < 0 ||
                posicion >= this.count) {

            throw new IndexOutOfBoundsException(
                    "Posicion fuera de rango");
        }

        /*
         * Si es el primer elemento.
         */
        if (posicion == 0) {

            return removeFirst();
        }

        /*
         * Si es el ultimo.
         */
        if (posicion == this.count - 1) {

            return removeLast();
        }

        /*
         * Buscamos el nodo anterior
         * al que queremos eliminar.
         */
        Node<ELEMENT> anterior = this.head;

        for (int i = 0; i < posicion - 1; i++) {

            anterior = anterior.next;
        }

        /*
         * Nodo que queremos eliminar.
         */
        Node<ELEMENT> eliminado = anterior.next;

        /*
         * Saltamos el nodo eliminado.
         */
        anterior.next = eliminado.next;

        this.count--;

        return eliminado.item;
    }

    /*
     * ========================================================
     * EJERCICIO 10 - ELIMINAR ELEMENTOS PARES
     * ========================================================
     * Elimina todos los números pares de la lista modificando
     * las referencias de los nodos de forma directa.
     */
    public void eliminarPares() {
        // Caso Borde 1: Remoción sucesiva si el nodo cabeza (head) contiene un valor
        // par
        while (this.head != null && (int) this.head.item % 2 == 0) {
            this.head = this.head.next;
            this.count--;
        }

        // Si la lista se vació por completo tras limpiar la cabecera, se reajusta la
        // cola (tail)
        if (this.head == null) {
            this.tail = null;
            return;
        }

        // Caso General: Recorrido del cuerpo de la lista utilizando punteros en tándem
        Node<ELEMENT> anterior = this.head;
        Node<ELEMENT> actual = this.head.next;

        while (actual != null) {
            if ((int) actual.item % 2 == 0) {
                // El nodo anterior saltea la referencia del nodo actual para excluirlo
                anterior.next = actual.next;

                // Caso Borde 2: Si el nodo eliminado era el último, reubicamos la cola (tail)
                if (actual == this.tail) {
                    this.tail = anterior;
                }
                this.count--;

                // Avanzamos 'actual' al nuevo sucesor sin desplazar la referencia 'anterior'
                actual = anterior.next;
            } else {
                // Si el elemento es impar, ambos punteros avanzan en paralelo
                anterior = actual;
                actual = actual.next;
            }
        }
    }
}
