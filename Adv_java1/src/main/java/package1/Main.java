import java.util.List;
import java.util.Map;

/**
 * Main class to run the automobile data processing pipeline.
 * <p>
 * This includes:
 * <ul>
 *     <li>Generating automobile data</li>
 *     <li>Filtering and grouping by car class</li>
 *     <li>Performing statistical analysis on car prices</li>
 *     <li>Identifying and analyzing outliers</li>
 * </ul>
 */
public class Main {
    public static void main(String[] args) {
        // 1. Generate objects
        List<Automobile> automobiles = Gatherer.gather(
                AutomobileGenerator.generate(),
                10,  // Skip the first 10
                "Toyota"  // Exclude brand "Toyota"
        );

        // 2. Filter and group by class
        Map<String, List<Automobile>> groupedByClass = Analyzer.filterAndGroup(automobiles, 12, 240);

        // Print group sizes
        groupedByClass.forEach((carClass, cars) -> {
            System.out.println("Class: " + carClass + ", Count: " + cars.size());
        });

        // 3. Perform statistical analysis
        Statistics.calculateStatistics(automobiles);

        // 4. Analyze outliers
        OutlierAnalyzer.analyzeOutliers(automobiles);
    }
}
