import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates a stream of random Automobile objects.
 */
public class AutomobileGenerator {
    private static final String[] BRANDS = {"Toyota", "Ford", "BMW", "Audi", "Tesla"};
    private static final String[] MODELS = {"Model S", "Model X", "Corolla", "Camry", "X5"};
    private static final String[] CLASSES = {"Economy", "Business", "Luxury"};
    private static final Random RANDOM = new Random();

    /**
     * Generates an infinite stream of Automobile objects with random attributes.
     *
     * @return a stream of Automobile objects
     */
    public static Stream<Automobile> generate() {
        return Stream.generate(() -> {
            String brand = BRANDS[RANDOM.nextInt(BRANDS.length)];
            String model = MODELS[RANDOM.nextInt(MODELS.length)];
            LocalDate manufactureDate = LocalDate.now().minusMonths(RANDOM.nextInt(240));
            String carClass = CLASSES[RANDOM.nextInt(CLASSES.length)];
            double price = 100_000 + RANDOM.nextDouble() * 2_000_000;

            return new Automobile(brand, model, manufactureDate, carClass, price);
        });
    }
}
