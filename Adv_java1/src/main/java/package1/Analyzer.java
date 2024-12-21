import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Analyzes and groups automobiles based on specific criteria.
 */
public class Analyzer {
    /**
     * Filters automobiles by manufacture date range and groups them by class.
     *
     * @param automobiles the list of automobiles to analyze
     * @param minMonths   the minimum months since manufacture
     * @param maxMonths   the maximum months since manufacture
     * @return a map grouping automobiles by their class
     */
    public static Map<String, List<Automobile>> filterAndGroup(List<Automobile> automobiles, long minMonths, long maxMonths) {
        return automobiles.stream()
                .filter(car -> {
                    long months = car.getMonthsSinceManufacture();
                    return months >= minMonths && months <= maxMonths;
                })
                .collect(Collectors.groupingBy(Automobile::getCarClass));
    }
}
