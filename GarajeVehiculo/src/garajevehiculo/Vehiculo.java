
package garajevehiculo;
// Clase Vehiculo
class Vehiculo {
    private String matricula;
    private String marca;
    private double precio;
    private int cilindrada;
    private double impuestoCirculacion;
    private double cuotaMesGarage;
    
    // Constante para cuota mensual por defecto
    private static final double CUOTA_MES_DEFAULT = 100;

    // Constructor
    public Vehiculo(String marca, double precio, int cilindrada) {
        this.matricula = null;
        this.marca = marca;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.impuestoCirculacion = 0;
        this.cuotaMesGarage = CUOTA_MES_DEFAULT;
        calcularImpuestoCirculacion();
    }

    // Getters y setters
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    public void setImpuestoCirculacion(double impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGarage() {
        return cuotaMesGarage;
    }

    public void setCuotaMesGarage(double cuotaMesGarage) {
        if (cuotaMesGarage >= 0) {
            this.cuotaMesGarage = cuotaMesGarage;
        } else {
            throw new CuotaNegativaException("La cuota mensual no puede ser negativa");
        }
    }

    // Métodos
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = this.precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 7) {
            this.matricula = matricula;
            return true;
        } else {
            return false;
        }
    }
}
