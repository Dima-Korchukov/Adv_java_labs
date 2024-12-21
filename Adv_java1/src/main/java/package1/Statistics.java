import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Calculates statistical information about automobiles.
 */
public class Statistics {
    /**
     * Prints statistics about automobile prices.
     *
     * @param automobiles the list of automobiles to analyze
     */
    public static void calculateStatistics(List<Automobile> automobiles) {
        DoubleSummaryStatistics stats = automobiles.stream()
                .collect(Collectors.summarizingDouble(Automobile::getPrice));

        double average = stats.getAverage();
        double min = stats.getMin();
        double max = stats.getMax();
        double stdDev = Math.sqrt(automobiles.stream()
                .mapToDouble(Automobile::getPrice)
                .map(price -> Math.pow(price - average, 2))
                .average()
                .orElse(0));

        System.out.printf("Min: %.2f, Max: %.2f, Average: %.2f, Std Dev: %.2f%n", min, max, average, stdDev);
    }
}
