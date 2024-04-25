import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CatColorGenetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input colors of the female and male cat
        String femaleColor = scanner.nextLine().trim();
        String maleColor = scanner.nextLine().trim();

        // Computing offspring colors
        Map<String, Double> offspringColors = computeOffspringColors(femaleColor, maleColor);

        // Outputting results
        for (Map.Entry<String, Double> entry : offspringColors.entrySet()) {
            System.out.printf("%s %.9f%n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }

    public static Map<String, Double> computeOffspringColors(String femaleColor, String maleColor) {
        Map<String, Double> offspringColors = new HashMap<>();

        // For each possible combination of genes, compute the probability
        for (String femaleGene : getGeneCombinations(femaleColor)) {
            for (String maleGene : getGeneCombinations(maleColor)) {
                String offspringColor = computeColorFromGenes(femaleGene, maleGene);
                double probability = computeProbability(femaleGene, maleGene);
                offspringColors.put(offspringColor, offspringColors.getOrDefault(offspringColor, 0.0) + probability);
            }
        }

        return offspringColors;
    }

    public static String computeColorFromGenes(String femaleGene, String maleGene) {
        // Extracting genes
        String femaleRedGene = femaleGene.substring(2, 3);
        String maleRedGene = maleGene.substring(2, 3);

        // Computing offspring color based on red gene
        if (femaleRedGene.equals("O") || maleRedGene.equals("O")) {
            return "D-O";
        } else {
            return "ddO";
        }
    }

    public static double computeProbability(String femaleGene, String maleGene) {
        // For simplicity, assume equal probability for each gene combination
        return 0.25; // 1/4 probability for each combination
    }

    public static String[] getGeneCombinations(String color) {
        // Extracting possible gene combinations from color
        String[] geneCombinations = new String[4];
        String blackGene = color.substring(0, 2);
        String dilutionGene = color.substring(2, 3);
        String redGene = color.substring(3);

        geneCombinations[0] = blackGene + dilutionGene + redGene;
        geneCombinations[1] = blackGene.toLowerCase() + dilutionGene + redGene;
        geneCombinations[2] = blackGene + dilutionGene.toLowerCase() + redGene;
        geneCombinations[3] = blackGene.toLowerCase() + dilutionGene.toLowerCase() + redGene;

        return geneCombinations;
    }
}
