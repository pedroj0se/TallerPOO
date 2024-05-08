
package parcialdos;

public class Garaje implements iGarage {
    public static final int NUMERO_ESPACIOS = 10; // Número de espacios en el garaje
    public static final int NUMERO_ESPACIOS_CAMIONES = 3;
    private int contadorCamionesDobles; // Contador de camiones dobles en el garaje
    private Vehiculo[] espacios; // Arreglo de espacios de vehículos
    private int contadorVehiculo;

    // Constructor de la clase Garaje
    public Garaje() {
        espacios = new Vehiculo[NUMERO_ESPACIOS]; // Inicializa el arreglo de espacios
        this.contadorCamionesDobles = 0;
        this.contadorVehiculo = 0;
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
    
    public void alquilarEspacioCamion(Camion camion) {
        if (contadorCamionesDobles < NUMERO_ESPACIOS_CAMIONES && camion.getTipoCamion().equalsIgnoreCase("doble")) {
            for (int i = 0; 1 < NUMERO_ESPACIOS; i++) {
                if (espacios[i] == null) {
                    espacios[i] = camion;
                    if (camion.getTipoCamion().equalsIgnoreCase("doble")) {
                        contadorCamionesDobles++;
                    }
                    System.out.println("Camión alquilado exitosamente.");
                    return;
                }
            }
         
        }else {System.out.println("Camión no alquilado.");}
    }
    
    public void alquilarEspacioAuto(Auto auto) {
        for (int i = NUMERO_ESPACIOS_CAMIONES; 1 < NUMERO_ESPACIOS; i++) {
            if (espacios[i] == null) {
                    espacios[i] = auto;
                    System.out.println("Auto alquilado exitosamente.");
                    return;
                }
            System.out.println("No hay más espacio disponible");
        }  
    }
    
    private void ordenarPlazas() {
        for (int i = 0; i < NUMERO_ESPACIOS - 1; i++) {
            for (int j = 0; j < NUMERO_ESPACIOS - i - 1; j++) {
                if (espacios[j] != null && espacios[j + 1] != null && espacios[j].getPlaca().compareTo(espacios[j + 1].getPlaca()) > 0) {
                    Vehiculo temp = espacios[j];
                    espacios[j] = espacios[j + 1];
                    espacios[j + 1] = temp;
                }
            }
        }
    }
    
    public void listarVehiculos() {
        ordenarPlazas();
        for (Vehiculo v : espacios) {
            if (v != null) {
                String tipo = v instanceof Moto ? "Moto" : "Coche";
                System.out.println("Matricula: " + v.getPlaca() + ", Cuota mensual: " + v.getCuotaMesGaraje() + ", Tipo: " + tipo);
            }
        }
    }
    
    public Vehiculo[] getEspacios() {
        return espacios;
    }
    
    public boolean darBajaAlquiler(Vehiculo v) {
        for (int i = 0; i < NUMERO_ESPACIOS; i++) {
            if (espacios[i] != null && espacios[i].equals(v)) {
                espacios[i] = null;
                contadorCamionesDobles--;
                return true;
            }
        }
        return false;
    }
}