
package garajevehiculo;

// Clase Moto
class Moto extends Vehiculo {
    public boolean tieneSidecar;

    // Constructor
    public Moto(String marca, double precio, int cilindrada, boolean tieneSidecar) {
        super(marca, precio, cilindrada);
        this.tieneSidecar = tieneSidecar;
        if (tieneSidecar) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.5);
            this.setImpuestoCirculacion(this.getImpuestoCirculacion() * 1.1);
        }
    }
}