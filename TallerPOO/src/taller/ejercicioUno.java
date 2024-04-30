
package taller;

/*
 * @author Pedro José Ortiz Mendez
 */

import javax.swing.JOptionPane;
public class ejercicioUno {
    public static void main (String[] args) {
        double descuento, nComputadoras, totalCompra, totalCompraDesc, precioComputadora;
        nComputadoras = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor de numero de computadoras"));
        descuento = 0;
        precioComputadora = 500;
        totalCompra = nComputadoras * precioComputadora;
        
        
        if(nComputadoras < 5)
            descuento = totalCompra * 0.1;
        if(nComputadoras >= 5 && nComputadoras <10)
            descuento = totalCompra * 0.2;
        if(nComputadoras >= 10)
            descuento = totalCompra * 0.4;
        
        totalCompraDesc = totalCompra - descuento;
        
        JOptionPane.showMessageDialog(null,
        "Valor de descuento: $" + descuento + "\n" +
        "Valor de total de la compra sin descuento: $" + totalCompra + "\n" +
        "Valor de total de la compra con descuento: $" + totalCompraDesc);
          
    }
}
