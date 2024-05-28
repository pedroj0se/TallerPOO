
package parcialtres;

public class Pantalon extends Componente {
    private boolean conCremallera;

    public Pantalon(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean conCremallera) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.conCremallera = conCremallera;
    }

    // Getters y setters

    public boolean isConCremallera() {
        return conCremallera;
    }

    public void setConCremallera(boolean conCremallera) {
        this.conCremallera = conCremallera;
    }

    // Método toString

    @Override
    public String toString() {
        return "Pantalon{" +
                "conCremallera=" + conCremallera +
                "} " + super.toString();
    }
}

