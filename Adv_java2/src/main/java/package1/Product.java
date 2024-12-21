/**
 * Клас, який представляє продукт із назвою та ціною.
 */
public class Product {
    @XmlField("product_name")
    @JsonField("name")
    private String name;

    @XmlField("price_usd")
    @JsonField("price")
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
