
package carta;

// Clase Prueba para probar las funcionalidades
public class Prueba {
    public static void main(String[] args) {
        Baraja baraja = new Baraja(); // Crear una nueva baraja

        // Imprimir el número de cartas en la baraja
        System.out.println("Baraja creada con " + baraja.getNumCartas() + " cartas.");

        baraja.barajar(); // Barajar las cartas
        System.out.println("Baraja barajada.");

        // Extraer una carta al azar, traducirla y mostrar su nombre
        Carta cartaAlAzar = baraja.extraerCartaAlAzar();
        System.out.println("Carta extraída al azar: " + baraja.traducir(cartaAlAzar));

        // Extraer la carta de arriba, traducirla y mostrar su nombre
        Carta cartaArriba = baraja.extraerCartaArriba();
        System.out.println("Carta extraída de arriba: " + baraja.traducir(cartaArriba));

        // Extraer una carta en la posición 5, traducirla y mostrar su nombre
        Carta cartaPosicion = baraja.extraerCarta(5);
        System.out.println("Carta extraída de la posición 5: " + baraja.traducir(cartaPosicion));

        // Crear una nueva carta (As de Oros) y agregarla a la baraja
        Carta nuevaCarta = new Carta(1, 0); // As de Oros
        boolean cartaAgregada = baraja.ponerCarta(nuevaCarta);
        if (cartaAgregada) {
            System.out.println("Carta agregada a la baraja: " + baraja.traducir(nuevaCarta));
        } else {
            System.out.println("No se pudo agregar la carta a la baraja.");
        }

        // Imprimir el número de cartas restantes en la baraja
        System.out.println("Número de cartas restantes en la baraja: " + baraja.getNumCartas());
    }
}