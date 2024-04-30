package taller;
import java.util.Scanner;

public class clinicaMaternidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de recién nacidos:");
        int cantidadBebes = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        // String[] nombres = new String[cantidadBebes];
        // char[] generos = new char[cantidadBebes];

        //En la primera columna se guarda el nombre del BB y el segunda el sexo
        String[][] bebes = new String[cantidadBebes][2];

        for (int i = 0; i < cantidadBebes; i++) {
            System.out.println("\nIngrese el nombre del recién nacido #" + (i + 1) + ":");
            bebes[i][0] = scanner.nextLine(); // Limpiar
            String genero;
            do {
                System.out.println("Ingrese el sexo (Utilice 'M' para hombre y 'F' para mujer.) del recién nacido #" + (i + 1) + ":");
                genero = scanner.nextLine(); // Limpiar

                if (genero.equalsIgnoreCase("M")) {
                    bebes[i][1] = "M";
                } else if (genero.equalsIgnoreCase("F")) {
                    bebes[i][1] = "F";
                } else {
                    System.out.println("Genero invalido. Utilice 'M' para hombre y 'F' para mujer.");
                }
            } while (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F"));
            System.out.println("\nBebe # "+ ( i + 1 ) + " Nombre: " + bebes[i][0] + " Sexo: " + bebes[i][1]);
        }

        int cantidadMasculino = 0, cantidadFemenino = 0;

        for (String[] b:bebes) {
            if (b[1].equalsIgnoreCase("M"))
                cantidadMasculino++;
            else
                cantidadFemenino++;
        }

        // Imprimir resultados
        System.out.println("\nResumen de nacimientos:");
        
        System.out.println("Total de bebés: " + cantidadBebes);
        System.out.println("Bebés masculinos: " + cantidadMasculino);
        System.out.println("Bebés femeninos: " + cantidadFemenino);

        scanner.close();
    }

}