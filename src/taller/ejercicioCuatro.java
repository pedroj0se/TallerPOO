
package taller;

/*
 * @author Pedro José Ortiz Mendez
 */

import javax.swing.JOptionPane;

public class ejercicioCuatro {
    public static void main(String[] args) {
        String kilosString = JOptionPane.showInputDialog("Introduce el número de kilos de manzanas comprados: ");
        double kilos = Double.parseDouble(kilosString);

        double discount = 0;
        if (kilos >= 0 && kilos <= 2.0) {
            discount = 0;
        } else if (kilos >= 2.01 && kilos <= 5.0) {
            discount = 0.10; // 10% discount
        } else if (kilos >= 5.01 && kilos <= 10.0) {
            discount = 0.15; // 15% discount
        } else {
            discount = 0.20; // 20% discount
        }

        double price = kilos * 1.5; // assuming the price of apples is $1.5 per kilo
        double priceWithDiscount = price * (1 - discount);

        JOptionPane.showMessageDialog(null, "El total es: $" + String.format("%.2f", priceWithDiscount));
    }
}
