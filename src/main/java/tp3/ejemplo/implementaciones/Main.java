package tp3.ejemplo.implementaciones;

public class Main {
  public static void main(String[] args) {
  
        //StackChar miPila = new StackChar();
        StackGenerica<Character> miPila = new StackGenerica();

        miPila.push('a');
        miPila.push('b');
        miPila.push('c');
        
        System.out.println("Proximo elemento a salir: "+ miPila.peek());

        System.out.println("Salio "+ miPila.pop());
        System.out.println("Salio "+ miPila.pop());
        System.out.println("Salio "+ miPila.pop());
      
      
      StackGenerica<Integer> miPilaNumeros = new StackGenerica<>();

        miPilaNumeros.push(1);
        miPilaNumeros.push(2);
        miPilaNumeros.push(3);

        System.out.println("Proximo elemento a salir: "+ miPilaNumeros.peek());

        while (!miPilaNumeros.isEmpty()) {
            System.out.println(miPilaNumeros.pop());
        }
      
  }
}
