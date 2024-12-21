import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Filters and collects a list of Automobile objects from a stream.
 */
public class Gatherer {
    /**
     * Collects a filtered and limited list of automobiles.
     *
     * @param stream       the stream of automobiles
     * @param n            the number of elements to skip
     * @param excludeBrand the brand to exclude
     * @return a list of 500 automobiles
     */
    public static List<Automobile> gather(Stream<Automobile> stream, int n, String excludeBrand) {
        return stream.filter(car -> !car.getBrand().equalsIgnoreCase(excludeBrand))
                     .skip(n)
                     .limit(500)
                     .collect(Collectors.toList());
    }
}
