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
 * Consigna:
 * Desarrollar un método estático externo que reciba una SimpleLinkedList<Integer> 
 * y devuelva la suma de todos sus elementos. La lista original no debe modificarse 
 * (ni su contenido ni su orden) al finalizar el método. Solo se permite usar los 
 * métodos públicos de la clase SimpleLinkedList.
 */

public class Principal9 {

    /*
     * SOLUCIÓN A: Recorrido mediante Iterador (for-each)
     * 
     * Ventaja: Acceso de solo lectura elemento por elemento.
     * Complejidad Temporal: O(n) - Lineal.
     */
    public static int sumarElementosA(SimpleLinkedList<Integer> lista) {
        int suma = 0;

        // Se recorre la lista utilizando la interfaz Iterable/Iterator sin alterar
        // punteros
        for (Integer numero : lista) {
            suma += numero;
        }

        return suma;
    }

    /*
     * SOLUCIÓN B: Recorrido por Rotación Estructural (Desencolar y Encolar)
     * 
     * Desventaja: Altera la estructura de nodos en tiempo de ejecución.
     * Complejidad Temporal: O(n) - Asumiendo que removeFirst y addLast son O(1).
     */
    public static int sumarElementosB(SimpleLinkedList<Integer> lista) {
        int suma = 0;
        int tamanioOriginal = lista.size();

        for (int i = 0; i < tamanioOriginal; i++) {
            // Se remueve el nodo cabeza de la lista
            Integer numero = lista.removeFirst();
            suma += numero;
            // Se reinserta el elemento como el nuevo nodo cola
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

        System.out.println("==================================================");
        System.out.println("Proyecto Integrador I - Estructuras de Datos UNJu");
        System.out.println("==================================================");

        System.out.println("Lista original: " + lista);
        System.out.println("--------------------------------------------------");

        int sumaA = sumarElementosA(lista);
        System.out.println("Suma usando solución A: " + sumaA);
        System.out.println("Lista después de A:     " + lista);
        System.out.println("--------------------------------------------------");

        int sumaB = sumarElementosB(lista);
        System.out.println("Suma usando solución B: " + sumaB);
        System.out.println("Lista después de B:     " + lista);
        System.out.println("--------------------------------------------------");
        System.out.println("Resultado: Ambas soluciones preservan el estado final.");
    }
}

/*
 * =============================================================================
 * PREGUNTAS SOBRE EL PROBLEMA - INFORME TÉCNICO (ESTUDIANTE FORMAL)
 * =============================================================================
 *
 * a) ¿Cuál de las dos respeta mejor las restricciones del ejercicio?
 * ¿La Solución B modifica la estructura interna de la lista durante el proceso?
 * ¿Considera que "rotar" la lista respetó la restricción?
 *
 * Respuesta:
 * La Solución A es la que respeta de manera óptima las restricciones impuestas.
 * Esto se debe a que realiza una operación pura de "solo lectura" a través del
 * iterador,
 * manteniendo la estructura de nodos intacta en todo momento.
 *
 * Por el contrario, la Solución B SÍ modifica drásticamente la estructura
 * interna
 * de la lista durante el tiempo de ejecución. Aunque el estado final (contenido
 * y orden)
 * coincida con el original, el mecanismo destruye y reconstruye enlaces en cada
 * iteración.
 *
 * Ejemplo visual del proceso en la Solución B:
 * - Estado Inicial: [10] -> [20] -> [30] -> [40]
 * - Iteración 1 (removeFirst): [20] -> [30] -> [40] (Se extrae 10)
 * - Iteración 1 (addLast): [20] -> [30] -> [40] -> [10] (Se rota el elemento)
 *
 * Conceptualmente, "rotar" la lista viola el espíritu de la restricción
 * "no modificarse",
 * ya que si el método fallara de forma inesperada a mitad del bucle, la lista
 * quedaría
 * corrupta o con el orden alterado para el resto del sistema.
 *
 * -----------------------------------------------------------------------------
 * b) ¿Cuál solución es más fácil de explicar a un compañero?
 * Argumente sobre la simplicidad del iterador (for-each) frente al uso de
 * removeFirst y addLast.
 *
 * Respuesta:
 * La Solución A es considerablemente más sencilla de explicar y razonar.
 * El bucle for-each (abstracción del patrón Iterator) oculta la complejidad del
 * manejo
 * de punteros internos, permitiendo describir la solución en un lenguaje
 * natural:
 * "Se recorre la lista secuencialmente de principio a fin, acumulando el valor de cada elemento"
 * .
 *
 * La Solución B requiere justificar una estrategia de desapilado/desencolado
 * temporal,
 * donde es obligatorio controlar de forma estricta el tamaño original
 * (`lista.size()`)
 * en una variable auxiliar para evitar un bucle infinito, haciendo el código
 * más propenso
 * a errores de lógica.
 *
 * -----------------------------------------------------------------------------
 * c) ¿Qué ventajas y desventajas tiene cada una? Mencione el tiempo de
 * ejecución.
 *
 * SOLUCIÓN A:
 * [+] Ventajas: Es declarativa, limpia, segura (no altera punteros) y no genera
 * efectos secundarios en la estructura de datos.
 * [-] Desventajas: Depende estrictamente de que la clase SimpleLinkedList del
 * profesor
 * tenga implementada la interfaz `Iterable` y exponga un iterador público
 * válido.
 * [*] Complejidad Temporal: O(n) - Lineal. Realiza exactamente 'n' visitas a
 * los nodos,
 * donde 'n' es el número de elementos.
 *
 * SOLUCIÓN B:
 * [+] Ventajas: No depende de un iterador externo; utiliza puramente los
 * métodos primitivos
 * de inserción y eliminación de la lista enlazada.
 * [-] Desventajas: Altera los punteros de cabeza (`first`) y cola (`last`)
 * constantemente.
 * Si ocurre una excepción durante el bucle, los datos pierden su orden original
 * de forma irreversible.
 * [*] Complejidad Temporal: O(n) - Lineal. Siempre y cuando las operaciones
 * `removeFirst()`
 * y `addLast()` estén optimizadas en O(1) dentro de la implementación de la
 * cátedra
 * (manteniendo punteros directos al inicio y al final de la lista). Si
 * `addLast()` tuviera
 * que recorrer la lista para insertar, la complejidad total se degradaría a
 * O(n²).
 */