// Programa que trabaja con una matriz de ventas de vendedores.

package tp2;

import java.util.Scanner;

/*
 * ENUNCIADO:
 *
 * Cargar una matriz de dos dimensiones con las ventas realizadas
 * por varios vendedores durante varios días.
 *
 * Las filas representan vendedores.
 * Las columnas representan días.
 *
 * El programa debe:
 *
 * a) Calcular el total vendido por cada vendedor.
 *
 * b) Calcular el promedio de ventas de cada día.
 *
 * c) Encontrar la venta máxima y mínima indicando vendedor y día.
 *
 * d) Contar vendedores que superan un monto objetivo en la totalidad
 *    de los días.
 *
 * e) Contar cuántas ventas superaron el promedio general de un día.
 *
 * f) Crear un arreglo con el promedio de ventas de cada vendedor.
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int vendedores;
        int dias;

        // Validamos la cantidad de vendedores.
        do {

            System.out.print("Ingrese cantidad de vendedores: ");
            vendedores = scanner.nextInt();

        } while (vendedores <= 0);

        // Validamos la cantidad de días.
        do {

            System.out.print("Ingrese cantidad de días: ");
            dias = scanner.nextInt();

        } while (dias <= 0);

        // Creamos la matriz.
        double[][] ventas = new double[vendedores][dias];

        // Cargamos la matriz.
        for (int i = 0; i < vendedores; i++) {

            System.out.println("\nVendedor " + i);

            for (int j = 0; j < dias; j++) {

                do {

                    System.out.print(
                            "Venta del día " + j + ": ");

                    ventas[i][j] = scanner.nextDouble();

                    if (ventas[i][j] < 0) {

                        System.out.println(
                                "La venta no puede ser negativa.");
                    }

                } while (ventas[i][j] < 0);
            }
        }

        // Punto a.
        mostrarTotalPorVendedor(ventas);

        // Punto b.
        mostrarPromedioPorDia(ventas);

        // Punto c.
        mostrarMayorYMenor(ventas);

        // Punto d.
        System.out.print(
                "\nIngrese el monto objetivo: ");

        double objetivo = scanner.nextDouble();

        int cantidadVendedores = contarVendedoresObjetivo(
                ventas,
                objetivo);

        System.out.println(
                "Cantidad de vendedores que superan el objetivo: "
                        + cantidadVendedores);

        // Punto e.
        System.out.print(
                "\nIngrese el día a consultar (0 a "
                        + (dias - 1) + "): ");

        int dia = scanner.nextInt();

        if (dia >= 0 && dia < dias) {

            double promedioDia = calcularPromedioDia(ventas, dia);

            int cantidad = contarVentasSuperiores(
                    ventas,
                    dia,
                    promedioDia);

            System.out.println(
                    "Promedio del día: "
                            + promedioDia);

            System.out.println(
                    "Cantidad de ventas superiores: "
                            + cantidad);

        } else {

            System.out.println("Día inválido.");
        }

        // Punto f.
        double[] promedios = calcularPromediosVendedores(ventas);

        System.out.println(
                "\nPromedio de cada vendedor:");

        for (int i = 0; i < promedios.length; i++) {

            System.out.println(
                    "Vendedor " + i
                            + ": " + promedios[i]);
        }

        scanner.close();
    }

    // Punto a: total de ventas por vendedor.
    public static void mostrarTotalPorVendedor(
            double[][] ventas) {

        System.out.println("\nTotal por vendedor:");

        for (int i = 0; i < ventas.length; i++) {

            double total = 0;

            for (int j = 0; j < ventas[i].length; j++) {

                total += ventas[i][j];
            }

            System.out.println(
                    "Vendedor " + i
                            + ": " + total);
        }
    }

    // Punto b: promedio de cada día.
    public static void mostrarPromedioPorDia(
            double[][] ventas) {

        System.out.println("\nPromedio por día:");

        for (int j = 0; j < ventas[0].length; j++) {

            double suma = 0;

            for (int i = 0; i < ventas.length; i++) {

                suma += ventas[i][j];
            }

            double promedio = suma / ventas.length;

            System.out.println(
                    "Día " + j
                            + ": " + promedio);
        }
    }

    // Punto c: mayor y menor venta.
    public static void mostrarMayorYMenor(
            double[][] ventas) {

        double mayor = ventas[0][0];
        double menor = ventas[0][0];

        int filaMayor = 0;
        int columnaMayor = 0;

        int filaMenor = 0;
        int columnaMenor = 0;

        for (int i = 0; i < ventas.length; i++) {

            for (int j = 0; j < ventas[i].length; j++) {

                if (ventas[i][j] > mayor) {

                    mayor = ventas[i][j];
                    filaMayor = i;
                    columnaMayor = j;
                }

                if (ventas[i][j] < menor) {

                    menor = ventas[i][j];
                    filaMenor = i;
                    columnaMenor = j;
                }
            }
        }

        System.out.println("\nMayor venta:");
        System.out.println("Monto: " + mayor);
        System.out.println("Vendedor: " + filaMayor);
        System.out.println("Día: " + columnaMayor);

        System.out.println("\nMenor venta:");
        System.out.println("Monto: " + menor);
        System.out.println("Vendedor: " + filaMenor);
        System.out.println("Día: " + columnaMenor);
    }

    // Punto d.
    public static int contarVendedoresObjetivo(
            double[][] ventas,
            double objetivo) {

        int contador = 0;

        for (int i = 0; i < ventas.length; i++) {

            boolean supera = true;

            for (int j = 0; j < ventas[i].length; j++) {

                if (ventas[i][j] <= objetivo) {

                    supera = false;
                }
            }

            if (supera) {
                contador++;
            }
        }

        return contador;
    }

    // Calcula el promedio de un día específico.
    public static double calcularPromedioDia(
            double[][] ventas,
            int dia) {

        double suma = 0;

        for (int i = 0; i < ventas.length; i++) {

            suma += ventas[i][dia];
        }

        return suma / ventas.length;
    }

    // Cuenta ventas superiores al promedio del día.
    public static int contarVentasSuperiores(
            double[][] ventas,
            int dia,
            double promedio) {

        int contador = 0;

        for (int i = 0; i < ventas.length; i++) {

            if (ventas[i][dia] > promedio) {

                contador++;
            }
        }

        return contador;
    }

    // Punto f: promedio de cada vendedor.
    public static double[] calcularPromediosVendedores(
            double[][] ventas) {

        double[] promedios = new double[ventas.length];

        for (int i = 0; i < ventas.length; i++) {

            double suma = 0;

            for (int j = 0; j < ventas[i].length; j++) {

                suma += ventas[i][j];
            }

            promedios[i] = suma / ventas[i].length;
        }

        return promedios;
    }
}

/*
 * c) Encontrar y mostrar la venta de mayor monto y la de menor monto de toda la
 * matriz, indicando qué
 * vendedor y en qué día se produjo (índices de fila y columna).
 * Con:
 * 
 * 100 200
 * 300 400
 * 
 * y día 2, que corresponde a la columna 1:
 * 
 * 200
 * 400
 * 
 * El promedio es:
 * 
 * (200 + 400) / 2 = 300
 * 
 * Las ventas que superan el promedio son:
 * 
 * 400
 * 
 * Por lo tanto:
 * 
 * Promedio = 300
 * Cantidad que lo supera = 1
 */