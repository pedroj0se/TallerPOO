package taller;
import java.util.Scanner;

public class distribuidorJuguetes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nJug = 10; 
        double[][] juguetes = new double[nJug][3];
        // VALORES MANUALES 

        for (int i = 0; i < juguetes.length; i++) {
            System.out.println("Datos juguete #" + (i + 1));
            System.out.println("Largo: ");
            // juguetes[i][0] = sc.nextDouble();
            juguetes[i][0] = ((int) (Math.random() * (10 - 1)) + 1);  //RELLENAR DE NUMERO ALEATORIO

            System.out.println("Ancho: ");
            // juguetes[i][1] = sc.nextDouble();
            juguetes[i][1] = ((int) (Math.random() * (10 - 1)) + 1);  //RELLENAR DE NUMERO ALEATORIO

            System.out.println("Alto: ");
            // juguetes[i][2] = sc.nextDouble();
            juguetes[i][2] = ((int) (Math.random() * (10 - 1)) + 1);  //RELLENAR DE NUMERO ALEATORIO
        }
        
        int nEsferas4 = 0, nEsferas6 = 0, nEsferas8 = 0, nEsferas10 = 0, nEsferasError = 0;
        System.out.printf("%-10s %-10s %-10s %-10s %n", "Largo", "Ancho", "Alto", "Diagonal");
        for ( double[] j:juguetes){
            double diag = Math.sqrt(Math.pow(j[0], 2) + Math.pow(j[1], 2) + Math.pow(j[2], 2));
            System.out.printf("%-10s %-10s %-10s %-10.1f %n", j[0], j[1], j[2], diag);
            
            if (diag <= 4 ) {
                nEsferas4++;
            } 
            else if (diag <= 6) 
                nEsferas6++;
            else if (diag <= 10)
                nEsferas10++;
            else 
                nEsferasError++;
        }

        System.out.println("N° Esfera 4: " + nEsferas4);
        System.out.println("N° Esfera 6: " + nEsferas6);
        System.out.println("N° Esfera 8: " + nEsferas8);
        System.out.println("N° Esfera 10: " + nEsferas10);
        System.out.println("N° Esfera Error: " + nEsferasError);
    }
}
