package parcialtres;

/**
 *
 * @author Pc
 */
public class Componente implements Comparable<Componente> {
    private int id;
    private String nombre;
    private String talla;
    private String color;
    private boolean esComunitario;
    private double precio;

    public Componente(int id, String nombre, String talla, String color, boolean esComunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.esComunitario = esComunitario;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscomunitario() {
        return esComunitario;
    }

    public void setEscomunitario(boolean escomunitario) {
        this.esComunitario = escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", esComunitario=" + esComunitario +
                ", precio=" + precio +
                '}';
    }

    // Método equals
    // equals (componentes son iguales si tienen el mismo id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componente that = (Componente) o;
        return id == that.id;
    }

    // Método compareTo
// compareTo (componentes se ordenan por id)
    @Override
    public int compareTo(Componente o) {
        return Integer.compare(this.id, o.id);
    }

    
}
