
package taller;
import javax.swing.JOptionPane;
/*
 * @author Pedro José Ortiz Mendez
 */
public class ejercicioTres {
    public static void main(String[] args) {

        String precioMusica = JOptionPane.showInputDialog("Introduce el precio sin IVA del reproductor de música: ");
        double precioSinIva = Double.parseDouble(precioMusica);

        String marca = JOptionPane.showInputDialog("Introduzca la marca de la reproductor de música. (NOSY u otro): ");

        double descuento = 0;
        if (precioSinIva >= 500) {
            descuento += 0.10; // 10% descuento si el precio es o mayor a $500
        }
        if (marca.equalsIgnoreCase("NOSY")) {
            descuento += 0.05; // 5% descuento si la marca es NOSY
        }

        double precioDescuento = precioSinIva * (1 - descuento); //Se calcula para obtener el precio con el descuento que tiene
        double precioConIva = precioDescuento * 1.19; // IVA es 19%

        System.out.printf("Total del pracio con IVA: $%.2f%n", precioConIva);
    }
}
