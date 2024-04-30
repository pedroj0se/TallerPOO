
package garajevehiculo;

// Clase Coche
class Coche extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    // Constructor
    public Coche(String marca, double precio, int cilindrada, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindrada);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        if (cilindrada > 2999) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.2);
        }
        if (tieneRadio) {
            this.setImpuestoCirculacion(this.getImpuestoCirculacion() * 1.01);
        }
        if (tieneNavegador) {
            this.setImpuestoCirculacion(this.getImpuestoCirculacion() * 1.02);
        }
    }
}
