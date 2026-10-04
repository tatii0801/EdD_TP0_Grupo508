package tp5.ejercicio10;

/*
 * EJERCICIO 10 - DEBUGGING
 *
 * Consigna:
 *
 * Analizar el siguiente metodo:
 *
 * public void eliminarPares() {
 *
 *     if (this.count == 0) return;
 *
 *     Node<ELEMENT> actual = this.head;
 *
 *     while (actual != null) {
 *
 *         if ((int) actual.item % 2 == 0) {
 *             actual.next = actual.next.next;
 *             this.count--;
 *         }
 *
 *         actual = actual.next;
 *     }
 * }
 *
 * Se debe encontrar y explicar los errores.
 */

public class Principal10 {

    /*
     * En este ejercicio no necesitamos crear
     * una implementacion nueva de la lista.
     *
     * El objetivo principal es analizar el codigo
     * y encontrar los errores de enlaces.
     */

    public static void main(String[] args) {

        System.out.println(
                "Ejercicio 10 - Debugging de eliminarPares()");

        System.out.println();

        System.out.println(
                "El metodo original tiene errores de manejo");
        System.out.println(
                "de nodos y enlaces.");
    }
}

/*
 * ==========================================
 * ANALISIS DEL METODO
 * ==========================================
 *
 * CODIGO ORIGINAL:
 *
 * public void eliminarPares() {
 *
 * if (this.count == 0) return;
 *
 * Node<ELEMENT> actual = this.head;
 *
 * while (actual != null) {
 *
 * if ((int) actual.item % 2 == 0) {
 * actual.next = actual.next.next;
 * this.count--;
 * }
 *
 * actual = actual.next;
 * }
 * }
 *
 *
 * ==========================================
 * ERROR 1: NO SE CONTROLA EL HEAD
 * ==========================================
 *
 * Supongamos:
 *
 * 2 -> 4 -> 5 -> null
 *
 * El primer nodo contiene 2, que es par.
 *
 * El codigo hace:
 *
 * actual.next = actual.next.next;
 *
 * Es decir, modifica el siguiente del nodo actual.
 *
 * Pero actual sigue siendo el HEAD.
 *
 * Si el primer elemento es par, el metodo deberia
 * cambiar head para eliminar ese primer nodo.
 *
 *
 * ==========================================
 * ERROR 2: PUEDE PRODUCIR NullPointerException
 * ==========================================
 *
 * Supongamos:
 *
 * 5 -> 8 -> null
 *
 * Cuando actual apunta a 8:
 *
 * actual.next == null
 *
 * Entonces:
 *
 * actual.next.next
 *
 * intenta acceder a next de null.
 *
 * Esto produce un NullPointerException.
 *
 *
 * ==========================================
 * ERROR 3: SE SALTAN NODOS
 * ==========================================
 *
 * Supongamos:
 *
 * 2 -> 4 -> 5
 *
 * Si se elimina un nodo y despues hacemos:
 *
 * actual = actual.next;
 *
 * podemos avanzar de manera incorrecta y dejar
 * nodos sin revisar.
 *
 *
 * ==========================================
 * ¿QUE PASA CON 2, 4, 5?
 * ==========================================
 *
 * La lista correcta deberia quedar:
 *
 * 5
 *
 * porque 2 y 4 son pares.
 *
 * Pero el metodo original no maneja correctamente
 * el caso en el que el primer nodo es par.
 *
 *
 * ==========================================
 * FORMA CORRECTA DE PENSARLO
 * ==========================================
 *
 * Para eliminar un nodo de una lista simplemente enlazada
 * necesitamos mantener:
 *
 * - actual
 * - anterior
 *
 * Ejemplo:
 *
 * anterior -> actual -> siguiente
 *
 * Si actual debe eliminarse:
 *
 * anterior.next = actual.next
 *
 *
 * ==========================================
 * EJEMPLO
 * ==========================================
 *
 * Lista:
 *
 * 3 -> 4 -> 6 -> 7
 *
 * Queremos eliminar 4.
 *
 * Tenemos:
 *
 * anterior = 3
 * actual = 4
 *
 * Entonces:
 *
 * anterior.next = actual.next
 *
 * queda:
 *
 * 3 -> 6 -> 7
 *
 *
 * ==========================================
 * CONCLUSION
 * ==========================================
 *
 * El metodo original NO resuelve correctamente
 * la eliminacion de todos los pares.
 *
 * Los principales problemas son:
 *
 * 1. No maneja correctamente un HEAD par.
 *
 * 2. Puede intentar acceder a actual.next.next
 * cuando actual.next es null.
 *
 * 3. El avance de actual no esta correctamente
 * coordinado con la eliminacion.
 *
 * 4. No utiliza correctamente el nodo anterior
 * cuando necesita eliminar un nodo del medio.
 */