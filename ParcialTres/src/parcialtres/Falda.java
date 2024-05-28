package parcialtres;

public class Falda extends Componente {
    private boolean conCremallera;

    public Falda(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean conCremallera) {
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
        return "Falda{" +
                "Cremallera=" + conCremallera +
                "} " + super.toString();
    }
}

