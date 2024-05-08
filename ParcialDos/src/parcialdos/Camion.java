
package parcialdos;

public class Camion extends Vehiculo {
    private String carrocería;
    private String tipoCamion;
    private double capacidadCarga;

    // Constructor de la clase Moto
    public Camion(String marca, double precio, int cilindraje, String carrocería , String tipoCamion, double capacidadCarga) {
        super(marca, precio, cilindraje); // Llama al constructor de la clase padre (Vehiculo)
        this.carrocería = carrocería;
        this.tipoCamion = tipoCamion;
        this.capacidadCarga = capacidadCarga;  
        calcularImpuestoCirculacion();
        calcularCuotaMesGaraje();
    }
 

    public void calcularImpuestoCirculacion() {
        double impuesto = getPrecio() * 0.09;
        impuesto += (capacidadCarga / 5) * 10;
        setImpuestoCirculacion(impuesto);
    }
    
    public void calcularCuotaMesGaraje() {
        double cuotaBase = getCuotaMesGaraje();
        if (tipoCamion.equalsIgnoreCase("sencillo")) {
            cuotaBase *= 1.75;
        } else if (tipoCamion.equalsIgnoreCase("doble")) {
            cuotaBase *= 2.25;
        }
        
        setCuotaMesGaraje(cuotaBase);
    }

    public String getCarrocería() {
        return carrocería;
    }

    public void setCarrocería(String carrocería) {
        this.carrocería = carrocería;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    
}
