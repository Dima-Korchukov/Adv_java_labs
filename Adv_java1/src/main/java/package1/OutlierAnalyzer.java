import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Identifies and analyzes outliers in automobile prices.
 */
public class OutlierAnalyzer {
    /**
     * Analyzes outliers based on the interquartile range (IQR).
     *
     * @param automobiles the list of automobiles to analyze
     */
    public static void analyzeOutliers(List<Automobile> automobiles) {
        List<Double> prices = automobiles.stream()
                                         .map(Automobile::getPrice)
                                         .sorted()
                                         .collect(Collectors.toList());

        int q1Index = prices.size() / 4;
        int q3Index = 3 * prices.size() / 4;
        double q1 = prices.get(q1Index);
        double q3 = prices.get(q3Index);
        double iqr = q3 - q1;
        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        Map<String, Long> result = automobiles.stream()
                .collect(Collectors.groupingBy(car -> {
                    double price = car.getPrice();
                    return (price < lowerBound || price > upperBound) ? "outliers" : "data";
                }, Collectors.counting()));

        System.out.println(result);
    }
}
