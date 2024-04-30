
package carta;
import java.util.Random;

// Clase Baraja que implementa la interfaz INaipes
class Baraja implements INaipes {
    private Carta[] cartas; // Array que almacena las cartas
    private int numCartas;  // Número de cartas en la baraja

    // Constructor de la clase Baraja
    public Baraja() {
        cartas = new Carta[40]; // Crear un array de 40 cartas
        numCartas = 40;         // Inicializar el número de cartas en 40
        // Rellenar la baraja con las cartas
        int index = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 1; numero <= 10; numero++) {
                cartas[index] = new Carta(numero, palo);
                index++;
            }
        }
    }

    @Override
    public String traducir(Carta unaCarta) {
        // Array para los nombres de los palos y números de las cartas
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        String[] numeros = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Sota", "Caballo", "Rey"};
        
        // Obtener el índice del palo y número de la carta
        int paloIndex = unaCarta.getPalo();
        int numeroIndex = (unaCarta.getNumero() - 1) % 10;

        // Construir y retornar el nombre de la carta
        return numeros[numeroIndex] + " de " + palos[paloIndex];
    }

    @Override
    public void barajar() {
        Random random = new Random(); // Generador de números aleatorios
        // Barajar las cartas intercambiando posiciones aleatorias
        for (int i = 0; i < numCartas; i++) {
            int index = random.nextInt(numCartas); //Genera número aleatorio entre 0 y numCartas (40)
            Carta temp = cartas[i]; // Se guarda temporalmente la carta en la posición i
            cartas[i] = cartas[index]; // Se intercambia la carta en la posición i con la carta en la posición generada aleatoriamente index
            cartas[index] = temp; // Se coloca la carta originalmente en la posición i en la posición index
        }
    }

    @Override
    public Carta extraerCartaAlAzar() {
        if (numCartas <= 0) {
            return null; // Si no hay cartas en la baraja, retorna null
        }
        Random random = new Random(); // Generador de números aleatorios
        int index = random.nextInt(numCartas); // Obtener un índice aleatorio
        Carta carta = cartas[index]; // Obtener la carta en esa posición
        cartas[index] = cartas[numCartas - 1]; // Mover la última carta al lugar de la carta extraída
        cartas[numCartas - 1] = null; // Eliminar la última carta
        numCartas--; // Decrementar el número de cartas
        return carta; // Retornar la carta extraída
    }

    @Override
    public Carta extraerCartaArriba() {
        if (numCartas <= 0) {
            return null; // Si no hay cartas en la baraja, retorna null
        }
        Carta carta = cartas[numCartas - 1]; // Obtener la carta de arriba
        cartas[numCartas - 1] = null; // Eliminar la carta de arriba
        numCartas--; // Decrementar el número de cartas
        return carta; // Retornar la carta extraída
    }

    @Override
    public Carta extraerCarta(int posicion) {
        if (posicion < 1 || posicion > numCartas) {
            return null; // Si la posición no es válida, retorna null
        }
        Carta carta = cartas[posicion - 1]; // Obtener la carta en la posición dada
        // Mover las cartas hacia la izquierda para llenar el espacio de la carta extraída
        for (int i = posicion; i < numCartas; i++) {
            cartas[i - 1] = cartas[i];
        }
        cartas[numCartas - 1] = null; // Eliminar la última carta
        numCartas--; // Decrementar el número de cartas
        return carta; // Retornar la carta extraída
    }

    @Override
    public boolean ponerCarta(Carta unaCarta) {
        if (numCartas >= 40) {
            return false; // Si la baraja está llena, retorna false
        }
        // Verificar si la carta ya existe en la baraja
        for (int i = 0; i < numCartas; i++) {
            if (cartas[i].getNumero() == unaCarta.getNumero() && cartas[i].getPalo() == unaCarta.getPalo()) {
                return false; // Si la carta ya existe, retorna false
            }
        }
        cartas[numCartas] = unaCarta; // Agregar la carta al final de la baraja
        numCartas++; // Incrementar el número de cartas
        return true; // Retornar true para indicar que la carta fue agregada
    }

    @Override
    public int getNumCartas() {
        return numCartas; // Retornar el número de cartas en la baraja
    }
}
