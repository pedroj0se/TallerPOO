
package parcialdos;

public class Garaje implements iGarage {
    private static final int NUMERO_ESPACIOS = 10; // Número de espacios en el garaje
    private Vehiculo[] espacios; // Arreglo de espacios de vehículos

    // Constructor de la clase Garaje
    public Garaje() {
        espacios = new Vehiculo[NUMERO_ESPACIOS]; // Inicializa el arreglo de espacios
    }

    // Implementación del método calcularIngresos() de la interfaz iGarage
    @Override
    public double calcularIngresos() {
        double ingresosTotales = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                ingresosTotales += vehiculo.getImpuestoCirculacion() + vehiculo.getCuotaMesGaraje();
            }
        }
        return ingresosTotales;
    }

    // Implementación del método calcularOcupacionPorTipoVehiculo() de la interfaz iGarage
    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (Vehiculo vehiculo : espacios) {
            //if (vehiculo != null && vehiculo.getClass().equals(v.getClass())) {
            if (vehiculo != null) {
                contador++;
            }
        }
        return contador;
    }

    // Otros métodos para gestionar el garaje, como agregar vehículo, etc.
}