
package parcialdos;

public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    // Constructor de la clase Auto
    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje); // Llama al constructor de la clase padre (Vehiculo)
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;

        // Ajusta el impuesto de circulación y la cuota mensual del garaje según las características del auto
        double impuestoAdicional = 0;
        double cuotaAdicional = 0;

        if (tieneRadio) {
            impuestoAdicional += super.getPrecio() * 0.01; // 1% del precio del auto
        }

        if (tieneNavegador) {
            impuestoAdicional += super.getPrecio() * 0.02; // 2% del precio del auto
        }

        super.setImpuestoCirculacion(super.getImpuestoCirculacion() + impuestoAdicional);

        if (cilindraje > 2499) {
            cuotaAdicional = super.getCuotaMesGaraje() * 0.2; // 20% de la cuota mensual
            super.setCuotaMesGaraje(super.getCuotaMesGaraje() + cuotaAdicional);
        }
    }

    // Getters y setters específicos para Auto
    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
    }
}

