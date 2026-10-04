package tp5.Base_Profesor;
/*
 * LISTA DOBLEMENTE ENLAZADA ORDENADA
 *
 * Hereda de DoubleLinkedList.
 *
 * El elemento debe implementar Comparable
 * para poder determinar su orden.
 */

public class DoubleLinkedOrderedList<ELEMENT extends Comparable<ELEMENT>>
        extends DoubleLinkedList<ELEMENT>
        implements ILinkedOrderedList<ELEMENT> {

    /*
     * Agrega un elemento manteniendo
     * el orden ascendente.
     */
    @Override
    public void addInOrder(ELEMENT item) {

        Node<ELEMENT> nuevo = new Node<>(item);

        /*
         * Caso 1:
         * La lista esta vacia.
         */
        if (this.count == 0) {

            this.head = nuevo;
            this.tail = nuevo;
            this.count++;

            return;
        }

        /*
         * Caso 2:
         * El nuevo elemento va antes del primero.
         */
        if (item.compareTo(this.head.item) <= 0) {

            nuevo.next = this.head;

            this.head.prev = nuevo;

            this.head = nuevo;

            this.count++;

            return;
        }

        /*
         * Buscamos la posicion correcta.
         */
        Node<ELEMENT> actual = this.head;

        while (actual.next != null &&
                item.compareTo(actual.next.item) > 0) {

            actual = actual.next;
        }

        /*
         * Caso 3:
         * Se agrega al final.
         */
        if (actual.next == null) {

            nuevo.prev = this.tail;

            this.tail.next = nuevo;

            this.tail = nuevo;

        } else {

            /*
             * Caso 4:
             * Se inserta en el medio.
             */
            Node<ELEMENT> siguiente = actual.next;

            nuevo.prev = actual;
            nuevo.next = siguiente;

            actual.next = nuevo;
            siguiente.prev = nuevo;
        }

        this.count++;
    }

    /*
     * Busca y elimina un elemento.
     *
     * Devuelve true si lo encontro.
     */
    public boolean findAndRemove(ELEMENT item) {

        Node<ELEMENT> actual = this.head;

        while (actual != null) {

            if (actual.item.compareTo(item) == 0) {

                /*
                 * Si es el primero.
                 */
                if (actual == this.head) {

                    removeFirst();

                    return true;
                }

                /*
                 * Si es el ultimo.
                 */
                if (actual == this.tail) {

                    removeLast();

                    return true;
                }

                /*
                 * Si esta en el medio.
                 */
                actual.prev.next = actual.next;

                actual.next.prev = actual.prev;

                this.count--;

                return true;
            }

            actual = actual.next;
        }

        return false;
    }
}