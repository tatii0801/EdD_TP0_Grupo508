package tp3.ejercicio5;

import java.util.Scanner;

import tp3.ejemplo.implementaciones.StackGenerica;

/* 
   =========================================================
   RESPUESTAS A LAS PREGUNTAS:
   =========================================================

   a) ¿Por qué no se puede modificar en el lugar como un arreglo?
   Porque una pila es LIFO y solo permite acceso directo al elemento del tope. Para llegar a los elementos inferiores, es obligatorio desapilar y almacenar temporalmente los superiores.

   b) ¿Qué ocurre si el idPedido ya estaba pagado o no existe?
   Si ya estaba pagado, su estado lógico 'true' se reasigna sin afectar al sistema. Si no existe, la pila se recorre por completo y se restaura sin sufrir alteraciones ni errores.

   c) ¿Se mantiene el orden relativo de los pedidos no pagados en vaciarPagados?
   Sí, se mantiene perfectamente. Al pasar los elementos entre la pila principal y la auxiliar, se producen dos inversiones consecutivas que devuelven a los pedidos pendientes a su secuencia original.

   d) ¿La solución compila, cumple y qué consecuencia trae para la pila original?
   Sí compila, pero no cumple. Como extrae elementos sin reinsertarlos en una pila auxiliar, la pila original pierde todos sus datos de forma irreversible y queda completamente vacía.
  */

public class Pedido {

  String idPedido;
  double monto;
  boolean estaPago;

  public Pedido(String idPedido, double monto, boolean estaPago) {
    this.idPedido = idPedido;
    this.monto = monto;
    this.estaPago = estaPago;
  }

  // a) cargarPedido(Stack<Pedido> pila, Pedido nuevo): agrega un nuevo pedido a
  // la pila.
  public void cargarPedido(StackGenerica<Pedido> pila, Pedido nuevo) {
    try {
      pila.push(nuevo);
    } catch (RuntimeException e) {
      System.err.println(e.getMessage());
    }
  }

  // b) marcarComoPagado(Stack<Pedido> pila, String idPedido): cambia el valor de
  // estaPago a true para el
  // pedido cuyo id coincide. Si no existe, no hace nada. El orden de la pila no
  // debe alterarse.
  public void marcarComoPagado(StackGenerica<Pedido> pila, String idPedido) {
    var aux = new StackGenerica<Pedido>();
    while (!pila.isEmpty()) {
      Pedido pedido = pila.pop();
      if (pedido.idPedido.equals(idPedido)) {
        pedido.estaPago = true;
      }
      aux.push(pedido);
    }

    while (!aux.isEmpty()) {
      pila.push(aux.pop());
    }

  }

  // c) obtenerDeudaTotal(Stack<Pedido> pila): devuelve la suma de los montos de
  // todos los pedidos que aún no han sido pagados.
  public double obtenerDeudaTotal(StackGenerica<Pedido> pila) {
    var aux = new StackGenerica<Pedido>();
    var total = 0.0;
    while (!pila.isEmpty()) {
      var pedido = pila.pop();
      if (!pedido.estaPago) {
        total += pedido.monto;
      }
      aux.push(pedido);
    }
    while (!aux.isEmpty()) {
      pila.push(aux.pop());
    }

    return total;
  }

  // d) vaciarPagados(Stack<Pedido> pila): elimina de la pila todos los objetos
  // que ya fueron pagados, manteniendo el orden de los pedidos pendientes de pago
  public void vaciarPagados(StackGenerica<Pedido> pila) {

    var aux = new StackGenerica<Pedido>();

    while (!pila.isEmpty()) {
      var pedido = pila.pop();
      if (!pedido.estaPago) {
        aux.push(pedido);
      }
    }
    while (!aux.isEmpty()) {
      pila.push(aux.pop());
    }

  }

  private static void mostrarPila(StackGenerica<Pedido> pila) {
    StackGenerica<Pedido> aux = new StackGenerica<>();
    while (!pila.isEmpty()) {
      Pedido p = pila.pop();
      System.out.println("ID: " + p.idPedido + " | Monto: $" + p.monto + " | Pagado: " + p.estaPago);
      aux.push(p);
    }
    while (!aux.isEmpty()) {
      pila.push(aux.pop());
    }
  }

  public static void main(String[] args) {
    Pedido gestor = new Pedido(null, 0.0, false);
    StackGenerica<Pedido> pila = new StackGenerica<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println(" Cargando pedidos: ");
    gestor.cargarPedido(pila, new Pedido("101", 1500.0, true));
    gestor.cargarPedido(pila, new Pedido("102", 3200.0, false));
    gestor.cargarPedido(pila, new Pedido("103", 800.0, false));
    gestor.cargarPedido(pila, new Pedido("104", 4500.0, true));
    gestor.cargarPedido(pila, new Pedido("105", 1200.0, false));

    System.out.println("\nEstado inicial de la pila y deuda total");
    mostrarPila(pila);
    System.out.println("Deuda total calculada: $" + gestor.obtenerDeudaTotal(pila));

    System.out.println("\n Solicitar idPedido, ejecutar marcarComoPagado y verificar deuda ");
    System.out.print("Ingrese el idPedido a marcar como pagado: ");
    String idBuscado = scanner.nextLine();
    gestor.marcarComoPagado(pila, idBuscado);
    System.out.println("Nueva deuda total calculada: $" + gestor.obtenerDeudaTotal(pila));

    System.out.println("\nEjecutar vaciarPagados y mostrar pila resultante: ");
    gestor.vaciarPagados(pila);
    mostrarPila(pila);

    scanner.close();
  }

}


