package parcialuno;
/*
 * @author Pedro José Ortiz Mendez
 * @codigo 20232217979
 */
public class ParcialUno {
    public static void main(String[] args) {
        // Capturar los datos de los jinetes en un arreglo unidimensional
        String[] jinetes = {"Ana", "Pedro", "Juan", "Cesar", "Diana", "María"};
        
        // Generar de forma aleatoria los datos de un número de carreras del torneo
        // int numCarreras = (int) (Math.random() * 20) + 1; // Número de carreras entre 1 y 20 de forma aleatoria
        int numCarreras = 5; // Número de carreras, fijado en 5 para este ejemplo de prueba
        int[][] resultados = new int[numCarreras][3]; // Arreglo para almacenar los resultados de las carreras. Cada fila representa una carrera y tiene 3 columnas: ganador, segundo y tercero
        
        // Llenar los datos de las carreras de forma aleatoria
        for (int i = 0; i < numCarreras; i++) { // Iteramos a través del número de carreras
            for (int j = 0; j < 3; j++) { // Iteramos a través de los puestos de cada carrera (ganador, segundo y tercero)
                resultados[i][j] = (int) (Math.random() * jinetes.length); // Generar códigos de jinetes aleatorios para cada posición en el arreglo de resultados
            }
        }
        
        // Calcular el tiempo ganador
        int tiempoGanador = resultados[0][0]; // Inicializamos con el tiempo del ganador de la primera carrera
        for (int i = 1; i < resultados.length; i++) { // Iteramos a través de las carreras (empezando desde la segunda)
            if (resultados[i][0] < tiempoGanador) { // Comparamos el tiempo del ganador de cada carrera con el tiempo ganador actual
                tiempoGanador = resultados[i][0]; // Actualizamos el tiempo ganador si encontramos un tiempo menor en alguna carrera posterior
            }
        }
        
        // Imprimir los resultados de las carreras y el tiempo ganador
        System.out.println("Resultados de las carreras:");
        for (int i = 0; i < numCarreras; i++) { // Iteramos a través del número de carreras
            System.out.println("Carrera " + (i + 1) + ": Ganador: " + jinetes[resultados[i][0]] + ", Segundo lugar: " + jinetes[resultados[i][1]] + ", Tercer lugar: " + jinetes[resultados[i][2]]); // Imprimir el ganador, segundo y tercer lugar de cada carrera
        }
        
        // Calcular los puntajes de los jinetes
        int[][] puntajes = new int[jinetes.length][4]; // Arreglo para almacenar los puntajes de los jinetes. Cada fila representa un jinete y tiene 4 columnas: carreras ganadas, segundos lugares, terceros lugares y puntaje total
        for (int i = 0; i < resultados.length; i++) { // Iteramos a través de las carreras
            // Ganador
            puntajes[resultados[i][0]][0]++; // Incrementamos el contador de carreras ganadas para el jinete que ganó la carrera actual
            // Segundo lugar
            puntajes[resultados[i][1]][1]++; // Incrementamos el contador de segundos lugares para el jinete que llegó en segundo lugar en la carrera actual
            // Tercer lugar
            puntajes[resultados[i][2]][2]++; // Incrementamos el contador de terceros lugares para el jinete que llegó en tercer lugar en la carrera actual
        }
        // Calcular puntajes totales
        for (int i = 0; i < puntajes.length; i++) { // Iteramos a través de los jinetes
            puntajes[i][3] = puntajes[i][0] * 5 + puntajes[i][1] * 3 + puntajes[i][2]; // Calcular el puntaje total para cada jinete según las reglas establecidas
        }
        
        // Imprimir los puntajes de los jinetes
        System.out.println("\nPuntajes de los jinetes:");
        for (int i = 0; i < puntajes.length; i++) { // Iteramos a través de los jinetes
            System.out.println("Jinete: " + jinetes[i] + ", Carreras ganadas: " + puntajes[i][0] + ", Segundos lugares: " + puntajes[i][1] + ", Terceros lugares: " + puntajes[i][2] + ", Puntuación total: " + puntajes[i][3]); // Imprimir los puntajes de cada jinete
        }
        
        // Generar el podio
        System.out.println("\nPodio:");
        String[] podio = new String[3]; // Arreglo para almacenar los nombres de los jinetes en el podio
        for (int i = 0; i < 3; i++) { // Iteramos tres veces para obtener los tres primeros lugares del podio
            int maxPuntaje = -1; // Inicializamos el máximo puntaje a -1
            int maxIndex = -1; // Inicializamos el índice del máximo puntaje a -1
            for (int j = 0; j < puntajes.length; j++) { // Iteramos a través de los jinetes
                if (puntajes[j][3] > maxPuntaje || (puntajes[j][3] == maxPuntaje && puntajes[j][0] > puntajes[maxIndex][0])) { // Comparamos los puntajes de los jinetes para encontrar el máximo puntaje y, en caso de empate, la cantidad de carreras ganadas
                    maxPuntaje = puntajes[j][3]; // Actualizamos el máximo puntaje si encontramos uno mayor
                    maxIndex = j; // Actualizamos el índice del máximo puntaje
                }
            }
            podio[i] = jinetes[maxIndex]; // Agregamos al jinete con el máximo puntaje al podio
            puntajes[maxIndex][3] = -1; // Marcar el jinete como ya procesado para evitar que se repita en el podio
        }
        for (int i = 0; i < podio.length; i++) { // Iteramos a través del podio
            System.out.println((i + 1) + "° puesto: " + podio[i]); // Imprimir el podio
        }
    }
}
