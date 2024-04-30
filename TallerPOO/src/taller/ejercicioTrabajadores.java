// Elabore un algoritmo que lea los siguientes datos de N trabajadores: Clave, Categoría, Sueldo,
// Años de antigüedad, Sexo. Calcule lo siguiente:
// a) Sueldo promedio por cada categoría.
// b) Cuántos empleados ganan más de $ 10,000.
// c) Cuántos empleados tienen más de 15 años de antigüedad.
// d) Cuántas mujeres de categoría A ganan más de $ 8,500.
// e) Cuántos empleados con 10 o más años de antigüedad, ganan menos de $ 6,000.
// f) Cuántos empleados de categoría C ganan más de $ 12,500.
// Existen 3 categorías: A, B y C



package taller;
import java.util.Scanner;
public class ejercicioTrabajadores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de empleados:");
        int nEmpleados = scanner.nextInt();
        scanner.nextLine();

        double[] sueldo = new double[nEmpleados];
        String[][] empCagSex = new String[nEmpleados][2];
        // int[][] empClaveAnti = new int[nEmpleados][2];

        for (int i = 0; i < nEmpleados; i++) {
            System.out.println("\nIngrese el sueldo del empleado: " + (i+1));
            sueldo[i] = scanner.nextInt();
            scanner.nextLine();

            String categoria;
            do {
                System.out.println("\nIngrese la categoria del empleado: " + (i+1));
                categoria = scanner.nextLine();
                
                if (categoria.equalsIgnoreCase("A")) {
                    empCagSex[i][0] = "A";
                } else if (categoria.equalsIgnoreCase("B")) {
                    empCagSex[i][0] = "B";
                } else if (categoria.equalsIgnoreCase("C")) {
                    empCagSex[i][0] = "C";
                } else 
                    System.out.println("ERROR");


            } while (!categoria.equalsIgnoreCase("A") && !categoria.equalsIgnoreCase("B") && !categoria.equalsIgnoreCase("C"));


            // String categoria = "";
            // while (!categoria.equalsIgnoreCase("A") && !categoria.equalsIgnoreCase("B")) {             
                // System.out.println("\nIngrese la categoria del empleado: " + (i+1));
                // String categoria = scanner.nextLine();

                // if (categoria.equalsIgnoreCase("A")) {
                //     empCagSex[i][0] = "A";
                // } else if (categoria.equalsIgnoreCase("B")) {
                //     empCagSex[i][0] = "B";
                // } else if (categoria.equalsIgnoreCase("C")) {
                //     empCagSex[i][0] = "C";
                // } else 
                //     System.out.println("ERROR");
            // }
            // empCagSex[i][0] = categoria;

            System.out.println("\nIngrese el sexo del empleado: " + (i+1));
            // empCagSex[i][1] = scanner.nextLine();
            String genero = scanner.nextLine(); // Limpiar

            if (genero.equalsIgnoreCase("M")) {
                empCagSex[i][1] = "M";
            } else if (genero.equalsIgnoreCase("F")) {
                empCagSex[i][1] = "F";
            } else {
                System.out.println("Genero invalido. Utilice 'M' para hombre y 'F' para mujer.");
            }


            // System.out.println("\nIngrese la clave del empleado: " + (i+1));
            // empClaveAnti[i][0] = scanner.nextInt();
            // System.out.println("\nIngrese el antiguedad del empleado: " + (i+1));
            // empClaveAnti[i][1] = scanner.nextInt();
        }

        int nCatA = 0, nCatB = 0, nCatC = 0;
        double acumSueldoCatA = 0, acumSueldoCatB = 0, acumSueldoCatC = 0, promA = 0, promB = 0, promC = 0;
        for (int i = 0; i < nEmpleados; i++){
            
            if (empCagSex[i][0].equalsIgnoreCase("A")) {
                nCatA++;
                acumSueldoCatA = acumSueldoCatA + sueldo[i];
            } else if (empCagSex[i][0].equalsIgnoreCase("B")) {
                nCatB++;
                acumSueldoCatB = acumSueldoCatB + sueldo[i];
            } else if (empCagSex[i][0].equalsIgnoreCase("C")) {
                nCatC++;
                acumSueldoCatC = acumSueldoCatC + sueldo[i];
            }

            promA = acumSueldoCatA / nCatA;
            promB = acumSueldoCatB / nCatB;
            promC = acumSueldoCatC / nCatC;
        }

        System.out.println("Promedio Categoría A: " + promA);
        System.out.println("Promedio Categoría A: " + promB);
        System.out.println("Promedio Categoría A: " + promC);
            


    }
}
