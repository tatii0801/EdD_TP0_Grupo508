package tp5.Base_Profesor;

/*
 * INTERFAZ DE LISTA ENLAZADA
 *
 * Define las operaciones basicas que debe tener
 * una lista enlazada.
 */

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {

    /*
     * Devuelve la cantidad de elementos de la lista.
     */
    int size();

    /*
     * Agrega un elemento al principio.
     */
    void addFirst(ELEMENT item);

    /*
     * Agrega un elemento al final.
     */
    void addLast(ELEMENT item);

    /*
     * Elimina y devuelve el primer elemento.
     */
    ELEMENT removeFirst();

    /*
     * Elimina y devuelve el ultimo elemento.
     */
    ELEMENT removeLast();
}
