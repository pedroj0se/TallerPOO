
package garajevehiculo;

import java.io.IOException;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1.- Alquilar una plaza");
            System.out.println("2.- Baja de alquiler");
            System.out.println("3.- Consulta de ingresos mensuales");
            System.out.println("4.- Consulta proporción coches / motos");
            System.out.println("5.- Listado de matriculas y cuota mensual y tipo vehículo");
            System.out.println("6.- Guardar vehículos en fichero (binario)");
            System.out.println("7.- Recuperar vehículos de fichero (binario)");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Lógica para alquilar una plaza
                    System.out.println("Introduce los datos del vehículo a alquilar:");
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cilindrada: ");
                    int cilindrada = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("¿Es una moto? (si/no): ");
                    String tipoVehiculo = scanner.nextLine();
                    boolean esMoto = tipoVehiculo.equalsIgnoreCase("si");

                    if (esMoto) {
                        System.out.print("¿Tiene sidecar? (si/no): ");
                        boolean tieneSidecar = scanner.nextLine().equalsIgnoreCase("si");
                        Moto moto = new Moto(marca, precio, cilindrada, tieneSidecar);
                        if (garaje.alquilarPlaza(moto)) {
                            System.out.println("Moto alquilada correctamente.");
                        } else {
                            System.out.println("No se pudo alquilar la plaza para la moto.");
                        }
                    } else {
                        System.out.print("¿Tiene radio? (si/no): ");
                        boolean tieneRadio = scanner.nextLine().equalsIgnoreCase("si");
                        System.out.print("¿Tiene navegador? (si/no): ");
                        boolean tieneNavegador = scanner.nextLine().equalsIgnoreCase("si");
                        Coche coche = new Coche(marca, precio, cilindrada, tieneRadio, tieneNavegador);
                        if (garaje.alquilarPlaza(coche)) {
                            System.out.println("Coche alquilado correctamente.");
                        } else {
                            System.out.println("No se pudo alquilar la plaza para el coche.");
                        }
                    }
                    break;
                case 2:
                    // Lógica para dar de baja alquiler
                    System.out.println("Introduce la matrícula del vehículo a dar de baja:");
                    String matriculaBaja = scanner.nextLine();
                    // Buscar el vehículo en el garaje
                    Vehiculo vehiculoBaja = null;
                    for (Vehiculo v : garaje.getPlazas()) {
                        if (v != null && v.getMatricula().equalsIgnoreCase(matriculaBaja)) {
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
                    break;
                case 3:
                    // Lógica para consultar ingresos mensuales
                    try {
                        double ingresos = garaje.calcularIngresos();
                        System.out.println("Los ingresos mensuales del garaje son: " + ingresos + " euros.");
                    } catch (VamosALaQuiebraException e) {
                        System.out.println("¡Estamos en quiebra!");
                    }
                    break;
                case 4:
                    // Lógica para consultar proporción coches / motos
                    int numCoches = garaje.calcularOcupacionPorTipoVehiculo(new Coche("", 0, 0, false, false));
                    int numMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto("", 0, 0, false));
                    System.out.println("Proporción coches / motos: " + numCoches + " / " + numMotos);
                    break;
                case 5:
                    // Lógica para listar matriculas y cuotas mensuales y tipo vehículo
                    garaje.listarVehiculos();
                    break;
                case 6:
                    // Lógica para guardar vehículos en fichero (binario)
                    try {
                        garaje.guardarVehiculosEnFichero("vehiculos.bin");
                        System.out.println("Vehículos guardados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar los vehículos: " + e.getMessage());
                    }
                    break;
                case 7:
                    // Lógica para recuperar vehículos de fichero (binario)
                    try {
                        garaje = Garaje.recuperarVehiculosDeFichero("vehiculos.bin");
                        System.out.println("Vehículos recuperados correctamente.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error al recuperar los vehículos: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
