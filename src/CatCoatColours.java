import java.util.*;

class Cat {
    String color;

    public Cat(String color) {
        this.color = color;
    }
}

public class CatCoatColours {
    private static final Map<String, String> blackPhenotypes = new HashMap<>();
    private static final Map<String, String> redPhenotypes = new HashMap<>();
    private static final Map<String, String> dilutionPhenotypes = new HashMap<>();

    // Initialize the maps with the phenotypes for each genotype
    static {
        blackPhenotypes.put("BB", "Black");
        blackPhenotypes.put("Bb", "Black");
        blackPhenotypes.put("bb", "Black");

        redPhenotypes.put("D-O", "Red");
        redPhenotypes.put("ddO", "Cream");

        dilutionPhenotypes.put("D-", "");
        dilutionPhenotypes.put("dd", "-Cream");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the colors of the two cats:");
        String cat1 = scanner.nextLine();

        String cat2 = scanner.nextLine();

        Cat parent1 = new Cat(cat1);
        Cat parent2 = new Cat(cat2);

        List<Map.Entry<String, Double>> probabilities = calculateOffspringColorProbabilities(parent1, parent2);

        for (Map.Entry<String, Double> entry : probabilities) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static List<Map.Entry<String, Double>> calculateOffspringColorProbabilities(Cat parent1, Cat parent2) {
        Map<String, Double> probabilities = new HashMap<>();

        for (String black1 : Arrays.asList("BB", "Bb", "bb")) {
            for (String black2 : Arrays.asList("BB", "Bb", "bb")) {
                for (String red1 : Arrays.asList("D-O", "ddO")) {
                    for (String red2 : Arrays.asList("D-O", "ddO")) {
                        for (String dilution1 : Arrays.asList("D-", "dd")) {
                            for (String dilution2 : Arrays.asList("D-", "dd")) {
                                String offspringBlack = black1 + black2;
                                String offspringRed = red1 + red2;
                                String offspringDilution = dilution1 + dilution2;

                                String offspringPhenotype = blackPhenotypes.get(offspringBlack) + "-" +
                                        redPhenotypes.get(offspringRed) +
                                        dilutionPhenotypes.get(offspringDilution);

                                double probability = 1.0 / (3 * 2 * 2);

                                probabilities.put(offspringPhenotype, probabilities.getOrDefault(offspringPhenotype, 0.0) + probability);
                            }
                        }
                    }
                }
            }
        }

        List<Map.Entry<String, Double>> sortedProbabilities = new ArrayList<>(probabilities.entrySet());
        Collections.sort(sortedProbabilities, (a, b) -> b.getValue().compareTo(a.getValue()));

        return sortedProbabilities;
    }


}
