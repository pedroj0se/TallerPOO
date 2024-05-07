
package parcialdos;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    // Constructor de la clase Moto
    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje); // Llama al constructor de la clase padre (Vehiculo)
        this.tieneSidecar = tieneSidecar;

        // Ajusta el impuesto de circulación y la cuota mensual del garaje si tiene sidecar
        if (tieneSidecar) {
            double impuestoAdicional = super.getPrecio() * 0.1; // 10% del precio de la moto
            double cuotaAdicional = super.getCuotaMesGaraje() * 0.5; // 50% de la cuota mensual
            super.setImpuestoCirculacion(super.getImpuestoCirculacion() + impuestoAdicional);
            super.setCuotaMesGaraje(super.getCuotaMesGaraje() + cuotaAdicional);
        }
    }

    // Getters y setters específicos para Moto
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }
}
