
package carta;
// Clase Carta
public class Carta {
    private int numero; // Número de la carta (1-10)
    private int palo;   // Palo de la carta (0-3)

    // Constructor de la clase Carta
    public Carta(int numero, int palo) {
        this.numero = numero;
        this.palo = palo;
    }

    // Getters y setters para número y palo
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }
}