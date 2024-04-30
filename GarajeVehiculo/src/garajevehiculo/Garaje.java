package garajevehiculo;

import java.io.*;
// Clase Garaje

class Garaje implements iGarage {

    private static final int NUM_PLAZAS = 10; // Número de plazas en el garaje
    private Vehiculo[] plazas;
    private int ocupadas;

    // Constructor
    public Garaje() {
        this.plazas = new Vehiculo[NUM_PLAZAS];
        this.ocupadas = 0;
    }

    // Métodos de la interfaz
    @Override
    public double calcularIngresos() {
        double ingresos = 0;
        for (Vehiculo v : plazas) {
            if (v != null) {
                ingresos += v.getCuotaMesGarage();
            }
        }
        if (ingresos < 400) {
            throw new VamosALaQuiebraException("Estamos en quiebra!");
        }
        return ingresos;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int count = 0;
        for (Vehiculo vehiculo : plazas) {
            if (vehiculo != null && vehiculo.getClass() == v.getClass()) {
                count++;
            }
        }
        return count;
    }

    // Otros métodos
    public boolean alquilarPlaza(Vehiculo v) {
        if (ocupadas < NUM_PLAZAS && !(v.getMatricula() == null) && calcularOcupacionPorTipoVehiculo(v) < 0.8 * NUM_PLAZAS) {
            for (int i = 0; i < NUM_PLAZAS; i++) {
                if (plazas[i] == null) {
                    plazas[i] = v;
                    ocupadas++;
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean darBajaAlquiler(Vehiculo v) {
        for (int i = 0; i < NUM_PLAZAS; i++) {
            if (plazas[i] != null && plazas[i].equals(v)) {
                plazas[i] = null;
                ocupadas--;
                return true;
            }
        }
        return false;
    }

    public void listarVehiculos() {
        ordenarPlazas();
        for (Vehiculo v : plazas) {
            if (v != null) {
                String tipo = v instanceof Moto ? "Moto" : "Coche";
                System.out.println("Matricula: " + v.getMatricula() + ", Cuota mensual: " + v.getCuotaMesGarage() + ", Tipo: " + tipo);
            }
        }
    }
    
    private void ordenarPlazas() {
        for (int i = 0; i < NUM_PLAZAS - 1; i++) {
            for (int j = 0; j < NUM_PLAZAS - i - 1; j++) {
                if (plazas[j] != null && plazas[j + 1] != null && plazas[j].getMatricula().compareTo(plazas[j + 1].getMatricula()) > 0) {
                    Vehiculo temp = plazas[j];
                    plazas[j] = plazas[j + 1];
                    plazas[j + 1] = temp;
                }
            }
        }
    }
    
    public Vehiculo[] getPlazas() {
        return plazas;
    }

    public void guardarVehiculosEnFichero(String nombreFichero) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreFichero));
        out.writeObject(this);
        out.close();
    }

    // Método para recuperar vehículos de fichero (binario)
    public static Garaje recuperarVehiculosDeFichero(String nombreFichero) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreFichero));
        Garaje garaje = (Garaje) in.readObject();
        in.close();
        return garaje;
    }

}

// Excepciones personalizadas
class SinMatriculaException extends Exception {

    public SinMatriculaException(String mensaje) {
        super(mensaje);
    }
}

class CuotaNegativaException extends RuntimeException {

    public CuotaNegativaException(String mensaje) {
        super(mensaje);
    }
}

class VamosALaQuiebraException extends RuntimeException {

    public VamosALaQuiebraException(String mensaje) {
        super(mensaje);
    }
}
