package taller;

import java.util.Scanner;

public class ejercicioAutomotriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("\nSelecciona el tipo de carro:");
            System.out.println("1. Automóvil");
            System.out.println("2. SUV");
            System.out.println("3. Camioneta");
            System.out.println("0. Exit");

            int tipoCarro = scanner.nextInt();
            
            
            if (tipoCarro < 0 || tipoCarro > 3) {
                System.out.println("Tipo de carro inválido. Inténtalo de nuevo.");
                continue;
            } else if (tipoCarro == 0) {
                    menu = false;
                    break;
            }
        

            boolean colorMenu = true;
            int color = 0;
            while (colorMenu) {

                System.out.println("\nSelecciona el color:");
                System.out.println("1. Negro");
                System.out.println("2. Blanco");
                System.out.println("3. Rojo");

                color = scanner.nextInt();

                if (color < 1 || color > 3) {
                    System.out.println("Color inválido. Inténtalo de nuevo.");
                    continue;
                }

                colorMenu = false;
            }

            System.out.println("\n*Seleccionaste " + getCarTypeName(tipoCarro) + " de color " + getColorName(color) + ".*");
        }
    }
    

    public static String getCarTypeName(int tipoCarro) {
        switch (tipoCarro) {
            case 1:
                return "Automóvil";
            case 2:
                return "SUV";
            case 3:
                return "Camioneta";
            default:
                return "Desconocido";
        }
    }

    public static String getColorName(int color) {
        switch (color) {
            case 1:
                return "Negro";
            case 2:
                return "Blanco";
            case 3:
                return "Rojo";
            default:
                return "Desconocido";
        }
    }
}
