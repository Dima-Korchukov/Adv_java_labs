/**
 * Клас для статичної серіалізації об'єктів у формати XML та JSON для різних класів.
 * Клас містить методи для серіалізації об'єктів класів Person, Product та Order.
 */
public class StaticSerializer {

    /**
     * Серіалізує об'єкт типу Person в формат XML.
     * 
     * @param person об'єкт типу Person, який необхідно серіалізувати.
     * @return рядок у форматі XML, що представляє об'єкт Person.
     */
    public static String toXml(Person person) {
        return "<Person>\n" +
               "\t<full_name>" + person.getName() + "</full_name>\n" +
               "\t<age_years>" + person.getAge() + "</age_years>\n" +
               "</Person>";
    }

    /**
     * Серіалізує об'єкт типу Person в формат JSON.
     * 
     * @param person об'єкт типу Person, який необхідно серіалізувати.
     * @return рядок у форматі JSON, що представляє об'єкт Person.
     */
    public static String toJson(Person person) {
        return "{\n" +
               "\t\"name\": \"" + person.getName() + "\",\n" +
               "\t\"age\": \"" + person.getAge() + "\"\n" +
               "}";
    }

    /**
     * Серіалізує об'єкт типу Product в формат XML.
     * 
     * @param product об'єкт типу Product, який необхідно серіалізувати.
     * @return рядок у форматі XML, що представляє об'єкт Product.
     */
    public static String toXml(Product product) { // Додано для Product
        return "<Product>\n" +
               "\t<product_name>" + product.getName() + "</product_name>\n" +
               "\t<price_usd>" + product.getPrice() + "</price_usd>\n" +
               "</Product>";
    }

    /**
     * Серіалізує об'єкт типу Product в формат JSON.
     * 
     * @param product об'єкт типу Product, який необхідно серіалізувати.
     * @return рядок у форматі JSON, що представляє об'єкт Product.
     */
    public static String toJson(Product product) { // Додано для Product
        return "{\n" +
               "\t\"name\": \"" + product.getName() + "\",\n" +
               "\t\"price\": \"" + product.getPrice() + "\"\n" +
               "}";
    }

    /**
     * Серіалізує об'єкт типу Order в формат XML.
     * 
     * @param order об'єкт типу Order, який необхідно серіалізувати.
     * @return рядок у форматі XML, що представляє об'єкт Order.
     */
    public static String toXml(Order order) { // Додано для Order
        return "<Order>\n" +
               "\t<order_id>" + order.getId() + "</order_id>\n" +
               "\t<order_date>" + order.getDate() + "</order_date>\n" +
               "</Order>";
    }

    /**
     * Серіалізує об'єкт типу Order в формат JSON.
     * 
     * @param order об'єкт типу Order, який необхідно серіалізувати.
     * @return рядок у форматі JSON, що представляє об'єкт Order.
     */
    public static String toJson(Order order) { // Додано для Order
        return "{\n" +
               "\t\"id\": \"" + order.getId() + "\",\n" +
               "\t\"date\": \"" + order.getDate() + "\"\n" +
               "}";
    }
}
