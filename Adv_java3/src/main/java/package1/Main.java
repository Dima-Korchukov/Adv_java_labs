/**
 * The Main class demonstrates serialization of objects to JSON and XML formats.
 * <p>
 * It uses the {@link JsonSerializer} and {@link XmlSerializer} to serialize 
 * instances of {@link User}, {@link Product}, and {@link Order} classes.
 * The results of serialization are printed to the console.
 * </p>
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     * <p>
     * It creates instances of {@link User}, {@link Product}, and {@link Order},
     * then serializes these objects to JSON and XML formats using
     * {@link JsonSerializer#serializeToJson(Object)} and
     * {@link XmlSerializer#serializeToXml(Object)} methods, respectively.
     * </p>
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        try {
            // Create sample objects for serialization
            User user = new User(1, "Alice");
            Product product = new Product(101, "Laptop");
            Order order = new Order(1001, 299.99);

            // JSON serialization
            System.out.println("JSON Serialization:");
            System.out.println(JsonSerializer.serializeToJson(user));
            System.out.println(JsonSerializer.serializeToJson(product));
            System.out.println(JsonSerializer.serializeToJson(order));

            // XML serialization
            System.out.println("\nXML Serialization:");
            System.out.println(XmlSerializer.serializeToXml(user));
            System.out.println(XmlSerializer.serializeToXml(product));
            System.out.println(XmlSerializer.serializeToXml(order));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
