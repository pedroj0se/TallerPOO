
package cajaregistradora;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        CajaRegistradora caja = new CajaRegistradora("Mi Caja");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ingresar monedas");
            System.out.println("2. Listar Contenido");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Extraer monedas");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese tipo de moneda: ");
                    double tipoIngreso = scanner.nextDouble();
                    System.out.print("Ingrese cantidad de unidades: ");
                    int unidadesIngreso = scanner.nextInt();
                    if (caja.meterMonedas(tipoIngreso, unidadesIngreso)) {
                        System.out.println("Monedas ingresadas correctamente.");
                    } else {
                        System.out.println("No se pudieron ingresar las monedas.");
                    }
                    break;
                case 2:
                    System.out.println("Contenido de la caja:");
                    for (double tipo : caja.getTiposDeMonedas()) {
                        System.out.println("Tipo: " + tipo + ", Unidades: " + caja.getUnidadesTipoMoneda(tipo));
                    }
                    break;
                case 3:
                    System.out.println("Saldo actual: " + caja.getSaldo());
                    break;
                case 4:
                    System.out.print("Ingrese tipo de moneda a extraer: ");
                    double tipoExtraccion = scanner.nextDouble();
                    System.out.print("Ingrese cantidad de unidades a extraer: ");
                    int unidadesExtraccion = scanner.nextInt();
                    if (caja.sacarMonedas(tipoExtraccion, unidadesExtraccion)) {
                        System.out.println("Monedas extraídas correctamente.");
                    } else {
                        System.out.println("No se pudieron extraer las monedas.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}

