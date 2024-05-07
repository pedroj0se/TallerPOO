
package parcialdos;

public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;
    private static final double CUOTA_MES_GARAJE = 100;

    public Vehiculo(String marca, double precio, int cilindraje) {
        this.placa = null; // Matrícula se inicia por defecto con null
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        calcularImpuestoCirculacion(); // Calcula el impuesto de circulación
        this.cuotaMesGaraje = CUOTA_MES_GARAJE; // Asigna la cuota mensual por defecto
    }
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuotaMesGaraje) {
        if (cuotaMesGaraje < 0) {
            System.out.println("La cuota mensual del garaje no puede ser negativa.");
        }
        this.cuotaMesGaraje = cuotaMesGaraje;
    }
    
    // Método para matricular el vehículo con una placa de 6 caracteres
    public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.placa = matricula;
            return true;
        } else {
            System.out.println("La matrícula debe tener 6 caracteres.");
            return false;
        }
    }
    
    // Método para calcular el impuesto de circulación (2% del precio del vehículo)
    private void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = precio * 0.02;
    }

    
    
}
