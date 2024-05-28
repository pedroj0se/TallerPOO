
package parcialtres;

public class Chaqueta extends Componente {
    private int numBotones;

    public Chaqueta(int id, String nombre, String talla, String color, boolean esComunitario, double precio, int numBotones) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.numBotones = numBotones;
    }

    // Getters y setters

    public int getNumBotones() {
        return numBotones;
    }

    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }

    // Método toString

    @Override
    public String toString() {
        return "Chaqueta{" +
                "Botones=" + numBotones +
                "} " + super.toString();
    }
}

