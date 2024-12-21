import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents an automobile with various attributes such as brand, model, manufacture date, class, and price.
 */
public class Automobile {
    private String brand;
    private String model;
    private LocalDate manufactureDate;
    private String carClass;
    private double price;

    /**
     * Constructs an Automobile object.
     *
     * @param brand           the brand of the automobile
     * @param model           the model of the automobile
     * @param manufactureDate the manufacture date of the automobile
     * @param carClass        the class of the automobile
     * @param price           the price of the automobile in UAH
     */
    public Automobile(String brand, String model, LocalDate manufactureDate, String carClass, double price) {
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.carClass = carClass;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarClass() {
        return carClass;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Calculates the number of months since the automobile was manufactured.
     *
     * @return the number of months since manufacture
     */
    public long getMonthsSinceManufacture() {
        return ChronoUnit.MONTHS.between(manufactureDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Automobile{brand='%s', model='%s', manufactureDate=%s, carClass='%s', price=%.2f}",
                brand, model, manufactureDate, carClass, price);
    }
}
