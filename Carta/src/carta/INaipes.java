
package carta;

// Interfaz INaipes
interface INaipes {
    // Método para traducir una carta a su nombre
    public String traducir(Carta unaCarta);
    // Método para barajar las cartas
    public void barajar();
    // Método para extraer una carta al azar
    public Carta extraerCartaAlAzar();
    // Método para extraer la carta de arriba del mazo
    public Carta extraerCartaArriba();
    // Método para extraer una carta en una posición dada
    public Carta extraerCarta(int posicion);
    // Método para añadir una carta al mazo
    public boolean ponerCarta(Carta unaCarta);
    // Método para obtener el número de cartas en el mazo
    public int getNumCartas();
}