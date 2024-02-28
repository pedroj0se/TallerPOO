
package taller;

import javax.swing.JOptionPane;

/*
 * @author Pedro José Ortiz Mendez
 */

public class ejercicioDos {
        public static void main(String[] args) {
            
            double totalPagar, precioLlanta, nLlantas;
            nLlantas = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el numero de llantas que desea comprar")); // número de llantas a comprar
            

            if (nLlantas < 5) {
                precioLlanta = 100;
            } else if (nLlantas >= 5 && nLlantas <= 10) {
                precioLlanta = 75;
            } else {
                precioLlanta = 50;
            }
            totalPagar = nLlantas * precioLlanta;
            System.out.println("La cantidad de llantas que desea comprar son: " + (int) nLlantas + " llantas");
            System.out.println("El total a pagar por cada llanta es: $" + precioLlanta);
            
            System.out.println("El total a pagar por la compra de " + (int) nLlantas + " llantas" + " es: $" + totalPagar);

    }
}

