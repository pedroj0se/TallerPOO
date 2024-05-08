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
        System.out.println("1. Alquilar un espacio para camion");
        System.out.println("2. Alquilar un espacio para auto");
        System.out.println("3. Consulta camiones en el garaje");
        System.out.println("4. Retirar vehículo");
        System.out.println("5. Consulta de ingresos mensuales");
        System.out.println("6. Consulta proporción autos / motos");
        System.out.println("7. Listado de matrículas, cuota mensual y tipo vehículo");
        System.out.println("0. Salir");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                alquilarEspacioCamion();
                break;
            case 2:
                alquilarEspacioAuto();
                break;
            case 3:
                consultarCamionGaraje();
                break;
            case 4:
                retirarVehiculo();
                break;
            case 5:
                consultarIngresosMensuales();
                break;
            case 6:
                consultarProporcionAutosMotos();
                break;
            case 7:
                listarMatriculasCuotasYTipo();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void alquilarEspacioCamion() {
        System.out.println("Ingrese la marca del camion");
        String marca = scanner.next();
        System.out.println("Ingrese el precio del camion");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese el cilindraje del camion");
        int cilindraje = scanner.nextInt();
        System.out.println("Ingrese el tipo de carrocería (Cerrada o Abierta)");
        String carrocería = scanner.next();
        System.out.println("Ingrese el tipo de camion (Doble o Sencillo)");
        String tipoCamion = scanner.next();
        System.out.println("Ingrese la capacidad de carga");
        double capacidadCarga = scanner.nextDouble();

        Camion camion = new Camion(marca, precio, cilindraje, carrocería, tipoCamion, capacidadCarga);
        garaje.alquilarEspacioCamion(camion);

    }

    private static void alquilarEspacioAuto() {
        System.out.println("Ingrese la marca del camion");
        String marca = scanner.next();
        System.out.println("Ingrese el precio del camion");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese el cilindraje del camion");
        int cilindraje = scanner.nextInt();
        System.out.println("¿Tiene radio?");
        boolean tieneRadio = scanner.nextLine().equalsIgnoreCase("si");
        System.out.println("¿Tiene navegador?");
        boolean tieneNavegador = scanner.nextLine().equalsIgnoreCase("si");

        Auto auto = new Auto(marca, precio, cilindraje, tieneRadio, tieneNavegador);
        garaje.alquilarEspacioAuto(auto);
    }

    private static void consultarCamionGaraje() {
        int camionesEnGaraje = garaje.calcularOcupacionPorTipoVehiculo(new Camion("", 0, 0, "", "", 0));
        int espaciosDisponibles = Garaje.NUMERO_ESPACIOS_CAMIONES - camionesEnGaraje;
        System.out.println("Cantidad de camiones  en el garaje: " + camionesEnGaraje);
        System.out.println("Espacios disponibles para camiones " + espaciosDisponibles);

    }

    private static void retirarVehiculo() {
        System.out.println("Introduce la matrícula del vehículo a dar de baja:");
        String matriculaBaja = scanner.nextLine();
        // Buscar el vehículo en el garaje
        Vehiculo vehiculoBaja = null;
        for (Vehiculo v : garaje.getEspacios()) {
            if (v != null && v.getPlaca().equalsIgnoreCase(matriculaBaja)) {
                vehiculoBaja = v;
                break;
            }
        }
        if (vehiculoBaja != null) {
            if (garaje.darBajaAlquiler(vehiculoBaja)) {
                System.out.println("Vehículo dado de baja correctamente.");
            } else {
                System.out.println("No se pudo dar de baja el vehículo.");
            }
        } else {
            System.out.println("No se encontró ningún vehículo con esa matrícula.");
        }
    }

    private static void consultarIngresosMensuales() {
        System.out.println("Ingresos mensuales del garaje: $" + garaje.calcularIngresos());
    }

    private static void consultarProporcionAutosMotos() {
        int cantidadAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto("", 0, 0, false, false));
        int cantidadMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
        int cantidadCamiones = garaje.calcularOcupacionPorTipoVehiculo(new Camion("", 0, 0, "", "", 0));
        System.out.println("Proporción autos / motos / camiones: " + cantidadAutos + " / " + cantidadMotos + " / " + cantidadCamiones);
    }

    private static void listarMatriculasCuotasYTipo() {
        garaje.listarVehiculos();
    }
}
