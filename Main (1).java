import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir la lista de términos y sus puntajes
        Map<String, Integer> phishingTerms = new HashMap<>();
        phishingTerms.put("contraseña", 3); // Muy probable
        phishingTerms.put("urgente", 2); // Probable
        // Agrega otras palabras clave y sus puntajes según la probabilidad estimada

        // Solicitar al usuario que ingrese la ruta del archivo
        System.out.println("Ingresa la ruta del archivo:");
        String filePath = scanner.nextLine();

        // Llamamos a la función para analizar el archivo y calcular la puntuación
        int phishingScore = calculatePhishingScore(filePath, phishingTerms);

        // Imprimimos la puntuación final y determinamos si es un posible intento de phishing
        System.out.println("Puntuación total de phishing: " + phishingScore);
        if (phishingScore > 0) {
            System.out.println("¡Posible intento de phishing detectado!");
        } else {
            System.out.println("No se encontraron indicios de phishing.");
        }
    }

    private static int calculatePhishingScore(String filePath, Map<String, Integer> phishingTerms) {
        int totalScore = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            // Simular la lectura del archivo ingresado por el usuario
            // En Replit, puedes leer el contenido del archivo de otras formas dependiendo del entorno
            System.out.println("Simulación: Ingresa el contenido del archivo:");
            String fileContent = scanner.nextLine();

            // Iteramos sobre cada línea del contenido del archivo
            Scanner lineScanner = new Scanner(fileContent);
            while (lineScanner.hasNextLine()) {
                String line = lineScanner.nextLine();
                // Verificamos si la línea contiene alguna palabra clave de phishing
                for (String term : phishingTerms.keySet()) {
                    if (line.toLowerCase().contains(term.toLowerCase())) {
                        // Incrementamos el total de puntos
                        totalScore += phishingTerms.get(term);

                        // Imprimimos información detallada para cada ocurrencia
                        System.out.println("Posible palabra clave de phishing encontrada: " + term +
                                ", Puntos acumulados: " + totalScore);
                    }
                }
            }
        }

        return totalScore;
    }
}
