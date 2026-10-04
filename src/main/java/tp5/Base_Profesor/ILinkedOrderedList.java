package tp5.Base_Profesor;
/*
 * INTERFAZ DE LISTA ORDENADA
 *
 * Define la operacion para agregar un elemento
 * respetando el orden.
 */

public interface ILinkedOrderedList<ELEMENT>
        extends ILinkedList<ELEMENT> {

    /*
     * Agrega un elemento manteniendo
     * el orden de la lista.
     */
    void addInOrder(ELEMENT item);
}
