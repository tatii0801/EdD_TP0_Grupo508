# Guía

## Ejecutar una clase específica del proyecto

Para ejecutar una clase de forma individual (por ejemplo, `src/main/java/tp1/Reserva.java`), la clase debe contener un método principal `main`:

```java
package src.main.java.tp1;

public class Reserva {
   // TODO TU CODIGO ACA
    public static void main(String[] args) {
        System.out.println("Ejecutando la clase Reserva...");
        // podes hacer tu ingreso de datos acá
    }
}

### Pasos para ejecutarlo

Abrir powershell y en el directorio raiz ejecutar

```cmd
.\run.bat <nombredelaclase>

```
### Ejemplo Simple

Si tenes tu clase en el paquete src.main.java.tp1.Reserva que queres ejecutar por separado:

```cmd
.\run.bat src.main.java.tp1 

```
