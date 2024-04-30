package taller;
import java.util.Scanner;

public class tiendaIceCream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cantidad = new int[5]; // Matriz para almacenar cantidades de cada sabor.
        String[] paleta = {"Limón", "Nuez", "Lulo", "Fresa", "Crema"}; // Variedad de sabores
        double[] precio = {2500, 2800, 2600, 2000, 3000}; // Variedad de precios para cada sabor.
        double totalVenta = 0; // Variable para almacenar las ventas totales
        int totalPaletas = 0; // Variable para almacenar el total de paletas heladas vendidas

        while (true) {
            System.out.println("\nIngrese la cantidad de paletas vendidas por cada sabor:");
            for (int i = 0; i < paleta.length; i++) {
                System.out.printf("%d. %s: ", i + 1, paleta[i]);
                cantidad[i] += scanner.nextInt();
            }

            System.out.println("Desea continuar? (s/n)");
            if (scanner.next().toLowerCase().charAt(0) != 's') {
                break;
            }
        }

        System.out.println("\nReporte de ventas:");
        System.out.printf("%-10s %-10s %-10s %n", "Sabor", "Cantidad", "Valor");
        System.out.printf("----------------------------- %n");
        for (int i = 0; i < paleta.length; i++) {
            double ventaPaleta = cantidad[i] * precio[i];
            System.out.printf("%-10s %-10d $%-10.1f %n", paleta[i], cantidad[i], ventaPaleta);
            totalVenta += ventaPaleta;
            totalPaletas += cantidad[i];
            
        }

        System.out.printf("----------------------------- %n");
        System.out.printf("%-10s %-10s $%-10.1f %n", "Total", totalPaletas, totalVenta);
    }
}