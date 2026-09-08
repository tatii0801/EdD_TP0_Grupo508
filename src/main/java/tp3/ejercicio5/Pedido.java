package tp3.ejercicio5;

import java.util.ArrayList;

import tp3.ejemplo.implementaciones.StackGenerica;
// Definir la clase Pedido con los atributos: idPedido, monto y estaPago (booleano). Cargar una pila con varios
// objetos de tipo Pedido. Además, implementar los siguientes métodos:
// a) cargarPedido(Stack<Pedido> pila, Pedido nuevo): agrega un nuevo pedido a la pila.
// b) marcarComoPagado(Stack<Pedido> pila, String idPedido): cambia el valor de estaPago a true para el
// pedido cuyo id coincide. Si no existe, no hace nada. El orden de la pila no debe alterarse.
// c) obtenerDeudaTotal(Stack<Pedido> pila): devuelve la suma de los montos de todos los pedidos que aún
// no han sido pagados.
// d) vaciarPagados(Stack<Pedido> pila): elimina de la pila todos los objetos que ya fueron pagados,
// manteniendo el orden de los pedidos pendientes de pago.

public class Pedido {

  String idPedido;
  double monto;
  boolean estaPago;

  // a) cargarPedido(Stack<Pedido> pila, Pedido nuevo): agrega un nuevo pedido a
  // la pila.
  public void cargarPedido(StackGenerica<Pedido> pila, Pedido nuevo) {
    try {
      pila.push(nuevo);
    } catch (RuntimeException e) {
      System.err.println(e.getMessage());
    } finally {
      System.out.println("No se pudo agregar un nuevo pedido");
    }
  }

  // b) marcarComoPagado(Stack<Pedido> pila, String idPedido): cambia el valor de
  // estaPago a true para el
  // pedido cuyo id coincide. Si no existe, no hace nada. El orden de la pila no
  // debe alterarse.
  public void marcarComoPagado(StackGenerica<Pedido> pila, String idPedido) {
    var pila_salida = new StackGenerica<Pedido>();
    while (!pila.isEmpty()) {
      Pedido pedido = pila.pop();
      if (pedido.idPedido == idPedido) {
        pedido.estaPago = true;
      }
      pila_salida.push(pedido);
    }

    while (!pila_salida.isEmpty()) {
      pila.push(pila_salida.pop());
    }

  }

  // c) obtenerDeudaTotal(Stack<Pedido> pila): devuelve la suma de los montos de
  // todos los pedidos que aún no han sido pagados.
  public double obtenerDeudaTotal(StackGenerica<Pedido> pila) {
    var pila_salida = new StackGenerica<Pedido>();
    var total = 0.0;
    while (!pila.isEmpty()) {
      var pedido = pila.pop();
      if (!pedido.estaPago) {
        total += pedido.monto;
      }
    }
    while (!pila_salida.isEmpty()) {
      pila.push(pila_salida.pop());
    }

    return total;
  }

  // d) vaciarPagados(Stack<Pedido> pila): elimina de la pila todos los objetos
  // que ya fueron pagados, manteniendo el orden de los pedidos pendientes de pago
  public void vaciarPagados(StackGenerica<Pedido> pila) {

    var pila_salida = new StackGenerica<Pedido>();

    while (!pila.isEmpty()) {
      var pedido = pila.pop();
      if (!pedido.estaPago) {
        pila_salida.push(pedido);
      }
    }
    while (!pila_salida.isEmpty()) {
      pila.push(pila_salida.pop());
    }

  }

  public void main(String[] argv) {
    System.out.println("Hello World");
  }

}
