
package parcialdos;
import java.util.Scanner;

public class MenuGaraje {
    private static Garaje garaje = new Garaje(); // Instancia del garaje
    private static Scanner scanner = new Scanner(System.in); // Scanner para entrada de usuario

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            procesarOpcion(opcion);
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ GARAJE ---");
        System.out.println("1. Alquilar un espacio");
        System.out.println("2. Retirar vehículo");
        System.out.println("3. Consulta de ingresos mensuales");
        System.out.println("4. Consulta proporción autos / motos");
        System.out.println("5. Listado de matrículas, cuota mensual y tipo vehículo");
        System.out.println("0. Salir");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                alquilarEspacio();
                break;
            case 2:
                retirarVehiculo();
                break;
            case 3:
                consultarIngresosMensuales();
                break;
            case 4:
                consultarProporcionAutosMotos();
                break;
            case 5:
                listarMatriculasCuotasYTipo();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void alquilarEspacio() {
        // 
        // 
    }

    private static void retirarVehiculo() {
        // 
        // 
    }

    private static void consultarIngresosMensuales() {
        System.out.println("Ingresos mensuales del garaje: $" + garaje.calcularIngresos());
    }

    private static void consultarProporcionAutosMotos() {
        int cantidadAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto("", 0, 0, false, false));
        int cantidadMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
        System.out.println("Proporción autos / motos: " + cantidadAutos + " / " + cantidadMotos);
    }

    private static void listarMatriculasCuotasYTipo() {
        // 
        // 
    }
}

