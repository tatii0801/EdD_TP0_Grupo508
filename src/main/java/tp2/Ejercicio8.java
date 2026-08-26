// Programa que gestiona empleados utilizando un arreglo de objetos.

package tp2;

/*
 * ENUNCIADO:
 *
 * Cargar 3 objetos de la clase Empleado en un arreglo.
 *
 * Cada empleado tiene:
 * - legajo
 * - nombre
 * - sueldo
 *
 * Luego:
 *
 * 1. Buscar un empleado por legajo e informar su nombre.
 * 2. Encontrar e informar el nombre del empleado con mayor sueldo.
 */

// Clase Empleado.
class Empleado {

    int legajo;
    String nombre;
    double sueldo;

    // Constructor.
    public Empleado(
            int legajo,
            String nombre,
            double sueldo) {

        this.legajo = legajo;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
}

// Clase principal.
public class Ejercicio8 {

    public static void main(String[] args) {

        // Creamos el arreglo para almacenar 3 empleados.
        Empleado[] empleados = new Empleado[3];

        // Cargamos los empleados.
        empleados[0] = new Empleado(101, "Ana", 500.0);

        empleados[1] = new Empleado(102, "Beto", 700.0);

        empleados[2] = new Empleado(103, "Carla", 600.0);

        // Legajo que queremos buscar.
        int legajoBuscado = 102;

        boolean encontrado = false;

        // Buscamos el empleado.
        for (int i = 0; i < empleados.length; i++) {

            if (empleados[i].legajo == legajoBuscado) {

                System.out.println(
                        "Empleado encontrado: "
                                + empleados[i].nombre);

                encontrado = true;

                break;
            }
        }

        // El mensaje de no encontrado debe mostrarse
        // solamente después de terminar la búsqueda.
        if (!encontrado) {

            System.out.println(
                    "Legajo no encontrado.");
        }

        // Verificamos que el arreglo no esté vacío.
        if (empleados.length > 0) {

            // Inicialmente suponemos que el primero
            // tiene el mayor sueldo.
            Empleado mayorSueldo = empleados[0];

            for (int i = 1; i < empleados.length; i++) {

                if (empleados[i].sueldo > mayorSueldo.sueldo) {

                    // Debemos cambiar el objeto completo,
                    // no solamente el sueldo.
                    mayorSueldo = empleados[i];
                }
            }

            System.out.println(
                    "Empleado con mayor sueldo: "
                            + mayorSueldo.nombre);

            System.out.println(
                    "Sueldo: "
                            + mayorSueldo.sueldo);
        }
    }
}

/*
 * ¿Qué estaba mal en la solución original?
 * Error 1 — Legajo no encontrado
 * 
 * La solución original hacía:
 * 
 * if (empleados[i].legajo == legajoBuscado) {
 * System.out.println("Encontrado");
 * } else {
 * System.out.println("Legajo no encontrado.");
 * }
 * 
 * Esto está mal porque si buscamos 102:
 * 
 * Empleado 101 → no encontrado
 * Empleado 102 → encontrado
 * Empleado 103 → no encontrado
 * 
 * Entonces mostraría:
 * 
 * Legajo no encontrado.
 * Encontrado: Beto
 * Legajo no encontrado.
 * 
 * El mensaje de no encontrado debe mostrarse una sola vez, después de recorrer
 * todo el arreglo.
 * 
 * Error 2 — Mayor sueldo
 * 
 * La solución original tenía:
 * 
 * if (empleados[i].sueldo > mayorSueldo.sueldo) {
 * mayorSueldo.sueldo = empleados[i].sueldo;
 * }
 * 
 * Esto solamente cambia el sueldo del objeto.
 * 
 * Por ejemplo:
 * 
 * mayorSueldo = Ana
 * 
 * Si Beto tiene mayor sueldo, no debemos hacer:
 * 
 * mayorSueldo.sueldo = empleados[i].sueldo;
 * 
 * porque seguiríamos teniendo:
 * 
 * mayorSueldo.nombre = Ana
 * mayorSueldo.sueldo = 700
 * 
 * Eso sería incorrecto.
 * 
 * Hay que hacer:
 * 
 * mayorSueldo = empleados[i];
 * 
 * Así mayorSueldo pasa a apuntar al objeto completo de Beto.
 */